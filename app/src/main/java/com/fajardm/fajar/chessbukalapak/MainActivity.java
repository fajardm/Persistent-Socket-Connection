package com.fajardm.fajar.chessbukalapak;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Server server;
    private Board board;
    private ImageView[][] imageView = new ImageView[8][8];
    private String history;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();

        // connect to the server
        new connectTask().execute("");
    }

    //Initialization component
    private void initComponents() {
        board = new Board();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                imageView[i][j] = (ImageView) findViewById(board.getImageViewId()[i][j]);
            }
        }
    }

    //set potition of pawn
    //clear false to clear image pawn
    private void setPotitionPawn(String value, boolean clear) {
        if (value != null) {
            String[] pos = value.split("\\s+");
            for (int i = 0; i < pos.length; i++) {
                String pawn = String.valueOf(pos[i].charAt(0));
                int row = Character.getNumericValue(pos[i].charAt(2)) - 1;
                int col = Character.getNumericValue(pos[i].charAt(1)) - 10;
                if (clear) {
                    imageView[row][col].setImageResource(0);
                } else {
                    imageView[row][col].setImageResource(board.getMapPawn().get(pawn));
                }
            }
        }
    }

    //Asynctask for server
    public class connectTask extends AsyncTask<String, String, Server> {
        @Override
        protected Server doInBackground(String... message) {
            server = new Server(new Server.OnMessageReceived() {
                @Override
                //here the messageReceived method is implemented
                public void messageReceived(String message) {
                    //this method calls the onProgressUpdate
                    publishProgress(message);
                }
            });
            server.run();
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            setPotitionPawn(history, true);
            setPotitionPawn(values[0], false);
            history = values[0];
        }
    }
}

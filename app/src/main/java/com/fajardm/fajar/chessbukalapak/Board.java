package com.fajardm.fajar.chessbukalapak;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fajar on 23/04/2016.
 */
public class Board {
    private Map<String, Integer> mapPawn = new HashMap<String, Integer>();

    //set id piece board
    private int imageViewId[][] = new int[][]{
            {R.id.row1colA, R.id.row1colB, R.id.row1colC, R.id.row1colD, R.id.row1colE, R.id.row1colF, R.id.row1colG, R.id.row1colH},
            {R.id.row2colA, R.id.row2colB, R.id.row2colC, R.id.row2colD, R.id.row2colE, R.id.row2colF, R.id.row2colG, R.id.row2colH},
            {R.id.row3colA, R.id.row3colB, R.id.row3colC, R.id.row3colD, R.id.row3colE, R.id.row3colF, R.id.row3colG, R.id.row3colH},
            {R.id.row4colA, R.id.row4colB, R.id.row4colC, R.id.row4colD, R.id.row4colE, R.id.row4colF, R.id.row4colG, R.id.row4colH},
            {R.id.row5colA, R.id.row5colB, R.id.row5colC, R.id.row5colD, R.id.row5colE, R.id.row5colF, R.id.row5colG, R.id.row5colH},
            {R.id.row6colA, R.id.row6colB, R.id.row6colC, R.id.row6colD, R.id.row6colE, R.id.row6colF, R.id.row6colG, R.id.row6colH},
            {R.id.row7colA, R.id.row7colB, R.id.row7colC, R.id.row7colD, R.id.row7colE, R.id.row7colF, R.id.row7colG, R.id.row7colH},
            {R.id.row8colA, R.id.row8colB, R.id.row8colC, R.id.row8colD, R.id.row8colE, R.id.row8colF, R.id.row8colG, R.id.row8colH},
    };

    public Board() {
        setMapPawn();
    }

    //Set pawn in map
    public void setMapPawn() {
        mapPawn.put("K", R.mipmap.white_king);
        mapPawn.put("Q", R.mipmap.white_queen);
        mapPawn.put("B", R.mipmap.white_bishop);
        mapPawn.put("N", R.mipmap.white_knight);
        mapPawn.put("R", R.mipmap.white_rook);
        mapPawn.put("k", R.mipmap.black_king);
        mapPawn.put("q", R.mipmap.black_queen);
        mapPawn.put("b", R.mipmap.black_bishop);
        mapPawn.put("n", R.mipmap.black_knight);
        mapPawn.put("r", R.mipmap.black_rook);
    }

    public Map<String, Integer> getMapPawn() {
        return mapPawn;
    }

    public int[][] getImageViewId() {
        return imageViewId;
    }
}

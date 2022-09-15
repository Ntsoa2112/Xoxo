package com.example.xoxo.morpion;

import android.content.Intent;

import com.example.xoxo.MainActivity;
import com.example.xoxo.WelcomeActivity;
import com.example.xoxo.WinActivity;

public class MatriceData {
    private int dimension;
    private Integer[][] listData;
    // private  Integer[][] winningCombinations;

    public MatriceData(int dimension){
        this.dimension = dimension;
        this.listData = new Integer[dimension][dimension];
    }

    public boolean checkWinner()
    {
        for (int i = 0; i < dimension; i++){

            int winner =  verify(i) ;
            if (winner != -1) {
            /*
                ATO DOLY NY ACTION atao satria kobo hoe naresy izy
             */
                // REDIRECTION VERS WIN
                //Intent intent = new Intent(MainActivity.this, WinActivity.class);
                //startActivity(intent);
                System.out.println("NARESY IZY EEE: " + String.valueOf(winner ));
                return true;
            }
        }

        return false;
    }


    public void setData(int col, int line, int val){
        listData[col][line] = val;
    }

    public Integer getElementInData(int col, int line){
        return listData[col][line];
    }

    private int verify(int i){
        int byCol = verifyByCol(i);
        if (byCol != -1) return byCol;

        int byLine = verifyByLine(i);
        if (byLine != -1) return byLine;

        int byDiagonal0 = verifyByDiagonal0();
        if (byDiagonal0 != -1) return byDiagonal0;

        int byDiagonal1 = verifyByDiagonal1();
        if (byDiagonal1 != -1) return byDiagonal1;

        return -1;
    }

    private int verifyByCol(int col){
        String res = "";

        for (int line=0; line<this.dimension;line++) {
            if ( getElementInData(col,line) == null ) break;
            res += getElementInData(col,line).toString();
        }
        return countOccurrence(res,0) == this.dimension ? Character.getNumericValue(res.charAt(0)) : -1 ;
    }

    private int verifyByLine(int line){
        String res = "";

        for (int col=0; col<this.dimension;col++) {
            if ( getElementInData(col,line) == null ) break;
            res += getElementInData(col,line).toString();
        }
        return countOccurrence(res,0) == this.dimension ? Character.getNumericValue(res.charAt(0)) : -1 ;
    }

    private int verifyByDiagonal0(){
        String res = "";

        for (int dim=0; dim<this.dimension;dim++) {
            if ( getElementInData(dim,dim) == null ) break;
            res += getElementInData(dim,dim).toString();
        }
        return countOccurrence(res,0) == this.dimension ? Character.getNumericValue(res.charAt(0)) : -1 ;
    }

    private int verifyByDiagonal1(){
        String res = "";

        for (int dim=0; dim<this.dimension;dim++) {
            int line =  (dim - (this.dimension - 1) ) * -1 ;
            if ( getElementInData(dim,line) == null ) break;
            res += getElementInData(dim,line).toString();
        }
        return countOccurrence(res,0) == this.dimension ? Character.getNumericValue(res.charAt(0)) : -1 ;
    }



    private int countOccurrence(String someString, int index) {
        if (index >= someString.length()) {
            return 0;
        }

        char searchedChar = someString.charAt(0);

        int count = someString.charAt(index) == searchedChar ? 1 : 0;
        return count + countOccurrence(
                someString, index + 1);
    }

}

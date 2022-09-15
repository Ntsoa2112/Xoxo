package com.example.xoxo.morpion;

public class GameInfo {
    private int match = 3;
    private int scorej1 = 0;
    private int scorej2 = 0;

    public GameInfo(int match){ this.match = match; }

    public int winner(int j){
        if(j == 0){
            scorej1++;
        }else{
            scorej2++;
        }
        match--;
        return match;
    }

    public int getScorej1() { return this.scorej1; }

    public int getScorej2() { return this.scorej2; }

}

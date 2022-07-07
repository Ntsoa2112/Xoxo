package com.example.xoxo.morpion;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Square {
    private int left, right, bottom, top;
    private Paint paint;
    private Canvas canvas;
    private boolean activate = false;
    private String type = null;

    public Square(int left, int right, int bottom, int top, Paint paint, Canvas canvas) {
        this.left = left;
        this.right = right;
        this.bottom = bottom;
        this.top = top;
        this.paint = paint;
        this.canvas = canvas;

        this.canvas.drawRect(left, top, right, bottom, paint);

    }

    private void drawX(){
        System.out.println('X');
    }

    private void drawO(){
        System.out.println('O');
    }

    public void drawing(String type){
        if(type.equals('X')){
            this.drawX();
            this.type = type;
        }
    }

    public boolean verifyTouch(int x, int y){
        if (x > this.left && x < this.right && y > this.top && y < this.bottom) return true;
        return false;
    }
}

package com.example.xoxo.morpion;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.MotionEvent;
import android.content.Intent;

import com.example.xoxo.MainActivity;
import com.example.xoxo.WinActivity;

import androidx.annotation.Nullable;

public class MatriceView extends View {

    private final int dim = 3;
    private MatriceData dataMatrice;
    private boolean ia  = false;

    public MatriceView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        dataMatrice = new MatriceData(dim);
    }

    public MatriceView(Context context) {
        super(context);

    }


    @Override
    protected void onDraw(Canvas canvas) {
        int margin_x = (int) 0.2 * getLayoutParams().width;
        int margin_y = (int) (0.2 * getLayoutParams().height);
        super.onDraw(canvas);
        Paint square = new Paint();
        square.setStyle(Paint.Style.STROKE);
        square.setColor(Color.BLACK);
        int width = getLayoutParams().width - margin_x;
        int abs = (int) width / (dim);

        // FANTARINA HOE TAPITRA NY LALAO
        // REHEFA TSS CASE LIBRE TSONY
        boolean tapitra = true;

        for (int x = 0; x < dim; x++) {
            for (int y = 0; y < dim; y++) {
                canvas.drawRect(
                        x * abs + margin_x / 2,
                        y * abs + margin_y / 2,
                        (x * abs) + abs + margin_x / 2,
                        (y * abs) + abs + margin_y / 2,
                        square
                );

                int re_dim = 40;

                if ( dataMatrice.getElementInData(x, y) != null ) {
                     if (dataMatrice.getElementInData(x, y) == 0) {
                         canvas.drawOval(
                                 (x * abs + margin_x / 2) + re_dim,
                                 (y * abs + margin_y / 2) +re_dim,
                                 ((x * abs) + abs + margin_x / 2) - re_dim,
                                 ((y * abs) + abs + margin_y / 2) - re_dim,
                                 square
                         );
                    } else if (dataMatrice.getElementInData(x, y) == 1) {
                        canvas.drawRect(
                                (x * abs + margin_x / 2) + re_dim,
                                (y * abs + margin_y / 2) +re_dim,
                                ((x * abs) + abs + margin_x / 2) - re_dim,
                                ((y * abs) + abs + margin_y / 2) -re_dim,
                                square
                        );
                    }
                }
                else
                    tapitra = false;
            }
        }

        boolean aona_aa = dataMatrice.checkWinner();

        if (!aona_aa && tapitra){
            System.out.println("TAPITRA AAA, MATCH NUL");
        }
        // REDIRECTION VERS WIN
        else if(aona_aa){
            if(MatriceData.getWinner() == 0){
                MainActivity.j1.win();
            }else{
                MainActivity.j2.win();
            }
            Intent intent = new Intent(MainActivity.mainA, WinActivity.class);
            MainActivity.mainA.startActivity(intent);

        }


        // stroke
        /*
        strokePaint.setStyle(Paint.Style.STROKE);
        strokePaint.setColor(Color.BLACK);
        strokePaint.setStrokeWidth(10);
        */
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int margin_x = (int) 0.2 * getLayoutParams().width;
        int margin_y = (int) (0.2 * getLayoutParams().height);

        if (event.getAction() == MotionEvent.ACTION_UP) {

            int width = getLayoutParams().width - margin_x;
            int height = getLayoutParams().height - margin_y;

            int abs = (int) (width / dim);
            int ord = (int) (height / dim) ;

            int touchX = (int) event.getX() ;
            int touchY = (int) event.getY() ;

            int col = (int) ( touchX / abs) ;
            col = Math.abs(col) ;

            int line = (int) ( touchY / ord );
            line = Math.abs(line);

            if (col < dim && line < dim ) {
                if (dataMatrice.getElementInData(col, line) == null){
                    dataMatrice.setData(col, line, ia ? 1 : 0);
                    ia = !ia;
                    invalidate();
                }

            }

        }
        return true;
    }

}

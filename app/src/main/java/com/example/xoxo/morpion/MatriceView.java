package com.example.xoxo.morpion;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.MotionEvent;

import androidx.annotation.Nullable;

public class MatriceView extends View {

    private final int dim = 4;
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
        int marginx = 20; // (int) 0.2 * getLayoutParams().width;
        int marginy = (int) (0.2 * getLayoutParams().height);
        super.onDraw(canvas);
        Paint carre = new Paint();
        carre.setStyle(Paint.Style.STROKE);
        carre.setColor(Color.BLACK);
        int width = getLayoutParams().width - marginx;
        int abscisse = (int) width / (dim);

        for (int x = 0; x < dim; x++) {
            for (int y = 0; y < dim; y++) {
                //dataMatrice.setData(x, y, null)
                canvas.drawRect(
                        x * abscisse + marginx / 2,
                        y * abscisse + marginy / 2,
                        (x * abscisse) + abscisse + marginx / 2,
                        (y * abscisse) + abscisse + marginy / 2,
                        carre
                );

                int redim = 40;

                if ( dataMatrice.getElementInData(x, y) != null ) {
                     if (dataMatrice.getElementInData(x, y) == 0) {
                         canvas.drawOval(
                                 (x * abscisse + marginx / 2) + redim,
                                 (y * abscisse + marginy / 2) +redim,
                                 ((x * abscisse) + abscisse + marginx / 2) - redim,
                                 ((y * abscisse) + abscisse + marginy / 2) -redim,
                                 carre
                         );
                    } else if (dataMatrice.getElementInData(x, y) == 1) {
                        canvas.drawRect(
                                (x * abscisse + marginx / 2) + redim,
                                (y * abscisse + marginy / 2) +redim,
                                ((x * abscisse) + abscisse + marginx / 2) - redim,
                                ((y * abscisse) + abscisse + marginy / 2) -redim,
                                carre
                        );
                    }
                }



            }
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

        int marginx = 20; // (int) 0.2 * getLayoutParams().width;
        int marginy = (int) (0.2 * getLayoutParams().height);

        if (event.getAction() == MotionEvent.ACTION_UP) {

            int width = getLayoutParams().width - marginx;
            int height = getLayoutParams().height - marginy;

            int abscisse = (int) (width / dim);
            int ordonnee = (int) (height / dim) ;

            int touchX = (int) event.getX() ;
            int touchY = (int) event.getY() ;

            int col = (int) ( touchX / abscisse) ;
            col = Math.abs(col) ;

            int line = (int) ( touchY / ordonnee );
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

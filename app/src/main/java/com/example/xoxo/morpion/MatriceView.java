package com.example.xoxo.morpion;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MatriceView extends View {

    private int dim = 4;

    private Integer[][] mat;


    public MatriceView(Context context, @Nullable AttributeSet attrs) {

        super(context, attrs);
        mat = new Integer[dim][dim];
    }

    public MatriceView(Context context) {
        super(context);
    }


    @Override
    protected void onDraw(Canvas canvas) {

        int marginx = 20 ; // (int) 0.2 * getLayoutParams().width;
        int marginy = (int) (0.2 * getLayoutParams().height);

        System.out.println(marginy);

        super.onDraw(canvas);
        Paint carre = new Paint();
        carre.setStyle(Paint.Style.STROKE);
        carre.setColor(Color.BLACK);
        // int height = getLayoutParams().height - marginy;
        int width = getLayoutParams().width  - marginx;
        int abscisse = (int)width/(dim);
        //int ordonnee = (int)height/(dim);

        for (int x = 0; x < dim ; x++){
            for (int y = 0; y < dim ; y++){
                new square();
//                canvas.drawRect(
//                         x*abscisse + marginx/2,
//                         y*abscisse + marginy/2 ,
//                         (x*abscisse) +abscisse + marginx/2,
//                        (y*abscisse) +abscisse + marginy/2,
//                        carre
//                );

            }
        }



        // stroke
        /*
        strokePaint.setStyle(Paint.Style.STROKE);
        strokePaint.setColor(Color.BLACK);
        strokePaint.setStrokeWidth(10);
        */
    }


    /*
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        touchX = (int)event.getX();
        touchY = (int)event.getY();
        if(event.getAction() == MotionEvent.ACTION_UP){
            Coordonnee newCoordonnee = new Coordonnee(touchY-30, touchY+30, touchX+30, touchX-30);
            Coordonnee.listCoordonne.add(newCoordonnee);
        }
        invalidate();

        return true;
    }
*/
}

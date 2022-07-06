package com.example.xoxo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MatriceView extends View {

    private int dim = 4;

    public MatriceView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MatriceView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint carre = new Paint();
        carre.setStyle(Paint.Style.STROKE);
        carre.setColor(Color.BLACK);
        int height = getLayoutParams().height;
        int width = getLayoutParams().width;
        int abscisse = (int)width/(dim+2);
        int ordonnee = (int)height/(dim+2);
        for(int x = 0; x<this.dim*230; x+=230){
            for(int y = 0; y<this.dim*230; y+= 230){
                canvas.drawRect(abscisse+ x, abscisse + y,  ordonnee + x, ordonnee + y, carre);
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

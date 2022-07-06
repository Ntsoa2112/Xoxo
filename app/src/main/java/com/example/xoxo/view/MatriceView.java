package com.example.xoxo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MatriceView extends View {
    public MatriceView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MatriceView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint newPaint = new Paint();
        newPaint.setColor(Color.BLACK);
        canvas.drawRect(100, 100,  60, 60, newPaint);

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

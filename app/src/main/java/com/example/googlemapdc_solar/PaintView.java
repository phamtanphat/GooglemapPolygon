package com.example.googlemapdc_solar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class PaintView extends View implements View.OnTouchListener {
    Paint mPaint;
    float mX;
    float mY;
    TextView mTVCoordinates;
    private List<Point> points = new ArrayList<>();
    private int index = 0;

    public PaintView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mX = mY = -100;
        mTVCoordinates = null;
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Setting the color of the circle
        mPaint.setColor(Color.rgb(231, 188, 81));

        // Draw the circle at (x,y) with radius 15
        for(Point point: points){
            canvas.drawCircle(point.x, point.y, 10, mPaint);

        }
        if (points.size() > 1){
            for (int i = 0 ; i< points.size() - 1; i++){

                canvas.drawLine(points.get(i).x, points.get(i).y,points.get(i + 1).x, points.get(i + 1).y,mPaint);
            }
        }

        // Redraw the canvas
        invalidate();
    }
    public void setTextView(TextView tv){
        // Reference to TextView Object
        mTVCoordinates = tv;
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        Point p = new Point();
        switch(event.getAction()){
            // When user touches the screen
            case MotionEvent.ACTION_DOWN:
                // Getting X coordinate
                p.x = (int) event.getX();
                // Getting Y Coordinate
                p.y = (int) event.getY();

                points.add(p);

                // Setting the coordinates on TextView
                if(mTVCoordinates!=null){
                    mTVCoordinates.setText("X :" + p.x + " , " + "Y :" + p.y);
                }
        }
        return true;
    }
}
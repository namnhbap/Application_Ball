package com.example.ngochieu.application_ball;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;

/**
 * Created by NgocHieu on 3/10/2016.
 */
public class brick extends View{
    Bitmap br;
    int x,y,xMax,yMax;
    public brick(Context context){
        super(context);
        br = BitmapFactory.decodeResource(getResources(), R.drawable.brick);
        br = Bitmap.createScaledBitmap(br, 50, 32, false);
    }

    protected void chophu(Canvas canvas,int x,int y) {
       // super.onDraw(canvas);
        //ve mot lop gach
        //for(int i=0;i<xMax;i=i+150)
        canvas.drawBitmap(br, x, y, null);
    }
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        xMax=w;
        yMax=h;
    }
}

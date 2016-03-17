package com.example.ngochieu.application_ball;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;

/**
 * Created by NgocHieu on 3/11/2016.
 */
public class bar extends View{
    Bitmap br;
    float x;
    public bar(Context context){
        super(context);
        br = BitmapFactory.decodeResource(getResources(), R.drawable.bar);
        br = Bitmap.createScaledBitmap(br, 100, 20, false);
    }

    protected void setbar(Canvas canvas,float i,int y) {
        x=i;
        canvas.drawBitmap(br, x, y*4/5, null);
    }
    public float getBarx(){ return x;}
}

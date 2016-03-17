package com.example.ngochieu.application_ball;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;

/**
 * Created by NgocHieu on 3/10/2016.
 */
public class ball extends View{
    Bitmap ball,ball2;
    int x1=300,y1=400,x2=0,y2=0, dty,dtx;
    int xspeed1=10,yspeed1=-10,xspeed2=-20,yspeed2=-20;
    int xMin=0,xMax,yMin=10,yMax;
    public ball(Context context){
        super(context);
        ball = BitmapFactory.decodeResource(getResources(), R.drawable.ball);
        ball = Bitmap.createScaledBitmap(ball, 25, 25, false);
        ball2 = BitmapFactory.decodeResource(getResources(), R.drawable.ball);
        ball2 = Bitmap.createScaledBitmap(ball2, 50, 50, false);
    }
    protected void setImage(Canvas canvas) {
       // super.onDraw(canvas);
        canvas.drawBitmap(ball, x1, y1, null);
        //canvas.drawBitmap(ball2, x2, y2, null);


    }
    public void update1(int xMax,int yMax) {
        dtx=Math.abs(x1 - x2);
        dty=Math.abs(y1 - y2);
        if(x1<=xMin||x1+50>xMax){
            xspeed1=-xspeed1;

        }
        if(y1<yMin) {
            yspeed1 = -yspeed1;
        }
        x1+=xspeed1;
        y1+=yspeed1;
    }

    public void update2(int xMax,int yMax) {
        dtx=Math.abs(x1 - x2);
        dty=Math.abs(y1 - y2);
        if(x2<=xMin||x2+50>xMax){
            xspeed2=-xspeed2;

        }
        if(y2<=yMin||y2+50>yMax||dty<=50&&dtx<=50) {
            yspeed2 = -yspeed2;
        }
        x2+=xspeed2;
        y2+=yspeed2;
    }
    public int getx(){ return x1;}
    public int gety(){return y1;}
    public void set(){ yspeed1=-yspeed1;}


}

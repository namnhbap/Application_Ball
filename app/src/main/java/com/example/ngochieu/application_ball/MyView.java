package com.example.ngochieu.application_ball;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by NgocHieu on 3/8/2016.
 */
public class MyView extends View {
    boolean touchDown=false;
    ball b;
    brick br;
    int xMax,yMax,score=0;
    int[] xb,yb,z;
    bar brr;
    float xBar=200;
    Paint paint;
    public MyView(Context context) {
        super(context);
        brr=new bar(context);
        b=new ball(context);
        br=new brick(context);
        xb=new int[51];
        yb=new int[51];
        z=new int[51];
        for(int i=1;i<z.length;i++) z[i]=1;
        xb[1]=0;
        //tao x
        for(int i=2;i<11;i++)xb[i]=xb[i-1]+53;
        for(int i=11;i<51;i++) xb[i]=xb[i-10];
        //tao y
        for(int i=1;i<11;i++) yb[i]=0;
        for(int i=11;i<51;i++)yb[i]=yb[i-10]+35;
        }
    @Override
    protected void onDraw(Canvas canvas) {

                super.onDraw(canvas);
        b.setImage(canvas);
        check();
        //ve text
        paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setTextSize(40);
        canvas.drawText("Score: " + score , 10,yMax-100, paint);
        if(score==500){canvas.drawText("You Win" , xMax/2-100,yMax/2, paint);
                        touchDown=false;}
        message(canvas);
      if(touchDown) update();
       // b.update2(xMax,yMax);
        for(int i=1;i<xb.length;i++) if(z[i]==1)br.chophu(canvas,xb[i],yb[i]);
        this.setBackgroundResource(R.drawable.background);
        // ve bar
        brr.setbar(canvas,xBar,yMax);
        try {
            Thread.sleep(30);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        invalidate();
}
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        xMax=w;
        yMax=h;
    }
    public void update(){
        b.update1(xMax, yMax);
       // updateBar();
    }
    private void delete(int j){

        z[j]=0;
    }
    public void checkBar(){
        int x=b.getx();
        int y=b.gety();
        float xbar=brr.getBarx();
        if((y+25>=yMax*4/5)&&(y+25<=yMax*0.81)&&(xbar<=x)&&(x<=xbar+100))b.set();
    }
    private void checkBrick(){
        int x=b.getx();
        int y=b.gety();
        for(int i=1;i<51;i++)
            if((xb[i]<=x+12)&&(xb[i]+53>=x+12)&&(yb[i]+35>=y+12)&&(yb[i]<=y+12)&&(z[i]==1)){
                delete(i);
                b.set();
                score+=10;

            }
    }
    public void check(){
        checkBar();
        checkBrick();
    }
    public boolean onTouchEvent(MotionEvent event){
        touchDown = true;
        if(event.getRawY()>yMax*0.7)
            xBar=event.getRawX()-50;
        if(xBar+100>=xMax)xBar=xMax-100;
        if(xBar<=0)xBar=0;
        if(event.getRawY()<yMax*0.5)touchDown=false;
        return true;
    }
    public void message(Canvas canvas){
        if (b.gety()+25>=yMax){
           canvas.drawText("You Lose" , xMax/2-100,yMax/2, paint);

                touchDown=false;
        }
    }
}

package com.example.ngochieu.application_ball;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyView TargetView = new MyView(this);
        setContentView(TargetView);
        TargetView.setBackgroundColor(Color.WHITE);
    }
}

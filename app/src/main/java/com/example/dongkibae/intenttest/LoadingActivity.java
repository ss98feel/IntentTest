package com.example.dongkibae.intenttest;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by dongkibae on 2017. 7. 13..
 */

public class LoadingActivity extends AppCompatActivity {
    private TextView counter;
    private int time;
    private ImageView loadImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        counter = (TextView)findViewById(R.id.Counter);
        loadImage = (ImageView)findViewById(R.id.imageView);
        time = 3;
        CountDownTimer mcount = null;

        mcount = new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                counter.setText(""+millisUntilFinished/1000);
                time--;
            }
            @Override
            public void onFinish() {
                Intent myintent = new Intent(LoadingActivity.this,MainActivity.class);
                startActivity(myintent);
                finish();
            }
        };
        mcount.start();
    }
}



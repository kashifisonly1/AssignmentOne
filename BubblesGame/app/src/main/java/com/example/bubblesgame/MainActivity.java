package com.example.bubblesgame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    private Handler handler = new Handler();
    RelativeLayout root;
    int size = 80;
    int speed = 10;
    float screenHeight;
    float screenWidth;
    TextView scoreView;
    TextView livesView;
    int lives=3;
    int score=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        screenHeight = getResources().getDisplayMetrics().heightPixels;
        screenWidth = getResources().getDisplayMetrics().widthPixels;
        root = findViewById(R.id.root);
        scoreView=findViewById(R.id.score);
        livesView=findViewById(R.id.lives);
        handler.postDelayed(addingImages, 1000);
    }
    private Runnable addingImages = new Runnable() {
        @Override
        public void run() {
            if(lives!=0)
            {
                addImage();
                handler.postDelayed(addingImages, 1000);
            }
        }
    };
    private Runnable livesDown = new Runnable() {
        @Override
        public void run() {
            lives--;
            livesView.setText("Lives: "+lives);
        }
    };
    private void addImage(){
        ImageView img = new ImageView(getApplicationContext());
        Random rand = new Random();
        int randomNumber = rand.nextInt(Math.round(screenWidth-80));

        img.setOnClickListener(this::removeBubble);
        img.setImageDrawable(getDrawable(R.drawable.bubble));
        img.animate().translationYBy(screenHeight).setDuration(speed*1000).withEndAction(livesDown);
        LayoutParams lp = new LayoutParams(size, size);
        lp.addRule(RelativeLayout.BELOW, scoreView.getId());
        lp.setMargins(randomNumber,0,0,0);
        img.setLayoutParams(lp);
        root.addView(img);
    }
    private void removeBubble(View view){
        view.animate().cancel();
        root.removeView(view);
        score++;
        scoreView.setText("Score: "+score);
    }
}
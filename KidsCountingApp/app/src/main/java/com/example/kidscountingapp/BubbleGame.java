package com.example.kidscountingapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import java.util.Random;

public class BubbleGame extends AppCompatActivity {
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
    int bubblesCount=3;
    int delayTime = 1000;
    MediaPlayer bgSound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bubble_game);
        bgSound = MediaPlayer.create(this, R.raw.bg);
        bgSound.setLooping(true);
        bgSound.setVolume(0, 0.2f);
        bgSound.start();
        screenHeight = getResources().getDisplayMetrics().heightPixels;
        screenWidth = getResources().getDisplayMetrics().widthPixels;
        root = findViewById(R.id.root);
        scoreView=findViewById(R.id.score);
        livesView=findViewById(R.id.lives);
        handler.postDelayed(addingImages, delayTime);
    }
    private Runnable addingImages = new Runnable() {
        @Override
        public void run() {
            if(lives!=0)
            {
                addImage();
                handler.postDelayed(addingImages, delayTime);
            }
            else{
                endGame();
            }
        }
    };
    private Runnable livesDown = new Runnable() {
        @Override
        public void run() {
            if(lives==0)
                return;
            lives--;
            livesView.setText("Lives: "+lives);
        }
    };
    private void endGame(){
        TextView textView = new TextView(this);
        LayoutParams lpe = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        lpe.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
        textView.setText("GAME END, SCORE: "+score);
        textView.setTextSize(24);
        textView.setLayoutParams(lpe);
        root.addView(textView);
    }
    private void addImage(){
        for(int i = 0; i<bubblesCount; i++) {
            ImageView img = new ImageView(getApplicationContext());
            Random rand = new Random();
            int randomNumber = rand.nextInt(Math.round(screenWidth - 80));
            img.setOnClickListener(this::removeBubble);
            img.setImageDrawable(getDrawable(R.drawable.bubble));
            img.animate().translationYBy(screenHeight).setDuration(speed * 1000).withEndAction(livesDown);
            LayoutParams lp = new LayoutParams(size, size);
            lp.addRule(RelativeLayout.BELOW, scoreView.getId());
            lp.setMargins(randomNumber, 0, 0, 0);
            img.setLayoutParams(lp);
            root.addView(img);
        }
    }
    private void removeBubble(View view){
        if(lives==0)
            return;
        MediaPlayer popSound = MediaPlayer.create(this, R.raw.pop);
        popSound.start();
        view.animate().cancel();
        root.removeView(view);
        score++;
        if(score%10==0&&speed>5){
            delayTime-=50;
        }
        scoreView.setText("Score: "+score);
    }

    public void gotoHome(View view) {
        bgSound.stop();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
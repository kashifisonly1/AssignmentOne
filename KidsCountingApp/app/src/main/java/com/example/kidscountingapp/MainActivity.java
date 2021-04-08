package com.example.kidscountingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer= MediaPlayer.create(this,R.raw.bg);
        mediaPlayer.setLooping(true);
        mediaPlayer.setVolume(0,0.2f);
        mediaPlayer.start();
    }

    public void startApp(View view) {
        mediaPlayer.stop();
        Intent intent= new Intent(this, PlayCounting.class);
        startActivity(intent);
    }
    public void startGame(View view) {
        mediaPlayer.stop();
        Intent intent= new Intent(this, BubbleGame.class);
        startActivity(intent);
    }

}
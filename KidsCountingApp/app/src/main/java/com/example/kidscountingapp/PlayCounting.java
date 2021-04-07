package com.example.kidscountingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class PlayCounting extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_counting);
        mediaPlayer= MediaPlayer.create(this,R.raw.bg);
        mediaPlayer.setLooping(true);
        mediaPlayer.setVolume(0,0.2f);
        mediaPlayer.start();
    }

    public void oneClicked(View view) {
        view.animate().rotationXBy(360).setDuration(1000);
        MediaPlayer mediaPlayer= MediaPlayer.create(this,R.raw.one);
        mediaPlayer.start();
    }
    public void twoClicked(View view) {
        view.animate().rotationXBy(360).setDuration(1000);
        MediaPlayer mediaPlayer= MediaPlayer.create(this,R.raw.two);
        mediaPlayer.start();
    }
    public void threeClicked(View view) {
        view.animate().rotationXBy(360).setDuration(1000);
        MediaPlayer mediaPlayer= MediaPlayer.create(this,R.raw.three);
        mediaPlayer.start();
    }
    public void fourClicked(View view) {
        view.animate().rotationXBy(360).setDuration(1000);
        MediaPlayer mediaPlayer= MediaPlayer.create(this,R.raw.four);
        mediaPlayer.start();
    }
    public void fiveClicked(View view) {
        view.animate().rotationXBy(360).setDuration(1000);
        MediaPlayer mediaPlayer= MediaPlayer.create(this,R.raw.five);
        mediaPlayer.start();
    }
    public void sixClicked(View view) {
        view.animate().rotationXBy(360).setDuration(1000);
        MediaPlayer mediaPlayer= MediaPlayer.create(this,R.raw.six);
        mediaPlayer.start();
    }
    public void sevenClicked(View view) {
        view.animate().rotationXBy(360).setDuration(1000);
        MediaPlayer mediaPlayer= MediaPlayer.create(this,R.raw.seven);
        mediaPlayer.start();
    }
    public void eightClicked(View view) {
        view.animate().rotationXBy(360).setDuration(1000);
        MediaPlayer mediaPlayer= MediaPlayer.create(this,R.raw.eight);
        mediaPlayer.start();

    }
    public void nineClicked(View view) {
        view.animate().rotationXBy(360).setDuration(1000);
        MediaPlayer mediaPlayer= MediaPlayer.create(this,R.raw.nine);
        mediaPlayer.start();
    }
    public void tenClicked(View view) {
        View ten1 = findViewById(R.id.tenImage1);
        View ten2 = findViewById(R.id.tenImage2);
        ten1.animate().rotationXBy(360).setDuration(1000);
        ten2.animate().rotationXBy(360).setDuration(1000);
        MediaPlayer mediaPlayer= MediaPlayer.create(this,R.raw.ten);
        mediaPlayer.start();
    }

    public void gotoHome(View view) {
        mediaPlayer.stop();
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
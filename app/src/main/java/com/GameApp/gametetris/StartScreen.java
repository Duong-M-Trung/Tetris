package com.GameApp.gametetris;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.media.MediaPlayer;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class StartScreen extends AppCompatActivity {

    Marathon parent;
    SharedPreferences mPref;
    private MediaPlayer mediaPlayer;
    private MediaPlayer buttonsound;
    private int maxVolume = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_screen);
        mediaPlayer = MediaPlayer.create(this,R.raw.tetris_soundtrack);
        mediaPlayer.start();
        mediaPlayer.setLooping(true);
        readPreferences();
        mPref = getSharedPreferences("setup", MODE_PRIVATE);
    }

    public void readPreferences(){
        try {
            parent.randomType = mPref.getInt("Random Type", 1); // Second one means get what value if this does not exist
        } catch (Exception PrefEmpty) {
            parent.randomType = 1;
        }
        try {
            parent.rotationType = mPref.getInt("Rotation Type", 1); // Second one means get what value if this does not exist
        } catch (Exception PrefEmpty) {
            parent.rotationType = 2;
        }
        try {
            parent.softDropSpeed = mPref.getInt("Soft Drop Type", 1); // Second one means get what value if this does not exist
        } catch (Exception PrefEmpty) {
            parent.softDropSpeed = 1;
        }
    }

    public void onStart(View v){
        Intent intent = new Intent(this, Marathon.class);
        startActivity(intent);
        buttonsound = MediaPlayer.create(this,R.raw.clickstart);
        buttonsound.start();
        mediaPlayer.stop();
    }

    public void onSettings(View v){
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
        buttonsound = MediaPlayer.create(this,R.raw.clickmenuhome);
        buttonsound.start();
    }

    public void onMaps(View v){
        Intent intent = new Intent(this, Maps.class);
        startActivity(intent);
        buttonsound = MediaPlayer.create(this,R.raw.clickmenuhome);
        buttonsound.start();
    }

    public void onExit(View v){
        mediaPlayer.stop();
        buttonsound = MediaPlayer.create(this,R.raw.clickmenuhome);
        buttonsound.start();
        finishAffinity();
        System.exit(0);

    }
}

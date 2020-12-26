package com.GameApp.gametetris;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mediaPlayer = MediaPlayer.create(this,R.raw.tetris_soundtrack);
        mediaPlayer.start();
        mediaPlayer.setLooping(true);
        setContentView(R.layout.activity_main);
    }
}
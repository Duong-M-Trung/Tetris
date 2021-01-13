package com.GameApp.gametetris;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Gameover extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameover);
        Bundle bundle = getIntent().getExtras();
        Long score = bundle.getLong("score");
        Long highscore = bundle.getLong("highscore");
        TextView sc = (TextView)findViewById(R.id.score);
        TextView hsc = (TextView)findViewById(R.id.highscore);
        sc.setText(score.toString());
        hsc.setText(highscore.toString());
    }
    public void onHome(View v){
        Intent intentover= new Intent(this, Gameover.class);
        startActivity(intentover);
        finish();
        Intent intent = new Intent(this, StartScreen.class);
        startActivity(intent);
    }
    public void onRetry(View v){
        Intent intent = new Intent(this, Marathon.class);
        startActivity(intent);
    }
}
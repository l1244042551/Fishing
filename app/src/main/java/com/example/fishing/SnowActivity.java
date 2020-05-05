package com.example.fishing;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

import java.util.Random;

public class SnowActivity extends AppCompatActivity {
    private Button spot00;
    private Button spot01;
    private Button spot02;
    private Button spot10;
    private Button spot11;
    private Button spot12;
    private Button spot20;
    private Button spot21;
    private Button spot22;
    private MediaPlayer soundNear;
    private MediaPlayer soundCaught;
    private boolean condition[][] = new boolean[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snow);
        createFish();
        spot00 = findViewById(R.id.Spot00);
        spot00.setSoundEffectsEnabled(false);
        spot00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caught(condition[0][0]);
            }
        });
        spot01 = findViewById(R.id.Spot01);
        spot01.setSoundEffectsEnabled(false);
        spot01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caught(condition[0][1]);
            }
        });
        spot02 = findViewById(R.id.Spot02);
        spot02.setSoundEffectsEnabled(false);
        spot02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caught(condition[0][2]);
            }
        });
        spot10 = findViewById(R.id.Spot10);
        spot10.setSoundEffectsEnabled(false);
        spot10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caught(condition[1][0]);
            }
        });
        spot11 = findViewById(R.id.Spot11);
        spot11.setSoundEffectsEnabled(false);
        spot11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caught(condition[1][1]);
            }
        });
        spot12 = findViewById(R.id.Spot12);
        spot12.setSoundEffectsEnabled(false);
        spot12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caught(condition[1][2]);
            }
        });
        spot20 = findViewById(R.id.Spot20);
        spot20.setSoundEffectsEnabled(false);
        spot20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caught(condition[2][0]);
            }
        });
        spot21 = findViewById(R.id.Spot21);
        spot21.setSoundEffectsEnabled(false);
        spot21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caught(condition[2][1]);
            }
        });
        spot22 = findViewById(R.id.Spot22);
        spot22.setSoundEffectsEnabled(false);
        spot22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caught(condition[2][2]);
            }
        });
        soundNear = MediaPlayer.create(this, R.raw.s1);
        soundCaught = MediaPlayer.create(this, R.raw.s0);
    }

    private void createFish() {
        int fishLocationX = new Random().nextInt(3);
        int fishLocationY = new Random().nextInt(3);
        condition[fishLocationX][fishLocationY] = true;
    }

    public void caught(boolean caught) {
        if (caught) {
            soundCaught.start();
            AlertDialog.Builder success = new AlertDialog.Builder(this);
            success.setMessage("Congratulations! You have caught this fish");
            success.create().show();
        } else {
            soundNear.start();
            AlertDialog.Builder fail = new AlertDialog.Builder(this);
            fail.setMessage("Oops, the fish got way. Good luck next time!");
            fail.create().show();
        }
    }
}

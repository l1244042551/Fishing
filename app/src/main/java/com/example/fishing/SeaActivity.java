package com.example.fishing;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class SeaActivity extends AppCompatActivity {
    private Button spot00;
    private Button spot01;
    private Button spot02;
    private Button spot10;
    private Button spot11;
    private Button spot12;
    private Button spot20;
    private Button spot21;
    private Button spot22;
    private Vibrator vibrator;
    private MediaPlayer soundNear;
    private MediaPlayer soundCaught;
    private int count = 2;
    private boolean condition[][] = new boolean[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sea);
        createFish();
        spot00 = findViewById(R.id.button7);
        spot00.setSoundEffectsEnabled(false);
        spot00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caught(condition[0][0], count);
                count--;
            }
        });
        spot01 = findViewById(R.id.button8);
        spot01.setSoundEffectsEnabled(false);
        spot01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caught(condition[0][1], count);
                count--;
            }
        });
        spot02 = findViewById(R.id.button9);
        spot02.setSoundEffectsEnabled(false);
        spot02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caught(condition[0][2], count);
                count--;
            }
        });
        spot10 = findViewById(R.id.button4);
        spot10.setSoundEffectsEnabled(false);
        spot10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caught(condition[1][0], count);
                count--;
            }
        });
        spot11 = findViewById(R.id.button5);
        spot11.setSoundEffectsEnabled(false);
        spot11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caught(condition[1][1], count);
                count--;
            }
        });
        spot12 = findViewById(R.id.button6);
        spot12.setSoundEffectsEnabled(false);
        spot12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caught(condition[1][2], count);
                count--;
            }
        });
        spot20 = findViewById(R.id.button);
        spot20.setSoundEffectsEnabled(false);
        spot20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caught(condition[2][0], count);
                count--;
            }
        });
        spot21 = findViewById(R.id.button2);
        spot21.setSoundEffectsEnabled(false);
        spot21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caught(condition[2][1], count);
                count--;
            }
        });
        spot22 = findViewById(R.id.button3);
        spot22.setSoundEffectsEnabled(false);
        spot22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caught(condition[2][2], count);
                count--;
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

    public void caught(boolean caught, int times) {
        if (caught) {
            soundCaught.start();
            AlertDialog.Builder success = new AlertDialog.Builder(this);
            success.setMessage("Congratulations! You have caught this fish");
            success.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    Intent intent = new Intent(SeaActivity.this, GameActivity.class);
                    startActivity(intent);
                }
            });
            success.create().show();
            vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
            if (Build.VERSION.SDK_INT >= 26) {
                vibrator.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE));
            } else {
                vibrator.vibrate(200);
            }
        } else {
            soundNear.start();
            AlertDialog.Builder fail = new AlertDialog.Builder(this);
            fail.setMessage("Oops, the fish got way. Good luck next time!");
            fail.create().show();
            limit(times);
        }
    }
    public void limit(int times) {
        if (times == 0) {
            AlertDialog.Builder end = new AlertDialog.Builder(this);
            end.setMessage("The fish got away, better luck next game!");
            end.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    Intent intent = new Intent(SeaActivity.this, GameActivity.class);
                    startActivity(intent);
                }
            });
            end.create().show();
        } else {
            AlertDialog.Builder remainder = new AlertDialog.Builder(this);
            String time = Integer.toString(times);
            remainder.setMessage("You have " + time + " chance left to catch the fish");
            remainder.create().show();
        }
    }
}

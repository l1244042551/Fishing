package com.example.fishing;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

    private boolean condition[][] = new boolean[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sea);
        createFish();
        spot00 = findViewById(R.id.button7);
        spot00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caught(condition[0][0]);
            }
        });
        spot01 = findViewById(R.id.button8);
        spot01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caught(condition[0][1]);
            }
        });
        spot02 = findViewById(R.id.button9);
        spot02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caught(condition[0][2]);
            }
        });
        spot10 = findViewById(R.id.button4);
        spot10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caught(condition[1][0]);
            }
        });
        spot11 = findViewById(R.id.button5);
        spot11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caught(condition[1][1]);
            }
        });
        spot12 = findViewById(R.id.button6);
        spot12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caught(condition[1][2]);
            }
        });
        spot20 = findViewById(R.id.button);
        spot20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caught(condition[2][0]);
            }
        });
        spot21 = findViewById(R.id.button2);
        spot21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caught(condition[2][1]);
            }
        });
        spot22 = findViewById(R.id.button3);
        spot22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caught(condition[2][2]);
            }
        });
    }

    private void createFish() {
        int fishLocationX = new Random().nextInt(3);
        int fishLocationY = new Random().nextInt(3);
        condition[fishLocationX][fishLocationY] = true;
    }

    public void caught(boolean caught) {
        if (caught) {
            AlertDialog.Builder success = new AlertDialog.Builder(this);
            success.setMessage("Congratulations! You have caught this fish");
            success.create().show();
        } else {
            AlertDialog.Builder fail = new AlertDialog.Builder(this);
            fail.setMessage("Oops, the fish got way. Good luck next time!");
            fail.create().show();
        }
    }
}

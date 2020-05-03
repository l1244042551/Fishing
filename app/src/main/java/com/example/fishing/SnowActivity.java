package com.example.fishing;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

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

    private boolean condition[][] = new boolean[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snow);
        spot00 = findViewById(R.id.Spot00);
        spot01 = findViewById(R.id.Spot01);
        spot02 = findViewById(R.id.Spot02);
        spot10 = findViewById(R.id.Spot10);
        spot11 = findViewById(R.id.Spot11);
        spot12 = findViewById(R.id.Spot12);
        spot20 = findViewById(R.id.Spot20);
        spot21 = findViewById(R.id.Spot21);
        spot22 = findViewById(R.id.Spot22);
        caught(false);

        createFish();
    }

    private void createFish() {
        int fishLocationX = new Random().nextInt(3);
        int fishLocationY = new Random().nextInt(3);
        condition[fishLocationX][fishLocationY] = true;
    }

    public void caught(boolean caught) {
        if (caught) {
            AlertDialog.Builder success = new AlertDialog.Builder(this);
            success.setMessage("Congratulations! You have caught this ");
            success.create().show();
        } else {
            AlertDialog.Builder fail = new AlertDialog.Builder(this);
            fail.setMessage("Oops, the fish got way. Good luck next time!");
            fail.create().show();
        }
    }
}

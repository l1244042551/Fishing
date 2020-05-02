package com.example.fishing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import java.util.Random;

public class LakeActivity extends AppCompatActivity {
    private ImageView lake;

    private boolean[][] condition = new boolean[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lake);

        createFish();

    }

    private void createFish() {
        int fishLocationX = new Random().nextInt(3);
        int fishLocationY = new Random().nextInt(3);
        condition[fishLocationX][fishLocationY] = true;
    }
}

package com.example.fishing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GameActivity extends AppCompatActivity {
    private Button lake;
    private Button waterfall;
    private Button sea;
    private Button snow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //set the four maps to show up.
        lake = findViewById(R.id.Lake);
        waterfall = findViewById(R.id.Waterfall);
        sea = findViewById(R.id.Sea);
        snow = findViewById(R.id.Snow);
        lake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLakeMap();
            }
        });
        waterfall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWaterfallMap();
            }
        });
        sea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSeaMap();
            }
        });
        snow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSnowMap();
            }
        });
    }
    public void openLakeMap() {
        Intent lakeMap = new Intent(GameActivity.this, LakeActivity.class);
        startActivity(lakeMap);
    }
    public void openSeaMap() {
        Intent seaMap = new Intent(GameActivity.this, SeaActivity.class);
        startActivity(seaMap);
    }
    public void openWaterfallMap() {
        Intent waterfallMap = new Intent(GameActivity.this, WaterfallActivity.class);
        startActivity(waterfallMap);
    }
    public void openSnowMap() {
        Intent snowMap = new Intent(GameActivity.this, SnowActivity.class);
        startActivity(snowMap);
    }
}

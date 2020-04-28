package com.example.fishing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class GameActivity extends AppCompatActivity {
    private Button lake;
    private Button waterfall;
    private Button sea;
    private Button undecided;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //set the four maps to show up.
        lake = findViewById(R.id.Lake);
        waterfall = findViewById(R.id.Waterfall);
        sea = findViewById(R.id.Sea);
        undecided = findViewById(R.id.undecided);
    }
}

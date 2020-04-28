package com.example.fishing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    private Button Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Tell the Login button what to do.
        Login = findViewById(R.id.LoginButton);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the Login Layout.
                openLoginActivity();
            }
        });
    }
    // Create a method to open the LoginActivity.
    public void openLoginActivity() {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }
}

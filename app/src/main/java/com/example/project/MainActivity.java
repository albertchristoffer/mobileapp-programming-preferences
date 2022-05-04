package com.example.project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    TextView textViewName;
    SharedPreferences preferences;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        preferences = getSharedPreferences("preferences", MODE_PRIVATE);
        textViewName = findViewById(R.id.name);

        Log.d("==>", "onCreate körs!");
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
                SharedPreferences.Editor editor = preferences.edit();
                editor.clear().apply();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        preferences = getSharedPreferences("preferences", MODE_PRIVATE);
        Log.d("==>", "Main Activity resumed!");
        String name = preferences.getString("name", "Inget namn hittades.");
        Log.d("==>", name);
        textViewName.setText(name);
    }
}

package com.example.intentplayground;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();

        if (intent.hasExtra(Constant.MESSAGE)) {
            String msg = intent.getStringExtra(Constant.MESSAGE);
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }
    }
}

package com.example.app;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private static  int TIME_OUT =4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
   new Handler().postDelayed(new Runnable() {
    @Override
    public void run() {
        Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
        getBaseContext().startActivity(loginIntent);
       finish();
    }
    },TIME_OUT);
    }
}
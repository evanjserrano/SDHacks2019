package com.example.sdhacks2019;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class DailyActivity extends AppCompatActivity {

    private static Button breakfast;
    private static Button lunch;
    private static Button dinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_daily);

        breakfast = findViewById(R.id.breakfastButton);
        breakfast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //openBreakfastMenu();
            }

        });

        lunch = findViewById(R.id.lunchButton);
        lunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //openLunchMenu();
            }

        });

        dinner = findViewById(R.id.dinnerButton);
        dinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //openDinnerMenu();
            }

        });
    }
/*
    public void openBreakfastMenu() {
        Intent intent = new Intent(this, BreakfastActivity.class);
        startActivity(intent);

    }

    public void openLunchMenu() {
        Intent intent = new Intent(this, LunchActivity.class);
        startActivity(intent);

    }

    public void openDinnerMenu() {
        Intent intent = new Intent(this, DinnerActivity.class);
        startActivity(intent);

    }
    */


    public static void setBreakfast() {
        breakfast.getBackground().setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);
        breakfast.setClickable(false);
    }
}

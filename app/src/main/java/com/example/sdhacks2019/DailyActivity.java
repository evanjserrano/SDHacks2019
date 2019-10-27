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

    private Button breakfast;
    private Button lunch;
    private Button dinner;
    private Button mealButton;

    private boolean breakfastSelected;
    private boolean lunchSelected;
    private boolean dinnerSelected;


    String meals[][] = new String[3][4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_daily);

        breakfastSelected = false;
        lunchSelected = false;
        dinnerSelected = false;

        breakfast = findViewById(R.id.breakfastButton);
        breakfast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBreakfastMenu();
            }

        });

        lunch = findViewById(R.id.lunchButton);
        lunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLunchMenu();
            }

        });

        dinner = findViewById(R.id.dinnerButton);
        dinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDinnerMenu();
            }

        });

        mealButton = findViewById(R.id.FinishDailyMeal);
        mealButton.setEnabled(false);
        mealButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myMeal = "Breakfast: " + meals[0][0] + "\nLunch: " + meals[1][0] + "\nDinner: " + meals[2][0];
                Intent intent = new Intent();
                intent.putExtra("Complete Meal", myMeal);
                intent.putExtra("Breakfast Name", meals[0][0]);
                intent.putExtra("Breakfast Nutrition", meals[0][1]);
                intent.putExtra("Breakfast Ingredients", meals[0][2]);
                intent.putExtra("Breakfast Instructions", meals[0][3]);
                intent.putExtra("Lunch Name", meals[1][0]);
                intent.putExtra("Lunch Nutrition", meals[1][1]);
                intent.putExtra("Lunch Ingredients", meals[1][2]);
                intent.putExtra("Lunch Instructions", meals[1][3]);
                intent.putExtra("Dinner Name", meals[2][0]);
                intent.putExtra("Dinner Nutrition", meals[2][1]);
                intent.putExtra("Dinner Ingredients", meals[2][2]);
                intent.putExtra("Dinner Instructions", meals[2][3]);
                setResult(RESULT_OK, intent);
                finish();
            }

        });
    }

    public void openBreakfastMenu() {
        Intent intent = new Intent(this, MyBreakfastActivity.class);
        startActivityForResult(intent, 1);

    }

    public void openLunchMenu() {
        Intent intent = new Intent(this, MyLunchActivity.class);
        startActivityForResult(intent, 2);

    }

    public void openDinnerMenu() {
        Intent intent = new Intent(this, MyDinnerActivity.class);
        startActivityForResult(intent, 3);

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                meals[0][0] = data.getStringExtra("Breakfast Name");
                meals[0][1] = data.getStringExtra("Breakfast Nutrition");
                meals[0][2] = data.getStringExtra("Breakfast Ingredients");
                meals[0][3] = data.getStringExtra("Breakfast Instructions");
                breakfast.setText(meals[0][0]);
                breakfastSelected = true;
                //breakfast.setBackgroundColor(Color.parseColor("#90EE90"));

            }
        } else if(requestCode == 2) {
            if(resultCode == RESULT_OK) {
                meals[1][0] = data.getStringExtra("Lunch Name");
                meals[1][1] = data.getStringExtra("Lunch Nutrition");
                meals[1][2] = data.getStringExtra("Lunch Ingredients");
                meals[1][3] = data.getStringExtra("Lunch Instructions");
                lunch.setText(meals[1][0]);
                lunchSelected = true;
                //lunch.setBackgroundColor(Color.parseColor("#90EE90"));
            }
        } else if(requestCode == 3) {
            if(resultCode == RESULT_OK) {
                meals[2][0] = data.getStringExtra("Dinner Name");
                meals[2][1] = data.getStringExtra("Dinner Nutrition");
                meals[2][2] = data.getStringExtra("Dinner Ingredients");
                meals[2][3] = data.getStringExtra("Dinner Instructions");
                dinner.setText(meals[2][0]);
                dinnerSelected = true;
                //dinner.setBackgroundColor(Color.parseColor("#90EE90"));
            }
        }

        if(breakfastSelected && lunchSelected && dinnerSelected) {
            mealButton.setEnabled(true);
        }
    }

}

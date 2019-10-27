package com.example.sdhacks2019;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MealActivity extends AppCompatActivity {

    private FloatingActionButton fab;
    private String food;

    private Button firstMeal;
    private Button secondMeal;
    private Button thirdMeal;

    private String firstMealStrings[][] = new String[3][4];
    private String secondMealStrings[][] = new String[3][4];
    private String thirdMealStrings[][] = new String[3][4];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_meal);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDailyMenu();


            }
        });

        firstMeal = findViewById(R.id.ButtonMeal1);
        firstMeal.setEnabled(false);
        firstMeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMeal1();
            }
        });

        secondMeal = findViewById(R.id.ButtonMeal2);
        secondMeal.setEnabled(false);
        secondMeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMeal2();
            }
        });

        thirdMeal = findViewById(R.id.ButtonMeal3);
        thirdMeal.setEnabled(false);
        thirdMeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMeal3();
            }
        });


    }

    public void openMeal1() {
        Intent intent = new Intent(this, prepped_meal.class);
        Bundle extras = new Bundle();
        extras.putString("BName", firstMealStrings[0][0]);
        extras.putString("BNutr", firstMealStrings[0][1]);
        extras.putString("BIngr", firstMealStrings[0][2]);
        extras.putString("BInst", firstMealStrings[0][3]);
        extras.putString("LName", firstMealStrings[1][0]);
        extras.putString("LNutr", firstMealStrings[1][1]);
        extras.putString("LIngr", firstMealStrings[1][2]);
        extras.putString("LInst", firstMealStrings[1][3]);
        extras.putString("DName", firstMealStrings[2][0]);
        extras.putString("DNutr", firstMealStrings[2][1]);
        extras.putString("DIngr", firstMealStrings[2][2]);
        extras.putString("DInst", firstMealStrings[2][3]);

        intent.putExtras(extras);
        startActivity(intent);


    }

    public void openMeal2() {
        Intent intent = new Intent(this, prepped_meal.class);
        Bundle extras = new Bundle();
        extras.putString("BName", secondMealStrings[0][0]);
        extras.putString("BNutr", secondMealStrings[0][1]);
        extras.putString("BIngr", secondMealStrings[0][2]);
        extras.putString("BInst", secondMealStrings[0][3]);
        extras.putString("LName", secondMealStrings[1][0]);
        extras.putString("LNutr", secondMealStrings[1][1]);
        extras.putString("LIngr", secondMealStrings[1][2]);
        extras.putString("LInst", secondMealStrings[1][3]);
        extras.putString("DName", secondMealStrings[2][0]);
        extras.putString("DNutr", secondMealStrings[2][1]);
        extras.putString("DIngr", secondMealStrings[2][2]);
        extras.putString("DInst", secondMealStrings[2][3]);

        intent.putExtras(extras);
        startActivity(intent);
    }

    public void openMeal3() {
        Intent intent = new Intent(this, prepped_meal.class);
        Bundle extras = new Bundle();
        extras.putString("BName", thirdMealStrings[0][0]);
        extras.putString("BNutr", thirdMealStrings[0][1]);
        extras.putString("BIngr", thirdMealStrings[0][2]);
        extras.putString("BInst", thirdMealStrings[0][3]);
        extras.putString("LName", thirdMealStrings[1][0]);
        extras.putString("LNutr", thirdMealStrings[1][1]);
        extras.putString("LIngr", thirdMealStrings[1][2]);
        extras.putString("LInst", thirdMealStrings[1][3]);
        extras.putString("DName", thirdMealStrings[2][0]);
        extras.putString("DNutr", thirdMealStrings[2][1]);
        extras.putString("DIngr", thirdMealStrings[2][2]);
        extras.putString("DInst", thirdMealStrings[2][3]);

        intent.putExtras(extras);
        startActivity(intent);
    }

    public void openDailyMenu() {
        Intent intent = new Intent(this, DailyActivity.class);
        startActivityForResult(intent, 5);

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 5) {
            if (resultCode == RESULT_OK) {
                food = data.getStringExtra("Complete Meal");
                //breakfast.setBackgroundColor(Color.parseColor("#90EE90"));
                if(!firstMeal.isEnabled()) {
                    firstMeal.setText(food);
                    firstMeal.setEnabled(true);

                    firstMealStrings[0][0] = data.getStringExtra("Breakfast Name");
                    firstMealStrings[0][1] = data.getStringExtra("Breakfast Nutrition");
                    firstMealStrings[0][2] = data.getStringExtra("Breakfast Ingredients");
                    firstMealStrings[0][3] = data.getStringExtra("Breakfast Instructions");
                    firstMealStrings[1][0] = data.getStringExtra("Lunch Name");
                    firstMealStrings[1][1] = data.getStringExtra("Lunch Nutrition");
                    firstMealStrings[1][2] = data.getStringExtra("Lunch Ingredients");
                    firstMealStrings[1][3] = data.getStringExtra("Lunch Instructions");
                    firstMealStrings[2][0] = data.getStringExtra("Dinner Name");
                    firstMealStrings[2][1] = data.getStringExtra("Dinner Nutrition");
                    firstMealStrings[2][2] = data.getStringExtra("Dinner Ingredients");
                    firstMealStrings[2][3] = data.getStringExtra("Dinner Instructions");

                } else if(!secondMeal.isEnabled()) {
                    secondMeal.setText(food);
                    secondMeal.setEnabled(true);

                    secondMealStrings[0][0] = data.getStringExtra("Breakfast Name");
                    secondMealStrings[0][1] = data.getStringExtra("Breakfast Nutrition");
                    secondMealStrings[0][2] = data.getStringExtra("Breakfast Ingredients");
                    secondMealStrings[0][3] = data.getStringExtra("Breakfast Instructions");
                    secondMealStrings[1][0] = data.getStringExtra("Lunch Name");
                    secondMealStrings[1][1] = data.getStringExtra("Lunch Nutrition");
                    secondMealStrings[1][2] = data.getStringExtra("Lunch Ingredients");
                    secondMealStrings[1][3] = data.getStringExtra("Lunch Instructions");
                    secondMealStrings[2][0] = data.getStringExtra("Dinner Name");
                    secondMealStrings[2][1] = data.getStringExtra("Dinner Nutrition");
                    secondMealStrings[2][2] = data.getStringExtra("Dinner Ingredients");
                    secondMealStrings[2][3] = data.getStringExtra("Dinner Instructions");

                } else if(!thirdMeal.isEnabled()) {
                    thirdMeal.setText(food);
                    thirdMeal.setEnabled(true);

                    thirdMealStrings[0][0] = data.getStringExtra("Breakfast Name");
                    thirdMealStrings[0][1] = data.getStringExtra("Breakfast Nutrition");
                    thirdMealStrings[0][2] = data.getStringExtra("Breakfast Ingredients");
                    thirdMealStrings[0][3] = data.getStringExtra("Breakfast Instructions");
                    thirdMealStrings[1][0] = data.getStringExtra("Lunch Name");
                    thirdMealStrings[1][1] = data.getStringExtra("Lunch Nutrition");
                    thirdMealStrings[1][2] = data.getStringExtra("Lunch Ingredients");
                    thirdMealStrings[1][3] = data.getStringExtra("Lunch Instructions");
                    thirdMealStrings[2][0] = data.getStringExtra("Dinner Name");
                    thirdMealStrings[2][1] = data.getStringExtra("Dinner Nutrition");
                    thirdMealStrings[2][2] = data.getStringExtra("Dinner Ingredients");
                    thirdMealStrings[2][3] = data.getStringExtra("Dinner Instructions");
                }
            }
        }
    }

}

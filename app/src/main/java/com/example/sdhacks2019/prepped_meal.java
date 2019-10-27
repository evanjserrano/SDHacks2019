package com.example.sdhacks2019;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Scanner;

public class prepped_meal extends AppCompatActivity {

    private String thisMeal[][] = new String[3][4];

    private Button breakfast;
    private Button lunch;
    private Button dinner;

    private int totCalories;
    private int totCarbs;
    private int totFat;
    private int totProtein;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prepped_meal);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        thisMeal[0][0] = extras.getString("BName");
        thisMeal[0][1] = extras.getString("BNutr");
        thisMeal[0][2] = extras.getString("BIngr");
        thisMeal[0][3] = extras.getString("BInst");
        thisMeal[1][0] = extras.getString("LName");
        thisMeal[1][1] = extras.getString("LNutr");
        thisMeal[1][2] = extras.getString("LIngr");
        thisMeal[1][3] = extras.getString("LInst");
        thisMeal[2][0] = extras.getString("DName");
        thisMeal[2][1] = extras.getString("DNutr");
        thisMeal[2][2] = extras.getString("DIngr");
        thisMeal[2][3] = extras.getString("DInst");

        breakfast = findViewById(R.id.meal1button);
        breakfast.setText(thisMeal[0][0]);
        breakfast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayBreakfast();


            }
        });

        lunch = findViewById(R.id.meal2button);
        lunch.setText(thisMeal[1][0]);

        lunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayLunch();


            }
        });

        dinner = findViewById(R.id.meal3button);
        dinner.setText(thisMeal[2][0]);
        dinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayDinner();


            }
        });





    }

    public void displayBreakfast() {
        TextView tv1 = (TextView)findViewById(R.id.textView4);
        tv1.setText(thisMeal[0][0] + "\nIngredients:\n" + thisMeal[0][2] + "\nInstructions\n" + thisMeal[0][3]);
        //setContentView(tv1);
    }

    public void displayLunch() {
        TextView tv1 = (TextView)findViewById(R.id.textView4);
        tv1.setText(thisMeal[1][0] + "\nIngredients:\n" + thisMeal[1][2] + "\nInstructions\n" + thisMeal[1][3]);
        //setContentView(tv1);
    }
    public void displayDinner() {
        TextView tv1 = (TextView)findViewById(R.id.textView4);
        tv1.setText(thisMeal[2][0] + "\nIngredients:\n" + thisMeal[2][2] + "\nInstructions\n" + thisMeal[2][3]);
        //setContentView(tv1);
    }
}

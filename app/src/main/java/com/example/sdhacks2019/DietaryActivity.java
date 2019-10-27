package com.example.sdhacks2019;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DietaryActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dietary);




        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBudgetMenu();
                saveData();
            }

        });

        loadData();
    }

    public void openBudgetMenu() {
        Intent intent = new Intent(this, MealActivity.class);
        startActivity(intent);

    }

    public void saveData() {

    }

    public void loadData() {

    }
}

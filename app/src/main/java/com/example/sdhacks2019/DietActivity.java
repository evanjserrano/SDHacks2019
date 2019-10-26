package com.example.sdhacks2019;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class DietActivity extends AppCompatActivity {

    private Button button;
    private RadioGroup radioDietGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDietaryMenu();
            }

        });

        radioDietGroup = (RadioGroup) findViewById(R.id.radioDiet);
    }

    public void openDietaryMenu() {
        Intent intent = new Intent(this, DietaryActivity.class);
        startActivity(intent);

    }
}

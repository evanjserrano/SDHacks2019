package com.example.sdhacks2019;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.widget.Button;


import android.os.Bundle;
import android.view.View;

public class Main1Activity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDietMenu();
            }

        });
    }

    public void openDietMenu() {
        Intent intent = new Intent(this, DietActivity.class);
        startActivity(intent);

    }
}

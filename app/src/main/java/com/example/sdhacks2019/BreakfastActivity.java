package com.example.sdhacks2019;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BreakfastActivity extends AppCompatActivity {

    private Button recipe1;
    private Button recipe2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakfast);

        recipe1 = (Button) findViewById(R.id.breakfast1);
        recipe1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRecipe1Popup();
            }

        });

        recipe2 = (Button) findViewById(R.id.breakfast2);
        recipe2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRecipe1Popup();
            }

        });
    }

    public void openRecipe1Popup() {
        Intent intent = new Intent(this, Breakfast1Activity.class);
        startActivity(intent);
    }
}

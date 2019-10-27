package com.example.sdhacks2019;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class DietActivity extends AppCompatActivity {

    private Button button;
    private RadioGroup radioDietGroup;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String DIET_KEY = "diet";

    public static final int NODIET_ID = 0;
    public static final int VEGGIE_ID = 1;
    public static final int VEGAN_ID = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(isFirstTime()) {
            SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
        }
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_diet);

        radioDietGroup = findViewById(R.id.radioDiet);


        // diet radio buttons
        RadioButton nodietRB = findViewById(R.id.noDiet);
        RadioButton veggieRB = findViewById(R.id.vegetarian);
        RadioButton veganRB = findViewById(R.id.vegan);
        nodietRB.setId(NODIET_ID);
        veggieRB.setId(VEGGIE_ID);
        veganRB.setId(VEGAN_ID);


        button = findViewById(R.id.dietbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDietaryMenu();
                saveData();
            }

        });



        loadData();




    }

    public void openDietaryMenu() {
        Intent intent = new Intent(this, DietaryActivity.class);
        startActivity(intent);

    }

    public void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt(DIET_KEY, radioDietGroup.getCheckedRadioButtonId());

        editor.apply();

        Toast.makeText(this, "Nice.", Toast.LENGTH_SHORT).show();
    }

    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        radioDietGroup.clearCheck();
        radioDietGroup.check(sharedPreferences.getInt(DIET_KEY, NODIET_ID));
    }

    public boolean isFirstTime() {
        return getDatabasePath("your file name").exists();
    }


}

package com.example.sdhacks2019;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

public class MyDinnerActivity extends AppCompatActivity {


    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;

    private Button selectButton;

    private String[][] recipeStringDinner = new String[5][4];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        loadRecipes();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_dinner);

        button1 = (Button) findViewById(R.id.ButtonDinner1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonShowPopupWindowClick(v, 0);
            }
        });

        button2 = (Button) findViewById(R.id.ButtonDinner2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonShowPopupWindowClick(v, 1);
            }
        });

        button3 = (Button) findViewById(R.id.ButtonDinner3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonShowPopupWindowClick(v, 2);
            }
        });

        button4 = (Button) findViewById(R.id.ButtonDinner4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonShowPopupWindowClick(v, 3);
            }
        });

        button5 = (Button) findViewById(R.id.ButtonDinner5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonShowPopupWindowClick(v, 4);
            }
        });

    }

    public void onButtonShowPopupWindowClick(View view, int recipeNum) {

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_my_dinner, null);



        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        // create the popup window
        //int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        //int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        int width = size.x;
        int height = size.y;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, (int)(width * .9),
                (int)(height * .7), focusable);

        final int num = recipeNum;

        selectButton = popupView.findViewById(R.id.ButtonDinnerSelect);
        selectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("Dinner Name", recipeStringDinner[num][0]);
                intent.putExtra("Dinner Nutrition", recipeStringDinner[num][1]);
                intent.putExtra("Dinner Ingredients", recipeStringDinner[num][2]);
                intent.putExtra("Dinner Instructions", recipeStringDinner[num][3]);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        TextView textView = (TextView) popupWindow.getContentView().findViewById(R.id.DinnerRecipeTitle);
        textView.setText(recipeStringDinner[recipeNum][0]);

        textView = (TextView) popupWindow.getContentView().findViewById(R.id.DinnerRecipeNutrition);
        textView.setText(recipeStringDinner[recipeNum][1]);

        textView = (TextView) popupWindow.getContentView().findViewById(R.id.DinnerRecipeIngredients);
        textView.setText(recipeStringDinner[recipeNum][2]);

        textView = (TextView) popupWindow.getContentView().findViewById(R.id.DinnerRecipeInstructions);
        textView.setText(recipeStringDinner[recipeNum][3]);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            popupWindow.setElevation(20);
        }
        // dismiss the popup window when touched
        /*
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });*/

    }

    void loadRecipes() {
        recipeStringDinner[0][0] = "Oven Baked Salmon with Salad";
        recipeStringDinner[1][0] = "Savory Salmon Hash";
        recipeStringDinner[2][0] = "Cajun Chicken";
        recipeStringDinner[3][0] = "Cauliflower Rice";
        recipeStringDinner[4][0] = "Cauliflower Stir Fry";


        recipeStringDinner[0][1] = "4 Servings\n" +
                "Per Serving: 44 Calories,\n" +
                "0g carbs, 11g fats, 17g protein";
        recipeStringDinner[1][1] = "2 Serving\n" +
                "Per Serving: 302 Calories,\n" +
                "14g carbs, 15g fats, 29g protein";
        recipeStringDinner[2][1] = "4 Servings\n" +
                "Per Serving: 379 Calories,\n" +
                "45g carbs, 18g fats, 9g protein";
        recipeStringDinner[3][1] = "4 Serving\n" +
                "Per Serving: 140 Calories,\n" +
                "10g carbs, 11g fats, 3g protein";
        recipeStringDinner[4][1] = "4 Servings\n" +
                "Per Serving: 66 Calories,\n" +
                "9g carbs, 3g fats, 4g protein";


        recipeStringDinner[0][2] = "12 ounces of salmon\n" +
                "1 pinch of salt\n" +
                "1 pinch of black pepper\n" +
                "1 shallot\n" +
                "1 tablespoon red wine vinegar\n" +
                "coarse grain salt\n" +
                "2 tablespoons rinsed capers\n" +
                "1 cup fresh parsley\n" +
                "1/2 cup toasted almonds\n" +
                "extra virgin olive oil\n";
        recipeStringDinner[1][2] = "1/2 yellow onion chopped\n" +
                "1/4 cup uncooked oats\n" +
                "1 cup boiling water\n" +
                "1 large zucchini chopped\n" +
                "1 cup chopped cauliflower\n" +
                "8 ounces cooked salmon\n" +
                "dried dill\n" +
                "salt\n";
        recipeStringDinner[2][2] = "1/4 cup ground buckwheat\n" +
                "2 tablespoons sweet paprika powder\n" +
                "1 teaspoon turmeric powder\n" +
                "1 teaspoon coriander powder\n" +
                "1 teaspoon cumin powder\n" +
                "1/2 teaspoon cinnamon powder\n" +
                "salt,pepper\n" +
                "4 chicken thighs or breasts\n" +
                "coconut oil\n" +
                "1 red chili\n" +
                "1 small handful of almonds\n";
        recipeStringDinner[3][2] = "1 large head cauliflower\n" +
                "3 tablespoons olive oil\n" +
                "1 medium onion diced,salt\n" +
                "2 tablespoons fresh parsley\n" +
                "lemon juice\n";
        recipeStringDinner[4][2] = "1 head cauliflower\n" +
                "2 teaspoon vegetable oil\n" +
                "2 cloves garlic\n" +
                "2 tablespoons soy sauce\n" +
                "juice of 1 lime\n" +
                "2 green onions\n" +
                "1 tablespoon sriracha\n" +
                "lime wedges\n";


        recipeStringDinner[0][3] = "Salmon\n" +
                "1. Preheat the oven to 450 degrees F.\n" +
                "2. Season salmon with salt and pepper.\n" +
                "3. Place salmon, skin side down, on a non-stick baking sheet or in a non-stick pan " +
                "with an oven-proof handle.\n" +
                "4. Bake until salmon is cooked through, about 12 to 15 minutes.\n" +
                "5. Serve with the Toasted Almond Parsley Salad and squash, if desired.\n" +
                "Salad\n" +
                "1. Mince the shallot and add to a small bowl.\n" +
                "2. Pour the vinegar over the shallots and add a pinch of salt.\n" +
                "3. Let sit for 30 minutes.\n" +
                "4. Roughly chop the capers, parsley and almonds and add to the shallots.\n" +
                "5. Add the olive oil, tasting as you go.\n" +
                "6. Mix again and adjust the seasonings.\n";
        recipeStringDinner[1][3] = "1. Spray a large saucepan with cooking spray and cook onion and oats for " +
                "about 2 minutes on medium heat, stirring repeatedly.\n" +
                "2. Add boiling water, zucchini, and cauliflower, and simmer for about 15 minutes, " +
                "until mixture has thickened a bit and oats are chewy and no longer hard.\n" +
                "3. Remove from heat and let stand for 2 minutes to thicken.\n" +
                "4. Stir in salmon, dill, and salt and serve.\n";
        recipeStringDinner[2][3] = "1. Mix ground buckwheat, paprika, turmeric, coriander, cumin, cinnamon, " +
                "salt, and pepper together.\n" +
                "2. Coat chicken in mix.\n" +
                "3. Heat a pan with ghee, butter, or coconut oil over medium-low heat.\n" +
                "4. Cook chicken through on both sides of each piece.\n" +
                "5. Serve topped with chili and almonds, and season with salt and pepper to taste.\n";
        recipeStringDinner[3][3] = "1. Trim the cauliflower florets, cutting away as much stem as possible.\n" +
                "2. In 3 batches, break up the florets into a food processor and pulse until the mixture " +
                "resembles couscous.\n" +
                "3. Heat the oil in a large skillet over medium-high heat.\n" +
                "4. At the first wisp of smoke from the oil, add the onions, and stir to coat.\n" +
                "5. Continue cooking, stirring frequently, until the onions are golden brown at the edges " +
                "and have softened, about 8 minutes.\n" +
                "6. Add the cauliflower, and stir to combine.\n" +
                "7. Add 1 teaspoon salt, and continue to cook, stirring frequently," +
                " until the cauliflower has softened, 3 to 5 minutes.\n" +
                "8. Remove from the heat.\n" +
                "9. Spoon the cauliflower into a large serving bowl, garnish with the parsley, " +
                "sprinkle with the lemon juice and season to taste with salt.\n" +
                "Cook's Note: Serve warm.\n";
        recipeStringDinner[4][3] = "1. Break up the cauliflower into large florets, then use your hands to break " +
                "into very small florets.\n" +
                "2. Heat a large, heavy skillet over medium-high to high heat.\n" +
                "3. Add the oil, then the cauliflower and garlic.\n" +
                "4. Stir the cauliflower around in the pan, allowing it to get very brown in some parts.\n" +
                "5. Cook for 3 minutes, then turn the heat to low.\n" +
                "6. Add the soy sauce, lime juice and most of the green onions, reserving the rest for serving.\n" +
                "7. Stir and allow to cook for 1 minute, then add the sriracha and stir until incorporated.\n" +
                "8. Add a little more sriracha if you want a deeper color and flavor.\n" +
                "9. Serve hot in a bowl.\n" +
                "10. Sprinkle the remaining green onions on top and serve with lime wedges.";
    }
}

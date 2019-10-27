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

public class MyBreakfastActivity extends AppCompatActivity {

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button10;

    private Button selectButton;

    private String[][] recipeStringBreakfast = new String[10][4];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        loadRecipes();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_breakfast);

        button1 = (Button) findViewById(R.id.ButtonBreakfast1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonShowPopupWindowClick(v, 0);
            }
        });

        button2 = (Button) findViewById(R.id.ButtonBreakfast2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonShowPopupWindowClick(v, 1);
            }
        });

        button3 = (Button) findViewById(R.id.ButtonBreakfast3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonShowPopupWindowClick(v, 2);
            }
        });

        button4 = (Button) findViewById(R.id.ButtonBreakfast4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonShowPopupWindowClick(v, 3);
            }
        });

        button5 = (Button) findViewById(R.id.ButtonBreakfast5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonShowPopupWindowClick(v, 4);
            }
        });

        button6 = (Button) findViewById(R.id.ButtonBreakfast6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonShowPopupWindowClick(v, 5);
            }
        });

        button7 = (Button) findViewById(R.id.ButtonBreakfast7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonShowPopupWindowClick(v, 6);
            }
        });

        button8 = (Button) findViewById(R.id.ButtonBreakfast8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonShowPopupWindowClick(v, 7);
            }
        });

        button9 = (Button) findViewById(R.id.ButtonBreakfast9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonShowPopupWindowClick(v, 8);
            }
        });

        button10 = (Button) findViewById(R.id.ButtonBreakfast10);
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonShowPopupWindowClick(v, 9);
            }
        });


    }


    public void onButtonShowPopupWindowClick(View view, int recipeNum) {

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_my_breakfast, null);



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


        selectButton = popupView.findViewById(R.id.ButtonBreakfastSelect);
        selectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("Breakfast Name", recipeStringBreakfast[num][0]);
                intent.putExtra("Breakfast Nutrition", recipeStringBreakfast[num][1]);
                intent.putExtra("Breakfast Ingredients", recipeStringBreakfast[num][2]);
                intent.putExtra("Breakfast Instructions", recipeStringBreakfast[num][3]);

                setResult(RESULT_OK, intent);
                finish();


            }
        });



        TextView textView = (TextView) popupWindow.getContentView().findViewById(R.id.breakfastRecipeTitle);
        textView.setText(recipeStringBreakfast[recipeNum][0]);

        textView = (TextView) popupWindow.getContentView().findViewById(R.id.breakfastRecipeNutrition);
        textView.setText(recipeStringBreakfast[recipeNum][1]);

        textView = (TextView) popupWindow.getContentView().findViewById(R.id.breakfastRecipeIngredients);
        textView.setText(recipeStringBreakfast[recipeNum][2]);

        textView = (TextView) popupWindow.getContentView().findViewById(R.id.breakfastRecipeInstructions);
        textView.setText(recipeStringBreakfast[recipeNum][3]);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window token
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
        recipeStringBreakfast[0][0] = "Hot Apple Cereal";
        recipeStringBreakfast[1][0] = "Chia Breakfast Pudding";
        recipeStringBreakfast[2][0] = "Sweet Potato Waffles";
        recipeStringBreakfast[3][0] = "Chocolate Fudge Brownie Oatmeal";
        recipeStringBreakfast[4][0] = "Breakfast Sandwich";
        recipeStringBreakfast[5][0] = "Fruit Smoothies";
        recipeStringBreakfast[6][0] = "Oatmeal";
        recipeStringBreakfast[7][0] = "Avocado Toast";
        recipeStringBreakfast[8][0] = "Peanut Banana Cinnamon Smoothie";
        recipeStringBreakfast[9][0] = "Honey Apple Toast";



        recipeStringBreakfast[0][1] = "4 Servings\n" +
                "Per Serving: 380 Calories,\n" +
                "41g carbs, 24g fats, 6g protein";
        recipeStringBreakfast[1][1] = "8 Servings\n" +
                "Per Serving: 193 Calories,\n" +
                "17g carbs, 13g fats, 6g protein";
        recipeStringBreakfast[2][1] = "4 Servings\n" +
                "Per Serving: 271 Calories,\n" +
                "52g carbs, 5g fats, 6g protein";
        recipeStringBreakfast[3][1] = "1 Serving\n" +
                "Per Serving: 353 Calories,\n" +
                "52g carbs, 6g fats, 27g protein";
        recipeStringBreakfast[4][1] = "1 Serving\n" +
                "Per Serving: 388 Calories,\n" +
                "27g carbs, 24g fats, 17g protein";
        recipeStringBreakfast[5][1] = "2 Servings\n" +
                "Per Serving: 366 Calories,\n" +
                "75g carbs, 7g fats, 8g protein";
        recipeStringBreakfast[6][1] = "4 Servings\n" +
                "Per Serving: 300 Calories,\n" +
                "64g carbs, 6g fats, 5g protein";
        recipeStringBreakfast[7][1] = "1 Serving\n" +
                "Per Serving: 407 Calories,\n" +
                "37g carbs, 23g fats, 15g protein";
        recipeStringBreakfast[8][1] = "1 Serving\n" +
                "Per Serving: 401 Calories,\n" +
                "69g carbs, 13g fats, 10g protein";
        recipeStringBreakfast[9][1] = "1 Serving\n" +
                "Per Serving: 538 Calories,\n" +
                "69g carbs, 21g fats, 22g protein";



        recipeStringBreakfast[0][2] = "6 Honeycrisp apples\n" + "1 cup canned coconut milk\n" +
                "2/3 cup roasted cashews\n" +
                "2 tablespoons ground flaxseed\n" +
                "2 teaspoons ground cinnamon\n" +
                "1/2 cup raisins\n";
        recipeStringBreakfast[1][2] = "1 cup of raw cashews\n" +
                "3 cups of water\n" +
                "3 tablespoons maple syrup\n" +
                "1 tablespoon vanilla extract\n" +
                "pinch of salt\n" +
                "1/2 cup chia seeds\n" +
                "additional fruit for toppings\n";
        recipeStringBreakfast[2][2] = "1/2 cup canned sweet potato\n" +
                "1/2 cup milk\n" +
                "1 tablespoon canola oil\n" +
                "1 egg\n" +
                "1 tablespoon honey\n" +
                "1 cup pancake or waffle mix\n" +
                "nonstick spray\n";
        recipeStringBreakfast[3][2] = "1/2 cup rolled oats\n" +
                "2 tablesppons unsweetened dark cocoa powder\n" +
                "3-4 packets Truvia\n" +
                "1 cup milk,15 stevia extract\n" +
                "1 scoop chocolate protein powder\n";
        recipeStringBreakfast[4][2] = "1 large egg\n" +
                "salt\n" +
                "pepper\n" +
                "1 tabespoon vegetable oil\n" +
                "1 buttermilk biscuit\n" +
                "1 slice cheese\n" +
                "2-3 strips cooked bacon\n";
        recipeStringBreakfast[5][2] = "1 frozen banana\n" +
                "2 cups frozen strawberries\n" +
                "1 cup milk\n" +
                "1/2 vanilla yogurt\n" +
                "1/2 cup freshly squeezed orange juice\n" +
                "2 tablespoons honey\n";
        recipeStringBreakfast[6][2] = "1 cup steel cut oats\n" +
                "1 cup dried cranberries\n" +
                "1 cup dried figs\n" +
                "4 cups water\n" +
                "1/2 cup half and half\n";
        recipeStringBreakfast[7][2] = "1 piece of toast\n" +
                "1 avocado\n1 egg\n";
        recipeStringBreakfast[8][2] = "1 cup vanilla soy milk\n" +
                "1 large banana\n" +
                "2 tablespoon peanut butter\n" +
                "1/2 teaspoon cinnamon\n" +
                "3 ice cubes\n";
        recipeStringBreakfast[9][2] = "2 slices wheat bread\n" +
                "1/2 cup ricotta\n" +
                "1 apple sliced\n" +
                "2 teaspoons honey\n";



        recipeStringBreakfast[0][3] = "1. Cut off the sides/cheeks from 1 apple and slice; reserve.\n" +
                "2. Set aside 1/4 cup of the coconut milk.\n" +
                "3. Peel and core the remaining 5 apples and cut into 1-inch chunks.\n" +
                "4. Add the apple chunks, remaining 3/4 cup coconut milk and 2/3 cup water to " +
                "a medium saucepan and bring to a simmer over medium-high heat.\n" +
                "5. Simmer, stirring occasionally, until the liquid is reduced by half and " +
                "the apples are tender and can be easily mashed with a fork, 10 to 12 minutes.\n" +
                "6. Remove from the heat and gently mash the apples, making sure to leave some " +
                "chunks for texture.\n" +
                "7. Meanwhile, pulse the cashews in a food processor until they are completely " +
                "ground and resemble flour (be careful not to make butter).\n" +
                "8. Transfer to a medium bowl and stir in the flaxseed and cinnamon.\n" +
                "9. Fold the cashew-flax mixture and raisins into the mashed apple mixture and stir " +
                "until well combined.\n";
        recipeStringBreakfast[1][3] = "1. Blend all ingredients except chia seeds in a blender until smooth.\n" +
                "2. Add chia seeds and blend lightly.\n" +
                "3. Pour into a large bowl and refrigerate overnight.\n" +
                "4. Serve topped with blueberries, strawberries, raspberries, almonds, cashews, " +
                "sunflower seeds, and raw honey as desired.\n";
        recipeStringBreakfast[2][3] = "1. Place sweet potato, milk, oil, egg, and honey in large bowl and whisk well.\n" +
                "2. Add pancake or waffle mix and stir with a wooden spoon until most of the lumps " +
                "have disappeared and there are no dry spots.\n" +
                "3. Heat a waffle iron and coat with cooking spray.\n" +
                "4. Cook batter according to the manufacturer’s instructions and serve immediately, " +
                "or cool on a wire rack and store in the fridge for up to three days, " +
                "or transfer to a resealable bag and freeze for up to six months.\n";
        recipeStringBreakfast[3][3] = "1. Put oats, cocoa, and Truvia into a large, microwave-safe bowl.\n" +
                "2. Pour in 3/4 cup milk and stir until it’s a thick sludge.\n" +
                "3. Microwave for 2 minutes and 10 to 30 seconds. (Add another 20 to 30 seconds if " +
                "you like soft oatmeal or 40 to 50 seconds longer if you like porridge)\n" +
                "4. Mix remaining milk, stevia extract, and protein powder in a glass with a spoon, " +
                "stirring and pressing on any clumps until dissolved.\n" +
                "5. Pour over oatmeal and stir until all is incorporated.\n";
        recipeStringBreakfast[4][3] = "1. Preheat the oven to 350 degrees.\n" +
                "2. Crack egg into a bowl and whip with a fork until yolk and whites are completely combined.\n" +
                "3. Season with salt and pepper to taste.\n" +
                "4. Heat oil in a skillet over medium heat.\n" +
                "5. When small bubbles start to form, carefully pour egg into the pan, " +
                "gently tilting the pan to cover the entire bottom with a thin layer of egg.\n" +
                "6. When egg bottom is firm, use a spatula to fold up the sides and form a square.\n" +
                "7. Flip and cook on the other side.\n" +
                "8. Lay egg square on bottom of biscuit and top with cheese, bacon, and other biscuit top.\n" +
                "9. Place sandwich on a baking sheet and stick in the oven for about 5 minutes or until cheese is fully melted.\n";
        recipeStringBreakfast[5][3] = "1. Put all the ingredients in a blender and process until smooth.\n" +
                "2. Pour into glasses and serve.\n" +
                "Cook's note: For non-dairy smoothies, substitute 1 cup rice milk for the milk and yogurt. " +
                "Or, use soy yogurt or milk instead of dairy.\n";
        recipeStringBreakfast[6][3] = "1. In a slow cooker, combine all ingredients and set to low heat.\n" +
                "2. Cover and let cook for 8 to 9 hours.\n" +
                "3. Stir and remove to serving bowls.\n" +
                "Cook's note: This method works best if started before you go to bed. " +
                "This way your oatmeal will be finished by morning.\n";
        recipeStringBreakfast[7][3] = "1. Simply poach the egg, mash the avocado, and top it all on a fresh " +
                "piece of whole wheat toast.\n";
        recipeStringBreakfast[8][3] = "1. Place the milk, banana, peanut butter, cinnamon, and honey (if using) " +
                "into a blender, and puree until smooth.\n" +
                "2. Add the ice cubes and pulse just until the ice is crushed.\n" +
                "3. Pour into a glass, sprinkle with additional cinnamon.\n";
        recipeStringBreakfast[9][3] = "1. Toast the bread to your desired toastiness.\n" +
                "2. Let it cool slightly.\n" +
                "3. Spread half of the ricotta on each piece of toast.\n" +
                "4. Spread half of the thin apple slices over the ricotta cheese.\n";

    }
}

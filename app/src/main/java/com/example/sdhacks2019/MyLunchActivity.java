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

public class MyLunchActivity extends AppCompatActivity {

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;

    private Button selectButton;

    private String[][] recipeStringLunch = new String[7][4];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        loadRecipes();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_lunch);

        button1 = (Button) findViewById(R.id.ButtonLunch1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonShowPopupWindowClick(v, 0);
            }
        });

        button2 = (Button) findViewById(R.id.ButtonLunch2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonShowPopupWindowClick(v, 1);
            }
        });

        button3 = (Button) findViewById(R.id.ButtonLunch3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonShowPopupWindowClick(v, 2);
            }
        });

        button4 = (Button) findViewById(R.id.ButtonLunch4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonShowPopupWindowClick(v, 3);
            }
        });

        button5 = (Button) findViewById(R.id.ButtonLunch5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonShowPopupWindowClick(v, 4);
            }
        });

        button6 = (Button) findViewById(R.id.ButtonLunch6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonShowPopupWindowClick(v, 5);
            }
        });

        button7 = (Button) findViewById(R.id.ButtonLunch7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonShowPopupWindowClick(v, 6);
            }
        });


    }

    public void openDailyMenu() {
        //Intent intent = new Intent(this, DailyActivity.class);
        //startActivity(intent);
        super.finish();
    }

    public void onButtonShowPopupWindowClick(View view, int recipeNum) {

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_my_lunch, null);



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

        selectButton = popupView.findViewById(R.id.ButtonLunchSelect);
        selectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("Lunch Name", recipeStringLunch[num][0]);
                intent.putExtra("Lunch Nutrition", recipeStringLunch[num][1]);
                intent.putExtra("Lunch Ingredients", recipeStringLunch[num][2]);
                intent.putExtra("Lunch Instructions", recipeStringLunch[num][3]);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        TextView textView = (TextView) popupWindow.getContentView().findViewById(R.id.LunchRecipeTitle);
        textView.setText(recipeStringLunch[recipeNum][0]);

        textView = (TextView) popupWindow.getContentView().findViewById(R.id.LunchRecipeNutrition);
        textView.setText(recipeStringLunch[recipeNum][1]);

        textView = (TextView) popupWindow.getContentView().findViewById(R.id.LunchRecipeIngredients);
        textView.setText(recipeStringLunch[recipeNum][2]);

        textView = (TextView) popupWindow.getContentView().findViewById(R.id.LunchRecipeInstructions);
        textView.setText(recipeStringLunch[recipeNum][3]);

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
        recipeStringLunch[0][0] = "Fettuccini Alfredo";
        recipeStringLunch[1][0] = "Kale Salad";
        recipeStringLunch[2][0] = "BBQ Chicken Cobb Salad";
        recipeStringLunch[3][0] = "Orange Salad";
        recipeStringLunch[4][0] = "Hummus Quinoa Cakes";
        recipeStringLunch[5][0] = "Prosciutto Sandwich";
        recipeStringLunch[6][0] = "Brussels Sprouts";



        recipeStringLunch[0][1] = "3 Servings\n" +
                "Per Serving: 490 Calories,\n" +
                "66g carbs, 15g fats, 20g protein";
        recipeStringLunch[1][1] = "1 Serving\n" +
                "Per Serving: 211 Calories,\n" +
                "31g carbs, 7g fats, 11g protein";
        recipeStringLunch[2][1] = "2 Servings\n" +
                "Per Serving: 280 Calories,\n" +
                "19g carbs, 10g fats, 28g protein";
        recipeStringLunch[3][1] = "1 Serving\n" +
                "Per Serving: 264 Calories,\n" +
                "43g carbs, 15g fats, 4g protein";
        recipeStringLunch[4][1] = "3 Servings\n" +
                "Per Serving: 333 Calories,\n" +
                "43g carbs, 14g fats, 11g protein";
        recipeStringLunch[5][1] = "2 Servings\n" +
                "Per Serving: 379 Calories,\n" +
                "45g carbs, 14g fats, 23g protein";
        recipeStringLunch[6][1] = "2 Servings\n" +
                "Per Serving: 109 Calories,\n" +
                "10g carbs, 7g fats, 4g protein";


        recipeStringLunch[0][2] = "1 tablespoon unsalted butter\n" +
                "1 clove minced garlic\n" +
                "1 teaspoon lemon zest\n" +
                "2 teaspoons all-purpose flour\n" +
                "1 cup low-fat milk,kosher salt\n" +
                "2 tablespoon cream cheese\n" +
                "3/4 cup grated parmesan cheese\n" +
                "3 tablespoons chopped parsley\n" +
                "12 ounces fettuccine,ground pepper\n";
        recipeStringLunch[1][2] = "1 cup shredded kale\n" +
                "1/4 chopped shiitake mushrooms\n" +
                "2 tablespoons golden raisins\n" +
                "1 tablespoon chopped cashews\n" +
                "1/4 cup alfalfa sprouts\n" +
                "3 ounces silken tofu,fresh lemon juice\n";
        recipeStringLunch[2][2] = "3 ounces boneles chicken\n" +
                "2 tablespoons bbq sauce\n" +
                "2 slices turkey bacon\n" +
                "1 1/2 cups chopped romaine lettuce\n" +
                "1 hardboiled egg white\n" +
                "1/4 cup chopped grape tomatoes\n" +
                "1/4 chopped avocado\n";
        recipeStringLunch[3][2] = "5 large oranges sliced and peeled\n" +
                "1/2 sliced red onions\n" +
                "1/4 cup minced tarragonleaves\n" +
                "1/2 cup chopped picholine olives\n" +
                "1/4 cup olive oil,salt\n";
        recipeStringLunch[4][2] = "1 cup cooked quinoa\n" +
                "1/2 cup hummus\n" +
                "1/2 cup minced red pepper\n" +
                "2 celery stalks minced\n" +
                "2 scallions\n" +
                "salt\n" +
                "pepper\n" +
                "1/2 tablespoon olive oil\n" +
                "tomato slices\n";
        recipeStringLunch[5][2] = "1 ciabatta roll\n" +
                "1/2 tablespoon fig preserve\n" +
                "2 slices prosciutton\n" +
                "1 thin manchego cheese\n" +
                "2 cups spinach\n";
        recipeStringLunch[6][2] = "1 1/2 pounds Brussels sprouts\n" +
                "3 tablespoons olive oil\n" +
                "3/4 teaspoon salt\n" +
                "1/2 teaspoon pepper\n";


        recipeStringLunch[0][3] = "1. Make the sauce: Melt the butter in a skillet over medium heat.\n" +
                "2. Add the garlic and lemon zest and cook until the garlic is slightly soft, about 1 minute.\n" +
                "3. Add in the flour and cook, stirring with a wooden spoon,1 minute.\n" +
                "4. Whisk in the milk and 3/4 teaspoon salt and cook, whisking constantly, " +
                "until just thickened, about 3 minutes.\n" +
                "5. Add the Neufchatel and parmesan cheese; whisk until melted, about 1 minute.\n" +
                "6. Stir in the chopped parsley.\n" +
                "7. Meanwhile, bring a large pot of salted water to a boil.\n" +
                "8. Add the fettuccine and cook until al dente, 2 to 3 minutes.\n" +
                "9. Reserve 1 cup cooking water, then drain the pasta and return to the pot.\n" +
                "10. Add the sauce and 1/2 cup of the reserved cooking water to the pasta and " +
                "gently toss to combine, adding more cooking water as needed to loosen.\n" +
                "11. Season with salt.\n" +
                "12. Divide among bowls and top with parmesan and pepper.\n";
        recipeStringLunch[1][3] = "1. Combine first six ingredients.\n" +
                "2. Top with lemon juice for dressing, if desired.\n";
        recipeStringLunch[2][3] = "1.Preheat the oven to 350 degrees.\n" +
                "2. Brush chicken with 1 tablespoon barbecue sauce and place in small baking dish " +
                "sprayed with nonstick spray.\n" +
                "3. Bake for 25 minutes or until chicken reaches 165 degrees or there is no pink inside.\n" +
                "4. Meanwhile cook bacon according to package directions.\n" +
                "5. Place romaine in a bowl or on a plate, top with other ingredients, " +
                "and drizzle with remaining tablespoon of barbecue sauce.\n";
        recipeStringLunch[3][3] = "1. Toss all ingredients together, season as needed, and serve immediately.\n";
        recipeStringLunch[4][3] = "1. In a medium bowl\n" +
                "2. Combine quinoa, hummus, red pepper, celery, and scallions.\n" +
                "3. Season with salt and pepper.\n" +
                "4. Heat a non-stick pan over medium-high heat and add olive oil once heated.\n" +
                "5. Form quinoa mixture into palm-sized patties and brown in pan, working in batches, " +
                "about 3 to 4 minutes per side.\n" +
                "6. Be careful not to overcrowd the pan.\n" +
                "7. Serve with additional hummus and tomato slices.\n";
        recipeStringLunch[5][3] = "Preheat the oven to 350 degrees.\n" +
                "2. Slather top half of ciabatta with fig preserve.\n" +
                "3. Layer prosciutto and cheese on bottom half of bread.\n" +
                "4. In a pan or skillet, saute spinach over medium-high heat until leaves are wilted, about 2 minutes.\n" +
                "5. Spoon spinach on top of cheese and cover with other half of ciabatta, pressing down firmly.\n" +
                "6. Place sandwich on a baking sheet and stick it in the oven for about 2 to 3 minutes.\n" +
                "7. Remove from the oven, slice in half, and eat immediately.\n";
        recipeStringLunch[6][3] = "1. Preheat oven to 400 degrees F.\n" +
                "2. Cut off the brown ends of the Brussels sprouts and pull off any yellow outer leaves.\n" +
                "3. Mix them in a bowl with the olive oil, salt and pepper.\n" +
                "4. Pour them on a sheet pan and roast for 35 to 40 minutes, " +
                "until crisp on the outside and tender on the inside.\n" +
                "5. Shake the pan from time to time to brown the sprouts evenly.\n" +
                "6. Sprinkle with more kosher salt ( I like these salty like French fries), and serve immediately.\n";
    }
}

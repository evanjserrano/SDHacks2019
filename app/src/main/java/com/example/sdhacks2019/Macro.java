package com.example.sdhacks2019;

public class Macro {
    float carb;
    float fat;
    float protein;

    Macro(float inCarb, float inFat, float inProtein) {
        carb = inCarb;
        fat = inFat;
        protein = inProtein;
    }

    void setCarb(float inCarb) {
        carb = inCarb;
    }

    float getCarb() {
        return carb;
    }

    void setFat(float inFat) {
        fat = inFat;
    }

    float getFat() {
        return fat;
    }

    void setProtein(float inProtein) {
        protein = inProtein;
    }

    float getProtein() {
        return protein;
    }
}

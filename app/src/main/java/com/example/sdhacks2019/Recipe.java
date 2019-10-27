package com.example.sdhacks2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.lang.*;
import java.lang.String;

class Recipe {
    String name;
    int calories;
    ArrayList<String> ingredients;
    ArrayList<String> shopping;
    ArrayList<String> instructions;
    Macro macros;

    Recipe() {
        name = null;
        calories = 0;
        ingredients = null;
        shopping = null;
        instructions = null;
        macros = new Macro(0, 0, 0);
    }

    void setName(String inName) {
        name = inName;
    }

    String getName() {
        return name;
    }

    void setCalories(int inCalories) {
        calories = inCalories;
    }

    int getCalories() {
        return calories;
    }

    void setIngredients(ArrayList<String> inIngredients) {
        ingredients = inIngredients;
    }

    void setIngredients(String line) {
        String values[] = line.split(",");
        ingredients = new ArrayList<String>(Arrays.asList(values));
    }

    ArrayList<String> getIngredients() {
        return ingredients;
    }

    void setShopping(ArrayList<String> inShopping) {
        shopping = inShopping;
    }

    void setShopping(String line) {
        String values[] = line.split(",");
        shopping = new ArrayList(Arrays.asList(values));
    }

    ArrayList<String> getShopping() {
        return shopping;
    }

    void setInstructions(ArrayList<String> inInstructions) {
        instructions = inInstructions;
    }

    ArrayList<String> getInstructions() {
        return instructions;
    }

    void setMacros(Macro inMacros) {
        macros = inMacros;
    }

    void setMacros(String line) {
        String values[] = line.split(",");
        macros.setCarb(Float.parseFloat(values[0]));
        macros.setFat(Float.parseFloat(values[1]));
        macros.setProtein(Float.parseFloat(values[2]));
    }

    Macro getMarcos() {
        return macros;
    }

    void addInstructions(String line) {
        instructions.add(line);
    }
}

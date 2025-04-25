package com.example.eatgreen;

public class DishList {
    private final String name;
    private final String ingredients;
    private final String price;
    private final String allergens;
    private final String calories;
    private final String description;  // Added description
    private final int imageResId;      // Added image resource ID

    // Updated constructor
    public DishList(String name, String ingredients, String price, String allergens, String calories, String description, int imageResId) {
        this.name = name;
        this.ingredients = ingredients;
        this.price = price;
        this.allergens = allergens;
        this.calories = calories;
        this.description = description;
        this.imageResId = imageResId;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getPrice() {
        return price;
    }

    public String getAllergens() {
        return allergens;
    }

    public String getCalories() {
        return calories;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResId() {
        return imageResId;
    }
}




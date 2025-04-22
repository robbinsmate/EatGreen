package com.example.eatgreen;

public class DishList {
    private String name;
    private String ingredients;
    private String price;
    private String allergens;
    private String calories;
    private String description;  // Added description
    private int imageResId;      // Added image resource ID

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




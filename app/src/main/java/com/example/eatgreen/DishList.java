package com.example.eatgreen;

public class DishList {
    private String name;
    private String ingredients;
    private String price;
    private String allergens;
    private String calories;

    public DishList(String name, String ingredients, String price, String allergens, String calories) {
        this.name = name;
        this.ingredients = ingredients;
        this.price = price;
        this.allergens = allergens;
        this.calories = calories;
    }

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
}


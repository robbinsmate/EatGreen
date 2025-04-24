package com.example.eatgreen;

import java.util.ArrayList;

public class DishCounter {
    private static DishCounter instance;
    private ArrayList<DishList> dishes;

    private DishCounter() {
        dishes = new ArrayList<>();
    }

    public static DishCounter getInstance() {
        if (instance == null) {
            instance = new DishCounter();
        }
        return instance;
    }

    public void addDish(DishList dish) {
        dishes.add(dish);
    }

    public ArrayList<DishList> getDishes() {
        return dishes;
    }

    public void clearItems() {
        dishes.clear();
    }
}

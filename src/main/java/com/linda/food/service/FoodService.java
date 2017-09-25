package com.linda.food.service;

import com.linda.food.model.Ingredient;

public interface FoodService {

    Iterable<Ingredient>findAll();
}

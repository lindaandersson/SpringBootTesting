package com.linda.food.service;

import com.linda.food.model.Ingredient;

public interface FoodService {

    Ingredient save(Ingredient ingredient);
    void delete(Ingredient ingredient);
    Ingredient findOne(String id);
    Iterable<Ingredient>findAll();
    Iterable<Ingredient>findByName(String name);
}

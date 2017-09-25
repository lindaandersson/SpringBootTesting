package com.linda.food.service;

import com.linda.food.model.Ingredient;
import com.linda.food.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Override
    public Ingredient save(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    @Override
    public void delete(Ingredient ingredient) {
        ingredientRepository.delete(ingredient);
    }

    @Override
    public Ingredient findOne(String id) {
        return ingredientRepository.findOne(id);
    }

    @Override
    public Iterable<Ingredient> findAll() {
        return ingredientRepository.findAll();
    }

    @Override
    public Iterable<Ingredient> findByName(String name) {
        return ingredientRepository.findByName(name);
    }
}

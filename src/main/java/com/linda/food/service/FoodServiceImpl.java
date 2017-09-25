package com.linda.food.service;

import com.linda.food.model.Ingredient;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {

    static private List<Ingredient> ingredient = Arrays.asList(
            new Ingredient("1", "orange"),
            new Ingredient("1", "banana")
    );

    @Override
    public Iterable<Ingredient> findAll() {
        return ingredient;
    }
}

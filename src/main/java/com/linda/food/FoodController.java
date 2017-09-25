package com.linda.food;

import com.google.common.collect.Lists;
import com.linda.food.model.Ingredient;
import com.linda.food.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @RequestMapping(method = RequestMethod.POST)
    public void post(@RequestBody Ingredient ingredient) {
        foodService.save(ingredient);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(@RequestBody Ingredient ingredient) {
        foodService.delete(ingredient);
    }

    @RequestMapping("/{id}")
    public Ingredient get(@PathVariable("id") String id) {
        return foodService.findOne(id);
    }

    @RequestMapping("/list")
    public List<Ingredient> list(@RequestParam(name = "name", defaultValue = "") String name) {
        if (name.isEmpty()) {
            return Lists.newArrayList(foodService.findAll());
        }
        return Lists.newArrayList(foodService.findByName(name));
    }
}

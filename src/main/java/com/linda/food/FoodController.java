package com.linda.food;


import com.linda.food.model.Ingredience;
import com.linda.food.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @RequestMapping("/list")
    public Iterable<Ingredience> list() {
        return foodService.findAll();
    }
}

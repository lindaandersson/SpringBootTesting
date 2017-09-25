package com.linda.food;

import com.google.common.collect.Lists;
import com.linda.food.model.Ingredient;
import com.linda.food.service.FoodService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class FoodServiceTest {

    @Autowired
    private FoodService ingredientService;

    @Autowired
    private ElasticsearchTemplate esTemplate;

    @Before
    public void before() {
        esTemplate.deleteIndex(Ingredient.class);
        esTemplate.createIndex(Ingredient.class);
        esTemplate.putMapping(Ingredient.class);
        esTemplate.refresh(Ingredient.class);
    }

    @Test
    public void testSave() {

        Ingredient ingredient = new Ingredient("1", "Orange");
        Ingredient testIngredient = ingredientService.save(ingredient);

        assertNotNull(testIngredient.getId());
        assertEquals(testIngredient.getName(), ingredient.getName());
    }

    @Test
    public void testFindOne() {

        Ingredient ingredient = new Ingredient("1", "Orange");
        ingredientService.save(ingredient);

        Ingredient testIngredient = ingredientService.findOne(ingredient.getId());

        assertNotNull(testIngredient.getId());
        assertEquals(testIngredient.getName(), ingredient.getName());

    }

    @Test
    public void testFindByName() {

        ingredientService.save(new Ingredient("1", "Orange"));
        ingredientService.save(new Ingredient("2", "Apple"));

        List<Ingredient> byTitle = Lists.newArrayList(ingredientService.findByName("Orange"));
        assertThat(byTitle.size(), is(1));
    }

    @Test
    public void testDelete() {

        Ingredient ingredient = new Ingredient("1", "Orange");
        ingredientService.save(ingredient);
        ingredientService.delete(ingredient);
        Ingredient testIngredient = ingredientService.findOne(ingredient.getId());
        assertNull(testIngredient);
    }

}
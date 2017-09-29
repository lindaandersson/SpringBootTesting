package com.linda.food;

import com.linda.food.model.Ingredient;
import com.linda.food.service.FoodService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FoodControllerTest {

    private MockMvc mockMvc;
    @Mock
    private FoodService foodService;

    @InjectMocks
    private FoodController foodController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(foodController).build();
    }

    @Test
    public void getOne() throws Exception {
        Ingredient ingredient = new Ingredient("4", "ananas");

        when(foodService.findOne("4")).thenReturn(ingredient);
        this.mockMvc.perform(get("/food/4").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"id\":\"4\",\"name\":\"ananas\"}"));
    }

    @Test
    public void getAll() throws Exception {
        Iterable<Ingredient> iterable = Arrays.asList(new Ingredient("4", "ananas"));

        when(foodService.findAll()).thenReturn(iterable);
        this.mockMvc.perform(get("/food/list").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(content().string("[{\"id\":\"4\",\"name\":\"ananas\"}]"));
    }

    @Test
    public void getByName() throws Exception {
        Iterable<Ingredient> iterable = Arrays.asList(new Ingredient("4", "ananas"));

        when(foodService.findByName("ananas")).thenReturn(iterable);
        this.mockMvc.perform(get("/food/list?name=ananas").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(content().string("[{\"id\":\"4\",\"name\":\"ananas\"}]"));
    }
}

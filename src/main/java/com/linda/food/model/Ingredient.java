package com.linda.food.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "food", type = "ingredient")
public class Ingredient {

    @Id
    private String id;
    private String name;

    public Ingredient(){
    }

    public Ingredient(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

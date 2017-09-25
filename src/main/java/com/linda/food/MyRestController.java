package com.linda.food;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/test/")
    String getRequestParam(@RequestParam(value = "param")String param){
        return "Request param was: " + param;
    }

    @RequestMapping("/test/{path}")
    String getPathVariable(@PathVariable("path") String path){
        return "Path variable was: " + path;
    }
}

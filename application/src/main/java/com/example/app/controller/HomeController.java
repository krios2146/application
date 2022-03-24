package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class HomeController {

    @GetMapping
    public String main(Map<String, Object> model) {
        model.put("hello", "Hello, World!");
        return "home";
    }
}

package com.example.service;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import io.opentracing.Tracer;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping("/fruits")
public class FruitController {

    private List<Fruit> fruits = new ArrayList<>();

    @Autowired
    private Tracer tracer;


    @GetMapping
    public String home(Model model) {

        // TODO: Add tracing here

        model.addAttribute("fruits", fruits);     // For the List view
        model.addAttribute("fruitForm", new Fruit()); // For the Form
        return "home";
    }

    @PostMapping
    public String createFruit(@ModelAttribute Fruit fruit) {
        fruits.add(fruit);
        return "redirect:/fruits";
    }
}

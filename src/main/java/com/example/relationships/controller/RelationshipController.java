package com.example.relationships.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class RelationshipController {

    @GetMapping
    public String greetings () {
        return "HOLA - HELLO";
    }


}

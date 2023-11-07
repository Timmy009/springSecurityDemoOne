package com.example.demo.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DEmoController {

    @GetMapping ("/demo")
    public String demo () {
        return "demo!";
    }
}

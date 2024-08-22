package com.example.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//Создание Spring MVC контроллера
@Controller
public class GfgController {

    @GetMapping("/elmaz")
    public String helloGfg() {
        return "hello-elmaz";
    }
}

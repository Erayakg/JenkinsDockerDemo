package com.dockerDemo.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Controller {

    @GetMapping
    public String deneme(){
        return "deneme sezer";
    }
    @GetMapping
    public String deneme2(){
        return "denemeasdas";
    }


}

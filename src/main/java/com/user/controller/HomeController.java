package com.user.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class HomeController {

    @GetMapping
    public String homeControllerHandler(){

        return "Jai Shree Ram  Welcome to Salon Appointmrnt Application";
    }

}

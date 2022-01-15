package com.bscinf2019.Online.Restaurant.Website.Application.restaurant;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OnlineFoodOrderingController {
    @GetMapping("/")
    public String hello(){
        return "Hello World";
    }
}

package com.java.microservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/staff")
public class StaffController {


    @GetMapping
    public String SayHelloStaff(){
        return "Hello staff back to worked...!!!";
    }


}

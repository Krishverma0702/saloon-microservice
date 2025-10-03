package com.project.saloonApplication.controller;

import com.project.saloonApplication.model.User;
import com.project.saloonApplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaloonController {


    @GetMapping("/hello")
    public String saloonControllerHandler(){
        return "User microservies";
    }
}

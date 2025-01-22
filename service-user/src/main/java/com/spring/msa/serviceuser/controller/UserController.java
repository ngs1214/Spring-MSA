package com.spring.msa.serviceuser.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {

    @Value("${server.port}")
    private String port;

    @GetMapping
    public String index() {
        return "userController" + port;
    }
}

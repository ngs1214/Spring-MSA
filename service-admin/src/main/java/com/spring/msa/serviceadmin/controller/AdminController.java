package com.spring.msa.serviceadmin.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin")
public class AdminController {

    @Value("${server.port}")
    private String port;

    @GetMapping
    public String index() {
        return "Admin Controller" + port;
    }
}

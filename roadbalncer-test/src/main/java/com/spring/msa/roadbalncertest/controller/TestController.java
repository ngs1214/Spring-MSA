package com.spring.msa.roadbalncertest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin")
public class TestController {

    @GetMapping
    public String test() {
        return "test";
    }
}

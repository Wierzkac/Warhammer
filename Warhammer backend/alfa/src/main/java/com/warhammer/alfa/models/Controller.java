package com.warhammer.alfa.models;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("abilities")
public class Controller {

    @GetMapping("/{id}")
    public String getTestString(@PathVariable int id) {
        return "Return string number: " + id;
    }
}
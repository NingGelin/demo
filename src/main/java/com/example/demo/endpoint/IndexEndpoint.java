package com.example.demo.endpoint;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexEndpoint {
    @GetMapping("")
    public String index()
    {
        return "index";
    }
}

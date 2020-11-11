package com.example.demo.endpoint;

import com.example.demo.model.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DemoEndpoint {
    private static final Logger logger = LoggerFactory.getLogger(DemoEndpoint.class);

    @GetMapping("/test")
    public ApiResponse test(@RequestParam() String state)
    {
        return new ApiResponse();
    }

    @GetMapping("/test1")
    public ApiResponse test1()
    {
        return new ApiResponse("查询失败",80001);
    }

    @GetMapping("/test2")
    public ApiResponse test2()
    {
        return new ApiResponse("hello");
    }
}

package com.example.demo.endpoint;

import com.example.demo.aspect.WebLog;
import com.example.demo.model.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
public class DemoEndpoint
{
    private static final Logger logger = LoggerFactory.getLogger(DemoEndpoint.class);

    @WebLog
    @GetMapping("test")
    public ApiResponse test()
    {
        return new ApiResponse();
    }
}

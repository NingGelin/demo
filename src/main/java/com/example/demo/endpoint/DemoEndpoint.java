package com.example.demo.endpoint;

import com.example.demo.model.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
public class DemoEndpoint {
    private static final Logger logger = LoggerFactory.getLogger(DemoEndpoint.class);

    @GetMapping("test")
    public ApiResponse test()
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
        logger.info("hello world");
        Map<String, String> map = new HashMap<>();
        map.put("111", "hello");
        map.put("222", "world");
        return new ApiResponse(map);
    }

    @RequestMapping("/hello")
    public String helloJsp(Model model){
        System.out.println("HelloController.helloJsp().hello=hello");
        model.addAttribute("hello", "你好");
        return "hello";
    }
}

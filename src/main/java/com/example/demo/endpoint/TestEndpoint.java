package com.example.demo.endpoint;

import com.example.demo.model.ApiResponse;
import com.example.demo.model.request.UserInfo;
import com.example.demo.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Validated
public class TestEndpoint
{
    public static final Logger logger = LoggerFactory.getLogger(TestEndpoint.class);

    @GetMapping("/test")
    public ApiResponse test()
    {
        return new ApiResponse();
    }

    @GetMapping("/testParamValid")
    public ApiResponse testParamValid(@RequestParam(value = "id") String id, @RequestParam(value = "name") String name)
    {
        return new ApiResponse(id + " " + name);
    }

    @PostMapping("/testParamValid")
    public ApiResponse testParamValid(@Valid @RequestBody UserInfo userinfo)
    {
        logger.info("userInfo: {}", JsonUtil.obj2String(userinfo));
        logger.info("userInfo: {}", userinfo.toString());
        return new ApiResponse();
    }
}

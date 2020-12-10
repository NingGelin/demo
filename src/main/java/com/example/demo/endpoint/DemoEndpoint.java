package com.example.demo.endpoint;

import com.example.demo.aspect.WebLog;
import com.example.demo.model.ApiResponse;
import com.example.demo.model.request.BooleanRequest;
import com.example.demo.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;


@RestController
public class DemoEndpoint {
    private static final Logger logger = LoggerFactory.getLogger(DemoEndpoint.class);

    @WebLog
    @CrossOrigin
    @GetMapping("test")
    public ApiResponse test()
    {
        return new ApiResponse();
    }

    @WebLog
    @PostMapping("/testBoolean")
    public ApiResponse testBoolean(@RequestBody BooleanRequest request)
    {
        logger.info(JsonUtil.obj2String(request));
        String aaa = JsonUtil.obj2String(request);
        logger.info(JsonUtil.string2obj(aaa, BooleanRequest.class).getNode());
        return new ApiResponse();
    }
}

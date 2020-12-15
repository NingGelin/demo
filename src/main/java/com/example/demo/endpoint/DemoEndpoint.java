package com.example.demo.endpoint;

import com.example.demo.aspect.WebLog;
import com.example.demo.dao.SkuPriceRepository;
import com.example.demo.entity.SkuPrice;
import com.example.demo.model.ApiResponse;
import com.example.demo.model.request.BooleanRequest;
import com.example.demo.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DemoEndpoint {
    private static final Logger logger = LoggerFactory.getLogger(DemoEndpoint.class);

    @Autowired
    private SkuPriceRepository skuPriceRepository;

    @WebLog
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

    @WebLog
    @PostMapping("config/skuPriceSearch")
    public ApiResponse skuPriceSearch()
    {
        SkuPrice skuPrice = skuPriceRepository.getOne("1");
        return new ApiResponse(skuPrice);
    }
}

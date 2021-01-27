package com.example.demo.endpoint;

import com.example.demo.dao.SkuConfigRepository;
import com.example.demo.dao.SkuPriceRepository;
import com.example.demo.entity.SkuConfig;
import com.example.demo.model.ApiResponse;
import com.example.demo.model.response.BaiduAddressParseInfo;
import com.example.demo.model.response.BaiduAddressParseResponse;
import com.example.demo.util.JsonUtil;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@RestController
@CrossOrigin
public class DemoEndpoint
{
    private static final Logger logger = LoggerFactory.getLogger(DemoEndpoint.class);

    @Autowired
    private SkuPriceRepository skuPriceRepository;

    @Autowired
    private SkuConfigRepository skuConfigRepository;

    private Executor executor = new ThreadPoolExecutor(100,200,0L,
            TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(1024),
            new ThreadFactoryBuilder().setNameFormat("pool-%d").build(),
            new ThreadPoolExecutor.AbortPolicy());

    @GetMapping("test")
    public ApiResponse test()
    {
        SkuConfig skuConfig = skuConfigRepository.findBySkuId("000");
        return new ApiResponse(skuConfig);
    }

    @GetMapping("test2")
    public ApiResponse test2(@RequestParam Map<String, Object> param)
    {
        executor.execute(() -> buildMessage());
        return new ApiResponse();
    }

    @GetMapping("addressParse1")
    public BaiduAddressParseResponse addressParse1(@RequestParam() String addressInfo)
    {
        logger.info(addressInfo);
        addressInfo = "宁格林15661010920陕西西安雁塔区清华科技园E座";
        String url = "https://ai.baidu.com/aidemo";
        HttpClient httpClient = new HttpClient();
        PostMethod postMethod = new PostMethod(url);
        postMethod.addParameter("apiType", "nlp");
        postMethod.addParameter("type", "address");
        postMethod.addParameter("text", addressInfo);
        httpClient.getParams().setContentCharset("UTF-8");

        String res = "";
        try {
            int code = httpClient.executeMethod(postMethod);
            if (code == 200){
                res = postMethod.getResponseBodyAsString();
                System.out.println(res);
                BaiduAddressParseResponse baiduAddressParseResponse = JsonUtil.string2obj(res, BaiduAddressParseResponse.class);
                BaiduAddressParseInfo baiduAddressParseInfo = JsonUtil.string2obj(JsonUtil.obj2String(baiduAddressParseResponse.getData()), BaiduAddressParseInfo.class);
                return baiduAddressParseResponse;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("addressParse2")
    public String addressParse2(@RequestParam() String addressInfo)
    {
        String url = "https://wangzc.wang/smAddress";
        HttpClient httpClient = new HttpClient();
        PostMethod postMethod = new PostMethod(url);
        postMethod.addParameter("address", addressInfo);
        httpClient.getParams().setContentCharset("UTF-8");
        NameValuePair param = new NameValuePair("address", addressInfo);
        NameValuePair[] parametersBody = {param};
        postMethod.setRequestBody(parametersBody);

        String res = "";
        try {
            int code = httpClient.executeMethod(postMethod);
            if (code == 200) {
                res = postMethod.getResponseBodyAsString();
                System.out.println(res);
                return res;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }



    private void buildMessage()
    {
        try
        {
            logger.info("1");
            TimeUnit.SECONDS.sleep(20L);
            logger.info("2");
        }
        catch (Exception e)
        {
            logger.info("sleep error");
        }
    }
}

package com.example.demo;

import com.baidu.aip.nlp.AipNlp;
import com.example.demo.model.response.BaiduAddressParseInfo;
import com.example.demo.model.response.BaiduAddressParseResponse;
import com.example.demo.util.JsonUtil;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;

public class BaiduTest
{
    public static void main(String[] args) {
        baiduApi();
    }

    private static void baiduApi()
    {
        String url = "https://ai.baidu.com/aidemo";
        HttpClient httpClient = new HttpClient();
        PostMethod postMethod = new PostMethod(url);
        postMethod.addParameter("apiType", "nlp");
        postMethod.addParameter("type", "address");
        postMethod.addParameter("text", "宁格林 15661010920 陕西西安雁塔区清华科技园E座");

        String res = "";
        try {
            int code = httpClient.executeMethod(postMethod);
            if (code == 200){
                res = postMethod.getResponseBodyAsString();
                System.out.println(res);
                BaiduAddressParseResponse baiduAddressParseResponse = JsonUtil.string2obj(res, BaiduAddressParseResponse.class);
                BaiduAddressParseInfo baiduAddressParseInfo = JsonUtil.string2obj(baiduAddressParseResponse.getText(), BaiduAddressParseInfo.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * post请求
     * @param url
     * @param json
     * @return
     */
    public static String doPost(String url, JSONObject json){
        HttpClient httpClient = new HttpClient();
        PostMethod postMethod = new PostMethod(url);

        postMethod.addRequestHeader("accept", "*/*");
        postMethod.addRequestHeader("connection", "Keep-Alive");
        //设置json格式传送
        postMethod.addRequestHeader("Content-Type", "application/json;charset=GBK");
        //必须设置下面这个Header
        postMethod.addRequestHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.81 Safari/537.36");
        //添加请求参数
        postMethod.addParameter("apiType", json.getString("apiType"));
        postMethod.addParameter("type", json.getString("type"));
        postMethod.addParameter("text", json.getString("text"));

        String res = "";
        try {
            int code = httpClient.executeMethod(postMethod);
            if (code == 200){
                res = postMethod.getResponseBodyAsString();
                System.out.println(res);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }



    private static RestTemplate restTemplate = new RestTemplate();



    private static void getAddress()
    {
        AipNlp client = new AipNlp("23574651", "uwba8ncctqO3y1CikeYyUCUh",
                "wq0e1vcGAWmNfeObp3jne3Bo9EQqbtTc");
        String text = "宁格林，15661010920，陕西西安雁塔区清华科技园E座";

        // 传入可选参数调用接口
        HashMap<String, Object> options = new HashMap<>();

        // 地址识别接口
        JSONObject res = client.address(text, options);
        System.out.println(res.toString(2));
    }
}

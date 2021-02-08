package com.example.demo.endpoint;

import com.example.demo.model.ApiResponse;
import com.example.demo.model.request.UserInfo;
import com.example.demo.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLException;

@RestController
@CrossOrigin
public class DemoEndpoint
{
    private static final Logger logger = LoggerFactory.getLogger(DemoEndpoint.class);

    @Value("${spring.datasource.url}")
    private String dbHost;
    @Value("${spring.datasource.username}")
    private String userName;
    @Value("${spring.datasource.password}")
    private String userPassword;

    @RequestMapping(path = {"/test1", "/test2"}, method = {RequestMethod.GET, RequestMethod.POST})
    public ApiResponse test()
    {
        return new ApiResponse();
    }

    @RequestMapping(path = {"/testParamValid"}, method = RequestMethod.POST)
    public ApiResponse testParamValid(@Valid @RequestBody UserInfo userinfo)
    {
        logger.info("userInfo: {}", JsonUtil.obj2String(userinfo));
        logger.info("userInfo: {}", userinfo.toString());
        return new ApiResponse();
    }

    @RequestMapping(path = {"/testParamValid"}, method = RequestMethod.GET)
    public ApiResponse testParamValid(@RequestParam(value = "id", required = true) String id)
    {
        return new ApiResponse();
    }

    @RequestMapping(path = {"/sqlQuery"}, method = RequestMethod.POST)
    public ApiResponse sqlQuery(@RequestParam(value = "sql", required = true) String sql) throws SQLException,
            ClassNotFoundException
    {
        final String request = sql;
        Object object;
        return new ApiResponse("resultSet");
    }
}

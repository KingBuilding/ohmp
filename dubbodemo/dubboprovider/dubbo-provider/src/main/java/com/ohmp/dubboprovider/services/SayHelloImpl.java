package com.ohmp.dubboprovider.services;

import com.alibaba.fastjson.JSON;
import com.ohmp.dubboproviderapi.services.request.User;
import com.ohmp.dubboproviderapi.services.ISayHelloService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;

import javax.validation.constraints.NotNull;

/**
 * Author: 金🗡
 * Date: 2020/1/19 0:21
 */
@Service(validation = "true")
@Slf4j
public class SayHelloImpl implements ISayHelloService {
    public String say(@NotNull String message) {
        log.info("message:{}", message);
        return message;
    }
    public String say2( User user) {
        log.info("user:{}", user);
        return JSON.toJSONString(user);
    }
}

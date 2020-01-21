package com.ohmp.dubboprovider.services;

import com.ohmp.dubboproviderapi.services.ISayHelloService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;

/**
 * Author: 金🗡
 * Date: 2020/1/19 0:21
 */
@Service
@Slf4j
public class SayHelloImpl implements ISayHelloService {
    public String say(String message) {
        log.info("message:{}", message);
        return message;
    }
}

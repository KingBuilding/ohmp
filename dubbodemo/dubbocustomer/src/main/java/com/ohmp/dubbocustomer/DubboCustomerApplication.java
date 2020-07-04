package com.ohmp.dubbocustomer;

import com.ohmp.dubboproviderapi.services.ISayHelloService;
import com.ohmp.dubboproviderapi.services.request.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.types.Expiration;

import java.nio.charset.Charset;

@SpringBootApplication
@Slf4j
public class DubboCustomerApplication {

    static RedisTemplate redisTemplate;
    public static void main(String[] args) {
      redisTemplate.execute(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                RedisStringCommands commands = (RedisStringCommands) connection.getNativeConnection();
              commands.set("".getBytes(Charset.defaultCharset()),
                        "s".getBytes(Charset.defaultCharset()), Expiration.seconds(10L), RedisStringCommands.SetOption.SET_IF_ABSENT);
            return "";
            }
        });
        SpringApplication.run(DubboCustomerApplication.class, args);
    }

    @Reference(url = "dubbo://127.0.0.1:8888",validation = "true")
    private ISayHelloService sayHelloService;



    @Bean
    public ApplicationRunner runner() {
        return args -> {
           User user= new User();
           user.setId("1");
            log.info(sayHelloService.say2(user));
            log.info(sayHelloService.say("ssssssssssssssssss"));
        };
    }

}

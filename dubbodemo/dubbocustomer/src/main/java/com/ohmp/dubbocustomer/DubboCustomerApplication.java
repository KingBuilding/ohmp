package com.ohmp.dubbocustomer;

import com.ohmp.dubboproviderapi.services.ISayHelloService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class DubboCustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboCustomerApplication.class, args);
    }

    @Reference(url = "dubbo://127.0.0.1:12345")
    private ISayHelloService sayHelloService;



    @Bean
    public ApplicationRunner runner() {
        return args -> {
            log.info(sayHelloService.say("mercyblitz"));
        };
    }

}

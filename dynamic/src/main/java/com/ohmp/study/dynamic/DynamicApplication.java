package com.ohmp.study.dynamic;

import com.ohmp.study.dynamic.event.PublishEvent;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@SpringBootApplication
@MapperScan(basePackages = "com.ohmp.study.dynamic.mapper")
public class DynamicApplication {

    @Resource
    PublishEvent publishEvent;
    public static void main(String[] args) {
        SpringApplication.run(DynamicApplication.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner(){
        return  args -> init();
    }

    public void init(){
        publishEvent.regist();
    }

}

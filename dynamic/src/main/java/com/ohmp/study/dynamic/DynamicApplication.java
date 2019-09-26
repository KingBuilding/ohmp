package com.ohmp.study.dynamic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.ohmp.study.dynamic.mapper")
public class DynamicApplication {

    public static void main(String[] args) {
        SpringApplication.run(DynamicApplication.class, args);
    }

}

package com.ohmp.springcloud;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringCloudApplicationTests {

    @Test
    public void contextLoads() {
    test("1","1");

    }

    public void test(String value,String value2){
        System.out.println("two args");
    }

    public void test(String ...values){
        System.out.println("values args");
    }
}

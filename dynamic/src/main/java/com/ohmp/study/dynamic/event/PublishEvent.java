package com.ohmp.study.dynamic.event;

import com.ohmp.study.dynamic.event.dto.EventSource;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;

/**
 * Author: 金🗡
 * Date: 2020/4/9 0:52
 */
@Component
public class PublishEvent {

    @Autowired
    ApplicationContext applicationContext;


    public void regist() {
        applicationContext.publishEvent(EventSource.builder().name("真三").build());
    }
    @EventListener
    public void handlerEvent(EventSource eventSource){
        System.out.println(eventSource.getName());
        System.out.println(eventSource.getName());
    }

}

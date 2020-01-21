package com.ohmp.study.devopsproject;

import java.util.HashMap;

/**
 * Author: 金🗡
 * Date: 2019/10/21 19:37
 */
public class ThreadB extends Thread{

    private Service service;

    public ThreadB(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.stopMethod();
    }
}

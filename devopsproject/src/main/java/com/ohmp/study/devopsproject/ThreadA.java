package com.ohmp.study.devopsproject;

/**
 * Author: 金🗡
 * Date: 2019/10/21 19:37
 */
public class ThreadA extends Thread{

    private Service service;

    public ThreadA(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.runMethod();
    }
}

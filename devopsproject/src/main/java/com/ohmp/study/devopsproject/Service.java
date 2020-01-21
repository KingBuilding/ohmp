package com.ohmp.study.devopsproject;

import java.util.HashMap;

import static com.sun.xml.internal.fastinfoset.util.ValueArray.MAXIMUM_CAPACITY;

/**
 * Author: 金🗡
 * Date: 2019/10/21 19:37
 */
public  class Service {
    private boolean isContinueRun=true;
    final int v;

    public Service(){
        v=1;
    }
    // private volatile boolean isContinueRun=true;  //使用volatile体现出可见性
    public void runMethod(){
        while (isContinueRun==true){
            System.out.println("isContinueRun=="+isContinueRun);
        }
        System.out.println("停止下来");
    }
    public void stopMethod(){
        isContinueRun=false;
    }

    public static void main(String[] args) throws InterruptedException {
//        Service service=new Service();
//        ThreadA threadA=new ThreadA(service);
//        threadA.start();
//        Thread.sleep(1000);
//        ThreadB threadB=new ThreadB(service);
//        threadB.start();
//        System.out.println("命令已经停止");
//        HashMap hashMap=new HashMap(4);
//        hashMap.put("q",2);
//        System.out.println(tableSizeFor(6));


    }



}

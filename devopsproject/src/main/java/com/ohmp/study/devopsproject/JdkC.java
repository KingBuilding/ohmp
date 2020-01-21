package com.ohmp.study.devopsproject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author: 金🗡
 * Date: 2019/10/31 16:23
 */
public class JdkC {

    private JdkC() {

    }


    public static void main(String[] args) {
//        System.out.println("kkkk");
//        JdkC jdkC = new JdkC();
//        System.out.println(jdkC.getClass());
//
//        Lock lockReentrantLock = new ReentrantLock();
//        lockReentrantLock.lock();

        List<String> list = new ArrayList<>();
        list.add("沉默王二");
        list.add("沉默王三");
        list.add("一个文章真特么有趣的程序员");

        for (String str : list) {
            if ("沉默王二".equals(str)) {
                list.remove(str);
            }
        }

        System.out.println(list);


    }

}

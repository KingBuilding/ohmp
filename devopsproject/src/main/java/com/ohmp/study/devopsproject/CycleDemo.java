package com.ohmp.study.devopsproject;

/**
 * Author: 金🗡
 * Date: 2019/12/22 23:32
 */
public class CycleDemo {





    public static int get(){
        for (int i = 0; i <3 ; i++) {
           if(i==2){
               return  2;
           }

        }
        return  1;
    }

    public static void main(String[] args) {
        System.out.println(get());
    }
}

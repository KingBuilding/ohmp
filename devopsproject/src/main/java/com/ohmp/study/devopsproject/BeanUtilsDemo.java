package com.ohmp.study.devopsproject;

import com.ohmp.study.dto.A;
import com.ohmp.study.dto.B;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

/**
 * Author: 金🗡
 * Date: 2019/12/22 17:15
 */
public class BeanUtilsDemo<T> {

    public  static <T>T getObj(Object b) {
        A a = new A();
        a.setMessage("sssss");
        BeanUtils.copyProperties(a,b);
        return  (T)b;
    }

    @Test
    public  void  test(){

        B b= BeanUtilsDemo.getObj(new B());
        b.getMessage();
        System.out.println(b.getMessage());
    }



}

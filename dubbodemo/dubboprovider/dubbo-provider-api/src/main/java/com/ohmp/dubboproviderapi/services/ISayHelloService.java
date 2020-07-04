package com.ohmp.dubboproviderapi.services;

import com.ohmp.dubboproviderapi.services.request.User;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * Author: 金🗡
 * Date: 2020/1/18 23:46
 */
public interface ISayHelloService {


    /**
     * @param message
     * @returnzz
     */


    String say(@NotBlank String message);
     String say2(@NotNull User user);

}

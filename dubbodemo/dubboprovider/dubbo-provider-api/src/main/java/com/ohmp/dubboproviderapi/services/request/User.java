package com.ohmp.dubboproviderapi.services.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Author: 金🗡
 * Date: 2020/4/1 0:34
 */
@Data
public class User implements Serializable {

    @NotNull(message = "不能胃口刚刚")
    private String id;
}

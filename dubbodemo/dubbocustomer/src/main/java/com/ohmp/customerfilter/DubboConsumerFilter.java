package com.ohmp.customerfilter;


import com.alibaba.fastjson.JSONObject;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @Author: jj
 * @Date: 2019/6/24 10:46
 * order 越小顺序越优先
 */
@Log4j2
@Activate(group = {CommonConstants.CONSUMER}, order = 100)
@Component
public class DubboConsumerFilter implements Filter, ApplicationContextAware {
    private static Map<String, List<String>> ipWhiteList = new HashMap<>();
    private static ApplicationContext applicationContextTemp;



    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        Object[] arguments = RpcContext.getContext().getArguments();
        String clientIp = RpcContext.getContext().getRemoteHost();
        log.info("访问ip为{} ", clientIp);
        log.info("请求参数：" + JSONObject.toJSONString(arguments));
        //目前所有的接口都需要传platformId  所以不能为空
        if(arguments.length>0&& Objects.nonNull(arguments[0])){
            String platformId = arguments[0].toString();
            log.info("当前platformId为" + platformId + "请求时间：" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            if (StringUtils.isNotBlank(platformId)) {
                if (ipWhiteList.containsKey(platformId)) {
                    List<String> platformIdIps = ipWhiteList.get(platformId);
                    if (!platformIdIps.contains(clientIp)) {
                        return new AppResponse(new RuntimeException("非法ip"));
                    }

                }
            }
            //platformId 表明传值有问题 走业务逻辑提示  同时也适配未开启白名单的项目
        }

        return invoker.invoke(invocation);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }
}

package com.ohmp.study.dynamic.nettytest;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @Author: jj
 * @Date: 2019/9/24 14:19
 */
public class TestServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        //类似于一个拦截器链
        ChannelPipeline pipeline = socketChannel.pipeline();
        pipeline.addLast("httpServerCodec", new HttpServerCodec()); //对于web请求进行编解码作用
        pipeline.addLast("testHttpServerHandler", new TestServerInitializer());
    }
}

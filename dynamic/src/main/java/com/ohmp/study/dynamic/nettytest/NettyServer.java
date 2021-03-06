package com.ohmp.study.dynamic.nettytest;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @Author: jj
 * @Date: 2019/9/24 14:11
 */
public class NettyServer {

    private static int port = 6666;
    private static String ip = "127.0.0.1";

    public static void main(String[] args) throws InterruptedException {

        //看做一个死循环，程序永远保持运行
        EventLoopGroup bossGroup = new NioEventLoopGroup(); //完成线程的接收，将连接发送给worker
        EventLoopGroup workerGroup = new NioEventLoopGroup(); //完成连接的处理
        try {
            //对于相关启动信息进行封装
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap
                    .group(bossGroup, workerGroup) //注入两个group
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new TestServerInitializer());
            //绑定端口对端口进行监听,启动服务器
            ChannelFuture channelFuture = serverBootstrap.bind(port).sync();
            channelFuture.channel().closeFuture().sync();
        } finally {

            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

}

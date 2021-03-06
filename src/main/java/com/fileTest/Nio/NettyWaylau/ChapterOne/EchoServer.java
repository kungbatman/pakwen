package com.fileTest.Nio.NettyWaylau.ChapterOne;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * @author kung
 * @date 2020-01-18 9:53
 * @Description 1.设置端口值（抛出一个 NumberFormatException 如果该端口参数的格式不正确）
 * <p>
 * 2.呼叫服务器的 start() 方法
 * <p>
 * 3.创建 EventLoopGroup
 * <p>
 * 4.创建 ServerBootstrap
 * <p>
 * 5.指定使用 NIO 的传输 Channel
 * <p>
 * 6.设置 socket 地址使用所选的端口
 * <p>
 * 7.添加 EchoServerHandler 到 Channel 的 ChannelPipeline
 * <p>
 * 8.绑定的服务器;sync 等待服务器关闭
 * <p>
 * 9.关闭 channel 和 块，直到它被关闭
 * <p>
 * 10.关机的 EventLoopGroup，释放所有资源。
 */
public class EchoServer {
    private final int port;

    public EchoServer(int port) {
        this.port = port;
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println(
                    "Usage: " + EchoServer.class.getSimpleName() +
                            " <port>");
            return;
        }
        int port = Integer.parseInt(args[0]);        //1
        new EchoServer(8096).start();                //2
    }

    public void start() throws Exception {
        NioEventLoopGroup group = new NioEventLoopGroup(); //3
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(group)                                //4
                    .channel(NioServerSocketChannel.class)        //5
                    .localAddress(new InetSocketAddress(port))    //6
                    .childHandler(new ChannelInitializer<SocketChannel>() { //7
                        @Override
                        public void initChannel(SocketChannel ch)
                                throws Exception {
                            ch.pipeline().addLast(
                                    new EchoServerHandler());
                        }
                    });

            ChannelFuture f = b.bind().sync();            //8
            System.out.println(EchoServer.class.getName() + " started and listen on " + f.channel().localAddress());
            f.channel().closeFuture().sync();            //9
        } finally {
            group.shutdownGracefully().sync();            //10
        }
    }
}

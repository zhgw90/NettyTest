package com.nettyTest.server;

public class StartServer {
    public static void main(String[] args) {
        try {
            new NettyServerBootstrap(61111);
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}

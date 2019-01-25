package com.nettytest.server;

/**
 * @author zhangguowei
 * @version v 0.1.0
 * @date 2019/1/25 16:56
 */
public class StartServer {
    public static void main(String[] args) {
        try {
            new NettyServerBootstrap(61111);
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}

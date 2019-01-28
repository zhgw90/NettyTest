package com.nettytest.nettybook.ch2.nio;

import java.io.IOException;

/**
 * @author zhangguowei
 * @version v 0.1.0
 * @date 2019/1/25 16:56
 */
public class TimeServer {
    public static void main(String [] args) throws IOException{
        int port = 61111;
        if(args != null && args.length > 0){
            try {
                port = Integer.valueOf(args[0]);
            }catch (NumberFormatException e){
                //采用默认值
            }
        }
        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);
        new Thread(timeServer, "NIO-MultiplexerTimeServer-001").start();
    }
}

package com.nettyTest.client;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class StartClient {
    public static void main(String[] args) throws Exception {
        NettyClientBootstrap bootstrap = new NettyClientBootstrap(61111, "127.0.0.1");
        int i = 1;

        while (true) {
            TimeUnit.SECONDS.sleep(2);
            System.out.println("send heartbeat!");

            RequestInfoVO req = new RequestInfoVO();
            req.setSequence(123456);
            req.setType((byte) 1);
            req.setSequence(0);
            req.setBody(String.valueOf((new Date()).getTime()));

            TestVO vo = new TestVO();
            vo.setReq(1);
            vo.setName("582552252525");

			bootstrap.getSocketChannel().write(req);
            bootstrap.getSocketChannel().writeAndFlush(vo);
            i++;
        }
    }
}

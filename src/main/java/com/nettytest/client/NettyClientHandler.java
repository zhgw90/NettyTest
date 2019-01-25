package com.nettytest.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author zhangguowei
 * @version v 0.1.0
 * @date 2019/1/25 16:56
 */
public class NettyClientHandler extends SimpleChannelInboundHandler<RequestInfoVO> {

    protected void channelRead0(ChannelHandlerContext ctx, RequestInfoVO msg)
            throws Exception {
        System.out.println(msg.getBody());
        RequestInfoVO req = new RequestInfoVO();
        req.setSequence(msg.getSequence());
        req.setType(msg.getType());
        if (2 == msg.getType()) {
            req.setBody("client");
            ctx.channel().writeAndFlush(req);
        } else if (3 == msg.getType()) {
            req.setBody("zpksb");
            ctx.channel().writeAndFlush(req);
        }
    }

    protected void messageReceived(ChannelHandlerContext channelHandlerContext, RequestInfoVO requestInfoVO) throws Exception {

    }
}

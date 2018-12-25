package com.nettyTest;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class NettyServerHandler extends SimpleChannelInboundHandler<RequestInfoVO> {
//	private static final Log log = LogFactory.getLog(NettyServerHandler.class);

    protected void channelRead0(ChannelHandlerContext ctx, RequestInfoVO msg) throws Exception {
        System.out.println(msg.getBody());
        //
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {

    }

    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {

    }
    protected void messageReceived(ChannelHandlerContext channelHandlerContext, RequestInfoVO requestInfoVO) throws Exception {
        System.out.println(requestInfoVO.toString());
    }
}

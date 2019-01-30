package com.nettytest.nettybook.ch2.aio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * @author zhangguowei
 * @version v 0.1.0
 * @date 2019/1/29 10:41
 */
public class AcceptCompletionHandler implements CompletionHandler<AsynchronousSocketChannel, AsyncTimeServerHandler> {

    @Override
    public void completed(AsynchronousSocketChannel result,
                          AsyncTimeServerHandler attachment) {
        attachment.asynchronousServerSocketChannel.accept(attachment, this);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        result.read(buffer, buffer, new ReadCompletionHandler(result));
    }

    @Override
    public void failed(Throwable exc, AsyncTimeServerHandler attachment) {
        exc.printStackTrace();
        attachment.latch.countDown();
    }

}
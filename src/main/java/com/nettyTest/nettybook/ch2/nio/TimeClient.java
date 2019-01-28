package com.nettytest.nettybook.ch2.nio;

/**
 * @author zhangguowei
 * @version v 0.1.0
 * @date 2019/1/28 13:27
 */
public class TimeClient{
        /**
         * @param args
         */
        public static void main(String[] args) {

            int port = 61111;
            if (args != null && args.length > 0) {
                try {
                    port = Integer.valueOf(args[0]);
                } catch (NumberFormatException e) {
                    // 采用默认值
                }
            }
            new Thread(new TimeClientHandle("127.0.0.1", port), "TimeClient-001")
                    .start();
        }
}

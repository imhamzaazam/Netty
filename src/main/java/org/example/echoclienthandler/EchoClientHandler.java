package org.example.echoclienthandler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

import java.nio.ByteBuffer;

@Sharable
public class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuffer> {
    @Override
    public void channelActive(ChannelHandlerContext ctx)  {
        ctx.writeAndFlush(Unpooled.copiedBuffer("Netty Rocks!", CharsetUtil.UTF_8));
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuffer in) {
        System.out.println("Client Received" + in.toString());
    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause){
        cause.printStackTrace();
        ctx.close();
    }
}

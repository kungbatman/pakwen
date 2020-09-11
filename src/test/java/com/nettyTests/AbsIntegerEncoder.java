package com.nettyTests;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.util.List;

/**
 * @author kung
 * @date 2020-01-20 15:32
 * @Description
 */
public class AbsIntegerEncoder extends MessageToMessageEncoder<ByteBuf> {  //1
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, ByteBuf in, List<Object> out) throws Exception {
        while (in.readableBytes() >= 4) { //2
            int value = Math.abs(in.readInt());//3
            out.add(value);  //4
        }
    }
}
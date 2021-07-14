package org.zj.inter.impl;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.zj.inter.IMessageProvider;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author jiezhou
 * @CalssName: MessageProviderImpl
 * @Package org.zj.inter.impl
 * @Description:
 * @date 2021/7/14/13:44
 */
@EnableBinding(Source.class)//定义消息的推送管道
public class MessageProviderImpl implements IMessageProvider {
    @Resource
    private MessageChannel output;// 消息发送管道

    @Override
    public String send() {
        String message = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(message).build());
        System.out.println("message = " + message);
        return null;
    }
}

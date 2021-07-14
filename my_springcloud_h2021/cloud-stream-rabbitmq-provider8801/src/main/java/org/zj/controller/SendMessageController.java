package org.zj.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zj.inter.IMessageProvider;

import javax.annotation.Resource;

/**
 * @author jiezhou
 * @CalssName: SendMessageController
 * @Package org.zj.controller
 * @Description:
 * @date 2021/7/14/13:47
 */
@RestController
public class SendMessageController {
    @Resource
    IMessageProvider messageProvider;


    @GetMapping("/sendMessage")
    public String sendMessage() {
        return messageProvider.send();
    }
}

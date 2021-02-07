package com.tb.springcloud.controller;

import com.tb.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SendMessageController {

    @Resource
    private IMessageProvider provider;

    @GetMapping("/sendMessage")
    public String SendMessage(){
        return provider.send();
    }
}

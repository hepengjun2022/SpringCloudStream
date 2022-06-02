package com.roy.sc.own;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class SendMessageController {

//    @Autowired
    private Source source;

//    @GetMapping("/send")
    public Object send(String message) {
        MessageBuilder<String> messageBuilder = MessageBuilder.withPayload(message);
        source.output().send(messageBuilder.build());
        return "message sended : " + message;
    }
}

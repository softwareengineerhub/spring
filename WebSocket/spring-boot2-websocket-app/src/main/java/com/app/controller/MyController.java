package com.app.controller;

import com.app.model.RequestMessage;
import com.app.model.ResponseMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {

    @MessageMapping("/request")
    @SendTo("/response/data")
    public ResponseMessage greeting(RequestMessage message) throws Exception {
        return new ResponseMessage(message.getName());
    }

}

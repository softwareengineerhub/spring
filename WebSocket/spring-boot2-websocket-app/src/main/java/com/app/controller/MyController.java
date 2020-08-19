package com.app.controller;

import com.app.model.Greeting;
import com.app.model.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class MyController {

    @MessageMapping("/request")
    @SendTo("/response/data")
    public Greeting greeting(HelloMessage message) throws Exception {
        return new Greeting(HtmlUtils.htmlEscape(message.getName()));
    }

}

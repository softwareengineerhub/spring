/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring.mail;

import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 *
 * @author Denys.Prokopiuk
 */
@Component
public class TemplateServiceImpl {
    
    @Autowired
    private TemplateEngine templateEngine;
    
    public void process(){        
        Context ctx = new Context(Locale.getDefault());
        ctx.setVariable("name", "recipientName");
        ctx.setVariable("subscriptionDate", new Date());
        ctx.setVariable("hobbies", Arrays.asList("Cinema", "Sports", "Music"));
        String htmlContent = templateEngine.process("email-simple", ctx);
        System.out.println(htmlContent);
    }
}

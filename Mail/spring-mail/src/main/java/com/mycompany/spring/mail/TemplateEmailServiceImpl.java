/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring.mail;

import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 *
 * @author Denys.Prokopiuk
 */
@Component(value = "template")
public class TemplateEmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private TemplateEngine htmlTemplateEngine;
    
    @Override
    public void sendSimpleMessage(String to, String subject, String text) {
        try {
            // Prepare the evaluation context
            final Context ctx = new Context(Locale.getDefault());
            ctx.setVariable("name", "recipientName");
            ctx.setVariable("subscriptionDate", new Date());
            ctx.setVariable("hobbies", Arrays.asList("Cinema", "Sports", "Music"));
            
            // Prepare message using a Spring helper
            final MimeMessage mimeMessage = mailSender.createMimeMessage();
            final MimeMessageHelper message = new MimeMessageHelper(mimeMessage, "UTF-8");
            message.setSubject("Example HTML email (simple)");
            //message.setFrom("thymeleaf@example.com");
            message.setTo("denys.prokopiuk@gmail.com");
            
            // Create the HTML body using Thymeleaf
            final String htmlContent = this.htmlTemplateEngine.process("email-simple", ctx);
            System.out.println(htmlContent);
            message.setText(htmlContent, true /* isHtml */);
            
            // Send email
            mailSender.send(mimeMessage);
        } catch (MessagingException ex) {
           throw new RuntimeException(ex);
        }
    }

}

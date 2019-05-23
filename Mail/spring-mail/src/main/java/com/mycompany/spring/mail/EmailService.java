/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring.mail;

/**
 *
 * @author Denys.Prokopiuk
 */
public interface EmailService {

    public void sendSimpleMessage(String to, String subject, String text);

}

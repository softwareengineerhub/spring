/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myaop.app04.ch01.decalrativeproxyfactory.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("com/myaop/app04/ch01/decalrativeproxyfactory/xml/declarativeproxyfactory.xml");
        ctx.refresh();

        Artist artist = ctx.getBean("artist", Artist.class);
        artist.doAction();
    }

}

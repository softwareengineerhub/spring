/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.core.bean.alias;

import com.mycompany.my.spring5.core.bean.names.*;
import java.util.Arrays;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("aliasContext.xml");
        MyData myData1 = (MyData) ctx.getBean("item1");
        System.out.println(myData1);

        MyData myData2 = (MyData) ctx.getBean("item2");
        System.out.println(myData2);

        MyData myData3 = (MyData) ctx.getBean("item3");
        System.out.println(myData3);
        
        System.out.println("--------------------------");
        MyData myData4 = (MyData) ctx.getBean("item4");
        System.out.println(myData4);
        myData4 = (MyData) ctx.getBean("a");
        System.out.println(myData4);
        myData4 = (MyData) ctx.getBean("b");
        System.out.println(myData4);
        myData4 = (MyData) ctx.getBean("c");
        System.out.println(myData4);
        myData4 = (MyData) ctx.getBean("myItem");
        System.out.println(myData4);
    }

}

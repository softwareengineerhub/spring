/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app;

import com.app.config.MyConfig;
import com.app.model.Person;
import com.mycompany.feign.client.PersonClient;

/**
 *
 * @author asusadmin
 */

public class Main {
    
    

    public static void main(String[] args) {
        MyConfig myConfig = new MyConfig();
        PersonClient personClient = myConfig.personClient("denis", "1");
        Person p = personClient.findById2(0);
        System.out.println(p);
    }

}

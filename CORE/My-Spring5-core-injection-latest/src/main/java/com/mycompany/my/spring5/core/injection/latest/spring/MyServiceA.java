/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.core.injection.latest.spring;

import com.mycompany.my.spring5.core.injection.latest.MyProcessor;
import com.mycompany.my.spring5.core.injection.latest.MyService;
import javax.inject.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Denys.Prokopiuk
 */
@Service(value="myServiceA")
public class MyServiceA implements MyService {

    @Autowired
    @Qualifier(value = "myProcessorA")
    private MyProcessor myProcessor;

    @Override
    public void doAction() {
        System.out.println("MyServiceA start");
        myProcessor.doProcess();
        System.out.println("MyServiceA end");
    }

}

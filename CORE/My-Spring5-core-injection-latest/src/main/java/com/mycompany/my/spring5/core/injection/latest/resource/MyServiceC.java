/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.core.injection.latest.resource;

import com.mycompany.my.spring5.core.injection.latest.MyProcessor;
import com.mycompany.my.spring5.core.injection.latest.MyService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 *
 * @author Denys.Prokopiuk
 */
@Service
public class MyServiceC implements MyService {

    @Resource
    private MyProcessor myProcessorC;

    @Override
    public void doAction() {
        System.out.println("start MyServiceC");
        myProcessorC.doProcess();
        System.out.println("end MyServiceC");
    }

}

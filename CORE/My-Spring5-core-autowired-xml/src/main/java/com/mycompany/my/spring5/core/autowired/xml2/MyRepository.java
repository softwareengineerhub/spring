/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.core.autowired.xml2;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyRepository {
    private MyService myService;
    private MyService myServiceObject;

    public MyService getMyService() {
        return myService;
    }

    public void setMyService(MyService myService) {
        this.myService = myService;
    }

    public MyService getMyServiceObject() {
        return myServiceObject;
    }

    public void setMyServiceObject(MyService myServiceObject) {
        this.myServiceObject = myServiceObject;
    }
    
    
    
    public void doAction(){
        System.out.println("MyRepository.doAction(); myService="+myService+"; myServiceObject="+myServiceObject);
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.controller;

import com.app.model.Employee;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Properties;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Denys.Prokopiuk
 */
@Controller
@ResponseBody
@RequestMapping("/a/b/c/d/e")
public class MyController {

    @RequestMapping(value = "/testsave", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.ACCEPTED)  
    public void testSave(@RequestBody Employee emp) {
        System.out.println("emp="+emp);   
     //   String s = null;
      //  s.toString();
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)  
    public String handleException(Exception ex){
        System.out.println("##########INSIDE");
        try(ByteArrayOutputStream out = new ByteArrayOutputStream(); 
                PrintStream ps = new PrintStream(out);){            
            ex.printStackTrace(ps);
            return new String(out.toByteArray());
        } catch(Exception ex1){
            throw new RuntimeException(ex1);
        }
    }

}

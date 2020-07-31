package com.app.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.Part;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.stream.Collector;

@RestController
public class MyRestController {

    @PostMapping("/upload")
    public void upload(HttpServletRequest request){
        try {
            Collection<Part> parts = request.getParts();
            for(Part part: parts){
                String name= part.getName();
                System.out.println("name="+name);

                //provides real name
                name=part.getSubmittedFileName();
                System.out.println("name="+name);

                try(InputStream in =  part.getInputStream();
                    OutputStream out = new FileOutputStream(name)){
                    byte[] data = new byte[in.available()];
                    in.read(data);
                    out.write(data);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @PostMapping("/upload2")
    public void upload2(HttpServletRequest request){
        try(ServletInputStream in = request.getInputStream();
            OutputStream out = new FileOutputStream("res.pdf")) {
            byte[] data = new byte[in.available()];
            in.read(data);
            out.write(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



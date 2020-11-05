package com.app.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

@RestController
public class MyMultipartUpload {

    @PostMapping("/v1/upload2")
    public void upload2(@RequestParam("file") MultipartFile file){
        try(
                InputStream in = file.getInputStream();
            OutputStream out = new FileOutputStream(new File("res.txt"))
        ){
            byte[] data = new byte[in.available()];
            in.read(data);
            out.write(data);
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }

    @PostMapping("/v1/upload3")
    public void upload3(){

    }

}

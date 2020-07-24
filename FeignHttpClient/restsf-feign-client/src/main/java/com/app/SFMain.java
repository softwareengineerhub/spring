/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app;

import com.app.model.AccountDto;
import com.app.config.SFClient;
import com.app.model.AssetMetaDto;
import feign.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//import feign.slf4j.Slf4jLogger;

/**
 *
 * @author asusadmin
 */
@SpringBootApplication
public class SFMain implements CommandLineRunner{
    @Autowired
    private SFClient sfClient;

    public static void main(String[] args) {
        System.setProperty("server.port", "8081");
        SpringApplication.run(SFMain.class, args);
    }
    
    public void run(String... args) throws Exception {
        //createAccount();
        //readAccount();
        //readAccountByName();
        //readAccountByNameWithParam();

        //getAllAssetsByAccountName();
        //getAllAssetsByAccountNameWithParam();
        //getAssetByName();
        //getAssetByNameWithParameter();
        //getAssetMetaByNameWithParameter();
        //getAssetMetaByName2();
        getAccountMetaByName();
    }

    private void getAccountMetaByName(){
        Map<String, Object> response = sfClient.getAccountMetaByName("test");
        System.out.println("#######response="+response);
        List<Map<String, Object>> records = (List) response.get("records");
        System.out.println("#######records.size="+records.size());
        List<String> res = new ArrayList();
        for(Map<String, Object> record: records){
            System.out.println("!!!!!!!!!!!!"+record);
            System.out.println("!!!!!!!!!!!!name="+record.get("Name"));
            System.out.println(String.format("ShippingStreet=%s", record.get("ShippingStreet")));
            System.out.println(String.format("ShippingCity=%s", record.get("ShippingCity")));
            System.out.println(String.format("ShippingState=%s", record.get("ShippingState")));
            System.out.println(String.format("ShippingPostalCode=%s", record.get("ShippingPostalCode")));
            System.out.println(String.format("ShippingCountry=%s", record.get("ShippingCountry")));
            System.out.println(String.format("Business_Unit__c=%s", record.get("Business_Unit__c")));
        }
    }

    private void getAllAssetsByAccountName() throws Exception {
        Response response = sfClient.getAllAssetsByAccountName();
        printRespone(response);
    }

    private void getAllAssetsByAccountNameWithParam() throws Exception {
        Map<String, Object> response = sfClient.getAllAssetsByAccountNameWithParameter("test");
        List<Map<String, Object>> records = (List) response.get("records");
        List<String> res = new ArrayList();
        for(Map<String, Object> record: records){
            res.add(String.valueOf(record.get("Name")));
        }
        System.out.println("!!!!!!!!!!!!"+res);
    }


    private void getAssetByName() throws Exception {
        Map<String, Object> response = sfClient.getAssetByName();
        System.out.println("#######response="+response);
        List<Map<String, Object>> records = (List) response.get("records");
        System.out.println("#######records.size="+records.size());
        List<String> res = new ArrayList();
        for(Map<String, Object> record: records){
            System.out.println("!!!!!!!!!!!!"+record);
            System.out.println("!!!!!!!!!!!!name="+record.get("Name"));
        }
    }

    private void getAssetByNameWithParameter() throws Exception {
        Map<String, Object> response = sfClient.getAssetByNameWithParameter("assert1.2");
        System.out.println("#######response="+response);
        List<Map<String, Object>> records = (List) response.get("records");
        System.out.println("#######records.size="+records.size());
        List<String> res = new ArrayList();
        for(Map<String, Object> record: records){
            System.out.println("!!!!!!!!!!!!"+record);
            System.out.println("!!!!!!!!!!!!name="+record.get("Name"));
            System.out.println("!!!!!!!!!!!!SerialNumber="+record.get("SerialNumber"));
            System.out.println("!!!!!!!!!!!!SerialNumber="+record.get("Customer_Asset_Name__c"));
            System.out.println("!!!!!!!!!!!!SerialNumber="+record.get("Manufactured_Location__c"));
            System.out.println("!!!!!!!!!!!!SerialNumber="+record.get("Product_Line__c"));
            System.out.println("!!!!!!!!!!!!SerialNumber="+record.get("Covered_by_Me__c"));
        }
    }


    private void getAssetMetaByNameWithParameter() throws Exception {
        Map<String, Object> response = sfClient.getAssetMetaByNameWithParameter("assert1.2");
        System.out.println("#######response="+response);
        List<Map<String, Object>> records = (List) response.get("records");
        System.out.println("#######records.size="+records.size());
        List<String> res = new ArrayList();
        for(Map<String, Object> record: records){
            System.out.println("!!!!!!!!!!!!"+record);
            System.out.println("!!!!!!!!!!!!name="+record.get("Name"));
        }
    }



    private void readAccountByNameWithParam() throws Exception {
        Response response =  sfClient.readAccountByNameWithParam("test");
        printRespone(response);
    }

    private void readAccountByName() throws Exception {
        Response response =  sfClient.readAccountByName();
        printRespone(response);
    }

    private void readAccount() throws Exception {
        Response response =  sfClient.readAccount();
        printRespone(response);
    }

    private void createAccount() throws Exception {
        AccountDto accountDto = new AccountDto("java-test");
        Response response =  sfClient.createAccount(accountDto);
        printRespone(response);
    }

    private void printRespone(Response response) throws Exception {
        System.out.println("------------response------------");
        System.out.println(response.headers());
        System.out.println("------------response------------");

        System.out.println("------------response.body------------");
        BufferedReader reader = new BufferedReader(response.body().asReader());
        String line = null;
        StringBuilder sb = new StringBuilder();
        while((line = reader.readLine())!=null){
            sb.append(line);
        }
        System.out.println(sb);
        System.out.println("------------response.body------------");

        System.out.println("------------response.status------------");
        System.out.println(response.status());
        System.out.println("------------response.status------------");

    }

}

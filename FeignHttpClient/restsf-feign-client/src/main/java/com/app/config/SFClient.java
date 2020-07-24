package com.app.config;

import com.app.model.AccountDto;
import com.app.model.AssetMetaDto;
import feign.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

//https://eu31.salesforce.com/services/data/v20.0/sobjects/Account/
/// services/data/v20.0/sobjects/Account/
public interface SFClient {


    @PostMapping("/services/data/v20.0/sobjects/Account/")
    public Response createAccount(@RequestBody AccountDto accountDto);

    @GetMapping("/services/data/v20.0/query/?q=select Id,Name from Account")
    public Response readAccount();

    @GetMapping("/services/data/v20.0/query/?q=select Id,Name from Account where Name='test'")
    public Response readAccountByName();

    @GetMapping("/services/data/v20.0/query/?q=select Id,Name from Account where Name='{accountName}'")
    public Response readAccountByNameWithParam(@PathVariable String accountName);


    //https://eu31.salesforce.com/services/data/v20.0/query/?q=SELECT+ShippingStreet, ShippingCity,ShippingState,ShippingPostalCode,ShippingCountry,Business_Unit__c+From+Account+WHERE+Account.Name='test'

    @GetMapping("/services/data/v20.0/query/?q=select ShippingStreet,ShippingCity,ShippingState,ShippingPostalCode,ShippingCountry,Business_Unit__c from Account where Name='{accountName}'")
    public Map<String, Object> readAccountMetaByName(@PathVariable String accountName);


    @GetMapping("/services/data/v20.0/query/?q=select Name from Asset where Account.Name='test'")
    public Response getAllAssetsByAccountName();

    @GetMapping("/services/data/v20.0/query/?q=select Name from Asset where Account.Name='{accountName}'")
    public Map<String, Object> getAllAssetsByAccountNameWithParameter(@PathVariable String accountName);

    //name,SerialNumber,Customer_Asset_Name__c,Manufactured_Location__c,Product_Line__c,Covered_by_Me__c
    //@GetMapping("/services/data/v20.0/query/?q=select name,SerialNumber,Customer_Asset_Name__c,Manufactured_Location__c,Product_Line__c,Covered_by_Me__c from Asset where Name='{assetName}'")

    //https://eu31.salesforce.com/services/data/v20.0/query/?q=SELECT+name+From+Asset+WHERE+Name='assert1.2'
    @GetMapping("/services/data/v20.0/query/?q=select Name from Asset where Asset.Name='assert1.2'")
    public Map<String, Object> getAssetByName();

    @GetMapping("/services/data/v20.0/query/?q=select Name from Asset where Asset.Name='{assetName}'")
    public Map<String, Object> getAssetByNameWithParameter(@PathVariable String assetName);

    @GetMapping("/services/data/v20.0/query/?q=select Name,SerialNumber,Customer_Asset_Name__c,Manufactured_Location__c,Product_Line__c,Covered_by_Me__c from Asset where Name='{assetName}'")
    public Map<String, Object> getAssetMetaByNameWithParameter(@PathVariable String assetName);

    //@GetMapping("/services/data/v20.0/query/?q=select Name,SerialNumber,Customer_Asset_Name__c,Manufactured_Location__c,Product_Line__c,Covered_by_Me__c from Asset where Name='{assetName}'")
    //public AssetMetaDto getAssetMetaByName2(@PathVariable String assetName);

    @GetMapping("/services/data/v20.0/query/?q=select ShippingStreet,ShippingCity,ShippingState,ShippingPostalCode,ShippingCountry,Business_Unit__c from Account where Name='{accountName}'")
    public Map<String, Object> getAccountMetaByName(@PathVariable String accountName);

}

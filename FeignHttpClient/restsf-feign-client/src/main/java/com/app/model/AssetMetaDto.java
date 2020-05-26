package com.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssetMetaDto {

    @JsonProperty("Name")
    private String name;
    @JsonProperty("SerialNumber")
    private String serialNumber;
    @JsonProperty("Customer_Asset_Name__c")
    private String customerAssetName;
    @JsonProperty("Manufactured_Location__c")
    private String manufacturedLocation;
    @JsonProperty("Product_Line__c")
    private String productLine;
    @JsonProperty("Covered_by_Me__c")
    private String coveredByMe;


}

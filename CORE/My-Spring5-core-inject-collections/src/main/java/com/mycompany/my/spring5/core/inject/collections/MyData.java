/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.core.inject.collections;

import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 *
 * @author Denys.Prokopiuk
 */
@Component
public class MyData {
    
    @Resource(name = "dataMap1")
    private Map<String, String> map1; 
    @Resource(name = "dataMap2")
    private Map<String, Integer> map2; 
    @Resource(name = "dataMap3")
    private Map<MyPerson, MyValue> map3;
    
    @Resource(name = "dataList1")
    private List<Integer> list1;
    @Resource(name = "dataList2")
    private List<MyValue> list2;
    @Resource(name = "dataList3")
    private List list3;
    
    @Resource(name="dataSet1")
    private Set<String> set1;
    @Resource(name="dataSet2")
    private Set<MyValue> set2;
    @Resource(name="dataSet3")
    private Set set3;
    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(map1);
        sb.append("\n");
        sb.append(map2);
        sb.append("\n");
        sb.append(map3);
        sb.append("\n");
        sb.append(list1);
        sb.append("\n");
        sb.append(list2);
        sb.append("\n");
        sb.append(list3);
        sb.append("\n");
        sb.append(set1);
        sb.append("\n");
        sb.append(set2);
        sb.append("\n");
        sb.append(set3);
        return sb.toString();
    }
    
    
    
    
}

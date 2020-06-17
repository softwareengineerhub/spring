package com.controller;

import com.model.DeviceEntity;
import com.model.TenantEntity;
import com.repository.DeviceEntityRepository;
import com.repository.TenantEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeviceController {
    @Autowired
    private DeviceEntityRepository deviceEntityRepository;
    @Autowired
    private TenantEntityRepository tenantEntityRepository;

    @PostMapping("/device/add/{tenantName}")
    public void addDevice(@RequestBody DeviceEntity deviceEntity, String tenantName){
        tenantEntityRepository.findAll().forEach(c->{
            if(c.getName().equals(tenantName)){
                deviceEntity.setTenantEntity(c);
            }
        });
        deviceEntityRepository.save(deviceEntity);
    }


}

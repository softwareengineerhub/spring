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
public class TenantController {
    @Autowired
    private TenantEntityRepository tenantEntityRepository;

    @PostMapping("/tenant/add/{tenantName}")
    public void addDevice(@RequestBody TenantEntity tenantEntity){
        tenantEntityRepository.save(tenantEntity);
    }

}

package com.model;

import javax.persistence.*;

@Entity
public class DeviceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne
    private TenantEntity tenantEntity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TenantEntity getTenantEntity() {
        return tenantEntity;
    }

    public void setTenantEntity(TenantEntity tenantEntity) {
        this.tenantEntity = tenantEntity;
    }
}

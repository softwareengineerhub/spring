package com.repository;

import com.model.DeviceEntity;
import com.model.TenantEntity;
import org.springframework.data.repository.CrudRepository;

public interface TenantEntityRepository extends CrudRepository<TenantEntity, Long> {
}

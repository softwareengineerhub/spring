package com.repository;

import com.model.DeviceEntity;
import org.springframework.data.repository.CrudRepository;

public interface DeviceEntityRepository extends CrudRepository<DeviceEntity, Long> {
}

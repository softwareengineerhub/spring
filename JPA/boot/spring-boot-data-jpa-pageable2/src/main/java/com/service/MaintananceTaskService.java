package com.service;

import com.model.DeviceEntity;
import com.model.MaintananceTask;
import com.repository.DeviceEntityRepository;
import com.repository.MaintananceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MaintananceTaskService {

    @Autowired
    private MaintananceRepository maintananceRepository;
    @Autowired
    private DeviceEntityRepository deviceEntityRepository;

    public long count(){
        return maintananceRepository.count();
    }

    public MaintananceTask update(MaintananceTask maintananceTask, String deviceName){
        deviceEntityRepository.findAll().forEach(c->{
            if(deviceName.equals(c.getName())){
                maintananceTask.setDeviceEntity(c);
            }
        });
        return maintananceRepository.save(maintananceTask);
    }

    public void delete(long id){
        maintananceRepository.deleteById(id);
    }

    public MaintananceTask add(MaintananceTask maintananceTask, String deviceName){

        deviceEntityRepository.findAll().forEach(c->{
            if(deviceName.equals(c.getName())){
                maintananceTask.setDeviceEntity(c);
            }
        });

        return maintananceRepository.save(maintananceTask);
    }

    public Page<MaintananceTask> filter(String site, String device, int priority, Pageable pageable){
        return maintananceRepository.filter(site, device, priority, pageable);
    }

    public Page<MaintananceTask> filterBySiteAndDevice(String site, String device, Pageable pageable){
        return maintananceRepository.filterBySiteAndDevice(site, device, pageable);
    }

    public Page<MaintananceTask> filterBySiteAndPriority(String site, int priority, Pageable pageable){
        return maintananceRepository.filterBySiteAndPriority(site, priority, pageable);
    }

    public Page<MaintananceTask> filterByDeviceAndPriority(String device, int priority, Pageable pageable){
        return maintananceRepository.filterByDeviceAndPriority(device, priority, pageable);
    }

    public Page<MaintananceTask> filterBySite(String site, Pageable pageable){
        return maintananceRepository.filterBySite(site, pageable);
    }

    public Page<MaintananceTask> filterByPriority(int priority, Pageable pageable){
        return maintananceRepository.filterByPriority(priority, pageable);
    }

    public Page<MaintananceTask> filterByDevice(String device, Pageable pageable){
        return maintananceRepository.filterByDevice(device, pageable);
    }

}

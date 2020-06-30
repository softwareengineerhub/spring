package com.service;

import com.model.MaintananceTask;
import com.model.MaintananceTaskDto;
import com.model.MaintananceTaskProjection;
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

    public Page<MaintananceTaskProjection> findAll(Pageable pageable){
        return maintananceRepository.findAllContent(pageable);
    }

    public Integer max(){
        return maintananceRepository.findMaxByTakId();
    }

    public long count(){
        return maintananceRepository.count();
    }

    public MaintananceTask update(MaintananceTask maintananceTask){
        return maintananceRepository.save(maintananceTask);
    }

    public void delete(long id){
        maintananceRepository.deleteById(id);
    }

    public MaintananceTask add(MaintananceTask maintananceTask){
        return maintananceRepository.save(maintananceTask);
    }

    public Page<MaintananceTaskProjection> filter(String site, String device, int priority, Pageable pageable){
        return maintananceRepository.filter(site, device, priority, pageable);
    }

    public Page<MaintananceTaskProjection> filterBySiteAndDevice(String site, String device, Pageable pageable){
        return maintananceRepository.filterBySiteAndDevice(site, device, pageable);
    }

    public Page<MaintananceTaskProjection> filterBySiteAndPriority(String site, int priority, Pageable pageable){
        return maintananceRepository.filterBySiteAndPriority(site, priority, pageable);
    }

    public Page<MaintananceTaskProjection> filterByDeviceAndPriority(String device, int priority, Pageable pageable){
        return maintananceRepository.filterByDeviceAndPriority(device, priority, pageable);
    }

    public Page<MaintananceTaskProjection> filterBySite(String site, Pageable pageable){
        return maintananceRepository.filterBySite(site, pageable);
    }

    public Page<MaintananceTaskProjection> filterByPriority(int priority, Pageable pageable){
        return maintananceRepository.filterByPriority(priority, pageable);
    }

    public Page<MaintananceTaskProjection> filterByDevice(String device, Pageable pageable){
        return maintananceRepository.filterByDevice(device, pageable);
    }

    public List<MaintananceTaskProjection> findTest(){
        return maintananceRepository.filterTest();
    }
}

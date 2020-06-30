package com.controller;

import com.model.*;
import com.repository.MaintananceRepository;
import com.service.JobService;
import com.service.MaintananceTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@Transactional
public class MaintananceTaskController {

    @Autowired
    private MaintananceTaskService maintananceTaskService;
    @Autowired
    private MaintananceRepository maintananceRepository;
    @Autowired
    private TestRepository testRepository;
    @Autowired
    private JobService jobService;

    @GetMapping("/findalltests")
    public List<TestProjection> findAllTests() {
        List<TestProjection> list = testRepository.findAllData();
        System.out.println("list="+list);
        System.out.println("list.size()="+list.size());
        return list;
    }

    @GetMapping("/findbyid/{id}")
    public MaintananceTaskProjection findbyid(@PathVariable("id") long id) {
        MaintananceTaskProjection mtp = maintananceRepository.findDataById(id);
        System.out.println("mtp="+mtp);
        return mtp;
    }

    @GetMapping("/makeaction/{id}")
    public void makeAction(@PathVariable int id){
        jobService.makeAction(id);
    }

    @GetMapping("/makeaction1/{id}")
    public void makeAction1(@PathVariable int id){
        jobService.makeAction1(id);
    }

    @GetMapping("/updateaction1/{id}")
    public void updateAction1(@PathVariable int id){
        jobService.updateAction1(id);
    }

    @GetMapping("/removeaction/{id}")
    public void removeAction1(@PathVariable int id){
        jobService.removeAction(id);
    }

    @PostMapping("/save/{device}")
    public void save(@PathVariable String device) {
        Test test = new Test();
        test.setDevice(device);
        testRepository.save(test);
    }

    @PostMapping("/save2/{device}/{taskid}")
    public void save2(@PathVariable String device, @PathVariable int taskid) {
        //testRepository.creat2(device, taskid);
        testRepository.creat2(device, taskid);
    }


    @GetMapping("/filtertest")
    public List<MaintananceTaskProjection> findAllContent() {
        return maintananceTaskService.findTest();
    }

    @GetMapping("/findallcontent")
    public Page<MaintananceTaskProjection> findAllContent(@RequestParam(name = "page", required = false) Integer page,
                                                          @RequestParam(name = "size", required = false) Integer size,
                                                          @RequestParam(name = "priority", required = false) Integer priority) {
        if (page == null) {
            page = 0;
        }
        if (size == null) {
            size = 10;
        }
        Pageable pageable = PageRequest.of(page, size);
        return maintananceTaskService.filterByPriority(priority, pageable);
    }


    @PostMapping("/my")
    public MyResponse myResponse(@RequestBody MyResponse myResponseParam) {
        System.out.println(myResponseParam);
        MyResponse myResponse = new MyResponse();
        myResponse.setFromvalue(new Timestamp(System.currentTimeMillis()));
        myResponse.setTovalue(new Timestamp(System.currentTimeMillis()));
        return myResponse;
    }

    @GetMapping("/count")
    public long count() {
        return maintananceTaskService.count();
    }

    @GetMapping("/max")
    public Integer max() {
        Integer res = maintananceTaskService.max();
        System.out.println("res=" + res);
        return res;
    }

    @PostMapping("/add")
    public MaintananceTask add(@RequestBody MaintananceTask maintananceTask) {
        return maintananceTaskService.add(maintananceTask);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") long id) {
        maintananceTaskService.delete(id);
    }

    @PutMapping("/update")
    public MaintananceTask update(@RequestBody MaintananceTask maintananceTask) {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!here");
        //maintananceTask.setId(id);
        return maintananceTaskService.update(maintananceTask);

    }

    @GetMapping("/filter")
    public Page<MaintananceTaskProjection> filter(@RequestParam(value = "device", required = false) String deviceParam,
                                                  @RequestParam(value = "site", required = false) String siteParam,
                                                  @RequestParam(value = "priority", required = false) String priorityParam,
                                                  @RequestParam(name = "page", required = false) Integer page, @RequestParam(name = "size", required = false) Integer size) {

        if (page == null) {
            page = 0;
        }
        if (size == null) {
            size = 10;
        }
        Pageable pageable = PageRequest.of(page, size);

        if (deviceParam != null && siteParam != null && priorityParam != null) {
            return maintananceTaskService.filter(siteParam, deviceParam, Integer.parseInt(priorityParam), pageable);
        }

        if (siteParam != null && deviceParam != null) {
            return maintananceTaskService.filterBySiteAndDevice(siteParam, deviceParam, pageable);
        }

        if (siteParam != null && priorityParam != null) {
            return maintananceTaskService.filterBySiteAndPriority(siteParam, Integer.parseInt(priorityParam), pageable);
        }

        if (deviceParam != null && priorityParam != null) {
            return maintananceTaskService.filterByDeviceAndPriority(deviceParam, Integer.parseInt(priorityParam), pageable);
        }

        if (siteParam != null) {
            return maintananceTaskService.filterBySite(siteParam, pageable);
        }
        if (deviceParam != null) {
            return maintananceTaskService.filterByDevice(siteParam, pageable);
        }
        if (priorityParam != null) {
            // return maintananceTaskService.filterByPriority(Integer.parseInt(priorityParam), pageable);
        }
        return maintananceTaskService.findAll(pageable);
    }

}


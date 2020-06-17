package com.controller;

import com.model.MaintananceTask;
import com.service.MaintananceTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MaintananceTaskController {

    @Autowired
    private MaintananceTaskService maintananceTaskService;

    @GetMapping("/count")
    public long count(){
        return maintananceTaskService.count();
    }

    @PostMapping("/add/{devicename}")
    public MaintananceTask add(@RequestBody MaintananceTask maintananceTask, @PathVariable("devicename") String devicename){
        return maintananceTaskService.add(maintananceTask, devicename);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") long id){
        maintananceTaskService.delete(id);
    }

    @PutMapping("/update/{id}/{devicename}")
    public MaintananceTask update(@RequestBody MaintananceTask maintananceTask, @PathVariable("id") long id, @PathVariable("devicename") String devicename){
        maintananceTask.setId(id);
        return maintananceTaskService.update(maintananceTask, devicename);
    }

    @GetMapping("/filter")
    public Page<MaintananceTask> filter(@RequestParam(value = "device", required = false) String deviceParam,
                                        @RequestParam(value = "site", required = false) String siteParam,
                                        @RequestParam(value = "priority", required = false) String priorityParam,
                                        @RequestParam("page") int page, @RequestParam("size") int size){
        Pageable pageable = PageRequest.of(page, size);

        if(deviceParam!=null && siteParam!=null && priorityParam!=null){
            return maintananceTaskService.filter(siteParam, deviceParam, Integer.parseInt(priorityParam), pageable);
        }

        if(siteParam!=null && deviceParam!=null){
            return maintananceTaskService.filterBySiteAndDevice(siteParam, deviceParam, pageable);
        }

        if(siteParam!=null && priorityParam!=null){
            return maintananceTaskService.filterBySiteAndPriority(siteParam, Integer.parseInt(priorityParam), pageable);
        }

        if(deviceParam!=null && priorityParam!=null){
            return maintananceTaskService.filterByDeviceAndPriority(deviceParam, Integer.parseInt(priorityParam), pageable);
        }

        if(siteParam!=null){
            return maintananceTaskService.filterBySite(siteParam, pageable);
        }
        if(deviceParam!=null){
            return maintananceTaskService.filterByDevice(siteParam, pageable);
        }
        if(priorityParam!=null){
            return maintananceTaskService.filterByPriority(Integer.parseInt(priorityParam), pageable);
        }
        return Page.empty();
    }

}


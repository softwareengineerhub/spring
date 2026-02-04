package com.app.controller;

import com.app.domain.Car;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

@RestController
public class DateController {

    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
    private DateFormat dateFormatWeekly = new SimpleDateFormat("yyyy-'W'ww");

    @GetMapping("/date")
    public String get(@RequestParam String start, @RequestParam String end) throws ParseException {
        Date startDate = dateFormatWeekly.parse(start);
        Date endDate = dateFormatWeekly.parse(end);
        return "start="+startDate+"; end="+endDate;
    }

    @GetMapping("/date2")
    public String get2(@RequestParam Instant start, @RequestParam Instant end) {
        return "start="+start+"; end="+end;
    }

    @GetMapping("/date3")
    public String get3(@RequestParam Date start, @RequestParam Date end) {
        return "start="+start+"; end="+end;
    }

}

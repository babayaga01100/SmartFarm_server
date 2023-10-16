package com.example.springserver.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.springserver.domain.SmartFarm;
import com.example.springserver.service.SmartFarmService;

@Controller
//@RestController
//@RequestMapping("/api")
public class SendController {

    private final SmartFarmService smartFarmService;

    @Autowired
    public SendController(SmartFarmService memberService) {
        this.smartFarmService = memberService;
    }

    @GetMapping("/data")
    @ResponseBody
    public SmartFarm getdata_g(){
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("INFO  Get Request checked " + currentTime);
        return smartFarmService.getLastSmartFarm();
    }

    @PostMapping("/data")
    @ResponseBody
    public SmartFarm getdata_p(){
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("INFO  Post Request checked " + currentTime);
        return smartFarmService.getLastSmartFarm();
    }
}

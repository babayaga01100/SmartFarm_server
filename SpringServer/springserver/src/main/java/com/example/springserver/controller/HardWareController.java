package com.example.springserver.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.springserver.domain.SmartFarm;
import com.example.springserver.service.SmartFarmService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class HardWareController {

    private SmartFarmService smartFarmService;

    @Autowired
    public void HardWareRController(SmartFarmService smartFarmService, ObjectMapper objectMapper) {
        this.smartFarmService = smartFarmService;
    }

    @GetMapping("/raspberrypi")
    @ResponseBody
    public SmartFarm getdata_r(){
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("INFO  Get Request checked(/raspberrypi) " + currentTime);
        return smartFarmService.getLastSmartFarm();
    }

    @PostMapping("/raspberrypi")
    @ResponseBody
    public void savedata_r(@RequestBody SmartFarm smartFarm) throws Exception {
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("INFO  Received JSON data: " + smartFarm + " from raspberrypi " + currentTime);

        // 데이터베이스에 Json 데이터를 처리하고 저장
        smartFarmService.join(smartFarm);
    }
}

package com.example.springserver.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.springserver.domain.SmartFarm;
import com.example.springserver.service.SmartFarmService;

@Controller
public class FrontController {
    @Autowired
    private final SmartFarmService smartFarmService;

    public FrontController(SmartFarmService smartFarmService) {
        this.smartFarmService = smartFarmService;
    }

    @PostMapping("/react")
    @ResponseBody
    public SmartFarm react(@RequestBody SmartFarm smartFarm) throws Exception {
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("INFO  post request checked(/react) " + currentTime);
        smartFarmService.join(smartFarm);

        return smartFarmService.getLastSmartFarm();
    }
}

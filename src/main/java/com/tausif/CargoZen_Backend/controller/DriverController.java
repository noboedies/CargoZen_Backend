package com.tausif.CargoZen_Backend.controller;


import com.tausif.CargoZen_Backend.dto.DriverRegDto;
import com.tausif.CargoZen_Backend.entity.Driver;
import com.tausif.CargoZen_Backend.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @PostMapping("/register")
    public boolean register(@RequestBody DriverRegDto driverRegDto){
        boolean result = driverService.register(driverRegDto);
        return result;
    }
}

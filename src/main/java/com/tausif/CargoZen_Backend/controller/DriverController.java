package com.tausif.CargoZen_Backend.controller;


import com.tausif.CargoZen_Backend.dto.DriverRegDto;
import com.tausif.CargoZen_Backend.entity.Driver;
import com.tausif.CargoZen_Backend.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/findByEmail/{email}")
    public Driver findByEmail(@PathVariable String email){
        return driverService.findByEmail(email);
    }

    @PutMapping("/setStatus/{status}/{email}")
    public boolean setStaus(@PathVariable String status, @PathVariable String email){
        return driverService.setStatus(status, email);
    }
}

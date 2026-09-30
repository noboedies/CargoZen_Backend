package com.tausif.CargoZen_Backend.controller;

import com.tausif.CargoZen_Backend.entity.Admin;
import com.tausif.CargoZen_Backend.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping
    public Admin login(@RequestBody Admin admin){
        return adminService.login(admin);
    }
}

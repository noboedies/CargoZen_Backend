package com.tausif.CargoZen_Backend.controller;


import com.tausif.CargoZen_Backend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CargozenController {

    @Autowired
    private CustomerService customerService;
}

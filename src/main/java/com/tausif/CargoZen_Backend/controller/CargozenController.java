package com.tausif.CargoZen_Backend.controller;


import com.tausif.CargoZen_Backend.dto.CustomerRegisterDto;
import com.tausif.CargoZen_Backend.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CargozenController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/register")
    public ResponseEntity<Boolean> register(@Valid  @RequestBody CustomerRegisterDto customerRegisterDto){
        return ResponseEntity.ok(customerService.register(customerRegisterDto));
    }

}

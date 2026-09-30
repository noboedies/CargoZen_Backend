package com.tausif.CargoZen_Backend.controller;


import com.tausif.CargoZen_Backend.dto.CustomerRegisterDto;
import com.tausif.CargoZen_Backend.entity.Customer;
import com.tausif.CargoZen_Backend.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/register")
    public ResponseEntity<Boolean> register(@Valid  @RequestBody CustomerRegisterDto customerRegisterDto){
        return ResponseEntity.ok(customerService.register(customerRegisterDto));
    }

    @GetMapping("/findByEmail/{email}")
    public Customer findByEmail(@PathVariable String email){
        return customerService.findByEmail(email);
    }
}

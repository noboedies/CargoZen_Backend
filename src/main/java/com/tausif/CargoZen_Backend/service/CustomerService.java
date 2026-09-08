package com.tausif.CargoZen_Backend.service;

import com.tausif.CargoZen_Backend.dto.CustomerRegisterDto;
import com.tausif.CargoZen_Backend.entity.Customer;
import com.tausif.CargoZen_Backend.repository.CustomerRepo;
import jakarta.validation.Valid;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    public boolean register(CustomerRegisterDto customerRegisterDto) {
        Customer customer = customerRepo.findByEmail(customerRegisterDto.getEmail());
        if(customer == null){
            customer = customerRepo.findByUsername(customerRegisterDto.getUsername());
        }

        if(customer != null){
            return false;
        }
        customer = mapToEntity(customerRegisterDto);
        customerRepo.save(customer);
        return true;

    }

    private Customer mapToEntity(CustomerRegisterDto customerRegisterDto) {
        Customer customer = new Customer();
        customer.setName(customerRegisterDto.getName());
        customer.setEmail(customerRegisterDto.getEmail());
        customer.setUsername(customerRegisterDto.getUsername());
        customer.setPassword(customerRegisterDto.getPassword());
        customer.setPhone(customerRegisterDto.getPhone());
        customer.setCratedAt(LocalDateTime.now());
        return customer;
    }
}

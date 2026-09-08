package com.tausif.CargoZen_Backend.service;

import com.tausif.CargoZen_Backend.dto.CustomerRegisterDto;
import com.tausif.CargoZen_Backend.repository.CustomerRepo;
import jakarta.validation.Valid;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    public @Nullable Boolean register(@Valid CustomerRegisterDto customerRegisterDto) {
    }
}

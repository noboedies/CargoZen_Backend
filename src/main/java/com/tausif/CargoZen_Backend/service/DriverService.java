package com.tausif.CargoZen_Backend.service;


import com.tausif.CargoZen_Backend.dto.DriverRegDto;
import com.tausif.CargoZen_Backend.entity.Driver;
import com.tausif.CargoZen_Backend.repository.DriverRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DriverService {

    @Autowired
    private DriverRepo driverRepo;

    public boolean register(DriverRegDto driverRegDto) {
        Driver d = driverRepo.findByEmail(driverRegDto.getEmail());
        if(d == null){
            d = driverRepo.findByUsername(driverRegDto.getUsername());
        }
        if(d == null){
            d = mapToEntity(driverRegDto);
            driverRepo.save(d);
            return true;
        }
        return false;
    }



    private Driver mapToEntity(DriverRegDto driverRegDto){
        Driver driver = new Driver();
        driver.setName(driverRegDto.getName());
        driver.setEmail(driverRegDto.getEmail());
        driver.setPassword(driverRegDto.getPassword());
        driver.setPhone(driverRegDto.getPhone());
        driver.setUsername(driverRegDto.getUsername());
        driver.setDriving_license_no(driverRegDto.getDriving_license_no());
        driver.setVehicle_type(driverRegDto.getVehicle_type());
        driver.setVehicle_rc_no(driverRegDto.getVehicle_rc_no());
        driver.setDriving_license(driverRegDto.getDriving_license());
        driver.setVehicle_rc(driverRegDto.getVehicle_rc());
        driver.setCreatedAt(LocalDateTime.now());
        driver.setStatus("pending");
        return driver;
    }
}

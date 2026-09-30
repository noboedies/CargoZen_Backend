package com.tausif.CargoZen_Backend.service;

import com.tausif.CargoZen_Backend.entity.Admin;
import com.tausif.CargoZen_Backend.repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepo adminRepo;

    public Admin login(Admin admin) {
        Admin a = adminRepo.findById(admin.getEmail()).orElse(null);
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        if(a != null && bcrypt.matches(admin.getPassword(), a.getPassword())){
            return a;
        }else{
            return null;
        }
    }
}

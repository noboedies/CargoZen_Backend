package com.tausif.CargoZen_Backend.repository;

import com.tausif.CargoZen_Backend.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepo extends JpaRepository<Driver, Long> {
    Driver findByEmail(String email);

    Driver findByUsername(String username);
}

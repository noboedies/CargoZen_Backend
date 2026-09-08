package com.tausif.CargoZen_Backend.repository;

import com.tausif.CargoZen_Backend.entity.Customer;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

    Object existsByEmail(@NotBlank @Email String email);

    Customer findByEmail(@NotBlank @Email String email);

    Customer findByUsername(@NotBlank @Size(min = 6, max = 10) String username);
}

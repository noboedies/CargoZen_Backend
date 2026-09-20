package com.tausif.CargoZen_Backend.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(unique = true, nullable = false)
    private String username;
    private String name;
    @Column(unique = true, nullable = false)
    private String phone;
    private String vehicle_type;
    @Column(unique = true, nullable = false)
    private String vehicle_rc_no;
    @Column(nullable = false, columnDefinition = "longblob")
    private byte[] vehicle_rc;
    @Column(unique = true, nullable = false)
    private String driving_license_no;
    @Column(nullable = false, columnDefinition = "longblob")
    private byte[] driving_license;
    @Column(nullable = false)
    private String password;
    private String status;
    private LocalDateTime createdAt;

}

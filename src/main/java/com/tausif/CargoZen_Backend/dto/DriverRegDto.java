package com.tausif.CargoZen_Backend.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DriverRegDto {

    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Size(min = 6, max = 10)
    private String username;
    @NotBlank
    @Size(min = 2, max = 30)
    private String name;
    @NotBlank
    @Pattern(regexp = "\\d{10}", message = "Phone number must contain exactly 10 digits")
    private String phone;
    private String vehicle_type;
    private String vehicle_rc_no;
    private byte[] vehicle_rc;
    private String driving_license_no;
    private byte[] driving_license;
    @NotBlank
    @Size(min = 8)
    private String password;
}

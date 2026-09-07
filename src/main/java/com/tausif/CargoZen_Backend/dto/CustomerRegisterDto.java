package com.tausif.CargoZen_Backend.dto;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRegisterDto {

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

    @NotBlank
    @Size(min = 8)
    private String password;
}

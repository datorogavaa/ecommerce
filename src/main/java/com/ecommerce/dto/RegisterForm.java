package com.ecommerce.dto;

import lombok.Data;

@Data
public class RegisterForm {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;
    private String confirmPassword;
}

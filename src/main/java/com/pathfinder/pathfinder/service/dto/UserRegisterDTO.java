package com.pathfinder.pathfinder.service.dto;

import jakarta.validation.constraints.*;
import org.springframework.format.annotation.NumberFormat;

public class UserRegisterDTO {

     @NotBlank
     @Size(min = 5, max = 50)
     private String username;

     @NotBlank
     @Size(min = 5, max = 50)
     private String fullName;

     @Email
     @Size(min = 5, max = 50)
     private String email;


     @Min(12)
     @Max(99)
     private Integer age;

     @Size(min = 5, max = 50)
     private String password;
     private String confirmPassword;

    public UserRegisterDTO() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}

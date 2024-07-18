package com.softuni.shopping_list.entity.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRegistrationBindingModel {

    @Size(min = 3, max = 20)
    @NotBlank
    private String username;

    @Size(min = 3, max = 20)
    @NotBlank
    private String password;

    @Size(min = 3, max = 20)
    private String confirmPassword;

    @Email
    @NotBlank
    private String email;


    public UserRegistrationBindingModel() {
    }

    public String getUsername() {
        return username;
    }

    public UserRegistrationBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegistrationBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegistrationBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegistrationBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }
}

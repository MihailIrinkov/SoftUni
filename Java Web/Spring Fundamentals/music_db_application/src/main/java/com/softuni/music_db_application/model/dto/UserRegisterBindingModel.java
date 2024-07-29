package com.softuni.music_db_application.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserRegisterBindingModel {

    @NotNull
    @Size(min = 3, max = 20, message = "Username length must be more than 3 characters")
    private String username;

    @NotNull
    @Size(min = 3, max = 20, message = "Full name length must be more than 3 characters")
    private String fullName;

    @NotNull
    @Size(min = 5, max = 20, message = "Password length must be between 5 and 20 characters")
    private String password;

    @NotNull
    @Size(min = 5, max = 20, message = "Password length must be between 5 and 20 characters")
    private String confirmPassword;

    @NotNull
    @Email(message = "Must be valid email")
    private String email;

    public UserRegisterBindingModel() {
    }

    public String getUsername() {
        return username;
    }

    public UserRegisterBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserRegisterBindingModel setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }
}

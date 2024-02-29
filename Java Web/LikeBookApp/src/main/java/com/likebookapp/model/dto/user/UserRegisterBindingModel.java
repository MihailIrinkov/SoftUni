package com.likebookapp.model.dto.user;

import com.likebookapp.validation.anotation.UniqueEmail;
import com.likebookapp.validation.anotation.UniqueUsername;
import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRegisterBindingModel {

    @UniqueUsername
    @NotNull
    @Size(min = 3, max = 20,
            message = "Username length must be between 3 and 20 characters!")
    private String username;

    @NotNull
    @Size(min = 3, max = 20,
            message = "Password length must be between 3 and 20 characters!")
    private String password;

    @NotNull
    @Size(min = 3, max = 20,
            message = "Password length must be between 3 and 20 characters!")
    private String confirmPassword;

    @UniqueEmail
    @Email(message = "Enter valid email!")
    @NotBlank(message = "Email can not be empty!")
    private String email;

    public UserRegisterBindingModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}

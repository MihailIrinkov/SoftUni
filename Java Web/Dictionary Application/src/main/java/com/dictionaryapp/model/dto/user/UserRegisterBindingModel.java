package com.dictionaryapp.model.dto.user;

import com.dictionaryapp.validation.anotation.UniqueEmail;
import com.dictionaryapp.validation.anotation.UniqueUsername;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.UniqueElements;

public class UserRegisterBindingModel {

    @UniqueUsername
    @NotNull
    @Size(min = 3, max = 20,
            message = "Username length must be between 3 and 20 characters!")
    private String username;

    @UniqueEmail
    @NotBlank(message = "Email can not be empty!")
//    @NotBlank(message = "Email can not be empty!")
    @Email(message = "Enter valid email!")
    private String email;

    @NotNull
    @Size(min = 3, max = 20,
            message = "Password length must be between 3 and 20 characters!")
    private String password;

    @NotNull
    @Size(min = 3, max = 20,
            message = "Password length must be between 3 and 20 characters!")
    private String confirmPassword;

    public UserRegisterBindingModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

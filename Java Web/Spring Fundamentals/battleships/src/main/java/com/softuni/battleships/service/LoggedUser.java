package com.softuni.battleships.service;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class LoggedUser {

    private Long id;

    private boolean isLogged;

    public LoggedUser() {
    }

    public Long getId() {
        return id;
    }

    public LoggedUser setId(Long id) {
        this.id = id;
        return this;
    }

    public boolean isLogged() {
        return isLogged;
    }

    public LoggedUser setLogged(boolean logged) {
        isLogged = logged;
        return this;
    }

    public void login(Long id) {
        this.id = id;
        this.isLogged = true;
    }

    public void logout() {
        this.id = null;
        this.isLogged = false;
    }
}

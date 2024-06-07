package org.softuni.mobilele.model.events;

import org.springframework.context.ApplicationEvent;

public class UserRegisteredEvent extends ApplicationEvent {
    private final String userEmail;
    private final String username;

    public UserRegisteredEvent(Object source,
                               String userEmail,
                               String username) {
        super(source);
        this.userEmail = userEmail;
        this.username = username;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUsername() {
        return username;
    }
}

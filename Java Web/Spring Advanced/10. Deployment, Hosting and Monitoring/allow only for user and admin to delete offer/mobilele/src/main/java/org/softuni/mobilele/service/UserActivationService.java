package org.softuni.mobilele.service;

import org.softuni.mobilele.model.events.UserRegisteredEvent;

public interface UserActivationService {

//    void userRegistered(UserRegisteredEvent event);

    void cleanUpObsoleteActivationLinks();

    String createActivationCode(String userEmail);
}

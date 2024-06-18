package org.softuni.mobilele.service;

public interface EmailService {

    void sendRegistrationEmail(String userEmail, String username, String activationCode);

}

package org.softuni.mobilele.service.impl;

import org.softuni.mobilele.model.entity.UserActivationCodeEntity;
import org.softuni.mobilele.repository.UserActivationCodeRepository;
import org.softuni.mobilele.repository.UserRepository;
import org.softuni.mobilele.service.UserActivationService;
import org.softuni.mobilele.service.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.Instant;
import java.util.Random;

@Service
public class UserActivationServiceImpl implements UserActivationService {

    private static final String ACTIVATION_CODE_SYMBOLS =
            "abcdefghijklmnopqrstuvwxyzABCDEFGJKLMNPRSTUVWXYZ0123456789";
    private static final int ACTIVATION_CODE_LENGTH = 20;

    private final UserRepository userRepository;
    private final UserActivationCodeRepository userActivationCodeRepository;

    public UserActivationServiceImpl(UserRepository userRepository,
                                     UserActivationCodeRepository userActivationCodeRepository) {
        this.userRepository = userRepository;
        this.userActivationCodeRepository = userActivationCodeRepository;
    }

    @Override
    public void cleanUpObsoleteActivationLinks() {

    }

    @Override
    public String createActivationCode(String userEmail) {

        String activationCode = generateActivationCode();

        UserActivationCodeEntity userActivationCodeEntity = new UserActivationCodeEntity();
        userActivationCodeEntity.setActivationCode(activationCode);
        userActivationCodeEntity.setCreated(Instant.now());
        userActivationCodeEntity.setUser(userRepository.findAllByEmail(userEmail)
                .orElseThrow(() -> new ObjectNotFoundException("User not found")));

        userActivationCodeRepository.save(userActivationCodeEntity);

        return activationCode;
    }

    private static String generateActivationCode() {
        StringBuilder activationCode = new StringBuilder();
        Random random = new SecureRandom();

        for (int i = 0; i < ACTIVATION_CODE_LENGTH; i++) {
            int randInx = random.nextInt(ACTIVATION_CODE_SYMBOLS.length());
            activationCode.append(ACTIVATION_CODE_SYMBOLS.charAt(randInx));
        }
        return activationCode.toString().trim();
    }
}

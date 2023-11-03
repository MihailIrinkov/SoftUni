package bg.softuni.services;

import bg.softuni.usersystem.domain_entities.User;

import java.util.Date;
import java.util.List;

public interface UserService {

    List<User> getAllUsersByEmailProvider(String provider);

    void deactivateInactiveUsers(Date date);

    void save(User user);

    long getUsersCount();

    List<String> getUserNamesAndAgeByAgeRange(int lowBound, int highBound);

}

package org.softuni.repository;

import org.softuni.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("memoryRepo")
public class InMemoryUserRepository implements UserRepository {
    @Override
    public List<User> findAll() {
        return List.of(
                new User("Ivan", "Ivanov", 20),
                new User("Georgi", "Georgiev", 30),
                new User("Pesho", "Petrov", 40)
        );
    }
}

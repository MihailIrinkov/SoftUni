package org.softuni.repository;

import org.softuni.model.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll();

}

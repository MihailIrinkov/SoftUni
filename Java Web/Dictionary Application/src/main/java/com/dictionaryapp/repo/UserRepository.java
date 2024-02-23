package com.dictionaryapp.repo;

import com.dictionaryapp.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findAllByUsername(String username);

    User findByEmailAndUsername(String email, String username);

    Optional<User> findByEmail(String value);
}

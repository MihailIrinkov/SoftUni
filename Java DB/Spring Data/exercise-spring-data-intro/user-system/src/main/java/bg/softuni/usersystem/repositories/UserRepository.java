package bg.softuni.usersystem.repositories;

import bg.softuni.usersystem.domain_entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByEmailEndingWith(String end);

    List<User> findAllByLastTimeLoggedInBefore(Date dateTime);

    List<User> findAllByAgeBetweenOrderByAge(int lowBound, int highBound);
}


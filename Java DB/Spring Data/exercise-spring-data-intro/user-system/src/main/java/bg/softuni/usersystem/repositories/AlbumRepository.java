package bg.softuni.usersystem.repositories;

import bg.softuni.usersystem.domain_entities.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
}


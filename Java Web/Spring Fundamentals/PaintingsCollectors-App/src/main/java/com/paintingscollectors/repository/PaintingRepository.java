package com.paintingscollectors.repository;

import com.paintingscollectors.model.entity.Painting;
import com.paintingscollectors.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaintingRepository extends JpaRepository<Painting, Long> {

    List<Painting> findAllByOwner_Username(String username);

    List<Painting> findAllByOwnerIsNot(User owner);

    List<Painting> findAllByIsFavorite(String isFavorite);

    @Query(nativeQuery = true, value = "SELECT * FROM painting\n" +
            "ORDER BY votes DESC\n" +
            ", painting.name ASC LIMIT 2;")
    List<Painting> findMostVoted();
}

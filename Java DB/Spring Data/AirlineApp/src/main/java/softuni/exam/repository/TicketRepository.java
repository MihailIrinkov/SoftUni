package softuni.exam.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entities.Ticket;

import java.util.List;
import java.util.Optional;

@Repository
public interface TicketRepository  extends JpaRepository<Ticket, Long> {

    Optional<Ticket> findBySerialNumber(String serialNumber);

//    @Query(value = "SELECT passenger_id, COUNT(passenger_id) FROM tickets\n" +
//            "GROUP BY passenger_id ORDER BY COUNT(passenger_id) DESC;",
//    nativeQuery = true)
    @Query(value = "SELECT t.passenger_id, p.email, COUNT(t.passenger_id) FROM tickets as t\n" +
            "INNER JOIN passengers as p ON t.passenger_id = p.id\n" +
            "GROUP BY t.passenger_id ORDER BY COUNT(t.passenger_id) DESC, p.email ASC;",
    nativeQuery = true)
    List<Long> findByTicketCount();

    List<Ticket> findAllByPassengerId(Long id);
}

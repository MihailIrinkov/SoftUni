import entities.inheritance.Bike;
import entities.inheritance.Car;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class InheritanceMain {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("relations");
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        em.persist(new Car());
        em.persist(new Bike());

        em.getTransaction().commit();
    }
}

import entities.Car;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("hibernate_code_first");
        EntityManager em = entityManagerFactory.createEntityManager();

        em.getTransaction().begin();

        Car car = new Car();
        //entities.PlateNumber plateNumber = new entities.PlateNumber();

        em.persist(car);
        //em.persist(plateNumber);
        em.getTransaction().commit();
    }
}

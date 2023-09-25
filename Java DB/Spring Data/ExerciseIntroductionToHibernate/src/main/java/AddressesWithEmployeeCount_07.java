import entities.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AddressesWithEmployeeCount_07 {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("soft_uni");
        EntityManager em = entityManagerFactory.createEntityManager();

        em.getTransaction().begin();

        em.createQuery("From Address ORDER BY employees.size DESC", Address.class)
                .setMaxResults(10)
                .getResultList().forEach(a -> a.printAddressesWithEmployeeNumber());
    }
}

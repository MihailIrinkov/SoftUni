import entities.Address;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class RemoveTowns_13 {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = entityManagerFactory.createEntityManager();

        em.getTransaction().begin();
        Scanner scanner = new Scanner(System.in);
        String townName = scanner.nextLine();

        final Town townToDelete = em
                .createQuery("FROM Town WHERE name = :townName", Town.class)
                .setParameter("townName", townName).getSingleResult();

        final List<Address> addressesInTownToDelete = em
                .createQuery("From Address WHERE town = :townToDelete", Address.class)
                .setParameter("townToDelete", townToDelete)
                .getResultList();

        addressesInTownToDelete.forEach(a -> a.getEmployees()
                .forEach(employee -> employee.setAddress(null)));

        addressesInTownToDelete.forEach(a -> em.remove(a));
        em.remove(townToDelete);

        final int deletedAddresses = addressesInTownToDelete.size();

        System.out.printf("%d address in %s deleted", deletedAddresses, townToDelete.getName());

        em.getTransaction().commit();
        em.close();
    }
}

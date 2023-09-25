import entities.Address;
import entities.Employee;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class AddingNewAddressAndUpdatingTheEmployee_06 {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = entityManagerFactory.createEntityManager();

        Scanner scanner = new Scanner(System.in);

        String lastName = scanner.nextLine();
        em.getTransaction().begin();

        Town townForNewAddress = em
                .createQuery("From Town WHERE id = 7", Town.class).getSingleResult();

        final Set<Employee> employees = Set.copyOf(
                em.createQuery("From Employee WHERE lastName = :lastName", Employee.class)
                .setParameter("lastName", lastName)
                .getResultList());

        Address newAddress = new Address();
        newAddress.setEmployees(employees);
        newAddress.setText("Vitoshka 15");
        newAddress.setTown(townForNewAddress);

        em.persist(newAddress);

        employees.forEach(e->e.setAddress(newAddress));

        em.flush();
        em.getTransaction().commit();

        em.close();
        scanner.close();
    }
}

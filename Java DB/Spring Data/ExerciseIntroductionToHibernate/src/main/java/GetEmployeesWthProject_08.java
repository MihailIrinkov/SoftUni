import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class GetEmployeesWthProject_08 {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        Scanner scanner = new Scanner(System.in);
        int employeeId = scanner.nextInt();

        em.createQuery("From Employee WHERE id = :employeeId", Employee.class)
                        .setParameter("employeeId", employeeId)
                .getSingleResult().printNameProjectsJobTitle();

        em.close();
        scanner.close();
    }
}

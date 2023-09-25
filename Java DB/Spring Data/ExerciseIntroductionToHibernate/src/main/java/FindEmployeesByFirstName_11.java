import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class FindEmployeesByFirstName_11 {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = entityManagerFactory.createEntityManager();

        em.getTransaction().begin();

        Scanner scanner = new Scanner(System.in);
        String letters = scanner.nextLine();

        em.createQuery("From Employee WHERE firstName like CONCAT(:letters, '%')", Employee.class)
                        .setParameter("letters", letters)
                .getResultList().forEach(Employee::printNamesAndUpdatedSalary);



        em.close();
    }
}

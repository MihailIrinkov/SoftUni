import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class ContainsEmployee_03 {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = entityManagerFactory.createEntityManager();

        Scanner scanner = new Scanner(System.in);

        String fullName = scanner.nextLine();

        em.getTransaction().begin();

        final String isEmployeePresented = em.createQuery("from Employee where concat_ws(' ', first_name, last_name) = : fullName"
                        , Employee.class).setParameter("fullName", fullName)
                .getResultList().isEmpty() ? "No" : "Yes";


        em.getTransaction().commit();
        em.close();

        System.out.println(isEmployeePresented);

    }
}

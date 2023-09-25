import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;

public class IncreaseSalaries_10 {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = entityManagerFactory.createEntityManager();

        em.getTransaction().begin();

        final List<String> departmentsNames =
                List.of("Engineering", "Tool Design", "Marketing", "Information Services");

        final List<Employee> employees = em
                .createQuery("From Employee WHERE department.name in (:departmentsNames)",
                        Employee.class).setParameter("departmentsNames", departmentsNames)
                .getResultList();

        employees.forEach(employee -> employee.setSalary(employee.getSalary()
                .multiply(BigDecimal.valueOf(1.12))));

        em.flush();
        em.getTransaction().commit();
        em.close();

        employees.forEach(e -> e.printNamesAndUpdatedSalary());
    }
}

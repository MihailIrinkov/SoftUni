import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmployeesFromDepartment_05 {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        em.createQuery("from Employee WHERE department.name = :dName ORDER BY salary, id", Employee.class)
                .setParameter("dName", "Research and Development")
                .getResultList().forEach(e -> e.printNameDepartmentAndSalary());

        em.close();
    }
}

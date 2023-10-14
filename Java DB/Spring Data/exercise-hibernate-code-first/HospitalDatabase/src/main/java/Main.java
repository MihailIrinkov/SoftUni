import entities.Medicament;
import entities.Patient;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("hospital_database");

        EntityManager em = entityManagerFactory.createEntityManager();


        Patient testPatient = new Patient("Test", "Tester");

        em.getTransaction().begin();

        em.persist(testPatient);
        em.getTransaction().commit();

        em.close();
    }
}

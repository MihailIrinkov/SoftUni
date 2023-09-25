import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Comparator;

public class FindTheLatest10Projects_09 {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("soft_uni");

        EntityManager em = entityManagerFactory.createEntityManager();

        em.getTransaction().begin();

        em.createQuery("From Project ORDER BY startDate DESC", Project.class)
                .setMaxResults(10).getResultList()
                .stream().sorted((Comparator.comparing(Project::getName)))
                .forEach(Project::printLatest10Projects);
//sort((o1, o2) -> o1.getName().compareTo(o2.getName()))
        em.close();
    }
}

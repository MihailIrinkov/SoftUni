import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ChangeCasing_02 {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("soft_uni");
        EntityManager em = entityManagerFactory.createEntityManager();

        em.getTransaction().begin();

        final List<Town> allTowns = em
                .createQuery("FROM Town", Town.class).getResultList();

        for (Town t : allTowns) {
            if (t.getName().length() > 5) {
                em.detach(t);
                continue;
            }
            t.setName(t.getName().toUpperCase());
            em.persist(t);
        }

        em.getTransaction().commit();
        em.close();
    }
}

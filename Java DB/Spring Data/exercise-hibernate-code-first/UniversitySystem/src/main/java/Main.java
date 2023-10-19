import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

            EntityManagerFactory entityManagerFactory =
                    Persistence.createEntityManagerFactory("university_system");

            EntityManager em = entityManagerFactory.createEntityManager();


        }
}

import entities.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.security.auth.login.Configuration;

public class Main {
    public static void main(String[] args) {



        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("school");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
//        Student student = new Student("Teo");
//        em.persist(student);
//        em.getTransaction().commit();

//        Student findStudent = em.find(Student.class, 1);
//        em.getTransaction().commit();
//
//        System.out.println(findStudent.getName());

//        Student updatedStudent = new Student("TeoUpdated");
//        em.persist(updatedStudent);
//        em.getTransaction().commit();

        Student studentToDelete = em.find(Student.class, 2);
        em.remove(studentToDelete);
        em.getTransaction().commit();



    }
}

import entities.Courses;
import entities.User;
import orm.EntityManager;
import orm.config.Connector;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws SQLException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
        Connector.createConnection("root", "12345", "soft_uni");

        Connection connection = Connector.getConnection();
        EntityManager<User> userEntityManager = new EntityManager<>(connection);
        boolean persistResult = userEntityManager
                .persist(new User("u", "p", 12, LocalDate.now()));

        EntityManager<Courses> coursesEntityManager = new EntityManager<>(connection);
        boolean persistResultCourses = coursesEntityManager
                .persist(new Courses("Math", 12));

        System.out.println(persistResult);

        System.out.println(persistResultCourses);

         Courses first = coursesEntityManager.findFirst(Courses.class);

        System.out.println(first);

        EntityManager<Courses> coursesEntityManagerTest = new EntityManager<>(connection);

        coursesEntityManagerTest.doCreateTest(Courses.class);
    }
}

package ua.grayloki8.spring;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ua.grayloki8.spring.model.Item;
import ua.grayloki8.spring.model.Person;

import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class).
                addAnnotatedClass(Item.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session currentSession = sessionFactory.getCurrentSession();

        try {
            currentSession.beginTransaction();

            Person person = currentSession.get(Person.class, 3);
            System.out.println(person);
            List<Item> items = person.getItems();
            System.out.println(items);
            currentSession.getTransaction().commit();

        } finally {

            sessionFactory.close();
        }
        System.out.println("Hello World!");
    }
}

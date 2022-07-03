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
            Person person = currentSession.get(Person.class, 2);
            Item item1 = new Item("Item1",person);
            Item item2 = new Item("Item2",person);
            Item item3 = new Item("Item3",person);
            currentSession.save(item1);
            currentSession.save(item2);
            currentSession.save(item3);
            person.getItems().add(item1);
            person.getItems().add(item2);
            person.getItems().add(item3);
            currentSession.getTransaction().commit();

        } finally {

            sessionFactory.close();
        }
        System.out.println("Hello World!");
    }
}

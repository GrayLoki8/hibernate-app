package ua.grayloki8.spring;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ua.grayloki8.spring.model.Item;
import ua.grayloki8.spring.model.Passport;
import ua.grayloki8.spring.model.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class).
                addAnnotatedClass(Passport.class).addAnnotatedClass(Item.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session currentSession = sessionFactory.getCurrentSession();

        try {
            currentSession.beginTransaction();
            Person person = new Person("Grand Loki", 40);
            Passport passport = new Passport( 123456);
            person.setPassport(passport);
            currentSession.save(person);

            currentSession.getTransaction().commit();

        } finally {

            sessionFactory.close();
        }
        System.out.println("Hello World!");
    }
}

package ua.grayloki8.spring;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ua.grayloki8.spring.model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Movie.class).
                addAnnotatedClass(Actor.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try(sessionFactory) {
            Session currentSession = sessionFactory.getCurrentSession();

            currentSession.beginTransaction();

            Movie avengers = new Movie("Avengers", 2014);
            Actor tom = new Actor("Tom", 54);
            Actor bill = new Actor("Bill", 44);
            avengers.setActors(new ArrayList<>(List.of(tom,bill)));
            tom.setMovies(new ArrayList<>(Collections.singletonList(avengers)));
            bill.setMovies(new ArrayList<>(Collections.singletonList(avengers)));
            currentSession.save(avengers);
            currentSession.save(tom);
            currentSession.save(bill);

            currentSession.getTransaction().commit();

        }
        System.out.println("Hello World!");
    }
}

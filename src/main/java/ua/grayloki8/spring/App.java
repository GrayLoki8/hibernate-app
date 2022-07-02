package ua.grayloki8.spring;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ua.grayloki8.spring.model.Person;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session currentSession = sessionFactory.getCurrentSession();

        try {
            currentSession.beginTransaction();
            Person person=new Person("Loki",2);
            Person person2=new Person("Tor",24);
            Person person3=new Person("Odin",52);
            currentSession.save(person);
            currentSession.save(person2);
            currentSession.save(person3);

            currentSession.getTransaction().commit();
        } finally {

            sessionFactory.close();
        }
        System.out.println("Hello World!");
    }
}

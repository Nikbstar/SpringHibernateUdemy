package ru.nik66.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.nik66.hibernate.demo.entity.Student;

public class PrimaryKeyDemoApp {

    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            Student ekaterina = new Student("Ekaterina", "Kotkina", null, "fff@eee.com");
            Student ksenia = new Student("Ksenia", "Fominykh", null, "kkk@eee.com");
            Student maria = new Student("Maria", "Kotkina", null, "mmm@eee.com");
            session.beginTransaction();
            session.save(ekaterina);
            session.save(ksenia);
            session.save(maria);
            session.getTransaction().commit();
        }
    }

}

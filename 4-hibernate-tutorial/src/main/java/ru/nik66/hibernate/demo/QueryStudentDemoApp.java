package ru.nik66.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.nik66.hibernate.demo.entity.Student;

import java.util.List;

public class QueryStudentDemoApp {

    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            System.out.println("QueryStudentDemoApp: select all...");
            List<Student> students = session.createQuery("from Student", Student.class).getResultList();
            students.forEach(System.out::println);
            System.out.println("QueryStudentDemoApp: select Kotkina...");
            students = session.createQuery("from Student where lastName = 'Kotkina'", Student.class).getResultList();
            students.forEach(System.out::println);
            session.getTransaction().commit();
            System.out.println("QueryStudentDemoApp: Done!");
        }
    }

}

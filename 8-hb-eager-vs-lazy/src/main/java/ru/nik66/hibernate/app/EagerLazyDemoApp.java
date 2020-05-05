package ru.nik66.hibernate.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.nik66.hibernate.entity.Course;
import ru.nik66.hibernate.entity.Instructor;
import ru.nik66.hibernate.entity.InstructorDetail;

public class EagerLazyDemoApp {

    public static void main(String[] args) {
        Instructor instructor;
        try(SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
            Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            instructor = session.get(Instructor.class, 2);
            instructor.getCourses().forEach(System.out::println); // used to get lazy data from DB
            session.getTransaction().commit();
            System.out.println("Done!");
        }
        System.out.println(instructor);
        instructor.getCourses().forEach(System.out::println);
    }

}

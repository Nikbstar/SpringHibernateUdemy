package ru.nik66.hibernate.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.nik66.hibernate.entity.Course;
import ru.nik66.hibernate.entity.Instructor;
import ru.nik66.hibernate.entity.InstructorDetail;

public class CreateCourseDemoApp {

    public static void main(String[] args) {
        Course course = new Course("Docker for beginners");
        Course course1 = new Course("Java for beginners");
        Course course2 = new Course("C# for beginners");
        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            Instructor instructor = session.get(Instructor.class, 2);
            if (instructor != null) {
                instructor.add(course);
                instructor.add(course1);
                instructor.add(course2);
                session.save(course);
                session.save(course1);
                session.save(course2);
            }
            session.getTransaction().commit();
            System.out.println("Done!");
        }
    }

}

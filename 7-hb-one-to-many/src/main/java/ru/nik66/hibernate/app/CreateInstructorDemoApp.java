package ru.nik66.hibernate.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.nik66.hibernate.entity.Course;
import ru.nik66.hibernate.entity.Instructor;
import ru.nik66.hibernate.entity.InstructorDetail;

public class CreateInstructorDemoApp {

    public static void main(String[] args) {
        Course course = new Course("Docker for beginners");
        Course course1 = new Course("Java for beginners");
        Course course2 = new Course("C# for beginners");
        InstructorDetail instructorDetail = new InstructorDetail("love2code", "codding");
        Instructor instructor = new Instructor("Nikolay", "Kotkin", "nikolay@kotkin.com", instructorDetail);
        instructor.add(course);
        instructor.add(course1);
        instructor.add(course2);
        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            session.save(instructor);
            session.getTransaction().commit();
            System.out.println("Done!");
        }
    }

}

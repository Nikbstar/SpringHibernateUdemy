package ru.nik66.hibernate.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.nik66.hibernate.entity.Course;
import ru.nik66.hibernate.entity.Instructor;
import ru.nik66.hibernate.entity.InstructorDetail;

public class DeleteCourseDemoApp {

    public static void main(String[] args) {
        try(SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
            Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Instructor instructor = session.get(Instructor.class, 2);
            Course course = instructor.getCourses().get(1);
            session.delete(course);
            session.getTransaction().commit();
            System.out.println("Done!");
        }
    }

}

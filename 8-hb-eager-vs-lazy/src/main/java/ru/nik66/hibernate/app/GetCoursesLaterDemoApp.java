package ru.nik66.hibernate.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import ru.nik66.hibernate.entity.Course;
import ru.nik66.hibernate.entity.Instructor;
import ru.nik66.hibernate.entity.InstructorDetail;

import java.util.List;

public class GetCoursesLaterDemoApp {

    public static void main(String[] args) {
        List<Course> courses;
        int id = 2;
        try(SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
            Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Query<Course> query = session.createQuery("from Course c where c.instructor.id =: theInstructorId", Course.class);
            query.setParameter("theInstructorId", id);
            courses = query.getResultList();
            session.getTransaction().commit();
            System.out.println("Done!");
        }
        courses.forEach(System.out::println);
    }

}

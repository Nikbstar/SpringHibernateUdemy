package ru.nik66.hibernate.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.nik66.hibernate.entity.Instructor;
import ru.nik66.hibernate.entity.InstructorDetail;

public class CreateInstructorDemoApp {

    public static void main(String[] args) {
        InstructorDetail instructorDetail = new InstructorDetail("love2code", "codding");
        Instructor instructor = new Instructor("Nikolay", "Kotkin", "nikolay@kotkin.com", instructorDetail);
        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            session.save(instructor);
            session.getTransaction().commit();
            System.out.println("Done!");
        }
    }

}

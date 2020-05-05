package ru.nik66.hibernate.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.nik66.hibernate.entity.Instructor;
import ru.nik66.hibernate.entity.InstructorDetail;

public class DeleteInstructorDemoApp {

    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            Instructor instructor = session.get(Instructor.class, 1);
            System.out.println("DeleteInstructorDemoApp: getting an instructor:");
            System.out.println(instructor);
            if (instructor != null) {
                session.delete(instructor);
            }
            session.getTransaction().commit();
            System.out.println("Done!");
        }

    }

}

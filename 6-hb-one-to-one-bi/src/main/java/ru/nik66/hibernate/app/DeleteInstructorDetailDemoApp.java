package ru.nik66.hibernate.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.nik66.hibernate.entity.Instructor;
import ru.nik66.hibernate.entity.InstructorDetail;

public class DeleteInstructorDetailDemoApp {

    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            InstructorDetail detail = session.get(InstructorDetail.class, 7);
            if (detail!= null) {
                detail.getInstructor().setInstructorDetail(null);
                session.delete(detail);
            }
            session.getTransaction().commit();
            System.out.println("Done!");
        }
    }

}

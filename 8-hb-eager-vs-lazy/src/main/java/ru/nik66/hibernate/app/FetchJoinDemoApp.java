package ru.nik66.hibernate.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import ru.nik66.hibernate.entity.Course;
import ru.nik66.hibernate.entity.Instructor;
import ru.nik66.hibernate.entity.InstructorDetail;

public class FetchJoinDemoApp {

    public static void main(String[] args) {
        Instructor instructor;
        int id = 2;
        try(SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
            Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Query<Instructor> query = session.createQuery("select i from Instructor i join fetch i.courses where i.id =:theInstructorId", Instructor.class);
            query.setParameter("theInstructorId", id);
            instructor = query.getSingleResult();
            session.getTransaction().commit();
            System.out.println("Done!");
        }
        System.out.println(instructor);
        instructor.getCourses().forEach(System.out::println);
    }

}

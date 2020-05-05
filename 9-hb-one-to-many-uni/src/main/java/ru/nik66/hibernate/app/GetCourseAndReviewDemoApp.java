package ru.nik66.hibernate.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.nik66.hibernate.entity.Course;
import ru.nik66.hibernate.entity.Instructor;
import ru.nik66.hibernate.entity.InstructorDetail;
import ru.nik66.hibernate.entity.Review;

public class GetCourseAndReviewDemoApp {

    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            Course course = session.get(Course.class, 10);
            if (course != null) {
                System.out.println(course);
                course.getReviews().forEach(System.out::println);
            }
            session.getTransaction().commit();
            System.out.println("Done!");
        }
    }
}

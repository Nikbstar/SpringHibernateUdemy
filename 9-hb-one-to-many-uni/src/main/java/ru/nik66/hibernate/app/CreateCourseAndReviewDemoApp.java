package ru.nik66.hibernate.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.nik66.hibernate.entity.Course;
import ru.nik66.hibernate.entity.Instructor;
import ru.nik66.hibernate.entity.InstructorDetail;
import ru.nik66.hibernate.entity.Review;

public class CreateCourseAndReviewDemoApp {

    public static void main(String[] args) {
        Course course = new Course("Docker for beginners");
        course.addReview(new Review("Great course"));
        course.addReview(new Review("I love that"));
        course.addReview(new Review("that's sux"));
        course.addReview(new Review("what is it?"));


        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            session.save(course);
            session.getTransaction().commit();
            System.out.println("Done!");
        }
    }

}

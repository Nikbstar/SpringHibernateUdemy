package ru.nik66.hibernate.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.nik66.hibernate.entity.Course;
import ru.nik66.hibernate.entity.Instructor;
import ru.nik66.hibernate.entity.InstructorDetail;
import ru.nik66.hibernate.entity.Review;
import ru.nik66.hibernate.entity.Student;

public class AddCourseForStudentDemoApp {

    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            Student student = session.get(Student.class, 7);
            Course course = new Course("Packman course");
            course.addStudent(student);
            session.save(course);
            session.getTransaction().commit();
            System.out.println("Done!");
        }
    }

}

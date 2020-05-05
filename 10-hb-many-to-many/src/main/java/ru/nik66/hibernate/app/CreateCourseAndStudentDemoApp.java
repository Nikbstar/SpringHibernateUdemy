package ru.nik66.hibernate.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.nik66.hibernate.entity.Course;
import ru.nik66.hibernate.entity.Instructor;
import ru.nik66.hibernate.entity.InstructorDetail;
import ru.nik66.hibernate.entity.Review;
import ru.nik66.hibernate.entity.Student;

public class CreateCourseAndStudentDemoApp {

    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            Course courseDocker = new Course("Docker for beginners");
            Course courseJava = new Course("Java for pro");
            Course coursePHP = new Course("PHP for advanced");
            session.save(courseDocker);
            session.save(courseJava);
            session.save(coursePHP);
            Student studentAaa = new Student("Qqq", "Aaa", "qqq@aaa.com");
            studentAaa.addCourse(courseDocker);
            Student studentWww = new Student("Www", "Sss", "www@sss.com");
            studentWww.addCourse(courseDocker);
            studentWww.addCourse(courseJava);
            studentWww.addCourse(coursePHP);
            session.save(studentAaa);
            session.save(studentWww);
            session.getTransaction().commit();
            System.out.println("Done!");
        }
    }

}

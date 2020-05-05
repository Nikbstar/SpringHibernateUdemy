package ru.nik66.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.nik66.hibernate.demo.entity.Student;

public class UpdateStudentDemoApp {

    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory()) {
            int studentId = 1;
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            Student student = session.get(Student.class, studentId);
            System.out.println("UpdateStudentDemoApp: before update: " + student);
            student.setFirstName("Alex");
            session.update(student);
            session.getTransaction().commit();
            session = factory.getCurrentSession();
            session.beginTransaction();
            Student newStudent = session.get(Student.class, student.getId());
            System.out.println("UpdateStudentDemoApp: after update: " + newStudent);
            session.getTransaction().commit();
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.createQuery("update Student set email = 'foo@gmail.com'").executeUpdate();
            session.getTransaction().commit();
            System.out.println("UpdateStudentDemoApp: Done!");
        }
    }

}

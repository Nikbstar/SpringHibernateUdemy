package ru.nik66.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.nik66.hibernate.demo.entity.Student;

public class CreateStudentDemoApp {

    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            System.out.println("CreateStudentDemoApp: Creating new student object ...");
            Student student = new Student("Nikolay", "Kotkin", null, "nikbstar@gmail.com");
            session.beginTransaction();
            System.out.println("CreateStudentDemoApp: Saving the student...");
            session.save(student);
            session.getTransaction().commit();
            System.out.println("CreateStudentDemoApp: Done!");
        }
    }

}

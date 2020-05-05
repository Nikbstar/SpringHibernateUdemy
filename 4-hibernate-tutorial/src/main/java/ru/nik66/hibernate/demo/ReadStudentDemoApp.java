package ru.nik66.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.nik66.hibernate.demo.entity.Student;

public class ReadStudentDemoApp {

    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            System.out.println("ReadStudentDemoApp: Creating new student object ...");
            Student student = new Student("Nikolay", "Kotkin", null, "nikbstar@gmail.com");
            session.beginTransaction();
            System.out.println("ReadStudentDemoApp: Saving the student...");
            System.out.println("ReadStudentDemoApp: " + student);
            session.save(student);
            session.getTransaction().commit();
            System.out.println("ReadStudentDemoApp: Saved student. Generated id = " + student.getId());
            session = factory.getCurrentSession();
            session.beginTransaction();
            System.out.println("ReadStudentDemoApp: Getting student with id = " + student.getId());
            Student myStudent = session.get(Student.class, student.getId());
            System.out.println("ReadStudentDemoApp: Get complete: " + myStudent);
            session.getTransaction().commit();
            System.out.println("ReadStudentDemoApp: Done!");
        }
    }

}

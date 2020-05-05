package ru.nik66.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.nik66.hibernate.demo.entity.Student;

public class DeleteStudentDemoApp {

    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory()) {
            int studentId = 1;
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            Student student = session.get(Student.class, studentId);
            session.delete(student);
            session.getTransaction().commit();
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.createQuery("delete from Student s where s.id = 4").executeUpdate();
            session.getTransaction().commit();
            System.out.println("DeleteStudentDemoApp: Done!");
        }
    }

}

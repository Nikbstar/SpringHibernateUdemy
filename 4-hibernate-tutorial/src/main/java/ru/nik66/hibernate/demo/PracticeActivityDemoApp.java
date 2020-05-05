package ru.nik66.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.nik66.hibernate.demo.entity.Employee;

import java.util.List;

public class PracticeActivityDemoApp {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("employee.hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
        System.out.println("PracticeActivityDemoApp: creating...");
        Employee qqq = new Employee("qqq", "aaa", "zzz");
        Employee www = new Employee("www", "sss", "xxx");
        Employee eee = new Employee("eee", "ddd", "ccc");
        Employee rrr = new Employee("rrr", "fff", "vvv");
        Employee ttt = new Employee("ttt", "ggg", "bbb");
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.save(qqq);
        session.save(www);
        session.save(eee);
        session.save(rrr);
        session.save(ttt);
        session.getTransaction().commit();
        System.out.println("PracticeActivityDemoApp: Get concrete employee from table with id = " + qqq.getId());
        session = factory.getCurrentSession();
        session.beginTransaction();
        Employee tmp = session.get(Employee.class, qqq.getId());
        System.out.println(tmp);
        session.getTransaction().commit();
        System.out.println("PracticeActivityDemoApp: get created list:");
        session = factory.getCurrentSession();
        session.beginTransaction();
        List<Employee> employees = session.createQuery("from Employee", Employee.class).getResultList();
        employees.forEach(System.out::println);
        session.getTransaction().commit();
        System.out.println("PracticeActivityDemoApp: update employee with id = " + qqq.getId());
        session = factory.getCurrentSession();
        session.beginTransaction();
        qqq.setLastName("NIP");
        session.update(qqq);
        session.getTransaction().commit();
        System.out.println("PracticeActivityDemoApp: update company for all employees to QWERTY");
        session = factory.getCurrentSession();
        session.beginTransaction();
        session.createQuery("update Employee e set e.company = 'QWERTY'").executeUpdate();
        session.getTransaction().commit();
        System.out.println("PracticeActivityDemoApp: get created list:");
        session = factory.getCurrentSession();
        session.beginTransaction();
        employees = session.createQuery("from Employee", Employee.class).getResultList();
        employees.forEach(System.out::println);
        session.getTransaction().commit();
        System.out.println("PracticeActivityDemoApp: delete employee with id = " + www.getId());
        session = factory.getCurrentSession();
        session.beginTransaction();
        session.delete(www);
        session.getTransaction().commit();
        System.out.println("PracticeActivityDemoApp: delete employee with id = " + rrr.getId());
        session = factory.getCurrentSession();
        session.beginTransaction();
        session.createQuery("delete from Employee e where e.id = " + rrr.getId());
        session.getTransaction().commit();
        System.out.println("PracticeActivityDemoApp: get created list:");
        session = factory.getCurrentSession();
        session.beginTransaction();
        employees = session.createQuery("from Employee", Employee.class).getResultList();
        employees.forEach(System.out::println);
        session.getTransaction().commit();
    }

}

package ru.nik66.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.nik66.aopdemo.config.DemoConfig;
import ru.nik66.aopdemo.dao.AccountDAO;
import ru.nik66.aopdemo.entity.Account;

import java.util.List;

public class AfterThrowingDemoApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        List<Account> accounts = null;
        try {
            boolean tripWire = true;
            accountDAO.findAccounts(tripWire);
        } catch (Exception e) {
            System.out.println(">>> Main Program: caught the exception: " + e);
        }
        System.out.println("Main Program: AfterThrowingDemoApp");
        accounts.forEach(System.out::println);
        context.close();
    }

}

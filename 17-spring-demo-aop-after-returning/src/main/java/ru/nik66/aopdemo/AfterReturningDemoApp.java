package ru.nik66.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.nik66.aopdemo.config.DemoConfig;
import ru.nik66.aopdemo.dao.AccountDAO;
import ru.nik66.aopdemo.entity.Account;

import java.util.List;

public class AfterReturningDemoApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        List<Account> accounts = accountDAO.findAccounts();
        System.out.println("Main Program: AfterReturningDemoApp");
        accounts.forEach(System.out::println);
        context.close();
    }

}

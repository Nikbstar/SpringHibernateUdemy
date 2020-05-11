package ru.nik66.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.nik66.aopdemo.config.DemoConfig;
import ru.nik66.aopdemo.dao.AccountDAO;
import ru.nik66.aopdemo.dao.MembershipDAO;
import ru.nik66.aopdemo.entity.Account;

public class MainDemoApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
        Account account =  new Account();
        accountDAO.addAccount(account, true);
        accountDAO.doWork();
        membershipDAO.addSillyMember();
        membershipDAO.goToSleep();
        context.close();
    }

}

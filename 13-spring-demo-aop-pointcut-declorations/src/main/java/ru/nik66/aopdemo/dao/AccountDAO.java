package ru.nik66.aopdemo.dao;

import org.springframework.stereotype.Repository;
import ru.nik66.aopdemo.entity.Account;

@Repository
public class AccountDAO {

    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + ": DOING MY DB WORK: ADD ACCOUNT!");
    }

    public boolean doWork() {
        System.out.println(getClass() + ": DO WORK METHOD");
        return false;
    }

}

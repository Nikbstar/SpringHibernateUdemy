package ru.nik66.aopdemo.dao;

import org.springframework.stereotype.Repository;
import ru.nik66.aopdemo.entity.Account;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAO {

    private String name;
    private String serviceCode;

    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + ": DOING MY DB WORK: ADD ACCOUNT!");
    }

    public boolean doWork() {
        System.out.println(getClass() + ": DO WORK METHOD");
        return false;
    }

    public List<Account> findAccounts() {
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account("John", "Silver"));
        accounts.add(new Account("Madhu", "Platinum"));
        accounts.add(new Account("Luca", "Gold"));
        return accounts;
    }

    public String getName() {
        System.out.println(getClass() + ": getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": setServiceCode()");
        this.serviceCode = serviceCode;
    }

}

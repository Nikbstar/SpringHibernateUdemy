package ru.nik66.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDAO {

    public void addAccount() {
        System.out.println(getClass() + ": DOING MY DB WORK: ADD ACCOUNT!");
    }

}

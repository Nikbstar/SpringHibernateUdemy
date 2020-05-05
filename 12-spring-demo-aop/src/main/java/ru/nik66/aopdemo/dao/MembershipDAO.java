package ru.nik66.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAO {

    public void addSillyMember() {
        System.out.println(getClass() + ": DOING MY DB WORK: ADD ACCOUNT!");
    }

}

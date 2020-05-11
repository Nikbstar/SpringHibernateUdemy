package ru.nik66.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAO {

    public boolean addSillyMember() {
        System.out.println(getClass() + ": DOING MY DB WORK: ADD ACCOUNT!");
        return true;
    }

    public void goToSleep() {
        System.out.println(getClass() + ": I'm going to sleep now...");
    }

}

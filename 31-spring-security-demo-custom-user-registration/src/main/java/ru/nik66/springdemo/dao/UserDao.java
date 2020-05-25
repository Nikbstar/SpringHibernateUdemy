package ru.nik66.springdemo.dao;

import ru.nik66.springdemo.entity.User;

public interface UserDao {

    User findByUserName(String userName);
    void save(User user);

}

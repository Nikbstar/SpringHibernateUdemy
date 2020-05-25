package ru.nik66.springdemo.service;


import org.springframework.security.core.userdetails.UserDetailsService;
import ru.nik66.springdemo.entity.User;
import ru.nik66.springdemo.user.CrmUser;

public interface UserService extends UserDetailsService {

    User findByUserName(String userName);

    void save(CrmUser crmUser);

}

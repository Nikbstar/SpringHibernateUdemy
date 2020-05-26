package ru.nik66.springdemo.dao;

import ru.nik66.springdemo.entity.Role;

import java.util.List;

public interface RoleDao {

    Role findRoleByName(String theRoleName);

    List<Role> getAll();

}

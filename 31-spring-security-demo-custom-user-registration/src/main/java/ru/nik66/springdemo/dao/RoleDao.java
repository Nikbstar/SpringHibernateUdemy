package ru.nik66.springdemo.dao;

import ru.nik66.springdemo.entity.Role;

public interface RoleDao {

    Role findRoleByName(String theRoleName);

}

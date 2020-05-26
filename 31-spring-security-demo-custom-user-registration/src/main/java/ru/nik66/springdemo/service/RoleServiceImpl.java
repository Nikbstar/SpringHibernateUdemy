package ru.nik66.springdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.nik66.springdemo.dao.RoleDao;
import ru.nik66.springdemo.entity.Role;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleDao roleDao;

    @Override
    @Transactional
    public List<String> getAllRoles() {
        List<String> result = new ArrayList<>();
        List<Role> roles = roleDao.getAll();
        if (roles == null) {
            throw new RuntimeException("No role list found!");
        }
        for (Role role : roles) {
            result.add(role.getName());
        }
        return result;
    }

    @Autowired
    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }
}

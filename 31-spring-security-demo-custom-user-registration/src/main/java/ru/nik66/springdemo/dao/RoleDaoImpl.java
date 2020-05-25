package ru.nik66.springdemo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.nik66.springdemo.entity.Role;

@Repository
public class RoleDaoImpl implements RoleDao {

    private SessionFactory sessionFactory;

    @Override
    public Role findRoleByName(String theRoleName) {
        Session session = sessionFactory.getCurrentSession();
        Query<Role> query = session.createQuery("select from Role where name=:roleName", Role.class);
        query.setParameter("roleName", theRoleName);
        return query.getSingleResult();
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}

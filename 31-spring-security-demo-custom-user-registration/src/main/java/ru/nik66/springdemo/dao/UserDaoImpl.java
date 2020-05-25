package ru.nik66.springdemo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.nik66.springdemo.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;

    @Override
    public User findByUserName(String userName) {
        Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createQuery("select from User where userName=:uName", User.class);
        query.setParameter("uName", userName);
        return query.getSingleResult();
    }

    @Override
    public void save(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}

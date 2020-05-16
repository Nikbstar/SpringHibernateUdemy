package ru.nik66.springdemo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.nik66.springdemo.entity.Customer;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    private SessionFactory sessionFactory;

    @Override
    public Customer getCustomer(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.get(Customer.class, id);
    }

    @Override
    public List<Customer> getCustomers() {
        Session session = this.sessionFactory.getCurrentSession();
        Query<Customer> query = session.createQuery("select c from Customer c order by c.lastName, c.firstName", Customer.class);
        return query.getResultList();
    }

    @Override
    public void saveCustomer(Customer customer) {
        Session session = this.sessionFactory.getCurrentSession();
        session.saveOrUpdate(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(customer);
    }

    @Override
    public void deleteCustomer(Customer customer) {
        Session session = this.sessionFactory.getCurrentSession();
        session.delete(customer);
    }

    @Override
    public List<Customer> searchCustomers(String searchParam) {
        Session session = this.sessionFactory.getCurrentSession();
        Query<Customer> query;
        if (searchParam != null && !searchParam.isEmpty()) {
            query = session.createQuery("select c from Customer c where lower(c.firstName) like :searchParam or lower(c.lastName) like :searchParam or lower(c.email) like :searchParam order by c.lastName, c.firstName", Customer.class);
            query.setParameter("searchParam", "%" + searchParam.toLowerCase() + "%");
        } else {
            return getCustomers();
        }
        return query.getResultList();
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}

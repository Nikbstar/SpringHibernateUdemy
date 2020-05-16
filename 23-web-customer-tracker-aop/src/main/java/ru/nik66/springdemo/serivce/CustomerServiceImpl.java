package ru.nik66.springdemo.serivce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.nik66.springdemo.dao.CustomerDAO;
import ru.nik66.springdemo.entity.Customer;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerDAO customerDAO;

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return this.customerDAO.getCustomers();
    }

    @Override
    @Transactional
    public void saveCustomer(Customer customer) {
        this.customerDAO.saveCustomer(customer);
    }

    @Override
    @Transactional
    public void updateCustomer(Customer customer) {
        this.customerDAO.updateCustomer(customer);
    }

    @Override
    @Transactional
    public Customer getCustomer(int id) {
        return this.customerDAO.getCustomer(id);
    }

    @Override
    @Transactional
    public void deleteCustomer(Customer customer) {
        this.customerDAO.deleteCustomer(customer);
    }

    @Override
    @Transactional
    public List<Customer> searchCustomers(String searchParam) {
        return this.customerDAO.searchCustomers(searchParam);
    }

    @Autowired
    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

}

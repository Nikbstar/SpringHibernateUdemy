package ru.nik66.springdemo.dao;

import ru.nik66.springdemo.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    void updateCustomer(Customer customer);

    Customer getCustomer(int id);

    void deleteCustomer(Customer customer);

    List<Customer> searchCustomers(String searchParam);
}

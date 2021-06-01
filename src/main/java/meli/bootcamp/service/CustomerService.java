package meli.bootcamp.service;

import meli.bootcamp.entity.Customer;

import java.util.List;

public interface CustomerService {

    public void createCustomer(Customer seller);

    public Customer getCustomerById(Integer id);

    public List<Customer> getAllCustomers();

    public Customer updateCustomer (Customer customer);

    public void deleteCustomer (Integer id);
}

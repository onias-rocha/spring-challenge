package meli.bootcamp.rest;

import meli.bootcamp.entity.Customer;

import java.util.List;

public interface CustomerController {

    public void createCustomer(Customer seller);

    public Customer getCustomerById(Integer id);

    public List<Customer> getAllCustomers();

    public Customer updateCustomer (Integer id);

    public void deleteCustomer (Integer id);
}

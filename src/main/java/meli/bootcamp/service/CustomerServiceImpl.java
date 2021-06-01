package meli.bootcamp.service;

import meli.bootcamp.data.CustomerRepository;
import meli.bootcamp.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createCustomer(Customer seller) {

    }

    @Override
    public Customer getCustomerById(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        repository.findAll().forEach((customer) -> customers.add(customer));
        return customers;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public void deleteCustomer(Integer id) {

    }
}

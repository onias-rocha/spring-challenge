package meli.bootcamp.rest;

import meli.bootcamp.data.CustomerRepository;
import meli.bootcamp.entity.Customer;
import meli.bootcamp.service.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerControllerImpl implements CustomerController {

    CustomerService service;

    public CustomerControllerImpl(CustomerService service) {
        this.service = service;
    }

    @Override
    public void createCustomer(Customer seller) {

    }

    @Override
    public Customer getCustomerById(Integer id) {
        return null;
    }

    @Override
    @GetMapping("/api/customers")
    public List<Customer> getAllCustomers() {
        return service.getAllCustomers() ;
    }

    @Override
    public Customer updateCustomer(Integer id) {
        return null;
    }

    @Override
    public void deleteCustomer(Integer id) {

    }
}

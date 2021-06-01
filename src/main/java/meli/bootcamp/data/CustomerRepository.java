package meli.bootcamp.data;

import meli.bootcamp.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository <Customer, Integer> {
}

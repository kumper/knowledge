package pl.kp.db.mogodbtest.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import pl.kp.db.mogodbtest.entity.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    public Customer findByFirstName(String firstName);
    public List<Customer> findByLastName(String lastName);

}

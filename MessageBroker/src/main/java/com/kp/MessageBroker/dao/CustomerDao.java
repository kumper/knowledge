package com.kp.MessageBroker.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kp.MessageBroker.entity.Customer;

@Repository
public interface CustomerDao extends CrudRepository<Customer, Long> {

	List<Customer> findByLastName(String lastName);
}

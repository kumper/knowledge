package com.kp.frameworks.springjpavaadin.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kp.frameworks.springjpavaadin.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
}
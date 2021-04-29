package com.michalska.bank.service;

import com.michalska.bank.entities.Customer;
import com.michalska.bank.model.exception.CustomerNotFoundException;
import com.michalska.bank.repository.CustomerRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    @Lazy
    public CustomerService(@NonNull @Lazy CustomerRepository customerRepository, @Lazy CustomerService customerService) {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> getCustomers() {
        return StreamSupport.stream(customerRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
    }

    public List<Customer> findAllCustomers() {
        return (List<Customer>) this.customerRepository.findAll();
    }


}

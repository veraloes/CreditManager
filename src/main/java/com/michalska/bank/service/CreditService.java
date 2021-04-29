package com.michalska.bank.service;

import com.michalska.bank.entities.Credit;
import com.michalska.bank.entities.Customer;
import com.michalska.bank.entities.Product;
import com.michalska.bank.model.exception.CreditNotFoundException;
import com.michalska.bank.model.exception.CustomerNotFoundException;
import com.michalska.bank.model.exception.ProductNotFoundException;
import com.michalska.bank.repository.CreditRepository;
import com.michalska.bank.repository.CustomerRepository;
import com.michalska.bank.repository.ProductRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CreditService {

    private final CreditRepository creditRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    public CreditService creditService;

    @Autowired
    public CreditService(@NonNull @Lazy CreditRepository creditRepository, CustomerRepository customerRepository, ProductRepository productRepository) {
        this.creditRepository = creditRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    public List<Credit> findAllCredits() {
        return (List<Credit>) this.creditRepository.findAll();
    }

    public Credit createCredit(Credit credit) {
        return creditRepository.save(credit);
    }

    public boolean validate(Credit credit) {
        return credit.getCreditName() != null && credit.getCreditName().length() > 0
                && credit.getProduct().getProductName() != null && credit.getProduct().getProductName().length() > 0
                && credit.getProduct().getProductValue() != null && credit.getProduct().getProductValue().toString().length() > 0
                && credit.getCustomer().getFirstName() != null && credit.getCustomer().getFirstName().length() > 0
                && credit.getCustomer().getLastName() != null && credit.getCustomer().getLastName().length() > 0
                && credit.getCustomer().getPeselNumber() != null && credit.getCustomer().getPeselNumber().toString().length() == 11;
    }

    public Credit getCreditById(Long id) {
        return creditRepository.findById(id).orElseThrow(() -> new CreditNotFoundException(id));
    }

    public List<Credit> getCredits() {
        return StreamSupport.stream(creditRepository.findAll().spliterator(), false).collect(Collectors.toList());
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


    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getProducts() {
        return StreamSupport.stream(productRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }

    public List<Product> findAllProducts() {
        return (List<Product>) this.productRepository.findAll();
    }

}

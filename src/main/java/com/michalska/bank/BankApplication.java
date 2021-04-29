package com.michalska.bank;

import com.michalska.bank.entities.Credit;
import com.michalska.bank.entities.Customer;
import com.michalska.bank.entities.Product;
import com.michalska.bank.repository.CreditRepository;
import com.michalska.bank.repository.CustomerRepository;
import com.michalska.bank.repository.ProductRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BankApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(BankApplication.class, args);

        CustomerRepository customerRepository = configurableApplicationContext.getBean(CustomerRepository.class);
        Customer customer = new Customer(1, "Weronika", "Michalska", 95052134567L);
        customerRepository.save(customer);
        Customer customer1 = new Customer(2, "Anna", "Nowak", 96013034567L);
        customerRepository.save(customer1);
        Customer customer2 = new Customer(3, "John", "Smith", 74021102801L);
        customerRepository.save(customer2);
        Customer customer3 = new Customer(4, "Chris", "Brown", 79023098678L);
        customerRepository.save(customer3);

        ProductRepository productRepository = configurableApplicationContext.getBean(ProductRepository.class);
        Product product = new Product(1, "Consumer loan", 200000L);
        productRepository.save(product);
        Product product1 = new Product(2, "Mortgage", 45000L);
        productRepository.save(product1);
        Product product2 = new Product(3, "Auto Loan", 10000000L);
        productRepository.save(product2);
        Product product3 = new Product(4, "Installment", 500000L);
        productRepository.save(product3);

        CreditRepository creditRepository = configurableApplicationContext.getBean(CreditRepository.class);
        Credit credit = new Credit(1, "Consumer Credit", customer, product);
        creditRepository.save(credit);
        Credit credit1 = new Credit(2, "Investment Credit", customer1, product1);
        creditRepository.save(credit1);
        Credit credit2 = new Credit(3, "Export Credit", customer2, product2);
        creditRepository.save(credit2);
        Credit credit3 = new Credit(4, "Open Credit", customer3, product3);
        creditRepository.save(credit3);

    }

}

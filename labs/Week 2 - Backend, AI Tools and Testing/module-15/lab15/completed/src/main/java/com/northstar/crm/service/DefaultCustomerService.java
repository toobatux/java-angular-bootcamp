package com.northstar.crm.service;

import com.northstar.crm.entity.Customer;
import com.northstar.crm.entity.CustomerStatus;
import com.northstar.crm.exception.CustomerNotFoundException;
import com.northstar.crm.repository.CustomerRepository;
import java.util.List;
import java.util.Optional;

public class DefaultCustomerService implements CustomerService {
    // TODO: final CustomerRepository repository
    // TODO: final CustomerValidator validator
    private final CustomerRepository repository;
    private final CustomerValidator validator;

    public DefaultCustomerService(CustomerRepository repository, CustomerValidator validator) {
        // TODO: assign final fields (constructor DI — no field injection)
        this.repository = repository;
        this.validator = validator;
    }

    @Override
    public Customer addCustomer(Customer customer) {
        // TODO: validator.validateNew then repository.save
        validator.validateNew(customer);
        return repository.save(customer);
    }

    @Override
    public Optional<Customer> findById(String customerId) {
        // TODO: repository.findById
        return repository.findById(customerId);
    }

    @Override
    public List<Customer> listAll() {
        // TODO: return List.copyOf(repository.findAll()) — never leak mutable Map/List
        List<Customer> allCustomers = repository.findAll();
        return allCustomers == null ? List.of() : List.copyOf(allCustomers);
    }

    @Override
    public Customer changeStatus(String customerId, CustomerStatus newStatus, String correlationId) {
        // TODO: find or throw; validateTransition BEFORE setStatus; save; return
        Customer customer = findById(customerId).orElseThrow(() -> new CustomerNotFoundException("Customer not found with ID: " + customerId));
        validator.validateTransition(customer.getStatus(), newStatus, correlationId);
        customer.setStatus(newStatus);
        return repository.save(customer);
    }
}

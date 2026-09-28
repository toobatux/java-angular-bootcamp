package main.java.com.northstar.crm.service;

import main.java.com.northstar.crm.entity.Customer;
import main.java.com.northstar.crm.entity.CustomerStatus;
import main.java.com.northstar.crm.exception.CustomerNotFoundException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/** INTENTIONALLY MESSY — refactor in later steps. Do not submit this style. */
public class CustomerService {
    List<Customer> data = new ArrayList<>();

    public Object get(String id) {
        for (int i = 0; i < data.size(); i++) {
            Customer x = (Customer) data.get(i);
            if (x.getCustomerId().equals(id)) {
                return x;
            }
        }
        return null;
    }

    public void createCustomer(String id, String name, String phone, CustomerStatus status) {
        if (id == null) throw new IllegalArgumentException("Must provide id");
        if (name == null) throw new IllegalArgumentException("Must provide name");
        if (phone == null) throw new IllegalArgumentException("Must provide phone");
        if (status == null) throw new IllegalArgumentException("Must provide status");

        if (getCustomer(id) != null) {
            System.out.println("Duplicate");
            return;
        }

        Customer newCustomer = new Customer();
        newCustomer.setCustomerId(id);
        newCustomer.setFullName(name);
        newCustomer.setPhone(phone);
        newCustomer.setStatus(status);

        data.add(newCustomer);
        System.out.println("ok " + id);
    }

    public Customer getCustomer(String id) {
        if (id == null) return null;

        for (Customer customer : data) {
            if (customer.getCustomerId().equals(id)) {
                return customer;
            }
        }

        throw new CustomerNotFoundException("Customer with ID " + id + " not found.");
    }

    public void updateStatus(String id, CustomerStatus newStatus) {
        if (newStatus == null) throw new IllegalArgumentException("New status value cannot be null.");
        Customer customer = (Customer) getCustomer(id);
        customer.setStatus(newStatus);
    }

    // TODO: replace doStuff/get with createCustomer / getCustomer / updateStatus
    // TODO: typed List<Customer>, proper exceptions, equals (not ==), correlation-aware logs
}

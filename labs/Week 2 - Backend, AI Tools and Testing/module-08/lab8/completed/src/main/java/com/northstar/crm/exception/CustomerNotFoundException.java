package com.northstar.crm.exception;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(String customerId) {
        // TODO: call super("Customer not found: " + customerId)
        super("Customer not found for " + customerId);
    }
}

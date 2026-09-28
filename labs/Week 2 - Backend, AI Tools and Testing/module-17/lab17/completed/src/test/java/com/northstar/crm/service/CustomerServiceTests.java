package com.northstar.crm.service;

import com.northstar.crm.entity.Customer;
import com.northstar.crm.entity.CustomerStatus;
import com.northstar.crm.exception.BusinessException;
import com.northstar.crm.repository.InMemoryCustomerRepository;
import jakarta.validation.groups.Default;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceTests {
    DefaultCustomerService service;

    @BeforeEach
    void setUp() {
        // TODO: fresh InMemoryCustomerRepository + CustomerValidator + DefaultCustomerService each test
       InMemoryCustomerRepository repo = new InMemoryCustomerRepository();
       CustomerValidator validator = new CustomerValidator(repo);
       this.service = new DefaultCustomerService(repo, validator);
    }

    @Test
    void addAndActivateRaviHappyPath() {
        // TODO: add Amina ACTIVE + Ravi PROSPECT; changeStatus CUS-1002 → ACTIVE; assert ACTIVE
        Customer amina = Customer.amina();
        Customer ravi = Customer.ravi();
        service.addCustomer(amina);
        service.addCustomer(ravi);
        service.changeStatus(ravi.getCustomerId(), CustomerStatus.ACTIVE, "CUS-002");
        assertEquals(CustomerStatus.ACTIVE, service.findById(ravi.getCustomerId()).orElseThrow().getStatus());
    }

    @Test
    void duplicateIdThrowsConflict() {
        // TODO: add Amina twice → assertThrows BusinessException
        Customer amina = Customer.amina();
        service.addCustomer(amina);
        BusinessException exception = assertThrows(BusinessException.class, () -> service.addCustomer(amina));
        assertEquals("CUSTOMER_ALREADY_EXISTS", exception.getCode());
    }

    @Test
    void illegalTransitionThrowsConflict() {
        // TODO: ACTIVE → PROSPECT on CUS-1001 → BusinessException; status still ACTIVE
        Customer amina = Customer.amina();
        service.addCustomer(amina);
        BusinessException exception = assertThrows(BusinessException.class, () -> service.changeStatus(amina.getCustomerId(), CustomerStatus.PROSPECT, "CUS-001"));
        assertEquals("ILLEGAL_STATUS_TRANSITION", exception.getCode());
        assertEquals(CustomerStatus.ACTIVE, service.findById(amina.getCustomerId()).orElseThrow().getStatus());
    }

    @Test
    void missingCustomerThrowsNotFound() {
        // TODO: changeStatus CUS-9999 → BusinessException with CUSTOMER_NOT_FOUND
        BusinessException exception = assertThrows(BusinessException.class,
                () -> service.changeStatus("CUS-9999", CustomerStatus.ACTIVE, "CUS-9999"));
        assertEquals("CUSTOMER_NOT_FOUND", exception.getCode());
    }

    @Test
    void duplicateEmailThrowsConflict() {
        // TODO: add Amina; add other id with same email → BusinessException
        Customer amina = Customer.amina();
        service.addCustomer(amina);
        Customer duplicateEmailCustomer = new Customer("CUS-9999", "Amina Duplicate", "amina.khan@example.com", "123-456-7890", CustomerStatus.PROSPECT, LocalDateTime.now());
        BusinessException exception = assertThrows(BusinessException.class, () -> service.addCustomer(duplicateEmailCustomer));
        assertEquals("CUSTOMER_ALREADY_EXISTS", exception.getCode());
    }

    @Test
    void closedToActiveRejected() {
        // TODO: add CLOSED CUS-1001; changeStatus → ACTIVE throws BusinessException
        Customer closedCustomer = new Customer("CUS-1001", "Closed Customer", "closed@example.com", "123-456-7890", CustomerStatus.CLOSED, LocalDateTime.now());
        service.addCustomer(closedCustomer);
        BusinessException exception = assertThrows(BusinessException.class, () -> service.changeStatus(closedCustomer.getCustomerId(), CustomerStatus.ACTIVE, "CUS-1001"));
        assertEquals("ILLEGAL_STATUS_TRANSITION", exception.getCode());
    }
}

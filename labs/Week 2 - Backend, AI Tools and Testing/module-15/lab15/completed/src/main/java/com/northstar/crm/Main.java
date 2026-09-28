package com.northstar.crm;

import com.northstar.crm.entity.Customer;
import com.northstar.crm.entity.CustomerStatus;
import com.northstar.crm.repository.CustomerRepository;
import com.northstar.crm.repository.InMemoryCustomerRepository;
import com.northstar.crm.service.CustomerService;
import com.northstar.crm.service.CustomerValidator;
import com.northstar.crm.service.DefaultCustomerService;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // TODO: one shared InMemoryCustomerRepository for validator + service

        CustomerRepository repo = new InMemoryCustomerRepository();
        CustomerValidator validator = new CustomerValidator(repo);
        CustomerService service = new DefaultCustomerService(repo, validator);

        Customer amina = Customer.amina();
        Customer ravi = Customer.ravi();
        // TODO: addCustomer Amina (ACTIVE) and Ravi (PROSPECT)
        service.addCustomer(amina);
        service.addCustomer(ravi);

        // TODO: changeStatus CUS-1002 → ACTIVE with correlation lab-request-001
        service.changeStatus(amina.getCustomerId(), CustomerStatus.ACTIVE, "lab-request-001");

        // TODO: catch illegal ACTIVE → PROSPECT on CUS-1001; print message; prove still ACTIVE
        try {
            service.changeStatus(amina.getCustomerId(), CustomerStatus.PROSPECT, "lab-request-001");
        } catch (Exception e) {
            System.out.println("Amina status: " + amina.getStatus());
            Customer verifiedAmina = service.findById(amina.getCustomerId())
                    .orElseThrow(() -> new RuntimeException("Amina missing!"));

            System.out.println("Proof - Amina current status in system: " + verifiedAmina.getStatus());
        }
    }
}
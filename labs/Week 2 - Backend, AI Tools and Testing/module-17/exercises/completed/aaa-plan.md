# Lab 17 — AAA Service Tests Plan

## Happy path (Arrange / Act / Assert)
```text
Arrange:    Create mock repository with customer entity for Ravi (customerId = "CUS-1002", status=PROSPECT)
Act:        customerService.activateCustomer("CUS-1002", correlationId)
Assert:     Returned DTO has status ACTIVE and repository save() invoked
```

## Not found
```text
Arrange:    Mock repository returns Optional.empty() for "CUS-9999"
Act:        customerService.activateCustomer("CUS-9999", correlationId)
Assert:     Thrown exception is of type CustomerNotFoundException
```

## Illegal
```text
Arrange:    Create mock repository with customer entity for Amina (customerId = "CUS-1002", status=ACTIVE)
Act:        customerService.activateCustomer("CUS-1002", correlationId)
Assert:     Thrown exception is of type BusinessException (409)
```

## Scope
Pre-lab only.
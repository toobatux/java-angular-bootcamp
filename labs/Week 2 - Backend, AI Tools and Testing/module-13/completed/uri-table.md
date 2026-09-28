
# Lab 13 — Design the Resource URI Table

## Name the Nouns

Customers, interactions

## URI Table
```text
collection:     /api/customers
item:           /api/customers/CUS-1001
sub-resource:   /api/customers/CUS-1001/interactions
```

## Fix a Bad URI

```text
/getCustomerById?id=CUS-1001
GET /api/customers/CUS-1001
```

Move verb out from name and into the method

## Scope

Design only — no controller and no OpenAPI YAML written yet.
## Scope
Pre-lab only — do not finish the full lab in this exercise.
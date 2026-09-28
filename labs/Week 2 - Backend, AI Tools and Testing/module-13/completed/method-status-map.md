# Lab 13 — Map Methods to Status Codes

## Method Table
```text
GET     /api/customers                          200 OK, array of customers
GET     /api/customers/CUS-1001                 200 OK, specific customer object
POST    /api/customers                          201 Created, location to new resource
PUT     /api/customers/CUS-1001                 200 OK, updated object
DELETE  /api/customers/CUS-1001                 204 No Content
GET     /api/customers/CUS-1001/interactions    200 OK, array of interactions
POST    /api/customers/CUS-1001/interactions    201 Created, location to new resource
```
```text
GET on collection and item; 
POST on the collection; 
PUT and DELETE on the item.
```

## Success Codes

GET 200, POST 201 with Location: /api/customers/CUS-1003, PUT 200, DELETE 204 with no body.

## Failure Codes

GET /api/customers/CUS-9999 returns 404; a malformed create body returns 400.

## Safe vs Idempotent

GET safe and idempotent; PUT and DELETE idempotent but not safe; POST neither.


## Scope
Pre-lab only — do not finish the full lab in this exercise.
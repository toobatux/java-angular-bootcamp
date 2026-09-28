# Lab 13 — Sketch the OpenAPI Skeleton

## Top-Level Keys
```text
openapi
info
servers
paths
components
```

## Two Paths
```text
/customers          GET, POST
/customers/{id}     GET, PUT, DELETE
```

## Customer Schema
```text
String id
String name
String email
Status status (ACTIVE, PROSPECT)
```

## API-First
Writing the contract first lets the Angular team review and mock it before any controller exists.

_____
## Scope
Pre-lab only — do not finish the full lab in this exercise.
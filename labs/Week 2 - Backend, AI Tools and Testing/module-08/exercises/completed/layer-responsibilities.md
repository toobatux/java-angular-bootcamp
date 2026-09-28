### Assign the tasks

| Task | Layer |
| ---- | ----- |
| Accept future create-customer input | controller |
| Reject blank customer name | service |
| Find customer by ID | repository |
| Represent customer ID/name/status | entity |
| Represent create request fields | dto |
| Define customer-not-found failure | exception |
| Wire application objects later | config |


### Repair a “god controller”

Bad flow:

```text
Controller validates every business rule
→ edits an in-memory list directly
→ constructs database queries
→ formats errors
```

Rewrite it:

```text
Controller maps request
Service validates/handles it
Repository saves it or finds it
Service returns the result
Controller maps the response
```

### Explain why boundaries help

Write 3–5 sentences

```text
Boundaries allow for independent and specialized components. 
If we keep layers loosely coupled and specialized in their own concerns, later we can replace a layer without changing the others.
Boundaries make testing easier, as the layers are completely isolated.
```
# Request flow — create customer (Exercise 5)

1. Client sends create payload
2. Controller receives the payload, validates input data, maps it to internal request object
3. Service processes the business logic, checks for duplicate customers, prepares data for saving
4. Repository interacts with database to persist new customer record
5. Response DTO maps the saved entity data into a clean data transfer object and sends it back to the client with a success status

## Notes

<!-- seams for validation / exceptions later -->

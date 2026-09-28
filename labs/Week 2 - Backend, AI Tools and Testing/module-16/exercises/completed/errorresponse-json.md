# Lab 16 — ErrorResponse JSON Draft

## Fields
status, timestamp, message, error, path, correlationId

## Sample (CUS-9999)
```json
{ 
  "status": 404, 
  "message": "Customer CUS-9999 was not found.", 
  "correlationId": "lab-request-001"
}
```
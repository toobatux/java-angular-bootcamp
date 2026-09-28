# Lab 16 — Failure to Status Map

| Failure | Status |
| --- | --- |
| CUS-9999 not found | 404 |
| Illegal activate (Amina) | 409 |
| Validation blank/email | 400  |
| Unexpected bug | 500 |

## Conflict choice reason
409 State conflict, can't update from Active to Prospect

## Never
Never return 200 with an error

## Scope
Pre-lab only.
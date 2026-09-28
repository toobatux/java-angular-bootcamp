# Lab 15 — Fill Activate Ravi Pseudocode TODOs

customer = repo.findById(CUS-1002)
if customer is null → throw NotFound
if status is not PROSPECT → throw illegal transition
set status to ACTIVE
repo.save(customer)
log correlation lab-request-001

## Repo boundary
Repo saves state, does not decide PROSPECT to ACTIVE

## Scope
Pre-lab only.
# Lab 14 — Fill ValidatorFactory TODOs

## Step 1 — Copy TODOs
Bootstrap: ValidatorFactory factory = validation.buildDefaultValidatorFactory();
Validator validator = factory.getValidator();
Invalid blank name → expect >= 1 violations
Invalid status TYPO → expect >= 1 violations
Valid Amina ACTIVE sketch → expect 0 violations
Spring @Valid in this pre-lab? No

## Step 2 — Fill blanks
Use Validation.buildDefaultValidatorFactory(), factory.getValidator(), counts/messages, and `no` for Spring `@Valid`.

## Step 3 — Invalid cases list
1. blank fullName
2. unknown email
3. null customerId on activate

## Scope
Pre-lab only.
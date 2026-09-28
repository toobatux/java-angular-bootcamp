# Lab 16 — Catch Order

## Step 1 — List types
NotFoundException, ConflictException, BusinessException, ValidationException, Exception

## Step 2 — Order (top → bottom)
1. BusinessException
2. ValidationException
3. Exception

## Step 3 — Why
A broad handler would catch all exceptions, potentially masking
underlying issues and making debugging more difficult.

## Scope
Pre-lab only.
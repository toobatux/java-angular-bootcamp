# Equals vs ==

| Check | Use == or equals? | Why |
| ----- | ----------------- | --- |
| String customerId | .equals() | Compares structural values |
| enum CustomerStatus | == | Enums are singletons, only one instance of each constant exists |

## Step 2 — Bad snippet

Fail: `if (status == "ACTIVE")`

## Step 3 — Good snippet

Write a good conceptual check for Amina ACTIVE using equals or enum.
`if (Objects.equals(status, "ACTIVE"))`

## Step 4 — JDK note

Note: prefer enums on JDK 21 sketches when status set is closed.

## Scope
Pre-lab only — do not finish the full lab in this exercise.
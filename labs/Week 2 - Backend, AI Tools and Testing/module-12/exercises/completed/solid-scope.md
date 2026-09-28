# SOLID apply vs defer

| Principle | Apply now? | Defer? | Why |
| --------- | ---------- | ------ | --- |
| S | Y | N | Separate validation helper from persistence/repository code |
| O | N | Y | Stick to concrete classes for now. Defer interfaces/abstract factories until new requirements or business rules are added |
| L | N | Y | No deep inheritance hierarchy or subclassing needed yet |
| I | N | Y | Avoid creating monolithic interfaces. Defer until they emerge |
| D | N | Y | Defer abstract interfaces |

## Step 1 — Apply now

SRP: separate validation helper from persistence-shaped code in the sketch.

## Step 2 — Defer

Defer DIP wiring frameworks and ISP for large REST resource interfaces until Labs 13+.

## Step 3 — Why defer

Modules 10–12 stay before REST hosting; do not over-architect ports.

## Scope
Pre-lab only — do not finish the full lab in this exercise.
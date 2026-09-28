# Lab 13 — Plan Collections and Versioning

## Query Parameters

```text
page (default 0)
size
sort field, direction
status option
```

## Response Envelope
```text
Content
Page, size, total elements, total pages
```

## Version Choice
```text
/api/v1/...
Only updates for breaking changes
Simple, intuitive, easy to see in logs
```

## Breaking Change
```text
Non-breaking: adding an optional field
Breaking: Removing or changing a field/field's type
```
_____
## Scope
Pre-lab only — do not finish the full lab in this exercise.
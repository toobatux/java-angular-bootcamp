# Lab 12 — Smell Bingo

## Step 1 — Smell list

Bingo card: long method, magic strings for ACTIVE/PROSPECT, == on Strings, mixed I/O in domain, unclear names.

## Step 2 — Fixture tie-in

For each smell, note how it could corrupt CUS-1001 / CUS-1002 handling.

== on Strings: Using == instead of .equals() checks memory reference rather than value, causes status evaluations or checks to fail silently
Mixed I/O in Domain: If domain entities directly execute DB queries, network calls, or file reads, makes it impossible to unit test CUS-1001 processing in isolation without real external dependencies
Magic Strings: Typos can prevent customers from moving through the state machine properly ("ACTIVE" vs "Active")
Long Method: Everything is crammed together, makes it difficult to trace exactly where a payload became corrupted
Unclear names: Vague variables invite mistakes and increase cognitive load

## Step 3 — Priority

Star the two smells you will fix first in the timed lab.
== on Strings
Mixed I/O in Domain

## Scope
Pre-lab only — do not finish the full lab in this exercise.
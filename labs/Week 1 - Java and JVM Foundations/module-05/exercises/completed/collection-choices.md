# Collection choices

| # | Scenario | Need (order / unique / key→value / sorted) | Interface | Implementation | Why |
| - | -------- | ------------------------------------------ | --------- | -------------- | --- |
| 1 | Ordered catalog; duplicate titles allowed | ordered, duplicates | `List` | `ArrayList` | Maintains insertion order and allows duplicates |
| 2 | Unique registered book IDs | unique | `Set` | `HashSet` | No duplicates and doesn't need to be ordered or sorted |
| 3 | Book ID → current borrower ID | key->value | `Map` | `HashMap` | Key/value relationship, unique keys, doesn't need ordering |
| 4 | Alphabetically sorted categories | sorted, uniqueness | `Set` | `TreeSet` | Uniqueness, must be sorted |
| 5 | Category → count, sorted by category | key->value | `Map` | `TreeMap` | Key/value relationship, sorted order |
| 6 | Checkout history in event order | ordered | `List` | `LinkedList` | Maintains order and allows for duplicate transactions |
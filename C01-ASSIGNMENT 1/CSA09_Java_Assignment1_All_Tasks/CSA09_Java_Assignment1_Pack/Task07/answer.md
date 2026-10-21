# Task 7 — Override and Specialise Behaviour

`calculateFee()` can be a common method in `Vehicle` that calls the overridden `ratePerHour()` method. `TwoWheeler`, `Car` and other types return their own rates. Use `@Override` so the compiler detects signature mistakes. The overriding method must have a compatible return type and cannot reduce visibility. A `final` field is appropriate for an immutable registration number; a `final` method prevents subclasses changing an invariant; a `final` class prevents inheritance when extension is unsafe.

Override `toString()` for readable details. Override `equals()` and `hashCode()` consistently if registration number defines vehicle identity. If equality is based only on registration number, a `Car` and `ElectricCar` with the same registration may compare equal; that may be inappropriate if vehicle category is part of identity, so production design should explicitly decide whether category is included.

Alternative: one `switch` on a type field can calculate the rate in O(1) for a fixed finite set of types, but adding a type requires editing the switch and possibly other code. Overriding keeps type-specific behaviour with each subclass and supports extension with fewer changes.

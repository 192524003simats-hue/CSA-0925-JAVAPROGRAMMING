# Task 10 — Packages and Encapsulation

A possible package structure is `parking.model` (`Vehicle`, `ParkingTicket`, `ParkingSlot`), `parking.service` (`ParkingService`, `PricingRule`) and `parking.app` (main application). Fields should normally be `private`; public methods form the supported API; `protected` is appropriate for subclass extension hooks; package-private access is useful for tightly related internal classes.

Getters expose needed state without allowing arbitrary changes. Setters or constructors should reject negative duration, blank registration and invalid slot indexes. Wrapper classes such as `Integer` are useful in collections; autoboxing converts between `int` and `Integer`. Do not compare wrapper objects with `==` for numeric equality—use `.equals()` or unbox safely.

If fields were public and every caller performed validation, a missed check could corrupt state. Validation cost is O(1) per update, but caller-side validation duplicates checks across every call site; encapsulation centralizes the invariant.

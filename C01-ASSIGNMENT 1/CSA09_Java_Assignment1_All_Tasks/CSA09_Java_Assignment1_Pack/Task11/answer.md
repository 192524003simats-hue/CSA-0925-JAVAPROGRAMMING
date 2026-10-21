# Task 11 — Implement, Test and Defend the Design

The included `ParkingSystemDemo.java` demonstrates a small end-to-end model with different vehicle rates, slot allocation/release, duplicate registration rejection and fee calculation. Run it and compare its actual output with `output.txt`.

Test table:
- Normal: car enters, ticket issued, fee computed, slot released.
- Boundary: final available slot is allocated; the next allocation returns no slot.
- Zero minutes: fee is zero under the demo's stated policy.
- Slab boundary: every started hour is charged; 61 minutes means two billable hours.
- Invalid: negative duration, invalid slot and duplicate active registration are rejected.

Design evaluation: private state supports encapsulation; vehicle subclasses demonstrate inheritance and overriding; `Vehicle` references demonstrate polymorphism; abstract `Vehicle` and `Chargeable` separate common contract and optional capability. Limitation: this small demonstration uses in-memory state and does not persist active tickets across restart.

Alternative storage: searching an array or `ArrayList` for a ticket is O(n). A `HashMap<String, ParkingTicket>` keyed by registration is O(1) average lookup and O(n) space, though worst-case lookup can degrade and the map must enforce unique active registrations.

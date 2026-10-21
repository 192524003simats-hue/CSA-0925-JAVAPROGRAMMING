# Task 6 — Design the Inheritance Hierarchy

Suggested hierarchy: `Vehicle` (abstract) → `TwoWheeler`, `Car` → `ElectricCar`. This is hierarchical inheritance from `Vehicle` and multilevel inheritance from `Vehicle` through `Car` to `ElectricCar`. Common registration data and fee API belong in `Vehicle`; subclasses provide `ratePerHour()`. `ElectricCar` adds charging capability through `Chargeable`.

When `new ElectricCar(...)` runs, the superclass constructor chain executes first: `Vehicle` constructor, then `Car` constructor, then `ElectricCar` constructor body. `super(...)` passes registration data to the parent.

Alternative composition: one `Vehicle` has a `VehicleType`/rate strategy. Adding a new type can mean adding a configuration/strategy rather than a subclass. Both fee calculation approaches are O(1); inheritance may require one class per type, while composition is more flexible when rates change frequently. Object space is O(1) per vehicle in either design, with composition adding a reference to the strategy.

UML (text): `Vehicle <|-- TwoWheeler`; `Vehicle <|-- Car`; `Car <|-- ElectricCar`; `ElectricCar ..|> Chargeable`.

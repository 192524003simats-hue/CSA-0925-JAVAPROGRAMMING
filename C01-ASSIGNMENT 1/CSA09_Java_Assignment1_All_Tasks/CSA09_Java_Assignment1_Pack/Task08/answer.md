# Task 8 — Apply Polymorphism

Compile-time polymorphism is method overloading, e.g. `calculateFee(int minutes)` and `calculateFee(LocalDateTime in, LocalDateTime out)`. The compiler chooses the overload from argument types. Runtime polymorphism occurs when `Vehicle v = new ElectricCar(...)` and `v.calculateFee(130)` executes the subclass implementation selected by dynamic dispatch.

An array of `Vehicle` references can contain `TwoWheeler`, `Car` and `ElectricCar` objects (upcasting). The declared type is `Vehicle`; the actual object type determines the overridden method at runtime. This avoids repeated type-checking `if/else` chains.

The included `FeeDemo.java` implements the supplied assignment's hierarchy and expected demonstration. Note: the brief's expected output treats `Car` and `ElectricCar` with the same registration as equal because `equals()` compares registration only. Whether that is correct depends on the system's identity rule.

Alternative `instanceof` checks can take up to O(k) checks for k types and make code longer; dynamic dispatch is effectively O(1) method selection in the usual model, and is easier to extend.

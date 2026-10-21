# Task 4 — Classes, Objects and Constructors

`ParkingTicket` should keep `ticketId`, vehicle/registration, floor, slot and entry time together. Methods can include getters, `closeTicket(exitTime)` and `durationMinutes()`. A parameterized constructor creates a complete valid ticket; overloaded constructors may accept an explicit entry time or use the current time. Constructor chaining with `this(...)` centralizes validation. `super(...)` invokes a parent constructor in a subclass. A copy constructor is useful only for an independent historical copy; an active duplicate ticket should receive a new unique ID rather than copying the original ID.

The `this` keyword distinguishes fields from parameters and supports constructor chaining. Local reference variables are normally in stack frames; objects/arrays are allocated on the heap in typical JVM implementations. After no reachable reference remains, an object is eligible for garbage collection (timing is not guaranteed).

Alternative: setters after a default constructor can temporarily create invalid objects unless all setters validate. A parameterized constructor validates once at creation. A static factory can have a meaningful name and return a subtype/cached instance if appropriate. Creating n ordinary tickets is O(n) total time and O(n) heap space in all three approaches; factory methods do not change the asymptotic cost.

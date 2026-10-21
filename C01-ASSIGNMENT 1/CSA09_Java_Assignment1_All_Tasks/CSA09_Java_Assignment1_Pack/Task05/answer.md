# Task 5 — static Members and Object Life Cycle

A static ticket counter belongs to the class because all tickets need unique IDs; an instance counter would restart for each facility/ticket object and could duplicate IDs. Static utility methods are suitable for shared validation or formatting that does not depend on instance state. A static block is appropriate only for one-time class initialization, not routine ticket creation.

On exit, the active ticket is closed and removed from the active-ticket collection. It becomes eligible for garbage collection only when no reachable references remain; retained history/log records can keep relevant data alive. Java passes object references by value, so a method can use the referenced object but reassigning its local parameter does not reassign the caller's variable.

If each facility has its own instance counter, two gates can each issue ticket 1; this is acceptable only if ticket IDs are scoped by facility (e.g. facility code + counter). A static counter gives one shared sequence within the JVM. A single static counter uses O(1) space for k facilities and n tickets; k instance counters use O(k) space.

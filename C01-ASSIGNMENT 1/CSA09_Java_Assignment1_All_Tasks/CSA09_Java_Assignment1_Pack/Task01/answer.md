# Task 1 — Understand the Problem and Identify the Objects

## Inputs and outputs
Inputs: vehicle registration number and category, user type/pass validity, available floors/slots, entry and exit times, and charging energy for EVs. Outputs: allocated floor/slot, unique ticket, entry/exit record, parking fee, and a full-facility or invalid-input message.

## Candidate classes and responsibilities
- `Vehicle`: common registration number and category behaviour.
- `TwoWheeler`, `Car`, `ElectricCar`: category-specific hourly rates/capabilities.
- `ParkingSlot`: slot number, floor, suitability and occupied/free state.
- `ParkingFacility`: owns floors/slots and allocates/releases slots.
- `ParkingTicket`: ticket ID, vehicle, location and entry/exit times.
- `PricingRule`: calculates a fee for a duration/category.
- `ParkingPass`: represents a valid student/staff monthly pass or visitor day pass.
- `ParkingService`: coordinates entry/exit and checks duplicate registrations.

Nouns suggest candidate classes; verbs such as `allocate`, `release`, `issueTicket`, `closeTicket`, and `calculateFee` suggest methods.

## Business rules and assumptions
A slot holds at most one vehicle; a ticket ID is unique and not reused; registration numbers cannot have two active tickets; only compatible slots are allocated; invalid duration/slot/pass data is rejected. Assume parking duration is measured in minutes and the rate policy is supplied by the facility. EV charging is billed separately.

## Alternative: objects vs parallel arrays
With objects, registration, type and entry time stay together in one `Vehicle`/ticket object; adding a field requires changing the class and relevant construction/access methods. Parallel arrays (`regNo[]`, `type[]`, `entryTime[]`) require matching indexes and every new attribute adds another array, increasing mismatch risk. Linear search is O(n) in both designs; object references add a small per-object header/reference overhead, while parallel arrays store separate values/references. The object design is easier to maintain and validate.

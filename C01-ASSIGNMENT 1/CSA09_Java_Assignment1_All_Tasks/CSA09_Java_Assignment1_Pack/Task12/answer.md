# Task 12 — Day-4 Design Challenge

## A. Impact analysis
New requirements: e-bikes with a flat fee, delivery vans charged at twice the car rate from 9 AM to 5 PM, visitor one-day passes, and five floors with unequal slot counts. A jagged array (`ParkingSlot[][]`) already supports different slot counts. Pricing and pass logic are the main affected areas.

## B. Evaluate original design
A subclass-per-vehicle design can add `EBike` and `DeliveryVan`, but time-window pricing and pass rules can spread conditionals across subclasses. A `PricingRule` abstraction/strategy and a `ParkingPass` model keep policy separate from vehicle data. Existing tested slot/allocation code should remain unchanged.

## C. Decision: modify
Retain the slot model and abstract vehicle hierarchy; modify pricing to use rules, add `EBike`, `DeliveryVan` and a one-day pass. A jagged array represents uneven floors. The included `SmartParkingExtended.java` is a runnable demonstration of the new category rates and pass discount/exemption policy.

## D. Evidence-based defence
The demonstration tests the new categories and one-day pass. The allocation model does not need to change for new pricing categories. Adding a further vehicle type requires a new category/rule rather than rewriting slot allocation. Trade-off: a strategy-based design has more classes/configuration but localizes pricing changes and is easier to test.

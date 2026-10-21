# Task 3 — Design the Control Logic

## Allocation pseudocode
1. FOR each floor `f` from 0 to number of floors - 1
2.   FOR each slot `s` in floor `f`
3.     IF slot is free, store vehicle number and RETURN `{f, s}`
4.   END FOR
5. END FOR
6. RETURN `null` when no suitable slot exists.

## Release pseudocode
Validate floor bounds; validate slot bounds for that floor; if invalid or already free return false; otherwise set slot to free and return true.

## Fee pseudocode
Reject negative duration. Compute started hours as `(minutes + 59) / 60`. Select the applicable rate/slab with `if/else` or `switch`, apply any daily maximum/pass exemption, and return the fee. `break` exits a switch/loop, `continue` skips an unsuitable slot, and `return` ends the method as soon as the result is known.

## Complexity
For F floors and S total slots, a scan-based allocation is O(S) worst-case and O(1) extra space; release is O(1) after validating indexes. A stack/list of free slot coordinates can make allocation/release O(1) amortized but needs O(S) additional storage and careful synchronization.

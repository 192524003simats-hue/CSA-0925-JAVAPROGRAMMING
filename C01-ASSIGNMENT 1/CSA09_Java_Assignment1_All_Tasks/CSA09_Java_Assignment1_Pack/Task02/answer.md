# Task 2 — Choose the Data Representation

- Floor and slot indexes: `int`; registration number: `String`; entry/exit time: `java.time.LocalDateTime` or epoch milliseconds (`long`); duration: `long` minutes; fee: `double` for this teaching example, though `BigDecimal` is safer for real currency.
- Use a jagged array such as `ParkingSlot[][] slots`, where each row is one floor. It supports different slot counts per floor. A rectangular array wastes capacity or misrepresents floors if counts differ.
- Read interactive input with `Scanner`; command-line arguments are useful for scripted tests.
- Avoid integer truncation: `130 / 60` is `2`, not 2.1667. To bill every started hour, use integer ceiling arithmetic: `hours = (minutes + 59) / 60` for nonnegative minutes. For 61 minutes this gives 2 hours. Validate minutes >= 0 before calculation.

## Alternative representations
A single one-dimensional array works cleanly when every floor has the same number of slots: `index = floor * slotsPerFloor + slot`, with O(1) direct access. With uneven floors, that formula needs prefix offsets or a mapping table. `ArrayList<ParkingSlot[]>` naturally supports different row lengths and is also O(1) to index a known floor/slot. All representations store O(S) slot references for S total slots.

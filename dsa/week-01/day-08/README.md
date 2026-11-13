
# Day 008 — Reverse Integer

## Problem Information

- **Platform:** LeetCode
- **Problem:** 7. Reverse Integer
- **Difficulty:** Medium
- **Languages:** Java, Python
- **DSA Pattern:** Digit Manipulation
- **Technique:** Mathematical Simulation
- **Topics:** Math, While Loop, Modulus, Integer Division, Overflow Handling

**Problem Link:** https://leetcode.com/problems/reverse-integer/

## Problem Statement

Given a signed 32-bit integer `x`, return the integer with its digits reversed.

If the reversed number exceeds the signed 32-bit integer range, return `0`.

**32-bit Integer Range:**
- Minimum: -2,147,483,648
- Maximum: 2,147,483,647

## Examples

| Input | Output |
|-------|--------|
| 123 | 321 |
| -123 | -321 |
| 120 | 21 |
| 1534236469 | 0 |

## Approach — Digit Manipulation

The algorithm uses four main steps:

1. Extract the last digit using `x % 10`.
2. Check whether appending the digit would cause integer overflow.
3. Build the reversed number using `rev * 10 + digit`.
4. Remove the last digit using integer division.

Repeat until the input number becomes zero.

### Core Logic

```text
digit = x % 10
Check integer overflow
rev = rev * 10 + digit
x = x / 10
```

## Dry Run

Input: `x = 123`

| Iteration | x | digit | rev |
|-----------|---|-------|-----|
| Initial | 123 | - | 0 |
| 1 | 12 | 3 | 3 |
| 2 | 1 | 2 | 32 |
| 3 | 0 | 1 | 321 |

Final Output: `321`

## Java Solution

See [ReverseInteger.java](Rev.java).

## Python Solution

See [reverse_integer.py](rev.py).

## Complexity Analysis

**Time Complexity: O(log |x|)**

- Each iteration removes one decimal digit.
- The number of iterations is proportional to the number of digits.
- For a fixed 32-bit integer, at most 10 iterations are needed.

**Space Complexity: O(1)**

- Only a fixed number of variables are used.
- No additional arrays or data structures are required.

## Key Concepts Learned

- Modulus `% 10` extracts the last digit.
- Integer division by 10 removes the last digit.
- Multiplying by 10 shifts digits left.
- Overflow must be checked before updating the reversed integer.
- Java uses fixed-size 32-bit integers.
- Python requires explicit 32-bit range validation for this problem.

## Edge Cases

- Negative input: -123 → -321
- Trailing zeros: 120 → 21
- Zero input: 0 → 0
- Integer overflow: return 0

## Pattern Recognition

Use the Digit Manipulation pattern when problems involve:

- Reversing digits
- Counting digits
- Calculating digit sums
- Checking palindrome numbers
- Extracting individual digits

## Related Problems

- LeetCode 9 — Palindrome Number
- LeetCode 258 — Add Digits
- LeetCode 1281 — Subtract the Product and Sum of Digits of an Integer
- LeetCode 1295 — Find Numbers with Even Number of Digits

## Learning Outcome

Learned how to reverse integers using mathematical operations without converting them to strings, while handling negative numbers and integer overflow.

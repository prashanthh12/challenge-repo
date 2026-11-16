
# LeetCode 258 — Add Digits

## Problem Information

- **Platform:** LeetCode
- **Problem:** 258. Add Digits
- **Difficulty:** Easy
- **Language:** Java
- **DSA Pattern:** Digit Manipulation
- **Technique:** Mathematical Simulation
- **Topics:** Math, Nested While Loops, Modulus, Integer Division

**Problem Link:** https://leetcode.com/problems/add-digits/

## Problem Statement

Given a non-negative integer `num`, repeatedly add all
its digits until the result contains only one digit.

Return the final single-digit number.

## Examples

| Input | Process | Output |
|-------|---------|--------|
| 38 | 3+8=11, 1+1=2 | 2 |
| 0 | Already one digit | 0 |
| 123 | 1+2+3=6 | 6 |
| 999 | 9+9+9=27, 2+7=9 | 9 |
| 10 | 1+0=1 | 1 |

## Approach — Digit Manipulation

1. Check whether the number has two or more digits.
2. Initialize `sum = 0`.
3. Extract the last digit using `x % 10`.
4. Add the extracted digit to `sum`.
5. Remove the last digit using `x / 10`.
6. Repeat until all digits are processed.
7. Assign `x = sum`.
8. Repeat the process until `x < 10`.
9. Return `x`.

## Java Solution

See [AddDigits.java](AddDigits.java).

## Core Logic

```java
while (x >= 10) {
    int sum = 0;

    while (x > 0) {
        sum += x % 10;
        x = x / 10;
    }

    x = sum;
}
```

## Dry Run

Input: `num = 38`

### First Round

| Step | x | x % 10 | sum |
|------|---|--------|-----|
| Initial | 38 | - | 0 |
| 1 | 3 | 8 | 8 |
| 2 | 0 | 3 | 11 |

After the first round: `x = 11`

### Second Round

| Step | x | x % 10 | sum |
|------|---|--------|-----|
| Initial | 11 | - | 0 |
| 1 | 1 | 1 | 1 |
| 2 | 0 | 1 | 2 |

After the second round: `x = 2`

Since `2 < 10`, the outer loop stops.

**Final Output: 2**

## Important Concepts

### Modulus Operator

`x % 10` extracts the last digit.

Example:
- 38 % 10 = 8
- 123 % 10 = 3

### Integer Division

`x / 10` removes the last digit.

Example:
- 38 / 10 = 3
- 123 / 10 = 12

### Nested While Loops

- Outer loop: Repeats digit summation until one digit remains.
- Inner loop: Extracts and adds all digits of the current number.

### Resetting the Sum

`sum = 0` must be inside the outer loop.

Each new round starts with a fresh sum.

## Complexity Analysis

**Time Complexity: O(log num)**

- Each inner-loop iteration processes one digit.
- The number of digits is logarithmic in the input value.
- The digit-sum rounds process progressively smaller numbers.

**Space Complexity: O(1)**

- Only a fixed number of integer variables are used.
- No additional arrays or collections are created.

## Edge Cases

- num = 0 → 0
- num = 9 → 9
- num = 10 → 1
- num = 99 → 9
- num = 999 → 9

## Alternative Approach — Digital Root

The same problem can be solved mathematically.

```java
class Solution {
    public int addDigits(int num) {
        if (num == 0) {
            return 0;
        }

        return 1 + (num - 1) % 9;
    }
}
```

**Time Complexity:** O(1)

**Space Complexity:** O(1)

## Pattern Recognition

Use Digit Manipulation for:

- Extracting digits
- Finding the sum of digits
- Reversing integers
- Counting digits
- Checking palindrome numbers

## Related Problems

- LeetCode 7 — Reverse Integer
- LeetCode 9 — Palindrome Number
- LeetCode 1281 — Subtract Product and Sum of Digits
- LeetCode 1295 — Find Numbers with Even Number of Digits

## Learning Outcome

Learned how to repeatedly calculate the digit sum of
an integer using nested while loops, modulus,
integer division, and mathematical simulation.

Also learned the Digital Root optimization.

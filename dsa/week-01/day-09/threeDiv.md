
# LeetCode 1952 — Three Divisors

## Problem Information

- **Platform:** LeetCode
- **Problem Number:** 1952
- **Problem Name:** Three Divisors
- **Difficulty:** Easy
- **Language:** Java
- **DSA Pattern:** Divisor Counting
- **Approach:** Brute Force
- **Topics:** Math, Number Theory, For Loop, Modulus Operator

**Problem Link:** https://leetcode.com/problems/three-divisors/

## Problem Statement

Given an integer `n`, return `true` if it has
exactly three positive divisors. Otherwise,
return `false`.

A divisor is a number that divides another
number without leaving a remainder.

## Examples

| Input | Divisors | Output |
|-------|----------|--------|
| 2 | 1, 2 | false |
| 4 | 1, 2, 4 | true |
| 6 | 1, 2, 3, 6 | false |
| 9 | 1, 3, 9 | true |
| 16 | 1, 2, 4, 8, 16 | false |
| 25 | 1, 5, 25 | true |

## Approach — Brute Force Divisor Counting

The idea is to check every positive integer
from `1` to `n` and count how many divide
`n` exactly.

### Algorithm

1. Initialize `count = 0`.
2. Iterate from `i = 1` to `i = n`.
3. Check whether `n % i == 0`.
4. If true, increment `count`.
5. After the loop, check whether `count == 3`.
6. Return `true` if exactly three divisors exist.
7. Otherwise, return `false`.

## Java Solution

```java
class Solution {
    public boolean isThree(int x) {
        int count = 0;

        for (int i = 1; i <= x; i++) {
            if (x % i == 0) {
                count++;
            }
        }

        return count == 3;
    }
}
```

## Dry Run

Input: `x = 4`

Initially:

`count = 0`

| Iteration | i | x % i | Divisor? | count |
|-----------|---|-------|----------|-------|
| 1 | 1 | 0 | Yes | 1 |
| 2 | 2 | 0 | Yes | 2 |
| 3 | 3 | 1 | No | 2 |
| 4 | 4 | 0 | Yes | 3 |

After the loop:

`count = 3`

`return count == 3`

**Output: true**

## Important Concepts

### 1. Modulus Operator (%)

The modulus operator returns the remainder
after division.

Example:

- `4 % 1 = 0` → Divisor
- `4 % 2 = 0` → Divisor
- `4 % 3 = 1` → Not a divisor
- `4 % 4 = 0` → Divisor

### 2. For Loop

```java
for (int i = 1; i <= x; i++)
```

- Starts at 1.
- Checks every number up to x.
- Uses `i++` to move to the next number.

### 3. Counter Variable

```java
count++;
```

Increases the divisor count by one whenever
a valid divisor is found.

### 4. Boolean Return

```java
return count == 3;
```

Returns:
- `true` when count is exactly 3.
- `false` otherwise.

## Complexity Analysis

### Time Complexity: O(n)

- The loop runs from 1 to n.
- Each iteration performs a constant-time
  modulus operation and comparison.
- Therefore, total time complexity is O(n).

### Space Complexity: O(1)

- Only two additional integer variables
  (`count` and `i`) are used.
- No additional arrays or collections.
- Therefore, auxiliary space is O(1).

## Mathematical Observation

A positive integer has exactly three
positive divisors if and only if it is
the square of a prime number.

Examples:

- 4 = 2² → Divisors: 1, 2, 4
- 9 = 3² → Divisors: 1, 3, 9
- 25 = 5² → Divisors: 1, 5, 25
- 49 = 7² → Divisors: 1, 7, 49

This observation can be used to develop
a more optimized solution.

## Pattern Recognition

**Primary Pattern:** Divisor Counting

**Technique:** Brute Force Enumeration

Use this pattern for problems involving:

- Finding divisors of a number
- Counting factors
- Checking divisibility
- Prime number checking
- Perfect square properties

## Edge Cases

- n = 1 → false
- n = 2 → false
- n = 4 → true
- n = 9 → true
- n = 16 → false
- n = 25 → true

## Related Problems

- LeetCode 204 — Count Primes
- LeetCode 2427 — Number of Common Factors
- LeetCode 507 — Perfect Number
- LeetCode 2520 — Count the Digits That Divide a Number

## Learning Outcome

Learned how to count positive divisors
using a for loop and modulus operator.

Understood brute force enumeration,
divisibility checks, boolean return values,
and O(n) time / O(1) space complexity.

Also learned that numbers with exactly
three positive divisors are squares of
prime numbers.


# LeetCode 509 — Fibonacci Number

## Problem Information

- **Platform:** LeetCode
- **Problem Number:** 509
- **Difficulty:** Easy
- **Language:** Java
- **DSA Pattern:** Recursion
- **Technique:** Recursive Decomposition
- **Topics:** Math, Recursion, Base Case, Call Stack, Dynamic Programming

**Problem Link:** https://leetcode.com/problems/fibonacci-number/

## Problem Statement

Given an integer `n`, return the nth Fibonacci number.

The Fibonacci sequence starts with:

F(0) = 0
F(1) = 1

For n > 1:

F(n) = F(n - 1) + F(n - 2)

Each Fibonacci number is the sum of the
previous two Fibonacci numbers.

## Examples

| Input | Calculation | Output |
|-------|-------------|--------|
| n = 0 | F(0) = 0 | 0 |
| n = 1 | F(1) = 1 | 1 |
| n = 2 | F(1) + F(0) | 1 |
| n = 3 | F(2) + F(1) | 2 |
| n = 4 | F(3) + F(2) | 3 |
| n = 5 | F(4) + F(3) | 5 |

## Approach 1 — Recursion

### Intuition

Break the problem into two smaller subproblems.

To calculate F(n), calculate:

- F(n - 1)
- F(n - 2)

Then add their results.

Continue recursively until reaching
the base cases F(0) and F(1).

### Algorithm

1. Create a recursive method `fib(n)`.
2. Check whether n is 0 or 1.
3. If n <= 1, return n.
4. Otherwise, recursively calculate fib(n - 1).
5. Recursively calculate fib(n - 2).
6. Add and return both results.

## Java Solution — Recursion

```java
class Solution {
    public int fib(int n) {

        if (n <= 1) {
            return n;
        }

        return fib(n - 1) + fib(n - 2);
    }
}
```

## Core Logic

```java
if (n <= 1) {
    return n;
}

return fib(n - 1) + fib(n - 2);
```

### Base Case

```java
if (n <= 1) {
    return n;
}
```

Stops recursion when n is 0 or 1.

- fib(0) returns 0.
- fib(1) returns 1.

### Recursive Case

```java
return fib(n - 1) + fib(n - 2);
```

Divides the problem into two smaller
recursive calls and adds their results.

## Recursion Tree

Input: n = 4

```text
                fib(4)
               /      \
          fib(3)       fib(2)
         /      \      /    \
     fib(2)   fib(1) fib(1) fib(0)
     /   \
 fib(1) fib(0)
```

Base cases:
- fib(0) = 0
- fib(1) = 1

## Dry Run

Input: n = 4

fib(4) = fib(3) + fib(2)

fib(3) = fib(2) + fib(1)
       = 1 + 1
       = 2

fib(2) = fib(1) + fib(0)
       = 1 + 0
       = 1

Therefore:

fib(4) = 2 + 1 = 3

**Output: 3**

## Important Concepts

### 1. Recursion

A function calls itself to solve
smaller versions of a problem.

### 2. Base Case

The condition that stops recursion.

Without a base case, recursive calls
could continue until stack overflow.

### 3. Multiple Recursive Calls

Fibonacci uses two recursive calls:

```java
fib(n - 1) + fib(n - 2)
```

This produces a branching recursion tree.

### 4. Overlapping Subproblems

Some Fibonacci numbers are calculated
multiple times.

For example, fib(2) appears more than once
in the recursion tree for fib(4).

This repeated work makes basic recursion
inefficient for larger inputs.

### 5. Dynamic Programming

Dynamic Programming improves Fibonacci
calculation by storing previously
calculated results.

Common approaches:
- Memoization (Top-Down)
- Tabulation (Bottom-Up)
- Space-optimized iteration

## Complexity Analysis — Recursion

### Time Complexity: O(2^n)

Each non-base recursive call generates
two smaller recursive calls.

The recursion tree grows exponentially.

O(2^n) is a valid upper bound.

A tighter bound is O(phi^n), where
phi is approximately 1.618.

### Space Complexity: O(n)

Maximum recursion depth is proportional to n.

Each recursive call occupies stack memory.

Therefore, auxiliary space is O(n).

## Approach 2 — Iterative Optimization

```java
class Solution {
    public int fib(int n) {

        if (n <= 1) {
            return n;
        }

        int a = 0;
        int b = 1;

        for (int i = 2; i <= n; i++) {
            int next = a + b;
            a = b;
            b = next;
        }

        return b;
    }
}
```

### Iterative Approach Explanation

- `a` stores the previous Fibonacci number.
- `b` stores the current Fibonacci number.
- `next` stores their sum.
- Update the two variables after each iteration.

### Complexity Comparison

| Approach | Time | Extra Space |
|----------|------|-------------|
| Basic Recursion | O(2^n) | O(n) |
| Memoization | O(n) | O(n) |
| Iteration | O(n) | O(1) |

## Edge Cases

- n = 0 → 0
- n = 1 → 1
- n = 2 → 1
- n = 3 → 2
- n = 4 → 3

## Pattern Recognition

**Primary Pattern:** Recursion

**Technique:** Divide into Smaller Subproblems

**Optimization Pattern:** Dynamic Programming

Use similar techniques for:

- Fibonacci Number
- Climbing Stairs
- Tribonacci Number
- Recursive Factorial
- Dynamic Programming problems

## Related LeetCode Problems

- 70 — Climbing Stairs
- 1137 — N-th Tribonacci Number
- 746 — Min Cost Climbing Stairs
- 198 — House Robber

## Learning Outcome

Learned how to calculate Fibonacci numbers
using recursion.

Understood:
- Base cases
- Multiple recursive calls
- Recursive decomposition
- Recursion trees
- Overlapping subproblems
- Time and space complexity
- Iterative optimization

Also learned why Dynamic Programming
can avoid repeated calculations.

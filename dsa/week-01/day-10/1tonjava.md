
# Print 1 to N Using Recursion

## Problem Information

- **Problem:** Print 1 to N Using Recursion
- **Difficulty:** Easy
- **Language:** Java
- **DSA Pattern:** Linear Recursion
- **Technique:** Recursive Decomposition
- **Topics:** Recursion, Base Case, Recursive Call, Call Stack

## Problem Statement

Given a positive integer `N`, print all integers
from `1` to `N` in ascending order using recursion.

Do not use loops.

## Examples

### Example 1
Input: N = 5

Output: 1 2 3 4 5

### Example 2
Input: N = 3

Output: 1 2 3

## Approach — Recursion

The problem is divided into smaller subproblems.

To print numbers from 1 to N:

1. Check the base case.
2. If N == 0, stop recursion.
3. Recursively call the function with N - 1.
4. Print N after the recursive call.
5. Repeat until all recursive calls return.

### Core Logic

```java
if (n == 0) {
    return;
}

rec(n - 1);
System.out.println(n);
```

## Java Solution

```java
class Sol {
    public void rec(int n) {

        if (n == 0) {
            return;
        }

        rec(n - 1);
        System.out.println(n);
    }
}

class Rec {
    public static void main(String[] args) {
        Sol s = new Sol();
        s.rec(7);
    }
}
```

## Dry Run

Input: N = 5

### Step 1 — Recursive Calling Phase

```text
rec(5)
  rec(4)
    rec(3)
      rec(2)
        rec(1)
          rec(0) → Base Case
```

The function keeps calling itself with N - 1.

When N becomes 0, recursion stops.

### Step 2 — Returning Phase

After reaching the base case, the recursive
calls return in reverse order.

```text
rec(0) → return
rec(1) → print 1
rec(2) → print 2
rec(3) → print 3
rec(4) → print 4
rec(5) → print 5
```

Final Output:

```text
1
2
3
4
5
```

## Important Concepts

### 1. Base Case

```java
if (n == 0) {
    return;
}
```

- Stops recursion.
- Prevents infinite recursive calls.
- Returns control to the previous function call.

### 2. Recursive Call

```java
rec(n - 1);
```

- Calls the same function with a smaller input.
- Reduces N by 1 each time.
- Eventually reaches the base case.

### 3. Printing After Recursion

```java
rec(n - 1);
System.out.println(n);
```

The print statement runs during the
returning (unwinding) phase.

Therefore, numbers print in ascending order.

### 4. Printing Before Recursion

```java
System.out.println(n);
rec(n - 1);
```

If printing happens before the recursive
call, the output is in descending order.

For N = 5:

```text
5
4
3
2
1
```

### 5. void vs int

- `void` is used when a function does not
  need to return a value.
- `int` is used when a function must return
  an integer result.
- Since this problem only prints numbers,
  the return type is `void`.

## Complexity Analysis

### Time Complexity: O(N)

- The recursive method is called N + 1 times.
- Each call performs constant work,
  excluding the recursive call.
- Total time grows linearly with N.

T(N) = T(N - 1) + O(1)

Therefore:

**Time Complexity = O(N)**

### Auxiliary Space Complexity: O(N)

- Every recursive call creates a stack frame.
- The maximum recursion depth is N + 1.
- No additional arrays are created.

S(N) = S(N - 1) + O(1)

Therefore:

**Space Complexity = O(N)**

## Pattern Recognition

**Primary Pattern:** Linear Recursion

**Technique:** Recursive Decomposition

Use this pattern for:

- Printing 1 to N
- Printing N to 1
- Finding factorial
- Calculating sum of first N numbers
- Processing arrays recursively

## Edge Cases

- N = 1 → Print 1
- N = 5 → Print 1, 2, 3, 4, 5
- N = 0 → Print nothing

## Key Learning

1. Every recursive function needs a base case.
2. Each recursive call should move toward the base case.
3. Printing before recursion produces descending order.
4. Printing after recursion produces ascending order.
5. Recursion uses call stack memory.
6. A void function can use `return;` to stop execution.

## Learning Outcome

Learned how to print numbers from 1 to N
using recursion without loops.

Understood base cases, recursive calls,
the calling phase, the returning phase,
and how to calculate time and space complexity.

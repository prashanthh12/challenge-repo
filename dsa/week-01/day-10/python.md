
# Print 1 to N Using Recursion

## Problem Information

- **Topic:** Recursion
- **Pattern:** Linear Recursion
- **Type:** Basic DSA
- **Difficulty:** Easy
- **Language:** Python

## 1. Problem Statement

Given a positive integer N, print all numbers from 1 to N
in ascending order using recursion.

### Example

Input:
N = 5

Output:
1 2 3 4 5

### Constraints

- N >= 1
- Do not use loops.
- Use recursion.

## 2. Understand the Problem

We need to print numbers starting from 1 up to N.

For N = 5:

1 -> 2 -> 3 -> 4 -> 5

Instead of using a for loop, we must solve this
problem by calling the same function repeatedly.

## 3. Divide Into Subproblems

Main problem:
Print numbers from 1 to 5.

Break it into smaller problems:

Print(5) = Print(4) + Print 5
Print(4) = Print(3) + Print 4
Print(3) = Print(2) + Print 3
Print(2) = Print(1) + Print 2
Print(1) = Print(0) + Print 1

At Print(0), recursion stops.

### General Pattern

Print(N) = Print(N - 1) + Print N

This means:

1. Solve the smaller problem first.
2. Print the current number.

## 4. Identify the Base Case

A base case is the condition that stops recursion.

```python
if n == 0:
    return
```

Why?

When n becomes 0, there are no more numbers
to process.

Without a base case, recursion would continue
and eventually cause a RecursionError.

## 5. Identify the Recursive Case

```python
printNumbers(n - 1)
print(n)
```

Explanation:

- printNumbers(n - 1) solves the smaller problem.
- print(n) prints the current number.
- The print statement executes after the
  recursive call returns.

## 6. Python Solution

```python
def printNumbers(n):
    if n == 0:
        return

    printNumbers(n - 1)
    print(n)


printNumbers(5)
```

### Output

```text
1
2
3
4
5
```

## 7. Dry Run

Input: N = 5

### Phase 1: Recursive Calls

printNumbers(5)
    printNumbers(4)
        printNumbers(3)
            printNumbers(2)
                printNumbers(1)
                    printNumbers(0)
                    return

At n = 0, the base case is reached.

### Phase 2: Returning From Recursion

printNumbers(1) -> Print 1
printNumbers(2) -> Print 2
printNumbers(3) -> Print 3
printNumbers(4) -> Print 4
printNumbers(5) -> Print 5

Final Output:

1 2 3 4 5

## 8. Why Does It Print in Ascending Order?

Consider:

```python
printNumbers(n - 1)
print(n)
```

The recursive call executes before print(n).

Therefore, all the smaller numbers are printed
before the current number.

This process is called stack unwinding.

### What If We Reverse the Order?

```python
def printNumbers(n):
    if n == 0:
        return

    print(n)
    printNumbers(n - 1)
```

Output:

5 4 3 2 1

Printing before recursion gives descending order.

Printing after recursion gives ascending order.

## 9. Complexity Analysis

### Time Complexity: O(N)

The function is called N + 1 times,
including the base case.

Therefore:

Time = O(N)

### Space Complexity: O(N)

Each recursive call uses stack memory.

For N = 5, the call stack contains multiple
active function calls before returning.

Therefore:

Space = O(N)

## 10. Important Concepts Learned

- Recursion
- Base Case
- Recursive Case
- Linear Recursion
- Problem Reduction
- Call Stack
- Stack Unwinding
- Time and Space Complexity

## 11. How to Approach Recursion Problems

Before writing code, ask:

1. What is the main problem?
2. Can I reduce it to a smaller problem?
3. What is the base case?
4. What work should happen before or after recursion?

For this problem:

Main Problem:
Print 1 to N.

Smaller Problem:
Print 1 to N - 1.

Base Case:
Stop when N = 0.

Remaining Work:
Print N.

## 12. Key Takeaways

1. Recursion means a function calls itself.
2. Every recursion needs a base case.
3. Reduce the problem size in each call.
4. Code before recursion executes while going down.
5. Code after recursion executes while returning.
6. Recursion uses the call stack.

## 13. Practice Problems

Try solving these using recursion:

1. Print N to 1.
2. Print 1 to N without loops.
3. Find the sum of the first N natural numbers.
4. Find the factorial of N.
5. Calculate the Nth Fibonacci number.

## Git Commit

Pattern: Linear Recursion
Type: Basic DSA

Commit message:

feat(dsa): solve Print 1 to N using linear recursion

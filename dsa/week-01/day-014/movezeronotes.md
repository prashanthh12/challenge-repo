
# LeetCode 283 — Move Zeroes

## Problem Information

- **Platform:** LeetCode
- **Problem Number:** 283
- **Difficulty:** Easy
- **Languages:** Java, Python
- **Primary DSA Pattern:** Two Pointers
- **Technique:** In-place Swapping
- **Topics:** Arrays, Two Pointers, Array Traversal, Swapping

**Problem Link:** https://leetcode.com/problems/move-zeroes/

---

## 1. Problem Statement

Given an integer array `nums`, move all zeroes
to the end of the array while maintaining the
relative order of the nonzero elements.

The operation must be performed **in-place**,
without creating another array.

### Examples

**Example 1**

Input:
nums = [0, 1, 0, 3, 12]

Output:
[1, 3, 12, 0, 0]

**Example 2**

Input:
nums = [0]

Output:
[0]

**Example 3**

Input:
nums = [0, 0, 1]

Output:
[1, 0, 0]

---

## 2. Approach — Two Pointers

### Intuition

Instead of creating a new array, we use
two pointers to rearrange the original array.

- `i` — Scans every element.
- `j` — Tracks the position where the next
  nonzero element should be placed.

Whenever we find a nonzero element, swap
it with the element at index `j`.

After the swap, increment `j`.

### Algorithm

1. Initialize `j = 0`.
2. Traverse the array using pointer `i`.
3. Check whether `nums[i] != 0`.
4. If the current element is nonzero:
   - Swap `nums[i]` and `nums[j]`.
   - Increment `j`.
5. If the element is zero, skip it.
6. Continue until the array is fully traversed.

### Core Logic

```java
if (nums[i] != 0) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
    j++;
}
```

---

## 3. Java Solution

```java
class Solution {
    public void moveZeroes(int[] nums) {

        int j = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != 0) {

                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                j++;
            }
        }
    }
}
```

### Java Explanation

**Step 1 — Initialize Pointer**

```java
int j = 0;
```

`j` represents the position where the
next nonzero element should be placed.

**Step 2 — Traverse Array**

```java
for (int i = 0; i < nums.length; i++)
```

`i` scans the array from left to right.

**Step 3 — Check Nonzero Element**

```java
if (nums[i] != 0)
```

Only nonzero elements need to be moved
toward the beginning of the array.

**Step 4 — Swap Elements**

```java
int temp = nums[i];
nums[i] = nums[j];
nums[j] = temp;
```

Moves the current nonzero element into
the correct position.

**Step 5 — Increment Pointer**

```java
j++;
```

Moves `j` to the next available position.

---

## 4. Python Solution

```python
class Solution:
    def moveZeroes(self, nums: list[int]) -> None:

        j = 0

        for i in range(len(nums)):

            if nums[i] != 0:

                nums[i], nums[j] = nums[j], nums[i]

                j += 1
```

### Python Explanation

**Initialize Pointer**

```python
j = 0
```

**Traverse Array**

```python
for i in range(len(nums)):
```

**Check Nonzero Element**

```python
if nums[i] != 0:
```

**Swap Elements**

```python
nums[i], nums[j] = nums[j], nums[i]
```

Python supports swapping two elements
without creating a temporary variable.

**Increment Pointer**

```python
j += 1
```

---

## 5. Dry Run

Input:

nums = [0, 1, 0, 3, 12]

Initially:

i = 0
j = 0

| i | nums[i] | j Before | Action | Updated Array |
|---|---------|----------|--------|---------------|
| 0 | 0 | 0 | Skip | [0,1,0,3,12] |
| 1 | 1 | 0 | Swap | [1,0,0,3,12] |
| 2 | 0 | 1 | Skip | [1,0,0,3,12] |
| 3 | 3 | 1 | Swap | [1,3,0,0,12] |
| 4 | 12 | 2 | Swap | [1,3,12,0,0] |

### Step-by-Step Explanation

**Iteration 1**

i = 0
nums[i] = 0

Since nums[i] == 0, skip it.

j remains 0.

**Iteration 2**

i = 1
nums[i] = 1

Since 1 != 0:

Swap nums[1] with nums[0].

Array becomes:

[1, 0, 0, 3, 12]

Increment j to 1.

**Iteration 3**

i = 2
nums[i] = 0

Skip the element.

j remains 1.

**Iteration 4**

i = 3
nums[i] = 3

Swap nums[3] with nums[1].

Array becomes:

[1, 3, 0, 0, 12]

Increment j to 2.

**Iteration 5**

i = 4
nums[i] = 12

Swap nums[4] with nums[2].

Array becomes:

[1, 3, 12, 0, 0]

Increment j to 3.

**Final Output: [1, 3, 12, 0, 0]**

---

## 6. Why Two Pointers?

The two pointers perform different jobs.

| Pointer | Purpose |
|---------|---------|
| i | Finds nonzero elements |
| j | Tracks the next position for a nonzero element |

Important:

- `i` moves in every iteration.
- `j` moves only when a nonzero element is found.
- `j` never moves ahead of `i`.

This maintains the relative order of nonzero values.

---

## 7. Java vs Python Comparison

| Operation | Java | Python |
|-----------|------|--------|
| Array length | nums.length | len(nums) |
| Initialize pointer | int j = 0; | j = 0 |
| Array traversal | for (int i=0; ...) | for i in range(...) |
| Nonzero condition | nums[i] != 0 | nums[i] != 0 |
| Swap | Using temp variable | Tuple assignment |
| Increment | j++ | j += 1 |
| Return type | void | None |

---

## 8. Complexity Analysis

Let n = number of elements in nums.

### Time Complexity: O(n)

The algorithm traverses the array once.

Each iteration performs constant-time
operations, including comparisons and swaps.

T(n) = n × O(1)

Therefore:

**Time Complexity = O(n)**

### Space Complexity: O(1)

We only use:

- i
- j
- temp (Java)

No additional array is created.

Therefore:

**Auxiliary Space Complexity = O(1)**

---

## 9. Why Is This an In-place Algorithm?

An in-place algorithm modifies the original
array without allocating another array
proportional to the input size.

Example:

Before:

nums = [0, 1, 0, 3, 12]

After:

nums = [1, 3, 12, 0, 0]

The original array is modified directly.

---

## 10. Important Concepts

### Two Pointers

Uses two indexes to efficiently process
elements inside an array.

### In-place Modification

Changes the original array without
creating a copy.

### Swapping

Exchanges values between two indexes.

Java:

```java
int temp = nums[i];
nums[i] = nums[j];
nums[j] = temp;
```

Python:

```python
nums[i], nums[j] = nums[j], nums[i]
```

### Relative Order

The order of nonzero elements must
remain unchanged.

Example:

Input: [0, 4, 0, 2, 7]

Correct: [4, 2, 7, 0, 0]

Incorrect: [7, 2, 4, 0, 0]

---

## 11. Edge Cases

| Input | Output |
|-------|--------|
| [0] | [0] |
| [1] | [1] |
| [0,0,0] | [0,0,0] |
| [1,2,3] | [1,2,3] |
| [0,1] | [1,0] |
| [1,0,2,0,3] | [1,2,3,0,0] |

---

## 12. Pattern Recognition

**Primary Pattern:** Two Pointers

**Technique:** In-place Swapping

Use this pattern when:

- Moving particular elements to one side
- Rearranging arrays in-place
- Removing elements from arrays
- Separating values based on conditions
- Maintaining relative order during traversal

### Related LeetCode Problems

- 26 — Remove Duplicates from Sorted Array
- 27 — Remove Element
- 88 — Merge Sorted Array
- 75 — Sort Colors
- 283 — Move Zeroes

---

## 13. Learning Outcome

Learned how to move zeroes to the end
of an array using the Two Pointers pattern.

Understood:

- Array traversal
- Two Pointers
- In-place modification
- Swapping elements
- Maintaining relative order
- Java and Python implementation
- Time Complexity O(n)
- Auxiliary Space Complexity O(1)

### Key Takeaway

Use pointer `i` to find nonzero elements
and pointer `j` to place them at the
beginning of the array.

This produces an efficient O(n) solution
without creating another array.

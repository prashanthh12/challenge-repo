
# LeetCode 217 — Contains Duplicate

## Problem Information

- **Platform:** LeetCode
- **Problem Number:** 217
- **Difficulty:** Easy
- **Languages:** Java, Python
- **Primary Pattern:** Hashing
- **Technique:** HashSet / Set Membership Checking
- **Topics:** Arrays, HashSet, Sets, Duplicate Detection

**Problem Link:** https://leetcode.com/problems/contains-duplicate/

---

## Problem Statement

Given an integer array `nums`, return `true`
if any element appears at least twice.

Return `false` if all elements are distinct.

## Examples

| Input | Output | Explanation |
|-------|--------|-------------|
| [1,2,3,1] | true | 1 appears twice |
| [1,2,3,4] | false | All elements are unique |
| [1,1,1,3,3,4] | true | Multiple duplicates |
| [5,5] | true | 5 appears twice |
| [1] | false | Only one element |

---

## Approach — HashSet

### Intuition

A HashSet stores unique elements and allows
efficient checking of whether an element
has already been seen.

Instead of comparing every element with
every other element, we store previously
visited numbers in a HashSet.

If a number already exists in the set,
we have found a duplicate.

### Algorithm

1. Create an empty HashSet.
2. Traverse the array from left to right.
3. Check whether the current number exists
   in the HashSet.
4. If it exists, return true.
5. Otherwise, add the number to the set.
6. Continue with the next element.
7. If no duplicates are found, return false.

### Core Pattern

Check → Detect Duplicate → Add to Set

```text
Create empty set

For each number:
    If number already exists:
        Return true

    Add number to set

Return false
```

---

## Java Solution

```java
import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            if (set.contains(nums[i])) {
                return true;
            }

            set.add(nums[i]);
        }

        return false;
    }
}
```

### Java Concepts

**HashSet Creation**

```java
HashSet<Integer> set = new HashSet<>();
```

Creates an empty set for storing unique integers.

**contains() Method**

```java
set.contains(nums[i])
```

Checks whether the current element
already exists in the set.

Returns:
- true → Element exists.
- false → Element does not exist.

**add() Method**

```java
set.add(nums[i]);
```

Adds the current number to the HashSet.

A HashSet does not store duplicate values.

---

## Python Solution

```python
class Solution:
    def containsDuplicate(self, nums: list[int]) -> bool:

        seen = set()

        for num in nums:

            if num in seen:
                return True

            seen.add(num)

        return False
```

### Python Concepts

**Creating an Empty Set**

```python
seen = set()
```

Creates an empty Python set.

Note: `{}` creates an empty dictionary,
not an empty set.

**Membership Checking**

```python
if num in seen:
```

Checks whether the current number
already exists in the set.

**Adding Elements**

```python
seen.add(num)
```

Adds an element to the set.

---

## Dry Run

Input:

```text
nums = [1, 2, 3, 1]
```

Initially:

```text
set = {}
```

| i | nums[i] | Set Before | Duplicate? | Action |
|---|---------|------------|------------|--------|
| 0 | 1 | {} | No | Add 1 |
| 1 | 2 | {1} | No | Add 2 |
| 2 | 3 | {1,2} | No | Add 3 |
| 3 | 1 | {1,2,3} | Yes | Return true |

### Step-by-Step Execution

**Iteration 1**

Current number = 1

- set.contains(1) → false
- Add 1
- set = {1}

**Iteration 2**

Current number = 2

- set.contains(2) → false
- Add 2
- set = {1,2}

**Iteration 3**

Current number = 3

- set.contains(3) → false
- Add 3
- set = {1,2,3}

**Iteration 4**

Current number = 1

- set.contains(1) → true
- Duplicate found!
- Return true immediately.

**Final Output: true**

---

## Java vs Python Comparison

| Operation | Java | Python |
|-----------|------|--------|
| Create set | new HashSet<>() | set() |
| Check element | set.contains(x) | x in seen |
| Add element | set.add(x) | seen.add(x) |
| Return true | return true; | return True; |
| Return false | return false; | return False; |

---

## Complexity Analysis

Let n = number of elements in nums.

### Time Complexity: O(n) Average

- The loop visits at most n elements.
- HashSet membership checking is O(1) on average.
- HashSet insertion is O(1) on average.

Therefore:

T(n) = n × O(1)

**Time Complexity = O(n)**

Hash collisions may make individual operations
slower in unusual cases, so the O(n) bound
describes expected/average performance.

### Space Complexity: O(n)

- A HashSet stores previously visited elements.
- In the worst case, all n elements are unique.
- The set can contain up to n integers.

Therefore:

**Auxiliary Space Complexity = O(n)**

---

## Why HashSet Instead of Nested Loops?

### Brute Force

Compare each number with the remaining numbers.

Time: O(n²)
Space: O(1)

### HashSet

Check previously visited numbers using hashing.

Time: O(n) average
Space: O(n)

HashSet uses extra memory to avoid
repeated comparisons.

---

## Important Concepts

### 1. Hashing

Hashing maps values to locations in
a hash-based data structure, allowing
efficient membership checking.

### 2. HashSet

A HashSet stores unique elements.

It is useful when we need to check
whether a value has appeared before.

### 3. Early Return

```java
if (set.contains(nums[i])) {
    return true;
}
```

Immediately stops the method when
a duplicate is found.

### 4. Check Before Adding

We check whether the element already
exists before adding it to the set.

This helps identify repeated values.

### 5. Java vs Python Boolean Values

Java:
- true
- false

Python:
- True
- False

---

## Edge Cases

- [1] → false
- [1,1] → true
- [1,2,3] → false
- [-1,-2,-1] → true
- [0,0] → true
- [1,2,3,4,5] → false

---

## Pattern Recognition

**Primary Pattern:** Hashing

**Technique:** HashSet Membership Checking

Think of HashSet when a problem asks:

- Does an element appear more than once?
- Have we seen this number before?
- Are all elements unique?
- Does a particular value exist?
- Can we detect duplicates efficiently?

---

## Related Problems

- LeetCode 1 — Two Sum
- LeetCode 219 — Contains Duplicate II
- LeetCode 242 — Valid Anagram
- LeetCode 349 — Intersection of Two Arrays
- LeetCode 128 — Longest Consecutive Sequence

---

## Learning Outcome

Learned how to detect duplicate elements
using HashSet in Java and set in Python.

Understood:

- Hashing
- HashSet creation
- Membership checking
- Inserting elements
- Early return
- Array traversal
- Time complexity O(n) average
- Space complexity O(n)

Key takeaway:

Use a HashSet when you need to remember
previously visited elements and detect
duplicates efficiently.

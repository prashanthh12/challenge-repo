# Day 08 – Big-O Notation: Time and Space Complexity

## 1. What is Big-O notation?

Big-O notation describes an upper bound on how an algorithm's resource usage grows as its input size increases. In DSA, we usually report the tightest useful bound for the worst case unless another case is specified.

- **Time complexity:** How the number of operations grows with input size.
- **Space complexity:** How memory usage grows with input size.
- **n:** Input size (for example, the number of elements in an array).

Big-O does not measure exact execution time in seconds or exact memory in bytes. It describes the growth rate.

## 2. Common Big-O complexities

| Complexity | Name | Example |
| --- | --- | --- |
| O(1) | Constant | Accessing an array element by index |
| O(n) | Linear | Traversing an array once |
| O(n²) | Quadratic | Comparing every pair of array elements |

### Comparing growth

Representative operation counts (ignoring constant factors):

| Input size (n) | O(1) | O(n) | O(n²) |
| ---: | ---: | ---: | ---: |
| 1 | 1 | 1 | 1 |
| 10 | 1 | 10 | 100 |
| 100 | 1 | 100 | 10,000 |
| 1,000 | 1 | 1,000 | 1,000,000 |

## 3. How to calculate time complexity

1. Identify the input size `n`.
2. Identify the operations that depend on `n`.
3. Count how many times each operation executes.
4. Add the costs of consecutive blocks; multiply iteration counts for independent nested loops.
5. Keep the fastest-growing term and remove constant factors.

### Simplification rules

| Operation count | Big-O |
| --- | --- |
| 5 | O(1) |
| 3n + 10 | O(n) |
| n + n | O(n) |
| n² + n + 5 | O(n²) |
| 2n² | O(n²) |

### Example 1: O(1) – Constant time

```java
int firstElement(int[] arr) {
    return arr[0]; // Assumes a non-empty array
}
```

Accessing one element takes constant time, regardless of the array length.

- Time complexity: **O(1)**
- Auxiliary space complexity: **O(1)**

### Example 2: O(n) – Linear time

```java
int sum(int[] arr) {
    int total = 0;
    for (int i = 0; i < arr.length; i++) {
        total += arr[i];
    }
    return total;
}
```

The loop body executes `n` times. Initialization and return take constant time. Loop condition checks and increments also grow linearly.

`T(n) = an + b → O(n)`, where `a` and `b` are constants.

- Time complexity: **O(n)**
- Auxiliary space complexity: **O(1)** (only a fixed number of variables)

### Example 3: O(n²) – Quadratic time

```java
void printPairs(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
        for (int j = 0; j < arr.length; j++) {
            System.out.println(arr[i] + ", " + arr[j]);
        }
    }
}
```

The outer loop runs `n` times. For each iteration, the inner loop runs `n` times.

`n × n = n² → O(n²)`

- Time complexity: **O(n²)** (assuming constant cost per pair printed)
- Auxiliary space complexity: **O(1)** (pairs are printed, not stored)

### Example 4: Two consecutive loops

```java
void traverseTwice(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
        System.out.println(arr[i]);
    }
    for (int i = 0; i < arr.length; i++) {
        System.out.println(arr[i]);
    }
}
```

`n + n = 2n → O(n)`

Consecutive loops are added, not multiplied.

### Example 5: Dependent nested loops

```java
void uniquePairs(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
        for (int j = i + 1; j < arr.length; j++) {
            System.out.println(arr[i] + ", " + arr[j]);
        }
    }
}
```

The inner loop runs `n - 1`, `n - 2`, ..., `1`, `0` times.

`(n - 1) + (n - 2) + ... + 1 = n(n - 1)/2 → O(n²)`

Even though only half the pairs are visited, the growth remains quadratic. This pattern appears in Selection Sort.

### Example 6: Different input sizes

```java
void crossPairs(int[] a, int[] b) {
    for (int x : a) {
        for (int y : b) {
            System.out.println(x + ", " + y);
        }
    }
}
```

If `a` has `n` elements and `b` has `m` elements, time is **O(n × m)**, not automatically O(n²). Auxiliary space is O(1).

### Important: Not every nested loop is O(n²)

A fixed inner loop of 5 iterations inside a loop of size `n` costs `5n → O(n)`. Always count iterations rather than just counting loops.

## 4. How to calculate space complexity

Space complexity describes memory growth. Two related measures are:

- **Total space:** Input storage plus additional memory (and output storage, when applicable).
- **Auxiliary space:** Extra working memory used by the algorithm, excluding input storage. Output storage is often reported separately; state your convention.

In the examples below, any newly allocated array is counted as additional memory, including returned arrays. When output is excluded from auxiliary space, the returned-array examples have O(1) working space plus the stated output space.

### Steps

1. Count fixed-size variables and references.
2. Identify new arrays, lists, maps, sets, or other allocated objects.
3. Account for the maximum number of recursive calls simultaneously on the call stack, if any.
4. Calculate peak additional memory used, not the cumulative number of allocations over time.
5. Drop constant factors and lower-order terms.

### Example 1: O(1) – Constant space

```java
int max(int[] arr) {
    int largest = arr[0]; // Assumes a non-empty array
    for (int i = 1; i < arr.length; i++) {
        if (arr[i] > largest) {
            largest = arr[i];
        }
    }
    return largest;
}
```

Only `largest` and `i` are needed as extra variables. The original array is not copied.

- Time: O(n)
- Auxiliary space: **O(1)**
- Total space including input: O(n)

### Example 2: O(n) – Linear additional space

```java
int[] copyArray(int[] arr) {
    int[] copy = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
        copy[i] = arr[i];
    }
    return copy;
}
```

A new array of `n` elements is allocated.

- Time: O(n)
- Additional space including output: **O(n)**
- Working space excluding output: O(1)

### Example 3: O(n²) – Quadratic additional space

```java
int[][] createMatrix(int n) {
    int[][] matrix = new int[n][n];
    return matrix;
}
```

The matrix stores `n × n` integer elements. Java also initializes those elements to zero.

- Time: O(n²)
- Additional space including output: **O(n²)**
- Working space excluding output: O(1)

### Example 4: Recursion and stack memory

```java
void countDown(int n) {
    if (n <= 0) return;
    countDown(n - 1);
}
```

For non-negative `n`, there are `n + 1` calls, and each active call uses a constant-size stack frame.

- Time: O(n)
- Auxiliary space: O(n)

## 5. Best, average and worst case

Consider Linear Search:

```java
int search(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == target) return i;
    }
    return -1;
}
```

| Case | Condition | Time |
| --- | --- | --- |
| Best | Target is the first element | O(1) |
| Average | Target is equally likely to be at any index | O(n) |
| Worst | Target is last or absent | O(n) |

Auxiliary space is O(1) in every case. Big-O can describe any of these cases; it is not exclusively a worst-case notation.

## 6. Python examples

```python
# O(1) time, O(1) auxiliary space (non-empty list)
def first_element(arr):
    return arr[0]

# O(n) time, O(1) auxiliary space
def array_sum(arr):
    total = 0
    for value in arr:
        total += value
    return total

# O(n²) time, O(1) auxiliary space (assuming constant cost per print)
def print_pairs(arr):
    for x in arr:
        for y in arr:
            print(x, y)

# O(n) time, O(n) additional space including output
def copy_array(arr):
    return arr[:]
```

These examples use the usual DSA model where basic arithmetic on fixed-size values is constant time. Python's arbitrary-precision integers can have additional costs when their bit lengths grow.

## 7. Complexity of common DSA problems

| Problem / algorithm | Time (worst case) | Auxiliary space |
| --- | --- | --- |
| Array index access | O(1) | O(1) |
| Linear Search | O(n) | O(1) |
| Reverse Array (in-place, two pointers) | O(n) | O(1) |
| Move Zeroes (in-place, two pointers) | O(n) | O(1) |
| Best Time to Buy and Sell Stock (one pass) | O(n) | O(1) |
| Two Sum (brute force) | O(n²) | O(1) |
| Two Sum (hash map) | O(n) expected under standard hashing assumptions; worst case can be higher | O(n) |
| Selection Sort (in-place) | O(n²) | O(1) |
| Bubble Sort (in-place) | O(n²) | O(1) |
| Valid Parentheses (stack) | O(n) | O(n) |

The complexity depends on the implementation, not just the problem name.

## 8. Practice questions

Find the time and auxiliary space complexity before checking the answers.

**Q1**

```java
int x = 10;
int y = 20;
int z = x + y;
```

**Q2**

```java
for (int i = 0; i < n; i += 2) {
    System.out.println(i);
}
```

**Q3**

```java
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
        System.out.println(i + j);
    }
}
```

**Q4**

```java
int[] temp = new int[n];
for (int i = 0; i < n; i++) {
    temp[i] = i;
}
```

**Q5**

```java
for (int i = 0; i < n; i++) {
    for (int j = 0; j < 5; j++) {
        System.out.println(i + j);
    }
}
```

### Answers

| Question | Time | Auxiliary space | Reason |
| --- | --- | --- | --- |
| Q1 | O(1) | O(1) | Fixed operations and variables |
| Q2 | O(n) | O(1) | Approximately n/2 iterations |
| Q3 | O(n²) | O(1) | n × n iterations; no growing data structure |
| Q4 | O(n) | O(n) | n iterations and a new n-element array |
| Q5 | O(n) | O(1) | 5n iterations; 5 is constant |

## 9. Quick revision

- O(1): Resource usage does not grow with input size.
- O(n): Resource usage grows linearly.
- O(n²): Resource usage grows quadratically.
- Consecutive blocks: Add their costs.
- Nested loops: Count inner iterations across all outer iterations.
- Ignore constant factors and lower-order terms.
- Time complexity and space complexity are independent: an algorithm can take O(n²) time and only O(1) extra space.
- In-place algorithms usually avoid allocating a new input-sized data structure, but may still use extra memory such as a recursion stack.

## 10. Learning outcome

- [ ] Explain Big-O notation and input size.
- [ ] Calculate O(1), O(n), and O(n²) time complexity from code.
- [ ] Distinguish total space from auxiliary space.
- [ ] Analyze consecutive loops, nested loops, arrays, and recursion.
- [ ] Explain time and space complexity in a technical interview.

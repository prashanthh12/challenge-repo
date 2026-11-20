
# Selection Sort — DSA Notes

## 1. What is Selection Sort?

Selection Sort is a comparison-based sorting algorithm that repeatedly
finds the smallest element in the unsorted portion of an array and
places it at the beginning of that portion.

It divides the array into two parts:

- Sorted portion: Elements already in their correct positions.
- Unsorted portion: Elements that still need to be sorted.

### Main Idea

Find Minimum → Swap → Move Forward → Repeat

---

## 2. Example

Input:
```text
[5, 3, 8, 2, 4]
```

Expected Output:
```text
[2, 3, 4, 5, 8]
```

---

## 3. How Selection Sort Works

### Pass 1

Array: [5, 3, 8, 2, 4]

- Start at index 0.
- Assume 5 is the minimum.
- Compare 5 with 3 → Minimum becomes 3.
- Compare 3 with 8 → No change.
- Compare 3 with 2 → Minimum becomes 2.
- Compare 2 with 4 → No change.
- Swap 5 and 2.

Result: [2, 3, 8, 5, 4]

### Pass 2

Array: [2, 3, 8, 5, 4]

- Index 0 is already sorted.
- Start searching at index 1.
- Minimum in [3, 8, 5, 4] is 3.
- It is already in the correct position.

Result: [2, 3, 8, 5, 4]

### Pass 3

Array: [2, 3, 8, 5, 4]

- Search the unsorted portion [8, 5, 4].
- Minimum is 4.
- Swap 8 and 4.

Result: [2, 3, 4, 5, 8]

### Pass 4

Array: [2, 3, 4, 5, 8]

- Search the remaining portion [5, 8].
- Minimum is 5.
- No change is required.

Final Sorted Array:
[2, 3, 4, 5, 8]

---

## 4. Algorithm

1. Start from index `i = 0`.
2. Assume `arr[i]` is the minimum.
3. Store its index in `minIndex`.
4. Compare it with the remaining unsorted elements.
5. Update `minIndex` whenever a smaller element is found.
6. After the inner loop, swap `arr[i]` with `arr[minIndex]`.
7. Increment `i` and repeat.
8. Stop when all elements are sorted.

---

## 5. Java Implementation

```java
import java.util.Arrays;

class Sol {
    public int[] isSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int min = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }

        return arr;
    }
}

public class Sel {
    public static void main(String[] args) {
        Sol sort = new Sol();

        int[] arr = {5, 3, 8, 2, 4};

        int[] result = sort.isSort(arr);

        System.out.println(
            "Sorted Array: " + Arrays.toString(result)
        );
    }
}
```

### Output

```text
Sorted Array: [2, 3, 4, 5, 8]
```

---

## 6. Code Explanation

### Outer Loop

```java
for (int i = 0; i < n - 1; i++)
```

- Controls each sorting pass.
- `i` represents the position where the next minimum belongs.
- Runs `n - 1` times.

### Minimum Index

```java
int min = i;
```

- Initially assumes the current element is the smallest.
- Stores the index, not the value.

### Inner Loop

```java
for (int j = i + 1; j < n; j++)
```

- Searches the remaining unsorted elements.
- Starts from `i + 1`.

### Minimum Comparison

```java
if (arr[j] < arr[min]) {
    min = j;
}
```

- Compares the current element with the minimum found so far.
- If a smaller element exists, updates its index.
- No swapping happens inside this loop.

### Swapping

```java
int temp = arr[i];
arr[i] = arr[min];
arr[min] = temp;
```

- Moves the minimum element to index `i`.
- Moves the previous element at `i` to the minimum's old position.
- One swap operation is performed per outer-loop pass.

---

## 7. Variables Used

| Variable | Purpose |
|----------|---------|
| `arr` | Array to be sorted |
| `n` | Length of the array |
| `i` | Current position to fill |
| `j` | Index used to search the unsorted portion |
| `min` | Index of the minimum element |
| `temp` | Temporary variable used during swapping |

---

## 8. Time Complexity

Selection Sort uses nested loops.

The number of comparisons is:

(n - 1) + (n - 2) + ... + 1

Total comparisons:

n(n - 1) / 2

Therefore:

Time Complexity = O(n²)

| Case | Complexity |
|------|------------|
| Best Case | O(n²) |
| Average Case | O(n²) |
| Worst Case | O(n²) |

### Why is the best case also O(n²)?

Even if the array is already sorted, Selection Sort
still compares all the remaining elements to find
the minimum in every pass.

---

## 9. Space Complexity

Space Complexity = O(1)

Reason:

- Uses only a few extra variables.
- No additional array is required.
- Sorting happens inside the original array.

---

## 10. Properties

| Property | Selection Sort |
|----------|----------------|
| Algorithm Type | Comparison-based |
| Sorting Method | In-place |
| Stable | No (standard implementation) |
| Adaptive | No |
| Best Time | O(n²) |
| Average Time | O(n²) |
| Worst Time | O(n²) |
| Extra Space | O(1) |
| Swap Operations | At most n - 1 |

### Why is it not stable?

Equal elements can change their relative order
when the algorithm swaps the minimum element
with an earlier element.

---

## 11. Advantages

- Simple to understand and implement.
- Requires constant extra space.
- Performs relatively few swaps.
- Useful for learning sorting algorithms.
- Can be useful when writing/swapping elements is expensive.

## 12. Disadvantages

- Slow for large arrays.
- Performs O(n²) comparisons.
- Does not benefit from an already sorted array.
- Standard implementation is not stable.

---

## 13. Selection Sort vs Bubble Sort

| Selection Sort | Bubble Sort |
|----------------|-------------|
| Finds the minimum element | Compares adjacent elements |
| Swaps after finding the minimum | Swaps whenever adjacent elements are out of order |
| At most O(n) swaps | Up to O(n²) swaps |
| Best case O(n²) | Optimized best case O(n) |
| Usually not stable | Stable |

---

## 14. Interview Explanation

Selection Sort is an in-place comparison-based sorting
algorithm that repeatedly selects the smallest element
from the unsorted part of an array and places it at
the beginning of that part.

It has O(n²) time complexity in all cases and
O(1) auxiliary space complexity.

---

## 15. Key Points to Remember

1. Selection Sort selects the minimum element.
2. `i` indicates the current position to fill.
3. `j` searches the unsorted portion.
4. `min` stores the index of the minimum element.
5. Swapping happens after the inner loop finishes.
6. Each pass places one element in its final position.
7. Time Complexity: O(n²).
8. Space Complexity: O(1).

### Easy Formula to Remember

Selection Sort = Find Minimum + Swap + Repeat

---

## 16. Practice Problems

1. Sort [9, 4, 7, 2, 1] in ascending order.
2. Sort [5, 8, 3, 1, 6] in descending order.
3. Count the number of comparisons.
4. Count the number of actual swaps.
5. Implement Selection Sort in Python.
6. Explain why Selection Sort is O(n²).

---

## 17. Learning Summary

Topic: Selection Sort

Category: DSA → Sorting Algorithms

Pattern: Comparison-Based Sorting

Languages: Java / Python

Concepts Learned:
- Nested loops
- Array indexing
- Finding minimum values
- Swapping elements
- In-place sorting
- Time complexity
- Space complexity

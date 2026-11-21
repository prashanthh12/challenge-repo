# Bubble Sort — DSA Notes

## 1. Definition

**Bubble Sort** is a comparison-based sorting algorithm that repeatedly compares **adjacent elements** and swaps them if they are in the wrong order. In ascending order, the largest remaining element moves to the end of the unsorted portion after each pass.

**Pattern:** Compare adjacent elements → Swap if needed → Repeat.

## 2. Example

**Input:** `[5, 3, 8, 2, 4]`  
**Output:** `[2, 3, 4, 5, 8]`

## 3. Dry Run (Ascending Order)

### Pass 1 (`i = 0`)

- Compare `5` and `3` → swap → `[3, 5, 8, 2, 4]`
- Compare `5` and `8` → no swap → `[3, 5, 8, 2, 4]`
- Compare `8` and `2` → swap → `[3, 5, 2, 8, 4]`
- Compare `8` and `4` → swap → `[3, 5, 2, 4, 8]`

The largest element, `8`, is in its final position.

### Pass 2 (`i = 1`)

- Compare `3` and `5` → no swap
- Compare `5` and `2` → swap → `[3, 2, 5, 4, 8]`
- Compare `5` and `4` → swap → `[3, 2, 4, 5, 8]`

The next largest element, `5`, is in its final position.

### Pass 3 (`i = 2`)

- Compare `3` and `2` → swap → `[2, 3, 4, 5, 8]`
- Compare `3` and `4` → no swap

### Pass 4 (`i = 3`)

- Compare `2` and `3` → no swap

**Final sorted array:** `[2, 3, 4, 5, 8]`

## 4. Algorithm

1. Start at index `0`.
2. Compare adjacent elements `arr[j]` and `arr[j + 1]`.
3. If `arr[j] > arr[j + 1]`, swap them.
4. Continue to the end of the unsorted portion.
5. After each pass, one more largest element is fixed at the end.
6. Repeat for up to `n - 1` passes.

## 5. Java Implementation (Basic)

Save as `Bubble.java`.

```java
import java.util.Arrays;

class Sol {
    public int[] bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
}

public class Bubble {
    public static void main(String[] args) {
        Sol sort = new Sol();
        int[] arr = {5, 3, 8, 2, 4};
        int[] result = sort.bubbleSort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(result));
    }
}
```

**Output:**

```text
Sorted Array: [2, 3, 4, 5, 8]
```

**Run:**

```bash
javac Bubble.java
java Bubble
```

## 6. Code Explanation

| Code | Meaning |
| --- | --- |
| `int n = arr.length;` | Number of elements |
| `i` | Counts the passes (and sorted positions at the end) |
| `j` | Index of the left element in a compared adjacent pair |
| `j < n - i - 1` | Avoids revisiting the sorted suffix and keeps `j + 1` valid |
| `arr[j] > arr[j + 1]` | Checks if adjacent elements are out of ascending order |
| `temp` | Temporarily stores a value during swapping |

### Why `n - i - 1`?

For `n = 5`:

| Pass | `i` | `j` values | Comparisons |
| --- | --- | --- | --- |
| 1 | 0 | 0, 1, 2, 3 | 4 |
| 2 | 1 | 0, 1, 2 | 3 |
| 3 | 2 | 0, 1 | 2 |
| 4 | 3 | 0 | 1 |

The `-1` prevents accessing `arr[n]` when comparing `arr[j + 1]`. The `-i` skips elements already fixed at the right end.

## 7. Optimized Bubble Sort

Stop early if a full pass makes **no swaps**.

```java
public static void bubbleSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
        boolean swapped = false;

        for (int j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                swapped = true;
            }
        }

        if (!swapped) {
            break; // Already sorted
        }
    }
}
```

A pass without swaps means all adjacent pairs in the unsorted portion are correctly ordered. Together with the already sorted suffix, the entire array is sorted.

## 8. Python Implementation (Optimized)

```python
def bubble_sort(arr):
    n = len(arr)
    for i in range(n - 1):
        swapped = False
        for j in range(n - i - 1):
            if arr[j] > arr[j + 1]:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]
                swapped = True
        if not swapped:
            break
    return arr

print(bubble_sort([5, 3, 8, 2, 4]))
```

## 9. Time and Space Complexity

| Case | Basic version | Optimized version |
| --- | --- | --- |
| Best | `O(n²)` | `O(n)` |
| Average | `O(n²)` | `O(n²)` |
| Worst | `O(n²)` | `O(n²)` |
| Auxiliary space | `O(1)` | `O(1)` |

In the basic version, the number of comparisons is:

`(n - 1) + (n - 2) + ... + 1 = n(n - 1)/2`, which is `O(n²)`.

In the optimized version, an already sorted array needs one pass, so the best case is `O(n)`.

## 10. Properties

- **In-place:** Yes — uses constant extra memory.
- **Stable:** Yes — equal values are not swapped because the condition uses `>` (not `>=`).
- **Adaptive:** The optimized version is adaptive and can stop early.
- **Comparison-based:** Yes.
- **Maximum passes:** `n - 1` for an array of length `n`.

## 11. Selection Sort vs Bubble Sort

| Selection Sort | Bubble Sort |
| --- | --- |
| Selects the minimum in the unsorted section | Compares neighboring elements |
| Places minimum at the beginning | Moves the largest remaining element to the end |
| At most `O(n)` swaps | Up to `O(n²)` swaps |
| Best-case time `O(n²)` | Optimized best-case time `O(n)` |
| Standard version is not stable | Standard adjacent-swap version is stable |

## 12. Interview Answer

> Bubble Sort repeatedly compares adjacent array elements and swaps them when they are in the wrong order. After each pass, the largest remaining element reaches its final position. The worst-case time complexity is O(n²), and the auxiliary space complexity is O(1). Using a swapped flag, its best-case time becomes O(n) for an already sorted array.

## 13. Practice

1. Dry-run Bubble Sort on `[7, 4, 9, 1, 5]`.
2. Modify the comparison to sort in **descending** order.
3. Print the array after every pass.
4. Count all comparisons and swaps.
5. Explain why `j < n - i - 1` is necessary.
6. Explain how the `swapped` flag improves the best case.

## 14. Quick Revision

- **`i`:** Pass number.
- **`j`:** Adjacent-pair index.
- **`arr[j] > arr[j + 1]`:** Swap condition for ascending order.
- **`n - i - 1`:** Skip sorted elements at the end.
- **Key idea:** Compare → Swap → Largest bubbles right.
- **Worst time:** `O(n²)`.
- **Extra space:** `O(1)`.

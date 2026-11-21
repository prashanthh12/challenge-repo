
# LeetCode 121 — Best Time to Buy and Sell Stock

## Problem Information

- **Platform:** LeetCode
- **Problem Number:** 121
- **Difficulty:** Easy
- **Languages:** Java, Python
- **Primary DSA Pattern:** Greedy
- **Technique:** One-Pass Array Traversal
- **Concept:** Minimum Price Tracking
- **Topics:** Arrays, Greedy, Profit Calculation

**Problem Link:** https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

---

## 1. Problem Statement

Given an integer array `prices`, where
`prices[i]` represents the price of a stock
on the ith day.

You can:

1. Buy one stock on a particular day.
2. Sell the stock on a later day.
3. Make the maximum possible profit.

Return the maximum profit.

If no profitable transaction is possible,
return 0.

**Important:** You must buy before selling.

---

## 2. Examples

### Example 1

Input:
```text
prices = [7, 1, 5, 3, 6, 4]
```

Output:
```text
5
```

Explanation:

- Buy at price 1.
- Sell later at price 6.
- Profit = 6 - 1 = 5.

### Example 2

Input:
```text
prices = [7, 6, 4, 3, 1]
```

Output:
```text
0
```

Explanation:

Prices keep decreasing.

No profitable transaction is possible.

### Example 3

Input:
```text
prices = [2, 4, 1]
```

Output:
```text
2
```

Explanation:

Buy at 2 and sell at 4.

Profit = 4 - 2 = 2.

Even though 1 is the lowest price, it
comes after 4, so buying at 1 and selling
at 4 is not allowed.

---

## 3. Approach — Greedy Algorithm

### Intuition

Instead of checking every possible buying
and selling day, we can solve the problem
by traversing the array once.

We maintain two variables:

- `minPrice` — Lowest price encountered so far.
- `maxProfit` — Maximum profit found so far.

At each day:

1. Check whether today's price is lower
   than the minimum price.
2. Update the minimum buying price if needed.
3. Calculate the profit if we sell today.
4. Update the maximum profit if today's
   profit is greater.

### Why Greedy?

We always keep the lowest buying price
encountered so far.

This allows us to calculate the best
possible profit for each selling day.

We do not need to check every previous
buying day again.

---

## 4. Algorithm

1. Initialize `minPrice = prices[0]`.
2. Initialize `maxProfit = 0`.
3. Start traversing from index 1.
4. If `prices[i] < minPrice`, update minPrice.
5. Calculate:

   profit = prices[i] - minPrice

6. If profit > maxProfit, update maxProfit.
7. Continue until the last element.
8. Return maxProfit.

### Core Logic

```text
minPrice = first stock price
maxProfit = 0

For each remaining price:

    Update minimum price if needed

    profit = current price - minimum price

    Update maximum profit if needed

Return maximum profit
```

---

## 5. Java Solution

```java
class Solution {
    public int maxProfit(int[] prices) {

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {

            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }

            int profit = prices[i] - minPrice;

            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }

        return maxProfit;
    }
}
```

---

## 6. Java Code Explanation

### Step 1 — Initialize Minimum Price

```java
int minPrice = prices[0];
```

The first stock price is considered
the initial minimum buying price.

Example:

```text
prices = [7, 1, 5, 3, 6, 4]

minPrice = 7
```

### Step 2 — Initialize Maximum Profit

```java
int maxProfit = 0;
```

Initially, no profit has been made.

If every price decreases, the answer
remains zero.

### Step 3 — Traverse Array

```java
for (int i = 1; i < prices.length; i++)
```

We start from index 1 because the first
element is already stored in minPrice.

### Step 4 — Update Minimum Price

```java
if (prices[i] < minPrice) {
    minPrice = prices[i];
}
```

If today's price is smaller than
the previous minimum, update minPrice.

Example:

```text
Previous minPrice = 7

Current price = 1

New minPrice = 1
```

### Step 5 — Calculate Profit

```java
int profit = prices[i] - minPrice;
```

Profit formula:

```text
Profit = Selling Price - Buying Price
```

Example:

```text
Current price = 6
Minimum price = 1

Profit = 6 - 1 = 5
```

### Step 6 — Update Maximum Profit

```java
if (profit > maxProfit) {
    maxProfit = profit;
}
```

Store the new profit only if it is
greater than the previous maximum.

### Step 7 — Return Answer

```java
return maxProfit;
```

Return the largest profit found.

---

## 7. Python Solution

```python
class Solution:
    def maxProfit(self, prices: list[int]) -> int:

        min_price = prices[0]
        max_profit = 0

        for i in range(1, len(prices)):

            if prices[i] < min_price:
                min_price = prices[i]

            profit = prices[i] - min_price

            if profit > max_profit:
                max_profit = profit

        return max_profit
```

### Python Explanation

**Initialize variables**

```python
min_price = prices[0]
max_profit = 0
```

**Traverse prices**

```python
for i in range(1, len(prices)):
```

**Update minimum price**

```python
if prices[i] < min_price:
    min_price = prices[i]
```

**Calculate profit**

```python
profit = prices[i] - min_price
```

**Update maximum profit**

```python
if profit > max_profit:
    max_profit = profit
```

**Return answer**

```python
return max_profit
```

---

## 8. Dry Run

Input:

```text
prices = [7, 1, 5, 3, 6, 4]
```

Initially:

```text
minPrice = 7
maxProfit = 0
```

| Day | Price | Min Price | Profit | Max Profit |
|-----|-------|-----------|--------|------------|
| 1 | 7 | 7 | 0 | 0 |
| 2 | 1 | 1 | 0 | 0 |
| 3 | 5 | 1 | 4 | 4 |
| 4 | 3 | 1 | 2 | 4 |
| 5 | 6 | 1 | 5 | 5 |
| 6 | 4 | 1 | 3 | 5 |

### Step-by-Step Explanation

**Day 1**

```text
Price = 7

minPrice = 7
maxProfit = 0
```

**Day 2**

```text
Price = 1

1 < 7

Update minPrice = 1

profit = 1 - 1 = 0

maxProfit = 0
```

**Day 3**

```text
Price = 5

minPrice = 1

profit = 5 - 1 = 4

Update maxProfit = 4
```

**Day 4**

```text
Price = 3

minPrice = 1

profit = 3 - 1 = 2

maxProfit remains 4
```

**Day 5**

```text
Price = 6

minPrice = 1

profit = 6 - 1 = 5

Update maxProfit = 5
```

**Day 6**

```text
Price = 4

minPrice = 1

profit = 4 - 1 = 3

maxProfit remains 5
```

### Final Answer

```text
5
```

Buy at price 1 and sell later at price 6.

---

## 9. Why Not Use Maximum - Minimum?

Consider:

```text
prices = [8, 2, 6, 1]
```

The maximum value is 8.

The minimum value is 1.

```text
8 - 1 = 7
```

But this is invalid because price 8
appears before price 1.

You cannot sell before buying.

### Correct Approach

Track the minimum price encountered
before or on the current day.

For this example:

```text
Buy at 2
Sell at 6

Maximum Profit = 4
```

The algorithm evaluates prices in
chronological order, so it never uses
a future buying price for an earlier sale.

---

## 10. Java vs Python Comparison

| Operation | Java | Python |
|-----------|------|--------|
| Array length | prices.length | len(prices) |
| Initial minimum | prices[0] | prices[0] |
| Minimum update | if condition | if condition |
| Profit | prices[i] - minPrice | prices[i] - min_price |
| Maximum update | maxProfit = profit | max_profit = profit |
| Return | return maxProfit; | return max_profit |

---

## 11. Complexity Analysis

Let n = number of stock prices.

### Time Complexity: O(n)

The algorithm traverses the array once.

Each iteration performs constant-time
operations:

- Comparison
- Minimum price update
- Subtraction
- Maximum profit update

Therefore:

```text
T(n) = n × O(1)

Time Complexity = O(n)
```

### Space Complexity: O(1)

The algorithm uses only a fixed number
of variables:

- minPrice
- maxProfit
- profit
- i

No additional array is created.

Therefore:

```text
Auxiliary Space Complexity = O(1)
```

---

## 12. Brute Force vs Greedy

### Brute Force Approach

Try every possible buying day and
every later selling day.

```text
For each buying day:
    For every later selling day:
        Calculate profit
        Update maximum profit
```

**Time:** O(n²)

**Space:** O(1)

### Greedy Approach

Remember the lowest stock price so far
and calculate possible profit at each day.

**Time:** O(n)

**Space:** O(1)

### Comparison

| Approach | Time | Space |
|----------|------|-------|
| Brute Force | O(n²) | O(1) |
| Greedy / One Pass | O(n) | O(1) |

The Greedy approach is more efficient.

---

## 13. Important Concepts

### Greedy Algorithm

A greedy algorithm makes a locally optimal
choice at each step.

Here, we keep the lowest buying price seen
so far and use it to evaluate the best
profit when selling on the current day.

### One-Pass Traversal

The array is processed only once.

This avoids unnecessary nested loops.

### Minimum Tracking

We continuously track the lowest value
encountered so far.

### Maximum Profit Tracking

We compare each possible profit with
the previous best profit.

### Chronological Order

The buying price must come from an
earlier day than the selling price.

---

## 14. Edge Cases

| Input | Output |
|-------|--------|
| [7,1,5,3,6,4] | 5 |
| [7,6,4,3,1] | 0 |
| [1,2] | 1 |
| [2,1] | 0 |
| [3,3,3] | 0 |
| [2,4,1] | 2 |
| [1,5,2,8] | 7 |

---

## 15. Pattern Recognition

**Primary Pattern:** Greedy

**Technique:** One-Pass Array Traversal

**Key Concept:** Minimum Tracking

Recognize this pattern when a problem asks:

- Find the maximum possible profit.
- Track the minimum value seen so far.
- Find the maximum difference where order matters.
- Process an array efficiently in one pass.
- Optimize a brute-force nested-loop solution.

---

## 16. Related LeetCode Problems

- 122 — Best Time to Buy and Sell Stock II
- 123 — Best Time to Buy and Sell Stock III
- 121 — Best Time to Buy and Sell Stock
- 53 — Maximum Subarray
- 238 — Product of Array Except Self

---

## 17. Learning Outcome

Learned how to calculate the maximum
profit from one stock transaction using
the Greedy algorithm.

Understood:

- Greedy strategy
- One-pass array traversal
- Minimum price tracking
- Maximum profit tracking
- Buying before selling
- Java and Python implementations
- Time complexity O(n)
- Auxiliary space complexity O(1)

### Key Takeaway

Instead of checking every buying and
selling combination, track the lowest
buying price and calculate the possible
profit for each later selling day.

This reduces the time complexity from
O(n²) to O(n).

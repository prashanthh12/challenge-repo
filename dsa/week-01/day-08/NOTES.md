# Day 008 – Number Manipulation and Palindrome Logic

## 1. Concepts Covered

- Modulo operator (`%`)
- Integer division (`/` and `//`)
- While loops
- Digit extraction
- Reversing numbers
- Palindrome checking
- Integer overflow

## 2. Modulo Operator (%)

The modulo operator returns the remainder after division.

Example:

```java
int digit = 121 % 10;
System.out.println(digit); // 1
```

**Why is it useful?**

When we use `% 10`, we get the last digit of a positive integer.

Examples:

- `123 % 10 = 3`
- `456 % 10 = 6`
- `789 % 10 = 9`

## 3. Integer Division

Integer division helps remove the last digit.

Java:

```java
int x = 121;
x = x / 10;

System.out.println(x); // 12
```

Python:

```python
x = 121
x = x // 10

print(x)  # 12
```

## 4. Reverse Number Logic

To reverse digits, use:

```java
int digit = x % 10;
rev = rev * 10 + digit;
x = x / 10;
```

### Example: Reverse 123

| Iteration | digit | rev | x |
|---|---|---|---|
| 1 | 3 | 3 | 12 |
| 2 | 2 | 32 | 1 |
| 3 | 1 | 321 | 0 |

Result: `321`

## 5. Palindrome Logic

A palindrome number remains the same when reversed.

Examples:

- `121` → Palindrome
- `1221` → Palindrome
- `12321` → Palindrome
- `123` → Not Palindrome

### Basic Approach

1. Store the original number.
2. Reverse its digits.
3. Compare the original and reversed numbers.

**Note:** Reversing an entire 32-bit integer using Java `int` can overflow. Use a wider type or the optimized half-reversal algorithm.

## 6. Optimized Half-Reversal Method

Instead of reversing the entire number, reverse only half its digits.

Example: `1221`

- Start: `x = 1221`, `rev = 0`
- Step 1: `x = 122`, `rev = 1`
- Step 2: `x = 12`, `rev = 12`

Compare `x == rev`.

Result: `true`

For odd-digit numbers such as `121`:

- Remaining half: `1`
- Reversed half: `12`
- Remove the middle digit: `12 / 10 = 1`

Result: `true`

## 7. Edge Cases

**Negative number:** `-121` is not a palindrome because of the minus sign.

**Number ending in zero:** `120` is not a palindrome because its reversed representation begins with zero.

**Zero:** `0` is a palindrome.

**Single-digit number:** Every non-negative single-digit integer is a palindrome.

## 8. Java Practice Code

File: `PalindromeExample.java`

```java
public class PalindromeExample {

    public static void main(String[] args) {
        int x = 121;
        int original = x;
        long rev = 0;

        while (x > 0) {
            int digit = x % 10;
            rev = rev * 10 + digit;
            x = x / 10;
        }

        if (original == rev) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }
    }
}
```

Output:

```text
Palindrome
```

## 9. Python Practice Code

File: `palindrome_example.py`

```python
x = 121
original = x
rev = 0

while x > 0:
    digit = x % 10
    rev = rev * 10 + digit
    x = x // 10

if original == rev:
    print("Palindrome")
else:
    print("Not Palindrome")
```

Output:

```text
Palindrome
```

## 10. Practice Questions

1. Reverse the digits of an integer.
2. Check whether a number is a palindrome.
3. Count the digits of a number.
4. Find the sum of digits.
5. Check whether a number ends with zero.
6. Check whether a number is a palindrome without converting it to a string.

## 11. Summary

Today I learned how to:

- Extract digits using modulo.
- Remove digits using integer division.
- Reverse numbers using loops.
- Check palindrome numbers.
- Optimize palindrome checking using half reversal.
- Avoid overflow in digit-manipulation problems.


# LeetCode 242 — Valid Anagram

## Problem Information

- **Platform:** LeetCode
- **Problem Number:** 242
- **Difficulty:** Easy
- **Languages:** Java, Python
- **Primary DSA Pattern:** Hashing
- **Technique:** Character Frequency Counting
- **Approach:** Frequency Array
- **Topics:** Strings, Arrays, Hashing, Character Indexing, For Loops

**Problem Link:** https://leetcode.com/problems/valid-anagram/

---

## 1. Problem Statement

Given two strings `s` and `t`, return `true` if
`t` is an anagram of `s`. Otherwise, return `false`.

An anagram is formed by rearranging the characters
of another string while using exactly the same
characters with the same frequencies.

### Examples

| s | t | Output |
|---|---|---|
| "anagram" | "nagaram" | true |
| "rat" | "car" | false |
| "listen" | "silent" | true |
| "aabb" | "abab" | true |
| "abc" | "ab" | false |

---

## 2. Approach — Frequency Counting

### Intuition

Two strings are anagrams if every character
appears the same number of times in both strings.

We use an integer array of size 26 because
the problem contains only lowercase English
letters from 'a' to 'z'.

For each character:
- Increase its count when found in string s.
- Decrease its count when found in string t.

If all frequency differences become zero,
the strings are anagrams.

### Algorithm

1. Compare the lengths of s and t.
2. If lengths differ, return false.
3. Create a frequency array of size 26.
4. Traverse both strings.
5. Increment the frequency for a character in s.
6. Decrement the frequency for a character in t.
7. Check all 26 array positions.
8. If any frequency is nonzero, return false.
9. Otherwise, return true.

### Core Pattern

Check Length → Count Characters → Compare Frequencies

---

## 3. Java Solution

```java
class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
```

---

## 4. Understanding the Java Code

### Step 1 — Compare String Lengths

```java
if (s.length() != t.length()) {
    return false;
}
```

Anagrams must have the same length.

Example:

s = "abc"
t = "abcd"

Different lengths mean they cannot be anagrams.

### Step 2 — Create Frequency Array

```java
int[] count = new int[26];
```

Creates an integer array containing 26 zeros.

Each index represents one lowercase letter.

| Letter | Array Index |
|---|---|
| a | 0 |
| b | 1 |
| c | 2 |
| d | 3 |
| n | 13 |
| z | 25 |

### Step 3 — Convert Characters to Array Indexes

```java
s.charAt(i) - 'a'
```

`charAt(i)` returns the character at index i.

Subtracting 'a' converts a lowercase character
into an integer index between 0 and 25.

Examples:

'a' - 'a' = 0
'b' - 'a' = 1
'c' - 'a' = 2
'n' - 'a' = 13
'z' - 'a' = 25

Java uses numeric character values during
character arithmetic.

### Step 4 — Increase Frequency

```java
count[s.charAt(i) - 'a']++;
```

Example:

s = "abc"
i = 1

s.charAt(1) = 'b'

Therefore:

```java
count['b' - 'a']++;
count[1]++;
```

This increases the frequency difference
for letter 'b' by one.

### Step 5 — Decrease Frequency

```java
count[t.charAt(i) - 'a']--;
```

This decreases the frequency difference
for the character found in t.

If a character occurs equally often in
both strings, its final count becomes zero.

### Step 6 — Check Frequencies

```java
for (int i = 0; i < 26; i++) {
    if (count[i] != 0) {
        return false;
    }
}
```

If any frequency difference is nonzero,
the strings are not anagrams.

If all counts are zero, return true.

---

## 5. Python Solution

```python
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:

        if len(s) != len(t):
            return False

        count = [0] * 26

        for i in range(len(s)):
            count[ord(s[i]) - ord('a')] += 1
            count[ord(t[i]) - ord('a')] -= 1

        for frequency in count:
            if frequency != 0:
                return False

        return True
```

---

## 6. Understanding the Python Code

### Step 1 — Compare Lengths

```python
if len(s) != len(t):
    return False
```

`len()` returns the number of characters
in a string.

### Step 2 — Create Frequency List

```python
count = [0] * 26
```

Creates a list containing 26 zeros.

Python uses a list here, while Java uses
an integer array.

### Step 3 — Understand ord()

```python
ord('a')  # 97
ord('b')  # 98
ord('c')  # 99
```

`ord()` returns the Unicode code point
of a character.

To convert a character into an index:

```python
ord('c') - ord('a')
```

Calculation:

102? No — ord('c') = 99.

99 - 97 = 2

Therefore, character 'c' maps to index 2.

### Step 4 — Increase Frequency

```python
count[ord(s[i]) - ord('a')] += 1
```

This adds one to the corresponding
character's frequency difference.

### Step 5 — Decrease Frequency

```python
count[ord(t[i]) - ord('a')] -= 1
```

This subtracts one for a character in t.

### Step 6 — Check Frequencies

```python
for frequency in count:
    if frequency != 0:
        return False
```

If all frequency differences are zero,
return True.

---

## 7. Dry Run

Input:

s = "ab"
t = "ba"

Initially:

count[a] = 0
count[b] = 0

| i | s[i] | t[i] | count[a] | count[b] |
|---|---|---|---|---|
| Initial | - | - | 0 | 0 |
| 0 | a | b | 1 | -1 |
| 1 | b | a | 0 | 0 |

### Iteration 1

i = 0

s[0] = 'a'
t[0] = 'b'

Increase count[a]:

count[a] = 0 + 1 = 1

Decrease count[b]:

count[b] = 0 - 1 = -1

### Iteration 2

i = 1

s[1] = 'b'
t[1] = 'a'

Increase count[b]:

count[b] = -1 + 1 = 0

Decrease count[a]:

count[a] = 1 - 1 = 0

All counts are zero.

**Output: true**

---

## 8. Java vs Python Comparison

| Operation | Java | Python |
|---|---|---|
| String length | s.length() | len(s) |
| Get character | s.charAt(i) | s[i] |
| Frequency storage | new int[26] | [0] * 26 |
| Character to index | ch - 'a' | ord(ch) - ord('a') |
| Increment | count[i]++ | count[i] += 1 |
| Decrement | count[i]-- | count[i] -= 1 |
| Boolean true | true | True |
| Boolean false | false | False |

---

## 9. Complexity Analysis

Let n = length of the strings.

### Time Complexity: O(n)

1. Length comparison takes O(1).
2. Character traversal takes O(n).
3. Checking the 26 frequency positions takes O(26).

Total:

T(n) = O(1) + O(n) + O(26)

Since 26 is constant:

**Time Complexity = O(n)**

### Space Complexity: O(1)

The frequency array/list always contains
exactly 26 integer elements.

Its size does not increase with input length.

**Auxiliary Space Complexity = O(1)**

---

## 10. Alternative Approach — Sorting

Another approach is to sort both strings
and compare them.

Example:

s = "anagram"
t = "nagaram"

After sorting:

s = "aaagmnr"
t = "aaagmnr"

Both strings match.

### Complexity Comparison

| Approach | Time | Extra Space |
|---|---|---|
| Frequency Array | O(n) | O(1) |
| Sorting | O(n log n) | O(n) for copied character arrays |

The frequency-array approach is more
efficient for lowercase English letters.

---

## 11. Important Concepts

### Hashing

Hashing allows values to be mapped
to positions for efficient access.

Here, characters are mapped directly
to frequency-array indexes.

### Frequency Counting

Count how many times each character
appears in a string.

### Character Indexing

Java:

```java
s.charAt(i)
```

Python:

```python
s[i]
```

### Character to Integer Mapping

Java:

```java
'a' - 'a'  // 0
'b' - 'a'  // 1
```

Python:

```python
ord('a') - ord('a')  # 0
ord('b') - ord('a')  # 1
```

### Frequency Difference

The algorithm stores:

frequency in s - frequency in t

A zero difference means both strings
have the same count for that character.

---

## 12. Edge Cases

| s | t | Result |
|---|---|---|
| "a" | "a" | true |
| "a" | "b" | false |
| "ab" | "ba" | true |
| "aa" | "a" | false |
| "aab" | "abb" | false |
| "abc" | "cab" | true |

---

## 13. Pattern Recognition

**Primary Pattern:** Hashing

**Technique:** Frequency Counting

Use this pattern when problems involve:

- Comparing character frequencies
- Checking whether strings are anagrams
- Counting occurrences of characters
- Detecting repeated characters
- Comparing two collections by frequency

---

## 14. Related LeetCode Problems

- 217 — Contains Duplicate
- 49 — Group Anagrams
- 383 — Ransom Note
- 387 — First Unique Character in a String
- 242 — Valid Anagram

---

## 15. Learning Outcome

Learned how to solve Valid Anagram using
a frequency array in Java and Python.

Understood:

- String indexing
- Character-to-integer conversion
- Frequency arrays
- Hashing
- Increment and decrement operations
- Comparing frequency differences
- Time complexity O(n)
- Auxiliary space complexity O(1)

### Key Takeaway

Two strings are anagrams if they contain
the same characters with the same frequencies.

By adding frequencies from s and
subtracting frequencies from t,
all counts become zero when the
strings are anagrams.


# Week 01 — Learning Retrospective

## Week Overview

**Focus:** DSA, Java, Python, REST API Fundamentals, Git & GitHub

**Goal:** Build consistent coding habits, strengthen problem-solving skills, understand core programming concepts, and start building practical projects.

---

## 1. What I Learned

### Data Structures & Algorithms

Practiced beginner-level LeetCode problems using Java and Python.

**Arrays**
- Running Sum of 1D Array
- Concatenation of Array
- Shuffle the Array
- Richest Customer Wealth
- Plus One
- Move Zeroes
- Best Time to Buy and Sell Stock

**Strings and Hashing**
- Defanging an IP Address
- Jewels and Stones
- Contains Duplicate
- Valid Anagram

**Mathematics and Digit Manipulation**
- Reverse Integer
- Palindrome Number
- Add Digits
- Three Divisors

**Recursion**
- Print 1 to N
- Fibonacci Number

### DSA Patterns Learned

| Pattern | Problem | Key Concept |
|---------|---------|-------------|
| Array Traversal | Running Sum | Iterating through arrays |
| Two Pointers | Move Zeroes | In-place swapping |
| Hashing | Contains Duplicate | HashSet membership |
| Frequency Counting | Valid Anagram | Character frequencies |
| Greedy | Best Time to Buy and Sell Stock | Minimum price tracking |
| Digit Manipulation | Reverse Integer | Modulo and division |
| Linear Recursion | Print 1 to N | Call stack and base case |
| Branching Recursion | Fibonacci | Recursive tree |

### Java and Python

- Practiced loops, arrays, strings, and functions.
- Learned Java HashSet and Python set.
- Understood character indexing using `charAt()` and `ord()`.
- Practiced Java and Python solutions for the same problems.
- Improved understanding of time and space complexity.

### REST API Fundamentals

- Learned the purpose of REST APIs.
- Studied HTTP methods: GET, POST, PUT, PATCH, DELETE.
- Practiced fetching JSON data using Python `requests`.
- Learned about HTTP status codes and JSON responses.

### Git and GitHub

- Organized DSA solutions into folders.
- Started documenting solutions using README.md.
- Practiced Git add, commit, and push.
- Learned how to write descriptive commit messages.
- Practiced maintaining a structured learning repository.

---

## 2. Where I Got Stuck

### Understanding Array Indexing

Initially found expressions such as:

```java
ans[i + n] = nums[i];
```

and

```java
ans[2 * i] = nums[i];
```

confusing.

**What helped:**
- Manual dry runs
- Index tables
- Tracing each loop iteration

### Understanding Character Frequency Counting

Found this code difficult to understand:

```java
count[s.charAt(i) - 'a']++;
count[t.charAt(i) - 'a']--;
```

**What I learned:**
- `charAt(i)` gets a character.
- Subtracting `'a'` converts it to an index.
- `++` increases the frequency difference.
- `--` decreases the frequency difference.

### Understanding Recursion

Found recursive calls and execution order challenging.

**What helped:**
- Identifying the base case
- Drawing recursion trees
- Understanding call stack unwinding
- Comparing linear and branching recursion

### Understanding Time and Space Complexity

Needed more practice identifying:
- O(1)
- O(n)
- O(n²)
- O(log n)
- Recursive stack space

**Improvement plan:**
Analyze complexity after solving every problem.

### Git Authentication

Encountered a GitHub authentication error while pushing changes.

**Lesson:**
GitHub HTTPS authentication requires a supported credential method, such as a personal access token or Git Credential Manager, rather than an account password.

---

## 3. What Went Well

- Practiced multiple DSA problem-solving patterns.
- Improved confidence with Java loops and arrays.
- Started translating solutions into Python.
- Learned how to approach problems step by step.
- Created structured notes for better revision.
- Started exploring practical mini-projects.
- Developed a more organized GitHub workflow.

---

## 4. What Needs Improvement

- Attempt problems independently before viewing solutions.
- Practice dry runs before coding.
- Improve understanding of recursion.
- Revise previously solved problems regularly.
- Write Python solutions without translating line by line from Java.
- Build and test mini-projects independently.
- Maintain consistent Git commits.

---

## 5. Project Learning

### Number Facts CLI

Concepts explored:
- Functions
- Loops
- Number theory
- Command-line arguments
- Prime number checking
- GCD and LCM

### Concurrent API Fetcher

Concepts explored:
- Sequential and concurrent requests
- Python async/await
- asyncio.gather()
- JavaScript Promise.all()
- Measuring execution time
- Error handling

### Job Description Parser CLI

Concepts to practice:
- File handling
- Dictionaries
- String methods
- Regular expressions
- Dataclasses
- JSON output

**Note:** Project topics are learning activities; completion and GitHub push status should be updated after verifying working implementations.

---

## 6. Week 01 Self-Assessment

| Skill | Progress |
|-------|----------|
| Java Fundamentals | Improving |
| Python Fundamentals | Improving |
| Arrays | Practiced |
| Strings | Practiced |
| Hashing | Practiced |
| Two Pointers | Practiced |
| Greedy | Practiced |
| Recursion | Needs more practice |
| Time & Space Complexity | Needs more practice |
| REST API Fundamentals | Started |
| Git & GitHub | Practiced |
| Mini Projects | In progress |

---

## 7. Goals for Week 02

- [ ] Solve more Two Pointers problems.
- [ ] Practice HashMap and HashSet problems.
- [ ] Revise recursion and Fibonacci.
- [ ] Solve problems in Java and Python independently.
- [ ] Write time and space complexity for each solution.
- [ ] Complete and test a mini-project.
- [ ] Improve README documentation.
- [ ] Push verified work to GitHub.
- [ ] Continue REST API learning.

---

## 8. Key Takeaways

1. Understanding the logic is more important than memorizing code.
2. Dry runs make complex indexing easier.
3. Recognizing DSA patterns helps solve new problems.
4. Every recursive function needs a correct base case.
5. Time and space complexity should be analyzed after coding.
6. Small, consistent progress is better than irregular practice.

---

## 9. Weekly Reflection

This week helped me strengthen my programming fundamentals and understand how to approach coding problems systematically.

My biggest challenge was understanding the logic behind certain algorithms, especially character frequency counting, recursion, and array indexing.

I learned that breaking a problem into smaller steps, performing manual dry runs, and explaining the code line by line helps me understand solutions more clearly.

**Week 01 Summary:** Focused on building fundamentals, recognizing patterns, and developing consistent coding and documentation habits.

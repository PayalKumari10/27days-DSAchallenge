---
title: "📅Day 0 of Understanding Time & Space Complexity for Developers:  Strivers SDE Sheet Using Java"
seoTitle: "Time & Space Complexity Basics for Developers"
seoDescription: "Learn time and space complexity with analogies and Java code in 27 days, perfect for coding interview preparation"
datePublished: Tue Jul 15 2025 10:03:15 GMT+0000 (Coordinated Universal Time)
cuid: cmd4d6rhb000v02jscpxn67lj
slug: day-0-of-understanding-time-and-space-complexity-for-developers-strivers-sde-sheet-using-java
cover: https://cdn.hashnode.com/res/hashnode/image/upload/v1752573764086/54a0e059-204b-40bc-83b5-9652e1fb5009.png
ogImage: https://cdn.hashnode.com/res/hashnode/image/upload/v1752573645262/62ddfda6-36d3-402a-be5e-47c5d42576b9.png
tags: code, java, coding, hashnode, dsa, coding-challenge, technical-writing-1, dsainjava, space-complexity, dsa-series, timecomplexity, codingjourney, striversdesheet, payalkumari11, dsawithpayal

---

> **Note :** <mark>I’ve officially started my 27-day </mark> **<mark>DSA journey using Striver’s SDE Sheet</mark>**<mark>. Over the next few weeks, I’ll be journaling my progress daily — breaking down brute-force to optimal solutions, writing clean Java code, analyzing time and space complexity, and sharing key patterns that every aspiring software engineer should master.</mark>

This blog series is for **anyone preparing for coding interviews** — whether you’re a beginner or a revision warrior. Let’s grow together! 🚀

### **Namaste Developers! 🙏**

This blog marks **Day 0** of my Striver’s SDE Sheet journey — and I wanted to begin by strengthening one of the most essential (but often overlooked) topics:

> **(Hindi : "Code likhna easy hai, lekin efficient code likhna ek art hai."**  
> Time aur Space Complexity yehi efficiency ke artist tools hain.)

If you're like me — you've read about TC/SC before, maybe solved many questions... but kabhi kabhi samajh nahi aata tha.

This blog is my simplified version — with **real-life analogies**, **Java code**, and clear-cut interview tips — so you can not just learn it, but remember it forever.

## 💠 What is Time Complexity?

> Time Complexity measures how the **time required to run an algorithm** increases with the size of the input `n`.

We don’t measure in seconds or milliseconds. We measure in steps — because steps reflect scalability.

### 📍Real-Life Analogy:

**Imagine distributing answer sheets to students in a classroom.**

* If 1 student takes 2 seconds:  
    → **100 students = 200 seconds** → That's **O(n)** (linear time)
    
* If you have a machine that directly finds the middle roll number:  
    → That’s **O(log n)** (binary search)
    
* If you check each student against every other (like in bubble sort):  
    → That’s **O(n²)** (quadratic time)
    

### 💠 What Input Size Means

In most problems, `n` refers to:

* Number of elements in an array
    
* Number of nodes in a tree/graph
    
* Size of the string
    
* Number of operations
    

So always read the question carefully and **identify the variable** your time depends on.

## 💠What is Space Complexity?

> Space Complexity tells us how much **extra memory** is needed by the algorithm to work efficiently.

This includes:

* Temporary variables
    
* Data structures (arrays, hashmaps, stacks)
    
* Recursion stack (very important!)
    

### 📍Real-Life Analogy: Packing for a Trip

* You carry only a wallet and phone → O(1)
    
* You pack a separate bag for each day → O(n)
    
* You put bags inside bags inside more bags → O(n²)
    

> **(Hindi : "Jitna zyada memory use karega code, utni zyada space lagegi.")**

### 💠Growth of Time Complexities (Best → Worst)

| Big O Notation | Name | Example |
| --- | --- | --- |
| O(1) | Constant | Accessing `arr[5]` |
| O(log n) | Logarithmic | Binary Search |
| O(√n) | Square Root | Checking for prime factors |
| O(n) | Linear | Simple loop through array |
| O(n log n) | Log-linear | Merge Sort, Quick Sort (avg) |
| O(n²) | Quadratic | Nested loops (i, j) |
| O(n³) | Cubic | 3 nested loops – matrix |
| O(2ⁿ) | Exponential | Subsets, recursion-heavy |
| O(n!) | Factorial | Permutations, brute TSP |

## 💠Big O vs Omega vs Theta – What's the Difference?

* **O(n)** – Worst Case
    
* **Ω(n)** – Best Case
    
* **Θ(n)** – Average Case
    

### ✅ Example: Linear Search

If you're searching for an element in an array:

* Best case: It's the first element → Ω(1)
    
* Worst case: It's the last element → O(n)
    
* Average case: Somewhere in the middle → Θ(n)
    

> Interviewers usually care most about **worst-case** (Big O) — always mention that first.

### 💠Java Code Examples :

### 1\. **Sum of All Elements**

```java
public int sumArray(int[] arr) {
    int total = 0;
    for (int num : arr) {
        total += num;
    }
    return total;
}
```

* **Loop runs** `n` times (where `n` = length of `arr`)
    
* Each iteration does a constant-time operation: `total += num`
    

**Time Complexity:** `O(n)`

> Because it runs once for every element in the array, You go through each element **once**

**Space Complexity:** `O(1)`

> Only 1 variable (`total`) is used — no extra space based on input size

### 2\. **Find a Number in Array**

```java
public boolean findNumber(int[] arr, int target) {
    for (int num : arr) {
        if (num == target) return true;
    }
    return false;
}
```

* Worst case: You check **every element** to find the target
    
* So again, **n operations**
    

**Time Complexity:** `O(n)`

> Worst case: Element not found after scanning full array

**Space Complexity:** `O(1)`

> No extra space, just checking values / comparing

### 3\. Brute Force for Duplicates

```java
public boolean hasDuplicate(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[i] == arr[j]) return true;
        }
    }
    return false;
}
```

* **Nested loops:** Outer runs `n` times, inner runs up to `n` times
    
* For every `i`, we compare with every `j > i`
    

**Time Complexity:** `O(n²)`

> Because you're doing `n * n` comparisons in worst case

**Space Complexity:** `O(1)`

> No extra space used

> (Hindi : "Do loop ek ke andar ho? Samajh jao ki time double nahi, square ban gaya – O(n²)")

### 4\. Optimal Using HashSet

```java
public boolean hasDuplicate(int[] arr) {
    HashSet<Integer> set = new HashSet<>();
    for (int num : arr) {
        if (set.contains(num)) return true;
        set.add(num);
    }
    return false;
}
```

* Every `.contains()` and `.add()` is approx **O(1)** in HashSet (average case)
    
* You do that for each element → `n` operations
    

**Time Complexity:** `O(n)` (average case)

> Set operations are constant time, loop runs `n` times

**Space Complexity:** `O(n)`

> You may store all `n` elements in the HashSet

> (Hindi: "Agar input bada ho, toh nested loop se bachna. HashMap or Set ka use karo — performance mein farak padta hai!")

### 5\. Recursive Call: Factorial

```java
int factorial(int n) {
    if (n == 0) return 1;
    return n * factorial(n - 1);
}
```

* Function calls itself `n` times
    
* Each call waits for the next → uses stack
    

**Time Complexity:** `O(n)`

> One call per value down to 0

**Space Complexity:** `O(n)`

> One stack frame per call — `n` calls = `O(n)` space

## 💠Brute Force vs Optimal: Real DSA Mindset

| Approach | Time | Space | Notes |
| --- | --- | --- | --- |
| Brute Force | High | Low | Easy but slow |
| Optimal | Lower | Maybe High | Fast but may use extra space |

### 💠Summary Table:

| Code Example | Time Complexity | Space Complexity | Explanation |
| --- | --- | --- | --- |
| Sum of Array | O(n) | O(1) | One loop, no extra space |
| Find Number | O(n) | O(1) | Search all elements |
| Brute Duplicates | O(n²) | O(1) | Nested loop |
| Optimal Duplicates | O(n) | O(n) | One pass + HashSet |
| Factorial Recursion | O(n) | O(n) | n function calls = n stack frames |

### 📍Rules We Must Remember

### 🔹 Time Complexity:

| Pattern | TC |
| --- | --- |
| Single loop | O(n) |
| Nested loops | O(n²) |
| Binary Search | O(log n) |
| Two-pointer / Sliding window | O(n) |
| Hashing lookup | O(1) avg |

### 🔹 Space Complexity:

| Pattern | SC |
| --- | --- |
| Constant vars | O(1) |
| Using array/map/set | O(n) |
| Recursive function stack | O(n) |

> ### 📍Final Tip :
> 
> ✅ If you iterate through each element of an array once, the time complexity is **O(n)**.  
> ✅ If you use nested loops to compare elements, the time complexity increases to **O(n²)**.  
> ✅ If an operation executes only once regardless of input size, it is considered **O(1)** — constant time.  
> ✅ When using recursion, remember that each function call adds to the call stack, so the **space complexity** also becomes **O(n)** in such cases.

## 🎯 Why This Blog Before Day 1?

Every question in **Striver’s SDE Sheet** — from Arrays to Graphs — tests how well you optimize time and space.

When you know:

* How many loops you're running
    
* What data you're storing
    
* What the scale of the input is
    

You can **predict** and **improve** your solution — which is exactly what top companies look for.

## ✍️ Final Thoughts

This blog is my **foundation checkpoint** before jumping into Day 1 of the sheet.

> "Code toh sab likhte hain. Jo optimise karta hai — wahi real coder hai."

If you ever forget TC/SC again, bookmark this post.

### 🙏 Special Thanks

A heartfelt thank you to [**<mark>Rajvikraaditya Sir</mark>**](https://www.linkedin.com/in/rajstriver/) for creating and sharing such an incredible DSA resource with the community <mark>(takeuforward)</mark>. Your structured approach has made DSA more accessible and less intimidating for thousands of learners like me.

![](https://cdn.hashnode.com/res/hashnode/image/upload/v1752572454233/394a47ec-edc0-448c-83f0-9a54334098ea.jpeg align="center")

💬 Let’s Connect

If this helped you, do share it with your fellow DSA learners.  
Comment with your doubts — I’d love to answer and grow together 🌱

✍️ [**Payal Kumari**](https://www.linkedin.com/in/payalkumari10/) 👩‍💻  
*Officially ready to start my 27-Day DSA Journey with Striver’s Sheet! <mark>#dsawithpayal</mark>*

%[https://youtu.be/FPu9Uld7W-E?si=zqrIwqq61lWqq7wn]
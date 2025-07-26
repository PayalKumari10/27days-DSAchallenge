---
title: "📅Day-5 Striver’s SDE Sheet | Arrays Part 2 | Merge Sorted Array , Find the Duplicate Number."
seoTitle: "SDE Sheet Day 5: Arrays Challenges"
seoDescription: "Explore Day 5 of Striver's SDE Sheet journey: merging sorted arrays and finding duplicate numbers, featuring both brute-force and optimal solutions"
datePublished: Sat Jul 26 2025 15:42:19 GMT+0000 (Coordinated Universal Time)
cuid: cmdkf55vh000302l4b6koesza
slug: day-5-strivers-sde-sheet-arrays-part-2-merge-sorted-array-find-the-duplicate-number
cover: https://cdn.hashnode.com/res/hashnode/image/upload/v1753528716973/690c2c33-0cff-46b0-9439-57afce0097e8.png
ogImage: https://cdn.hashnode.com/res/hashnode/image/upload/v1753544491463/ef9dc98e-82e6-43ac-b9ea-b361a34c0c3c.png
tags: code, blogging, java, technology, coding, hashnode, dsa, coding-challenge, technical-writing-1, dsainjava, dsa-series, striversa2zdsa, striversdesheet, payalkumari11, dsawithpayal

---

> ***Note : <mark>Started my 27-day DSA journey with Striver’s SDE Sheet!</mark>  
> <mark>I will be journaling every day</mark> <mark>— recording what I learn, reflecting on it, and sharing it with my network to help fellow learners</mark> <mark>and aspiring developers..</mark> <mark>Learning through videos, resources, and the internet — simplifying logic in my own way with real-world connections. Sharing 2 questions daily: brute-force to optimal, clean Java code, time &amp; space complexity, and key patterns.</mark>***

This blog series is for **anyone preparing for coding interviews** — whether you’re a beginner or a revision warrior. Let’s grow together! 🚀

## Namaste Developers! 🙏

### **Welcome to Day 5 of my 27-day DSA journey using Striver’s SDE Sheet!**

## 1️⃣**Merge Sorted Array**

🔸 Problem Statement:

You are given two integer arrays `nums1` and `nums2`, sorted in **non-decreasing order**, and two integers `m` and `n`, representing the number of elements in `nums1` and `nums2` respectively.

**Merge** `nums1` and `nums2` into a single array sorted in **non-decreasing order**.

The final sorted array should not be returned by the function, but instead be *stored inside the array* `nums1`. To accommodate this, `nums1` has a length of `m + n`, where the first `m` elements denote the elements that should be merged, and the last `n` elements are set to `0` and should be ignored. `nums2` has a length of `n`.

```plaintext
Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
```

```plaintext
Example 2:

Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].
```

```plaintext
Example 3:

Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
```

**Constraints:**

* `nums1.length == m + n`
    
* `nums2.length == n`
    
* `0 <= m, n <= 200`
    
* `1 <= m + n <= 200`
    
* `-10<sup>9</sup> <= nums1[i], nums2[j] <= 10<sup>9</sup>`
    

**Follow up:** Can you come up with an algorithm that runs in `O(m + n)` time?

## <mark>💠Real Life Example</mark>

Imagine you're arranging two sorted lines of people according to height.  
One line (nums1) has some **empty spots at the end** to fit people from the second line (nums2).  
Your goal is to arrange **all people in one line** in **ascending order of height** — **without using another queue**!

### 💠Brute Force Approach

### 📍Steps:

* Copy all elements of `nums2` to the end of `nums1`.
    
* Sort the entire `nums1`.
    

(Hinglish :

* Step 1️⃣: `nums2` ke saare elements ko `nums1` ke bache hue jagah mein daal ni h.
    
* Step 2️⃣: Fir `Arrays.sort()` se pura `nums1` sort kar diya.
    
* **Lekin problem yeh hai** ki humre dono arrays pehle se sorted hain. Toh dobara sort karna time waste hai.)
    
    ```java
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
         for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);   
        }
    }
    ```
    
    ### 📍Time Complexity (TC):
    
    * ### `O(n)` → copying elements
        
    * `O((m + n) * log(m + n))` → sorting entire array
        
    
    ✅ **<mark>Final TC: O((m + n) log(m + n))</mark>**
    

### 📍Space Complexity (SC):

* `O(log(m + n))` – because `Arrays.sort()` in Java uses **Timsort**, which requires **auxiliary stack space** (not extra array), so it's **not strictly in-place**.
    
    ✅ **Final SC: O(log(m + n))**
    

🔸 **(Hinglish:** Brute force mein bas dono arrays merge karke sort kar diya, lekin yeh optimal nahi hai! )

## 💠Optimal Two Pointer Approach (From Back):

**Idea:** Use two pointers starting from the ends of `nums1` and `nums2` and place the larger element at the back of `nums1`.

### (Hinglish :

* Hum **piche se compare karenge** (i.e., from end of both arrays)
    
* Jo bada hoga, usko `nums1` ke end mein daalenge.
    
* **Fayda**: overwrite bhi ho jayega, aur sort bhi nahi karna padega.)
    

### 📌 Steps:

1. Initialize three pointers:
    
    * `i = m - 1` (last valid element in `nums1`)
        
    * `j = n - 1` (last element in `nums2`)
        
    * `k = m + n - 1` (last index of `nums1`)
        
2. Compare and fill from the back:
    
    * If `nums1[i] > nums2[j]`, place `nums1[i]` at `nums1[k]`
        
    * Else place `nums2[j]` at `nums1[k]`
        
    * Move pointers accordingly
        
3. Copy remaining `nums2` if any
    

```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; // nums1 ka last element index
        int j = n - 1; // nums2 ka last element index
        int k = m + n - 1; // nums1 ke end ka index jaha se bharna hai

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--]; // bada element end mein daalo
            } else {
                nums1[k--] = nums2[j--]; // bada element end mein daalo
            }
        }

        // agar nums2 ke elements bache hain
        while (j >= 0) {
            nums1[k--] = nums2[j--]; // remaining nums2 elements daal do
        }
    }
}
```

### 📍Time Complexity (TC):

Let:

* `m` = number of initial elements in `nums1`
    
* `n` = number of elements in `nums2`
    

#### ✅ Loop Details:

* While loop runs while `i >= 0 && j >= 0` → At most `m + n` comparisons
    
* Second while loop runs for leftover elements in `nums2` → At most `n` times
    

✅ **<mark>Total Time: O(m + n)</mark>**

### 📍Space Complexity (SC):

* No extra array used.
    
* Just 3 pointers (`i`, `j`, `k`), which are constant.
    

✅ **<mark>Space: O(1)</mark>**

🔸**(Hinglish:** Yeh trick super se bhi upar hai! Piche se start karo, jahan space available hai wahan merge karo )

## 📍Highlights :

✅ Brute force karne ka matlab hai sort kar dena pura array — time barbaad.  
✅ Optimal mein do pointer lagao — dono arrays ke end se, aur compare karte hue merge karo.

---

## **2️⃣Find the Duplicate Number**

🔸 Problem Statement:

Given an array of integers `nums` containing `n + 1` integers where each integer is in the range `[1, n]` inclusive.

There is only **one repeated number** in `nums`, return *this repeated number*.

You must solve the problem **without** modifying the array `nums` and using only constant extra space.

```plaintext
Example 1:

Input: nums = [1,3,4,2,2]
Output: 2

Example 2:

Input: nums = [3,1,3,4,2]
Output: 3

Example 3:

Input: nums = [3,3,3,3,3]
Output: 3
```

**Constraints:**

* `1 <= n <= 10<sup>5</sup>`
    
* `nums.length == n + 1`
    
* `1 <= nums[i] <= n`
    
* All the integers in `nums` appear only **once** except for **precisely one integer** which appears **two or more** times.
    

**Follow up:**

* How can we prove that at least one duplicate number must exist in `nums`?
    
* Can you solve the problem in linear runtime complexity?
    

## 💠Real Life Example:

Imagine you're organizing a school competition where every student is given a **unique roll number from 1 to n**, but **by mistake**, one roll number is given to **more than one student**.

You have a list of roll numbers submitted by students.  
Now your task is to find **which roll number is duplicated** — **without changing the list** and without using a register or pen (no extra space).

## 💠Brute Force Approach

Compare every pair of elements. If two elements are the same, that’s the duplicate.

### 📍Idea:

* Use two loops and compare every pair
    
* If two numbers match → that’s the duplicate
    

```java
class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j]) return nums[i]; // match mila, duplicate found
            }
        }
        return -1;
    }
}
```

#### 💠Time Complexity:

* Outer loop: O(n)
    
* Inner loop: O(n)  
    ✅ **TC = O(n²)** → ❌ **TLE on large inputs**
    

#### 💠 Space Complexity:

* No extra space → ✅ **O(1)**
    

> ⚠️ **Note:** Ye approach chhoti input ke liye kaam karti hai, lekin **larger inputs mein TLE** de deti hai. That's why we move to better solutions below.

### 📍Transition to Better Approach

Then introduce HashSet and Floyd's Cycle (optimal) with comparisons  
This transition dikhata hai ki tumne problem ko depth mein samjha and optimize kiya — jo interview mein aur readers ke liye valuable hota hai!

### 💠Optimal Approach

### Intuition:

This problem is a **disguised Linked List cycle** problem!

When each number in the array represents a **pointer to the next index**, due to the duplicate, a **cycle forms** just like in a linked list.

```plaintext
nums = [3, 1, 3, 4, 2]
index → value (pointer to)
0 → 3  
1 → 1  
2 → 3  
3 → 4  
4 → 2  
```

This forms a cycle: 3 → 4 → 2 → 3 → ...

Now apply the **Floyd’s Cycle Detection Algorithm**

### 📍Steps:

1. **Phase 1**: Detect the cycle using slow and fast pointers
    
2. **Phase 2**: Find entry point of the cycle – that's the duplicate!
    

```java
class Solution {
    public int findDuplicate(int[] nums) {
        // Step 1: Detect intersection point (cycle meeting)
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];      // 1 step
            fast = nums[nums[fast]]; // 2 steps
        } while (slow != fast);

        // Step 2: Find entry point of cycle = duplicate number
        fast = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
```

### 📍Time Complexity:

* O(n) ✅  
    (Each pointer visits at most `n` elements)
    

### 📍Space Complexity:

* O(1) ✅  
    (No extra space used)
    

## 💠Highlights

* **Array ko linked list ki tarah treat karo** → because `nums[i]` gives the next pointer
    
* **Floyd’s algorithm lagao** ➤ slow & fast pointer use karke cycle detect karo
    
* Duplicate hamesha **cycle ka entry point** hoga
    
* **Kuch bhi modify nahi karna** array mein
    
* **Space bilkul nahi lena hai extra** ➤ O(1)
    

## ✅Conclusion (Blog End Thoughts)

This problem teaches you the **power of thinking differently**.  
Sometimes, array problems are actually **graph or linked list problems** in disguise!

\=&gt; Just like life, **kabhi kabhi seedha solution nahi dikhta**, thoda ghumake sochna padta hai

## ✍️ Final Notes:

If you're just starting your DSA journey like me, don't worry if you don’t get it perfect the first time.  
**Visualize → Dry Run → Optimize.**  
Stay consistent, and let’s crack every problem from brute to optimal! 💪

### 🙏 Special Thanks

A heartfelt thank you to [**<mark>Rajvikraaditya Sir</mark>**](https://www.linkedin.com/in/rajstriver/) for creating and sharing such an incredible DSA resource with the community <mark>(takeuforward)</mark>. Your structured approach has made DSA more accessible and less intimidating for thousands of learners like me.

If this helped you, do share it with your fellow DSA learners.  
Comment with your doubts — I’d love to answer and grow together 🌱

✍️ [**Payal Kumari**](https://www.linkedin.com/in/payalkumari10/) 👩‍💻  
*My 27-Day DSA Journey with Striver’s Sheet! <mark>#dsawithpayal</mark>*

![](https://cdn.hashnode.com/res/hashnode/image/upload/v1753543966207/e3c4218b-c1f5-4046-a381-3f4edb9d696a.jpeg align="center")

%[https://youtu.be/n7uwj04E0I4] 

%[https://youtu.be/32Ll35mhWg0]
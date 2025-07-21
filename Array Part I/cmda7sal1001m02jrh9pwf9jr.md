---
title: "📅Day 2 - Striver’s SDE Sheet | Arrays Part 1 | Q3 & Q4: Next Permutation & Kadane's Algorithm"
seoTitle: "Next Permutation & Kadane's Algorithm"
seoDescription: "Join a 27-day DSA journey with Striver's SDE Sheet. Explore Day 2: Next Permutation and Kadane's Algorithm for coding interviews. 🚀"
datePublished: Sat Jul 19 2025 12:18:39 GMT+0000 (Coordinated Universal Time)
cuid: cmda7sal1001m02jrh9pwf9jr
slug: day-2-strivers-sde-sheet-arrays-part-1-q3-and-q4-next-permutation-and-kadanes-algorithm
cover: https://cdn.hashnode.com/res/hashnode/image/upload/v1752862921298/76e60f16-3cb5-4e7b-b08a-553bfec6a8a0.png
ogImage: https://cdn.hashnode.com/res/hashnode/image/upload/v1752926960067/2180e411-59a7-4993-a6e0-1d7a140eaff5.png
tags: cpp, java, technology, hashnode, dsa, coding-challenge, technical-writing-1, coding-journey, kadanes-algorithm, next-permutation, dsa-series, codinginterview, striversa2zdsa, payalkumari11, dsawithpayal

---

> ***Note : <mark>Started my 27-day DSA journey with Striver’s SDE Sheet!</mark>  
> <mark>I will be journaling every day</mark> <mark>— recording what I learn, reflecting on it, and sharing it with my network to help fellow learners</mark> <mark>and aspiring developers..</mark> <mark>Learning through videos, resources, and the internet — simplifying logic in my own way with real-world connections. Sharing 2 questions daily: brute-force to optimal, clean Java code, time &amp; space complexity, and key patterns.</mark>***

This blog series is for **anyone preparing for coding interviews** — whether you’re a beginner or a revision warrior. Let’s grow together! 🚀

---

## Namaste Developers! 🙏

### **Welcome to Day 2 of my 27-day DSA journey using Striver’s SDE Sheet!**

## 💠What is a Permutation?

In simple words,

A permutation of an array is an arrangement or reordering of its elements.

Real-Life Example: Socho ek box mein 3 different color ke balls hain: Red , Blue , Green .

Agar tum inka har possible sequence banana chahte ho toh:

* \[Red, Blue, Green\]
    
* \[Red, Green, Blue\]
    
* \[Green, Red, Blue\]
    
* ... and so on!
    

Ye sab hi permutations hain.

## 💠What is "Next" Permutation?

Ab maan lo tumhare paas ek permutation already hai — for example: \[1, 2, 3\]

Toh iska **next permutation** hoga lexicographically (dictionary-like order) next arrangement i.e. \[1, 3, 2\]

Lexicographical means: jaisa tum words ko dictionary mein arrange karte ho — waise hi numbers bhi arrange hote hain.

## 💠 Real-Life Example for Intuition

Imagine tum password try kar rahe ho on a locker: 1️⃣2️⃣3️⃣

You want to try the next possible guess — tum chahte ho ki pehle se thoda aage wala pattern mile automatically.

That’s what "Next Permutation" helps with!

## 📍Example:

Input: \[1,2,3\]  
Next Permutation: \[1,3,2\]

Input: \[3,2,1\]  
Next Permutation: \[1,2,3\]  
(Because this is the last permutation, we rotate it to the smallest one)

Input: \[1,1,5\]  
Next Permutation: \[1,5,1\]

## 💠Problem Statement

### **🟢<mark>Next Permutation</mark>** **:** A **permutation** of an array of integers is an arrangement of its members into a sequence or linear order.

* For example, for `arr = [1,2,3]`, the following are all the permutations of `arr`: `[1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1]`.
    

The **next permutation** of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the **next permutation** of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

* For example, the next permutation of `arr = [1,2,3]` is `[1,3,2]`.
    
* Similarly, the next permutation of `arr = [2,3,1]` is `[3,1,2]`.
    
* While the next permutation of `arr = [3,2,1]` is `[1,2,3]` because `[3,2,1]` does not have a lexicographical larger rearrangement.
    

Given an array of integers `nums`, *find the next permutation of* `nums`.

The rep[lacement](http://en.wikipedia.org/wiki/In-place_algorithm) must be [**in place**](http://en.wikipedia.org/wiki/In-place_algorithm) and use only constant extra memory.

```plaintext
Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]
```

```plaintext
Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]
```

```plaintext
Example 3:

Input: nums = [1,1,5]
Output: [1,5,1]
```

**Constraints:**

* `1 <= nums.length <= 100`
    
* `0 <= nums[i] <= 100`
    

## 💠Brute Force Approach (Not Recommended)

[Idea:](http://en.wikipedia.org/wiki/In-place_algorithm)

* Generate all permutations of the array.
    
* Sort them.
    
* Find the next one after the current.
    

Problem: Time complexity is too [high (O](http://en.wikipedia.org/wiki/In-place_algorithm)(N!)) and not efficient at all.

## 💠Optimal Approach (In-place and Efficient)

We follow 3️⃣ steps:

### Step 1: Find the Break Point

* Traverse from right to left.
    
* Find the first number that is smaller than its next number.
    
* Call it index `i`.
    

Why? Ye index batata hai jahan se hum permutation ko modify karna start karenge.

Example: In \[1, 3, 5, 4, 2\], break point is at index 1 (value = 3)

### Step 2: Find the Just Greater Element

* Again, move from rig[ht to le](http://en.wikipedia.org/wiki/In-place_algorithm)ft and find the first number that is bigger than `nums[i]`
    
* [Let’s](http://en.wikipedia.org/wiki/In-place_algorithm) call its index `j`
    
* Swap `nums[i]` and `nums[j]`
    

So now w[e get a](http://en.wikipedia.org/wiki/In-place_algorithm) slightly bigger number.

### Step 3: Reverse the Right Part

* Reverse the part of array from index `i+1` to end.
    
* This give[s the ne](http://en.wikipedia.org/wiki/In-place_algorithm)xt lexicographically smallest arrangement.
    

```java
class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;

        // Step 1: Find first decreasing element from end
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // Step 2: If found, find next greater element and swap
        if (i >= 0) {
            int j = n - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            // swap
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        // Step 3: Reverse the remaining array
        reverse(nums, i + 1, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}
```

Time & Space Complexity

| Complexity | Value |
| --- | --- |
| Time | O(N) |
| Space | O(1) (In-place) |

## 📍Highlights & Tips :

* Ye pattern DSA interviews mein kaafi baar poocha ja chuka hai (Top companies like Google, Amazon, etc.)
    
* Focus karo "breakpoint" dhoondhne par — wahi sabse important step hai!
    
* Don't forget to reverse the right half after swap.
    
* Jab array already in decreasing order ho, next permutation hoti hai sorted (ascending) form.
    

---

## **💠What is Kadane’s Algorithm?**

Kadane’s algorithm **continuously tracks the best possible sum of a subarray ending at each index**, and resets it when the running sum becomes negative.

**Kadane’s Algorithm** ek **efficient way hai maximum subarray sum nikalne ka** — matlab **continuous elements ka woh group jinka sum sabse zyada ho**.

> **Kadane’s says**:  
> **"Agar tumhare paas ek achha sum chal raha hai, toh usme naye element ko jodte jao. Agar woh sum negative ho jaye, toh usko chhodo aur naya start karo."**

📍Real Life Analogy:

Socho tum ek marathon bhaag rahe ho (continuous subarray), aur kabhi kabhi thak jaate ho (negative sum).  
Kadane's kehta hai:

> **"Jab tak energy positive hai, bhaag te raho. Jaise hi energy negative ho gayi, reset karo aur fresh start lo!"**

### 💠Kadane’s Ka Sochne Ka Tareeka:

1. `currentSum` rakho — jo tum abhi tak ka sum calculate kar rahe ho.
    
2. `maxSum` rakho — ab tak mila sabse bada sum.
    

Every step pe decide karo:

> **"Kya mujhe naye number se fresh start karna chahiye? Ya previous subarray ko continue karna chahiye?"**

### **🟢<mark>Kadane's Algorithm </mark> : Maximum Subarray Sum in an Array**

Given an integer array `nums`, find the subarray with the largest sum, and return *its sum*.

```plaintext
Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
```

```plaintext
Example 2:

Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.
```

```plaintext
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
```

**Constraints:**

* `1 <= nums.length <= 10<sup>5</sup>`
    
* `-10<sup>4</sup> <= nums[i] <= 10<sup>4</sup>`
    

**Follow up:** If you have figured out the `O(n)` solution, try coding another solution using the **divide and conquer** approach, which is more subtle.

```plaintext
nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
```

### 📍 Real-Life Example

Socho tumhare paas ek graph ho jo daily profit/damage dikhata hai — kabhi profit ho raha hai kabhi nuksan. Tumhe dekhna hai ki kaunsa period (subarray) sabse zyada profitable tha. Bas wahi hai yeh Maximum Subarray problem!

### 💠Brute Force Approach

```java
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int currentSum = 0;
            for (int j = i; j < n; j++) {
                currentSum += nums[j];
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum;
    }
}
```

❌Yeh code TLE dega jab input bada hoga (10⁵ elements), kyunki:

* Har index se har possible subarray check karta hai.
    
* Time Complexity: O(n²)
    

### 💠Time Complexity: O(n²)

* Outer loop runs n times.
    
* Inner loop runs n-i times.
    
* Total iterations ≈ n + (n-1) + (n-2) + ... + 1 = n(n+1)/2 → O(n²)
    

Example: Agar array size 10⁵ hai, toh 10⁵ × 10⁵ = 10¹⁰ operations → ❌ TLE in interview/code test

### 💠 Space Complexity: O(1)

* No extra space used except some variables (maxSum, currentSum)
    

📍 Real-life analogy:  
Imagine checking happiness of every day-to-every-day combo in a year — 365 × 365 = 1,33,225 combinations! Thak jaoge!

### 💠Optimal Approach

Kadane's Algorithm is based on a simple idea:

> Either continue the previous subarray or start a new one.

```java
class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
```

### 💠Time Complexity: O(n)

* Ek hi baar array traverse kar rahe ho
    
* No nested loop
    

### 💠 Space Complexity: O(1)

* Sirf 2 variables: currentSum and maxSum
    

📍Real-life analogy:  
Jaise tum har din ka mood dekh ke turant decide karo — continue karna ya new streak start karna. Simple & fast!

### 📍Concept behind Kadane's Algorithm

* Har element pe do choice hoti hai:
    
    1. **Khud se start karu?** (nums\[i\])
        
    2. **Pichle wale ke sath jod lu?** (currentSum + nums\[i\])
        
* Jo bhi zyada hoga, wahi current subarray banega.
    

Soch lo daily ka mood tracker hai, jahan kuch din kharab ja rahe the, aur achanak ek achha din aaya. Tab tum decide karte ho ki naye tareeke se shuru karte hain ya pichle dino ke effort ko continue karte hain. 💪

## ✍️ Final Notes:

If you're just starting your DSA journey like me, don't worry if you don’t get it perfect the first time.  
**Visualize → Dry Run → Optimize.**  
Stay consistent, and let’s crack every problem from brute to optimal! 💪

### 🙏 Special Thanks

A heartfelt thank you to [**<mark>Rajvikraaditya Sir</mark>**](https://www.linkedin.com/in/rajstriver/) for creating and sharing such an incredible DSA resource with the community <mark>(takeuforward)</mark>. Your structured approach has made DSA more accessible and less intimidating for thousands of learners like me.

If this helped you, do share it with your fellow DSA learners.  
Comment with your doubts — I’d love to answer and grow together 🌱

✍️ [**Payal Kumari**](https://www.linkedin.com/in/payalkumari10/) 👩‍💻  
*Officially ready to start my 27-Day DSA Journey with Striver’s Sheet! <mark>#dsawithpayal</mark>*

![](https://cdn.hashnode.com/res/hashnode/image/upload/v1752926635189/2c670b77-124e-4384-86f7-40f1ddf286ef.jpeg align="center")

%[https://youtu.be/JDOXKqF60RQ?si=v4s-tD0O4ErDLc7G] 

%[https://youtu.be/AHZpyENo7k4?si=n-OXdEF3ODEyFX9W]
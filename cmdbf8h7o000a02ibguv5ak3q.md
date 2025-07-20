---
title: "📅Day-3 Striver’s SDE Sheet | Arrays Part 1 | Q5 & Q6: Sort an array of 0's, 1's and 2's & Stock Buy and Sell"
seoTitle: "Sort Arrays and Optimize Stock Transactions"
seoDescription: "Explore Day 3 of the 27-day DSA journey with Striver’s SDE Sheet: mastering sorting 0's, 1's, 2's, and optimizing stock trading"
datePublished: Sun Jul 20 2025 08:34:58 GMT+0000 (Coordinated Universal Time)
cuid: cmdbf8h7o000a02ibguv5ak3q
slug: day-3-strivers-sde-sheet-arrays-part-1-q5-and-q6-sort-an-array-of-0s-1s-and-2s-and-stock-buy-and-sell
cover: https://cdn.hashnode.com/res/hashnode/image/upload/v1752995593135/9fb622aa-e299-4a08-9bee-1ab19137dd09.png
ogImage: https://cdn.hashnode.com/res/hashnode/image/upload/v1753000368733/0181db41-7154-411b-ac71-e38ebd7f1017.png
tags: code, java, technology, coding, hashnode, dsa, coding-challenge, technical-writing-1, coding-journey, dsainjava, striver-dsa-sheet, striversa2zdsa, striversdesheet, payalkumari11, dsawithpayal

---

> ***Note : <mark>Started my 27-day DSA journey with Striver’s SDE Sheet!</mark>  
> <mark>I will be journaling every day</mark> <mark>— recording what I learn, reflecting on it, and sharing it with my network to help fellow learners</mark> <mark>and aspiring developers..</mark> <mark>Learning through videos, resources, and the internet — simplifying logic in my own way with real-world connections. Sharing 2 questions daily: brute-force to optimal, clean Java code, time &amp; space complexity, and key patterns.</mark>***

This blog series is for **anyone preparing for coding interviews** — whether you’re a beginner or a revision warrior. Let’s grow together! 🚀

---

## Namaste Developers! 🙏

### **Welcome to Day 3 of my 27-day DSA journey using Striver’s SDE Sheet!**

## 1️⃣ **Sort an array of 0's, 1's and 2's**

🔸 Problem Statement:

Given an array `nums` with `n` objects colored red, white, or blue, sort them [**in-place**](https://en.wikipedia.org/wiki/In-place_algorithm) so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers `0`, `1`, and `2` to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

**Example 1:**

```plaintext
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
```

**Example 2:**

```plaintext
Input: nums = [2,0,1]
Output: [0,1,2]
```

**Constraints:**

* `n == nums.length`
    
* `1 <= n <= 300`
    
* `nums[i]` is either `0`, `1`, or `2`.
    

### 💠Real Life

Imagine you are a shopkeeper sorting **red, white, and blue balls** randomly dumped on a table. You want to quickly group them by color **in a single go**, without using any extra baskets or boxes.

## 1️⃣ **Brute Force Approach: Count & Overwrite**

### 📌 Idea:

First count how many 0s, 1s, and 2s are in the array, then **overwrite** the original array in order.

### ✅ Steps:

* Loop through array and count 0s, 1s, 2s.
    
* Overwrite array using those counts.
    

### ✅Code:

```java
class Solution {
    public void sortColors(int[] nums) {
        int count0 = 0, count1 = 0, count2 = 0;

        for (int num : nums) {
            if (num == 0) count0++;
            else if (num == 1) count1++;
            else count2++;
        }

        int i = 0;
        while (count0-- > 0) nums[i++] = 0;
        while (count1-- > 0) nums[i++] = 1;
        while (count2-- > 0) nums[i++] = 2;
    }
}
```

### ✅Time Complexity:

* First loop to count: `O(n)`
    
* Second loop to write: `O(n)`
    
* 🔹 **Total TC = O(n)**  
    (2 linear loops)
    

### ✅Space Complexity:

* Constant extra variables only → **O(1)**
    

> “Pehle count kar liya har color ka, fir usi order me array overwrite kar diya — simple!”  
> Lekin do baar loop chal raha hai — isse aur optimize kiya ja sakta hai.

### 2️⃣ **Optimal Approach: Dutch National Flag Algorithm**

### 📌 Idea:

Use **3 pointers** — `low`, `mid`, `high` to place 0s, 1s, and 2s correctly in **one-pass**.

### ✅ Pointer Roles:

* `low` → next position for 0
    
* `mid` → current element
    
* `high` → next position for 2 (from end)
    

### ✅ Logic:

* If `nums[mid] == 0`: Swap with `low`, move `low++`, `mid++`
    
* If `nums[mid] == 1`: Just `mid++`
    
* If `nums[mid] == 2`: Swap with `high`, only `high-`
    

### Code:

```java
class Solution {
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
```

### ✅Time Complexity:

* Single while loop → **O(n)**  
    Because each element is checked at most once
    

### ✅ Space Complexity:

* Only 3 pointers used → **O(1)**
    

> “Ek hi baar array ko scan karke, 0 ko left me bhejna, 2 ko right me, aur 1 apne jagah pe rakhna — super efficient!”

## 💠How to Calculate Time & Space Complexity?

**📍Time Complexity (TC):**

* Look for loops:
    
    * 1 loop → `O(n)`
        
    * 2 nested loops → `O(n²)`
        
* Recursion? Consider call stack depth
    

**📍Space Complexity (SC):**

* Count **extra space** (arrays, HashMaps, etc.)
    
* Using only a few variables = `O(1)`
    

> **<mark>Pro Tip:</mark>**  
> "Jitni baar array ya structure ko traverse kar rahe ho, usi hisaab se TC hoti hai."

---

### **2️⃣ Best Time to Buy and Sell Stock**

🔸 Problem Statement:

You are given an array `prices` where `prices[i]` is the price of a given stock on the `i<sup>th</sup>` day.

You want to maximize your profit by choosing a **single day** to buy one stock and choosing a **different day in the future** to sell that stock.

Return *the maximum profit you can achieve from this transaction*. If you cannot achieve any profit, return `0`.

**Example 1:**

```plaintext
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
```

**Example 2:**

```plaintext
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
```

### **💠Real-Life Analogy:**

> Think of this like visiting a **vegetable market** 🌽  
> You want to **buy onions at the lowest price**, and then **sell them later at the highest price** to earn profit.  
> But you can **only sell after buying** — you can't go back in time!

### 1️⃣Brute Force

### 📌 Idea:

Try **all pairs of days** (i, j) where i &lt; j and check the profit if you buy on day i and sell on day j.

```java
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        return maxProfit;
    }
}
```

### ✅Time Complexity: `O(n²)`

(2 nested loops, checking every pair)

### ✅Space Complexity: `O(1)`

(No extra space used)

> “Har possible din ka pair try kar rahe ho — buy day `i`, sell day `j` — lekin ye slow hoga jab array bada ho.”

### 2️⃣Optimal Approach

### 📌 Idea:

Keep track of the **minimum price so far** while traversing, and for each day, calculate the **profit** if you sell today.

Update `maxProfit` whenever a higher profit is found.

```java
class Solution {
    public int maxProfit(int[] prices) {
        int mini = prices[0];
        int maxProfit = 0;
        int n = prices.length;

        for (int i = 1; i < n; i++) {
            int cost = prices[i] - mini;
            maxProfit = Math.max(maxProfit, cost);
            mini = Math.min(mini, prices[i]);
        }
        return maxProfit;
    }
}
```

### **✅Time Complexity**

* The loop runs exactly once for each element (excluding the first one), so it runs **n - 1 times**, which is **O(n)**.
    
* All operations inside the loop are constant time: subtraction, `Math.max`, and `Math.min`.
    

**🔹 TC = O(n)**

### **✅Space Complexity**

* You're using only a **constant number of extra variables** (`mini`, `maxProfit`, `cost`), regardless of the input size.
    

**🔹 SC = O(1)**

> “Jaise jaise market ka price dekhte ja rahe ho, agar naye minimum pe pohche toh us din buy karne ka socho. Agar naye din pe zyada price mile, toh profit calculate karo.”

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

![](https://cdn.hashnode.com/res/hashnode/image/upload/v1753000039389/7870b668-1a03-4b06-939b-c76ac73f3ae2.jpeg align="center")

%[https://youtu.be/tp8JIuCXBaU?si=xEZSHBVSehrw6Dae] 

%[https://youtu.be/excAOvwF_Wk?si=IJxHQkG8KFHIuAr-]
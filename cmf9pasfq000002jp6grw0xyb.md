---
title: "📅Day-21 Striver’s SDE Sheet | Linked List and Arrays | Remove Duplicates from Sorted Array & Max Consecutive Ones."
seoTitle: "Linked Lists & Arrays: Remove Duplicates & More"
seoDescription: "Join Day 21 of Payal's journey with Striver’s SDE Sheet, tackling Linked Lists, Arrays, and more for effective coding interview prep"
datePublished: Sun Sep 07 2025 13:00:34 GMT+0000 (Coordinated Universal Time)
cuid: cmf9pasfq000002jp6grw0xyb
slug: day-21-strivers-sde-sheet-linked-list-and-arrays-remove-duplicates-from-sorted-array-and-max-consecutive-ones
cover: https://cdn.hashnode.com/res/hashnode/image/upload/v1757223498364/46302840-823f-4550-aaa5-f2077ce04ad6.png
ogImage: https://cdn.hashnode.com/res/hashnode/image/upload/v1757249964611/0e20a2ca-25a7-4c4a-8ece-a9b4f91e9f72.png
tags: algorithms, java, technology, data-structures, hashnode, dsa, techblog, technical-writing-1, dsainjava, dsa-series, striver-dsa-sheet, striversa2zdsa, striversdesheet, payalkumari11, dsawithpayal

---

> ***Note : <mark>Started my 27-day DSA journey with Striver’s SDE Sheet!</mark>  
> <mark>I will be journaling every day</mark> <mark>— recording what I learn, reflecting on it, and sharing it with my network to help fellow learners</mark> <mark>and aspiring developers..</mark> <mark>Learning through videos, resources, and the internet — simplifying logic in my own way with real-world connections. Sharing 2 questions daily: brute-force to optimal, clean Java code, time &amp; space complexity, and key patterns.</mark>***

This blog series is for **anyone preparing for coding interviews** whether you’re a beginner or a revision warrior. Let’s grow together!

## Namaste Developers! 🙏

**Welcome to Day 21 of my 27-day DSA journey using Striver’s SDE Sheet!**

# 1️⃣ **Remove Duplicates from Sorted Array**

### 🔸 Problem Statement:

Given an integer array `nums` sorted in **non-decreasing order**, remove the duplicates [**in-place**](https://en.wikipedia.org/wiki/In-place_algorithm) such that each unique element appears only **once**. The **relative order** of the elements should be kept the **same**. Then return *the number of unique elements in* `nums`.

Consider the number of unique elements of `nums` to be `k`, to get accepted, you need to do the following things:

* Change the array `nums` such that the first `k` elements of `nums` contain the unique elements in the order they were present in `nums` initially. The remaining elements of `nums` are not important as well as the size of `nums`.
    
* Return `k`.
    

**Custom Judge:**

The judge will test your solution with the following code:

```plaintext
int[] nums = [...]; // Input array
int[] expectedNums = [...]; // The expected answer with correct length

int k = removeDuplicates(nums); // Calls your implementation

assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
    assert nums[i] == expectedNums[i];
}
```

If all assertions pass, then your solution will be **accepted**.

**Example 1:**

```plaintext
Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
```

**Example 2:**

```plaintext
Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
```

**Constraints:**

* `1 <= nums.length <= 3 * 10<sup>4</sup>`
    
* `-100 <= nums[i] <= 100`
    
* `nums` is sorted in **non-decreasing** order.
    

## <mark>Real-World Example</mark>

Imagine you’re cleaning your **phone contact list**.

* Since it’s sorted alphabetically, you might find **duplicate names** (like 3 entries of "Rahul").
    
* You don’t want multiple "Rahul" entries, bas ek hi kaafi hai.
    
* So you keep **only one Rahul** and delete the rest.
    

That’s exactly what we’re doing in this problem: **keeping unique entries, removing duplicates.**

**(<mark>Hinglish:</mark>**  
Contacts list clean karna hai → ek hi naam baar-baar likha ho toh sirf ek baar rakho, baaki delete kar do.)

## 1️⃣ Brute Force Approach

* Use a **HashSet** to store unique numbers.
    
* Copy them back into `nums`.
    

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        Set<Integer> set = new LinkedHashSet<>();
        for (int num : nums) set.add(num);

        int i = 0;
        for (int val : set) nums[i++] = val;
        return set.size();
    }
}
```

### **<mark>Time Complexity:</mark>** O(N)

### **<mark>Space Complexity:</mark>** O(N) (extra space for Set)

## 2️⃣ Optimal Approach (Two Pointers)

* Keep one pointer `i` for unique elements, another pointer `j` to scan array.
    
* If `nums[j] != nums[i]`, move `i` forward and assign `nums[i] = nums[j]`.
    
* At the end, answer is `i + 1`.
    
    ```java
    class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums.length == 0) return 0;
            
            int i = 0;
            for (int j = 1; j < nums.length; j++) {
                if (nums[j] != nums[i]) {
                    i++;
                    nums[i] = nums[j];
                }
            }
            return i + 1;
        }
    }
    ```
    
    ### **<mark>Time Complexity:</mark>** O(N)
    
    ### **<mark>Space Complexity:</mark>** O(1)
    

---

# **2️⃣ Max Consecutive Ones**

Given a binary array `nums`, return *the maximum number of consecutive* `1`*'s in the array*.

**Example 1:**

```plaintext
Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
```

**Example 2:**

```plaintext
Input: nums = [1,0,1,1,0,1]
Output: 2
```

**Constraints:**

* `1 <= nums.length <= 10<sup>5</sup>`
    
* `nums[i]` is either `0` or `1`.
    

## <mark>Real-World Example</mark>

Think of this like your **Wi-Fi signal strength**.

* `1` means your Wi-Fi is connected.
    
* `0` means it’s disconnected.  
    Now, the question is: **What’s the longest streak of stable Wi-Fi connection?**  
    That’s what this problem is asking!
    

**(Hinglish:** Jaise tum Wi-Fi use kar rahe ho, kabhi connect ho raha hai (1), kabhi disconnect (0). Tumhe bas yeh dekhna hai ki ek saath kitni der tak Wi-Fi connected raha.)

## 1️⃣ Brute Force Approach

### 🔹 Idea:

* Start at each index and count how many consecutive `1`s we can get.
    
* Track the maximum streak.
    

```java
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 1) count++;
                else break;
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}
```

### **<mark>Time Complexity:</mark>** O(N²)

### **<mark>Space Complexity:</mark>** O(1)

## 2️⃣ Optimal Approach

### 🔹 Idea:

* Use a simple counter `count` to track current streak of 1’s.
    
* Reset `count = 0` whenever we see a `0`.
    
* Maintain a `maxCount` for the longest streak so far.
    

```java
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, maxCount = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
                maxCount = Math.max(maxCount, count);
            } else {
                count = 0;
            }
        }
        return maxCount;
    }
}
```

### **<mark>Time Complexity: </mark>** O(N)

### **<mark>Space Complexity:</mark>** O(1)

---

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

![](https://cdn.hashnode.com/res/hashnode/image/upload/v1757249622168/78d3edc4-b989-435f-9c34-c621a4109b5d.jpeg align="center")

%[https://youtu.be/37E9ckMDdTk] 

%[https://youtu.be/bYWLJb3vCWY]
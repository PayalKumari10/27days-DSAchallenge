---
title: "📅Day-9 Striver’s SDE Sheet |  Arrays Part 4 | Two Sum ,  4Sum."
seoTitle: "Two Sum & 4Sum: Striver’s SDE Sheet Day 9"
seoDescription: "Join my 27-day DSA journey with Striver's SDE Sheet! Day 10: Learn Two Sum and 4Sum strategies for coding interviews"
datePublished: Wed Aug 06 2025 12:26:52 GMT+0000 (Coordinated Universal Time)
cuid: cmdzy06up000w02i58pot846y
slug: day-9-strivers-sde-sheet-arrays-part-4-two-sum-4sum
cover: https://cdn.hashnode.com/res/hashnode/image/upload/v1754478928949/b13a250a-5c54-4d9e-9064-602ca3dfc2a3.png
ogImage: https://cdn.hashnode.com/res/hashnode/image/upload/v1754483185405/1ff73ae6-2ab4-4753-9ceb-1bf4ce214677.png
tags: code, java, technology, coding, hashnode, dsa, coding-challenge, codenewbies, coding-journey, dsainjava, striver-dsa-sheet, striversa2zdsa, striversdesheet, payalkumari11, dsawithpayal

---

> ***Note : <mark>Started my 27-day DSA journey with Striver’s SDE Sheet!</mark>  
> <mark>I will be journaling every day</mark> <mark>— recording what I learn, reflecting on it, and sharing it with my network to help fellow learners</mark> <mark>and aspiring developers..</mark> <mark>Learning through videos, resources, and the internet — simplifying logic in my own way with real-world connections. Sharing 2 questions daily: brute-force to optimal, clean Java code, time &amp; space complexity, and key patterns.</mark>***

This blog series is for **anyone preparing for coding interviews** — whether you’re a beginner or a revision warrior. Let’s grow together! 🚀

## Namaste Developers! 🙏

**Welcome to Day 10 of my 27-day DSA journey using Striver’s SDE Sheet!**

### 1️⃣**Two Sum**

🔸 Problem Statement:

Given an array of integers `nums` and an integer `target`, return *indices of the two numbers such that they add up to* `target`.

You may assume that each input would have ***exactly* one solution**, and you may not use the *same* element twice.

You can return the answer in any order.

**Example 1:**

```plaintext
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
```

**Example 2:**

```plaintext
Input: nums = [3,2,4], target = 6
Output: [1,2]
```

**Example 3:**

```plaintext
Input: nums = [3,3], target = 6
Output: [0,1]
```

**Constraints:**

* `2 <= nums.length <= 10<sup>4</sup>`
    
* `-10<sup>9</sup> <= nums[i] <= 10<sup>9</sup>`
    
* `-10<sup>9</sup> <= target <= 10<sup>9</sup>`
    
* **Only one valid answer exists.**
    

**Follow-up:** Can you come up with an algorithm that is less than`O(n<sup>2</sup>)` time complexity?

### 💠Real-Life Example

Imagine you’re in a shopping mall with a list that says:

**"I want two items whose total cost is exactly 1000 rupees."**

You start scanning all the items on the shelf. Your goal is to find **two items** whose prices add up **exactly to 1000**.

(Hinglish : Socho ek shopping mall me tumhare paas ek list hai:

> *"Mujhe 1000 rupay ke total ke 2 saman chahiye"*

You are scanning all the items on a shelf. Tumhe 2 items dhoondhne hain **jinka total exactly 1000 ho**. )

That’s exactly what this problem is about!

## 💠 Brute Force Approach – Naive Thinking (Nested Loops)

### 📍Logic:

* Traverse the array with **two loops**
    
* For each pair `(i, j)` where `i ≠ j`, check if `nums[i] + nums[j] == target`
    
* Return the indices if found
    

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0]; 
    }
}
```

### 📍Time & Space Complexity:

* **Time**: `O(n2)`
    
* **Space**: `O(1)`
    

> ❌ Brute force works but not efficient for large inputs. So let’s optimize it!

### 💠Optimal Approach – Using HashMap

### 📍Logic:

* Use a **HashMap** to store each number and its index
    
* For each `num`, calculate its \*\*complement = target - num\`
    
* If the complement already exists in the map, return their indices
    
* Otherwise, store `num` with its index in the map
    

```java
import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            
            map.put(nums[i], i);
        }

        return new int[0];
    }
}
```

## 📍Dry Run for Better Understanding

### For: nums = \[2, 7, 11, 15\], target = 9

* i=0 → `complement = 9 - 2 = 7` → map: {2:0}
    
* i=1 → `complement = 9 - 7 = 2` → 2 is in map → return \[0,1\]
    

### 📍Time & Space Complexity:

* **Time**: `O(n)`
    
* **Space**: `O(n)`
    

> ✅ Much faster and scalable than brute-force. Perfect for interviews!

## 📍Key Takeaways (in Hinglish)

* **“Two Sum”** is a foundational problem in DSA and interviews
    
* Pehle brute force samjho, fir hashmap se optimize karo
    
* HashMap gives you **O(1) lookup**, jo brute force se bahut fast hai
    
* Dry run zarur karo to avoid off-by-one ya logic mistakes
    
* Interviewers love this question, toh iska logic crystal clear hona chahiye!
    

## 💠Revision Tip:

> Before solving harder problems like **3Sum**, **4Sum**, or **Subarray Sum Equals K**, make sure you’re rock solid on **Two Sum**. Yeh ek base building block hai DSA ke liye.

---

### 2️⃣ **4Sum**

🔸 Problem Statement:

Given an array `nums` of `n` integers, return *an array of all the* ***unique*** *quadruplets* `[nums[a], nums[b], nums[c], nums[d]]` such that:

* `0 <= a, b, c, d < n`
    
* `a`, `b`, `c`, and `d` are **distinct**.
    
* `nums[a] + nums[b] + nums[c] + nums[d] == target`
    

You may return the answer in **any order**.

**Example 1:**

```plaintext
Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
```

**Example 2:**

```plaintext
Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]
```

**Constraints:**

* `1 <= nums.length <= 200`
    
* `-10<sup>9</sup> <= nums[i] <= 10<sup>9</sup>`
    
* `-10<sup>9</sup> <= target <= 10<sup>9</sup>`
    

### 💠Real-Life Example

Suppose you have 6 people, and they each have some amounts: 1, 0, -1, 0, -2, 2.  
You need to choose **4 people** such that their **total sum is 0** (target = 0).

So basically, you have to check for all combinations of 4 people, **but without any repetitions.**

(Hinglish: **Suppose** aapke paas 6 log hain aur unke paas kuch amounts hain: `1, 0, -1, 0, -2, 2`  
Aapko 4 log choose karne hain jinki total value **0 honi chahiye** (target = 0)  
Toh basically aapko combinations check karne hain, lekin bina repeat ke ).

### 💠Brute Force Approach

```java
import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        
        // Sort the array to help avoid duplicates
        Arrays.sort(nums);

        for (int i = 0; i < n - 3; i++) {
            // Skip duplicate elements for i
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < n - 2; j++) {
                // Skip duplicate elements for j
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                for (int k = j + 1; k < n - 1; k++) {
                    // Skip duplicate elements for k
                    if (k > j + 1 && nums[k] == nums[k - 1]) continue;

                    for (int l = k + 1; l < n; l++) {
                        // Skip duplicate elements for l
                        if (l > k + 1 && nums[l] == nums[l - 1]) continue;

                        long sum = (long) nums[i] + nums[j] + nums[k] + nums[l]; // prevent overflow
                        if (sum == target) {
                            result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        }
                    }
                }
            }
        }
        return result;
    }
}
```

### 💠Problem:

* Very slow for big inputs
    
* Duplicate combinations bhi aayenge
    

### 📍Time & Space Complexity:

### 💠 Time Complexity:

* `O(n^4)`
    
* Kyunki 4 nested loops hai
    

### 💠 Space Complexity:

* `O(1)` (excluding result storage)
    
    ## 💠Optimal Approach: Two Pointer + Sorting
    
    ### 📍 Idea:
    
    1. **Sort** the array
        
    2. First 2 loops fix first 2 numbers → `i` and `j`
        
    3. For rest of the two → use **Two Pointer** technique (low & high)
        
    
    ### ✅ Why Two Pointers?
    
    Once sorted, you can shrink the search space by checking the sum from both ends of the array — saving lots of time.
    

```java
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // avoid duplicate i
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue; // avoid duplicate j

                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        while (left < right && nums[left] == nums[left + 1]) left++; // skip dup
                        while (left < right && nums[right] == nums[right - 1]) right--; // skip dup

                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return result;
    }
}
```

### 📍 Time Complexity:

* Outer loop (i): O(n)
    
* Inner loop (j): O(n)
    
* Two pointers: O(n)  
    \=&gt; So overall: **O(n³)**
    

### 📍 Space Complexity:

* `O(1)` (excluding result)
    

## 💠Key Points (Hinglish):

✅ **Sort karna** first step hai — helps in avoiding duplicates and makes two pointer possible

✅ Duplicate values ko **skip karna** bohot important hai

✅ Two pointer se hum **bina sab combinations** banaye directly solution tak pahuchte hain

✅ Use of **long** to avoid integer overflow — smart move

✅ Result list mein sirf **unique** values store karni hain

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

![](https://cdn.hashnode.com/res/hashnode/image/upload/v1754482797377/fded5ee6-a8e8-4d55-8dcb-c74b3d7f770c.jpeg align="center")

%[https://youtu.be/UXDSeD9mN-k] 

%[https://youtu.be/eD95WRfh81c]
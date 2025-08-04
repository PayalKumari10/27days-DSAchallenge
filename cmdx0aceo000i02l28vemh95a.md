---
title: "📅Day-8 Striver’s SDE Sheet |  Arrays Part 3 | Majority Element (>n/2 times) , Majority Element (n/3 times)"
seoTitle: "Striver's SDE Day 8: Arrays & Majority Elements"
seoDescription: "Learn about the Majority Element problem and Boyer-Moore Voting Algorithm in Day 8 of Striver's SDE Sheet 27-day DSA series"
datePublished: Mon Aug 04 2025 11:07:26 GMT+0000 (Coordinated Universal Time)
cuid: cmdx0aceo000i02l28vemh95a
slug: day-8-strivers-sde-sheet-arrays-part-3-majority-element-n2-times-majority-element-n3-times
cover: https://cdn.hashnode.com/res/hashnode/image/upload/v1754302129800/ace1bfe0-8074-4600-aae5-0a46f96206a4.png
ogImage: https://cdn.hashnode.com/res/hashnode/image/upload/v1754305616545/8e85b11c-1f39-45ed-a732-26af9748f7d0.png
tags: code, blogging, java, coding, hashnode, dsa, coding-challenge, technical-writing-1, coding-journey, dsainjava, striver-dsa-sheet, striversa2zdsa, striversdesheet, payalkumari11, dsawithpayal

---

> ***Note : <mark>Started my 27-day DSA journey with Striver’s SDE Sheet!</mark>  
> <mark>I will be journaling every day</mark> <mark>— recording what I learn, reflecting on it, and sharing it with my network to help fellow learners</mark> <mark>and aspiring developers..</mark> <mark>Learning through videos, resources, and the internet — simplifying logic in my own way with real-world connections. Sharing 2 questions daily: brute-force to optimal, clean Java code, time &amp; space complexity, and key patterns.</mark>***

This blog series is for **anyone preparing for coding interviews** — whether you’re a beginner or a revision warrior. Let’s grow together! 🚀

## Namaste Developers! 🙏

### **Welcome to Day 8 of my 27-day DSA journey using Striver’s SDE Sheet!**

### 1️⃣**Majority Element**

🔸 Problem Statement:

Given an array `nums` of size `n`, return *the majority element*.

The majority element is the element that appears more than `⌊n / 2⌋` times. You may assume that the majority element always exists in the array.

```plaintext
Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
```

**Constraints:**

* `n == nums.length`
    
* `1 <= n <= 5 * 10<sup>4</sup>`
    
* `-10<sup>9</sup> <= nums[i] <= 10<sup>9</sup>`
    

**Follow-up:**Could you solve the problem in linear time and in`O(1)`space?

### 💠Real-Life Example

Imagine a classroom with 10 students, and they were asked to vote for their favorite programming language. Python received 7 out of 10 votes, which is more than \[10/2\] = 5. So, Python is the majority element!

(Hinglish: Imagine ek classroom hai jisme 10 students hain, aur unse vote karwaya gaya for favorite programming language:

```plaintext
Votes = [Python, C++, Python, Java, Python, Python, C++, Python, Python, Python]
```

Yahan pe **Python** ko 10 mein se **7 votes** mile, which is more than `⌊10/2⌋ = 5`. So, Python is the **majority element**!

### Example 1:

```plaintext
Input: nums = [3,2,3] Output: 3
```

Yahan `3` appears 2 times, and array ka size hai 3 → majority = ⌊3/2⌋ = 1.  
So `3` is majority ✅

### Example 2:

```plaintext
Input: nums = [2,2,1,1,1,2,2]
Output: 2
```

Yahan `2` appears 4 times, `1` appears 3 times → Majority element is `2` ✅

1. ### Brute Force Approach
    

Let’s count occurrences of each element and check if koi element hai jiska count &gt; n/2.

```java
class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (nums[j] == nums[i]) {
                    count++;
                }
            }
            if (count > n / 2) {
                return nums[i];
            }
        }
        return -1; 
    }
}
```

### Time & Space Complexity

* **Time:** O(n²) - (nested loops)
    
* **Space:** O(1) – no extra space used
    

> 🔴 **Not optimal for large datasets**

2. ### Optimal Approach – Boyer-Moore Voting Algorithm
    

📍 **Intuition:**

* Assume one element as a candidate.
    
* Keep a count for it.
    
* Whenever you find the same element → increase the count (count++)
    
* Whenever you find a different element → decrease the count (count--)
    

\=&gt; If an element is the majority, it will still survive in the end even after the count decreases!

(Hinglish : 📍 **Intuition:**

* Ek `candidate` assume kar lo
    
* Uska count rakho
    
* Jab bhi same element mile → count++
    
* Jab different mile → count--
    
* Why It Works:
    
    * Agar ek element majority hai, toh wo count decrease hone ke baad bhi overall survive karega!)
        
    
    ```java
    class Solution {
        public int majorityElement(int[] nums) {
            int count = 0;
            int candidate = 0;
    
            for (int num : nums) {
                if (count == 0) {
                    candidate = num;
                }
    
                count += (num == candidate) ? 1 : -1;
            }
    
            return candidate;
        }
    }
    ```
    

### 💠Time & Space Complexity:

* **Time:** O(n) ✅
    
* **Space:** O(1) ✅
    

> Yeh algorithm interview ka **favorite** hai, especially in **Amazon, Google, Microsoft** type of companies

## Dry Run (Example):

Let’s dry run: `nums = [2,2,1,1,1,2,2]`

| Step | num | count | candidate |
| --- | --- | --- | --- |
| 1 | 2 | 1 | 2 |
| 2 | 2 | 2 | 2 |
| 3 | 1 | 1 | 2 |
| 4 | 1 | 0 | 2 |
| 5 | 1 | 1 | 1 |
| 6 | 2 | 0 | 1 |
| 7 | 2 | 1 | 2 |

Finally → Majority element = `2`

## 💠Important Points:

* ✅ Majority element **always exists** in input (interview mein poocha jaa sakta hai)
    
* ✅ Use **Boyer-Moore Voting Algorithm** for best performance
    
* ✅ Brute force is slow, par use karke aapka base strong hota hai
    
* ✅ Real-life use case: Polls, Elections, or Product feedbacks where most customers vote on one thing
    

## 💠Hinglish Tips for Revision:

* Agar koi **element baar-baar repeat ho raha hai**, wo **majority ban sakta hai**
    
* **Boyer-Moore** algorithm: jab count 0 ho, **naya candidate pakdo**
    
* **Brute force** mein nested loop se har element ka count check karo
    
* **Optimal approach** mein single pass se kaam ho jaata hai, bina extra space ke
    

---

### 2️⃣**Majority Element II**

Given an integer array of size `n`, find all elements that appear more than `⌊ n/3 ⌋` times.

  
**Example 1:**

```plaintext
Input: nums = [3,2,3]
Output: [3]
```

**Example 2:**

```plaintext
Input: nums = [1]
Output: [1]
```

**Example 3:**

```plaintext
Input: nums = [1,2]
Output: [1,2]
```

**Constraints:**

* `1 <= nums.length <= 5 * 10<sup>4</sup>`
    
* `-10<sup>9</sup> <= nums[i] <= 10<sup>9</sup>`
    

**Follow up:** Could you solve the problem in linear time and in `O(1)` space?

### 💠Real Life Example:

Think of a group of friends choosing their fav snack 🍿

```plaintext
Votes = [Chips, Coke, Chips, Burger, Coke, Chips, Coke]
```

* n = 7 → n/3 = 2.33 → floor(n/3) = 2
    
* So we find all snacks voted more than **2 times**
    

Here:

* Chips = 3 times
    
* Coke = 3 times  
    ✅ Answer = `[Chips, Coke]`
    

1. ## Brute Force Approach
    

* Count occurrences of each element (using Map or 2 loops)
    
* Then check: `count > ⌊n/3⌋`
    

```java
import java.util.*;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int count = 0;

            // Count occurrences of nums[i]
            for (int j = 0; j < n; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }

            // If count > n/3 and not already in result, add it
            if (count > n / 3 && !result.contains(nums[i])) {
                result.add(nums[i]);
            }
        }

        return result;
    }
}
```

### 💠Time & Space Complexity:

* **Time Complexity**: O(n²) — Two nested loops.
    
* **Space Complexity**: O(1) (excluding the result list).
    

2. ### Optimal Approach – Extended Boyer-Moore Voting Algorithm
    

This time we want **elements &gt; n/3**, not just one. So max **2 elements** can be possible.

### 📍Intuition:

* Let’s maintain:
    
    * Two candidates (`candidate1`, `candidate2`)
        
    * Two counts (`count1`, `count2`)
        
* Traverse the array:
    
    * If num matches candidate1 → count1++
        
    * Else if matches candidate2 → count2++
        
    * Else if count1 == 0 → assign candidate1 = num, count1 = 1
        
    * Else if count2 == 0 → assign candidate2 = num, count2 = 1
        
    * Else → count1-- and count2--
        

### ✅ Final Step:

* Do a second pass to verify if counts of candidate1 or candidate2 are actually &gt; n/3
    

```java
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0, count2 = 0;
        int candidate1 = 0, candidate2 = 1; 

        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        
        List<Integer> result = new ArrayList<>();
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1) count1++;
            else if (num == candidate2) count2++;
        }

        int n = nums.length;
        if (count1 > n / 3) result.add(candidate1);
        if (count2 > n / 3) result.add(candidate2);

        return result;
    }
}
```

## 💠Dry Run Example: `nums = [1,1,1,3,3,2,2,2]`

* 1 → 3 times
    
* 2 → 3 times
    
* 3 → 2 times
    
* n = 8 → n/3 = 2.66 → floor = 2
    

✅ Output = `[1,2]`

## 💠Time & Space Complexity:

* **Time:** O(n) ✅
    
* **Space:** O(1) ✅ (No extra hash maps or arrays)
    

> 💯 This is the best solution you can give in an interview.

(Hinglish:

* Do `2 candidate maintain karo`
    
* Jab **count 0 ho jaaye**, naya candidate pakdo
    
* Last mein ek baar aur verify karo
    
* Yeh wala logic coding rounds + interviews dono mein aata hai)
    

## 💠Final points:

This was a **perfect extension** of the earlier problem.  
Understanding this teaches you pattern-based thinking, algo optimization, and edge case handling.

**Key learning:** Optimal doesn't always mean complex, bas approach smart honi chahiye!

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

![](https://cdn.hashnode.com/res/hashnode/image/upload/v1754305317089/31221728-9899-4fd7-878d-1c2884220e94.jpeg align="center")

%[https://youtu.be/nP_ns3uSh80] 

%[https://youtu.be/vwZj1K0e9U8]
---
title: "📅Day-12 Striver’s SDE Sheet | Arrays Part 4 | Count number of subarrays with given xor K, Longest Substring without repeat."
seoTitle: "Day 12: XOR Subarrays & Longest Substring"
seoDescription: "Explore the optimal ways to count subarrays with XOR k and find the longest substring without repeats. Join a 27-day DSA journey!"
datePublished: Fri Aug 08 2025 17:04:53 GMT+0000 (Coordinated Universal Time)
cuid: cme32tfac000402jwa6iw7thq
slug: day-12-strivers-sde-sheet-arrays-part-4-count-number-of-subarrays-with-given-xor-k-longest-substring-without-repeat
cover: https://cdn.hashnode.com/res/hashnode/image/upload/v1754665202224/e6ba20b4-dc44-4466-8a53-3804f19457b1.png
ogImage: https://cdn.hashnode.com/res/hashnode/image/upload/v1754672462667/2905867e-084e-4b05-8b0b-5555b69838b8.png
tags: code, java, technology, coding, hashnode, dsa, coding-challenge, coding-journey, dsainjava, dsa-series, striver-dsa-sheet, striversa2zdsa, striversdesheet, payalkumari11, dsawithpayal

---

> ***Note : <mark>Started my 27-day DSA journey with Striver’s SDE Sheet!</mark>  
> <mark>I will be journaling every day</mark> <mark>— recording what I learn, reflecting on it, and sharing it with my network to help fellow learners</mark> <mark>and aspiring developers..</mark> <mark>Learning through videos, resources, and the internet — simplifying logic in my own way with real-world connections. Sharing 2 questions daily: brute-force to optimal, clean Java code, time &amp; space complexity, and key patterns.</mark>***

This blog series is for **anyone preparing for coding interviews** — whether you’re a beginner or a revision warrior. Let’s grow together! 🚀

## Namaste Developers! 🙏

**Welcome to Day 12 of my 27-day DSA journey using Striver’s SDE Sheet!**

### 1️⃣ **Count number of subarrays with given xor K**

### 🔸 Problem Statement:

Given an array of integers A and an integer B. Find the total number of subarrays having bitwise XOR of all elements equal to k.

```plaintext

Example 1:
Input Format: A = [4, 2, 2, 6, 4] , k = 6
Result: 4
Explanation: The subarrays having XOR of their elements as 6 are  [4, 2], [4, 2, 2, 6, 4], [2, 2, 6], [6]

Example 2:
Input Format: A = [5, 6, 7, 8, 9], k = 5
Result: 2
Explanation: The subarrays having XOR of their elements as 5 are [5] and [5, 6, 7, 8, 9]
```

###   
💠Real World Example

> XOR ka matlab hota hai **exclusive OR** — jisme bits alag ho tabhi result 1 hota hai.

| Input A | Input B | Output |
| --- | --- | --- |
| 0 | 0 | 0 |
| 0 | 1 | 1 |
| 1 | 0 | 1 |
| 1 | 1 | 0 |

* Think of XOR like this:-
    
    ✅ Suppose you and your friend both have different ideas, toh combined result exciting hoga (1).
    
    ✅ But if you both think the same (0,0 or 1,1), toh result boring hoga (0).
    

(Hinglish : **XOR ko aise socho:**  
Agar tum aur tumhara friend dono ke ideas alag-alag hain, toh jo result aayega wo exciting hoga (1).  
Lekin agar dono same soch rahe ho (jaise 0-0 ya 1-1), toh result boring hoga (0).)

## 💠Brute Force Approach – TLE Risk but Concept Clear

### 📍Idea:

* Check every subarray.
    
* Calculate XOR of all elements.
    
* Count if XOR == k.
    

```java
class Solution {
    public long subarrayXor(int arr[], int k) {
    int count = 0;
    for (int i = 0; i < arr.length; i++) {
        int xor = 0;
        for (int j = i; j < arr.length; j++) {
            xor ^= arr[j];
            if (xor == k) count++;
        }
    }
    return count;
  }

}
```

### 📍Time Complexity (TC):

* O(n²) — because of nested loop
    

### 📍 Space Complexity (SC):

* O(1) — no extra space used
    

### ⚠️ Note:

> **Brute force TLE de sakta hai jab input bada ho**, like `10^5` size array!

### 💠Optimal Approach – HashMap with XOR Concept

### 📍Intuition:

Let’s say we calculate prefix XOR till index `i`:

* Let `xor` = prefix XOR till index `i`
    
* Then, we check:  
    If `(xor ^ k)` already occurred before,  
    then there exists a subarray whose XOR = k.
    

#### XOR property used:

```java
If A ^ B = C, then A = B ^ C and B = A ^ C
```

So, we use a **HashMap** to store frequency of prefix XORs.

```java
class Solution {
    public long subarrayXor(int arr[], int k) {
     Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int xor = 0;

        for (int i = 0; i < arr.length; i++) {
            xor ^= arr[i];

            if (xor == k) count++;

            int required = xor ^ k;
            count += map.getOrDefault(required, 0);

            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }

        return count;
      }

    }
```

✅ Step-by-step Dry Run:

| Index | Num | xor (prefix XOR) | xor ^ k = needed | Map Lookup | Add to Count | Updated Map | Total Count |
| --- | --- | --- | --- | --- | --- | --- | --- |
| 0 | 4 | 0 ^ 4 = 4 | 4 ^ 6 = 2 | ❌ (not found) | ❌ | {4: 1} | 0 |
| 1 | 2 | 4 ^ 2 = 6 | 6 ^ 6 = 0 | ❌ | ✅ xor == k | {4:1, 6:1} | 1 |
| 2 | 2 | 6 ^ 2 = 4 | 4 ^ 6 = 2 | ❌ | ❌ | {4:2, 6:1} | 1 |
| 3 | 6 | 4 ^ 6 = 2 | 2 ^ 6 = 4 | ✅ found 4 → map\[4\]=2 | ✅ +2 subarrays | {4:2, 6:1, 2:1} | 3 |
| 4 | 4 | 2 ^ 4 = 6 | 6 ^ 6 = 0 | ❌ | ✅ xor == k | {4:2, 6:2, 2:1} | 4 |

✅ Final Count = 4

### 📍Time Complexity:

* O(n) — one traversal
    

### 📍Space Complexity:

* O(n) — for HashMap
    

## 💠Real World Application

* **Network Security** – XOR used in encryption (e.g. stream ciphers)
    
* **Bit Manipulation Problems** – Used in leetcode, CP (competitive programming)
    
* **Debugging** – Finding **unique elements**, **prefix sums with twist**
    

(Tips Hinglish :

* “Prefix XOR” ka idea samajhna zaroori hai — har index tak ka XOR calculate karna.
    
* “xor ^ k” = required value jo map mein search karni hai.
    
* HashMap frequency store karne ke kaam aata hai — bina dikhaye kaam karta hai background mein)
    

---

### 2️⃣ **Longest Substring Without Repeating Characters**

### 🔸 Problem Statement:

Given a string `s`, find the length of the **longest** **substring** without duplicate characters.

**Example 1:**

```plaintext
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
```

**Example 2:**

```plaintext
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
```

**Example 3:**

```plaintext
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
```

**Constraints:**

* `0 <= s.length <= 5 * 10<sup>4</sup>`
    
* `s` consists of English letters, digits, symbols and spaces.
    

## 📍Real World Example

Imagine you’re playing a memory game :

* You have to **keep selecting different cards** (characters),
    
* The moment you pick a **duplicate card**, your current streak ends.
    
* You start a **new streak** from the next card.
    

> Aisa hi kuch hum kar rahe hain is problem mein!

### 💠Brute Force Approach

### 📍Idea:

* Generate all substrings.
    
* For each substring, check if all characters are unique.
    

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
    int maxLength = 0;
    for (int i = 0; i < s.length(); i++) {
        Set<Character> set = new HashSet<>();
        for (int j = i; j < s.length(); j++) {
            if (set.contains(s.charAt(j))) break;
            set.add(s.charAt(j));
            maxLength = Math.max(maxLength, j - i + 1);
        }
    }
    return maxLength;
   }

 }
```

### **📍Time Complexity:** O(n²)

### **📍Space Complexity:** O(n)

### 💠Optimal Approach – Sliding Window + HashSet

### 📍Ideas:

* Use two pointers (left and right) to create a window.
    
* Move `right` pointer to include new characters.
    
* If duplicate found, move `left` pointer to remove until no duplicates remain.
    

> **Set** use karenge to track which characters are inside window.

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0, maxLen = 0;

        while (right < s.length()) {
            char ch = s.charAt(right);

            if (!set.contains(ch)) {
                set.add(ch);
                maxLen = Math.max(maxLen, right - left + 1);
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }

        return maxLen;
    }
}
```

### **📍Time Complexity:** O(n)

### **📍Space Complexity:** O(n)

### 💠Dry Run – s = "abcabcbb"

| Step | Left | Right | Char | Set Content | maxLen |
| --- | --- | --- | --- | --- | --- |
| 1 | 0 | 0 | a | {a} | 1 |
| 2 | 0 | 1 | b | {a, b} | 2 |
| 3 | 0 | 2 | c | {a, b, c} | 3 ✅ |
| 4 | 0 | 3 | a | Duplicate → move `left` |  |
| 5 | 1 | 3 | a | {b, c, a} | 3 |
| ... | Keep going |  |  |  |  |
| Final |  |  |  |  |  |
| ✅ Answer: maxLen = 3 for substring "abc" |  |  |  |  |  |

(Hinglish Tips

* `Set` ko samjho: it stores only **unique elements**. Duplicate mila toh remove karo `left` se.
    
* `Sliding window` ka matlab hota hai ek range jise hum dynamically adjust karte hain.
    
* Don’t memorize — **understand the logic**. Try dry runs manually.)
    

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

![](https://cdn.hashnode.com/res/hashnode/image/upload/v1754672294620/ca37d10b-668f-4158-8d47-e21e35067f11.jpeg align="center")

%[https://youtu.be/eZr-6p0B7ME] 

%[https://youtu.be/qtVh-XEpsJo]
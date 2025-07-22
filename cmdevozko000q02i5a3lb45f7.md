---
title: "📅Day-4 Striver’s SDE Sheet | Arrays Part 2 | Q1 & Q2: Rotate Matrix, Merge Overlapping Subintervals"
seoTitle: "Rotate Matrix & Merge Intervals Guide"
seoDescription: "Explore Day 4 of my 27-day DSA journey with Striver’s SDE Sheet: Rotate Matrix and Merge Overlapping Subintervals. Improve coding interview skills!"
datePublished: Tue Jul 22 2025 18:39:00 GMT+0000 (Coordinated Universal Time)
cuid: cmdevozko000q02i5a3lb45f7
slug: day-4-strivers-sde-sheet-arrays-part-2-q1-and-q2-rotate-matrix-merge-overlapping-subintervals
cover: https://cdn.hashnode.com/res/hashnode/image/upload/v1753206231267/a2f482ef-0c91-474b-86c6-ba037e963a8a.png
ogImage: https://cdn.hashnode.com/res/hashnode/image/upload/v1753209506852/92c77d95-2d57-4572-b490-bc64f3374eae.png
tags: java, technology, coding, hashnode, dsa, techblog, coding-challenge, technical-writing-1, coding-journey, dsainjava, striversa2zdsa, techblogs, striversdesheet, payalkumari11, dsawithpayal

---

> ***Note : <mark>Started my 27-day DSA journey with Striver’s SDE Sheet!</mark>  
> <mark>I will be journaling every day</mark> <mark>— recording what I learn, reflecting on it, and sharing it with my network to help fellow learners</mark> <mark>and aspiring developers..</mark> <mark>Learning through videos, resources, and the internet — simplifying logic in my own way with real-world connections. Sharing 2 questions daily: brute-force to optimal, clean Java code, time &amp; space complexity, and key patterns.</mark>***

This blog series is for **anyone preparing for coding interviews** — whether you’re a beginner or a revision warrior. Let’s grow together! 🚀

## Namaste Developers! 🙏

### **Welcome to Day 4 of my 27-day DSA journey using Striver’s SDE Sheet!**

## 1️⃣ **Rotate Matrix**

🔸 Problem Statement:

You are given an `n x n` 2D `matrix` representing an image, rotate the image by **90** degrees (clockwise).

You have to rotate the image [**in-place**](https://en.wikipedia.org/wiki/In-place_algorithm), which means you have to modify the input 2D matrix directly. **DO NOT** allocate another 2D matrix and do the rotation.

```plaintext
Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]

Example 2:
Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
```

**Constraints:**

* `n == matrix.length == matrix[i].length`
    
* `1 <= n <= 20`
    
* `-1000 <= matrix[i][j] <= 1000`
    

### 💠Trick to Remember: Transpose + Reverse = Rotate 90° Clockwise

📍Real-World Problem (The Pizza Trick 🍕)

Imagine a **pizza placed on a plate** 📸  
Each topping on the pizza is a value in the matrix.

Now, if you want to **rotate the pizza 90° clockwise**, you don’t remove the toppings and put them on a new plate. Instead, you just:

1. **Spin the plate** (like spinning clockwise).
    
2. The toppings automatically appear to be rotated in place!
    

### 📍 How to Relate it to Matrix:

1. **Transpose the matrix** = Tilt your head diagonally  
    (Swap rows and columns like looking from corner to corner)
    
2. **Reverse every row** = Now flip the topping positions in each row  
    (Like dragging each slice from left to right after tilting)
    

### ✅Shortcut Trick: "TR" = Transpose + Reverse

📍 Just remember:

> **“TR karo, aur Rotate ho gaya!”**  
> (T → Transpose, R → Reverse Rows)

That’s it! Bas yahi TR mantra yaad rakhna hai.

### 💠Brute Force Approach

### 📍Idea:

* Create a **new matrix** to store the rotated version.
    
* For each element in the original matrix, place it in the correct rotated position in the new matrix.
    

### 📍Code:

```java
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[j][n - 1 - i] = matrix[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = result[i][j];
            }
        }
    }
}
```

### ✅Time Complexity: `O(n^2)`

### ✅ Space Complexity: `O(n^2)` (extra space used)

→ **But this violates the “in-place” condition.**

## 💠Optimal Approach – In-Place Rotation

### 📍 Two-step process:

1. **Transpose the Matrix**
    
2. **Reverse each Row**
    

## ✅Step-by-Step Explanation:

### 1\. Transpose the Matrix:

Transpose ka matlab: `matrix[i][j]` ↔ `matrix[j][i]`

**Example:**  
Before Transpose:

```plaintext
[ [1, 2, 3],
  [4, 5, 6],
  [7, 8, 9] ]
```

After Transpose:

```plaintext
[ [1, 4, 7],
  [2, 5, 8],
  [3, 6, 9] ]
```

### 2\. Reverse Each Row:

Now reverse every row to get the 90° rotated matrix.

After reversing:

```plaintext
[ [7, 4, 1],
  [8, 5, 2],
  [9, 6, 3] ]
```

```java
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // Step 1: Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }
}
```

### ✅ **Time Complexity:** `O(n^2)`

  
→ Two nested loops for transpose and reversal.

### ✅ **Space Complexity:** `O(1)`

  
→ No extra space used — done in-place.

## 💠How to Calculate Time and Space Complexity?

📍 **Time Complexity:**  
Count the number of nested loops and operations per loop.  
Here, `O(n^2)` because we're visiting every element once in transpose and once in reverse.

📍 **Space Complexity:**  
Look for extra data structures.  
We didn’t use any extra matrix, so it’s `O(1)`.

### <mark>📍Tips :</mark>

* **“Transpose then Reverse = 90° Clockwise”**  
    *Yaad karo TR – Transpose then Reverse!*
    
* **“Matrix ko ulta seedha karke ghuma diya”**  
    Transpose se diagonally swap hota hai, fir row reverse se clockwise rotate.
    

---

## **2️⃣ Merge Overlapping Subintervals**

🔸 Problem Statement:

Given an array of `intervals` where `intervals[i] = [start<sub>i</sub>, end<sub>i</sub>]`, merge all overlapping intervals, and return *an array of the non-overlapping intervals that cover all the intervals in the input*.

```java
Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
```

**Constraints:**

* `1 <= intervals.length <= 10<sup>4</sup>`
    
* `intervals[i].length == 2`
    
* `0 <= start<sub>i</sub> <= end<sub>i</sub> <= 10<sup>4</sup>`
    

### <mark>📍Real-World Example:</mark>

Let’s say you have appointments scheduled as:

```plaintext
9:00–10:30 AM  
10:15–11:00 AM  
1:00–2:00 PM  
1:30–3:00 PM
```

There are overlaps:

* First two overlap → merge into `9:00–11:00`
    
* Next two overlap → merge into `1:00–3:00`
    

Resulting time blocks:

```plaintext
9:00–11:00  
1:00–3:00
```

**That's exactly what we do in this problem!**

## 📍Intuition:

Think of it as arranging your meetings in a calendar.  
You **sort the meetings by start time**, then **combine overlapping ones**.  
Simple and effective.

### 💠Brute Force Approach :

* Compare **every interval with every other interval** to check for overlap.
    
* Merge manually by checking all combinations.
    
* Keep track of visited or merged intervals using a boolean array or extra space.
    
* This approach is **not optimal** and is mainly useful to understand the problem before optimizing.
    

```java
import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        boolean[] merged = new boolean[n];
        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (merged[i]) continue;

            int start = intervals[i][0];
            int end = intervals[i][1];

            for (int j = i + 1; j < n; j++) {
                if (merged[j]) continue;

                // Check for overlap
                if (!(intervals[j][0] > end || intervals[j][1] < start)) {
                    // Merge intervals
                    start = Math.min(start, intervals[j][0]);
                    end = Math.max(end, intervals[j][1]);
                    merged[j] = true;
                }
            }

            merged[i] = true;
            result.add(new int[]{start, end});
        }

        return result.toArray(new int[result.size()][]);
    }
}
```

### ✅Time Complexity = O(n²)

For each interval, we compare it with every other

### ✅Space Complexity = O(n)

Extra space to store visited/merged status

## 💠Optimal Approach:

### 📍 Steps:

1. **Sort the intervals** by their starting point.
    
2. Initialize a result list with the **first interval**.
    
3. Traverse the remaining intervals:
    
    * If the current interval **overlaps** with the last interval in result, **merge** them.
        
    * Else, just **add it** to the result.
        

### 💠Code

```java
import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();

        for (int[] interval : intervals) {
            if (result.isEmpty() || result.get(result.size() - 1)[1] < interval[0]) {
                result.add(interval); // No overlap
            } else {
                // Overlap → merge
                result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], interval[1]);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
```

### ✅ Time Complexity:

* Sorting: `O(n log n)`
    
* Traversal: `O(n)`
    
* ✅ Total: `O(n log n)`
    

### ✅ Space Complexity:

* Using extra list: `O(n)` (for result)
    

## 📍Trick to Remember :

> **“Pehle sort karo, phir compare karke jod do”**  
> (First sort → then merge overlapping ones)

**Easy Visualization:**  
Imagine drawing each interval on a number line — merge them where they touch or overlap.

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

![](https://cdn.hashnode.com/res/hashnode/image/upload/v1753209285421/6e78a79b-8b5f-4df7-be19-582d4d8014e8.jpeg align="center")

%[https://youtu.be/Z0R2u6gd3GU] 

%[https://youtu.be/IexN60k62jo]
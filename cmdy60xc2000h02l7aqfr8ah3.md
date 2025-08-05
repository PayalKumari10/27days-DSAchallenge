---
title: "📅Day-9 Striver’s SDE Sheet |  Arrays Part 3 | Grid Unique Paths , Reverse Pairs ."
seoTitle: "Arrays Challenge: Grid Paths & Reverse Pairs"
seoDescription: "Join me on Day 9 of Striver’s SDE Sheet journey! Explore Grid Unique Paths and Reverse Pairs optimally. Perfect for coding interview prep!"
datePublished: Tue Aug 05 2025 06:35:51 GMT+0000 (Coordinated Universal Time)
cuid: cmdy60xc2000h02l7aqfr8ah3
slug: day-9-strivers-sde-sheet-arrays-part-3-grid-unique-paths-reverse-pairs
cover: https://cdn.hashnode.com/res/hashnode/image/upload/v1754370382864/4c13725e-ebc5-4478-b58c-ccc1c7a26a70.png
ogImage: https://cdn.hashnode.com/res/hashnode/image/upload/v1754375718555/c375f5f7-1818-4c46-b488-9e1cae297896.png
tags: code, java, technology, coding, hashnode, dsa, techblog, coding-challenge, technical-writing-1, coding-journey, dsainjava, striversa2zdsa, striversdesheet, payalkumari11, dsawithpayal

---

> ***Note : <mark>Started my 27-day DSA journey with Striver’s SDE Sheet!</mark>  
> <mark>I will be journaling every day</mark> <mark>— recording what I learn, reflecting on it, and sharing it with my network to help fellow learners</mark> <mark>and aspiring developers..</mark> <mark>Learning through videos, resources, and the internet — simplifying logic in my own way with real-world connections. Sharing 2 questions daily: brute-force to optimal, clean Java code, time &amp; space complexity, and key patterns.</mark>***

This blog series is for **anyone preparing for coding interviews** — whether you’re a beginner or a revision warrior. Let’s grow together! 🚀

## Namaste Developers! 🙏

### **Welcome to Day 9 of my 27-day DSA journey using Striver’s SDE Sheet!**

### 1️⃣ **Unique Paths**

🔸 Problem Statement:

There is a robot on an `m x n` grid. The robot is initially located at the **top-left corner** (i.e., `grid[0][0]`). The robot tries to move to the **bottom-right corner** (i.e., `grid[m - 1][n - 1]`). The robot can only move either down or right at any point in time.

Given the two integers `m` and `n`, return *the number of possible unique paths that the robot can take to reach the bottom-right corner*.

The test cases are generated so that the answer will be less than or equal to `2 * 10<sup>9</sup>`.

(Hinglish : **"Unique Paths"** – Ek robot ko top-left se bottom-right tak grid me chalna hai, but sirf **right** ya **down** move kar sakta hai. Aapko batana hai ki kitne unique ways hai uske paas destination tak pahuchne ke liye.

Let’s deep dive into it step-by-step! )

```plaintext
Example 1:

Input: m = 3, n = 7
Output: 28

Example 2:

Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
```

### 💠Real-Life Example

Socho ek **robot** ek **maze** ya **office floor** pe hai. Har block ek room hai. Robot sirf **right ya down** ja sakta hai. Tumhe uske liye count karna hai ki **kitne different tareekon se** wo last room tak pahuch sakta hai.

Bas wahi hai yeh question

### 💠 Brute Force Approach

### 📍Explanation:

* `dp[i][j]` represents number of ways to reach cell `(i, j)`.
    
* We initialize the first row and first column with `1` because there's only one way to reach those positions — all right or all down.
    
* Then, we build up the solution using the known sub-problems.
    

```java
class Solution {
    public int uniquePaths(int m, int n) {
        
        int[][] dp = new int[m][n];

        
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }
}
```

### 💠Time & Space Complexity:

* **Time**: `O(m * n)`
    
* **Space**: `O(m * n)`
    

## 💠 Optimal Approach:

### 📍 1D Array Optimized (Space Efficient)

```java
class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1); 

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }

        return dp[n - 1];
    }
}
```

### 💠Time & Space Complexity

* **Time:** O(m\*n)
    
* **Space:** O(n)
    

---

### **2️⃣ Reverse Pairs**

🔸 Problem Statement:

Given an integer array `nums`, return *the number of* ***reverse pairs*** *in the array*.

A **reverse pair** is a pair `(i, j)` where:

* `0 <= i < j < nums.length` and
    
* `nums[i] > 2 * nums[j]`.
    

```plaintext
Example 1:

Input: nums = [1,3,2,3,1]
Output: 2
Explanation: The reverse pairs are:
(1, 4) --> nums[1] = 3, nums[4] = 1, 3 > 2 * 1
(3, 4) --> nums[3] = 3, nums[4] = 1, 3 > 2 * 1
Example 2:

Input: nums = [2,4,3,5,1]
Output: 3
Explanation: The reverse pairs are:
(1, 4) --> nums[1] = 4, nums[4] = 1, 4 > 2 * 1
(2, 4) --> nums[2] = 3, nums[4] = 1, 3 > 2 * 1
(3, 4) --> nums[3] = 5, nums[4] = 1, 5 > 2 * 1
```

**Constraints:**

* `1 <= nums.length <= 5 * 10<sup>4</sup>`
    
* `-2<sup>31</sup> <= nums[i] <= 2<sup>31</sup> - 1`
    

### 💠Real-Life Example

Imagine you're analyzing **stock prices**.  
You want to find all the **"reverse" dips**, where an earlier stock price is **more than double** a later price.

This can help in detecting **massive drops or risky stocks**.  
Same logic is applied here in reverse pairs.

### 💠Brute Force Approach

### 📍Idea:

* Use 2 loops
    
* For every `i`, check all `j > i`
    
* If `nums[i] > 2 * nums[j]`, count it
    

```java
class Solution {
    public int reversePairs(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                if((long)nums[i] > 2 * (long)nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
```

⚠️ Use `(long)` to prevent integer overflow.

### Time Complexity (TC):

* `O(n^2)`
    
* Not suitable for large arrays (`n <= 5 * 10^4`)
    

### Space Complexity (SC):

* `O(1)`
    

> ❌ TLE aayega large inputs par, toh chalo karte hain isko optimize using Merge Sort!

### 💠Optimal Approach: Merge Sort Based Counting

### 📍Key Insight:

This problem is **similar to Inversion Count** problem.  
But here, the condition is **nums\[i\] &gt; 2 \* nums\[j\]**, not just `nums[i] > nums[j]`.

We can use a **modified merge sort** to:

* **Sort the array** (required for merge sort)
    
* While merging, **count such reverse pairs**
    

### 📍How it works?

1. Split the array recursively like Merge Sort
    
2. During merge:
    
    * Count how many elements from right half satisfy `nums[i] > 2 * nums[j]` for each i in left half
        
3. Merge the two halves
    

```java
class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int low, int high) {
        if (low >= high) return 0;
        int mid = (low + high) / 2;
        int count = mergeSort(nums, low, mid) + mergeSort(nums, mid + 1, high);
        
        // Count reverse pairs
        int j = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (j <= high && (long)nums[i] > 2 * (long)nums[j]) {
                j++;
            }
            count += (j - (mid + 1));
        }

        // Merge the sorted halves
        merge(nums, low, mid, high);
        return count;
    }

    private void merge(int[] nums, int low, int mid, int high) {
        List<Integer> temp = new ArrayList<>();
        int left = low, right = mid + 1;

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp.add(nums[left++]);
            } else {
                temp.add(nums[right++]);
            }
        }

        while (left <= mid) temp.add(nums[left++]);
        while (right <= high) temp.add(nums[right++]);

        for (int i = low; i <= high; i++) {
            nums[i] = temp.get(i - low);
        }
    }
}
```

### 💠Time Complexity (TC):

* Each merge takes O(n), and merge sort does log(n) levels
    
* So overall:  
    ✅ `O(n log n)`
    

### 💠 Space Complexity (SC):

* Extra space for temp array during merge:  
    ✅ `O(n)`
    

(Learning points Hinglish :

* Kabhi kabhi **sorting ke saath counting** bhi karna hota hai, like here!
    
* Try to recognize **Inversion Count patterns**
    
* Java mein **overflow se bacho**, use **long** during multiplications
    
* Brute force sirf logic samajhne ke liye use karo, but use optimized in production code)
    

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

![](https://cdn.hashnode.com/res/hashnode/image/upload/v1754375517508/12cc78d6-1aac-47ab-b775-b9eff0ebdd14.jpeg align="center")

%[https://youtu.be/t_f0nwwdg5o] 

%[https://youtu.be/0e4bZaP3MDI]
---
title: "📅Day-7 Striver’s SDE Sheet |  Arrays Part 3 | Search in a 2 D matrix , Pow(x, n)"
seoTitle: "Search 2D Matrix & Compute Powers"
seoDescription: "Explore Day 7 of Striver's 27-day SDE Sheet journey focusing on searching in a 2D matrix and implementing Pow(x, n) with optimal solutions"
datePublished: Fri Aug 01 2025 20:44:46 GMT+0000 (Coordinated Universal Time)
cuid: cmdtal8hb000302jva23khngd
slug: day-7-strivers-sde-sheet-arrays-part-3-search-in-a-2-d-matrix-powx-n
cover: https://cdn.hashnode.com/res/hashnode/image/upload/v1754076434894/769cbe45-ed2f-4d8c-9918-b996dc23101a.png
ogImage: https://cdn.hashnode.com/res/hashnode/image/upload/v1754080990885/a66d6509-3de0-4f1b-8801-7f12fa996015.png
tags: code, technology, coding, hashnode, dsa, coding-challenge, technical-writing-1, coding-journey, dsainjava, dsa-series, striversa2zdsa, striversdesheet, payalkumari11, dsawithpayal, striverssdesheet

---

> ***Note : <mark>Started my 27-day DSA journey with Striver’s SDE Sheet!</mark>  
> <mark>I will be journaling every day</mark> <mark>— recording what I learn, reflecting on it, and sharing it with my network to help fellow learners</mark> <mark>and aspiring developers..</mark> <mark>Learning through videos, resources, and the internet — simplifying logic in my own way with real-world connections. Sharing 2 questions daily: brute-force to optimal, clean Java code, time &amp; space complexity, and key patterns.</mark>***

This blog series is for **anyone preparing for coding interviews** — whether you’re a beginner or a revision warrior. Let’s grow together! 🚀

## Namaste Developers! 🙏

### **Welcome to Day 7 of my 27-day DSA journey using Striver’s SDE Sheet!**

### 1️⃣**Search in a sorted 2D matrix**

🔸 Problem Statement:

You are given an `m x n` integer matrix `matrix` with the following two properties:

* Each row is sorted in non-decreasing order.
    
* The first integer of each row is greater than the last integer of the previous row.
    

Given an integer `target`, return `true` *if* `target` *is in* `matrix` *or* `false` *otherwise*.

You must write a solution in `O(log(m * n))` time complexity.

```plaintext
Example 1:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true

Example 2:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false
```

**Constraints:**

* `m == matrix.length`
    
* `n == matrix[i].length`
    
* `1 <= m, n <= 100`
    
* `-10<sup>4</sup> <= matrix[i][j], target <= 10<sup>4</sup>`  
    

### 💠Real-World Example

Imagine a **library with shelves** (rows).  
Each shelf has **books sorted in increasing order** (like a row).  
Also, the **first book on the second shelf** is thicker than the **last book on the first shelf** 📚

So the entire library, though in 2D shelves, behaves like a **1D sorted list of books**.  
We need to find a specific book thickness — can we do it without checking each one?

Yes! We can use **Binary Search.**

(<mark>Hinglish </mark> : Another Example - Socho tumhare paas ek **register** hai jisme roll numbers likhe hain.

* Har page pe numbers **sorted** hain.
    
* Naye page ka **pehla number** pichle page ke **last number se bada** hai.
    

Ab agar kisi ka roll number dhundhna hai, toh:

* Tum ek-ek page aur number dekh ke dhoond sakte ho ( Brute Force)
    
* Ya phir ek **smart strategy** laga sakte ho ( Binary Search), jaise ek librarian fast search karta hai using index. )
    

1\. Brute Force Approach (Simple & Straightforward)

#### 📍Approach:

We check **each element one by one** — like manually flipping every page of a dictionary to find a word. Tedious, right?

(Hinglish :

* Har element ko line by line check karo.
    
* Jaise roll number register mein manually dhoondhna.)
    

```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
      for(int i = 0; i < matrix.length; i++) {
        for(int j = 0; j < matrix[0].length; j++) {
            if(matrix[i][j] == target) {
                return true;
            }
        }
      }
        return false;
    }
}
```

#### 💠Time Complexity:

* `O(m * n)`  
    — m = number of rows  
    — n = number of columns
    

#### 💠 Space Complexity:

* `O(1)` (No extra space)
    

2\. Optimal Approach (Binary Search in 2D as 1D)

#### 📍Key Insight:

Matrix actually behaves like a **sorted 1D array**.  
We can perform **binary search** by mapping:

```plaintext
mid index → (row = mid / n, col = mid % n)
```

#### 📍Smart Trick:

* Treat the matrix as if it’s **flattened** into a sorted array.
    
* Use classic binary search strategy.
    

```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
     int m = matrix.length;  // total rows 
     int n = matrix[0].length; //tpta; columns

     int left = 0;
     int right = m * n - 1;  //treat matrix as 1D array 

     while (left <= right) {
        int mid = (left + right) / 2;

        int row = mid / n;  //find actua row in matrix
        int col = mid % n;  //find actual column in matrix

        int midValue = matrix[row][col];

        if(midValue == target) {
            return true;   //target mil gaya
        } else if(midValue < target) {
            left = mid + 1;  //search right half 
        } else {
            right = mid - 1;   //serach left half 
         }
        }
        return false;    //target nahi mila 
    }
}
```

#### 💠Time Complexity:

* `O(log(m * n))` ✅  
    — because we’re performing binary search on total `m * n` elements
    

#### 💠 Space Complexity:

* `O(1)` (No extra space)
    

### 📍Key Takeaways:

✅ Understand the **matrix property** – rows are sorted, and each row starts bigger than previous ends.  
✅ Map 1D index to 2D to apply **binary search smartly**.  
✅ Practicing this builds strong foundation in **search algorithms** & **matrix manipulation**.

---

### 2️⃣**Implement Pow(x,n) | X raised to the power N**

🔸 Problem Statement:

Implement pow(x, n), which calculates `x` raised to the power `n` (i.e., `x<sup>n</sup>`).

**Example 1:**

```plaintext
Input: x = 2.00000, n = 10
Output: 1024.00000
```

**Example 2:**

```plaintext
Input: x = 2.10000, n = 3
Output: 9.26100
```

**Example 3:**

```plaintext
Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
```

**Constraints:**

* `-100.0 < x < 100.0`
    
* `-2<sup>31</sup> <= n <= 2<sup>31</sup>-1`
    
* `n` is an integer.
    
* Either `x` is not zero or `n > 0`.
    
* `-10<sup>4</sup> <= x<sup>n</sup> <= 10<sup>4</sup>`
    

### 💠Real-World Example

Imagine you’re doubling your savings every year (compound interest style ).  
Year 1: ₹100  
Year 2: ₹200  
Year 3: ₹400

...  
By Year 10: ₹1024

That’s **2 raised to power 10** — or `pow(2, 10)`.  
But what if we have to calculate it for large powers or for **negative exponents** like interest deduction?

This is where **efficiency** comes into play!

(Hinglish : Socho tumne saving kari hai per year

Har din wo double hota hai:

* Year 1 → ₹100
    
* Year 2 → ₹200
    
* Year 3 → ₹400
    
* ...
    
* Year 10 → ₹1024
    

Yeh exactly `pow(2, 10)` hai.  
Agar same rupees har year **aadha ho jaaye** due to drought, then it becomes `pow(2, -2) = 0.25`.  
Toh ab samajh aaya, **power positive bhi ho sakta hai aur negative bhi**. We need to handle both efficiently!

1. Brute Force Approach
    
    📍Logic : Multiply `x` with itself `n` times.
    
    (Hinglish :
    
    * Bas ek loop chalao `n` times, har baar `result *= x` karo.
        
    * Negative power ho toh finally `1 / result` return karo.)
        
    
    ```java
    class Solution {
        public double myPow(double x, int n) {
            double result = 1.0;
            long power = n;
            
            if (power < 0) {
                power = -power;
            }
    
            for (int i = 0; i < power; i++) {
                result *= x;
            }
    
            return (n < 0) ? 1.0 / result : result;
        }
    }
    ```
    
    #### 💠Time Complexity:
    
    * `O(n)`
        
    
    📍Problem:
    
    Too slow when `n` is large (like 2³¹). May cause **Time Limit Exceeded (TLE)**.
    
    (Hinglish : TLE (Time Limit Exceeded) ho sakta hai — especially when `n` is huge.)
    
2. Optimal Approach-Fast Power Using Binary Exponentiation
    
    ### 📍 Concept:
    
    Instead of multiplying `x` `n` times, let’s do it smartly!
    
3. * It uses:  
        ✔ `x^n = (x^2)^{n/2}` (when n is even)  
        ✔ `x^n = x * (x^2)^{n/2}` (when n is odd)
        
    
    * This actually reflects the **optimized recursive/iterative logic**.
        
    * This reduces steps from `n` → `log n`
        
    
    ```java
    class Solution {
        public double myPow(double x, int n) {
            long power = n;
            
            if (power < 0) {
                x = 1 / x; //negative power ka handle 
                power = -power;
            }
             
             double result = 1.0;
    
            while(power > 0) {
                if(power % 2 == 1) {
                    result *= x; //odd power
                }
                x *= x; //square the base
                power /= 2;  //divide power by 2
            }
    
            return  result;
        }
    }
    ```
    
    **💠Time** Complexity: **:** `O(log n)` ✅
    
    **Why?**
    
    * Each time we divide the power `n` by 2 → this is a classic **Binary Exponentiation** or **Exponentiation by Squaring** technique.
        
    * This reduces the number of steps drastically (just like in binary search).
        
    * So, the loop runs approximately **log₂(n)** times.
        
    
    > **Example**:  
    > For `n = 16`, number of operations ≈ `log₂(16)` = 4 steps only.
    
    **💠Space** Complexity:**:** `O(1)` ✅
    
    **Why?**
    
    * No recursion stack.
        
    * We use only a **fixed number of variables** (`result`, `x`, `power`) regardless of input size.
        
    * So, the space used is constant.
        

```plaintext
Input: x = 2.0, n = 10

Initial:
  result = 1.0, power = 10, x = 2.0

Step 1: power even → x = x*x = 4, power = 5
Step 2: power odd → result = result * 4 = 4, x = 16, power = 2
Step 3: power even → x = 256, power = 1
Step 4: power odd → result = result * 256 = 1024, power = 0

Final Result: 1024.0 ✅
```

> **(Hinglish : "Maan lo tumhare paas ek number hai** `x = 2` aur tumhe uska 10th power chahiye. Ab 2 ko 10 baar multiply karne ki jagah, hum shortcut lete hain!"  
> Just like how we don’t count steps one by one when climbing stairs — instead, we take **double steps** — similarly, here we **square** the base and reduce the power. That’s **exponentiation by squaring**! )

### 📍Important Points :-

✅ If `n` is negative → convert `x` to `1/x` and `n` to `-n`  
✅ Binary Exponentiation = super fast, time `O(log n)`  
✅ Overflow se bachne ke liye use `long` instead of `int`  
✅ `pow(x, n)` ek basic yet super frequently asked DSA concept hai — **must know for interviews.**

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

![](https://cdn.hashnode.com/res/hashnode/image/upload/v1754080755779/ca94610d-00b8-4324-91f2-f026586e779f.jpeg align="center")

%[https://youtu.be/JXU4Akft7yk] 

%[]
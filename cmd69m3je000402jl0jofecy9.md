---
title: "📅 Day 1 - Striver’s SDE Sheet | Arrays Part 1 | Q1 & Q2: Set Matrix Zero & Pascal’s Triangle"
seoTitle: "Matrix Zeroes & Pascal Triangle Solutions"
seoDescription: "Begin your 27-day DSA journey with Striver’s SDE Sheet starting with arrays. Explore matrix zero and Pascal's triangle with optimal solutions"
datePublished: Wed Jul 16 2025 17:58:45 GMT+0000 (Coordinated Universal Time)
cuid: cmd69m3je000402jl0jofecy9
slug: day-1-strivers-sde-sheet-arrays-part-1-q1-and-q2-set-matrix-zero-and-pascals-triangle
cover: https://cdn.hashnode.com/res/hashnode/image/upload/v1752666348134/dbebe1d5-89f1-4d72-aa8d-f2238a9c974d.png
ogImage: https://cdn.hashnode.com/res/hashnode/image/upload/v1752688670163/615c00d4-8f12-4ef2-9773-983f82433e8a.png
tags: code, java, technology, hashnode, dsa, coding-challenge, codenewbies, technical-writing-1, coding-journey, dsainjava, dsa-series, striver-dsa-sheet, striversdesheet, payalkumari11, dsawithpayal

---

> Note : **<mark>Started my 27-day DSA journey with Striver’s SDE Sheet!</mark>**  
> <mark>I will be </mark> ***<mark>journaling every day</mark>*** <mark>— recording what I learn, reflecting on it, and sharing it with my network to help </mark> ***<mark>fellow learners</mark>*** <mark>and </mark> ***<mark>aspiring developers..</mark>*** <mark>Learning through videos, resources, and the internet — simplifying logic in my own way with real-world connections. Sharing 2 questions daily: brute-force to optimal, clean Java code, time &amp; space complexity, and key patterns.</mark>

This blog series is for **anyone preparing for coding interviews** — whether you’re a beginner or a revision warrior. Let’s grow together! 🚀

## **Namaste Developers! 🙏**

### **Welcome to Day 1 of my 27-day DSA journey using Striver’s SDE Sheet!**

## 💠What is an Array? (Quick Recap)

An **array** is a **linear data structure** used to store a collection of elements (like numbers or characters) at **contiguous memory locations**.

### 🔑 Key Points:

* Stores **multiple values** in a **single variable**
    
* Accessed via **index** (starting from 0)
    
* Helps in solving problems involving sequences, patterns, and grids
    
* In DSA, arrays are the **foundation** for more advanced topics like matrices, strings, DP, etc.
    
* Example:
    
    ```java
    int[] arr = {1, 2, 3, 4};
    System.out.println(arr[2]);  // Output: 3
    ```
    
    <mark><br>Today I’ve started with </mark> **<mark>Arrays – Part 1</mark>** <mark>and solved the 1st</mark> **<mark>two questions</mark>**<mark>:</mark>
    

1️⃣ **Set Matrix Zero**  
2️⃣ **Pascal’s Triangle**

---

### **<mark>1️⃣</mark>**[**<mark>Set Matrix Zeroes</mark>**](https://leetcode.com/problems/set-matrix-zeroes/)

Given an **m x n** integer matrix matrix, if an element is **0**, set its entire row and column to 0. **You must do it in place.**

**Examples:**

```plaintext
Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]

Output: [[1,0,1],[0,0,0],[1,0,1]]

Explanation:

Element at position (1,1) is 0, so set entire row 1 and column 1 to 0.
```

```plaintext
Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]

Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]

Explanation:

There are two zeroes: (0,0) and (0,3).

Row 0 → all elements become 0
Column 0 and column 3 → all elements become 0
```

**💠Constraints:**

* `m == matrix.length`
    
* `n == matrix[0].length`
    
* `1 <= m, n <= 200`
    
* `-2<sup>31</sup> <= matrix[i][j] <= 2<sup>31</sup> - 1`
    

🔷 Problem Statement (Simple Words):

You’re given a 2D matrix.  
If any element in the matrix is `0`, then you need to **make its entire row and column** `0`.

**BUT...**  
If you start doing this instantly, new zeros will impact the wrong rows/columns.  
So you’ll need a **safe step-by-step plan**.

## ✅ Real Life Analogy – *COVID Ward Seal Down* 🏥

Imagine a **hospital ward** represented as a matrix:

```plaintext
[[1, 1, 1],
 [1, 0, 1],
 [1, 1, 1]]
```

* `1` = Healthy Patient
    
* `0` = COVID Positive
    
    **<mark>Rule</mark>:** If any patient is COVID positive, we seal the **entire row and column** for safety.
    
    **(Hindi: But** agar turant har infected patient ka row/column seal kar diya, toh naye 0 doosri rows/columns ko bhi galat affect kar denge.)
    
    That's why — just like real-life COVID protocols — we need a **2-phase approach**.
    
    ### 💠Brute Force Approach
    
    📍Idea:
    
    * Traverse matrix → store **rows & columns** that have `0`.
        
        (Hindi : Jaha jaha `0` ho matrix mein, uska **row** aur **column** record karo)
        
    * Second pass → set those rows and columns to `0`.
        
        (Hindi : Baad mein un sab rows/columns ko `0` kar do)
        
        📍Dry Run Example:
        
    * Input
        
        ```plaintext
        [[1, 1, 1],
         [1, 0, 1],
         [1, 1, 1]]
        ```
        
        * Found `0` at \[1\]\[1\]
            
        * Mark row `1` and column `1`
            
    * Output:
        
        ```plaintext
        [[1, 0, 1],
         [0, 0, 0],
         [1, 0, 1]]
        ```
        

### 💠Brute Force Code

```java
 class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];

        // Step 1: Mark rows and cols with 0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        // Step 2: Set 0 based on markings
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] matrix = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        };

        sol.setZeroes(matrix);

        // Print the modified matrix
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
```

📍Time & Space Complexity:

* **Time:** `O(m * n)` → 2 traversals
    
* **Space:** `O(m + n)` → Extra row & column arrays
    

### 💠Optimal Approach

### 📍 Trick:

Use matrix’s own **first row and column as markers**.

### ⚠️ Special Case:

What if original first row/column already had `0`?  
→ Track separately using **row0** and **col0** flags.

### 📍Real World Analogy:

Just like **hotel guest register**, we use the **first row/column** as markers to note which row/col should be zero later.

### 💠Optimal Code :

```java
 class Solution {
    public void setZeroes(int[][] matrix) { 
        int m = matrix.length, n = matrix[0].length;
        boolean row0 = false, col0 = false;

        // Step 1: Check first row/col has 0
        for (int i = 0; i < m; i++)
            if (matrix[i][0] == 0) col0 = true;

        for (int j = 0; j < n; j++)
            if (matrix[0][j] == 0) row0 = true;

        // Step 2: Use first row/col as markers
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0; // mark row
                    matrix[0][j] = 0; // mark column
                }
            }
        }

        // Step 3: Update matrix based on markers
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }

        // Step 4: Set first row/col if needed
        if (col0)
            for (int i = 0; i < m; i++) matrix[i][0] = 0;

        if (row0)
            for (int j = 0; j < n; j++) matrix[0][j] = 0;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] matrix = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        };
        sol.setZeroes(matrix);

        // Print the modified matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
```

📍Time & Space Complexity:

* **Time:** `O(m * n)`
    
* **Space:** `O(1)` → No extra arrays, just flags
    

### 💠Thought Process Table

| 📍 Step | 📍 Sochne ka Tarika |
| --- | --- |
| 1️⃣ | Pehle matrix samjho, pattern pakdo |
| 2️⃣ | Brute force: har 0 mark karo |
| 3️⃣ | Optimize: Kya extra space avoid ho sakta hai? |
| 4️⃣ | Use matrix’s first row/col as marker |
| 5️⃣ | Handle special case (first row/col has 0) |

### 💠Real World Applications:

* **Excel/Google Sheets:** Auto-hiding or locking based on invalid entries
    
* **Hospitals:** Seal COVID rows for safety
    

**Fire Alert Systems:** One alarm disables full area.

---

### 2️⃣ **Pascal’s Triangle**

Given an integer `numRows`, return the first numRows of **Pascal's triangle**.

In **Pascal's triangle**, each number is the sum of the two numbers directly above it as shown:

**Example 1:**

```plaintext
Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
```

**Example 2:**

```plaintext
Input: numRows = 1
Output: [[1]]
```

**Constraints:**

* `1 <= numRows <= 30`
    

📍 Every row starts and ends with `1`,  
📍Middle elements are `sum` of two numbers above.

### 💠Real Life Analogy – *Staircase Team Formation*

Imagine there is a team-building game taking place, where people stand in rows, like a ladder.

* 1st row mein 1 banda.
    
* 2nd row mein 2 log: dono ke paas ek-ek helmet.
    
* 3rd row se leke har aadmi ka helmet, **upar ke dono bande milke dete hain.**
    

Jaise:

* 3rd row, 2nd person → helmet from row2's 1st + 2nd person → 1 + 1 = 2
    
* 4th row, 2nd person → 1st + 2nd from previous → 1 + 2 = 3
    

> **Itna simple logic! Bas upar ke 2 add karo — that’s Pascal’s Triangle!**

Sochne ka simple flow: **Staircase jaisi team formation** jahan har level ke log **apne upar walon pe depend karte hain** — that's the beauty of this pattern!

### 💠Step-by-Step Intuition

### 📍Observation:

* Har row ke start/end mein hamesha `1` hota hai
    
* `triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j]` for middle elements
    

📍Dry Run with numRows = 4

```plaintext
Row 0:        [1]
Row 1:      [1, 1]
Row 2:    [1, 2, 1]       → 2 = 1 + 1
Row 3:  [1, 3, 3, 1]      → 3 = 1+2, 3 = 2+1
```

### 💠Better Approach

```java
import java.util.*;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                row.add((int) nCr(i, j));
            }
            triangle.add(row);
        }

        return triangle;
    }

    private long nCr(int n, int r) {
        long res = 1;

        // Since C(n, r) = C(n, n-r)
        if (r > n - r)
            r = n - r;

        for (int i = 0; i < r; ++i) {
            res *= (n - i);
            res /= (i + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        List<List<Integer>> triangle = sol.generate(14); // try with large value

        for (List<Integer> row : triangle) {
            System.out.println(row);
        }
    }
}
```

📍Time complexity (TC)

```java
for (int i = 0; i < numRows; i++) {
    for (int j = 0; j <= i; j++) {
        row.add((int) nCr(i, j)); // nCr takes O(r) time
    }
}
```

### `nCr(i, j)` takes `O(min(j, i-j))` = at most `O(i/2)`

Worst-case estimate:

* Inner loop: runs `i+1` times
    
* Each `nCr` call takes up to `O(i)`
    
* So, total time =
    
    ![](https://cdn.hashnode.com/res/hashnode/image/upload/v1752731919026/a0d90fe9-139e-4d00-bd43-b63c319d0c8f.png align="center")
    

✅ But with the optimized `nCr`, actual time is slightly better:

* **Amortized TC ≈ O(n²)** for triangle generation using multiplicative `nCr`.
    

📍Space Complexity (SC)

* Output: storing Pascal's Triangle → total number of elements =
    
    ![](https://cdn.hashnode.com/res/hashnode/image/upload/v1752731959464/9e6dd5ce-5bd8-4b4f-aa6f-a7b3a14650af.png align="center")
    
* Extra variables: `long res`, loop vars → negligible
    

✅ **SC = O(n²)**

**Why quadratic?**

Because we are filling triangle up to `numRows`, and each row has `i` elements → total ≈ `n²` operations

### 💠Brute to Optimal

| 📍 Step | 📍 Sochne ka Tarika |
| --- | --- |
| 1️⃣ | Har row ki length = row index + 1 |
| 2️⃣ | First/Last index → always 1 |
| 3️⃣ | Beech ka element → upar ke 2 elements ka sum |
| 4️⃣ | Triangle list mein har row add karte jao |
| 5️⃣ | No need to optimize further – space/time are already good |

```java
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            
            for (int j = 0; j <= i; j++) {
                // First and last positions are always 1
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    // Sum of the two values above
                    int val = triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j);
                    row.add(val);
                }
            }

            triangle.add(row);
        }

        return triangle;
    }
}
```

## 💠What's This Approach?

This uses the **Pascal’s Triangle property**:

![](https://cdn.hashnode.com/res/hashnode/image/upload/v1752732091861/7d375d2c-4850-4e1e-99b2-0dfe55502bfb.png align="center")

With the base cases:

* First and last elements of each row are always `1`.
    

📍**Time Complexity (TC)**

* Each row `i` has `i+1` elements.
    
* You iterate through each element once.
    
* Total number of operations:
    

![](https://cdn.hashnode.com/res/hashnode/image/upload/v1752732197108/364a848f-da77-48a5-92e2-a60bb8c4a728.png align="center")

📍 **Space Complexity (SC):**

* You're storing the entire triangle:
    

![](https://cdn.hashnode.com/res/hashnode/image/upload/v1752732268843/fe99f96f-56dd-486e-8b95-908f94a62ecf.png align="center")

No extra space used apart from the result list.

### 💠Why This Is Best:

* No use of factorials → avoids integer overflow.
    
* Avoids recomputation → more efficient.
    
* Clean, readable logic → perfect for interviews.
    

## 💠Real World Applications:

* **Probability in Math** → Binomial Expansion
    
* **Combinatorics** → nCr patterns
    
* **Interview Prep** → Classic pattern-based problem
    
* **Memory Games** → Building pyramid logic with previous states
    

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

![](https://cdn.hashnode.com/res/hashnode/image/upload/v1752688098622/a55ab452-43ea-4f8b-b39e-a0e942b6a391.jpeg align="center")

%[https://youtu.be/N0MgLvceX7M?si=7e6PqV_0rwAaxBW6] 

%[https://youtu.be/bR7mQgwQ_o8?si=bLmPtPXbYvnTA78a]
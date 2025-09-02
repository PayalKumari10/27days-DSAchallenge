---
title: "📅Day-20 Striver’s SDE Sheet | Linked List and Arrays |  3Sum , Trapping Rain Water."
seoTitle: "Linked List & Arrays: 3Sum, Trapping Rain"
seoDescription: "Learn efficient solutions for 3Sum and Trapping Rain Water in Day 20 of Striver's SDE Sheet journey. Optimize your coding interview prep!"
datePublished: Sun Aug 31 2025 18:30:00 GMT+0000 (Coordinated Universal Time)
cuid: cmf2iid6a000302jte9wn1qah
slug: day-20-strivers-sde-sheet-linked-list-and-arrays-3sum-trapping-rain-water
cover: https://cdn.hashnode.com/res/hashnode/image/upload/v1756802570797/86245488-e9d0-4520-9c14-3a0cfebf4b11.png
ogImage: https://cdn.hashnode.com/res/hashnode/image/upload/v1756815151849/77f1e0fd-90ab-4841-a97a-0116c0a8fe8c.png
tags: code, java, technology, coding, hashnode, dsa, coding-challenge, codenewbies, technical-writing-1, codingnewbies, dsainjava, dsa-series, striversa2zdsa, payalkumari11, dsawithpayal

---

> ***Note : <mark>Started my 27-day DSA journey with Striver’s SDE Sheet!</mark>  
> <mark>I will be journaling every day</mark> <mark>— recording what I learn, reflecting on it, and sharing it with my network to help fellow learners</mark> <mark>and aspiring developers..</mark> <mark>Learning through videos, resources, and the internet — simplifying logic in my own way with real-world connections. Sharing 2 questions daily: brute-force to optimal, clean Java code, time &amp; space complexity, and key patterns.</mark>***

This blog series is for **anyone preparing for coding interviews** whether you’re a beginner or a revision warrior. Let’s grow together!

## Namaste Developers! 🙏

**Welcome to Day 20 of my 27-day DSA journey using Striver’s SDE Sheet!**

## 1️⃣ 3Sum

### 🔸 Problem Statement:

Given an integer array nums, return all the triplets `[nums[i], nums[j], nums[k]]` such that `i != j`, `i != k`, and `j != k`, and `nums[i] + nums[j] + nums[k] == 0`.

Notice that the solution set must not contain duplicate triplets.

**Example 1:**

```plaintext
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
```

**Example 2:**

```plaintext
Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
```

**Example 3:**

```plaintext
Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
```

**Constraints:**

* `3 <= nums.length <= 3000`
    
* `-10<sup>5</sup> <= nums[i] <= 10<sup>5</sup>`
    

## <mark>Real World Example</mark>

Imagine you and your two friends go to a cafe. You all want to order snacks such that the **total bill = 0** (let’s say you’re playing with virtual credits where positive = you pay, negative = discount).

* You pick `-1` (discount of ₹1)
    
* Your friend picks `2` (pays ₹2)
    
* Another friend picks `-1` (discount of ₹1)
    

So the total = `-1 + 2 + -1 = 0`.  
This forms a valid triplet.

**(Hinglish:** Socho tum 3 dost ho, aur har ek ka balance positive/negative hai. Tumhe aisi team banana hai jiska **total zero ho jaye**. Bas wahi yaha 3Sum ka funda hai!)

### **1️⃣ Brute Force Approach**

The simplest way is to try all possible triplets and check if they sum to zero.

```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(triplet); // avoid duplicates like [2,-1,-1] vs [-1,-1,2]
                        if (!result.contains(triplet)) {
                            result.add(triplet);
                        }
                    }
                }
            }
        }
        return result;
    }
}
```

### <mark>Time Complexity (TC)</mark>

* We are checking all combinations → `O(n³)`
    
* Sorting each triplet + checking duplicates can add more overhead.
    

### <mark>Space Complexity (SC)</mark>

* Extra space for storing results. Worst case: `O(n²)` triplets.
    

(Hinglish: Ye approach kaafi slow hai, kyunki har ek teen numbers ka combination check karna pad raha hai. Bade arrays ke liye ye bilkul bhi efficient nahi hai.)

## 2️⃣ Optimal Approach

We can improve efficiency by using the **Two Pointer Technique** after sorting the array.

### Steps:

1. Sort the array.
    
2. Fix one number (`nums[i]`) and then use **two pointers** (`left` and `right`) to find pairs that make the sum zero with `nums[i]`.
    
3. Skip duplicates to avoid repeated triplets.
    

```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); 
        int n = nums.length;
        
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; 
            
            int left = i + 1, right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++; 
                } else {
                    right--; 
                }
            }
        }
        return result;
    }
}
```

### <mark>Time Complexity (TC)</mark>

* Sorting = `O(n log n)`
    
* Outer loop (`i`) runs `n` times
    
* Inner two-pointer loop runs `O(n)`
    
* Total = `O(n²)`
    

### <mark>Space Complexity (SC)</mark>

* Only storing results + few variables = `O(1)` auxiliary space (ignoring output).
    

(Hinglish: Is approach main humne smart tareeke se array ko sort karke left-right pointers use kiya, jisse unnecessary combinations check karne ki zarurat nahi padti. Speed bohot fast ho gayi compared to brute force.)

---

## 2️⃣**Trapping Rain Water**

Given `n` non-negative integers representing an elevation map where the width of each bar is `1`, compute how much water it can trap after raining.

  
**Example 1:**

![](https://assets.leetcode.com/uploads/2018/10/22/rainwatertrap.png align="left")

```plaintext
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
```

**Example 2:**

```plaintext
Input: height = [4,2,0,3,2,5]
Output: 9
```

**Constraints:**

* `n == height.length`
    
* `1 <= n <= 2 * 10<sup>4</sup>`
    
* `0 <= height[i] <= 10<sup>5</sup>`
    

## <mark>Real World Example</mark>

<mark><br></mark>Imagine you are in a street with **uneven buildings**.  
After rain, water will **collect between taller buildings and shorter buildings**.

* **High building → acts like a boundary**
    
* **Low building → water fills there until a taller wall stops it**
    

Example: If your left building is 5 floors and right building is 6 floors, and in between you have 2 floors → then water fills **(min(5,6)-2) = 3 floors**.

**(Hinglish:** Samajh lo ki paani hamesha dono taraf ke tallest walls ke beech rukta hai. Jitni choti building beech mein hogi, utna zyada paani jama hoga.)

### 1️⃣ Brute Force Approach

### Idea

* For each block, find:
    
    * **Left Max Height**
        
    * **Right Max Height**
        
* Water trapped at that block = `min(leftMax, rightMax) - height[i]` (if positive).
    
* Sum this for all blocks.
    

```java
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int water = 0;
        
        for (int i = 0; i < n; i++) {
            int leftMax = 0, rightMax = 0;
            
            // find left max
            for (int j = 0; j <= i; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }
            
            // find right max
            for (int j = i; j < n; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }
            
            water += Math.min(leftMax, rightMax) - height[i];
        }
        
        return water;
    }
}
```

### **<mark>Time Complexity:</mark>**

`O(N^2)` (for each element, scanning left & right).

### **<mark>Space Complexity:</mark>**

`O(1)` (no extra space).

**(Hinglish:** Ye approach easy hai but costly hai. Har element ke liye left aur right scan karna padta hai, so performance slow ho jata hai.)

## 2️⃣ Optimal Approach

### Idea

* Maintain two pointers: **left** and **right**.
    
* Maintain two variables: **leftMax** and **rightMax**.
    
* Move pointers smartly:
    
    * If `height[left] < height[right]`, water depends on leftMax.
        
    * Otherwise, water depends on rightMax.
        

```java
class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;
        
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }
        return water;
    }
}
```

### **<mark>Time Complexity:</mark>**

`O(N)` (single pass).

### **<mark>Space Complexity:</mark>**

`O(1)` (constant extra variables).

**(Hinglish:** Yaha hum dono ends se ek saath move karte hain. Left aur right ke maximum ko track karte hain aur har step pe paani add karte jaate hain. Ye sabse fast solution hai.)

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

![](https://cdn.hashnode.com/res/hashnode/image/upload/v1756812364111/fbc1b627-3003-4745-ac68-ec3f664b5b81.jpeg align="center")

%[https://youtu.be/DhFh8Kw7ymk] 

%[https://youtu.be/1_5VuquLbXg]
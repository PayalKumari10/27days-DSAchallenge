---
title: "📅Day-11 Striver’s SDE Sheet |  Arrays Part 4 | Longest Consecutive Sequence, Largest Subarray with K sum."
seoTitle: "SDE Sheet Day 10: Advanced Array Challenges"
seoDescription: "Discover optimal solutions for "Longest Consecutive Sequence" and "Largest Subarray with K sum" using Striver's SDE in this insightful DSA journey"
datePublished: Thu Aug 07 2025 14:02:14 GMT+0000 (Coordinated Universal Time)
cuid: cme1guoit000902ji4xp6e6j6
slug: day-11-strivers-sde-sheet-arrays-part-4-longest-consecutive-sequence-largest-subarray-with-k-sum
cover: https://cdn.hashnode.com/res/hashnode/image/upload/v1754567587705/5119fde4-06fe-4571-b480-f3ae7bf9d2e6.png
ogImage: https://cdn.hashnode.com/res/hashnode/image/upload/v1754574922453/acbc2e81-820a-43ff-9a1e-f0029073418c.png
tags: code, java, technology, coding, hashnode, dsa, coding-challenge, technical-writing-1, coding-journey, dsainjava, dsa-series, striver-dsa-sheet, striversdesheet, payalkumari11, dsawithpayal

---

> ***Note : <mark>Started my 27-day DSA journey with Striver’s SDE Sheet!</mark>  
> <mark>I will be journaling every day</mark> <mark>— recording what I learn, reflecting on it, and sharing it with my network to help fellow learners</mark> <mark>and aspiring developers..</mark> <mark>Learning through videos, resources, and the internet — simplifying logic in my own way with real-world connections. Sharing 2 questions daily: brute-force to optimal, clean Java code, time &amp; space complexity, and key patterns.</mark>***

This blog series is for **anyone preparing for coding interviews** — whether you’re a beginner or a revision warrior. Let’s grow together! 🚀

## Namaste Developers! 🙏

**Welcome to Day 11 of my 27-day DSA journey using Striver’s SDE Sheet!**

### 1️⃣ Longest Consecutive Sequence

### 🔸 Problem Statement:

Given an unsorted array of integers `nums`, return *the length of the longest consecutive elements sequence.*

You must write an algorithm that runs in `O(n)` time.

**Example 1:**

```plaintext
Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
```

**Example 2:**

```plaintext
Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
```

**Example 3:**

```plaintext
Input: nums = [1,0,1,2]
Output: 3
```

**Constraints:**

* `0 <= nums.length <= 10<sup>5</sup>`
    
* `-10<sup>9</sup> <= nums[i] <= 10<sup>9</sup>`
    

### 💠Real world Example

Imagine you have a bunch of books, each labeled with a random volume number, like:

```plaintext
Books = [5, 1, 2, 100, 3]
```

Now, you want to find the longest sequence of books where the volume numbers follow each other consecutively — like \[1, 2, 3, 4, 5\]. You just need to return the length of that longest consecutive sequence.

(Hinglish: Maan lo tumhare paas ek **bunch of books** hain — sab ke upar random **volume numbers** likhe hue hain, Books = \[5, 1, 2, 100, 3\]. Ab tumhe dekhna hai ki kaunsa **longest sequence** hai jo continuously follow kar raha hai volume numbers ko — jaise \[1, 2, 3, 4, 5\]. Bas yeh sequence ka **length** hi return karna hai.)

## 💠 Brute Force Approach – Sorting Based

📍Logic

First, sort the array.

Then check for consecutive elements using the condition:  
`nums[i] == nums[i - 1] + 1`

Keep counting the length of the current consecutive sequence and update the maximum length whenever needed.

(Hinglish :

1. Pehle array ko sort karo.
    
2. Consecutive elements check karo: `nums[i] == nums[i-1] + 1`
    
3. Count consecutive sequence and update max. )
    

```java
class Solution {
   
       public int longestConsecutive(int[] nums) {
    if (nums.length == 0) return 0;

    Arrays.sort(nums);
    int longest = 1, count = 1;

    for (int i = 1; i < nums.length; i++) {
        if (nums[i] != nums[i - 1]) { // avoid duplicate counting
            if (nums[i] == nums[i - 1] + 1) {
                count++;
            } else {
                longest = Math.max(longest, count);
                count = 1;
            }
        }
    }
    return Math.max(longest, count);


    }
}
```

### 📍Time & Space Complexity:

```java
Arrays.sort(nums);
for loop...
```

#### 🔹 Time Complexity (TC):

* `Arrays.sort(nums)` → **O(n log n)**
    
* `for` loop traversal → **O(n)**
    
* **Overall TC = O(n log n)**
    

#### 🔹 Space Complexity (SC):

* If sorting in-place → **O(1)**
    
* But in Java, `Arrays.sort()` uses **TimSort** which takes **O(n)** in worst case for additional space  
    So: **SC = O(n)** (depends on language sorting implementation)
    

* **TC:** `O(n log n)` (because of sorting)
    
* **SC:** `O(1)` (if sorting in-place), Java mein ho sakta hai `O(n)` internally.
    

### 💠Optimal Approach – Using HashSet

**📍Logic :**

* Put all the numbers into a HashSet.
    
* Then, for each number, check: does `num - 1` **not** exist?
    
    * If it doesn’t exist, that means this number could be the **start of a new sequence**.
        
* Then keep checking for `num + 1`, `num + 2`, and so on — until the sequence breaks.
    

(Hinglish :

* Sab numbers ek HashSet mein daal do.
    
* Fir har number ke liye check karo: kya `num - 1` exist nahi karta?  
    Agar nahi karta, toh woh ek **new sequence ka start** hoga.
    
* Aage check karte jao `num + 1`, `num + 2`, ... jab tak sequence break na ho.)
    

```java
class Solution {
   public int longestConsecutive(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
        set.add(num);
    }

    int longest = 0;

    for (int num : set) {
        // Only check if it's the start of a sequence
        if (!set.contains(num - 1)) {
            int currentNum = num;
            int count = 1;

            while (set.contains(currentNum + 1)) {
                currentNum++;
                count++;
            }

            longest = Math.max(longest, count);
        }
    }
    return longest;
}
}
```

### 📍Time & Space Complexity:

```java
Set<Integer> set = new HashSet<>();
```

#### 🔹 Time Complexity (TC):

* Storing all elements in a set → **O(n)**
    
* Iterating each element once + while loop (each element max once) → **O(n)**
    
* **Overall TC = O(n)**
    

#### 🔹 Space Complexity (SC):

* HashSet storing all elements → **O(n)**
    

* **TC:** `O(n)` → because each number is visited at most twice.
    
* **SC:** `O(n)` → because we store numbers in a Set.
    

---

### 2️⃣Largest Subarray with K sum

🔸 Problem Statement:

Given an array `arr[]` containing integers and an integer `k`, your task is to find the length of the longest subarray where the sum of its elements is equal to the given value `k`. If there is no subarray with sum equal to `k`, return `0`.

**Examples:**

```plaintext
Input: arr[] = [10, 5, 2, 7, 1, -10], k = 15
Output: 6
Explanation: Subarrays with sum = 15 are [5, 2, 7, 1], [10, 5] and [10, 5, 2, 7, 1, -10]. The length of the longest subarray with a sum of 15 is 6.
```

```plaintext
Input: arr[] = [-5, 8, -14, 2, 4, 12], k = -5
Output: 5
Explanation: Only subarray with sum = -5 is [-5, 8, -14, 2, 4] of length 5.
```

```plaintext
Input: arr[] = [10, -10, 20, 30], k = 5
Output: 0
Explanation: No subarray with sum = 5 is present in arr[].
```

**Constraints:**  
1 ≤ arr.size() ≤ 10<sup>5<br></sup>\-10<sup>4&nbsp;</sup> ≤ arr\[i\] ≤ 10<sup>4<br></sup>\-10<sup>9 </sup> ≤ k ≤ 10<sup>9</sup>

### 💠Real World Example

Imagine you’re walking on a road (`arr[]`), and every step gives or takes energy (`+` or `-` values).  
You want to find the **longest path** where total energy spent is exactly `k`.

So you keep walking, and keep checking:

> *“Yeh takraar ka hisaab ab tak k ke barabar hai ya nahi?”*  
> If yes → you save that length!

### 💠Brute Force Approach

### 📍Idea:

* Check every subarray `i to j`
    
* Calculate the sum
    
* If it’s `k`, update max length
    

```java
class Solution {
    public int longestSubarray(int[] arr, int k) {
          int maxLen = 0;
    for (int i = 0; i < arr.length; i++) {
        int sum = 0;
        for (int j = i; j < arr.length; j++) {
            sum += arr[j];
            if (sum == k) {
                maxLen = Math.max(maxLen, j - i + 1);
            }
        }
    }
    return maxLen;
        
    }
}
```

### 📍Time & Space Complexity:

* **TC = O(n²)** → nested loops
    
* **SC = O(1)**
    

> ⛔ Not good for large inputs (TLE warning )

### 💠Optimal Approach

### Idea:

We use a **prefix sum** and store it in a **HashMap**, where:

* `key = sum` we’ve seen so far
    
* `value = index` where that sum occurred first
    

If at index `i`, the current prefix sum is `sum`,  
we check if `sum - k` was seen before → that means the subarray between that index and `i` adds up to `k`.

### ✅ Step-by-Step:

1. Initialize map: `sumToIndex = new HashMap<>()`
    
2. Loop through array, maintain `sum`
    
3. If `sum == k`, update `maxLen`
    
4. If `sum - k` exists in map → update `maxLen` based on that index
    
5. Only insert a sum into the map **if it’s not already there** (we want the longest)
    

```java
class Solution {
    public int longestSubarray(int[] arr, int k) {
        Map<Integer, Integer> sumToIndex = new HashMap<>();
        int sum = 0, maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum == k) {
                maxLen = i + 1;
            }

            if (sumToIndex.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i - sumToIndex.get(sum - k));
            }

            if (!sumToIndex.containsKey(sum)) {
                sumToIndex.put(sum, i);
            }
        }

        return maxLen;
    }
}
```

### 📍Time & Space Complexity:

* **TC = O(n)**
    
* **SC = O(n)**
    

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

![](https://cdn.hashnode.com/res/hashnode/image/upload/v1754574622626/dc8c1760-f1f4-444a-83e5-5c27ec83a974.jpeg align="center")

%[https://youtu.be/oO5uLE7EUlM] 

%[https://youtu.be/frf7qxiN2qU]
---
title: "📅Day-14 Striver’s SDE Sheet | Linked List Part 1 | Merge two sorted Linked Lists , Remove N-th node from the end of a Linked List."
seoTitle: "Linked List Fundamentals: Merge and Remove Nodes"
seoDescription: "Learn to merge sorted linked lists and remove n-th node from the end. Brute force to optimal solutions with Java code and complexity analyses"
datePublished: Tue Aug 12 2025 13:19:43 GMT+0000 (Coordinated Universal Time)
cuid: cme8kj9oo000n02ibg39l6iu0
slug: day-14-strivers-sde-sheet-linked-list-part-1-merge-two-sorted-linked-lists-remove-n-th-node-from-the-end-of-a-linked-list
cover: https://cdn.hashnode.com/res/hashnode/image/upload/v1754999292022/b70ee30d-6126-418e-8ddd-3cb0e3ebc82b.png
ogImage: https://cdn.hashnode.com/res/hashnode/image/upload/v1755004614037/e04bfb58-39eb-4522-846c-a60593445d66.png
tags: code, java, coding, hashnode, dsa, coding-tips, coding-challenge, coding-journey, codingnewbies, dsainjava, dsa-series, striver-dsa-sheet, striversdesheet, payalkumari11, dsawithpayal

---

> ***Note : <mark>Started my 27-day DSA journey with Striver’s SDE Sheet!</mark>  
> <mark>I will be journaling every day</mark> <mark>— recording what I learn, reflecting on it, and sharing it with my network to help fellow learners</mark> <mark>and aspiring developers..</mark> <mark>Learning through videos, resources, and the internet — simplifying logic in my own way with real-world connections. Sharing 2 questions daily: brute-force to optimal, clean Java code, time &amp; space complexity, and key patterns.</mark>***

This blog series is for **anyone preparing for coding interviews** — whether you’re a beginner or a revision warrior. Let’s grow together! 🚀

## Namaste Developers! 🙏

**Welcome to Day 14 of my 27-day DSA journey using Striver’s SDE Sheet!**

### 1️⃣ **Merge two sorted Linked Lists**

### 🔸 Problem Statement:

You are given the heads of two sorted linked lists `list1` and `list2`.

Merge the two lists into one **sorted** list. The list should be made by splicing together the nodes of the first two lists.

Return *the head of the merged linked list*.

**Example 1:**

![](https://assets.leetcode.com/uploads/2020/10/03/merge_ex1.jpg align="left")

```plaintext
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
```

**Example 2:**

```plaintext
Input: list1 = [], list2 = []
Output: []
```

**Example 3:**

```plaintext
Input: list1 = [], list2 = [0]
Output: [0]
```

**Constraints:**

* The number of nodes in both lists is in the range `[0, 50]`.
    
* `-100 <= Node.val <= 100`
    
* Both `list1` and `list2` are sorted in **non-decreasing** order.
    

## 💠Real-Life Example

Imagine you have **two queues** of students standing in increasing order of their height:

* Queue A → \[150cm, 160cm, 170cm\]
    
* Queue B → \[155cm, 165cm, 175cm\]
    

Now, the teacher says — *"Merge both queues into one big queue but still maintain height order"*.

So you start comparing **the first students** in both queues and **pick the shorter one first** to stand in the merged queue. Repeat until one queue is empty, and then append the rest.

This is exactly how merging works in **Linked Lists**.

(<mark>Hinglish </mark> : Socho tumhare paas do queues hain students ki, jo apni height ke increasing order mein khade hain:

Queue A → \[150cm, 160cm, 170cm\]  
Queue B → \[155cm, 165cm, 175cm\]

Ab teacher bolti hain — "Dono queues ko ek badi queue mein merge karo, lekin height ka order same rehna chahiye."

Toh tum dono queues ke first students ko compare karoge, jo chhota hoga usko pehle merged queue mein rakhoge. Yeh process repeat karte rahoge jab tak ek queue khali na ho jaye. Phir bachi hui queue ke saare students ko end mein add kar doge.

Bilkul yeh hi process Linked Lists merge karte time hota hai.)

### 💠Brute Force Approach

**📍Idea**:

* Extract all elements from both linked lists into a new array/list.
    
* Sort that array.
    
* Build a new linked list from it.
    

**📍Steps**:

1. Traverse **list1** and store values in an array.
    
2. Traverse **list2** and store values in the same array.
    
3. Sort the array.
    
4. Create a new linked list from this sorted array.
    

```java
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        List<Integer> arr = new ArrayList<>();

        // Store elements of list1
        while (list1 != null) {
            arr.add(list1.val);
            list1 = list1.next;
        }

        // Store elements of list2
        while (list2 != null) {
            arr.add(list2.val);
            list2 = list2.next;
        }

        // Sort the array
        Collections.sort(arr);

        // Build new linked list
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        for (int val : arr) {
            temp.next = new ListNode(val);
            temp = temp.next;
        }

        return dummy.next;
    }
}
```

**📍Time Complexity**:

* O((n+m) log(n+m)) → because of sorting.
    
    **📍Space Complexity**:
    
* O(n+m) → extra space for storing elements.
    

( **Hinglish Note**:  
Yeh approach simple hai lekin zyada space & sorting time lagta hai. Interview me **pass ho jayega but not optimal**.)

## 💠 Optimal Approach (Two Pointer Technique)

**📍Idea**:  
Since both linked lists are **already sorted**, we can merge them **like in Merge Sort** using **two pointers** without sorting again.

**📍Steps**:

1. Create a dummy node to simplify list creation.
    
2. Keep two pointers `p1` and `p2` at heads of `list1` and `list2`.
    
3. Compare values at `p1` and `p2`.
    
    * Pick the smaller node and move that pointer ahead.
        
4. Repeat until one list becomes empty.
    
5. Append the remaining list to the merged list.
    

```java
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        // Attach the remaining nodes
        if (list1 != null) tail.next = list1;
        if (list2 != null) tail.next = list2;

        return dummy.next;
    }
}
```

### 📍Time Complexity

* **O(n + m)** → We visit each node exactly once.
    

### 📍Space Complexity

* **O(1)** → No extra array, only pointers.
    

(**Hinglish Note**:  
Yeh approach **fatafat** kaam karta hai, bilkul efficient hai, aur interviews me **thumbs up** milega.)

### 💠Key Takeaways

* Brute Force: Simple but not efficient (O((n+m) log(n+m)) time).
    
* Optimal: Two-pointer merge in O(n+m) time and O(1) space.
    
* **Tip**: Dummy node use karna life easy bana deta hai.
    

✅ **Final Advice for Beginners**:

* Pehle Brute Force samajho, phir Optimal.
    
* Real-life analogy yaad rakho — **"Do sorted queues ko ek me merge karna"**.
    
* Linked list problems me **pointer manipulation ka game strong karo**.
    

---

### 2️⃣ **Remove Nth Node From End of List**

### 🔸 Problem Statement:

Given the `head` of a linked list, remove the `n<sup>th</sup>` node from the end of the list and return its head.

**Example 1:**

![](https://assets.leetcode.com/uploads/2020/10/03/remove_ex1.jpg align="left")

```plaintext
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
```

**Example 2:**

```plaintext
Input: head = [1], n = 1
Output: []
```

**Example 3:**

```plaintext
Input: head = [1,2], n = 1
Output: [1]
```

**Constraints:**

* The number of nodes in the list is `sz`.
    
* `1 <= sz <= 30`
    
* `0 <= Node.val <= 100`
    
* `1 <= n <= sz`
    

**Follow up:** Could you do this in one pass?

## 💠Real-Life Example

Imagine a **train** with bogies numbered from **front to back**.  
The problem is: "Remove the **nth bogie from the end**."

Example: Train bogies → `1 - 2 - 3 - 4 - 5`  
If `n = 2`, then from the end, **bogie 4** will be removed.

### 💠Brute Force Approach (2 Pass Method)

### 🔍 Idea

1. **First pass:** Count total number of nodes `len`.
    
2. **Second pass:** Remove `(len - n + 1)`th node from the front.
    

```java
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode temp = head;

        // 1st pass: find length
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        // If head node is to be removed
        if (length == n) return head.next;

        // 2nd pass: go to (length - n)th node
        temp = head;
        for (int i = 1; i < length - n; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
        return head;
    }
}
```

### ✅ Complexity

* **Time Complexity (TC):** `O(2N)` ≈ `O(N)` → We traverse the list twice.
    
* **Space Complexity (SC):** `O(1)` → No extra space used.
    

### 💠Optimal Approach (One Pass – Two Pointer Technique)

### 📍Idea

* Use **two pointers** `fast` and `slow`.
    
* Move `fast` pointer `n` steps ahead.
    
* Move **both** `fast` & `slow` until `fast` reaches the end.
    
* [`slow.next`](http://slow.next) will be the node to remove.
    

```java
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        // Move fast ahead by n+1 steps
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both fast and slow together
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Remove target node
        slow.next = slow.next.next;

        return dummy.next;
    }
}
```

### ✅ Complexity

* **Time Complexity (TC):** `O(N)` → Only one pass.
    
* **Space Complexity (SC):** `O(1)` → Constant extra space.
    

(<mark>Hinglish </mark> :

* Brute Force mein hum pehle **list ka length nikalte** hain aur phir `(length - n)`th node se aage wale ko remove kar dete hain.
    
* Optimal mein hum ek baar hi traverse karte hain using **Two Pointer Technique** → fast ko pehle n steps aage bhej dete hain, phir fast & slow ko ek saath chala dete hain jab tak fast end tak nahi pahunchta, aur slow ke next ko remove kar dete hain.)
    

## 📍Key Takeaways

(Hinglish:

* Linked List ke problems ka **best friend = Two Pointer Technique** 😎
    
* Brute Force → Easy but 2 passes.
    
* Optimal → Same TC but ek hi pass mein kaam.)
    

📍**Real Coder** (<mark>Hinglish </mark> **<mark>Tip</mark>:** Jab interview mein yeh question aaye, pehle brute force explain karo (easy samajhne ke liye) and phir optimal likho – interviewer ko lagega tum systematic approach follow karte ho.)

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

![](https://cdn.hashnode.com/res/hashnode/image/upload/v1755004477983/c5bddc13-52d7-4b6c-8a6b-e7c416c72bc0.jpeg align="center")

%[https://youtu.be/Xb4slcp1U38] 

%[https://youtu.be/Lhu3MsXZy-Q]
---
title: "📅Day-13 Striver’s SDE Sheet | Linked List Part 1 | Reverse a Linked List, Find the middle of LinkedList."
seoTitle: "Reverse and Find Middle of Linked List"
seoDescription: "Reverse a linked list, find its middle, and optimize coding techniques for interviews with Day 13 of Striver’s SDE Sheet journey"
datePublished: Mon Aug 11 2025 17:02:01 GMT+0000 (Coordinated Universal Time)
cuid: cme7d1an3000k02jx3ndzhgne
slug: day-13-strivers-sde-sheet-linked-list-part-1-reverse-a-linked-list-find-the-middle-of-linkedlist
cover: https://cdn.hashnode.com/res/hashnode/image/upload/v1754906528040/d1fd40e1-ebe7-4acf-a100-e91920f6ec19.png
ogImage: https://cdn.hashnode.com/res/hashnode/image/upload/v1754931689888/84043249-41dd-43b9-bd0f-4e11aab28bcd.png
tags: code, java, coding, hashnode, dsa, coding-challenge, codenewbies, coding-journey, dsainjava, dsa-series, striver-dsa-sheet, striversa2zdsa, striversdesheet, payalkumari11, dsawithpa

---

> ***Note : <mark>Started my 27-day DSA journey with Striver’s SDE Sheet!</mark>  
> <mark>I will be journaling every day</mark> <mark>— recording what I learn, reflecting on it, and sharing it with my network to help fellow learners</mark> <mark>and aspiring developers..</mark> <mark>Learning through videos, resources, and the internet — simplifying logic in my own way with real-world connections. Sharing 2 questions daily: brute-force to optimal, clean Java code, time &amp; space complexity, and key patterns.</mark>***

This blog series is for **anyone preparing for coding interviews** — whether you’re a beginner or a revision warrior. Let’s grow together! 🚀

## Namaste Developers! 🙏

**Welcome to Day 13 of my 27-day DSA journey using Striver’s SDE Sheet!**

### **Intro: What’s the Scene?**

If you’ve ever **reversed a playlist on Spotify**, you know the vibe — the last song becomes the first, and the first becomes the last.  
In coding, reversing a linked list is the same: we flip the order of nodes so the head becomes the tail and vice versa.

In a **singly linked list**, each node points to the next one. But if you want to reverse it, you need to *carefully change those arrows* without losing track of the list.  
Think of it like **flipping a train** — you have to reverse all bogies but keep them connected.

### 1️⃣ **Reverse a Linked List**

### 🔸 Problem Statement:

Given the `head` of a singly linked list, reverse the list, and return *the reversed list*.

**Example 1:**

![](https://assets.leetcode.com/uploads/2021/02/19/rev1ex1.jpg align="left")

```plaintext
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
```

**Example 2:**

![](https://assets.leetcode.com/uploads/2021/02/19/rev1ex2.jpg align="left")

```plaintext
Input: head = [1,2]
Output: [2,1]
```

**Example 3:**

```plaintext
Input: head = []
Output: []
```

### 💠**Real-Life Example**

Imagine you have a **queue of friends** waiting for ice cream :  
**Original order:** Rahul → Priya → Aman → Meena  
If you reverse it:  
**Reversed order:** Meena → Aman → Priya → Rahul.

(<mark>Hinglish</mark> : Socho tumhare paas ek queue hai friends ki jo ice cream ke liye wait kar rahe hain:  
Original order: Rahul → Priya → Aman → Meena  
Agar tum ise reverse kar do:  
Reversed order: Meena → Aman → Priya → Rahul)

## 💠Brute Force Approach — Reverse a Linked List

### **📍Idea**

Instead of changing pointers directly (like in the optimal method),  
we first **store all node values in an array/list**, reverse that array, and then write those values back into the linked list.

(<mark>Hinglish</mark> :

📍 Idea  
Optimal method mein jaise directly pointers change karte hain, uske bajay  
pehle hum saare node values ek array/list mein store karenge,  
phir us array ko reverse karenge,  
aur fir woh values wapas linked list mein likh denge.)

### **📍Steps**

1. Create an empty array `values[]`.
    
2. Traverse the linked list from head to tail and push each `node.val` into `values[]`.
    
3. Reverse the `values[]`.
    
4. Traverse the linked list again, this time replacing each node's value with the reversed values.
    

```java
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;

        // Step 1: Store all values in an array
        List<Integer> values = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            values.add(temp.val);
            temp = temp.next;
        }

        // Step 2: Reverse the array
        Collections.reverse(values);

        // Step 3: Put values back into the list
        temp = head;
        int index = 0;
        while (temp != null) {
            temp.val = values.get(index++);
            temp = temp.next;
        }

        return head; // head stays same, only values change
    }
}
```

### **📍Dry Run Example**

For input: `1 → 2 → 3 → 4`

* `values[]` after step 1: `[1, 2, 3, 4]`
    
* After reversing: `[4, 3, 2, 1]`
    
* After putting values back: `4 → 3 → 2 → 1`
    

### **📍Complexity Analysis**

* **Time Complexity (TC)**:
    
    1. Traversing list to store values → **O(n)**
        
    2. Reversing array → **O(n)**
        
    3. Traversing list again to assign values → **O(n)**  
        **Total:** O(n) + O(n) + O(n) = **O(n)**
        
* **Space Complexity (SC)**:
    
    * We store all values in an extra array → **O(n)** extra space.
        
    * No recursion stack, so no hidden extra space.
        
    
    ### ✅ **Final Complexity:**
    
* **TC:** O(n)
    
* **SC:** O(n)
    

**(<mark>Hinglish Tip:</mark>**  
*"Yeh brute force approach kaam karta hai, par memory zyada khata hai kyunki hum ek extra array use karte hain. Interview mein best yeh hota hai ki optimal pointer manipulation wala approach likho, kyunki woh space O(1) rakhta hai.”)*

## **💠Optimal Iterative Approach (Pointer Manipulation)**

**📍Idea:**  
We reverse the list *in-place* by changing each node’s `next` pointer.

**📍Steps:**

1. Take three pointers: `prev`, `curr`, and `nextNode`.
    
2. Initially, `prev = null` and `curr = head`.
    
3. Loop through the list:
    
    * Store `nextNode =` [`curr.next`](http://curr.next)
        
    * Reverse the link: [`curr.next`](http://curr.next) `= prev`
        
    * Move `prev` to `curr`
        
    * Move `curr` to `nextNode`
        
4. At the end, `prev` will be the new head.
    

```java
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextNode = curr.next; // store next
            curr.next = prev;              // reverse link
            prev = curr;                   // move prev
            curr = nextNode;                // move curr
        }

        return prev; // new head
    }
}
```

### 📍Dry Run

(Example: \[1,2,3,4\])

```plaintext
Step 1: prev = null, curr = 1 → 2 → 3 → 4
Step 2: nextNode = 2, curr.next = null, prev = 1, curr = 2
Step 3: nextNode = 3, curr.next = 1, prev = 2 → 1, curr = 3
Step 4: nextNode = 4, curr.next = 2 → 1, prev = 3 → 2 → 1, curr = 4
Step 5: curr = null, prev = 4 → 3 → 2 → 1
```

* **It reverses the linked list in-place** by changing the `next` pointers directly.
    
* **No extra array** or data structure is used.
    
* Only uses a few pointers: `prev`, `curr`, and `nextNode`.
    
* **Time Complexity (TC)**: O(n) — we traverse the list once.
    
* **Space Complexity (SC)**: O(1) — constant extra space.
    
    ### ✅ **Final Complexity:**
    
* **TC:** O(n)
    
* **SC:** O(1)
    

(<mark>Hinglish Tips</mark> :- *"Yeh code bilkul mast hai — yeh pointer manipulation se list ko reverse karta hai bina extra space khaye. Isliye yeh hi interviewers ka favourite hota hai, kyunki yeh fast aur memory-friendly hai."* )

## 💠Recursive Approach (Pointer Manipulation via Call Stack)

### **📍Idea:**

  
Instead of reversing all links in one loop, we let recursion handle the rest of the list and then reverse the current link on the way back.

```java
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = reverseList(head.next); // reverse the rest
        head.next.next = head; // make next node point to current
        head.next = null; // break old link

        return newHead;
    }
}
```

### **📍Dry Run (Example: \[1,2,3\])**

```java
reverseList(1)
   → reverseList(2)
       → reverseList(3) → returns 3
       2.next.next = 2  (3 → 2)
       2.next = null
   1.next.next = 1  (2 → 1)
   1.next = null
```

**Result:** 3 → 2 → 1

### ✅ **Final Complexity:**

* **Time Complexity (TC):** O(n) — we visit each node once
    
* **Space Complexity (SC):** O(n) — recursion call stack
    

(**<mark>Hinglish Tip:</mark>**  
*"Code short hai, par stack space ka dhyan rakho — large lists pe overflow ho sakta hai.")*

# **📍Final Thoughts**

* **Brute Force:** Simple but memory-heavy (O(n) space).
    
* **Iterative:** **Best choice** — O(n) time, O(1) space.
    
* **Recursive:** Clean but O(n) space due to stack.
    

(<mark>Hinglish</mark> : *"Reverse linked list ek classic interview sawaal hai. Agar aap iterative aur recursive dono approaches confidently likh paate ho, toh aap half linked list problems jeet gaye!")*

---

## **2️⃣Middle of the Linked List**

Given the `head` of a singly linked list, return *the middle node of the linked list*.

If there are two middle nodes, return **the second middle** node.

**Example 1:**

![](https://assets.leetcode.com/uploads/2021/07/23/lc-midlist1.jpg align="left")

```plaintext
Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.
```

**Example 2:**

![](https://assets.leetcode.com/uploads/2021/07/23/lc-midlist2.jpg align="left")

```plaintext
Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
```

**Constraints:**

* The number of nodes in the list is in the range `[1, 100]`.
    
* `1 <= Node.val <= 100`
    

### **💠Real-Life Example**

Think of a **train** with bogies (coaches) numbered from **front to back**.  
The middle bogie is the one exactly at the halfway mark.  
If the train has an **even number of bogies**, we take the **second middle** — because that's the "middle" for our rule.

(<mark>Hinglish</mark> : Real-Life Analogy  
Socho ek train hai jisme bogies (coaches) front se back tak numbered hain.  
Middle bogie woh hoti hai jo bilkul halfway mark par hoti hai.  
Agar train mein even number of bogies hain, toh hum second middle lete hain — kyunki hamare rule ke hisaab se wahi "middle" hai.)

## **💠Brute Force (Two Pass Traversal)**

**📍Idea:**

1. Count the total number of nodes `n`.
    
2. Find the middle index → `n / 2` (integer division).
    
3. Traverse again to reach that index and return that node.
    

```java
class Solution {
    public ListNode middleNode(ListNode head) {
        int count = 0;
        ListNode temp = head;

        // First pass: count nodes
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        // Second pass: reach middle
        int mid = count / 2;
        temp = head;
        for (int i = 0; i < mid; i++) {
            temp = temp.next;
        }

        return temp;
    }
}
```

### **✅ Final Complexity:**

* **Time:** O(n) + O(n) = **O(n)**
    
* **Space:** O(1)
    

**(<mark>Hinglish Tip:</mark>**  
*"Yeh simple approach hai — pehle length nikal, phir middle tak jaa. Do baar chalana padta hai.")*

### 💠Store in Array/List (Extra Space)

**📍Idea:**

* Store all nodes in an array.
    
* Return node at index `n / 2`.
    

```java
class Solution {
    public ListNode middleNode(ListNode head) {
        List<ListNode> arr = new ArrayList<>();
        while (head != null) {
            arr.add(head);
            head = head.next;
        }
        return arr.get(arr.size() / 2);
    }
}
```

**✅Final omplexity:**

* **Time:** O(n)
    
* **Space:** O(n) (array storage)
    

### **💠Optimal (Fast & Slow Pointer)**

**📍Idea:**  
Use **two pointers**:

* `slow` moves **1 step** at a time
    
* `fast` moves **2 steps** at a time  
    When `fast` reaches the end, `slow` will be at the middle.
    

```java
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;       // move 1 step
            fast = fast.next.next;  // move 2 steps
        }

        return slow;
    }
}
```

**Dry Run (\[1,2,3,4,5,6\]):**

```plaintext
slow = 1, fast = 1
slow = 2, fast = 3
slow = 3, fast = 5
slow = 4, fast = null  ✅
```

Middle = `4`

**✅Final Complexity:**

* **Time:** O(n) (single pass)
    
* **Space:** O(1) (no extra space)
    

**(<mark>Hinglish Tip</mark>:**  
*"Yeh approach interview ka hero hai — ek hi traversal, bina memory waste kiye middle nikalta hai.")*

## **📍Final Notes**

* **Brute Force:** Easy but 2 passes.
    
* **Array Storage:** One pass but extra memory.
    
* **Fast & Slow Pointer:** **Best choice** — O(n) time, O(1) space.
    

(<mark>Hinglish </mark> : *"Middle of Linked List is a must-know — especially the fast & slow pointer trick, kyunki yeh cycle detection, palindrome check, aur aur bhi linked list problems mein kaam aata hai.")*

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

![](https://cdn.hashnode.com/res/hashnode/image/upload/v1754931506147/5c7c0d2a-80b4-4506-a31b-d0c45c355780.jpeg align="center")

%[https://youtu.be/iRtLEoL-r-g] 

%[https://youtu.be/sGdwSH8RK-o]
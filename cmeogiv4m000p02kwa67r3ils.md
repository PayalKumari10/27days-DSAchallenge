---
title: "📅Day-19 Striver’s SDE Sheet | Linked List and Arrays | Rotate a LinkedList, Clone a Linked List with random and next pointer."
seoTitle: "Striver’s SDE Sheet: Linked List and Arrays"
seoDescription: "Learn how to rotate and clone linked lists efficiently using Striver's SDE Sheet with detailed explanations and real-life examples"
datePublished: Sat Aug 23 2025 16:11:45 GMT+0000 (Coordinated Universal Time)
cuid: cmeogiv4m000p02kwa67r3ils
slug: day-19-strivers-sde-sheet-linked-list-and-arrays-rotate-a-linkedlist-clone-a-linked-list-with-random-and-next-pointer
cover: https://cdn.hashnode.com/res/hashnode/image/upload/v1755953045876/62727e2e-83ea-45b1-8f8a-56df4eb86e10.png
ogImage: https://cdn.hashnode.com/res/hashnode/image/upload/v1755965433397/996df993-6c55-428a-af8e-ae4b20b35b72.png
tags: code, java, coding, hashnode, dsa, coding-tips, coding-challenge, technical-writing-1, coding-journey, codingnewbies, problem-solving-skills, dsainjava, dsa-series, striversa2zdsa, payalkumari11

---

> ***Note : <mark>Started my 27-day DSA journey with Striver’s SDE Sheet!</mark>  
> <mark>I will be journaling every day</mark> <mark>— recording what I learn, reflecting on it, and sharing it with my network to help fellow learners</mark> <mark>and aspiring developers..</mark> <mark>Learning through videos, resources, and the internet — simplifying logic in my own way with real-world connections. Sharing 2 questions daily: brute-force to optimal, clean Java code, time &amp; space complexity, and key patterns.</mark>***

This blog series is for **anyone preparing for coding interviews** whether you’re a beginner or a revision warrior. Let’s grow together!

## Namaste Developers! 🙏

**Welcome to Day 19 of my 27-day DSA journey using Striver’s SDE Sheet!**

## 1️⃣ **Rotate List**

### 🔸 Problem Statement:

Given the `head` of a linked list, rotate the list to the right by `k` places.

  
**Example 1:**

![](https://assets.leetcode.com/uploads/2020/11/13/rotate1.jpg align="left")

```plaintext
Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]
```

**Example 2:**

![](https://assets.leetcode.com/uploads/2020/11/13/roate2.jpg align="left")

```plaintext
Input: head = [0,1,2], k = 4
Output: [2,0,1]
```

**Constraints:**

* The number of nodes in the list is in the range `[0, 500]`.
    
* `-100 <= Node.val <= 100`
    
* `0 <= k <= 2 * 10<sup>9</sup>`
    

## 💠Real Life Example

Imagine you have a **music playlist**:  
`[Song1, Song2, Song3, Song4, Song5]`

Now your friend says – *"Bro, play the last 2 songs first and then the rest."*  
So after rotation by `k=2`:  
`[Song4, Song5, Song1, Song2, Song3]`

\=&gt; Boom! That’s exactly what **Rotate Linked List** is doing.

(<mark>Hinglish </mark> : Soch lo tumhare paas ek music playlist hai:  
**\[Song1, Song2, Song3, Song4, Song5\]**

Ab tumhara dost bolta hai –  
**"Bro, pehle last ke 2 gaane chala, fir baaki."**

Toh rotation k=2 ke baad playlist aisi ho jaati hai:  
**\[Song4, Song5, Song1, Song2, Song3\]**

\=&gt; Samjhe? Yehi kaam Rotate Linked List karta hai.)

### **1️⃣ Brute Force Approach**

**Idea**: Rotate list one by one, `k` times.

Steps:

1. For each rotation:
    
    * Traverse till last node.
        
    * Make last node as new head.
        
    * Adjust links accordingly.
        
2. Repeat this process **k times**.
    

```java
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        int n = 0;
        ListNode temp = head;
        while (temp != null) {
            n++;
            temp = temp.next;
        }

        k = k % n;
        if (k == 0) return head;

        for (int i = 0; i < k; i++) {
            ListNode prev = null, curr = head;
            while (curr.next != null) {
                prev = curr;
                curr = curr.next;
            }
            prev.next = null;
            curr.next = head;
            head = curr;
        }
        return head;
    }
}
```

### 📍Complexity

* **Time Complexity (TC)** → `O(k * n)`  
    (Because for each of `k` rotations we traverse list of size `n`)
    
* **Space Complexity (SC)** → `O(1)`  
    (Only pointers used, no extra space)
    

### **2️⃣ Optimal Approach**

**Idea**: Instead of rotating one by one, we use math & linked list properties.

Steps:

1. Find length `n` of list.
    
2. Connect last node → head (circular list).
    
3. Find effective rotations: `k = k % n`.
    
4. Break the list at `(n - k)` position.
    
5. New head will be `(n - k + 1)`th node.
    

```java
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // Step 1: Find length
        ListNode temp = head;
        int n = 1;
        while (temp.next != null) {
            n++;
            temp = temp.next;
        }

        // Step 2: Make it circular
        temp.next = head;

        // Step 3: Effective rotations
        k = k % n;
        int stepsToNewHead = n - k;

        // Step 4: Find new head
        ListNode newTail = head;
        for (int i = 1; i < stepsToNewHead; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}
```

### 📍Complexity

* **Time Complexity (TC)** → `O(n)`  
    (One pass for length, one pass for finding new head)
    
* **Space Complexity (SC)** → `O(1)`  
    (No extra space, only pointers)
    

---

### 2️⃣ **Copy List with Random Pointer**

### 🔸 Problem Statement:

A linked list of length `n` is given such that each node contains an additional random pointer, which could point to any node in the list, or `null`.

Construct a [**deep copy**](https://en.wikipedia.org/wiki/Object_copying#Deep_copy) of the list. The deep copy should consist of exactly `n` **brand new** nodes, where each new node has its value set to the value of its corresponding original node. Both the `next` and `random` pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. **None of the pointers in the new list should point to nodes in the original list**.

For example, if there are two nodes `X` and `Y` in the original list, where `X.random --> Y`, then for the corresponding two nodes `x` and `y` in the copied list, `x.random --> y`.

Return *the head of the copied linked list*.

The linked list is represented in the input/output as a list of `n` nodes. Each node is represented as a pair of `[val, random_index]` where:

* `val`: an integer representing `Node.val`
    
* `random_index`: the index of the node (range from `0` to `n-1`) that the `random` pointer points to, or `null` if it does not point to any node.
    

Your code will **only** be given the `head` of the original linked list.

**Example 1:**

![](https://assets.leetcode.com/uploads/2019/12/18/e1.png align="left")

```plaintext
Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
```

**Example 2:**

![](https://assets.leetcode.com/uploads/2019/12/18/e2.png align="left")

```plaintext
Input: head = [[1,1],[2,1]]
Output: [[1,1],[2,1]]
```

**Example 3:**

![](https://assets.leetcode.com/uploads/2019/12/18/e3.png align="left")

```plaintext
Input: head = [[3,null],[3,0],[3,null]]
Output: [[3,null],[3,0],[3,null]]
```

**Constraints:**

* `0 <= n <= 1000`
    
* `-10<sup>4</sup> <= Node.val <= 10<sup>4</sup>`
    
* `Node.random` is `null` or is pointing to some node in the linked list.
    

## 💠 Real World Terms

Imagine you’re making a **guest list for a wedding**.

* Each guest has:
    
    1. **Name (val)** → like "Rahul", "Priya", "John".
        
    2. **Next pointer** → the person sitting next to them in the list.
        
    3. **Random pointer** → a special link to their **“plus one” friend/relative**. (Could be anyone from the list, or no one).
        

Now, you want to **copy the guest list** completely into a new list for backup.  
But here’s the catch **The new guest list should not refer to the old one at all.**

* Rahul’s copy should point to Priya’s copy (not old Priya).
    
* If Rahul’s random points to John, then Rahul-copy’s random should also point to John-copy.
    

This is exactly the **Copy List with Random Pointer** problem.

(<mark>Hinglish </mark> : Socho tum shaadi ke liye ek **guest list** bana rahe ho.

Har guest ke paas hai:

* **Name (val)** → jaise "Rahul", "Priya", "John".
    
* **Next pointer** → jo uske baad wali seat pe baitha hai list mein.
    
* **Random pointer** → ek special link uske “plus one” dost/relative ko. (Ye koi bhi ho sakta hai list se, ya phir koi na ho).
    

Ab tumhe poori guest list **copy** karke ek nayi list banani hai backup ke liye.  
Lekin catch ye hai ki nayi guest list purani wali ko refer nahi karegi.

Agar **Rahul-copy** hai to uska **next** Priya-copy hona chahiye (na ki old Priya).  
Aur agar Rahul ka **random John pe point kar raha hai**, to Rahul-copy ka random bhi **John-copy** pe hi point kare.

\=&gt; Yehi exactly **Copy List with Random Pointer problem** hai.)

<mark>Example </mark> → Original list:

```plaintext
Rahul → Priya → John
Rahul.random → John
Priya.random → Rahul
John.random → null
```

When you make a deep copy:

```plaintext
Rahul' → Priya' → John'
Rahul'.random → John'
Priya'.random → Rahul'
John'.random → null
```

Now, even if the **old list is destroyed**, the new one works independently.

## 1️⃣ Brute Force Approach

### 🔹 Steps

1. Traverse original list → create new nodes and store mapping `{oldNode → newNode}` in a **HashMap**.
    
2. Traverse again → for each old node,
    
    * [`newNode.next`](http://newNode.next) `= map.get(`[`oldNode.next`](http://oldNode.next)`)`
        
    * `newNode.random = map.get(oldNode.random)`
        

```java
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // Step 1: Store mapping old → new
        HashMap<Node, Node> map = new HashMap<>();
        Node temp = head;
        while (temp != null) {
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }

        // Step 2: Connect next & random using map
        temp = head;
        while (temp != null) {
            Node clone = map.get(temp);
            clone.next = map.get(temp.next);
            clone.random = map.get(temp.random);
            temp = temp.next;
        }

        return map.get(head);
    }
}
```

### 💠Complexity

* **Time Complexity (TC)**: `O(n)` (2 traversals of list)
    
* **Space Complexity (SC)**: `O(n)` (HashMap storage for mapping)
    

## 2️⃣ Optimal Approach

### 🔹 Steps

1. **Interweave nodes**: For each node, insert its clone **just after it**.  
    Example: `A → B → C` becomes `A → A' → B → B' → C → C'`
    
2. **Fix random pointers**: If `A.random = B`, then `A'.random = B'.`
    
3. **Separate lists**: Detach clone nodes to form the new list.
    

```java
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // Step 1: Insert clone nodes
        Node temp = head;
        while (temp != null) {
            Node clone = new Node(temp.val);
            clone.next = temp.next;
            temp.next = clone;
            temp = clone.next;
        }

        // Step 2: Set random pointers
        temp = head;
        while (temp != null) {
            if (temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }

        // Step 3: Separate both lists
        Node dummy = new Node(0);
        Node copy = dummy;
        temp = head;
        while (temp != null) {
            copy.next = temp.next;
            copy = copy.next;

            temp.next = temp.next.next;
            temp = temp.next;
        }

        return dummy.next;
    }
}
```

### 💠Complexity

* **Time Complexity (TC)**: `O(n)` (3 traversals)
    
* **Space Complexity (SC)**: `O(1)` (No extra DS, only new nodes)
    

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

![](https://cdn.hashnode.com/res/hashnode/image/upload/v1755964834243/ee5a6553-b9d1-43d9-a2c8-1ffd8bbd306d.jpeg align="center")

%[https://youtu.be/9VPm6nEbVPA] 

%[https://youtu.be/q570bKdrnlw]
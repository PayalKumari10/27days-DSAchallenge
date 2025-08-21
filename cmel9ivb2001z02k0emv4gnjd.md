---
title: "📅Day-17 Striver’s SDE Sheet | Linked List Part 2 | Find the starting point of the Loop of LinkedList, Flattening of a LinkedList"
seoTitle: "Linked List Loops & Flattening Guide"
seoDescription: "Explore finding the starting point of a linked list loop and flattening a linked list with optimal approaches. Perfect for coding interviews"
datePublished: Thu Aug 21 2025 10:32:29 GMT+0000 (Coordinated Universal Time)
cuid: cmel9ivb2001z02k0emv4gnjd
slug: day-17-strivers-sde-sheet-linked-list-part-2-find-the-starting-point-of-the-loop-of-linkedlist-flattening-of-a-linkedlist
cover: https://cdn.hashnode.com/res/hashnode/image/upload/v1755764484941/3449de11-5de5-467c-a868-b3794612f0e9.png
ogImage: https://cdn.hashnode.com/res/hashnode/image/upload/v1755772294912/87f830aa-1fea-4001-9e3d-0504d5208286.png
tags: code, programming-blogs, java, technology, coding, hashnode, dsa, coding-challenge, technical-writing-1, coding-journey, dsainjava, striver-dsa-sheet, striversa2zdsa, payalkumari11, dsawithpayal

---

> ***Note : <mark>Started my 27-day DSA journey with Striver’s SDE Sheet!</mark>  
> <mark>I will be journaling every day</mark> <mark>— recording what I learn, reflecting on it, and sharing it with my network to help fellow learners</mark> <mark>and aspiring developers..</mark> <mark>Learning through videos, resources, and the internet — simplifying logic in my own way with real-world connections. Sharing 2 questions daily: brute-force to optimal, clean Java code, time &amp; space complexity, and key patterns.</mark>***

This blog series is for **anyone preparing for coding interviews** — whether you’re a beginner or a revision warrior. Let’s grow together! 🚀

## Namaste Developers! 🙏

**Welcome to Day 18 of my 27-day DSA journey using Striver’s SDE Sheet!**

### 1️⃣ **Find the starting point of the Loop of LinkedList**

### 🔸 Problem Statement:

Given the `head` of a linked list, return *the node where the cycle begins. If there is no cycle, return* `null`.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the `next` pointer. Internally, `pos` is used to denote the index of the node that tail's `next` pointer is connected to (**0-indexed**). It is `-1` if there is no cycle. **Note that** `pos` **is not passed as a parameter**.

**Do not modify** the linked list.

**Example 1:**

![](https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist.png align="left")

```plaintext
Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
Explanation: There is a cycle in the linked list, where tail connects to the second node.
```

**Example 2:**

![](https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist_test2.png align="left")

```plaintext
Input: head = [1,2], pos = 0
Output: tail connects to node index 0
Explanation: There is a cycle in the linked list, where tail connects to the first node.
```

**Example 3:**

![](https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist_test3.png align="left")

```plaintext
Input: head = [1], pos = -1
Output: no cycle
Explanation: There is no cycle in the linked list.
```

**Constraints:**

* The number of the nodes in the list is in the range `[0, 10<sup>4</sup>]`.
    
* `-10<sup>5</sup> <= Node.val <= 10<sup>5</sup>`
    
* `pos` is `-1` or a **valid index** in the linked-list.
    

**Follow up:** Can you solve it using `O(1)` (i.e. constant) memory?

### 💠Real-Life Example

### 📍WhatsApp Group Loops

  
Imagine you forward a message in a WhatsApp group. If there’s a setting where it bounces back from someone and comes to you again → that’s a cycle.  
The **person from where it started looping back** = cycle start node.

**(Hinglish:** WhatsApp group mein ek message forward karo. Agar woh kisi se ghoom ke wapas tumhe aata hai → matlab cycle hai.  
Aur jaha se woh looping start hui → wahi cycle ka starting node hai.)

### 1️⃣ Brute Force Approach

### 📍 Idea:

Use a **HashSet** to store visited nodes.

* Traverse the list.
    
* If we see a node that’s already visited → that’s the **start of cycle**.
    
* If we reach null → no cycle.
    

```java
class Solution {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();

        ListNode curr = head;
        while (curr != null) {
            if (set.contains(curr)) {
                return curr; // cycle starts here
            }
            set.add(curr);
            curr = curr.next;
        }
        return null; // no cycle
    }
}
```

### 💠Time Complexity:

* O(N) (we visit each node once)
    

### 💠 Space Complexity:

* O(N) (HashSet to store visited nodes)
    

\=&gt; Downside: Extra memory usage. Interviewers might not like it.

### 2️⃣ Optimal Approach

### 📍Idea:

We use **two pointers (slow & fast):**

1. **Detect cycle:**
    
    * Move slow by 1 step, fast by 2 steps.
        
    * If they meet → cycle exists.
        
    * If fast hits null → no cycle.
        
2. **Find starting node of cycle:**
    
    * Move one pointer back to head.
        
    * Now move both (slow & head) one step at a time.
        
    * The point where they meet again = start of cycle.
        

```java
class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        // Step 1: Detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) { // cycle detected
                // Step 2: Find start of cycle
                ListNode ptr1 = head;
                ListNode ptr2 = slow;

                while (ptr1 != ptr2) {
                    ptr1 = ptr1.next;
                    ptr2 = ptr2.next;
                }
                return ptr1; // starting node of cycle
            }
        }
        return null; // no cycle
    }
}
```

💠Time Complexity:

* Detect cycle = O(N)
    
* Find cycle start = O(N)  
    ➡️ Total = **O(N)**
    

💠 Space Complexity:

* **O(1)** (No extra memory used)
    

---

### 2️⃣ **Flattening a Linked List**

### 🔸 Problem Statement:

Given a linked list containing **n** head nodes where every node in the linked list contains two pointers:  
(i) **next** points to the next node in the list.  
(ii) **bottom** pointer to a sub-linked list where the current node is the head.  
Each of the sub-linked lists nodes and the head nodes are sorted in **ascending** order based on their data.  
Your task is to **flatten** the linked list such that all the nodes appear in a single level while maintaining the sorted order.

**Note:  
**1\. **↓** represents the bottom pointer and **\-&gt;** represents the next pointer.  
2. The flattened list will be printed using the **bottom** pointer instead of the next pointer.

**Examples:**

```plaintext
Input:

Output: 5-> 7-> 8-> 10 -> 19-> 20-> 22-> 28-> 30-> 35-> 40-> 45-> 50.
Explanation: 
Bottom pointer of 5 is pointing to 7.
Bottom pointer of 7 is pointing to 8.
Bottom pointer of 8 is pointing to 10 and so on.
```

```plaintext
Input:
 
Output: 5-> 7-> 8-> 10-> 19-> 22-> 28-> 30-> 50
Explanation:
Bottom pointer of 5 is pointing to 7.
Bottom pointer of 7 is pointing to 8.
Bottom pointer of 8 is pointing to 10 and so on.
```

**Constraints:**  
0 &lt;= n &lt;= 100  
1 &lt;= number of nodes in sub-linked list(m<sub>i</sub>) &lt;= 50  
1 &lt;= node-&gt;data &lt;= 10<sup>4</sup>

### 💠Real-Life Example

### Example 1: Stacks of Books

* Imagine each **head node = a stack of books (sorted by height)**.
    
* `bottom` = books inside each stack.
    
* `next` = next stack of books.  
    Flattening = merging all stacks into **one sorted pile of books** .
    

### Example 2: Grocery Shelves

* `next` = different racks in a grocery store.
    
* `bottom` = products stacked in sorted order (by price).  
    Flattening = arranging **all products in one big shelf sorted by price** .
    
    ## 1️⃣Brute Force Approach
    
    ### 📍Idea:
    
    1. Traverse the **next linked list**.
        
    2. Collect all values into an array/list.
        
    3. Sort the array.
        
    4. Rebuild the flattened linked list from this sorted array.
        

```java
class Solution {
    Node flatten(Node root) {
        List<Integer> list = new ArrayList<>();

        Node curr = root;
        // Step 1: Traverse horizontally
        while (curr != null) {
            Node temp = curr;
            // Step 2: Traverse vertically
            while (temp != null) {
                list.add(temp.data);
                temp = temp.bottom;
            }
            curr = curr.next;
        }

        // Step 3: Sort collected values
        Collections.sort(list);

        // Step 4: Rebuild flattened linked list
        Node dummy = new Node(0);
        Node newHead = dummy;

        for (int val : list) {
            newHead.bottom = new Node(val);
            newHead = newHead.bottom;
        }

        return dummy.bottom;
    }
}
```

**💠Time Complexity = O(K log K)**

**💠Space Complexity = O(K)**

### 2️⃣ Optimal Approach

### 📍 Idea:

We can use the **merge of two sorted lists** approach (like merge in MergeSort).

1. Start from the leftmost head node.
    
2. Recursively flatten the `next` list.
    
3. Merge current list (using `bottom`) with the already flattened list.
    
4. This way, no extra array or sorting is required.
    

```java
class Solution {
    Node merge(Node a, Node b) {
        if (a == null) return b;
        if (b == null) return a;

        Node result;
        if (a.data < b.data) {
            result = a;
            result.bottom = merge(a.bottom, b);
        } else {
            result = b;
            result.bottom = merge(a, b.bottom);
        }
        result.next = null; 
        return result;
    }
    Node flatten(Node root) {
        if (root == null || root.next == null) return root;

        // Step 1: Flatten the right side
        root.next = flatten(root.next);

        // Step 2: Merge current list with right flattened list
        root = merge(root, root.next);

        return root;
    }
}
```

**💠Time Complexity:** O(K)

**💠Space Complexity:** O(1) (auxiliary), O(H) recursion stack

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

![](https://cdn.hashnode.com/res/hashnode/image/upload/v1755771630494/097c4825-f182-462d-a61e-d3b09d7f5a26.jpeg align="center")

%[https://youtu.be/QfbOhn0WZ88] 

%[https://youtu.be/ysytSSXpAI0]
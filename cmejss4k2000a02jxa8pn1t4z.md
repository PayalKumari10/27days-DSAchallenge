---
title: "📅Day-17 Striver’s SDE Sheet | Linked List Part 2 | Reverse a LinkedList in groups of size k, Check if the given Linked List is Palindrome."
seoTitle: "Reverse and Check Linked List Palindrome"
seoDescription: "Explore Day 17 of a 27-day DSA journey, tackling linked list challenges: reverse k-group nodes and palindrome check. Learn Java solutions!"
datePublished: Wed Aug 20 2025 09:56:01 GMT+0000 (Coordinated Universal Time)
cuid: cmejss4k2000a02jxa8pn1t4z
slug: day-17-strivers-sde-sheet-linked-list-part-2-reverse-a-linkedlist-in-groups-of-size-k-check-if-the-given-linked-list-is-palindrome
cover: https://cdn.hashnode.com/res/hashnode/image/upload/v1755678338002/c2b77fbe-6a73-4072-917a-efdfec9997f8.png
ogImage: https://cdn.hashnode.com/res/hashnode/image/upload/v1755683262406/b0ed012f-9ef2-48f5-88a8-8ea258d09dda.png
tags: code, java, coding, hashnode, dsa, techblog, coding-challenge, codenewbies, coding-journey, dsainjava, dsa-series, striver-dsa-sheet, striversa2zdsa, payalkumari11, dsawithpayal

---

> ***Note : <mark>Started my 27-day DSA journey with Striver’s SDE Sheet!</mark>  
> <mark>I will be journaling every day</mark> <mark>— recording what I learn, reflecting on it, and sharing it with my network to help fellow learners</mark> <mark>and aspiring developers..</mark> <mark>Learning through videos, resources, and the internet — simplifying logic in my own way with real-world connections. Sharing 2 questions daily: brute-force to optimal, clean Java code, time &amp; space complexity, and key patterns.</mark>***

This blog series is for **anyone preparing for coding interviews** — whether you’re a beginner or a revision warrior. Let’s grow together! 🚀

## Namaste Developers! 🙏

**Welcome to Day 17 of my 27-day DSA journey using Striver’s SDE Sheet!**

### 1️⃣ **Reverse Nodes in k-Group**

Given the `head` of a linked list, reverse the nodes of the list `k` at a time, and return *the modified list*.

`k` is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of `k` then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.

**Example 1:**

![](https://assets.leetcode.com/uploads/2020/10/03/reverse_ex1.jpg align="left")

```plaintext
Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]
```

**Example 2:**

![](https://assets.leetcode.com/uploads/2020/10/03/reverse_ex2.jpg align="left")

```plaintext
Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]
```

**Constraints:**

* The number of nodes in the list is `n`.
    
* `1 <= k <= n <= 5000`
    
* `0 <= Node.val <= 1000`
    

**Follow-up:** Can you solve the problem in `O(1)` extra memory space?

## 💠Real Life Example

Think of a group of friends standing in a line .

* Photographer says: “Turn around in groups of **k**!”
    
* If `k=2`, every pair flips their position.
    
* If `k=3`, every 3 friends swap positions.
    
* If the last group has fewer than `k`, they just stay as they are (because photographer ka patience khatam).
    

(Hinglish : Socho ek group of friends line me khade hai.

Photographer bolta hai: “Turn around in groups of k!”

* Agar k = 2, toh har 2 dost apni jagah swap kar lenge.
    
* Agar k = 3, toh har 3 dost apni position ulat denge.
    
* Agar last wale group me k se kam dost bache, toh wo waisa hi reh jaata hai (kyunki photographer ka patience khatam ho gaya) ).
    
    ```java
    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null || k <= 1) return head;
    
            // Step 1: Traverse and store values in an ArrayList
            List<Integer> values = new ArrayList<>();
            ListNode curr = head;
            while (curr != null) {
                values.add(curr.val);
                curr = curr.next;
            }
    
            // Step 2: Reverse every chunk of k elements
            for (int i = 0; i + k <= values.size(); i += k) {
                reverseChunk(values, i, i + k - 1);
            }
    
            // Step 3: Rebuild the linked list with modified values
            curr = head;
            int index = 0;
            while (curr != null) {
                curr.val = values.get(index++);
                curr = curr.next;
            }
    
            return head;
        }
    
        // Helper method to reverse elements in array between l and r
        private void reverseChunk(List<Integer> arr, int l, int r) {
            while (l < r) {
                int temp = arr.get(l);
                arr.set(l, arr.get(r));
                arr.set(r, temp);
                l++;
                r--;
            }
        }
    }
    ```
    
    ### 📍Complexity :
    
    * **Time Complexity = O(N)**
        
    * **Space Complexity = O(N)**
        

### 💠Optimal Approach

This is the **real deal**. We reverse the nodes **by changing pointers**, not values.

Steps:

1. Count total nodes.
    
2. While there are at least `k` nodes left:
    
    * Reverse those `k` nodes using a standard linked list reversal technique.
        
    * Connect the reversed group back to the previous part.
        
    * Move ahead `k` steps and repeat.
        
    
    ```java
    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null || k == 1) return head;
    
            // Dummy node to simplify handling of head reversals
            ListNode dummy = new ListNode(0);
            dummy.next = head;
    
            ListNode prevGroupEnd = dummy;
            ListNode curr = head;
    
            while (true) {
                // Step 1: Check if we have at least k nodes left
                ListNode temp = curr;
                int count = 0;
                while (temp != null && count < k) {
                    temp = temp.next;
                    count++;
                }
                if (count < k) break; // not enough nodes, stop
    
                // Step 2: Reverse k nodes
                ListNode prev = null, next = null;
                ListNode groupStart = curr;
                for (int i = 0; i < k; i++) {
                    next = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = next;
                }
    
                // Step 3: Connect reversed group with rest of the list
                prevGroupEnd.next = prev;
                groupStart.next = curr;
                prevGroupEnd = groupStart;
            }
    
            return dummy.next;
        }
    }
    ```
    
    ### 📍Complexity :
    
    * **Time:** O(N) → Each node is visited once and reversed once.
        
    * **Space:** O(1) → In-place reversal, only a few pointers used.
        

(Hinglish : Soch lo ek line of friends khadi hai. Photographer bolta hai: *“Har group of k, ulta ho jao!”*

* Agar exact group milta hai → ulta kar do.
    
* Agar last group chhota hai → waisa hi rehne do.
    

👉 Brute force = **notebook mein likh ke ulta karna** (uses extra space).  
👉 Optimal approach = **bina likhe directly rotate karna** (only pointers change). )

---

### 2️⃣ **Palindrome Linked List**

Given the `head` of a singly linked list, return `true` *if it is a palindrome or* `false` *otherwise*.  
(**Palindrome :** A **palindrome** is a sequence that reads the same forward and backward.)

**Example 1:**

![](https://assets.leetcode.com/uploads/2021/03/03/pal1linked-list.jpg align="left")

```plaintext
Input: head = [1,2,2,1]
Output: true
```

**Example 2:**

![](https://assets.leetcode.com/uploads/2021/03/03/pal2linked-list.jpg align="left")

```plaintext
Input: head = [1,2]
Output: false
```

**Constraints:**

* The number of nodes in the list is in the range `[1, 10<sup>5</sup>]`.
    
* `0 <= Node.val <= 9`
    

**Follow up:**Could you do it in`O(n)`time and`O(1)`space?

### 💠Real-Life Example

Think of a **Palindrome Linked List** like a **Mirror**.

* Imagine writing a word on a **folded paper**.
    
* When you unfold it → the left side and right side must look the same for it to be palindrome.
    

🔹 Example:

* "RADAR" → Left = "RA", Right = "AR" (mirror hai, Palindrome).
    
* "HELLO" → Left = "HE", Right = "OL" (mirror nahi hai).
    

In Linked List, we can’t just directly "look at the end" (no backward traversal in singly list). That’s why we use the **reverse trick**.

### 1️⃣Brute Force Approach

### Idea:

1. Traverse the linked list → store values in an **Array/List**.
    
2. Check if the array is palindrome by comparing start and end.
    

```java
class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;

        // Step 1: Copy linked list into array
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }

        // Step 2: Check Palindrome
        int i = 0, j = list.size() - 1;
        while (i < j) {
            if (!list.get(i).equals(list.get(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
```

### **💠Complexity :**

* **Time Complexity:** `O(n)`
    
* **Space Complexity:** `O(n)`
    

### 2️⃣Optimal Approach

### 📍Idea:

We’ll use **Linked List tricks**:

1. **Find Middle** of the linked list (slow-fast pointer method).
    
2. **Reverse 2nd half** of the list.
    
3. Compare **1st half** and **2nd half**.
    
4. (Optional: Restore the list back to original)
    

```java
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        // Step 1: Find middle
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse 2nd half
        ListNode secondHalf = reverse(slow);

        // Step 3: Compare
        ListNode firstHalf = head;
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }

    // Function to reverse linked list
    private ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
```

### **💠Complexity :**

* **Time Complexity:** `O(n)`
    
* **Space Complexity:** `O(1)`
    

(Hinglish :

* Brute Force → "Array banao aur check karo palindrome hai ya nahi."
    
* Optimal → "Middle nikal lo → 2nd half reverse karo → dono half compare karo.")
    

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

![](https://cdn.hashnode.com/res/hashnode/image/upload/v1755683144297/342977d6-d63d-45ab-bd86-7be46159ec9f.jpeg align="center")

%[https://youtu.be/Of0HPkk3JgI] 

%[https://youtu.be/-DtNInqFUXs]
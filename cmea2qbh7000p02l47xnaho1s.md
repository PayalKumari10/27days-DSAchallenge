---
title: "📅Day-15 Striver’s SDE Sheet | Linked List Part 1 | Add Two Numbers , Delete Node in a Linked List."
seoTitle: "Linked List Challenges: Day 15 Solutions"
seoDescription: "Striver’s SDE Sheet Day 15 covers adding numbers in linked lists and efficient node deletion, crucial for coding interviews"
datePublished: Wed Aug 13 2025 14:36:51 GMT+0000 (Coordinated Universal Time)
cuid: cmea2qbh7000p02l47xnaho1s
slug: day-15-strivers-sde-sheet-linked-list-part-1-add-two-numbers-delete-node-in-a-linked-list
cover: https://cdn.hashnode.com/res/hashnode/image/upload/v1755083999621/ed8be2da-ec7b-4b5d-ad49-b07fb4dfaebb.png
ogImage: https://cdn.hashnode.com/res/hashnode/image/upload/v1755095760529/7f311abd-3fe5-4657-b96f-7c197f482af8.png
tags: code, java, technology, coding, hashnode, dsa, coding-challenge, codenewbies, coding-journey, codingnewbies, dsainjava, dsa-series, striver-dsa-sheet, payalkumari11, dsawithpayal

---

> ***Note : <mark>Started my 27-day DSA journey with Striver’s SDE Sheet!</mark>  
> <mark>I will be journaling every day</mark> <mark>— recording what I learn, reflecting on it, and sharing it with my network to help fellow learners</mark> <mark>and aspiring developers..</mark> <mark>Learning through videos, resources, and the internet — simplifying logic in my own way with real-world connections. Sharing 2 questions daily: brute-force to optimal, clean Java code, time &amp; space complexity, and key patterns.</mark>***

This blog series is for **anyone preparing for coding interviews** — whether you’re a beginner or a revision warrior. Let’s grow together! 🚀

## Namaste Developers! 🙏

**Welcome to Day 15 of my 27-day DSA journey using Striver’s SDE Sheet!**

## **1️⃣ Add Two Numbers**

### 🔸 Problem Statement:

You are given two **non-empty** linked lists representing two non-negative integers. The digits are stored in **reverse order**, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

**Example 1:**

![](https://assets.leetcode.com/uploads/2020/10/02/addtwonumber1.jpg align="left")

```plaintext
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
```

**Example 2:**

```plaintext
Input: l1 = [0], l2 = [0]
Output: [0]
```

**Example 3:**

```plaintext
Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
```

**Constraints:**

* The number of nodes in each linked list is in the range `[1, 100]`.
    
* `0 <= Node.val <= 9`
    
* It is guaranteed that the list represents a number that does not have leading zeros.
    

### 💠Real-Life Example

Think of it like **adding two really long numbers digit by digit**, the way we did in school.  
Just like in manual addition, we start from the units place (least significant digit), add them, and carry over to the next place if the sum is greater than 9.

(**Hinglish:**  
Jaise school me hum addition karte the — units place se start, carry lete hue tens place, fir hundreds place… waise hi yaha hum linked list ke nodes add karenge.)

## **💠Brute Force (Naive Thinking)**

### **📍 Idea**

* Convert both linked lists into numbers.
    
* Add the numbers.
    
* Convert the sum back into a linked list (in reverse order).
    

### **📍Steps :**

1. **Traverse l1 and build num1**
    
    * Har node ka value uthao aur string me prepend karo (reverse order maintain karne ke liye).
        
    * Example: `l1 = [2,4,3]` → `"342"` (string).
        
2. **Traverse l2 and build num2**
    
    * Same process l2 ke liye.
        
    * Example: `l2 = [5,6,4]` → `"465"`.
        
3. **Add both numbers**
    
    * Use `BigInteger` taaki large numbers handle ho sake without overflow.
        
    * Example: `342 + 465 = 807`.
        
4. **Convert sum to linked list in reverse order**
    
    * Sum ko string me convert karo.
        
    * Har digit ko reverse order me linked list me insert karo.
        
    * Example: `"807"` → `[7,0,8]`.
        

```java
import java.math.BigInteger;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Step 1: Convert l1 to string
        StringBuilder s1 = new StringBuilder();
        while (l1 != null) {
            s1.insert(0, l1.val); // prepend digit
            l1 = l1.next;
        }

        // Step 2: Convert l2 to string
        StringBuilder s2 = new StringBuilder();
        while (l2 != null) {
            s2.insert(0, l2.val); // prepend digit
            l2 = l2.next;
        }

        // Step 3: Use BigInteger to handle very large numbers
        BigInteger num1 = new BigInteger(s1.toString());
        BigInteger num2 = new BigInteger(s2.toString());
        BigInteger sum = num1.add(num2);

        // Step 4: Convert sum back to linked list
        String sumStr = sum.toString();
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int i = sumStr.length() - 1; i >= 0; i--) {
            curr.next = new ListNode(sumStr.charAt(i) - '0');
            curr = curr.next;
        }

        return dummy.next;
    }
}
```

### **📍Time Complexity**

* **O(n + m)** — n and m are lengths of l1 and l2.
    
* String building + BigInteger addition + final conversion.
    

### **📍 Space Complexity**

* **O(n + m)** — strings and linked list storage.
    

> **Note**:  
> (Hinglish : Yeh brute force hai kyunki hum pure number bana rahe hain aur phir add kar rahe hain — memory usage zyada hai aur linked list ke direct addition ka advantage lose ho jata hai.)

### 💠Optimal (Digit by Digit Addition)

### 📍Idea:

Instead of converting to integers, **add the digits node-by-node**, just like manual addition.

* Start from head of both lists (units place).
    
* Keep a **carry** variable.
    
* Create a new node for each sum’s digit.
    
* Move to next nodes until both lists are done and carry is 0.
    

### 📍Steps:

1. Initialize a dummy head and a `carry = 0`.
    
2. Loop while `l1` or `l2` or `carry` is not empty:
    
    * Take values from `l1` and `l2` (0 if null).
        
    * Sum = val1 + val2 + carry.
        
    * New digit = sum % 10, new carry = sum / 10.
        
    * Append to result list.
        
3. Return [`dummy.next`](http://dummy.next).
    

```java
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;
        
        while (l1 != null || l2 != null || carry != 0) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;
            
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        
        return dummy.next;
    }
}
```

### **📍Time Complexity**

* We traverse each node exactly once → **O(max(n, m))**
    

### **📍Space Complexity**

* Output linked list → **O(max(n, m))**
    

## 💠Key Takeaways

✅ **Brute Force** is simple but can overflow for big numbers.  
✅ **Optimal** is safer, faster, and works for very large inputs.  
✅ Always handle **carry** carefully.

---

### **2️⃣ Delete Node in a Linked List**

There is a singly-linked list `head` and we want to delete a node `node` in it.

You are given the node to be deleted `node`. You will **not be given access** to the first node of `head`.

All the values of the linked list are **unique**, and it is guaranteed that the given node `node` is not the last node in the linked list.

Delete the given node. Note that by deleting the node, we do not mean removing it from memory. We mean:

* The value of the given node should not exist in the linked list.
    
* The number of nodes in the linked list should decrease by one.
    
* All the values before `node` should be in the same order.
    
* All the values after `node` should be in the same order.
    

**Custom testing:**

* For the input, you should provide the entire linked list `head` and the node to be given `node`. `node` should not be the last node of the list and should be an actual node in the list.
    
* We will build the linked list and pass the node to your function.
    
* The output will be the entire list after calling your function.
    

**Example 1:**

![](https://assets.leetcode.com/uploads/2020/09/01/node1.jpg align="left")

```plaintext
Input: head = [4,5,1,9], node = 5
Output: [4,1,9]
Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.
```

**Example 2:**

![](https://assets.leetcode.com/uploads/2020/09/01/node2.jpg align="left")

```plaintext
Input: head = [4,5,1,9], node = 1
Output: [4,5,9]
Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.
```

**Constraints:**

* The number of the nodes in the given list is in the range `[2, 1000]`.
    
* `-1000 <= Node.val <= 1000`
    
* The value of each node in the list is **unique**.
    
* The `node` to be deleted is **in the list** and is **not a tail** node.
    

### 💠Real Life Example

Imagine you’re in a **relay race** 🏃‍♂️🏃‍♀️🏃‍♂️.  
You’re standing in the middle holding the baton (node).  
The person before you (previous node) is **not visible to you**.  
But you can still **pass the baton** to the next person ([node.next](http://node.next)).

So, instead of removing yourself, you **become the next runner** by:

* Taking their number (value)
    
* Pointing to their next runner ([node.next](http://node.next) = [node.next.next](http://node.next.next))
    

## **💠Brute ForceApproach**

Honestly, here **brute force doesn’t make sense** because:

* We **don’t have head** to traverse.
    
* We **must modify only this node**.
    

So, there’s no O(n) traversal approach here.

## 💠Optimal Approach

### **📍 Idea**

Instead of **removing this node directly** (which we can’t without the previous pointer),  
**copy the data** from the **next node** into the current node, then skip the next node.

```java
class Solution {
    public void deleteNode(ListNode node) {
        // Copy value of the next node into the current node
        node.val = node.next.val;
        // Skip over the next node
        node.next = node.next.next;
    }
}
```

## **💠Time & Space Complexity**

* **Time Complexity (TC)** → **O(1)**  
    Because we only modify the given node, no traversal.
    
* **Space Complexity (SC)** → **O(1)**  
    No extra data structure used.
    

(Hinglish : *"Yaha trick yeh hai ki tum apne next node ka data copy kar lo aur usko skip kar do. Bas! Tum delete bhi ho gaye aur list ka order bhi maintain raha. Interviewers iss question ko trap banate hain, par yeh actually 2-line ka kaam hai." )*

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

![](https://cdn.hashnode.com/res/hashnode/image/upload/v1755095527749/5c23e389-e278-4f4e-a572-ec8e64ad906e.jpeg align="center")

%[https://youtu.be/LBVsXSMOIk4] 

%[https://youtu.be/icnp4FJdZ_c]
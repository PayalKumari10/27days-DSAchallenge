---
title: "📅Week-2 (Day 3) - Understanding the Strategy Design Pattern with a Practical Example for Low-Level Design 👩‍💻"
seoTitle: "Strategy Design Pattern Guide"
seoDescription: "Explore the Strategy Design Pattern with real-life examples and practical uses in low-level system design"
datePublished: Thu May 22 2025 11:24:33 GMT+0000 (Coordinated Universal Time)
cuid: cmazabau7000u09jv0mkb2pef
slug: week-2-day-3-understanding-the-strategy-design-pattern-with-a-practical-example-for-low-level-design
cover: https://cdn.hashnode.com/res/hashnode/image/upload/v1747902476526/c49944dc-e4b6-48e5-81de-bf6f686f885e.png
ogImage: https://cdn.hashnode.com/res/hashnode/image/upload/v1747913000372/64927809-5a21-471e-b50d-3c76abd4b531.png
tags: blogging, java, technology, coding, tech, hashnode, system-design, dsa, coding-challenge, technical-writing-1, coding-journey, low-level-design, coderarmy, 8weekslldchallenge, payalkumari11

---

> ***NOTE: - <mark>I started my 8-week system design journey with Coder Army. I will be journaling every day, recording what I learn, reflecting on it, and sharing it with my network to help newcomers to system design.</mark>***

## 💠What is the Strategy Design Pattern?

*Defines a family of algorithms, puts them into separate classes so that they can be changed at run time.*

**"Strategy Pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable. It lets the algorithm vary independently from clients that use it."**

(Hindi: **Strategy Pattern ek family of algorithms define karta hai, har ek algorithm ko alag se encapsulate karta hai, aur unhe interchangeable banata hai. Isse algorithms ko bina client code change kiye easily change kiya ja sakta hai.**)

📍 In simple words: It's like having different ways to solve a problem and being able to switch between those ways easily!

📍**Real-Life Example:**  
Think of Google Maps 🗺️ – when you enter a location, it shows:

* 🚗 Driving route
    
* 🚶 Walking path
    
* 🚴‍♀️ Cycling option
    
* 🚌 Public transport
    

You choose one based on your need, but the destination remains the same.  
Each of these is a *strategy*, and Google Maps is the *context* that uses them.

**(Hindi : Jaise Google Maps mein aap route select karte ho – car, paidal, cycle ya bus – yeh sab alag-alag strategies hain jo same destination tak pahuchne ke liye hoti hain.)**

## 💠Why & When to Use Strategy Pattern?

✅ When you have many similar algorithms (behaviors)  
✅ When you want to **switch algorithms at runtime**  
✅ When you want to follow **SOLID principles** (especially OCP – Open/Closed Principle)

📍 Problem with Inheritance:

* Code re-use becomes complex
    
* Adding new features becomes painful
    
* Violates Open/Closed Principle (OCP)
    

(Hindi : **"Inheritance mein baar-baar changes karne padte hain, naye features add karne mein dikkat aati hai, aur code baar-baar break hota hai."**)

## 💠How to Implement It Using Clean OOP Principles?

Step 1: Create an interface (common behavior)  
Step 2: Write separate classes for different algorithms  
Step 3: Use composition to inject behavior into the main class  
Step 4: Switch strategy as needed

```java
interface PaymentStrategy {
  void pay(int amount);
}

class CreditCardPayment implements PaymentStrategy {
  public void pay(int amount) { System.out.println("Paid via Credit Card"); }
}

class UpiPayment implements PaymentStrategy {
  public void pay(int amount) { System.out.println("Paid via UPI"); }
}

class ShoppingCart {
  private PaymentStrategy strategy;
  public void setPaymentStrategy(PaymentStrategy strategy) { this.strategy = strategy; }
  public void checkout(int amount) { strategy.pay(amount); }
}
```

Now you can switch between `CreditCardPayment` or `UpiPayment` easily!

## 💠Real-Life Scenario You Can Relate To

### Designing Flexible Robots for a Smart Home 🏠

Imagine you are building different types of **robots** for a **smart home system** – each robot has **different capabilities** like:

* 🚶 Walking
    
* 🗣️ Talking
    
* 🛫 Flying
    

But **not all robots need all abilities**!  
For example:

* *Companion Robot* (for kids or elderly): Can **walk** and **talk**, but doesn't fly.
    
* *Worker Robot* (used in factories): Can **fly** (e.g., drone-based) but **cannot walk or talk**.
    

### 📍Problem Without Strategy Pattern

If you used *inheritance only*, you’d end up with:

* Long class hierarchies
    
* Lots of **duplicate code**
    
* Difficulty in **changing a feature without breaking others**
    

Every time you want a new behavior (e.g., *silent mode*, *hovering*), you’d have to **change the parent class or create multiple subclasses**, which is **not scalable**.

### ✅ Solution with Strategy Pattern

With **Strategy Design Pattern**, you can:

1. **Encapsulate each behavior** (walk, talk, fly) as separate classes
    
2. Assign behaviors to robots dynamically
    
3. Add or change behaviors **without modifying existing robot classes**
    

### 📍Code Walkthrough & Explanation

* #### CompanionRobot:
    

```java
Robot robot1 = new CompanionRobot(new NormalWalk(), new NormalTalk(), new NoFly());
```

📝 Meaning: This robot can walk and talk normally but **cannot fly**.

* #### WorkerRobot:
    

```java
Robot robot2 = new WorkerRobot(new NoWalk(), new NoTalk(), new NormalFly());
```

📝 Meaning: This robot **only flies** and cannot walk or talk. Useful for industrial tasks!

### 📍Dynamic Behavior Switching

What if your robot **upgrades** in the future?

You don’t need to change the class! Just set a new strategy:

```java
robot1.flyBehavior = new NormalFly(); // Now CompanionRobot can fly!
```

**"Ab aap apne purane robot mein naya fly wala feature add kar sakte ho bina kisi major change ke."**

![](https://cdn.hashnode.com/res/hashnode/image/upload/v1756233245001/7e7feffd-81c0-4c29-b56d-f254b852bd1b.png align="center")

### 📍Why It’s Useful

✅ Helps you **code to interface** not implementation  
✅ Follows **Open/Closed Principle** – open for extension, closed for modification  
✅ Super useful in **LLD interviews** and real-world systems like:

* Game character behavior switching
    
* AI chatbot customization
    
* E-commerce discount strategy
    
    ![](https://cdn.hashnode.com/res/hashnode/image/upload/v1756234038559/16ab515f-8eb9-42a9-ae92-18f056e3849f.png align="center")
    

## 📍Key Takeaways

🔹 Encapsulate what varies – **Rakho alag jo badalta rehta hai.**  
🔹 Don’t solve inheritance issues by adding more inheritance  
🔹 Code to **interfaces**, not **implementations**  
🔹 DRY: Don’t Repeat Yourself!

```java
// --- Strategy Interface for Walk ---
interface WalkableRobot {
    void walk();
}

// --- Concrete Strategies for walk ---
class NormalWalk implements WalkableRobot {
    public void walk() {
        System.out.println("Walking normally...");
    }
}

class NoWalk implements WalkableRobot {
    public void walk() {
        System.out.println("Cannot walk.");
    }
}

// --- Strategy Interface for Talk ---
interface TalkableRobot {
    void talk();
}

// --- Concrete Strategies for Talk ---
class NormalTalk implements TalkableRobot {
    public void talk() {
        System.out.println("Talking normally...");
    }
}

class NoTalk implements TalkableRobot {
    public void talk() {
        System.out.println("Cannot talk.");
    }
}

// --- Strategy Interface for Fly ---
interface FlyableRobot {
    void fly();
}

class NormalFly implements FlyableRobot {
    public void fly() {
        System.out.println("Flying normally...");
    }
}

class NoFly implements FlyableRobot {
    public void fly() {
        System.out.println("Cannot fly.");
    }
}

// --- Robot Base Class ---
abstract class Robot {
    protected WalkableRobot walkBehavior;
    protected TalkableRobot talkBehavior;
    protected FlyableRobot flyBehavior;

    public Robot(WalkableRobot w, TalkableRobot t, FlyableRobot f) {
        this.walkBehavior = w;
        this.talkBehavior = t;
        this.flyBehavior = f;
    }

    public void walk() {
        walkBehavior.walk();
    }

    public void talk() {
        talkBehavior.talk();
    }

    public void fly() {
        flyBehavior.fly();
    }

    public abstract void projection(); // Abstract method for subclasses
}

// --- Concrete Robot Types ---
class CompanionRobot extends Robot {
    public CompanionRobot(WalkableRobot w, TalkableRobot t, FlyableRobot f) {
        super(w, t, f);
    }

    public void projection() {
        System.out.println("Displaying friendly companion features...");
    }
}

class WorkerRobot extends Robot {
    public WorkerRobot(WalkableRobot w, TalkableRobot t, FlyableRobot f) {
        super(w, t, f);
    }

    public void projection() {
        System.out.println("Displaying worker efficiency stats...");
    }
}

// --- Main Function ---
public class StrategyDesignPattern {
    public static void main(String[] args) {
        Robot robot1 = new CompanionRobot(new NormalWalk(), new NormalTalk(), new NoFly());
        robot1.walk();
        robot1.talk();
        robot1.fly();
        robot1.projection();

        System.out.println("--------------------");

        Robot robot2 = new WorkerRobot(new NoWalk(), new NoTalk(), new NormalFly());
        robot2.walk();
        robot2.talk();
        robot2.fly();
        robot2.projection();
    }
}
```

### **Week - 2 (Day 3) Completed ✅ System Design**

> ***NOTE : - A big thanks to my mentors*** [***<mark>Rohit Negi</mark> <mark>Sir</mark>***](https://www.linkedin.com/in/rohit-negi9/) ***and*** [***<mark>Aditya</mark>*** ***<mark>Sir</mark>*** ***fo***](https://www.linkedin.com/in/adityatandon2/)***r launching this amazing <mark>8-week course</mark> absolutely <mark>free</mark> on YouTube via <mark>CoderArmy9 </mark> :-*** [***youtube.com/@CoderArmy9***](http://youtube.com/@CoderArmy9) [***. 🙌***](https://www.youtube.com/@CoderArmy9)

👉 **Share this blog with your connections!** Let’s keep learning, growing, and supporting one another on this journey. 🚀

✍️ [***Payal Kumari***](https://www.linkedin.com/in/payalkumari10/) 👩‍💻 [**Github**](https://github.com/PayalKumari10)

[![](https://cdn.hashnode.com/res/hashnode/image/upload/v1747838984908/a4ff2e93-c7a8-4f69-93bf-975d78a4885a.jpeg align="center")](https://www.linkedin.com/in/payalkumari10/)

**Jai Hind 🇮🇳 | #CoderArmy #LearningInPublic #SystemDesign #TechForAll #MentorshipMatters** [**#8weeksLLdChallenge**](https://www.youtube.com/hashtag/8weekslldchallenge) [**#LowLevelDesign** **#Code #LLD**](https://www.youtube.com/hashtag/8weekslldchallenge) [**#OOP**](https://www.youtube.com/hashtag/lowleveldesign)

%[https://youtu.be/PpKvPrl_gRg?si=aYteFePudVPJ1UFz]
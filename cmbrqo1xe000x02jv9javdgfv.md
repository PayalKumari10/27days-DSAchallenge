---
title: "📅Week-5 (Day-2) - Understanding the Chain of Responsibility Pattern: Building a Cash Dispenser with UML and Code"
seoTitle: "Chain of Responsibility: Cash Dispenser Design"
seoDescription: "Build a cash dispenser using the Chain of Responsibility Pattern with UML and code, exploring system design through real-world examples"
datePublished: Wed Jun 11 2025 09:19:54 GMT+0000 (Coordinated Universal Time)
cuid: cmbrqo1xe000x02jv9javdgfv
slug: week-5-day-2-understanding-the-chain-of-responsibility-pattern-building-a-cash-dispenser-with-uml-and-code
cover: https://cdn.hashnode.com/res/hashnode/image/upload/v1749630919037/af155d0e-a1b1-4b5a-b1fd-80e377a2a4b6.jpeg
ogImage: https://cdn.hashnode.com/res/hashnode/image/upload/v1749633545432/8a0898b6-8445-4aaf-9a4f-497300b1de93.jpeg
tags: cpp, code, java, technology, coding, hashnode, system-design, dsa, coding-challenge, coding-journey, low-level-design, lld, coderarmy, 8weekslldchallenge, payalkumari11

---

> ***NOTE: - <mark>I started my 8-week system design journey with Coder Army. I will be journaling every day, recording what I learn, reflecting on it, and sharing it with my network to help newcomers to system design.</mark>***

## 💠 What is Chain of Responsibility Pattern?

The **Chain of Responsibility Pattern** allows an object to **pass a request** along a chain of potential handlers. Each handler decides whether to **process the request** or **pass it to the next one**.

(Hindi: Chain of Responsibility Pattern ek aisa behavioral pattern hai jisme request ek chain ke through pass hoti hai. Har node decide karta hai ki request ka response dena hai ya aage bhejna hai.)

📍 **Definition:** Allow an object to pass a request along a chain of potential handlers. Each handler in the chain either processes the request or passes it to the next handler.

## 💠 Real-Life Analogy: Cash Dispenser ATM

Let’s say you want to withdraw ₹3,800 from an ATM. The machine:

* First tries ₹2000 handler
    
* Then ₹500 handler
    
* Then ₹100 handler
    

Each note handler checks: *"Can I dispense this amount?"* and if yes, it does and passes on the rest.

➡️ This is exactly how Chain of Responsibility works!

(Hindi: ATM jab ₹3800 deta hai, toh pehle ₹2000 ke note, phir ₹500, phir ₹100 ke note nikalta hai — ek chain ke through.)

![]( align="center")

![](https://cdn.hashnode.com/res/hashnode/image/upload/v1749632837848/9a0d7124-9f3e-4046-af11-87ac80f01596.png align="center")

```java
abstract class MoneyHandler {
    protected MoneyHandler nextHandler;

    public MoneyHandler() {
        this.nextHandler = null;
    }

    public void setNextHandler(MoneyHandler next) {
        this.nextHandler = next;
    }

    public abstract void dispense(int amount);
}

class ThousandHandler extends MoneyHandler {
    private int numNotes;

    public ThousandHandler(int numNotes) {
        this.numNotes = numNotes;
    }

    @Override
    public void dispense(int amount) {
        int notesNeeded = amount / 1000;

        if (notesNeeded > numNotes) {
            notesNeeded = numNotes;
            numNotes = 0;
        } else {
            numNotes -= notesNeeded;
        }

        if (notesNeeded > 0)
            System.out.println("Dispensing " + notesNeeded + " x ₹1000 notes.");

        int remainingAmount = amount - (notesNeeded * 1000);
        if (remainingAmount > 0) {
            if (nextHandler != null) nextHandler.dispense(remainingAmount);
            else {
                System.out.println("Remaining amount of " + remainingAmount + " cannot be fulfilled (Insufficinet fund in ATM)");
            }
        }
    }
}

class FiveHundredHandler extends MoneyHandler {
    private int numNotes;

    public FiveHundredHandler(int numNotes) {
        this.numNotes = numNotes;
    }

    @Override
    public void dispense(int amount) {
        int notesNeeded = amount / 500;

        if (notesNeeded > numNotes) {
            notesNeeded = numNotes;
            numNotes = 0;
        } else {
            numNotes -= notesNeeded;
        }

        if (notesNeeded > 0)
            System.out.println("Dispensing " + notesNeeded + " x ₹500 notes.");

        int remainingAmount = amount - (notesNeeded * 500);
        if (remainingAmount > 0) {
            if (nextHandler != null) nextHandler.dispense(remainingAmount);
            else {
                System.out.println("Remaining amount of " + remainingAmount + " cannot be fulfilled (Insufficinet fund in ATM)");
            }
        }
    }
}

class TwoHundredHandler extends MoneyHandler {
    private int numNotes;

    public TwoHundredHandler(int numNotes) {
        this.numNotes = numNotes;
    }

    @Override
    public void dispense(int amount) {
        int notesNeeded = amount / 200;

        if (notesNeeded > numNotes) {
            notesNeeded = numNotes;
            numNotes = 0;
        } else {
            numNotes -= notesNeeded;
        }

        if (notesNeeded > 0)
            System.out.println("Dispensing " + notesNeeded + " x ₹200 notes.");

        int remainingAmount = amount - (notesNeeded * 200);
        if (remainingAmount > 0) {
            if (nextHandler != null) nextHandler.dispense(remainingAmount);
            else {
                System.out.println("Remaining amount of " + remainingAmount + " cannot be fulfilled (Insufficinet fund in ATM)");
            }
        }
    }
}

class HundredHandler extends MoneyHandler {
    private int numNotes;

    public HundredHandler(int numNotes) {
        this.numNotes = numNotes;
    }

    @Override
    public void dispense(int amount) {
        int notesNeeded = amount / 100;

        if (notesNeeded > numNotes) {
            notesNeeded = numNotes;
            numNotes = 0;
        } else {
            numNotes -= notesNeeded;
        }

        if (notesNeeded > 0)
            System.out.println("Dispensing " + notesNeeded + " x ₹100 notes.");

        int remainingAmount = amount - (notesNeeded * 100);
        if (remainingAmount > 0) {
            if (nextHandler != null) nextHandler.dispense(remainingAmount);
            else {
                System.out.println("Remaining amount of " + remainingAmount + " cannot be fulfilled (Insufficinet fund in ATM)");
            }
        }
    }
}

public class COR {
    public static void main(String[] args) {
        MoneyHandler thousandHandler = new ThousandHandler(3);
        MoneyHandler fiveHundredHandler = new FiveHundredHandler(5);
        MoneyHandler twoHundredHandler = new TwoHundredHandler(10);
        MoneyHandler hundredHandler = new HundredHandler(20);

        thousandHandler.setNextHandler(fiveHundredHandler);
        fiveHundredHandler.setNextHandler(twoHundredHandler);
        twoHundredHandler.setNextHandler(hundredHandler);

        int amountToWithdraw = 4000;

        System.out.println("\nDispensing amount: ₹" + amountToWithdraw);
        thousandHandler.dispense(amountToWithdraw);
    }
}
```

## 💠 Real-World Design Use Case: Logger System

Logging systems also use Chain of Responsibility:

* 🔹 **InfoLogger** → Handles general messages
    
* 🔸 **DebugLogger** → Debug info
    
* 🔴 **ErrorLogger** → Logs critical issues
    

Depending on the log level, the request is passed and handled accordingly.

(Hindi: Jaise system mein different level ke log hotey hain — Info, Debug, Error — toh request ko sahi logger tak pass kiya jata hai.)

## 📝 Homework: Leave Request System (Employee Leave Flow)

### Scenario:

* 2 Days Leave → Handled by Team Lead
    
* 5 Days Leave → Handled by Manager
    
* More → Forwarded to Director
    

![](https://cdn.hashnode.com/res/hashnode/image/upload/v1749633292125/3bcd29c3-221f-4879-935f-b0bd87264021.png align="center")

```java
interface LeaveApprover {
    void setNext(LeaveApprover next);
    void approveLeave(int days);
}

class TeamLead implements LeaveApprover {
    private LeaveApprover next;
    public void setNext(LeaveApprover next) { this.next = next; }
    public void approveLeave(int days) {
        if (days <= 2) System.out.println("TeamLead approved leave for " + days + " days");
        else next.approveLeave(days);
    }
}
```

(Hindi: Agar leave 2 din ka hai toh Team Lead approve karega, agar zyada hai toh Manager ya Director approve karega.)

## 💠Benefits of Chain of Responsibility Pattern

* **Decouples sender and receiver**
    
* **Flexible and scalable**
    
* **Easy to add or remove handlers**
    
* **Clean separation of concerns**
    

## 💠Summary

* **Chain of Responsibility kya karta hai?**
    

> Request ko ek chain ke through forward karta hai jab tak uska handler mil jaye.

*ATM*, *Logger*, *Leave Request* — sab mein yeh pattern useful hai.

### **Week - 5 (Day-2) Completed ✅ System Design**

> ***NOTE : - A big thanks to my mentors <mark>Rohit Negi</mark> <mark>Sir </mark> and*** [***<mark>Aditya</mark>***](https://www.linkedin.com/in/adityatandon2/) [***<mark>Sir</mark> fo***](https://www.linkedin.com/in/adityatandon2/)***r launching this amazing <mark>8-week course</mark> absolutely <mark>free</mark> on YouTube via <mark>CoderArmy9 </mark> :-*** [***youtube.com/@CoderArmy9***](http://youtube.com/@CoderArmy9) [***. 🙌***](https://www.youtube.com/@CoderArmy9)

👉 **Share this blog with your connections!** Let’s keep learning, growing, and supporting one another on this journey. 🚀

✍️ [***Payal Kumari***](https://www.linkedin.com/in/payalkumari10/) 👩‍💻

![](https://cdn.hashnode.com/res/hashnode/image/upload/v1749633344625/92845077-6d27-443d-9f52-8af59e98014b.jpeg align="center")

**Jai Hind 🇮🇳 | #CoderArmy #LearningInPublic #SystemDesign #TechForAll #MentorshipMatters** [**#8weeksLLdChallenge**](https://www.youtube.com/hashtag/8weekslldchallenge) [**#LowLevelDesign**](https://www.youtube.com/hashtag/lowleveldesign) [**#LLD**](https://www.youtube.com/hashtag/lld) **👩‍💻**

%[https://youtu.be/LXVKB6deQMo?si=64jwVsf0GOFgSSIj]
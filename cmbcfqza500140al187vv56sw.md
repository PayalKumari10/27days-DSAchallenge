---
title: "📅Week -3 (Day-4) - How to Design Your Own Notification Engine: A Step-by-Step Guide."
seoTitle: "Design Your Own Notification Engine Guide"
seoDescription: "Learn how to design a notification engine, covering architecture, types, patterns, and real-life examples for effective message delivery"
datePublished: Sat May 31 2025 16:17:42 GMT+0000 (Coordinated Universal Time)
cuid: cmbcfqza500140al187vv56sw
slug: week-3-day-4-how-to-design-your-own-notification-engine-a-step-by-step-guide
cover: https://cdn.hashnode.com/res/hashnode/image/upload/v1748697807868/b553ceec-7545-437b-a382-6401934b154c.png
ogImage: https://cdn.hashnode.com/res/hashnode/image/upload/v1748708205043/2b4ff10f-2b54-4738-9ab8-c9a4f3241b8c.png
tags: cpp, blogging, java, technology, coding, system-design, dsa, techblog, coding-challenge, coding-journey, lld, coderarmy, lowleveldesign, 8weekslldchallenge, payalkumari11

---

> ***NOTE: - <mark>I </mark>*** <mark>started my 8-week system design journey with Coder Army. I will be journaling every day, recording what I learn, reflecting on it, and sharing it with my network to help newcomers to system design.</mark>

## 💠What is a Notification Engine?

A Notification Engine is like a smart postman that delivers messages to users via **Email, SMS, or Push Notifications**, based on their preferences and triggers.

(Hindi : Notification Engine ek smart postman ki tarah hota hai, jo users tak unke pasand ke mutabiq **Email, SMS, ya Push Notification** ke zariye message pahuchata hai.)

> **"Agar aap ek Notification System bana sakte hain, to aap kisi bhi Scalable System ki neev samajh sakte hain!"**

## 💠What You’ll Learn in This System Design Module

## ✅ End-to-End Architecture of Notification System

Learn how to structure the entire engine from scratch, like a blueprint of a house.

**Real-life Example:**  
Zomato needs to notify you: “Your order is out for delivery” — this engine decides *what*, *when*, and *how* to send it.

## 💠Multiple Notification Types Support:

* 📩 **Email**
    
* 📱 **SMS**
    
* 🔔 **Push Notifications**
    

**Real-life Example :**  
Netflix might send an email for a subscription reminder, an SMS for account activity, and a push notification for a new series drop.

**(Hindi:** Netflix aapko subscription ke liye email bhejta hai, SMS ke zariye account activity batata hai, aur naye series release hone par push notification deta hai.)

## 💠Real-time Logging of Notifications

Every notification sent is logged — like a delivery tracker.

**(Example:** If an OTP SMS fails, the system logs it, helping teams debug it fast.)

### 💠Design Patterns You’ll Implement:

* **Observer Pattern** –  
    When one part changes (like order status), others (like the SMS system) react.  
    **Real-life analogy:** You follow someone on Instagram, and get notified when they post.
    
* **Strategy Pattern** –  
    Choose how to send notification (SMS or Email) at runtime.  
    **Analogy:** Like choosing your transport method: bike for short trips, flight for long ones.
    
* **Decorator Pattern** –  
    Add extra features like “High Priority” or “Retry on Fail” without changing core code.  
    **Analogy:** Adding toppings to your pizza —base remains same!
    
* **Singleton Pattern** –  
    Only one Notification Manager exists, controlling everything.  
    **Analogy:** Like a Prime Minister — one center of control.
    
    ## 💠UML Class Diagrams to visualize and structure the system
    

![](https://cdn.hashnode.com/res/hashnode/image/upload/v1757444272164/0c59fc63-b15c-4a91-8942-c14c50fabd3e.png align="center")

or

![](https://cdn.hashnode.com/res/hashnode/image/upload/v1748707806579/97712b66-c4e8-45b6-91dd-c74cef50aa59.jpeg align="center")

```java
// Java version of the given C++ Notification System code

import java.util.*;

/*============================
      Notification & Decorators
=============================*/

interface INotification {
    String getContent();
}

// Concrete Notification: simple text notification.
class SimpleNotification implements INotification {
    private String text;

    public SimpleNotification(String msg) {
        this.text = msg;
    }

    public String getContent() {
        return text;
    }
}

// Abstract Decorator: wraps a Notification object.
abstract class INotificationDecorator implements INotification {
    protected INotification notification;

    public INotificationDecorator(INotification n) {
        this.notification = n;
    }
}

// Decorator to add a timestamp to the content.
class TimestampDecorator extends INotificationDecorator {
    public TimestampDecorator(INotification n) {
        super(n);
    }

    public String getContent() {
        return "[2025-04-13 14:22:00] " + notification.getContent();
    }
}

// Decorator to append a signature to the content.
class SignatureDecorator extends INotificationDecorator {
    private String signature;

    public SignatureDecorator(INotification n, String sig) {
        super(n);
        this.signature = sig;
    }

    public String getContent() {
        return notification.getContent() + "\n-- " + signature + "\n\n";
    }
}

/*============================
  Observer Pattern Components
=============================*/

// Observer interface: each observer gets an update with a Notification pointer.
interface IObserver {
    void update();
}

interface IObservable {
    void addObserver(IObserver observer);
    void removeObserver(IObserver observer);
    void notifyObservers();
}

// Concrete Observable
class NotificationObservable implements IObservable {
    private List<IObserver> observers = new ArrayList<>();
    private INotification currentNotification = null;

    public void addObserver(IObserver obs) {
        observers.add(obs);
    }

    public void removeObserver(IObserver obs) {
        observers.remove(obs);
    }

    public void notifyObservers() {
        for (IObserver obs : observers) {
            obs.update();
        }
    }

    public void setNotification(INotification notification) {
        this.currentNotification = notification;
        notifyObservers();
    }

    public INotification getNotification() {
        return currentNotification;
    }

    public String getNotificationContent() {
        return currentNotification.getContent();
    }
}

/*============================
       NotificationService
=============================*/

// The NotificationService manages notifications. It keeps track of notifications. 
// Any client code will interact with this service.

// Singleton class
class NotificationService {
    private NotificationObservable observable;
    private static NotificationService instance = null;
    private List<INotification> notifications = new ArrayList<>();

    private NotificationService() {
        observable = new NotificationObservable();
    }

    public static NotificationService getInstance() {
        if (instance == null) {
            instance = new NotificationService();
        }
        return instance;
    }

    // Expose the observable so observers can attach.
    public NotificationObservable getObservable() {
        return observable;
    }

    // Creates a new Notification and notifies observers.
    public void sendNotification(INotification notification) {
        notifications.add(notification);
        observable.setNotification(notification);
    }
}

/*============================
       ConcreteObservers
=============================*/
class Logger implements IObserver {
    private NotificationObservable notificationObservable;

    public Logger() {
        this.notificationObservable = NotificationService.getInstance().getObservable();
        notificationObservable.addObserver(this);
    }

    public Logger(NotificationObservable observable) {
        notificationObservable.addObserver(this);
        this.notificationObservable = observable;
    }

    public void update() {
        System.out.println("Logging New Notification : \n" + notificationObservable.getNotificationContent());
    }
}

/*============================
  Strategy Pattern Components (Concrete Observer 2)
=============================*/

interface INotificationStrategy {
    void sendNotification(String content);
}

class EmailStrategy implements INotificationStrategy {
    private String emailId;

    public EmailStrategy(String emailId) {
        this.emailId = emailId;
    }

    public void sendNotification(String content) {
        // Simulate the process of sending an email notification, 
        // representing the dispatch of messages to users via email.​
        System.out.println("Sending email Notification to: " + emailId + "\n" + content);
    }
}

class SMSStrategy implements INotificationStrategy {
    private String mobileNumber;

    public SMSStrategy(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void sendNotification(String content) {
        // Simulate the process of sending an SMS notification, 
        // representing the dispatch of messages to users via SMS.​
        System.out.println("Sending SMS Notification to: " + mobileNumber + "\n" + content);
    }
}

class PopUpStrategy implements INotificationStrategy {
    public void sendNotification(String content) {
        // Simulate the process of sending popup notification.
        System.out.println("Sending Popup Notification: \n" + content);
    }
}

class NotificationEngine implements IObserver {
    private NotificationObservable notificationObservable;
    private List<INotificationStrategy> notificationStrategies = new ArrayList<>();

    public NotificationEngine() {
        this.notificationObservable = NotificationService.getInstance().getObservable();
        notificationObservable.addObserver(this);
    }

    public NotificationEngine(NotificationObservable observable) {
        this.notificationObservable = observable;
    }

    public void addNotificationStrategy(INotificationStrategy ns) {
        this.notificationStrategies.add(ns);
    }

    // Can have RemoveNotificationStrategy as well.

    public void update() {
        String notificationContent = notificationObservable.getNotificationContent();
        for (INotificationStrategy strategy : notificationStrategies) {
            strategy.sendNotification(notificationContent);
        }
    }
}

public class NotificationSystemUpdated {
    public static void main(String[] args) {

        // Create NotificationService.
        NotificationService notificationService = NotificationService.getInstance();

        // Create Logger Observer
        Logger logger = new Logger();

        // Create NotificationEngine observers.
        NotificationEngine notificationEngine = new NotificationEngine();

        notificationEngine.addNotificationStrategy(new EmailStrategy("random.person@gmail.com"));
        notificationEngine.addNotificationStrategy(new SMSStrategy("+91 9876543210"));
        notificationEngine.addNotificationStrategy(new PopUpStrategy());

        INotification notification = new SimpleNotification("Your order has been shipped!");
        notification = new TimestampDecorator(notification);
        notification = new SignatureDecorator(notification, "Customer Care");

        notificationService.sendNotification(notification);
    }
}
```

### **Week - 3 (Day 4) Completed ✅ System Design**

> ***NOTE : - A big thanks to my mentors <mark>Rohit Negi</mark> <mark>Sir </mark> and*** [***<mark>Aditya</mark>***](https://www.linkedin.com/in/adityatandon2/) [***<mark>Sir</mark> fo***](https://www.linkedin.com/in/adityatandon2/)***r launching this amazing <mark>8-week course</mark> absolutely <mark>free</mark> on YouTube via <mark>CoderArmy9 </mark> :-*** [***https://www.youtube.com/@CoderArmy9***](https://www.youtube.com/@CoderArmy9) [***. 🙌***](https://www.youtube.com/@CoderArmy9)

👉 **Share this blog with your connections!** Let’s keep learning, growing, and supporting one another on this journey. 🚀

✍️ [*Payal Kumari*](https://www.linkedin.com/in/payalkumari10/) 👩‍💻

![](https://cdn.hashnode.com/res/hashnode/image/upload/v1748701983759/4d4ae6a2-40ea-477c-aad8-28b60c7dc8b3.jpeg align="center")

**Jai Hind 🇮🇳 | #CoderArmy #LearningInPublic #SystemDesign #TechForAll #MentorshipMatters** [**#8weeksLLdChallenge**](https://www.youtube.com/hashtag/8weekslldchallenge) [**#LowLevelDesign**](https://www.youtube.com/hashtag/lowleveldesign) #Code [**#LLD**](https://www.youtube.com/hashtag/lld) **#OOP** **👩‍💻**

%[https://youtu.be/t-4r2AsJz_Q?si=LFfBiYK1FZ1CZBAR]
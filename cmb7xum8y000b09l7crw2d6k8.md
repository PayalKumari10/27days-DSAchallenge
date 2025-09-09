---
title: "📅Week-3 (Day-2) - Understanding the Observer Design Pattern: Real-Life Applications and Code"
seoTitle: "Observer Pattern: Applications and Implementation"
seoDescription: "Explore the Observer Design Pattern with real-life examples, understand its pros and cons, and learn to apply it in system design"
datePublished: Wed May 28 2025 12:45:34 GMT+0000 (Coordinated Universal Time)
cuid: cmb7xum8y000b09l7crw2d6k8
slug: week-3-day-2-understanding-the-observer-design-pattern-real-life-applications-and-code
cover: https://cdn.hashnode.com/res/hashnode/image/upload/v1748426191324/7e5118a5-7ee8-4799-aaba-5b0af23112b1.png
ogImage: https://cdn.hashnode.com/res/hashnode/image/upload/v1748436269721/12c9a130-e2cc-40a4-93d1-c357c8c714aa.png
tags: blogging, technology, coding, hashnode, system-design, dsa, techblog, coding-challenge, technical-writing-1, coding-journey, low-level-design, lld, coderarmy, 8weekslldchallenge, payalkumari11

---

> ***NOTE: - <mark>I started my 8-week system design journey with Coder Army. I will be journaling every day, recording what I learn, reflecting on it, and sharing it with my network to help newcomers to system design.</mark>***

## 💠 What is the Observer Design Pattern?

The **Observer Pattern** defines a **one-to-many relationship** between objects.  
➡️ When **one object changes its state**, all its **dependents (observers)** are **automatically notified** and updated.

**(Hindi: Observer Pattern ek aisa design pattern hai jisme ek object ke badlav hone par kai aur objects ko turant pata chal jaata hai aur woh update ho jaate hain.)**

## 💠 Real-World Examples (Observer Pattern in Real Life)

### 1\. **YouTube Channel & Subscribers**

You **subscribe** to a YouTube channel.  
Whenever the creator uploads a new video, you get a **notification**.

📍 **Here’s the mapping:**

* Channel = **Subject (Observable)**
    
* Subscribers = **Observers**
    

When the subject (channel) updates, all registered observers (subscribers) are notified!

**(Hindi: Jab aap kisi YouTube channel ko subscribe karte ho, aur naya video aata hai toh aapko notification milta hai. Yehi observer pattern hai!)**

📍 **Unsubscribe Logic**:  
👉 If a user **unsubscribes**, they are **removed** from the observer list.  
So, they **won’t receive any further notifications** from that channel.

**That’s how the Observer Pattern handles dynamic subscriptions!**

**(Hindi: Agar aap YouTube se unsubscribe karte hain, toh us channel ka koi update ya notification aapko nahi milta. Kyunki ab aap observer list mein nahi ho!)**

### 2\. **Notification Services (Tech Example)**

* WhatsApp chats
    
* Email alerts
    
* Instagram DMs
    

All of them follow **Observer Pattern**!

Whenever there's **new activity**, your app (observer) gets **instantly notified** by the backend service (subject).  
But if you **disable notifications** or **mute the chat**, your device **stops receiving updates** — just like removing the observer from the list.

**(Hindi: WhatsApp group ko mute karna ya Insta notifications off karna matlab observer pattern mein observer ko hata dena.)**

### 3\. **Event Listeners in Programming**

* You add a **click listener** to a button.
    
* When the button is clicked, it **triggers an event** (callback function runs).
    

```java
button.addEventListener("click", handleClick);  // Subscribe (Observer added)

button.removeEventListener("click", handleClick);  // Unsubscribe (Observer removed)
```

This is the most relatable example for **front-end devs**:

> The button is being **observed**, and clicking it **triggers a handler**. Remove the listener and nothing happens on click!

**(Hindi: Yahan button observer pattern ka example hai. Jab tak listener hai, tab tak click hone par kaam hota hai. Listener hata diya, toh kuch nahi hoga.)**

### 💠 Java Code: YouTube Channel & Subscribers :

```java
interface Observer { 
    void update(String message);
}

class Subscriber implements Observer {
    private String name;

    Subscriber(String name) {
        this.name = name;
    }

    public void update(String message) {
        System.out.println(name + " received: " + message);
    }
}

class YouTubeChannel {
    private List<Observer> subscribers = new ArrayList<>();

    void subscribe(Observer obs) {
        subscribers.add(obs); // Observer added (Subscribe)
    }

    void unsubscribe(Observer obs) {
        subscribers.remove(obs); // Observer removed (Unsubscribe)
    }

    void notifyAll(String message) {
        for (Observer obs : subscribers) {
            obs.update(message); // Notifying all current subscribers
        }
    }
}
```

> "When you subscribe to a channel, you start receiving updates. When you unsubscribe, the updates stop."

You can call `subscribe()` and `unsubscribe()` methods to **dynamically control notifications**.

## 💠 Use in Real Projects like YouTube

* Building your **own Notification System**
    
* Using **Webhooks**, **Realtime Events**, or **Pub/Sub Architecture**
    
* Event-driven microservices
    

Example : <mark>"Jab ek user new blog publish karta hai (like on Hashnode), sab followers ko email ya app notification milta hai."</mark>

## ✅ Pros of Observer Pattern

* Decouples Subject & Observer
    
* Real-time updates
    
* Scales well for many listeners
    

## ❌ Cons (SRP Violation)

* Subject class becomes **heavy** (has to manage many observers)
    
* **Breaking SRP** (Single Responsibility Principle) if not separated well
    

**(Hindi: Agar observer logic ko alag class mein na rakha jaye toh main class kaafi complex ho jaata hai.)**

![](https://cdn.hashnode.com/res/hashnode/image/upload/v1757420369847/02c9f157-5da9-445d-b948-d74265e42d21.png align="center")

```java

import java.util.ArrayList;
import java.util.List;

interface ISubscriber {
    void update();
}

// Observable interface: a YouTube channel interface
interface IChannel {
    void subscribe(ISubscriber subscriber);
    void unsubscribe(ISubscriber subscriber);
    void notifySubscribers();
}

// Concrete Subject: a YouTube channel that observers can subscribe to
class Channel implements IChannel {
    private List<ISubscriber> subscribers;
    private String name;
    private String latestVideo;

    public Channel(String name) {
        this.name = name;
        this.subscribers = new ArrayList<>();
    }

    @Override
    public void subscribe(ISubscriber subscriber) {
        if (!subscribers.contains(subscriber)) {
            subscribers.add(subscriber);
        }
    }

    @Override
    public void unsubscribe(ISubscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers() {
        for (ISubscriber sub : subscribers) {
            sub.update();
        }
    }

    public void uploadVideo(String title) {
        latestVideo = title;
        System.out.println("\n[" + name + " uploaded \"" + title + "\"]");
        notifySubscribers();
    }

    public String getVideoData() {
        return "\nCheckout our new Video : " + latestVideo + "\n";
    }
}

// Concrete Observer: represents a subscriber to the channel
class Subscriber implements ISubscriber {
    private String name;
    private Channel channel;

    public Subscriber(String name, Channel channel) {
        this.name = name;
        this.channel = channel;
    }

    @Override
    public void update() {
        System.out.println("Hey " + name + "," + channel.getVideoData());
    }
}

public class ObserverDesignPattern {
    public static void main(String[] args) {
        // Create a channel and subscribers
        Channel channel = new Channel("CoderArmy");

        Subscriber subs1 = new Subscriber("Varun", channel);
        Subscriber subs2 = new Subscriber("Tarun", channel);

        // Varun and Tarun subscribe to CoderArmy
        channel.subscribe(subs1);
        channel.subscribe(subs2);

        // Upload a video: both Varun and Tarun are notified
        channel.uploadVideo("Observer Pattern Tutorial");

        // Varun unsubscribes; Tarun remains subscribed
        channel.unsubscribe(subs1);

        // Upload another video: only Tarun is notified
        channel.uploadVideo("Decorator Pattern Tutorial");
    }
}
```

## 💠Final Thoughts

**Observer Pattern is everywhere** – from notifications to live updates.  
🔄 Whenever you want to **automatically inform others** when something changes — think **Observer Pattern**.

👉 Use it wisely, break into modular code, and you’ll be building **scalable systems** just like YouTube, WhatsApp, and Amazon!

**(Hindi: Jab kisi system mein automatic update ka feature chahiye, tab Observer pattern perfect hota hai!)**

### **Week - 3 (Day 2) Completed ✅ System Design**

> ***NOTE : - A big thanks to my mentors*** [***<mark>Rohit Negi</mark> <mark>Sir</mark>***](https://www.linkedin.com/in/rohit-negi9/) ***and*** [***<mark>Aditya</mark> <mark>Sir</mark> fo***](https://www.linkedin.com/in/adityatandon2/)***r launching this amazing <mark>8-week course</mark> absolutely <mark>free</mark> on YouTube via <mark>CoderArmy9 </mark> :-*** [***youtube.com/@CoderArmy9***](http://youtube.com/@CoderArmy9) [***. 🙌***](https://www.youtube.com/@CoderArmy9)

👉 **Share this blog with your connections!** Let’s keep learning, growing, and supporting one another on this journey. 🚀

✍️ [***Payal Kumari***](https://www.linkedin.com/in/payalkumari10/) 👩‍💻 [**Github**](https://github.com/PayalKumari10)

Follow me : [**X**](https://x.com/PayalKumar89652)

![](https://cdn.hashnode.com/res/hashnode/image/upload/v1748436073039/9dd87855-0554-4eb2-95ff-35a4f457dc59.jpeg align="center")

**Jai Hind 🇮🇳 | #CoderArmy #LearningInPublic #SystemDesign #TechForAll #MentorshipMatters** [**#8weeksLLdChallenge**](https://www.youtube.com/hashtag/8weekslldchallenge) [**#LowLevelDesign**](https://www.youtube.com/hashtag/lowleveldesign) [**#LLD**](https://www.youtube.com/hashtag/lld)

%[https://youtu.be/Jpmp4GY8r3Q?si=JE-hy2jh4zMa-dDd]
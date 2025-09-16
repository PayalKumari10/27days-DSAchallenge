---
title: "📅Week-5 (Day -1) - Understanding the Proxy Design Pattern: Virtual, Protection, and Remote Proxies Explained"
seoTitle: "Proxy Design Pattern: Virtual, Protection, Remote"
seoDescription: "Learn Proxy Design Pattern: Virtual, protection, and remote proxies with real-world examples and benefits. Ideal for system design understanding"
datePublished: Tue Jun 10 2025 12:01:24 GMT+0000 (Coordinated Universal Time)
cuid: cmbqgzvss000o02jyd9zr7v3e
slug: week-5-day-1-understanding-the-proxy-design-pattern-virtual-protection-and-remote-proxies-explained
cover: https://cdn.hashnode.com/res/hashnode/image/upload/v1749552766053/08aedf13-a61f-4f35-aa13-7e171c8806bc.jpeg
ogImage: https://cdn.hashnode.com/res/hashnode/image/upload/v1749556847009/1f451ff4-e855-4408-8f8a-e2050bf51699.jpeg
tags: cpp, code, java, technology, coding, system-design, dsa, coding-challenge, technical-writing-1, coding-journey, low-level-design, lld, coderarmy, 8weekslldchallenge, payalkumari11

---

> ***NOTE: - <mark>I started my 8-week system design journey with Coder Army. I will be journaling every day, recording what I learn, reflecting on it, and sharing it with my network to help newcomers to system design.</mark>***

---

## 💠 What is the Proxy Design Pattern?

The **Proxy Pattern** provides a **surrogate** or **placeholder** for another object to **control access** to it. It’s like a personal assistant who filters or manages your meetings. ☎️🙅‍♂️

(Hindi: Proxy Pattern ek aisa design pattern hai jo kisi object ke liye ek representative ya agent banata hai — jo us object ka access control karta hai.)

## 💠 Why Do We Need a Proxy?

* Sometimes, **direct access** to an object is **too expensive, unsafe, or just not possible**.
    
* Proxies help in handling:
    
    * 💰 Expensive resource usage
        
    * 🔐 Security and protection
        
    * 🌍 Remote objects access
        

## 💠 Types of Proxy

### 1️⃣ **Virtual Proxy** – Lazy Loading

**Use Case:** Delays the creation of an expensive object until it’s needed.

> *Example:* Imagine a photo gallery app. You don’t want to load all high-res images at once — instead, use a proxy that loads them when scrolled into view.
> 
> (Hindi: Agar koi image bahut heavy hai toh usse turant load karne ke bajaye tab load karo jab user use dekhe — yeh kaam karta hai virtual proxy.)

![](https://cdn.hashnode.com/res/hashnode/image/upload/v1758021069413/453cdafe-1fbf-436b-b104-4fb830eece55.png align="center")

```java
interface IImage {
    void display();
}

class RealImage implements IImage {
    private String filename;

    public RealImage(String file) {
        this.filename = file;
        System.out.println("[RealImage] Loading image from disk: " + filename);
    }

    @Override
    public void display() {
        System.out.println("[RealImage] Displaying " + filename);
    }
}

class ImageProxy implements IImage {
    private RealImage realImage;
    private String filename;

    public ImageProxy(String file) {
        this.filename = file;
        this.realImage = null;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}

public class VirtualProxy {
    public static void main(String[] args) {
        IImage image1 = new ImageProxy("sample.jpg");
        image1.display();
    }
}
```

### 2️⃣ **Protection Proxy** – Access Control

**Use Case:** Controls access to sensitive objects based on permissions.

> *Example:* Admin dashboard. Only admins can delete data — others can only view. Protection Proxy checks user role before allowing actions.
> 
> (Hindi: Jaise bank ke admin panel mein sirf authorised log hi kuch edit kar sakte hain — normal users nahi. Yeh kaam karta hai protection proxy.)

![](https://cdn.hashnode.com/res/hashnode/image/upload/v1749556038151/9f1da216-11e8-41c2-954b-26e3d1fa4755.png align="center")

```java
interface IDocumentReader {
    void unlockPDF(String filePath, String password);
}

class RealDocumentReader implements IDocumentReader {
    @Override
    public void unlockPDF(String filePath, String password) {
        System.out.println("[RealDocumentReader] Unlocking PDF at: " + filePath);
        System.out.println("[RealDocumentReader] PDF unlocked successfully with password: " + password);
        System.out.println("[RealDocumentReader] Displaying PDF content...");
    }
}

class User {
    public String name;
    public boolean premiumMembership;

    public User(String name, boolean isPremium) {
        this.name = name;
        this.premiumMembership = isPremium;
    }
}

class DocumentProxy implements IDocumentReader {
    private RealDocumentReader realReader;
    private User user;

    public DocumentProxy(User user) {
        this.realReader = new RealDocumentReader();
        this.user = user;
    }

    @Override
    public void unlockPDF(String filePath, String password) {
        if (!user.premiumMembership) {
            System.out.println("[DocumentProxy] Access denied. Only premium members can unlock PDFs.");
            return;
        }
        realReader.unlockPDF(filePath, password);
    }
}

public class ProtectionProxy {
    public static void main(String[] args) {
        User user1 = new User("Rohan", false);
        User user2 = new User("Rashmi", true);

        System.out.println("== Rohan (Non-Premium) tries to unlock PDF ==");
        IDocumentReader docReader = new DocumentProxy(user1);
        docReader.unlockPDF("protected_document.pdf", "secret123");

        System.out.println("\n== Rashmi (Premium) unlocks PDF ==");
        docReader = new DocumentProxy(user2);
        docReader.unlockPDF("protected_document.pdf", "secret123");
    }
}
```

### 3️⃣ **Remote Proxy** – Object Over the Internet

**Use Case:** Represents an object that exists remotely (e.g., on a different server).

> *Example:* When your app calls an API hosted in the US while you're in India. The Remote Proxy acts as a local placeholder.
> 
> (Hindi: Jaise Zoom call mein aapka friend US mein hai, lekin aap usse proxy ke through local screen par dekh rahe ho.)

![](https://cdn.hashnode.com/res/hashnode/image/upload/v1758021152527/ace070ca-ac81-46f3-a7ee-8680e9006d18.png align="center")

```java
interface IDataService {
    String fetchData();
}

class RealDataService implements IDataService {
    public RealDataService() {
        // Imagine this connects to a remote server or loads heavy resources.
        System.out.println("[RealDataService] Initialized (simulating remote setup)");
    }

    @Override
    public String fetchData() {
        return "[RealDataService] Data from server";
    }
}

// Remote proxy
class DataServiceProxy implements IDataService {
    private RealDataService realService;

    public DataServiceProxy() {
        realService = new RealDataService();
    }

    @Override
    public String fetchData() {
        System.out.println("[DataServiceProxy] Connecting to remote service...");
        return realService.fetchData();
    }
}

public class RemoteProxy {
    public static void main(String[] args) {
        IDataService dataService = new DataServiceProxy();
        dataService.fetchData();
    }
}
```

## 💠Real-World Use Cases

* 🎮 Lazy loading in games (Virtual Proxy)
    
* 🔐 Secure APIs or Admin UIs (Protection Proxy)
    
* 🛰️ Remote object communication (Remote Proxy)
    

(Hindi: Proxy ka use har jagah hota hai — APIs, games, secure dashboards, aur remote connections mein!)

![](https://cdn.hashnode.com/res/hashnode/image/upload/v1749556320523/42bb3f12-8f8e-4423-bbea-f9df4afd09ba.png align="center")

## 💠 Benefits of Proxy Pattern

* Lazy initialization of heavy resources
    
* Improved security and access control
    
* Enables distributed computing
    
* Cleaner client-side code
    

## 💠Recap

**Proxy Pattern kya karta hai?**

> Kisi object ka access control karta hai ek mediator ya representative ke through.

**Types of Proxy**

1. Virtual Proxy → Jab zarurat ho tab load karo
    
2. Protection Proxy → Sirf authorized users ko access do
    
3. Remote Proxy → Door ke object ko local bana do
    

(Hindi: Proxy Pattern ek aise concept hai jo aapke project ko smart aur efficient banata hai.)

### **Week - 5 (Day-1) Completed ✅ System Design**

> ***NOTE : - A big thanks to my mentors <mark>Rohit Negi</mark> <mark>Sir </mark> and*** [***<mark>Aditya</mark>***](https://www.linkedin.com/in/adityatandon2/) [***<mark>Sir</mark> fo***](https://www.linkedin.com/in/adityatandon2/)***r launching this amazing <mark>8-week course</mark> absolutely <mark>free</mark> on YouTube via <mark>CoderArmy9 </mark> :-*** [***youtube.com/@CoderArmy9***](http://youtube.com/@CoderArmy9) [***. 🙌***](https://www.youtube.com/@CoderArmy9)

👉 **Share this blog with your connections!** Let’s keep learning, growing, and supporting one another on this journey. 🚀

✍️ [***Payal Kumari***](https://www.linkedin.com/in/payalkumari10/) 👩‍💻

![](https://cdn.hashnode.com/res/hashnode/image/upload/v1749236575540/027ca7b3-20ef-4970-a0b7-d48f766e447f.jpeg?auto=compress,format&format=webp align="left")

**Jai Hind 🇮🇳 | #CoderArmy #LearningInPublic #SystemDesign #TechForAll #MentorshipMatters** [**#8weeksLLdChallenge**](https://www.youtube.com/hashtag/8weekslldchallenge) [**#LowLevelDesign #Code #LLD**](https://www.youtube.com/hashtag/8weekslldchallenge) [**#OOP**](https://www.youtube.com/hashtag/lowleveldesign)

%[https://youtu.be/xuT6OOYVJTQ?si=G9yFTF-RQ4M7OVqx]
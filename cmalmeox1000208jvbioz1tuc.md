---
title: "📅Week-1 (Day 1) - Introduction to System Design: LLD vs DSA vs HLD 🔥👩‍💻"
seoTitle: "My System Design Journey : Real-Life LLD Example You’ll Never Forget"
seoDescription: "🚀 Curious about how System Design works in real life?
In this blog, I share my Day 1 learnings from an 8-week journey into System Design."
datePublished: Mon May 12 2025 21:54:20 GMT+0000 (Coordinated Universal Time)
cuid: cmalmeox1000208jvbioz1tuc
slug: day-1-introduction-to-system-design-lld-vs-dsa-vs-hld
canonical: https://www.linkedin.com/in/payalkumari10/
cover: https://cdn.hashnode.com/res/hashnode/image/upload/v1747075028095/b875e93d-95cc-4c07-89a8-2d308d83b63f.jpeg
ogImage: https://cdn.hashnode.com/res/hashnode/image/upload/v1747086227997/1f5c43a4-fb31-48cb-9fd9-bc68f54abc61.jpeg
tags: java, developer, system-design, dsa, techblog, technical-writing-1, lld, dsa-series, coderarmy, lowleveldesign, 8weekslldchallenge, payal11, payalkumari11

---

> NOTE: - ***<mark>Today marks the beginning of my 8-week System Design journey with Coder Army. I'm journaling each day to capture what I learn, reflect on it, and share it with my network to help others who are new to system design.</mark>***

---

## 💠**What is System Design ?**

**System Design** refers to the process of designing day-to-day tech-based systems that power our applications and services.

(Hindi: "System Design" ka matlab hai roz ke technology-based systems ko design karna, jo hamare applications aur services ko chalaate hain.)

## 💠What is LLD ?

**LLD (Low-Level Design)** involves taking various concepts from data structures and algorithms (DSA) to build the complete structure of an application. It focuses on the detailed implementation, including how each component interacts and functions.

(Hindi: LLD ka matlab hai, "Low-Level Design." Ye wo process hai jismein multiple DSA ke concepts ka istemal karke poore application ka structure tayar kiya jata hai. Yani, application ke har component ke design aur unke interaction ko detail mein define kiya jata hai.)

[![](https://cdn.hashnode.com/res/hashnode/image/upload/v1747078210265/245c6400-12cb-46d5-9d83-d4f3654f3bee.png align="center")](https://www.linkedin.com/in/payalkumari10/)

* ## **💠 A Real-World Example:**
    

### 📍 Meet Anmol and Ritesh

Two college friends, **Anmol** and **Ritesh**, just graduated and joined tech companies as software developers. Both are smart and hardworking, but there’s a small difference:

* **Anmol** has good **DSA knowledge**, but no exposure to LLD.
    
* **Ritesh** knows both **DSA** and **LLD**.
    

### 📍 The Task: Build a “Quick Ride” App (like Ola/Uber)

Their manager gives them the task to design a simple ride-sharing system — similar to Quick Ride. Here's what happened:

### Case 1: Anmol’s Approach (Only DSA)

Anmol immediately thinks like a coder. He solves it like a DSA problem.

* Step 1: Select **source → destination**
    
* Step 2: Implement a **queue** to match **users with riders**, using a priority system.
    

He builds it quickly using algorithms and data structures. Great!

But when he presents it to the manager, he's asked:

> "Where is the system design? Can you tell me about:
> 
> * The objects involved?
>     
> * How components talk to each other?
>     
> * How you’ll handle data security?
>     
> * What happens if 1 million users use this?"
>     

Anmol is confused. He solved the algorithm part, but **missed the bigger picture**.

### Case 2: Ritesh’s Approach (LLD + DSA)

Ritesh takes a step back and **thinks like a designer**, not just a coder.

He first identifies the key **objects/entities**:

* User
    
* Rider
    
* Location
    
* Notification
    
* Payment
    

Then he designs the **relationships**:

* A rider can be a user too
    
* A ride has a source & destination
    
* Payments are linked to users & rides
    

He considers:

* **Data Security**
    
* **Modular structure**
    
* **Scalability** (millions of users)
    
* **Notifications**
    
* **Payments**
    

And **only after this**, he uses DSA where needed: for queuing, pathfinding, etc.

### 📍Moral of the Story

> * **DSA helps you write efficient code.**
>     
> * **LLD helps you think like a software engineer.**
>     

In the real world, **systems aren't built with just algorithms**. You need to know:

* How to design components
    
* How data flows
    
* How parts interact
    
* How to build for scale
    

So always try to go from **LLD → DSA**, not the other way around.

---

## 💠LLD (Low Level Design) - Key Concepts

1. **Scalability (No. of Users Sustains) : -**  
    LLD helps ensure that your system can handle more users without crashing.
    
    (Hindi : Jaise jaise users badhte hain, system ko smoothly chalna chahiye. )
    
2. **Maintainability (Easily Debuggable) : -**  
    A good LLD design makes it easy to debug and fix issues.
    
    (Hindi : Agar code easily maintainable hoga, toh future me bugs fix karna aur improvements lana simple hoga.)
    
3. **Reusability (Plug and Play Model) : -**  
    A well-designed system allows you to reuse code.
    

(Hindi : Matlab, agar aap code ko kisi aur app me daalna chahein, toh usme zyada changes nahi karne padenge — bas plug and play.)

**a) Tightly Coupled** means components are highly dependent on each other.

(Hindi : Iska matlab hai, agar aap code ko reuse karna chahenge, toh aapko bohot saare changes karne padenge, jo reusability ko difficult bana dete hain.)

b) **Loosely Coupled** means components are independent and don't rely heavily on each other.

(Hindi : Iska matlab hai, agar aap code ko reuse karna chahenge, toh aapko bohot kam changes karne padenge, making it easier to reuse across different apps.)

---

## 💠**What is NOT LLD ?**

Low-Level Design (LLD) focuses on the detailed design and implementation of individual components, but **High-Level Design (HLD)** is different. HLD looks at the overall system architecture and planning. Let's break down what HLD includes:

1. **Tech Stack (Java, Spring Boot, etc.) : -**  
    HLD decides on the technology stack for your project — for example, Java with Spring Boot, or Node.js with Express. It defines the framework and programming languages you'll use for building the system.
    
    (Hindi : HLD aapke project ke liye tech stack decide karta hai — jaise Java with Spring Boot ya Node.js with Express. Yeh define karta hai ki aap kis framework aur programming languages ka use karenge system banane ke liye.)
    
2. Database (SQL or NoSQL, etc.) : -
    
    HLD determines which type of database to use — whether you need SQL databases (like MySQL) for structured data or NoSQL (like MongoDB) for unstructured data. It helps in deciding how data will be stored and accessed at a high level.
    
    (Hindi : HLD yeh decide karta hai ki kaunsa database use karna hai — kya aapko SQL databases (jaise MySQL) chahiye structured data ke liye, ya NoSQL (jaise MongoDB) chahiye unstructured data ke liye. Yeh decide karta hai ki data kaise store aur access hoga system ke high level par.)
    
3. Server Scale : -
    
    In HLD, you decide how your system will scale. Meaning, if you handle millions of users, how will you scale the server - load balancing, cloud services, etc. It is all about making sure your system can handle as much traffic as needed.
    
    (Hindi : HLD mein aap decide karte hain ki aapka system kaise scale karega. Matlab, agar aapko millions of users handle karne hain, toh aapko kaise server scale karna hoga — load balancing, cloud services, etc. Yeh ensure karta hai ki aapka system zyada traffic ko handle kar sake.)
    
4. **Cost Optimization : -**
    
    HLD also includes cost optimization. It determines how the system cost will increase or decrease depending on the user. If you have to use cloud services, you use them in a cost-efficient manner.
    
    (Hindi : HLD mein cost optimization bhi hota hai. Yeh decide karta hai ki user ke hisaab se system ka cost kaise increase ya decrease hoga. Agar aap cloud services ka use kar rahe hain, toh aap unko cost-effective tareeke se use karte hain.)
    

---

> NOTE : - ***<mark>DSA is the brain of an Application , LLD is the skeleton.</mark>***

[![](https://cdn.hashnode.com/res/hashnode/image/upload/v1747084097297/67fd5f76-3092-439c-bf41-0fddb24b0e43.png align="center")](https://www.linkedin.com/in/payalkumari10/)

---

### **Day 1 Completed ✅ System Design**

> NOTE : - A big thanks to my mentors **<mark>Rohit Negi</mark>** **<mark>Sir </mark>** and [**<mark>Aditya</mark>**](https://www.linkedin.com/in/adityatandon2/) **<mark>Sir</mark>** for launching this amazing **<mark>8-week course</mark>** absolutely **<mark>free</mark>** on YouTube via **<mark>CoderArmy9 </mark> :-** [https://www.youtube.com/@CoderArmy9](https://www.youtube.com/@CoderArmy9) . 🙌

🗓️ **Course Start Date:** 12th May 2025  
🎥 **Watch Here:** [CoderArmy9](https://youtu.be/AK0hu0Zxua4?si=jDeCCKTZok-nNKa6) – don’t forget to **subscribe**!  
🏆 **Exciting Hackathon**: Prizes worth ₹1 Lakh!  
📜 **Completion Certificate** will be provided at the end.

This initiative makes high-quality learning **accessible and affordable for everyone**, and I’m truly grateful to be a part of it. 🙏

**<mark>From today, I’ve officially taken the challenge to learn consistently and help others along the way. 🌱</mark>**

Let’s build, grow, and support each other through this journey.

✍️ [Payal Kumari](https://www.linkedin.com/in/payalkumari10/) 👩‍💻

Follow me : [X](https://x.com/PayalKumar89652)

[![](https://cdn.hashnode.com/res/hashnode/image/upload/v1747086407177/f6a72a8c-4722-4ecf-8f22-04f6fda91286.jpeg align="center")](https://www.linkedin.com/in/payalkumari10/)

**Jai Hind 🇮🇳 | #CoderArmy #LearningInPublic #SystemDesign #TechForAll #MentorshipMatters** [**#8weeksLLdChallenge**](https://www.youtube.com/hashtag/8weekslldchallenge) [**#LowLevelDesign**](https://www.youtube.com/hashtag/lowleveldesign) [**#LLD**](https://www.youtube.com/hashtag/lld) **👩‍💻**

%[https://youtu.be/AK0hu0Zxua4?si=ATAx-cO-CPTeWTiq]
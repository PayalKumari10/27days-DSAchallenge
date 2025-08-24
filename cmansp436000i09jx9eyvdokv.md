---
title: "📅Week 1 (Day 2) -  Real-World Examples of OOP Concepts: Understanding Abstraction and Encapsulation 🔥👩‍💻"
seoTitle: "OOP Concepts: Understanding Abstraction and Encapsulation"
seoDescription: "Learn the core Object-Oriented Programming concepts of Abstraction and Encapsulation with real-world examples."
datePublished: Wed May 14 2025 10:25:56 GMT+0000 (Coordinated Universal Time)
cuid: cmansp436000i09jx9eyvdokv
slug: day-2-real-world-examples-of-oop-concepts-understanding-abstraction-and-encapsulation
cover: https://cdn.hashnode.com/res/hashnode/image/upload/v1747218039812/65621c59-2e38-40d3-a30d-48ab6ff7efb1.png
ogImage: https://cdn.hashnode.com/res/hashnode/image/upload/v1747218151220/fdbf8442-6933-4526-9867-9955ebec0c92.png
tags: code, development, developer, hashnode, oops, system-design, object-oriented-programming, dsa, techblog, technical-writing-1, lld, systemdesign, coderarmy, 8weekslldchallenge

---

> ***NOTE: - <mark>I </mark>*** <mark>started my 8-week system design journey with Coder Army. I will be journaling every day, recording what I learn, reflecting on it, and sharing it with my network to help newcomers to system design.</mark>

## 💠 What is Programming Language Evolution?

Programming language evolution refers to how software languages have developed over time—from machine-level binary codes to modern object-oriented structures—to better model real-world problems, improve developer productivity, and reduce errors.

(Hindi: Programming language evolution ka matlab hai software bhashao ka vikas, jismein machine level binary code se lekar modern object-oriented languages tak ka safar shamil hai. Isse developers ko complex problems solve karne mein aasani hoti hai aur error bhi kam hoti hai.)

---

## 1\. Machine Language (Binary: 0s and 1s)

In the earliest days, programmers wrote code using binary digits (0 and 1). These were direct CPU instructions.

📌 Example:  
0100101  
1100101

📌 Drawbacks:

* Extremely error-prone – One wrong bit and the whole program breaks.  
    (Hindi: Bahut zyada galti hone ki sambhavana – ek bit ki galti se pura program kharab ho jata tha.)
    
* Tedious to write and maintain.  
    (Hindi: Likhna aur maintain karna mushkil tha.)
    
* No abstraction – Programmer had to manage every single detail.  
    (Hindi: Koi abstraction nahi thi – har chhoti detail manually manage karni padti thi.)
    

📌 Real-Life Analogy:  
It’s like trying to build a house by only using Morse code instructions without any blueprint.

## 2\. Assembly Language

To simplify things, Assembly Language introduced mnemonics (like MOV, ADD, SUB). These were symbolic instructions that directly mapped to machine language.

📌 Example:  
MOV A, 61h

📌 Drawbacks:

* Still hardware-dependent – Changing CPU meant rewriting code.  
    (Hindi: Ab bhi hardware ke upar depend tha – CPU badalne par code bhi badalna padta tha.)
    
* No structured logic like loops or functions.  
    (Hindi: Loop ya function jaise structure nahi the.)
    
* Poor scalability – Only worked well for small systems.  
    (Hindi: Sirf chhote system ke liye theek tha – large systems mein fail.)
    

📌 Real-Life Analogy:  
Imagine giving cooking instructions in your native language but still needing to tell every little action—no shortcuts or reusable steps.

## 3\. Procedural Programming (Structured Programming)

As systems grew complex, languages like C introduced structured programming: loops, functions, and conditional statements like if-else, switch.

📌 Example:  
void cook() {  
boilWater();  
addRice();  
stir();  
}

### 💠 Features Introduced:

* ### Functions for code reuse
    
    (Hindi: Code ko baar-baar use karne ke liye functions aaye.)
    
* Control Structures: if-else, loops  
    (Hindi: Decision making aur repetition ke liye control structures aaye jaise if-else, for loop.)
    
* Better readability and debugging  
    (Hindi: Code padhna aur debug karna aasaan hua.)
    

### 💠 Limitations:

* Poor real-world modeling: Couldn’t directly model entities like “User,” “Driver,” or “Payment.”  
    (Hindi: Complex systems jaise ride-booking app mein user, driver jaise real-world objects ko model karna mushkil tha.)
    
* No data security – Everything was globally visible.  
    (Hindi: Data security ka issue tha – sab kuch globally accessible tha.)
    

### 💠 Real-Life Analogy:

You can cook multiple recipes using a recipe book (functions), but you still have no way to store who is the chef or assign kitchen roles (objects, permissions).

📌 Why It Matters?

Understanding these older paradigms helps us appreciate the Object-Oriented Programming (OOPs) approach that solves many of these issues — like abstraction, encapsulation, and modularity — enabling us to build scalable, maintainable software.

(Hindi: In purani programming styles ko samajhne se humein pata chalta hai ki Object-Oriented Programming kyun zaruri hai – yeh problems ka better solution deti hai.)

---

## 💠 What is Object-Oriented Programming (OOP)?

Object-Oriented Programming (OOP) is a paradigm that allows us to build software by modeling it after real-world entities — things that have characteristics (attributes) and can perform actions (behaviors).

(Hindi: OOP ek aisa tarika hai jisme hum real-world ki cheezon jaise objects ko code mein model karte hain. Jaise kisi cheez ke attributes (characteristics) aur behavior (karya) hote hain, waise hi hamare code mein bhi honge.)

### 1\. Why OOP?

As software systems grew complex (think Uber, Ola, Zomato), we needed a way to map real-world problems into code more naturally and securely.

OOP allows us to:

* Model real-world entities as objects (e.g., User, Car, Ride)
    
* Secure data via encapsulation (only allow safe access)
    
* Reuse code using inheritance and interfaces
    
* Build scalable systems with loosely-coupled modules
    

(Hindi: OOPs se hum real-world ke complex problems ko code mein asani se model kar sakte hain. Data ko secure kar sakte hain, aur code ko reuse kar sakte hain.)

### 💠 Core Ideology of OOP:

“Program the way the real world works — with objects that interact.”

(Hindi: Programming ko is tarah karo jaise real world mein objects interact karte hain.)

Example: Car and Owner

Let’s model a simple real-world interaction: A person owns and drives a car.

### 💠 Real-world Thought:

* Object 1: Car
    
    * Characteristics (Attributes): brand, model, isEngineOn
        
    * Behaviors (Methods): start(), stop(), gearShift(), accelerate(), brake()
        
* Object 2: Owner
    
    * Characteristics: name
        
    * Behavior: drive()
        

(Hindi: Car ek object hai jismein kuch features hain jaise brand, model, aur kuch functions hain jaise start karna, brake lagana. Waise hi owner ek object hai jo car ko use karta hai.)

### 🔧 OOP Code Representation:

🔹 Car Class:

```java
public class Car {
    String brand;
    String model;
    boolean isEngineOn;

    public void start() {
        isEngineOn = true;
        System.out.println("Car started");
    }

    public void stop() {
        isEngineOn = false;
        System.out.println("Car stopped");
    }

    public void gearShift() {
        System.out.println("Gear shifted");
    }

    public void accelerate() {
        System.out.println("Accelerating...");
    }
}
```

🔹 Owner Class:

```java
public class Owner {
    String name;
    Car car;

    public void drive() {
        System.out.println(name + " is driving the car.");
        car.start();
        car.gearShift();
        car.accelerate();
    }
}
```

🔹 Main Function:

```java
public class Main {
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.brand = "Toyota";
        myCar.model = "Corolla";

        Owner owner = new Owner();
        owner.name = "Alice";
        owner.car = myCar;

        owner.drive();
    }
}
```

(Hindi: Yahaan Owner aur Car ke objects ek dusre se interact kar rahe hain. Owner apni car ko drive kar raha hai, aur car ke methods jaise start(), gearShift() call ho rahe hain.)

### 2\. Modeling Real-World Entities in Code

Let’s break it down even more:

* Object: A real-world thing (Car, User, Ride)  
    (Hindi: Object matlab ek vastu jiska koi role hai, jaise car.)
    
* Class: Blueprint of object (defines properties & behaviors)  
    (Hindi: Class ek design hai jiske base par object banta hai.)
    
* Instance: Actual object created using the class  
    (Hindi: Instance class ka actual object hai jo memory mein create hota hai.)
    
* Example:  
    class Car → Blueprint  
    Car myCar = new Car(); → Instance of Car
    

📌 Summary:

* OOP makes code look and behave like the real world.
    
* Every object has characteristics (fields) and behavior (methods).
    
* Objects can interact with each other just like in the real world.
    
* This interaction builds modular, maintainable, and scalable systems.
    

(Hindi: OOP mein hum aise programs banate hain jo real world ki tarah dikhte aur behave karte hain. Objects ke beech interaction ke through hum complex systems ko asani se model kar sakte hain.)

---

### 💠 Pillars of Object-Oriented Programming: – 1) Abstraction

* Abstraction hides unnecessary implementation details and shows only the relevant information needed to interact with an object. Or Abstraction – "Show only what’s necessary, hide everything else!"
    

(Hindi: Abstraction mein kisi object ke andar ka kaam kaise ho raha hai yeh nahi dikhaya jata, sirf itna dikhaya jata hai jitna user ko chahiye. or Abstraction ka matlab hota hai — "Sirf zaroori cheezein dikhana, baaki sab chhupa lena.")

* ### Real-World Analogies
    

1 ) You can start the car, press the pedals, and turn the wheel.

What you don't need to know:  
❌ How the engine combustion works  
❌ How fuel reaches the engine  
❌ How the gears change internally

(Hindi: Aapko yeh jaanna zaroori nahi hai ki car ka engine internally kaise kaam karta hai, aapko sirf car chalani aani chahiye.)

2 ) Using a Laptop  
You use apps, click buttons, browse the internet…

But:  
❌ You don’t care how the OS schedules tasks  
❌ How the RAM and processor manage memory

That’s abstraction – the complex logic is hidden from the user.

(Hindi: Hum laptop chalate hain, par use banane ka internal process nahi samajhte, yeh hi abstraction hai.)

* ### Programming Level Abstraction
    

Control Structures like:  
🔹 if  
🔹 for  
🔹 while

They are high-level instructions.

The compiler takes care of converting these into machine-level instructions!

(Hindi: if-else, loops jaise keywords high-level abstraction provide karte hain. Compiler inhe machine code mein convert karta hai.)

## 💠Code-Based Abstraction: Abstract Class

```java
public abstract class Car {

    // Abstract methods - no implementation here
    public abstract void startEngine();
    public abstract void shiftGear(int newGear);
    public abstract void accelerate();
    public abstract void brake();
}
```

* This is an abstract class.
    

(Hindi: Yeh ek abstract class hai jismein sirf method ke naam hain, implementation nahi.)

### 💠Key Points in Java:

* Java uses the `abstract` keyword for both abstract classes and methods.
    
* Abstract methods **do not** have a body (`{}`), just a signature.
    
* You **cannot instantiate** an abstract class directly.
    
* Any class that extends `Car` **must implement** all its abstract methods, unless that class is also declared abstract.
    

### 💠Concert Subclass Example

```java
// Concrete implementation of Car
public class SportsCar extends Car {
    public void startEngine() {
        System.out.println("SportsCar engine started!");
    }

    public void shiftGear(int newGear) {
        System.out.println("Gear shifted to " + newGear);
    }

    public void accelerate() {
        System.out.println("SportsCar accelerating!");
    }

    public void brake() {
        System.out.println("Applying brakes!");
    }
}
```

```java
public class Main {
    public static void main(String[] args) {
        Car myCar = new SportsCar();
        myCar.startEngine();
        myCar.shiftGear(2);
        myCar.accelerate();
        myCar.brake();
    }
}
```

### 💠 Benefits of Abstraction

* Simplified Interfaces  
    Clients focus on what an object does, not how it does it.  
    (Hindi: User ko sirf object ka kaam dikhai deta hai, andar ki complexity nahi.)
    
* Ease of Maintenance  
    You can change the internal code without affecting the client code.  
    (Hindi: Agar andar ka code badla bhi jaaye to client side pe koi asar nahi padta.)
    
* Code Reuse  
    You can reuse the same interface for different classes – e.g., SUV, Sedan, ElectricCar.  
    (Hindi: Aap same interface se alag-alag types ke cars bana sakte ho.)
    
* Reduced Complexity  
    System becomes modular and easy to manage.  
    (Hindi: System simple aur manageable ban jata hai.)
    

---

## 💠 Pillars of Object-Oriented Programming: – 2 ) Encapsulation

Encapsulation means wrapping data (state) and methods (behavior) into a single unit called a class and restricting direct access to some of the object's components.

Encapsulation is like a protective capsule for your data! It bundles data (variables) and behaviors (functions) together, and controls how the outside world can access them.

(Hindi: Encapsulation ek capsule ki tarah hota hai jo data aur us par hone wale operations ko ek sath bandh kar rakhta hai. Ye ensure karta hai ki sensitive data ko bahar se direct access na mile.)

### 💠 Two Facets of Encapsulation

1️⃣ Logical Grouping

* Data + Functions = One cohesive unit
    

📌 Example:  
Car class will contain:

* engineOn (bool)
    
* currentSpeed (int)
    
* accelerate(), shiftGear(), brake() functions
    

(Hindi: Logical grouping ka matlab hai related data aur functions ko ek hi jagah rakhna, jaise Car class ke andar sab kuch car se related milega.)

2️⃣ Data Security

* Prevent direct access to sensitive data fields.
    
* Example: You can view the car’s mileage (odometer) but can’t reset it.
    

(Hindi: Data security ka matlab hai important fields ko protect karna. Jaise ki car ka odometer sirf read ho sakta hai, set nahi.)

### 💠Real-World Analogies

### 📌 Medicine Capsule:

* Data = Medicine inside
    
* Wrapper = Protection
    
* You can take it without knowing the inner chemicals!
    

(Hindi: Capsule mein dawai aur uski safety ek sath hoti hai. Aap usko lete ho bina andar ke ingredients jaane.)

### 📌 Car Odometer:

* You can read kilometers driven.
    
* You can’t directly set it to 0.
    

(Hindi: Aap car ka odometer dekh sakte ho, lekin usse reset nahi kar sakte.)

```java
public class Car {
    private int speed;
    private int odometer;

    public void setSpeed(int s) {
        if (s > 0) {
            speed = s;
        }
    }

    public int getSpeed() {
        return speed;
    }

    public int getOdometer() {
        return odometer;
    }

    public void drive(int distance) {
        if (distance > 0) {
            odometer += distance;
        }
    }
}
```

### 💠 Access Modifiers in Java

🔓 public — Accessible from anywhere  
🔒 private — Only accessible inside the class  
🔐 protected — Accessible in the class and its child classes

(Hindi: Ye access modifiers define karte hain ki kaunsa data kahaan se access ho sakta hai.)

### 💠Getters & Setters: Controlled Access

* Getters allow safe read access.
    
* Setters allow controlled modifications with validations.
    

Allow controlled mutation with checks, rather then exposing fileds blindly

(Hindi: Getter aur Setter functions se aap data ko secure tarike se access aur modify kar sakte ho, bina direct access diye.)

### 💠 Benefits of Encapsulation

* Robustness:  
    Protects data from accidental or intentional misuse.
    
* Maintainability:  
    You can change internal code without affecting outside users.
    
* Clear Contracts:  
    Users interact via defined functions only.
    
* Modularity:  
    Helps organize code better and makes testing easier.
    

---

### 💠 Difference: Data Hiding vs Data Security

* Data Security:  
    Important info agar leak ho gaya toh threat ban sakta hai.
    
* Data Hiding:  
    Agar kuch data hide bhi ho gaya aur kisi ne dekh liya — koi dikkat nahi.
    

(Hindi: Data hiding aur security mein farq hai. Security mein data leak se danger ho sakta hai. Hiding mein aisa zaroori nahi.)

---

### **Day 2 Completed ✅ System Design**

> ***NOTE : - A big thanks to my mentors <mark>Rohit Negi</mark> <mark>Sir </mark> and*** [***<mark>Aditya</mark>***](https://www.linkedin.com/in/adityatandon2/) [***<mark>Sir</mark> fo***](https://www.linkedin.com/in/adityatandon2/)***r launching this amazing <mark>8-week course</mark> absolutely <mark>free</mark> on YouTube via <mark>CoderArmy9 </mark> :-*** [***https://www.youtube.com/@CoderArmy9***](https://www.youtube.com/@CoderArmy9) [***. 🙌***](https://www.youtube.com/@CoderArmy9)

👉 **Share this blog with your connections!** Let’s keep learning, growing, and supporting one another on this journey. 🚀

✍️ [*Payal Kumari*](https://www.linkedin.com/in/payalkumari10/) 👩‍💻

[![](https://cdn.hashnode.com/res/hashnode/image/upload/v1747217130450/e73bc306-e3c0-4f47-aac5-2a3c5336d01d.jpeg align="center")](https://www.linkedin.com/in/payalkumari10/)

**Jai Hind 🇮🇳 | #CoderArmy #LearningInPublic #SystemDesign #TechForAll #MentorshipMatters** [**#8weeksLLdChallenge**](https://www.youtube.com/hashtag/8weekslldchallenge) [**#LowLevelDesign**](https://www.youtube.com/hashtag/lowleveldesign) #Code [**#LLD**](https://www.youtube.com/hashtag/lld) **#OOP** **👩‍💻**

%[https://youtu.be/QbGoqAgP_zg?si=gyGos0oRrMmPlm_v]
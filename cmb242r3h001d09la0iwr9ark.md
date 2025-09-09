---
title: "📅Week -2 (Day4) - Factory Design Pattern | Simple, Factory Method & Abstract Factory with Real-Life Examples (Low-Level Design)👩‍💻"
seoTitle: "Factory Design pattern with real-world example"
seoDescription: "Explore the Factory Design Pattern in Low-Level Design to enhance flexibility, reduce coupling, and simplify object creation with real-world examples"
datePublished: Sat May 24 2025 10:53:15 GMT+0000 (Coordinated Universal Time)
cuid: cmb242r3h001d09la0iwr9ark
slug: week-2-day4-factory-design-pattern-simple-factory-method-and-abstract-factory-with-real-life-examples-low-level-design
cover: https://cdn.hashnode.com/res/hashnode/image/upload/v1748084667668/73a5be20-667e-4289-bc97-3da6e73b8a27.png
ogImage: https://cdn.hashnode.com/res/hashnode/image/upload/v1748083890421/e1dcc972-b5cb-4796-84d3-3d12310a952b.png
tags: cpp, blogging, java, technology, hashnode, system-design, dsa, techblog, coding-challenge, coding-journey, low-level-design, lld, coderarmy, 8weekslldchallenge, payalkumari11

---

> ***NOTE: - <mark>I started my 8-week system design journey with Coder Army. I will be journaling every day, recording what I learn, reflecting on it, and sharing it with my network to help newcomers to system design.</mark>***

# 💠Factory Design Pattern Explained

The Factory Design Pattern is one of the most commonly used design patterns in Low-Level Design (LLD). It allows you to create objects without exposing the creation logic to the client. Instead, a factory method is used to return instances of specific subclasses, promoting loose coupling and better maintainability.

(Hindi : Factory Design Pattern, Low-Level Design (LLD) me sabse zyada use hone wale patterns me se ek hai. Ye pattern client se object creation ki logic ko chhupakar objects create karne ki suvidha deta hai. Isme ek factory method ka use karke subclass ke instances return kiye jaate hain, jisse code loosely coupled aur easily maintainable ban jata hai.)

## 📍Why Factory Design Pattern?

* Imagine karo tum ek car showroom ke customer ho. Tumhe sirf car chahiye, kaise banti hai uske baare mein tumhe koi fikr nahi.
    
* Showroom (factory) decide karta hai ki kaunsi car kaise banegi aur tumhe deliver karta hai.
    
* Isse tumhara kaam aasan ho jata hai aur showroom ko flexibility milti hai nayi car models banane ki bina tumhe confuse kiye.
    

## 📍When to Use the Factory Pattern ?

* **Decoupling object creation:** When the creation logic is complex.
    
* **Flexibility & extensibility:** When new types need to be added without modifying existing client code.
    
* **Maintainability:** When you want a central place to manage object creation.
    
* **Interface-based hierarchy:** When multiple object types share a common interface.
    

### 📍Example

Imagine a payment processing system where users can choose between Credit Card, PayPal, or Bank Transfer. Instead of creating each payment type manually, use a factory to generate the correct payment method object.

### 📍 Implementation Steps

**1\. Define an Interface (Product):**

* Create an interface like `PaymentMethod`.
    

**2\. Define Concrete Classes (Products):**

* Implement the interface with classes like `CreditCardPayment`, `PayPalPayment`.
    

**3\. Define the Factory:**

* Create a factory class `PaymentMethodFactory` with a method that returns the correct object based on input.
    

**4\. Use the Factory in Client Code:**

* Use the factory instead of creating objects manually.
    

### 📍 Benefits of Using the Factory Pattern

* **Reduced Coupling:** Easier to manage and update.
    
* **Centralized Object Creation:** Logic is maintained in one place.
    
* **Improved Flexibility:** Add new types without breaking old code.
    
* **Simplified Object Creation:** Clean and organized code.
    

## 💠Types of Factory Design Pattern

### 1) Simple Factory (Not a formal pattern, more a principle)

A single factory class contains logic to decide which object to create. The client simply calls the factory and receives an object.

📍 **When to use?**

* When object creation is centralized.
    
* When new object types are rare and logic is straightforward.
    
    **📍Example: Burger Preparation using a Simple Burger Factory**
    
    **📍Concept:** A single `BurgerFactory` decides which type of burger to prepare — Basic, Standard, or Premium — based on input.
    
    ![](https://cdn.hashnode.com/res/hashnode/image/upload/v1757420480100/ce23554c-5345-429e-91b5-70182d907e1c.png align="center")
    
    ![](https://cdn.hashnode.com/res/hashnode/image/upload/v1757420499679/6f901ce7-46f1-42f1-ab3d-de0abfb9f236.png align="center")
    

```java
// --- Burger Interface ---
interface Burger {
    void prepare();
}

// --- Concrete Burger Implementations ---
class BasicBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Preparing Basic Burger with bun, patty, and ketchup!");
    }
}

class StandardBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Preparing Standard Burger with bun, patty, cheese, and lettuce!");
    }
}

class PremiumBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Preparing Premium Burger with gourmet bun, premium patty, cheese, lettuce, and secret sauce!");
    }
}

// --- Burger Factory ---
class BurgerFactory {
    public Burger createBurger(String type) {
        if (type.equalsIgnoreCase("basic")) {
            return new BasicBurger();
        } else if (type.equalsIgnoreCase("standard")) {
            return new StandardBurger();
        } else if (type.equalsIgnoreCase("premium")) {
            return new PremiumBurger();
        } else {
            System.out.println("Invalid burger type!");
            return null;
        }
    }
}

// --- Main Class ---
public class SimpleFactory {
    public static void main(String[] args) {
        String type = "standard";

        BurgerFactory myBurgerFactory = new BurgerFactory();

        Burger burger = myBurgerFactory.createBurger(type);

        if (burger != null) {
            burger.prepare();
        }
    }
}
```

(Hindi : Ek simple `BurgerFactory` hai jo decide karti hai ki customer ke input ke basis pe kaunsa burger banana hai — Basic, Standard ya Premium.)

### 2) Factory Method Pattern

The factory is defined as an **interface or abstract class**, and **subclasses override** the factory method to return specific object instances.

📍 **When to use?**

* When object creation depends on the subclass implementation.
    
* When you want to delegate the instantiation logic to derived classes.
    

**📍Example: Burger Brands (SinghBurger vs KingBurger)**

**📍Concept:** Different brands have their own burger factories and they decide which burger to prepare using their own factory method.

![](https://cdn.hashnode.com/res/hashnode/image/upload/v1757420540870/1fe14417-a60c-421c-ac6d-6abfa6d8dd87.png align="center")

![](https://cdn.hashnode.com/res/hashnode/image/upload/v1757420561567/458458e1-c301-4afe-bbe6-a3d7f4543151.png align="center")

```java

// Product Interface and subclasses
interface Burger {
    void prepare();
}

class BasicBurger implements Burger {
    public void prepare() {
        System.out.println("Preparing Basic Burger with bun, patty, and ketchup!");
    }
}

class StandardBurger implements Burger {
    public void prepare() {
        System.out.println("Preparing Standard Burger with bun, patty, cheese, and lettuce!");
    }
}

class PremiumBurger implements Burger {
    public void prepare() {
        System.out.println("Preparing Premium Burger with gourmet bun, premium patty, cheese, lettuce, and secret sauce!");
    }
}

class BasicWheatBurger implements Burger {
    public void prepare() {
        System.out.println("Preparing Basic Wheat Burger with bun, patty, and ketchup!");
    }
}

class StandardWheatBurger implements Burger {
    public void prepare() {
        System.out.println("Preparing Standard Wheat Burger with bun, patty, cheese, and lettuce!");
    }
}

class PremiumWheatBurger implements Burger {
    public void prepare() {
        System.out.println("Preparing Premium Wheat Burger with gourmet bun, premium patty, cheese, lettuce, and secret sauce!");
    }
}

// Factory Interface and Concrete Factories
interface BurgerFactory {
    Burger createBurger(String type);
}

class SinghBurger implements BurgerFactory {
    public Burger createBurger(String type) {
        if (type.equalsIgnoreCase("basic")) {
            return new BasicBurger();
        } else if (type.equalsIgnoreCase("standard")) {
            return new StandardBurger();
        } else if (type.equalsIgnoreCase("premium")) {
            return new PremiumBurger();
        } else {
            System.out.println("Invalid burger type!");
            return null;
        }
    }
}

class KingBurger implements BurgerFactory {
    public Burger createBurger(String type) {
        if (type.equalsIgnoreCase("basic")) {
            return new BasicWheatBurger();
        } else if (type.equalsIgnoreCase("standard")) {
            return new StandardWheatBurger();
        } else if (type.equalsIgnoreCase("premium")) {
            return new PremiumWheatBurger();
        } else {
            System.out.println("Invalid burger type!");
            return null;
        }
    }
}

// Main Class
public class FactoryMethod {
    public static void main(String[] args) {
        String type = "basic";

        BurgerFactory myFactory = new SinghBurger();
        Burger burger = myFactory.createBurger(type);

        if (burger != null) {
            burger.prepare();
        }
    }
}
```

(Hindi : Yahan har brand ka apna factory class hai — `SinghBurgerFactory` aur `KingBurgerFactory`. Har factory `createBurger()` method ko override karke apne specific burger banati hai.)

### 3) **Abstract Factory Pattern**

An abstract factory creates **families of related or dependent objects** without specifying their concrete classes.

**📍When to use?**

* When you need to ensure that a group of related products is used together.
    
* When you want to isolate product creation from usage.**When to use?**
    

📍Example : **Mega Burger Factory that Creates Families of Burgers**

**📍Concept:** We have one big factory that can produce *families* of burgers — like Singh’s Classic set, Singh’s Wheat set, and King’s Garlic set — without revealing the concrete classes.

![](https://cdn.hashnode.com/res/hashnode/image/upload/v1757420581347/1111a37f-2afc-41a3-ad55-75dbfe053be4.png align="center")

![](https://cdn.hashnode.com/res/hashnode/image/upload/v1757420597182/b6606c1f-eca6-44db-ad8e-09a031f10f2f.png align="center")

```java
// --- Product 1 --> Burger ---
interface Burger {
    void prepare();
}

class BasicBurger implements Burger {
    public void prepare() {
        System.out.println("Preparing Basic Burger with bun, patty, and ketchup!");
    }
}

class StandardBurger implements Burger {
    public void prepare() {
        System.out.println("Preparing Standard Burger with bun, patty, cheese, and lettuce!");
    }
}

class PremiumBurger implements Burger {
    public void prepare() {
        System.out.println("Preparing Premium Burger with gourmet bun, premium patty, cheese, lettuce, and secret sauce!");
    }
}

class BasicWheatBurger implements Burger {
    public void prepare() {
        System.out.println("Preparing Basic Wheat Burger with bun, patty, and ketchup!");
    }
}

class StandardWheatBurger implements Burger {
    public void prepare() {
        System.out.println("Preparing Standard Wheat Burger with bun, patty, cheese, and lettuce!");
    }
}

class PremiumWheatBurger implements Burger {
    public void prepare() {
        System.out.println("Preparing Premium Wheat Burger with gourmet bun, premium patty, cheese, lettuce, and secret sauce!");
    }
}

// --- Product 2 --> GarlicBread ---
interface GarlicBread {
    void prepare();
}

class BasicGarlicBread implements GarlicBread {
    public void prepare() {
        System.out.println("Preparing Basic Garlic Bread with butter and garlic!");
    }
}

class CheeseGarlicBread implements GarlicBread {
    public void prepare() {
        System.out.println("Preparing Cheese Garlic Bread with extra cheese and butter!");
    }
}

class BasicWheatGarlicBread implements GarlicBread {
    public void prepare() {
        System.out.println("Preparing Basic Wheat Garlic Bread with butter and garlic!");
    }
}

class CheeseWheatGarlicBread implements GarlicBread {
    public void prepare() {
        System.out.println("Preparing Cheese Wheat Garlic Bread with extra cheese and butter!");
    }
}

// --- Abstract Factory ---
interface MealFactory {
    Burger createBurger(String type);
    GarlicBread createGarlicBread(String type);
}

// --- Concrete Factory 1 ---
class SinghBurger implements MealFactory {
    public Burger createBurger(String type) {
        if (type.equalsIgnoreCase("basic")) {
            return new BasicBurger();
        } else if (type.equalsIgnoreCase("standard")) {
            return new StandardBurger();
        } else if (type.equalsIgnoreCase("premium")) {
            return new PremiumBurger();
        } else {
            System.out.println("Invalid burger type!");
            return null;
        }
    }

    public GarlicBread createGarlicBread(String type) {
        if (type.equalsIgnoreCase("basic")) {
            return new BasicGarlicBread();
        } else if (type.equalsIgnoreCase("cheese")) {
            return new CheeseGarlicBread();
        } else {
            System.out.println("Invalid Garlic bread type!");
            return null;
        }
    }
}

// --- Concrete Factory 2 ---
class KingBurger implements MealFactory {
    public Burger createBurger(String type) {
        if (type.equalsIgnoreCase("basic")) {
            return new BasicWheatBurger();
        } else if (type.equalsIgnoreCase("standard")) {
            return new StandardWheatBurger();
        } else if (type.equalsIgnoreCase("premium")) {
            return new PremiumWheatBurger();
        } else {
            System.out.println("Invalid burger type!");
            return null;
        }
    }

    public GarlicBread createGarlicBread(String type) {
        if (type.equalsIgnoreCase("basic")) {
            return new BasicWheatGarlicBread();
        } else if (type.equalsIgnoreCase("cheese")) {
            return new CheeseWheatGarlicBread();
        } else {
            System.out.println("Invalid Garlic bread type!");
            return null;
        }
    }
}

// --- Main Class ---
public class AbstractFactory {
    public static void main(String[] args) {
        String burgerType = "basic";
        String garlicBreadType = "cheese";

        MealFactory mealFactory = new SinghBurger();

        Burger burger = mealFactory.createBurger(burgerType);
        GarlicBread garlicBread = mealFactory.createGarlicBread(garlicBreadType);

        if (burger != null) burger.prepare();
        if (garlicBread != null) garlicBread.prepare();
    }
}
```

(Hindi : Yahan pe `BurgerSetFactory` ek aisa interface hai jo related burgers ka poora family banata hai. `SinghClassicSetFactory` ya `KingGarlicSetFactory` jese factory alag alag burger family banate hain — Basic, Standard, Premium — ek hi theme ke under.)

## 💠Summary with Real-Life Examples

| Pattern | Focus | Factory Class | Product Types | Example (Burger System) |
| --- | --- | --- | --- | --- |
| Simple Factory | Centralized object creation | One class | Independent | BurgerFactory creates Basic/Standard/Premium |
| Factory Method | Subclass decides object creation | Many subclasses | One family | Singh vs King with different creation logic |
| Abstract Factory | Create related families of objects | One interface | Related group | Singh Classic Set vs King Garlic Set |

### **Week - 2 (Day 4) Completed ✅ System Design**

> ***NOTE : - A big thanks to my mentors*** [***<mark>Rohit Negi</mark> <mark>Sir</mark>***](https://www.linkedin.com/in/rohit-negi9/) ***and*** [***<mark>Aditya</mark> <mark>Sir</mark> fo***](https://www.linkedin.com/in/adityatandon2/)***r launching this amazing <mark>8-week course</mark> absolutely <mark>free</mark> on YouTube via <mark>CoderArmy9 </mark> :-*** [***youtube.com/@CoderArmy9***](http://youtube.com/@CoderArmy9) [***. 🙌***](https://www.youtube.com/@CoderArmy9)

👉 **Share this blog with your connections!** Let’s keep learning, growing, and supporting one another on this journey. 🚀

✍️ [***Payal Kumari***](https://www.linkedin.com/in/payalkumari10/) 👩‍💻 [**Github**](https://github.com/PayalKumari10)

![](https://cdn.hashnode.com/res/hashnode/image/upload/v1748076871803/86ddb6dc-a4f6-48d8-b81e-09494a1c902f.jpeg align="center")

**Jai Hind 🇮🇳 | #CoderArmy #LearningInPublic #SystemDesign #TechForAll #MentorshipMatters** [**#8weeksLLdChallenge**](https://www.youtube.com/hashtag/8weekslldchallenge) [**#LowLevelDesign #Code #LLD**](https://www.youtube.com/hashtag/8weekslldchallenge) [**#OOP**](https://www.youtube.com/hashtag/lowleveldesign)

%[https://youtu.be/dMK4TbG29fk?si=nS9FxU0juE3gzQdu]
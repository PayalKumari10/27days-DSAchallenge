---
title: "📅Week-3 (Day-3) - Decorator Pattern Explained | Real-world use case + Code | Design patterns in LLD"
seoTitle: "Decorator Pattern: Code, Use Case & Explanation"
seoDescription: "Explore the Decorator Pattern in system design, with real-life analogies and coding examples, to dynamically enhance object functionalities"
datePublished: Thu May 29 2025 12:22:10 GMT+0000 (Coordinated Universal Time)
cuid: cmb9cgdd1001209ld8rv529gj
slug: week-3-day-3-decorator-pattern-explained-real-world-use-case-code-design-patterns-in-lld
cover: https://cdn.hashnode.com/res/hashnode/image/upload/v1748516275996/83fb1c1d-e2c8-4e2d-9519-657bfe3a38fa.png
ogImage: https://cdn.hashnode.com/res/hashnode/image/upload/v1748521264543/ddc03fa4-20bf-468e-9959-9f7375e2c892.png
tags: cpp, java, technology, coding, system-design, dsa, techblog, coding-challenge, technical-writing-1, coding-journey, low-level-design, lld, coderarmy, 8weekslldchallenge, payalkumari11

---

> ***NOTE: - <mark>I started my 8-week system design journey with Coder Army. I will be journaling every day, recording what I learn, reflecting on it, and sharing it with my network to help newcomers to system design.</mark>***

## 💠What is the Decorator Pattern?

> The **Decorator Pattern** allows you to **dynamically add behavior or responsibilities to objects** *without modifying their code*.

🎯 It gives you a **flexible alternative to subclassing**, perfect when you want to **extend functionalities at runtime**.

> Decorator Pattern ek aisa design hai jisme aap kisi object ke upar naye features ya behavior add kar sakte ho **bina uske original code ko chhue**.

(Hindi : Jaise ek aadmi ne jacket pehna, phir topi lagayi, phir sunglasses — ek ke baad ek cheezein add hoti gayi!)

## 💠Real-life Analogy: Mario Game

Imagine Mario, the classic video game character:

* **Base Mario**: Can just walk.
    
* Eats a Mushroom → Grows taller.
    
* Eats a Fire Flower → Can shoot fireballs.
    
* Gets a Star → Becomes invincible.
    

👉 Mario’s **core abilities stay the same**, but **new powers are added** on top, dynamically — *just like decorators!*

## 💠How Does It Work?

We use:

* **Component Interface (IComponent)**: Base functionalities
    
* **Concrete Component (ConcreteComponent)**: Real object
    
* **Decorator Class**: Abstract wrapper
    
* **Concrete Decorators**: Extra powers
    

![](https://cdn.hashnode.com/res/hashnode/image/upload/v1757420961942/dd6e1bb8-f7fc-4ac8-bb0c-b4d773aeb9a3.png align="center")

## 💠Why & When to Use the Decorator Pattern?

### ✅ Use When:

* You want to add behavior to objects at runtime.
    
* You don’t want to modify original code.
    
* You need a flexible way to extend functionality.
    

### ❌ Don’t Use When:

* Too many layers might make debugging hard.
    
* Can lead to too many small classes.
    

## 💠 Difference Between Inheritance vs Decorator

| Feature | Inheritance | Decorator |
| --- | --- | --- |
| Compile-time | Behavior added at compile-time | Behavior added at run-time |
| Tight coupling | Yes | No (more flexible) |
| Open-Closed | ❌ May violate it | ✅ Follows open-closed principle |

```java
// Component Interface: defines a common interface for Mario and all power-up decorators.
interface Character {
    String getAbilities();
}

// Concrete Component: Basic Mario character with no power-ups.
class Mario implements Character {
    public String getAbilities() {
        return "Mario";
    }
}

// Abstract Decorator: CharacterDecorator "is-a" Character and "has-a" Character.
abstract class CharacterDecorator implements Character {
    protected Character character;  // Wrapped component

    public CharacterDecorator(Character c) {
        this.character = c;
    }
}

// Concrete Decorator: Height-Increasing Power-Up.
class HeightUp extends CharacterDecorator {
    public HeightUp(Character c) {
        super(c);
    }

    public String getAbilities() {
        return character.getAbilities() + " with HeightUp";
    }
}

// Concrete Decorator: Gun Shooting Power-Up.
class GunPowerUp extends CharacterDecorator {
    public GunPowerUp(Character c) {
        super(c);
    }

    public String getAbilities() {
        return character.getAbilities() + " with Gun";
    }
}

// Concrete Decorator: Star Power-Up (temporary ability).
class StarPowerUp extends CharacterDecorator {
    public StarPowerUp(Character c) {
        super(c);
    }

    public String getAbilities() {
        return character.getAbilities() + " with Star Power (Limited Time)";
    }
}

public class DecoratorPattern {
    public static void main(String[] args) {
        // Create a basic Mario character.
        Character mario = new Mario();
        System.out.println("Basic Character: " + mario.getAbilities());

        // Decorate Mario with a HeightUp power-up.
        mario = new HeightUp(mario);
        System.out.println("After HeightUp: " + mario.getAbilities());

        // Decorate Mario further with a GunPowerUp.
        mario = new GunPowerUp(mario);
        System.out.println("After GunPowerUp: " + mario.getAbilities());

        // Finally, add a StarPowerUp decoration.
        mario = new StarPowerUp(mario);
        System.out.println("After StarPowerUp: " + mario.getAbilities());
    }
}
```

### <mark>UML Design</mark>

![](https://cdn.hashnode.com/res/hashnode/image/upload/v1757421029862/9b6dddc9-25a4-4f38-8f4b-6e356e137a64.png align="center")

## 💠 Real-World Example

### 📍Gift Wrapping Analogy:

* **Gift** = Base object.
    
* **Wrapper** = Decorator.
    
* Add ribbon, cover, bow — all without changing the gift itself!
    

### 📍 Zomato Order:

* You order food (base).
    
* Add cutlery, sauces, extra cheese (decorators).
    

### **Week - 3 (Day 3) Completed ✅ System Design**

> ***NOTE : - A big thanks to my mentors*** [***<mark>Rohit Negi</mark> <mark>Sir</mark>***](https://www.linkedin.com/in/rohit-negi9/) ***and*** [***<mark>Aditya</mark> <mark>Sir</mark> fo***](https://www.linkedin.com/in/adityatandon2/)***r launching this amazing <mark>8-week course</mark> absolutely <mark>free</mark> on YouTube via <mark>CoderArmy9 </mark> :-*** [***youtube.com/@CoderArmy9***](http://youtube.com/@CoderArmy9) [***. 🙌***](https://www.youtube.com/@CoderArmy9)

👉 **Share this blog with your connections!** Let’s keep learning, growing, and supporting one another on this journey. 🚀

✍️ [***Payal Kumari***](https://www.linkedin.com/in/payalkumari10/) 👩‍💻 [**Github**](https://github.com/PayalKumari10)

![](https://cdn.hashnode.com/res/hashnode/image/upload/v1748520920056/059b089e-860f-4bbf-9069-7aa0e133de62.jpeg align="center")

**Jai Hind 🇮🇳 | #CoderArmy #LearningInPublic #SystemDesign #TechForAll #MentorshipMatters** [**#8weeksLLdChallenge**](https://www.youtube.com/hashtag/8weekslldchallenge) [**#LowLevelDesign**](https://www.youtube.com/hashtag/lowleveldesign) [**#LLD**](https://www.youtube.com/hashtag/lld) **👩‍💻**

%[https://youtu.be/Z9rFlZClYNI?si=ksoIFm1o11YNRNk6]
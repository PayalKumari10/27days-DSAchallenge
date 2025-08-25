---
title: "📅Week-1 (Day 5) - Learn SOLID Design Principles: Detailed Guide and Practical Code Samples part -1."
seoTitle: "SOLID Design Principles: Day 5 Guide"
seoDescription: "Discover SOLID design principles for scalable, maintainable code in object-oriented programming with examples. Enhance your coding skills today!"
datePublished: Sat May 17 2025 13:09:10 GMT+0000 (Coordinated Universal Time)
cuid: cmas8ukuc00340ajxdtlj2j5w
slug: day-5-learn-solid-design-principles-detailed-guide-and-practical-code-samples-part-1
cover: https://cdn.hashnode.com/res/hashnode/image/upload/v1747477558474/d4d1b15e-6602-479d-a94b-31784bbc06bb.png
ogImage: https://cdn.hashnode.com/res/hashnode/image/upload/v1747487302468/21a4a3f9-975b-42cc-8e94-2077ddb6cfa6.png
tags: oop, technology, coding, hashnode, oops, system-design, dsa, coder, techblog, low-level-design, lld, solid-design-principles, coderarmy, payalkumari11

---

## 1) Why Design Principles Matter?

Without proper design principles, our code becomes:

❌ Difficult to Maintain  
❌ Hard to Read  
❌ Bugs

This is where SOLID Principles come to the rescue!

## 2) SOLID Design Principles

### 💠 Introduction to SOLID Principles

Back in the year 2000, a computer scientist named Robert C. Martin (aka Uncle Bob) introduced five key principles of object-oriented programming to write better, scalable, and maintainable code.

SOLID is a set of five basic design principles in object-oriented programming that help developers write clean, easy-to-maintain, and scalable code. These principles improve the structure of your code and make it easier to understand and modify. Following the principles keeps the code structured and ready for future updates.

(Hindi : **SOLID ek paanch core design principles ka set hai jo object-oriented programming mein clear, samajhne mein easy, aur maintain karne layak code likhne mein madad karta hai. In principles ko follow karne se code structured rehta hai aur future updates ke liye ready hota hai.**)

They are remembered as the acronym: SOLID

<mark>The five SOLID principles are:</mark>

1. S – Single Responsibility Principle (SRP)
    
2. **O** – Open/Closed Principle
    
3. L – Liskov Substitution Principle (LSP)
    
4. I – Interface Segregation Principle (ISP) ❌ (we’ll skip this for now)
    
5. D – Dependency Inversion Principle (DIP) ❌ (we’ll skip this too)
    

## 1\. Single Responsibility Principle (SRP)

* A class should have only one reason to change. That means one class = one job.
    
* A class should do only one things.
    

📍Real-Life Example:  
Think of a washing machine. Its only job is to wash clothes. Imagine if it also tried to make tea — that’s bad design.

(Hindi: Ek washing machine ka kaam sirf kapde dhona hona chahiye. Agar woh chai banana bhi shuru kar de, toh system kaam nahi karega.)

> <mark>Note: Ek class ke andar multiple methods ho sakta hai, lekin uska purpose and responsibility ek hi specific task se related hona chahiye.</mark>

![](https://cdn.hashnode.com/res/hashnode/image/upload/v1756131332567/adcc281e-f8b3-4689-98f8-93d1ac4c1de9.png align="center")

```java
import java.util.ArrayList;
import java.util.List;

// Product class representing any item in eCommerce.
class Product {
    public String name;
    public double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

// 1. ShoppingCart: Only responsible for Cart related business logic.
class ShoppingCart {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product p) {
        products.add(p);
    }

    public List<Product> getProducts() {
        return products;
    }

    // Calculates total price in cart.
    public double calculateTotal() {
        double total = 0;
        for (Product p : products) {
            total += p.price;
        }
        return total;
    }
}

// 2. ShoppingCartPrinter: Only responsible for printing invoices
class ShoppingCartPrinter {
    private ShoppingCart cart;

    public ShoppingCartPrinter(ShoppingCart cart) {
        this.cart = cart;
    }

    public void printInvoice() {
        System.out.println("Shopping Cart Invoice:");
        for (Product p : cart.getProducts()) {
            System.out.println(p.name + " - Rs " + p.price);
        }
        System.out.println("Total: Rs " + cart.calculateTotal());
    }
}

// 3. ShoppingCartStorage: Only responsible for saving cart to DB
class ShoppingCartStorage {
    private ShoppingCart cart;

    public ShoppingCartStorage(ShoppingCart cart) {
        this.cart = cart;
    }

    public void saveToDatabase() {
        System.out.println("Saving shopping cart to database...");
    }
}

public class SRPFollowed {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addProduct(new Product("Laptop", 50000));
        cart.addProduct(new Product("Mouse", 2000));

        ShoppingCartPrinter printer = new ShoppingCartPrinter(cart);
        printer.printInvoice();

        ShoppingCartStorage db = new ShoppingCartStorage(cart);
        db.saveToDatabase();
    }
}
```

## 2\. Open/Closed Principle (OCP)

A class Software should be open for extension, but closed for modification.<mark>"</mark>**<mark>Software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification</mark>**<mark>"</mark>

📍 Real-Life Example:  
Think of a power strip (multi-plug). You can add more devices (extend), but you don’t need to break or modify it to use it.

(Hindi: Power board mein aap naye devices laga sakte ho bina use tod-phod kiye.)

> <mark>Note : Bina existing class ya code ko modify kiye naye features ko add karna</mark>

![](https://cdn.hashnode.com/res/hashnode/image/upload/v1756134352484/0aa6f0c6-3063-4a60-b57c-53edfcf01317.png align="center")

```java
import java.util.ArrayList;
import java.util.List;

// Product class representing any item in eCommerce.
class Product {
    public String name;
    public double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

// 1. ShoppingCart: Only responsible for Cart related business logic.
class ShoppingCart {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product p) {
        products.add(p);
    }

    public List<Product> getProducts() {
        return products;
    }

    // Calculates total price in cart.
    public double calculateTotal() {
        double total = 0;
        for (Product p : products) {
            total += p.price;
        }
        return total;
    }
}

// 2. ShoppingCartPrinter: Only responsible for printing invoices
class ShoppingCartPrinter {
    private ShoppingCart cart;

    public ShoppingCartPrinter(ShoppingCart cart) {
        this.cart = cart;
    }

    public void printInvoice() {
        System.out.println("Shopping Cart Invoice:");
        for (Product p : cart.getProducts()) {
            System.out.println(p.name + " - Rs " + p.price);
        }
        System.out.println("Total: Rs " + cart.calculateTotal());
    }
}

interface Persistence {
    void save(ShoppingCart cart);
}

class SQLPersistence implements Persistence {
    @Override
    public void save(ShoppingCart cart) {
        System.out.println("Saving shopping cart to SQL DB...");
    }
}

class MongoPersistence implements Persistence {
    @Override
    public void save(ShoppingCart cart) {
        System.out.println("Saving shopping cart to MongoDB...");
    }
}

class FilePersistence implements Persistence {
    @Override
    public void save(ShoppingCart cart) {
        System.out.println("Saving shopping cart to a file...");
    }
}

public class OCPFollowed {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(new Product("Laptop", 50000));
        cart.addProduct(new Product("Mouse", 2000));

        ShoppingCartPrinter printer = new ShoppingCartPrinter(cart);
        printer.printInvoice();

        Persistence db    = new SQLPersistence();
        Persistence mongo = new MongoPersistence();
        Persistence file  = new FilePersistence();

        db.save(cart);    // Save to SQL database
        mongo.save(cart); // Save to MongoDB
        file.save(cart);  // Save to File
    }
}
```

## 3\. Liskov Substitution Principle (LSP)

The principle was introduced by <mark>Barbara Liskov in 1987</mark> and according to this principle <mark>"</mark>**<mark>Derived or child classes must be substitutable for their base or parent classes</mark>**<mark>".</mark>

**Subclass should be substitutable for their base classes.**

Any client that expects a reference of class `A` (the base class) should be able to work correctly even when an object of class `B` (a subclass of A) is passed instead. This means the subclass should be **substitutable** for the base class without breaking the functionality of the program.

📍 **Real-Life Example for LSP:**

**Think of a universal TV remote.**  
It is designed to work with different TV brands — Sony, LG, Samsung — all of which follow the same basic commands (like power on/off, volume, channel change).  
If the remote works fine with any of these TVs without needing internal changes, then each TV (subclass) is substitutable for the standard remote (base class).

🔁 **In code terms:**  
Remote = base class,  
SonyTV / SamsungTV = subclasses.  
Each subclass should respond correctly to base class behavior — without breaking anything.

(Hindi : Socho ek universal TV remote hai — usse aap Sony, LG, Samsung kisi bhi TV ko control kar sakte ho.  
Har TV remote ke basic functions (power, volume, channel) samajh leta hai.  
Matlab har TV (subclass) ko ek base class ke remote ke reference se control kiya ja sakta hai — bina kuch tod-phod ke.  
**Yahi hai Liskov Substitution Principle.**)

> Note : **Subclass ko parent class ke features ko extend karna hota hai, bina unki functionality ko break kiye.**

![](https://cdn.hashnode.com/res/hashnode/image/upload/v1756134371188/e2deee35-4f19-4c76-b8a8-17f0b65eaa0e.png align="center")

```java
import java.util.ArrayList;
import java.util.List;

// 1. DepositOnlyAccount interface: only allows deposits
interface DepositOnlyAccount {
    void deposit(double amount);
}

// 2. WithdrawableAccount interface: allows deposits and withdrawals
interface WithdrawableAccount extends DepositOnlyAccount {
    void withdraw(double amount);
}

class SavingAccount implements WithdrawableAccount {
    private double balance;

    public SavingAccount() {
        balance = 0;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + " in Savings Account. New Balance: " + balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + " from Savings Account. New Balance: " + balance);
        } else {
            System.out.println("Insufficient funds in Savings Account!");
        }
    }
}

class CurrentAccount implements WithdrawableAccount {
    private double balance;

    public CurrentAccount() {
        balance = 0;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + " in Current Account. New Balance: " + balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + " from Current Account. New Balance: " + balance);
        } else {
            System.out.println("Insufficient funds in Current Account!");
        }
    }
}

class FixedTermAccount implements DepositOnlyAccount {
    private double balance;

    public FixedTermAccount() {
        balance = 0;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + " in Fixed Term Account. New Balance: " + balance);
    }
}

class BankClient {
    private List<WithdrawableAccount> withdrawableAccounts;
    private List<DepositOnlyAccount> depositOnlyAccounts;

    public BankClient(List<WithdrawableAccount> withdrawableAccounts,
                      List<DepositOnlyAccount> depositOnlyAccounts) {
        this.withdrawableAccounts = withdrawableAccounts;
        this.depositOnlyAccounts = depositOnlyAccounts;
    }

    public void processTransactions() {
        for (WithdrawableAccount acc : withdrawableAccounts) {
            acc.deposit(1000);
            acc.withdraw(500);
        }
        for (DepositOnlyAccount acc : depositOnlyAccounts) {
            acc.deposit(5000);
        }
    }
}

public class LSPFollowed {
    public static void main(String[] args) {
        List<WithdrawableAccount> withdrawableAccounts = new ArrayList<>();
        withdrawableAccounts.add(new SavingAccount());
        withdrawableAccounts.add(new CurrentAccount());

        List<DepositOnlyAccount> depositOnlyAccounts = new ArrayList<>();
        depositOnlyAccounts.add(new FixedTermAccount());

        BankClient client = new BankClient(withdrawableAccounts, depositOnlyAccounts);
        client.processTransactions();
    }
}
```

### **Day 5 Completed ✅ System Design**

> ***NOTE : - A big thanks to my mentors*** [***<mark>Rohit Negi</mark>***](https://www.linkedin.com/in/rohit-negi9/) ***<mark>Sir </mark> and*** [***<mark>Aditya</mark>***](https://www.linkedin.com/in/adityatandon2/) [***<mark>Sir</mark> fo***](https://www.linkedin.com/in/adityatandon2/)***r launching this amazing <mark>8-week course</mark> absolutely <mark>free</mark> on YouTube via <mark>CoderArmy9 </mark> :-*** [https://www.youtube.com/@CoderArmy9***🙌***](https://www.youtube.com/@CoderArmy9)

👉 **Share this blog with your connections!** Let’s keep learning, growing, and supporting one another on this journey. 🚀

✍️ [***Payal Kumari***](https://www.linkedin.com/in/payalkumari10/) 👩‍💻

[![](https://cdn.hashnode.com/res/hashnode/image/upload/v1747487051639/6c90760a-0d20-479c-b3e3-9430d7ba59a2.jpeg align="center")](https://www.linkedin.com/in/payalkumari10/)

**Jai Hind 🇮🇳 | #CoderArmy #LearningInPublic #SystemDesign #TechForAll #MentorshipMatters** [**#8weeksLLdChallenge**](https://www.youtube.com/hashtag/8weekslldchallenge) [**#LowLevelDesign**](https://www.youtube.com/hashtag/8weekslldchallenge) [#Code **#LLD**](https://www.youtube.com/hashtag/lowleveldesign) [**#OOP**](https://www.youtube.com/hashtag/lld) **#SOLIDDesignPrinciples** **👩‍💻**

%[https://youtu.be/UsNl8kcU4UA?si=oe8DDohRwWE-tL3t]
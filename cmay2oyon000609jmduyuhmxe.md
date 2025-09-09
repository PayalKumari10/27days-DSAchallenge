---
title: "📅Week-2 (Day 2) -Real-World LLD: Building a Document Editor Inspired by Google Docs"
seoTitle: "Document Editor Design: Google Docs Inspiration"
seoDescription: "Learn to design a Google Docs-like document editor by exploring components, SOLID principles, and extensibility in real-world system design"
datePublished: Wed May 21 2025 15:03:27 GMT+0000 (Coordinated Universal Time)
cuid: cmay2oyon000609jmduyuhmxe
slug: week-2-day-2-real-world-lld-building-a-document-editor-inspired-by-google-docs
cover: https://cdn.hashnode.com/res/hashnode/image/upload/v1747829016112/c7e27b5e-f564-4540-8ef2-228cdd3aff2c.png
ogImage: https://cdn.hashnode.com/res/hashnode/image/upload/v1747839784736/968b05a1-ef40-47a0-93e1-7965036ce384.png
tags: blog, cpp, code, blogging, java, coding, system-design, dsa, techblog, coding-challenge, coding-journey, lld, lowleveldesign, 8weekslldchallenge, payalkumari11

---

> ***NOTE: - <mark>I started my 8-week system design journey with Coder Army. I will be journaling every day, recording what I learn, reflecting on it, and sharing it with my network to help newcomers to system design.</mark>***

## **💠 What are we building? A design similar to Google Docs.**

* Imagine you're writing a document online (like Google Docs). You type text 📝, add images 🖼️, save the file 💾, and maybe preview it 👀.  
    Behind the scenes, a lot of components are working together!
    

(Hindi: Sochiye aap ek online document likh rahe hain, jisme aap likh rahe hain, image daal rahe hain, save kar rahe hain — in sab ke peeche ek strong system bana hota hai jo yeh sab handle karta hai.)

## 📍Concepts Covered

* ✅ Classes & Relationships
    
* ✅ SOLID-compliant structure
    
* ✅ Extensibility & Modularity
    

(Hindi: Aaj hum seekhenge ki kaise alag-alag classes milke ek poora system banati hain, aur kaise hum ise flexible aur future-ready bana sakte hain.)

## 📍 Real-Life Analogy

Let’s say you're writing a **recipe book** .

* **TextElement** = Ingredients ya steps jo aap likh rahe hain
    
* **ImageElement** = Khana ka photo
    
* **Document** = Pura recipe book
    
* **DocumentEditor** = Aap, jo likh rahe hain
    
* **DocumentRenderer** = Print karne wali machine ya screen view
    
* **FileStorage/DBStorage** = Notebook ya Google Drive jahan aap save karte ho
    

(Hindi: Ye example humare design ko asaan aur relatable banata hai.)

## 📍System Design Overview (LLD)

Let’s understand the key components 👇

### 1) **DocumentElement (Abstract Class)**

Acts as a blueprint for elements like text and images.

(Hindi: Ye ek aisi class hai jisko use karke hum text aur image jaisa content define karte hain.)

```java
abstract class DocumentElement {
    public abstract void render();
}
```

➡️ **Subclasses:** `TextElement` & `ImageElement`  
(Hindi: In dono classes se hume pata chalta hai ki humara content kya hoga — text ya image.)

```java
class TextElement extends DocumentElement {
    void render() { /* display text */ }
}

class ImageElement extends DocumentElement {
    void render() { /* display image */ }
}
```

### 2) **Document Class**

It stores multiple elements like paragraphs and images.

(Hindi: Ye pura document represent karta hai jisme hum alag-alag content add karte hain.)

```java
class Document {
    List<DocumentElement> elements = new ArrayList<>();

    void addElement(DocumentElement el) {
        elements.add(el);
    }

    List<DocumentElement> getElements() {
        return elements;
    }
}
```

### 3) **Persistence (Abstract Class)**

*Saves data to file/database*  
(Hindi: Ye class document save karne ka kaam karti hai)

📍Implementations:

* `FileStorage` ➡️ Local save
    
* `DBStorage` ➡️ Cloud save
    

```java
abstract class Persistence {
    abstract void save(String data);
}

class FileStorage extends Persistence {
    void save(String data) { /* save to file */ }
}

class DBStorage extends Persistence {
    void save(String data) { /* save to DB */ }
}
```

### 4) **DocumentEditor**

Used to add text or image and save the document.

(Hindi: Ye editor user ke liye hai jahan se woh document me text ya image add kar sakta hai.)

```java
class DocumentEditor {
    Document doc = new Document();

    void addText(String text) {
        doc.addElement(new TextElement());
    }

    void addImage(String path) {
        doc.addElement(new ImageElement());
    }
}
```

### 5) **DocumentRenderer**

Used to render/display the document on screen or paper.

(Hindi: Iska kaam document ko screen ya printer pe dikhana hai.)

```java
class DocumentRenderer {
    void render(Document doc) {
        for (DocumentElement el : doc.getElements()) {
            el.render();
        }
    }
}
```

## 📍 Relationships Between Classes

* **Document** contains multiple **DocumentElements** (Composition)  
    (Hindi: Document ke andar kai content elements hote hain.)
    
* **DocumentEditor** uses **Document** and **Persistence** to save and update  
    (Hindi: Editor document me changes karta hai aur usse save karta hai.)
    
* **TextElement** & **ImageElement** inherit from **DocumentElement**  
    (Hindi: Ye dono classes ek common base se aati hain — isse code reuse hota hai.)
    

## 💠SOLID Principles at Work

| Principle | How it's Used | Hindi Explanation |
| --- | --- | --- |
| S - Single Responsibility | Each class does one thing only | Har class ka ek hi kaam hai |
| O - Open/Closed | Easy to extend with new elements | Naye features easily add ho sakte hain |
| L - Liskov Substitution | Subclasses can replace base class | Subclasses ko base ki jagah use kar sakte ho |
| I - Interface Segregation | Small, focused interfaces | Sirf jarurat ke methods |
| D - Dependency Inversion | Depends on abstraction | High-level modules abstractions pe depend karte hain |

## 💠Extensibility & Modularity

* Want to support **videos** in the future? Add a `VideoElement`.  
    (Hindi: Future me video support chahiye? Ek nayi class banao aur kaam ho gaya!)
    
* Want to save to cloud? Add a `CloudStorage` class.  
    (Hindi: Cloud me save karna hai? Nayi class likho aur bas!)
    

## 💠Final Thoughts

Designing a Google Docs-like editor helped me understand how real-world applications work from the inside.

(Hindi: Is project se mujhe samajh aaya ki bade applications jaise Google Docs kaise internally kaam karte hain.)

Everything is built in parts — and every part is reusable, replaceable, and extendable

![](https://cdn.hashnode.com/res/hashnode/image/upload/v1757420137104/4efa3fe3-d9be-4870-a9c8-ba44cb4366ee.png align="center")

```java
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

// Interface for document elements
interface DocumentElement {
    public abstract String render();
}

// Concrete implementation for text elements
class TextElement implements DocumentElement {
    private String text;

    public TextElement(String text) {
        this.text = text;
    }

    @Override
    public String render() {
        return text;
    }
}

// Concrete implementation for image elements
class ImageElement implements DocumentElement {
    private String imagePath;

    public ImageElement(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String render() {
        return "[Image: " + imagePath + "]";
    }
}

// NewLineElement represents a line break in the document.
class NewLineElement implements DocumentElement {
    @Override
    public String render() {
        return "\n";
    }
}

// TabSpaceElement represents a tab space in the document.
class TabSpaceElement implements DocumentElement {
    @Override
    public String render() {
        return "\t";
    }
}

// Document class responsible for holding a collection of elements
class Document {
    private List<DocumentElement> documentElements = new ArrayList<>();

    public void addElement(DocumentElement element) {
        documentElements.add(element);
    }

    // Renders the document by concatenating the render output of all elements.
    public String render() {
        StringBuilder result = new StringBuilder();
        for (DocumentElement element : documentElements) {
            result.append(element.render());
        }
        return result.toString();
    }
}

// Persistence Interface
interface Persistence {
    void save(String data);
}

// FileStorage implementation of Persistence
class FileStorage implements Persistence {
    @Override
    public void save(String data) {
        try {
            FileWriter outFile = new FileWriter("document.txt");
            outFile.write(data);
            outFile.close();
            System.out.println("Document saved to document.txt");
        } catch (IOException e) {
            System.out.println("Error: Unable to open file for writing.");
        }
    }
}

// Placeholder DBStorage implementation
class DBStorage implements Persistence {
    @Override
    public void save(String data) {
        // Save to DB
    }
}

// DocumentEditor class managing client interactions
class DocumentEditor {
    private Document document;
    private Persistence storage;
    private String renderedDocument = "";

    public DocumentEditor(Document document, Persistence storage) {
        this.document = document;
        this.storage = storage;
    }

    public void addText(String text) {
        document.addElement(new TextElement(text));
    }

    public void addImage(String imagePath) {
        document.addElement(new ImageElement(imagePath));
    }

    // Adds a new line to the document.
    public void addNewLine() {
        document.addElement(new NewLineElement());
    }

    // Adds a tab space to the document.
    public void addTabSpace() {
        document.addElement(new TabSpaceElement());
    }

    public String renderDocument() {
        if (renderedDocument.isEmpty()) {
            renderedDocument = document.render();
        }
        return renderedDocument;
    }

    public void saveDocument() {
        storage.save(renderDocument());
    }
}

// Client usage example
public class DocumentEditorClient {
    public static void main(String[] args) {
        Document document = new Document();
        Persistence persistence = new FileStorage();

        DocumentEditor editor = new DocumentEditor(document, persistence);

        // Simulate a client using the editor with common text formatting features.
        editor.addText("Hello, world!");
        editor.addNewLine();
        editor.addText("This is a real-world document editor example.");
        editor.addNewLine();
        editor.addTabSpace();
        editor.addText("Indented text after a tab space.");
        editor.addNewLine();
        editor.addImage("picture.jpg");

        // Render and display the final document.
        System.out.println(editor.renderDocument());

        editor.saveDocument();
    }
}
```

### **Week - 2 (Day 2) Completed ✅ System Design**

> ***NOTE : - A big thanks to my mentors*** [***<mark>Rohit Negi</mark> <mark>Sir</mark>***](https://www.linkedin.com/in/rohit-negi9/) ***and*** ***<mark>Aditya</mark>*** ***<mark>Sir</mark>*** [***fo***](https://www.linkedin.com/in/adityatandon2/)***r launching this amazing <mark>8-week course</mark> absolutely <mark>free</mark> on YouTube via <mark>CoderArmy9 </mark> :-*** [***youtube.com/@CoderArmy9***](http://youtube.com/@CoderArmy9) [***. 🙌***](https://www.youtube.com/@CoderArmy9)

👉 **Share this blog with your connections!** Let’s keep learning, growing, and supporting one another on this journey. 🚀

✍️ [***Payal Kumari***](https://www.linkedin.com/in/payalkumari10/) 👩‍💻 [**Github**](https://github.com/PayalKumari10)

![](https://cdn.hashnode.com/res/hashnode/image/upload/v1747838984908/a4ff2e93-c7a8-4f69-93bf-975d78a4885a.jpeg align="center")

**Jai Hind 🇮🇳 | #CoderArmy #LearningInPublic #SystemDesign #TechForAll #MentorshipMatters** [**#8weeksLLdChallenge**](https://www.youtube.com/hashtag/8weekslldchallenge) [**#LowLevelDesign** **#Code #LLD**](https://www.youtube.com/hashtag/8weekslldchallenge) [**#OOP**](https://www.youtube.com/hashtag/lowleveldesign)

%[https://youtu.be/MT9qZFGQXOU?si=I5G0V7y3kbrnl_vX]
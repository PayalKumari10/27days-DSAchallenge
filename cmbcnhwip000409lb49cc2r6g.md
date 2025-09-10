---
title: "📅 Week-3 (Day-5) Understanding the Command Design Pattern: Real-World Examples and Code"
seoTitle: "Understanding the Command Pattern: Examples & Code"
seoDescription: "Learn about the Command Design Pattern through real-world examples and code to build scalable systems and enhance your system design skills"
datePublished: Sat May 31 2025 19:54:36 GMT+0000 (Coordinated Universal Time)
cuid: cmbcnhwip000409lb49cc2r6g
slug: week-3-day-5-understanding-the-command-design-pattern-real-world-examples-and-code
cover: https://cdn.hashnode.com/res/hashnode/image/upload/v1748717993786/993452d0-0a8c-4429-81a7-e141202bda4a.png
ogImage: https://cdn.hashnode.com/res/hashnode/image/upload/v1748721136785/98084ab4-4ee7-4d84-a952-f10c643117e9.png
tags: cpp, blogging, java, technology, coding, hashnode, dsa, techblog, coding-challenge, technical-writing-1, coding-journey, low-level-design, lld, coderarmy, payalkumari11

---

> ***NOTE: - <mark>I </mark>*** <mark>started my 8-week system design journey with Coder Army. I will be journaling every day, recording what I learn, reflecting on it, and sharing it with my network to help newcomers to system design.</mark>

💠 **What is the Command Design Pattern?**

The **Command Pattern** is like giving instructions to your smart devices but in a way that’s reusable, organized, and flexible.

It’s a behavioral design pattern that **encapsulates a request as an object**, allowing you to **queue, execute, and even undo** actions — just like a remote control for your home appliances.

(Hindi: Command Design Pattern ek design technique hai jisme hum kisi bhi action (jaise light on/off karna) ko ek object ke form mein store kar lete hain. Isse hum wo command future mein reuse, undo, ya queue bhi kar sakte hain — bilkul ek smart remote ki tarah jo har device ke liye kaam karta hai.)

> ***Tech Note:***<mark><br>"Encapsulate a request as an object, thereby letting you parameterize clients with different requests, queue or log requests, and support undoable operations."<br>(For those preparing for technical interviews or formal definitions!)</mark>

### 💠 **Real-Life Example: Smart Home Automation**

Imagine you have a smart home setup:

* You want to **turn the lights ON**, **switch the fan OFF**, and **undo** the last action…
    
* Instead of hardcoding all actions, you create **command objects** for each action.
    

So you have:

🔘 `LightOnCommand`  
🔘 `FanOffCommand`  
🔘 `UndoLastCommand`

Each of these commands knows **what device to control** and **how to perform the action**, but your main controller (called the **Invoker**) doesn't care about the actual device — it just runs the command when needed.

(Hindi: Sochiye aapke paas ek smart home remote hai — aap har device ke liye ek alag command object banate ho. Jaise "LightOnCommand", "FanOffCommand", etc. Fir aapka remote (Invoker) sirf commands execute karta hai bina yeh jaane ki actual kaam kaise ho raha hai.)

### **💠Why Use the Command Pattern?**

* **Decouples** objects – Controller doesn’t need to know how device works
    
* **Reusable & Extensible** – Add new commands without changing old code
    
* **Undo functionality** – You can reverse actions easily
    
* **Perfect for automation systems, IoT platforms, task schedulers**
    

(Hindi:  
✅ Har device ko remote se alag kar deta hai  
✅ Naye actions add karna easy hota hai  
✅ Undo feature banana possible hota hai  
✅ Automation ya IoT system ke liye perfect hai)

## 💠UML Diagrams

![](https://cdn.hashnode.com/res/hashnode/image/upload/v1748721036296/2136bb45-75d8-4f57-9399-88dfd148405c.png align="center")

![](https://cdn.hashnode.com/res/hashnode/image/upload/v1748721018003/22fa3eb1-d56e-4c15-8ccc-695ef248b0f2.png align="center")

## 💠Code

```java
// ----------------------------
// Command Interface
// ----------------------------
interface Command {
    void execute();
    void undo();
}

// ----------------------------
// Receivers
// ----------------------------
class Light {
    public void on()  {
        System.out.println("Light is ON");
    }
    public void off() {
        System.out.println("Light is OFF");
    }
}

class Fan {
    public void on()  {
        System.out.println("Fan is ON");
    }
    public void off() {
        System.out.println("Fan is OFF");
    }
}

// ----------------------------
// Concrete Command for Light
// ----------------------------
class LightCommand implements Command {
    private Light light;

    public LightCommand(Light l) {
        this.light = l;
    }

    public void execute() {
        light.on();
    }

    public void undo() {
        light.off();
    }
}

// ----------------------------
// Concrete Command for Fan
// ----------------------------
class FanCommand implements Command {
    private Fan fan;

    public FanCommand(Fan f) {
        this.fan = f;
    }

    public void execute() {
        fan.on();
    }

    public void undo() {
        fan.off();
    }
}

// ----------------------------
// Invoker: Remote Controller with static array of 4 buttons
// ----------------------------
class RemoteController {
    private static final int numButtons = 4;
    private Command[] buttons;
    private boolean[] buttonPressed;

    public RemoteController() {
        buttons = new Command[numButtons];
        buttonPressed = new boolean[numButtons];
        for (int i = 0; i < numButtons; i++) {
            buttons[i] = null;
            buttonPressed[i] = false;  // false = off, true = on
        }
    }

    public void setCommand(int idx, Command cmd) {
        if (idx >= 0 && idx < numButtons) {
            buttons[idx] = cmd;
            buttonPressed[idx] = false;
        }
    }

    public void pressButton(int idx) {
        if (idx >= 0 && idx < numButtons && buttons[idx] != null) {
            if (!buttonPressed[idx]) {
                buttons[idx].execute();
            } else {
                buttons[idx].undo();
            }
            buttonPressed[idx] = !buttonPressed[idx];
        } else {
            System.out.println("No command assigned at button " + idx);
        }
    }
}

// ----------------------------
// Main Application
// ----------------------------
public class CommandPattern {
    public static void main(String[] args) {
        Light livingRoomLight = new Light();
        Fan ceilingFan = new Fan();

        RemoteController remote = new RemoteController();

        remote.setCommand(0, new LightCommand(livingRoomLight));
        remote.setCommand(1, new FanCommand(ceilingFan));

        // Simulate button presses (toggle behavior)
        System.out.println("--- Toggling Light Button 0 ---");
        remote.pressButton(0);  // ON
        remote.pressButton(0);  // OFF

        System.out.println("--- Toggling Fan Button 1 ---");
        remote.pressButton(1);  // ON
        remote.pressButton(1);  // OFF

        // Press unassigned button to show default message
        System.out.println("--- Pressing Unassigned Button 2 ---");
        remote.pressButton(2);
    }
}
```

### 💠Final Thoughts

The **Command Pattern** is not just theory — it’s the real-world logic behind smart devices, task queues, game controls, and more.  
If you're serious about building **scalable**, **maintainable**, and **decoupled systems**, this is a pattern you must know! 🌟

(Hindi: Command Pattern sirf ek concept nahi, balki smart homes, task automation, aur game systems ka real-world base hai. Agar aap scalable aur clean systems banana chahte hain, toh ye pattern zaroor seekhiye.)

### **Week - 3 ( Day-5 ) Completed ✅ System Design**

> ***NOTE : - A big thanks to my mentors <mark>Rohit Negi</mark> <mark>Sir </mark> and*** [***<mark>Aditya</mark>***](https://www.linkedin.com/in/adityatandon2/) [***<mark>Sir</mark> fo***](https://www.linkedin.com/in/adityatandon2/)***r launching this amazing <mark>8-week course</mark> absolutely <mark>free</mark> on YouTube via <mark>CoderArmy9 </mark> :-*** [***https://www.youtube.com/@CoderArmy9***](https://www.youtube.com/@CoderArmy9) [***. 🙌***](https://www.youtube.com/@CoderArmy9)

👉 **Share this blog with your connections!** Let’s keep learning, growing, and supporting one another on this journey. 🚀

✍️ [*Payal Kumari*](https://www.linkedin.com/in/payalkumari10/) 👩‍💻

![](https://cdn.hashnode.com/res/hashnode/image/upload/v1748719862963/69b3c423-a8a6-43a6-a8b0-264481b3b91c.jpeg align="center")

**Jai Hind 🇮🇳 | #CoderArmy #LearningInPublic #SystemDesign #TechForAll #MentorshipMatters** [**#8weeksLLdChallenge**](https://www.youtube.com/hashtag/8weekslldchallenge) [**#LowLevelDesign**](https://www.youtube.com/hashtag/lowleveldesign) #Code [**#LLD**](https://www.youtube.com/hashtag/lld) **#OOP** **👩‍💻**

%[https://youtu.be/cnQZsN0jxEY?si=bwWzPDCsNwg9JseU]
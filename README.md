---

<h3 align="center">
⚠️ Disclamer This repo is a version of the <a href="https://github.com/kamranahmedse/design-patterns-for-humans">original </a> built by <a href="https://twitter.com/kamranahmedse">@kamranahmedse</a>.
</h3>
<p align="center">
<b>All the credits are from him and I'm just adapting the code to Java because is my actual language at work.</b>
</p>

---

![Design Patterns For Humans](https://cloud.githubusercontent.com/assets/11269635/23065273/1b7e5938-f515-11e6-8dd3-d0d58de6bb9a.png)

---

<p align="center">
🎉 Ultra-simplified explanation to design patterns! 🎉
</p>
<p align="center">
A topic that can easily make anyone's mind wobble. Here I try to make them stick in to your mind(and maybe mine) by explaining them in the <i>simplest</i> way possible.
</p>

---

# Introduction

Design patterns are solutions to recurring problems; **guidelines on how to tackle certain problems**. They are not classes, packages or libraries that you can plug into your application and wait for the magic to happen. These are, rather, guidelines on how to tackle certain problems in certain situations.

> Design patterns are solutions to recurring problems; guidelines on how to tackle certain problems

Wikipedia describes them as

> In software engineering, a software design pattern is a general reusable solution to a commonly occurring problem within a given context in software design. It is not a finished design that can be transformed directly into source or machine code. It is a description or template for how to solve a problem that can be used in many different situations.

## ⚠️ Be Careful

- Design patterns are not a silver bullet to all your problems.
- Do not try to force them; bad things are supposed to happen, if done so.
- Keep in mind that design patterns are solutions **to** problems, not solutions **finding** problems; so don't overthink.
- If used in a correct place in a correct manner, they can prove to be a savior; or else they can result in a horrible mess of a code.

> Also note that the code samples below are in Java, however this shouldn't stop you because the concepts are same anyways.

## Types of Design Patterns

- [Creational](#creational-design-patterns)
- [Structural](#structural-design-patterns)
- [Behavioral](#behavioral-design-patterns)

# Creational Design Patterns

In plain words

> Creational patterns are focused towards how to instantiate an object or group of related objects.

Wikipedia says

> In software engineering, creational design patterns are design patterns that deal with object creation mechanisms, trying to create objects in a manner suitable to the situation. The basic form of object creation could result in design problems or added complexity to the design. Creational design patterns solve this problem by somehow controlling this object creation.

- [Simple Factory](#-simple-factory)
- [Factory Method](#-factory-method)
- [Abstract Factory](#-abstract-factory)
- [Builder](#-builder)
- [Prototype](#-prototype)
- [Singleton](#-singleton)

## 🏠 Simple Factory

Real world example

> Consider, you are building a house and you need doors. You can either put on your carpenter clothes, bring some wood, glue, nails and all the tools required to build the door and start building it in your house or you can simply call the factory and get the built door delivered to you so that you don't need to learn anything about the door making or to deal with the mess that comes with making it.

In plain words

> Simple factory simply generates an instance for client without exposing any instantiation logic to the client

Wikipedia says

> In object-oriented programming(OOP), a factory is an object for creating other objects – formally a factory is a function or method that returns objects of a varying prototype or class from some method call, which is assumed to be "new".

**Programmatic Example**

First of all we have a door interface and the implementation

```java
public interface IDoor {
    float getWidth();

    float getHeight();
}

public class WoodenDoor implements IDoor {

    private float width;
    private float height;

    public WoodenDoor(float width, float height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public float getWidth() {
        return width;
    }

    @Override
    public float getHeight() {
        return height;
    }
}
```

Then we have our door factory that makes the door and returns it

```java
public class DoorFactory {
    public static WoodenDoor MakeDoor(float width, float height) {
        return new WoodenDoor(width, height);
    }
}
```

And then it can be used as

```java
// Make me a door of 100x200
WoodenDoor door = DoorFactory.MakeDoor(100, 200);

System.out.println("Width " + door.getWidth() + " ");
System.out.println("Height " + door.getHeight() + " ");

// Make me a door of 50x100
WoodenDoor door2 = DoorFactory.MakeDoor(50, 100);

System.out.println("Width " + door2.getWidth() + " ");
System.out.println("Height " + door2.getHeight() + " ");
```

**When to Use?**

When creating an object is not just a few assignments and involves some logic, it makes sense to put it in a dedicated factory instead of repeating the same code everywhere.

## 🏭 Factory Method

Real world example

> Consider the case of a hiring manager. It is impossible for one person to interview for each of the positions. Based on the job opening, she has to decide and delegate the interview steps to different people.

In plain words

> It provides a way to delegate the instantiation logic to child classes.

Wikipedia says

> In class-based programming, the factory method pattern is a creational pattern that uses factory methods to deal with the problem of creating objects without having to specify the exact class of the object that will be created. This is done by creating objects by calling a factory method—either specified in an interface and implemented by child classes, or implemented in a base class and optionally overridden by derived classes—rather than by calling a constructor.

**Programmatic Example**

Taking our hiring manager example above. First of all we have an interviewer interface and some implementations for it

```java
public interface IInterviewer {
    String AskQuestions();
}

public class Developer implements IInterviewer {
    @Override
    public String AskQuestions() {
        return "Asking about design patterns!";
    }
}

public class CommunityExecutive implements IInterviewer {
    @Override
    public String AskQuestions() {
        return "Asking about community building";
    }
}
```

Now let us create our `HiringManager`

```java
public abstract class HiringManager {
    // Factory method
    abstract protected IInterviewer MakeInterviewer();

    public String TakeInterview() {
        IInterviewer interviewer = MakeInterviewer();
        return interviewer.AskQuestions();
    }
}
```

Now any child can extend it and provide the required interviewer

```java
public class DevelopmentManager extends HiringManager {
    @Override
    protected IInterviewer MakeInterviewer() {
        return new Developer();
    }
}

public class MarketingManager extends HiringManager {
    @Override
    protected IInterviewer MakeInterviewer() {
        return new CommunityExecutive();
    }
}
```

and then it can be used as

```java
DevelopmentManager devManager = new DevelopmentManager();
System.out.println(devManager.TakeInterview()); // Output: Asking about design patterns

MarketingManager marketingManager = new MarketingManager();
System.out.println(marketingManager.TakeInterview()); // Output: Asking about community building.
```

**When to use?**

Useful when there is some generic processing in a class but the required sub-class is dynamically decided at runtime. Or putting it in other words, when the client doesn't know what exact sub-class it might need.

## 🔨 Abstract Factory

Real world example

> Extending our door example from Simple Factory. Based on your needs you might get a wooden door from a wooden door shop, iron door from an iron shop or a PVC door from the relevant shop. Plus you might need a guy with different kind of specialities to fit the door, for example a carpenter for wooden door, welder for iron door etc. As you can see there is a dependency between the doors now, wooden door needs carpenter, iron door needs a welder etc.

In plain words

> A factory of factories; a factory that groups the individual but related/dependent factories together without specifying their concrete classes.

Wikipedia says

> The abstract factory pattern provides a way to encapsulate a group of individual factories that have a common theme without specifying their concrete classes

**Programmatic Example**

Translating the door example above. First of all we have our `Door` interface and some implementation for it

```java
public interface IDoor {
    String GetDescription();
}

public class WoodenDoor implements IDoor {
    @Override
    public String GetDescription() {
        return "I am a wooden door";
    }
}

public class IronDoor implements IDoor {
    @Override
    public String GetDescription() {
        return "I am a iron door";
    }
}
```

Then we have some fitting experts for each door type

```java
public interface IDoorFittingExpert {
    String GetDescription();
}

public class Welder implements IDoorFittingExpert {
    @Override
    public String GetDescription() {
        return "I can only fit iron doors";
    }
}

public class Carpenter implements IDoorFittingExpert {
    @Override
    public String GetDescription() {
        return "I can only fit wooden doors";
    }
}
```

Now we have our abstract factory that would let us make family of related objects i.e. wooden door factory would create a wooden door and wooden door fitting expert and iron door factory would create an iron door and iron door fitting expert

```java
public interface IDoorFactory {
    IDoor MakeDoor();

    IDoorFittingExpert MakeFittingExpert();
}

// Wooden factory to return carpenter and wooden door
public class WoodenDoorFactory implements IDoorFactory {
    @Override
    public IDoor MakeDoor() {
        return new WoodenDoor();
    }

    @Override
    public IDoorFittingExpert MakeFittingExpert() {
        return new Carpenter();
    }
}

// Iron door factory to get iron door and the relevant fitting expert
public class IronDoorFactory implements IDoorFactory {
    @Override
    public IDoor MakeDoor() {
        return new IronDoor();
    }

    @Override
    public IDoorFittingExpert MakeFittingExpert() {
        return new Welder();
    }
}
```

And then it can be used as

```java
WoodenDoorFactory woodenFactory = new WoodenDoorFactory();

IDoor door = woodenFactory.MakeDoor();
IDoorFittingExpert expert = woodenFactory.MakeFittingExpert();

System.out.println(door.GetDescription()); // Output: I am a wooden door
System.out.println(expert.GetDescription()); // Output: I can only fit wooden doors

// Same for Iron Factory
IronDoorFactory ironFactory = new IronDoorFactory();

door = ironFactory.MakeDoor();
expert = ironFactory.MakeFittingExpert();

System.out.println(door.GetDescription()); // Output: I am an iron door
System.out.println(expert.GetDescription()); // Output: I can only fit iron doors
```

As you can see the wooden door factory has encapsulated the `carpenter` and the `wooden door` also iron door factory has encapsulated the `iron door` and `welder`. And thus it had helped us make sure that for each of the created door, we do not get a wrong fitting expert.

**When to use?**

When there are interrelated dependencies with not-that-simple creation logic involved

## 👷 Builder

Real world example

> Imagine you are at Hardee's and you order a specific deal, lets say, "Big Hardee" and they hand it over to you without _any questions_; this is the example of simple factory. But there are cases when the creation logic might involve more steps. For example you want a customized Subway deal, you have several options in how your burger is made e.g what bread do you want? what types of sauces would you like? What cheese would you want? etc. In such cases builder pattern comes to the rescue.

In plain words

> Allows you to create different flavors of an object while avoiding constructor pollution. Useful when there could be several flavors of an object. Or when there are a lot of steps involved in creation of an object.

Wikipedia says

> The builder pattern is an object creation software design pattern with the intentions of finding a solution to the telescoping constructor anti-pattern.

Having said that let me add a bit about what telescoping constructor anti-pattern is. At one point or the other we have all seen a constructor like below:

```java
public Burger(int size, Boolean cheese = true, Boolean pepperoni = true, Boolean tomato = false, Boolean lettuce = true)
{
}
```

As you can see; the number of constructor parameters can quickly get out of hand and it might become difficult to understand the arrangement of parameters. Plus this parameter list could keep on growing if you would want to add more options in future. This is called telescoping constructor anti-pattern.

**Programmatic Example**

The sane alternative is to use the builder pattern. First of all we have our burger that we want to make

```java
public class Burger {
    protected int size;
    protected Boolean cheese = false;
    protected Boolean pepperoni = false;
    protected Boolean lettuce = false;
    protected Boolean tomato = false;

    public Burger(BurgerBuilder builder) {
        this.size = builder.size;
        this.cheese = builder.cheese;
        this.pepperoni = builder.pepperoni;
        this.lettuce = builder.lettuce;
        this.tomato = builder.tomato;
    }

    @Override
    public String toString() {
        return "Burger{" +
                "size=" + size +
                ", cheese=" + cheese +
                ", pepperoni=" + pepperoni +
                ", lettuce=" + lettuce +
                ", tomato=" + tomato +
                '}';
    }
}
```

And then we have the builder

```java
public class BurgerBuilder {
    protected int size;
    protected Boolean cheese = false;
    protected Boolean pepperoni = false;
    protected Boolean lettuce = false;
    protected Boolean tomato = false;

    public BurgerBuilder(int size) {
        this.size = size;
    }

    public BurgerBuilder AddPepperoni() {
        this.pepperoni = true;
        return this;
    }

    public BurgerBuilder AddLettuce() {
        this.lettuce = true;
        return this;
    }

    public BurgerBuilder AddCheese() {
        this.cheese = true;
        return this;
    }

    public BurgerBuilder AddTomato() {
        this.tomato = true;
        return this;
    }

    public Burger Build() {
        return new Burger(this);
    }
}
```

And then it can be used as:

```java
Burger burger = new BurgerBuilder(14)
                .AddPepperoni()
                .AddLettuce()
                .AddTomato()
                .Build();

System.out.println(burger);
```

**When to use?**

When there could be several flavors of an object and to avoid the constructor telescoping. The key difference from the factory pattern is that; factory pattern is to be used when the creation is a one step process while builder pattern is to be used when the creation is a multi step process.

## 🐑 Prototype

Real world example

> Remember dolly? The sheep that was cloned! Lets not get into the details but the key point here is that it is all about cloning

In plain words

> Create object based on an existing object through cloning.

Wikipedia says

> The prototype pattern is a creational design pattern in software development. It is used when the type of objects to create is determined by a prototypical instance, which is cloned to produce new objects.

In short, it allows you to create a copy of an existing object and modify it to your needs, instead of going through the trouble of creating an object from scratch and setting it up.

**Programmatic Example**

In Java, it can be easily done implementing the Clonable interface

```java
public class Sheep implements Cloneable {
    protected String name;
    protected String category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Sheep(String name, String category) {
        this.name = name;
        this.category = this.category == null ? "Mountain Sheep" : category;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Sheep sheep;
        try {
            sheep = (Sheep) super.clone();
        } catch (CloneNotSupportedException e) { // this should never happen
            System.out.println("CloneNotSupportedException thrown " + e);
            return null;
        }
        return sheep;
    }
}
```

Then it can be cloned like below

```java
Sheep original = new Sheep("Jolly", null);

// Clone and modify what is required
Sheep cloned = (Sheep) original.clone();
cloned.setName("Dolly");
cloned.setCategory("Cloned Sheep");

System.out.println(original.getName()); // Jolly
System.out.println(original.getCategory()); // Mountain Sheep
        
System.out.println(cloned.getName()); // Dolly
System.out.println(cloned.getCategory()); // Mountain sheep
```

**When to use?**

When an object is required that is similar to existing object or when the creation would be expensive as compared to cloning.

## 💍 Singleton

Real world example

> There can only be one president of a country at a time. The same president has to be brought to action, whenever duty calls. President here is singleton.

In plain words

> Ensures that only one object of a particular class is ever created.

Wikipedia says

> In software engineering, the singleton pattern is a software design pattern that restricts the instantiation of a class to one object. This is useful when exactly one object is needed to coordinate actions across the system.

Singleton pattern is actually considered an anti-pattern and overuse of it should be avoided. It is not necessarily bad and could have some valid use-cases but should be used with caution because it introduces a global state in your application and change to it in one place could affect in the other areas and it could become pretty difficult to debug. The other bad thing about them is it makes your code tightly coupled plus mocking the singleton could be difficult.

**Programmatic Example**

To create a singleton, make the constructor private, disable cloning, disable extension and create a static variable to house the instance

```java
public final class President
{
    private static President instance;

    private President()
    {
        // Hide the constructor
    }

    public static President getInstance()
    {
         if(instance == null)
            {
                instance = new President();
            }
            return instance;
    }
}
```

Then in order to use

```java
President p1 = President.getInstance();
President p2 = President.getInstance();

System.out.println(p1.equals(p2)); // true
```

# Structural Design Patterns

In plain words

> Structural patterns are mostly concerned with object composition or in other words how the entities can use each other. Or yet another explanation would be, they help in answering "How to build a software component?"

Wikipedia says

> In software engineering, structural design patterns are design patterns that ease the design by identifying a simple way to realize relationships between entities.

- [Adapter](#-adapter)
- [Bridge](#-bridge)
- [Composite](#-composite)
- [Decorator](#-decorator)
- [Facade](#-facade)
- [Flyweight](#-flyweight)
- [Proxy](#-proxy)

## 🔌 Adapter

Real world example

> Consider that you have some pictures in your memory card and you need to transfer them to your computer. In order to transfer them you need some kind of adapter that is compatible with your computer ports so that you can attach memory card to your computer. In this case card reader is an adapter.
> Another example would be the famous power adapter; a three legged plug can't be connected to a two pronged outlet, it needs to use a power adapter that makes it compatible with the two pronged outlet.
> Yet another example would be a translator translating words spoken by one person to another

In plain words

> Adapter pattern lets you wrap an otherwise incompatible object in an adapter to make it compatible with another class.

Wikipedia says

> In software engineering, the adapter pattern is a software design pattern that allows the interface of an existing class to be used as another interface. It is often used to make existing classes work with others without modifying their source code.

**Programmatic Example**

Consider a game where there is a hunter and he hunts lions.

First we have an interface `Lion` that all types of lions have to implement

```java
public interface Lion {
    String roar();
}

public class AfricanLion implements Lion {
    @Override
    public String roar() {
        return "Roar!";
    }
}

public class AsianLion implements Lion {
    @Override
    public String roar() {
        return "Roar!";
    }
}
```

And hunter expects any implementation of `Lion` interface to hunt.

```java
public class Hunter {

    public String hunt(Lion lion) {
        return lion.roar();
    }

}
```

Now let's say we have to add a `WildDog` in our game so that hunter can hunt that also. But we can't do that directly because dog has a different interface. To make it compatible for our hunter, we will have to create an adapter that is compatible

```java
// This needs to be added to the game
public class WildDog {
    public String bark() {
        return "Bark";
    }
}

// Adapter around wild dog to make it compatible with our game
public class WildDogAdapter implements Lion {

    protected WildDog dog;

    public WildDogAdapter(WildDog dog) {
        this.dog = dog;
    }

    @Override
    public String roar() {
        return this.dog.bark();
    }
}
```

And now the `WildDog` can be used in our game using `WildDogAdapter`.

```java
 WildDog wildDog = new WildDog();
 WildDogAdapter wildDogAdapter = new WildDogAdapter(wildDog);

 Hunter hunter = new Hunter();
 System.out.println(hunter.hunt(wildDogAdapter));
```

## 🚡 Bridge

Real world example

> Consider you have a website with different pages and you are supposed to allow the user to change the theme. What would you do? Create multiple copies of each of the pages for each of the themes or would you just create separate theme and load them based on the user's preferences? Bridge pattern allows you to do the second i.e.

![With and without the bridge pattern](https://cloud.githubusercontent.com/assets/11269635/23065293/33b7aea0-f515-11e6-983f-98823c9845ee.png)

In Plain Words

> Bridge pattern is about preferring composition over inheritance. Implementation details are pushed from a hierarchy to another object with a separate hierarchy.

Wikipedia says

> The bridge pattern is a design pattern used in software engineering that is meant to "decouple an abstraction from its implementation so that the two can vary independently"

**Programmatic Example**

Translating our WebPage example from above. Here we have the `WebPage` hierarchy

```java
public interface WebPage {
    String getContent();
}

public class About implements WebPage {
    protected Theme theme;

    public About(Theme theme) {
        this.theme = theme;
    }

    @Override
    public String getContent() {
        return "About page in " + this.theme.color();
    }
}

public class Careers implements WebPage {
    protected Theme theme;

    public Careers(Theme theme) {
        this.theme = theme;
    }

    @Override
    public String getContent() {
        return "Careers page in " + this.theme.color();
    }
}
```

And the separate theme hierarchy

```java
public interface Theme {
    String color();
}

public class DarkTheme implements Theme {
    public String color = "Dark Black";

    public String color() {
        return color;
    }
}

public class LigthTheme implements Theme {
    public String color = "Ligth";

    public String color() {
        return color;
    }
}

public class AquaTheme implements Theme {
    public String color = "Light Blue";

    public String color() {
        return color;
    }
}
```

And both the hierarchies

```java
DarkTheme darkTheme = new DarkTheme();

About about = new About(darkTheme);
Careers careers = new Careers(darkTheme);

System.out.println(about.getContent()); // "About page in Dark Black";
System.out.println(careers.getContent()); // "Careers page in Dark Black";
```

## 🌿 Composite

Real world example

> Every organization is composed of employees. Each of the employees has the same features i.e. has a salary, has some responsibilities, may or may not report to someone, may or may not have some subordinates etc.

In plain words

> Composite pattern lets clients treat the individual objects in a uniform manner.

Wikipedia says

> In software engineering, the composite pattern is a partitioning design pattern. The composite pattern describes that a group of objects is to be treated in the same way as a single instance of an object. The intent of a composite is to "compose" objects into tree structures to represent part-whole hierarchies. Implementing the composite pattern lets clients treat individual objects and compositions uniformly.

**Programmatic Example**

Taking our employees example from above. Here we have different employee types

```java
public interface Employee {
    String getName();

    void setSalary(float salary);

    float getSalary();

    String[] getRoles();
}

public class Developer implements Employee {
    protected String name;
    protected float salary;
    protected String[] roles = {};

    public Developer(String name, float salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public float getSalary() {
        return this.salary;
    }

    @Override
    public String[] getRoles() {
        return this.roles;
    }
}

public class Designer implements Employee {
    protected String name;
    protected float salary;
    protected String[] roles = {};

    public Designer(String name, float salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public float getSalary() {
        return this.salary;
    }

    @Override
    public String[] getRoles() {
        return this.roles;
    }
}
```

Then we have an organization which consists of several different types of employees

```java
public class Organization {

    protected List<Employee> employees = new ArrayList<Employee>();

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public float getNetSalaries() {
        return employees.stream()
                .map(Employee::getSalary)
                .reduce(0f, (a, b) -> a + b);
    }
}
```

And then it can be used as

```java
 // Prepare the employees
Developer john = new Developer("John Doe", 12000);
Designer jane = new Designer("Jane Doe", 15000);

// Add them to organization
Organization organization = new Organization();
organization.addEmployee(john);
organization.addEmployee(jane);

System.out.println("Net salaries: " + organization.getNetSalaries()); // Net Salaries: 27000
```

## ☕ Decorator

Real world example

> Imagine you run a car service shop offering multiple services. Now how do you calculate the bill to be charged? You pick one service and dynamically keep adding to it the prices for the provided services till you get the final cost. Here each type of service is a decorator.

In plain words

> Decorator pattern lets you dynamically change the behavior of an object at run time by wrapping them in an object of a decorator class.

Wikipedia says

> In object-oriented programming, the decorator pattern is a design pattern that allows behavior to be added to an individual object, either statically or dynamically, without affecting the behavior of other objects from the same class. The decorator pattern is often useful for adhering to the Single Responsibility Principle, as it allows functionality to be divided between classes with unique areas of concern.

**Programmatic Example**

Lets take coffee for example. First of all we have a simple coffee implementing the coffee interface

```java
public interface Coffee {

    int getCost();

    String getDescription();
}

public class SimpleCoffee implements Coffee {
    @Override
    public int getCost() {
        return 10;
    }

    @Override
    public String getDescription() {
        return "Simple coffee";
    }
}
```

We want to make the code extensible to allow options to modify it if required. Lets make some add-ons(decorators)

```java
public class MilkCoffee implements Coffee {
    protected Coffee coffee;

    public MilkCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public int getCost() {
        return this.coffee.getCost() + 2;
    }

    @Override
    public String getDescription() {
        return this.coffee.getDescription() + ", milk";
    }
}

public class WhipCoffee implements Coffee {
    protected Coffee coffee;

    public WhipCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public int getCost() {
        return this.coffee.getCost() + 5;
    }

    @Override
    public String getDescription() {
        return this.coffee.getDescription() + ", whip";
    }
}

public class VanillaCoffee implements Coffee {
    protected Coffee coffee;

    public VanillaCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public int getCost() {
        return this.coffee.getCost() + 3;
    }

    @Override
    public String getDescription() {
        return this.coffee.getDescription() + ", vanilla";
    }
}
```

Lets make a coffee now

```java
SimpleCoffee simpleCoffee = new SimpleCoffee();
System.out.println(simpleCoffee.getCost()); // 10
System.out.println(simpleCoffee.getDescription()); // Simple Coffee

MilkCoffee milkCoffee = new MilkCoffee(simpleCoffee);
System.out.println(milkCoffee.getCost()); // 12
System.out.println(milkCoffee.getDescription()); // Simple Coffee, milk

WhipCoffee whipCoffee = new WhipCoffee(simpleCoffee);
System.out.println(whipCoffee.getCost()); // 17
System.out.println(whipCoffee.getDescription()); // Simple Coffee, whip

VanillaCoffee vanillaCoffee = new VanillaCoffee(simpleCoffee);
System.out.println(vanillaCoffee.getCost()); // 20
System.out.println(vanillaCoffee.getDescription()); // Simple Coffee, vanilla
```

## 📦 Facade

Real world example

> How do you turn on the computer? "Hit the power button" you say! That is what you believe because you are using a simple interface that computer provides on the outside, internally it has to do a lot of stuff to make it happen. This simple interface to the complex subsystem is a facade.

In plain words

> Facade pattern provides a simplified interface to a complex subsystem.

Wikipedia says

> A facade is an object that provides a simplified interface to a larger body of code, such as a class library.

**Programmatic Example**

Taking our computer example from above. Here we have the computer class

```java
public class Computer {
    public void getElectricShock() {
        System.out.println("Ouch!");
    }

    public void makeSound() {
        System.out.println("Beep beep!");
    }

    public void showLoadingScreen() {
        System.out.println("Loading..");
    }

    public void bam() {
        System.out.println("Ready to be used!");
    }

    public void closeEverything() {
        System.out.println("Bup bup bup buzzzz!");
    }

    public void sooth() {
        System.out.println("Zzzzz");
    }

    public void pullCurrent() {
        System.out.println("Haaah!");
    }
}
```

Here we have the facade

```java
public class ComputerFacade {
    protected Computer computer;

    public ComputerFacade(Computer computer) {
        this.computer = computer;
    }

    public void turnOn() {
        this.computer.getElectricShock();
        this.computer.makeSound();
        this.computer.showLoadingScreen();
        this.computer.bam();
    }

    public void turnOff() {
        this.computer.closeEverything();
        this.computer.pullCurrent();
        this.computer.sooth();
    }
}
```

Now to use the facade

```java
ComputerFacade computer = new ComputerFacade(new Computer());
computer.turnOn(); // Ouch! Beep beep! Loading.. Ready to be used!
computer.turnOff(); // Bup bup buzzz! Haah! Zzzzz
```

## 🍃 Flyweight

Real world example

> Did you ever have fresh tea from some stall? They often make more than one cup that you demanded and save the rest for any other customer so to save the resources e.g. gas etc. Flyweight pattern is all about that i.e. sharing.

In plain words

> It is used to minimize memory usage or computational expenses by sharing as much as possible with similar objects.

Wikipedia says

> In computer programming, flyweight is a software design pattern. A flyweight is an object that minimizes memory use by sharing as much data as possible with other similar objects; it is a way to use objects in large numbers when a simple repeated representation would use an unacceptable amount of memory.

**Programmatic example**

Translating our tea example from above. First of all we have tea types and tea maker

```java
// Anything that will be cached is flyweight.
// Types of tea here will be flyweights.
public class KarakTea { }

// Acts as a factory and saves the tea
public class TeaMaker {
    protected Map<String, KarakTea> availableTea = new HashMap<String, KarakTea>();

    public KarakTea Make(String preference) {
        if (!this.availableTea.containsKey(preference)) {
            this.availableTea.put(preference, new KarakTea());
        }

        return this.availableTea.get(preference);
    }
}
```

Then we have the `TeaShop` which takes orders and serves them

```java
public class TeaShop {
    protected Map<Integer, KarakTea> orders = new HashMap<Integer, KarakTea>();

    protected TeaMaker teaMaker;

    public TeaShop(TeaMaker teaMaker) {
        this.teaMaker = teaMaker;
    }

    public void takeOrder(String teaType, int table) {
        this.orders.put(table, this.teaMaker.Make(teaType));
    }

    public void serve() {
        for (Integer table : orders.keySet()) {
            System.out.println("Serving tea to table# " + table);
        }
    }
}
```

And it can be used as below

```c#
TeaMaker teaMaker = new TeaMaker();
TeaShop shop = new TeaShop(teaMaker);

shop.takeOrder("less sugar", 1);
shop.takeOrder("more milk", 2);
shop.takeOrder("without sugar", 5);

shop.serve();
// Serving tea to table# 1
// Serving tea to table# 2
// Serving tea to table# 5
```

## 🎱 Proxy

Real world example

> Have you ever used an access card to go through a door? There are multiple options to open that door i.e. it can be opened either using access card or by pressing a button that bypasses the security. The door's main functionality is to open but there is a proxy added on top of it to add some functionality. Let me better explain it using the code example below.

In plain words

> Using the proxy pattern, a class represents the functionality of another class.

Wikipedia says

> A proxy, in its most general form, is a class functioning as an interface to something else. A proxy is a wrapper or agent object that is being called by the client to access the real serving object behind the scenes. Use of the proxy can simply be forwarding to the real object, or can provide additional logic. In the proxy extra functionality can be provided, for example caching when operations on the real object are resource intensive, or checking preconditions before operations on the real object are invoked.

**Programmatic Example**

Taking our security door example from above. Firstly we have the door interface and an implementation of door

```java
public interface IDoor {
    String open();

    String close();
}

public class LabDoor implements IDoor {
    @Override
    public String open() {
        return "Opening lab door";
    }

    @Override
    public String close() {
        return "Closing lab door";
    }
}
```

Then we have a proxy to secure any doors that we want

```java
public class SecuredDoor {

    protected IDoor door;

    public SecuredDoor(IDoor door) {
        this.door = door;
    }

    public String open(String password) {
        return this.Authenticate(password) ? this.door.open() : "Big no! It ain't possible.";
    }

    public boolean Authenticate(String password) {
        return password == "$ecr@t";
    }

    public String close() {
        return this.door.close();
    }
}
```

And here is how it can be used

```java
SecuredDoor door = new SecuredDoor(new LabDoor());
System.out.println(door.open("invalid")); // Big no! It ain't possible.

System.out.println(door.open("$ecr@t")); // Opening lab door
System.out.println(door.close()); // Closing lab door
```

Yet another example would be some sort of data-mapper implementation. For example, I recently made an ODM(Object Data Mapper) for MongoDB using this pattern where I wrote a proxy around mongo classes while utilizing the magic method `__call()`. All the method calls were proxied to the original mongo class and result retrieved was returned as it is but in case of `find` or `findOne` data was mapped to the required class objects and the object was returned instead of `Cursor`.

# Behavioral Design Patterns

In plain words

> It is concerned with assignment of responsibilities between the objects. What makes them different from structural patterns is they don't just specify the structure but also outline the patterns for message passing/communication between them. Or in other words, they assist in answering "How to run a behavior in software component?"

Wikipedia says

> In software engineering, behavioral design patterns are design patterns that identify common communication patterns between objects and realize these patterns. By doing so, these patterns increase flexibility in carrying out this communication.

- [Chain of Responsibility](#-chain-of-responsibility)
- [Command](#-command)
- [Iterator](#-iterator)
- [Mediator](#-mediator)
- [Memento](#-memento)
- [Observer](#-observer)
- [Visitor](#-visitor)
- [Strategy](#-strategy)
- [State](#-state)
- [Template Method](#-template-method)

## 🔗 Chain of Responsibility

Real world example

> For example, you have three payment methods(`A`, `B` and `C`) setup in your account; each having a different amount in it. `A` has 100 USD, `B` has 300 USD and `C` having 1000 USD and the preference for payments is chosen as `A` then `B` then `C`. You try to purchase something that is worth 210 USD. Using Chain of Responsibility, first of all account `A` will be checked if it can make the purchase, if yes purchase will be made and the chain will be broken. If not, request will move forward to account `B` checking for amount if yes chain will be broken otherwise the request will keep forwarding till it finds the suitable handler. Here `A`, `B` and `C` are links of the chain and the whole phenomenon is Chain of Responsibility.

In plain words

> It helps building a chain of objects. Request enters from one end and keeps going from object to object till it finds the suitable handler.

Wikipedia says

> In object-oriented design, the chain-of-responsibility pattern is a design pattern consisting of a source of command objects and a series of processing objects. Each processing object contains logic that defines the types of command objects that it can handle; the rest are passed to the next processing object in the chain.

**Programmatic Example**

Translating our account example above. First of all we have a base account having the logic for chaining the accounts together and some accounts

```java
public abstract class Account {
    private Account successor;
    protected float balance;

    public void setNext(Account account) {
        this.successor = account;
    }

    public void pay(float amountToPay) throws Exception {
        if (this.canPay(amountToPay)) {
            System.out.println(String.format("Paid %s using %s", amountToPay, this.getClass().getSimpleName()));
        } else if (this.successor != null) {
            System.out.println(String.format("Cannot pay using %s, proceeding..", this.getClass().getSimpleName()));
            this.successor.pay(amountToPay);
        } else {
            throw new Exception("None of the accounts have enough balance");
        }
    }

    public boolean canPay(float amount) {
        return this.balance >= amount;
    }
}

public class Bank extends Account {
    public Bank(float balance) {
        this.balance = balance;
    }
}

public class Paypal extends Account {
    public Paypal(float balance) {
        this.balance = balance;
    }
}

public class Bitcoin extends Account {
    public Bitcoin(float balance) {
        this.balance = balance;
    }
}
```

Now let's prepare the chain using the links defined above(i.e. Bank, Paypal, Bitcoin)

```java
// Let's prepare a chain like below
//      $bank->$paypal->$bitcoin
//
// First priority bank
//      If bank can't pay then paypal
//      If paypal can't pay then bit coin

Bank bank = new Bank(100); // Bank with balance 100
Paypal paypal = new Paypal(200); // Paypal with balance 200
Bitcoin bitcoin = new Bitcoin(300); // Bitcoin with balance 300

bank.setNext(paypal);
paypal.setNext(bitcoin);

// Let's try to pay using the first priority i.e. bank
bank.pay(259);

// Output will be
// ==============
// Cannot pay using bank. Proceeding ..
// Cannot pay using paypal. Proceeding ..:
// Paid 259 using Bitcoin!
```

## 👮 Command

Real world example

> A generic example would be you ordering food at a restaurant. You(i.e. `Client`) ask the waiter(i.e. `Invoker`) to bring some food(i.e. `Command`) and waiter simply forwards the request to Chef(i.e. `Receiver`) who has the knowledge of what and how to cook.
> Another example would be you(i.e. `Client`) switching on(i.e. `Command`) the television(i.e. `Receiver`) using a remote control(`Invoker`).

In plain words

> Allows you to encapsulate actions in objects. The key idea behind this pattern is to provide the means to decouple client from receiver.

Wikipedia says

> In object-oriented programming, the command pattern is a behavioral design pattern in which an object is used to encapsulate all information needed to perform an action or trigger an event at a later time. This information includes the method name, the object that owns the method and values for the method parameters.

**Programmatic Example**

First of all we have the receiver that has the implementation of every action that could be performed

```java
// Receiver
public class Bulb {
    public String turnOn() {
        return "Bulb has been lit!";
    }

    public String turnOff() {
        return "Darkness!";
    }
}
```

then we have an interface that each of the commands are going to implement and then we have a set of commands

```java
public interface Command {
    String execute();

    String undo();

    String redo();
}

public class TurnOn implements Command {
    protected Bulb bulb;

    public TurnOn(Bulb bulb) {
        this.bulb = bulb;
    }

    public String execute() {
        return this.bulb.turnOn();
    }

    public String undo() {
        return this.bulb.turnOff();
    }

    public String redo() {
        return this.bulb.turnOn();
    }
}

public class TurnOff implements Command {
    protected Bulb bulb;

    public TurnOff(Bulb bulb) {
        this.bulb = bulb;
    }

    public String execute() {
        return this.bulb.turnOff();
    }

    public String undo() {
        return this.bulb.turnOn();
    }

    public String redo() {
        return this.bulb.turnOff();
    }
}
```

Then we have an `Invoker` with whom the client will interact to process any commands

```java
// Invoker
public class RemoteControl {
    public String submit(Command command) {
        return command.execute();
    }
}
```

Finally let's see how we can use it in our client

```java
 Bulb bulb = new Bulb();

TurnOn turnOn = new TurnOn(bulb);
TurnOff turnOff = new TurnOff(bulb);

RemoteControl remote = new RemoteControl();
remote.submit(turnOn); // Bulb has been lit!
remote.submit(turnOff); // Darkness!
```

Command pattern can also be used to implement a transaction based system. Where you keep maintaining the history of commands as soon as you execute them. If the final command is successfully executed, all good otherwise just iterate through the history and keep executing the `undo` on all the executed commands.

## ➿ Iterator

Real world example

> An old radio set will be a good example of iterator, where user could start at some channel and then use next or previous buttons to go through the respective channels. Or take an example of MP3 player or a TV set where you could press the next and previous buttons to go through the consecutive channels or in other words they all provide an interface to iterate through the respective channels, songs or radio stations.

In plain words

> It presents a way to access the elements of an object without exposing the underlying presentation.

Wikipedia says

> In object-oriented programming, the iterator pattern is a design pattern in which an iterator is used to traverse a container and access the container's elements. The iterator pattern decouples algorithms from containers; in some cases, algorithms are necessarily container-specific and thus cannot be decoupled.

**Programmatic example**

Translating our radio stations example from above. First of all we have `RadioStation`

```java
public class RadioStation {
    protected double frequency;

    public RadioStation(double frequency) {
        this.frequency = frequency;
    }

    public double getFrequency() {
        return frequency;
    }
}
```

Then we have our iterator

```java
public class StationList implements Container {

    protected List<RadioStation> stations = new ArrayList<RadioStation>();

    public void AddStation(RadioStation station) {
        this.stations.add(station);
    }

    public void RemoveStation(final RadioStation toRemove) {
        this.stations = this.stations.stream()
                .filter(s -> s.frequency != toRemove.getFrequency())
                .collect(Collectors.toList());
    }

    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator {

        int index;

        @Override
        public boolean hasNext() {

            if (index < stations.size()) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {

            if (this.hasNext()) {
                return stations.get(index++);
            }
            return null;
        }
    }
}
```

Who implements the following interfaces

```java
public interface Container {
    public Iterator getIterator();
}

public interface Iterator {
    public boolean hasNext();

    public Object next();
}
```

And finally it can be used as

```java
StationList stationList = new StationList();

stationList.AddStation(new RadioStation(89));
stationList.AddStation(new RadioStation(101));
stationList.AddStation(new RadioStation(102));
stationList.AddStation(new RadioStation(103.2));

        for (Iterator iter = stationList.getIterator(); iter.hasNext(); ) {
            RadioStation radio = (RadioStation) iter.next();
            System.out.println(radio.getFrequency());
        }

stationList.RemoveStation(new RadioStation(89)); // Will remove station 89
```

# 👽 Mediator

Real world example

> A general example would be when you talk to someone on your mobile phone, there is a network provider sitting between you and them and your conversation goes through it instead of being directly sent. In this case network provider is mediator.

In plain words

> Mediator pattern adds a third party object(called mediator) to control the interaction between two objects(called colleagues). It helps reduce the coupling between the classes communicating with each other. Because now they don't need to have the knowledge of each other's implementation.

Wikipedia says

> In software engineering, the mediator pattern defines an object that encapsulates how a set of objects interact. This pattern is considered to be a behavioral pattern due to the way it can alter the program's running behavior.

**Programmatic Example**

Here is the simplest example of a chat room(i.e. mediator) with users(i.e. colleagues) sending messages to each other.

First of all, we have the mediator i.e. the chat room

```c#
interface ChatRoomMediator {
    void ShowMessage(User user, string message);
}

// Mediator
class ChatRoom : ChatRoomMediator {
    public void ShowMessage(User user, string message) {
        DateTime time = new DateTime();
        string sender = user.GetName();

        System.Console.WriteLine($"{time} [ {sender} ]: {message}");
    }
}
```

Then we have our users i.e. colleagues

```c#
class User {
    protected string name;
    protected ChatRoomMediator chatMediator;

    public User(string name, ChatRoomMediator chatMediator) {
        this.name = name;
        this.chatMediator = chatMediator;
    }

    public string GetName() => this.name;

    public void Send(string message) {
        this.chatMediator.ShowMessage(this, message);
    }
}
```

And the usage

```c#
ChatRoom mediator = new ChatRoom();

User john = new User("John Doe", mediator);
User jane = new User("Jane Doe", mediator);

john.Send("Hi there!");
jane.Send("Hey!");

// Output will be
// Feb 14, 10:58 [John]: Hi there!
// Feb 14, 10:58 [Jane]: Hey!
```

## 💾 Memento

Real world example

> Take the example of calculator(i.e. originator), where whenever you perform some calculation the last calculation is saved in memory(i.e. memento) so that you can get back to it and maybe get it restored using some action buttons(i.e. caretaker).

In plain words

> Memento pattern is about capturing and storing the current state of an object in a manner that it can be restored later on in a smooth manner.

Wikipedia says

> The memento pattern is a software design pattern that provides the ability to restore an object to its previous state(undo via rollback).

Usually useful when you need to provide some sort of undo functionality.

**Programmatic Example**

Lets take an example of text editor which keeps saving the state from time to time and that you can restore if you want.

First of all we have our memento object that will be able to hold the editor state

```c#
class EditorMemento {
    protected string content;

    public EditorMemento(string content) {
        this.content = content;
    }

    public string getContent() => this.content;
}
```

Then we have our editor i.e. originator that is going to use memento object

```c#
class Editor {
    protected string content;

    public void Type(string words) {
        this.content = this.content + " " + words;
    }

    public string GetContent() => this.content;

    public EditorMemento Save() {
        return new EditorMemento(this.content);
    }

    public string Restore(EditorMemento memento) => this.content = memento.getContent();
}
```

And then it can be used as

```c#
Editor editor = new Editor();

// Type some stuff
editor.Type("This is the first sentence.");
editor.Type("This is second.");

// Save the state to restore to : This is the first sentence. This is second.
EditorMemento saved = editor.Save();

// Type some more
editor.Type("And this is third.");

// Output: Content before Saving
System.Console.WriteLine(editor.GetContent()); // This is the first sentence. This is second. And this is third.

// Restoring to last saved state
editor.Restore(saved);

System.Console.WriteLine(editor.GetContent()); // This is the first sentence. This is second.
```

## 😎 Observer

Real world example

> A good example would be the job seekers where they subscribe to some job posting site and they are notified whenever there is a matching job opportunity.

In plain words

> Defines a dependency between objects so that whenever an object changes its state, all its dependents are notified.

Wikipedia says

> The observer pattern is a software design pattern in which an object, called the subject, maintains a list of its dependents, called observers, and notifies them automatically of any state changes, usually by calling one of their methods.

**Programmatic example**

Translating our example from above. First of all we have job seekers that need to be notified for a job posting

```c#
class JobPost {
    public string title;

    public JobPost(string title) {
        this.title = title;
    }

    public string getTitle() => this.title;
}

class JobSeeker : IObserver<JobPost> {
    protected string name;

    public JobSeeker(string name) {
        this.name = name;
    }

    public void OnCompleted() {
        throw new NotImplementedException();
    }

    public void OnError(Exception error) {
        throw new NotImplementedException();
    }

    public void OnNext(JobPost value) {
        Console.WriteLine("Hi {0} ! New job posted: {1}", name, value.title);
    }
}

```

Then we have our job postings to which the job seekers will subscribe

```c#
class JobPostings : IObservable<JobPost> {
    private List<IObserver<JobPost>> mObservers;
    private List<JobPost> mJobPostings;

    public JobPostings() {
        mObservers = new List<IObserver<JobPost>>();
        mJobPostings = new List<JobPost>();
    }

    public IDisposable Subscribe(IObserver<JobPost> observer) {
        // Check whether observer is already registered. If not, add it
        if(!mObservers.Contains(observer)) {
            mObservers.Add(observer);
        }
        return new Unsubscriber<JobPost>(mObservers, observer);
    }

    private void Notify(JobPost jobPost) {
        foreach(var observer in mObservers) {
            observer.OnNext(jobPost);
        }
    }

    public void AddJob(JobPost jobPost) {
        mJobPostings.Add(jobPost);
        Notify(jobPost);
    }

}

internal class Unsubscriber<JobPost> : IDisposable {
    private List<IObserver<JobPost>> mObservers;
    private IObserver<JobPost> mObserver;

    internal Unsubscriber(List<IObserver<JobPost>> observers, IObserver<JobPost> observer) {
        this.mObservers = observers;
        this.mObserver = observer;
    }

    public void Dispose() {
        if(mObservers.Contains(mObserver))
            mObservers.Remove(mObserver);
    }
}
```

Then it can be used as

```c#
//Create Subscribers
JobSeeker johnDoe = new JobSeeker("John Doe");
JobSeeker janeDoe = new JobSeeker("Jane Doe");

//Create publisher and attch subscribers
var jobPostings = new JobPostings();
jobPostings.Subscribe(johnDoe);
jobPostings.Subscribe(janeDoe);

//Add a new job and see if subscribers get notified
jobPostings.AddJob(new JobPost("Software Engineer"));

//Output
// Hi John Doe! New job posted: Software Engineer
// Hi Jane Doe! New job posted: Software Engineer
```

## 🏃 Visitor

Real world example

> Consider someone visiting Dubai. They just need a way(i.e. visa) to enter Dubai. After arrival, they can come and visit any place in Dubai on their own without having to ask for permission or to do some leg work in order to visit any place here; just let them know of a place and they can visit it. Visitor pattern lets you do just that, it helps you add places to visit so that they can visit as much as they can without having to do any legwork.

In plain words

> Visitor pattern lets you add further operations to objects without having to modify them.

Wikipedia says

> In object-oriented programming and software engineering, the visitor design pattern is a way of separating an algorithm from an object structure on which it operates. A practical result of this separation is the ability to add new operations to existing object structures without modifying those structures. It is one way to follow the open/closed principle.

**Programmatic example**

Let's take an example of a zoo simulation where we have several different kinds of animals and we have to make them Sound. Let's translate this using visitor pattern

```c#

// Visitee
interface Animal {
    void Accept(AnimalOperation operation);
}

// Visitor
interface AnimalOperation {
    void VisitMonkey(Monkey monkey);
    void VisitLion(Lion lion);
    void VisitDolphin(Dolphin dolphin);
}
```

Then we have our implementations for the animals

```c#
class Monkey : Animal {
    public void Shout() {
        System.Console.WriteLine("Ooh oo aa aa!");
    }

    public void Accept(AnimalOperation operation) {
        operation.VisitMonkey(this);
    }
}

class Lion : Animal {
    public void Roar() => System.Console.WriteLine("Roaaar!");

    public void Accept(AnimalOperation operation) {
        operation.VisitLion(this);
    }
}

class Dolphin : Animal {
    public void Speak() => System.Console.WriteLine("Tuut tuttu tuutt!");

    public void Accept(AnimalOperation operation) {
        operation.VisitDolphin(this);
    }
}
```

Let's implement our visitor

```c#
class Speak : AnimalOperation {
    public void VisitMonkey(Monkey monkey) {
        monkey.Shout();
    }

    public void VisitLion(Lion lion) {
        lion.Roar();
    }

    public void VisitDolphin(Dolphin dolphin) {
        dolphin.Speak();
    }
}
```

And then it can be used as

```c#
Monkey monkey = new Monkey();
Lion lion = new Lion();
Dolphin dolphin = new Dolphin();

Speak speak = new Speak();

monkey.Accept(speak); // Ooh oo aa aa!
lion.Accept(speak); // Roaaar!
dolphin.Accept(speak); // Tuut tutt tuutt!
```

We could have done this simply by having an inheritance hierarchy for the animals but then we would have to modify the animals whenever we would have to add new actions to animals. But now we will not have to change them. For example, let's say we are asked to add the jump behavior to the animals, we can simply add that by creating a new visitor i.e.

```c#
class Jump : AnimalOperation {
    public void VisitMonkey(Monkey monkey) {
        System.Console.WriteLine("Jumped 20 feet high! on to the tree!");
    }

    public void VisitLion(Lion lion) {
        System.Console.WriteLine("Jumped 7 feet! Back on the ground!");
    }

    public void VisitDolphin(Dolphin dolphin) {
        System.Console.WriteLine("Walked on water a little and disappeared");
    }
}
```

And for the usage

```c#
Monkey monkey = new Monkey();
Lion lion = new Lion();
Dolphin dolphin = new Dolphin();

Speak speak = new Speak();
Jump jump = new Jump();

monkey.Accept(speak); // Ooh oo aa aa!
monkey.Accept(jump); // Jumped 20 feet high! on to the tree!

lion.Accept(speak); // Roaaar!
lion.Accept(jump); // Jumped 7 feet! Back on the ground!

dolphin.Accept(speak); // Tuut tutt tuutt!
dolphin.Accept(jump); // Walked on water a little and disappeared
```

## 💡 Strategy

Real world example

> Consider the example of sorting, we implemented bubble sort but the data started to grow and bubble sort started getting very slow. In order to tackle this we implemented Quick sort. But now although the quick sort algorithm was doing better for large datasets, it was very slow for smaller datasets. In order to handle this we implemented a strategy where for small datasets, bubble sort will be used and for larger, quick sort.

In plain words

> Strategy pattern allows you to switch the algorithm or strategy based upon the situation.

Wikipedia says

> In computer programming, the strategy pattern(also known as the policy pattern) is a behavioural software design pattern that enables an algorithm's behavior to be selected at runtime.

**Programmatic example**

Translating our example from above. First of all we have our strategy interface and different strategy implementations

```c#
interface SortStrategy {
    int[] Sort(int[] dataset);
}

class BubbleSortStrategy : SortStrategy {
    public int[] Sort(int[] dataset) {
        System.Console.WriteLine("Sorting using bubble sort");

        // Do sorting
        return dataset;
    }
}

class QuickSortStrategy : SortStrategy {
    public int[] Sort(int[] dataset) {
        System.Console.WriteLine("Sorting using quick sort");

        // Do sorting
        return dataset;
    }
}
```

And then we have our client that is going to use any strategy

```c#
class Sorter {
    protected SortStrategy sorter;

    public Sorter(SortStrategy sorter) {
        this.sorter = sorter;
    }

    public int[] Sort(int[] dataset) => this.sorter.Sort(dataset);
}
```

And it can be used as

```c#
int[] dataset = { 1, 5, 4, 3, 2, 8 };

Sorter sorter = new Sorter(new BubbleSortStrategy());
sorter.Sort(dataset); // Output : Sorting using bubble sort

sorter = new Sorter(new QuickSortStrategy());
sorter.Sort(dataset); // Output : Sorting using quick sort
```

## 💢 State

Real world example

> Imagine you are using some drawing application, you choose the paint brush to draw. Now the brush changes its behavior based on the selected color i.e. if you have chosen red color it will draw in red, if blue then it will be in blue etc.

In plain words

> It lets you change the behavior of a class when the state changes.

Wikipedia says

> The state pattern is a behavioral software design pattern that implements a state machine in an object-oriented way. With the state pattern, a state machine is implemented by implementing each individual state as a derived class of the state pattern interface, and implementing state transitions by invoking methods defined by the pattern's superclass.
> The state pattern can be interpreted as a strategy pattern which is able to switch the current strategy through invocations of methods defined in the pattern's interface.

**Programmatic example**

Let's take an example of text editor, it lets you change the state of text that is typed i.e. if you have selected bold, it starts writing in bold, if italic then in italics etc.

First of all we have our state interface and some state implementations

```c#
interface WritingState {
    void write(string words);
}

class UpperCase : WritingState {
    public void write(string words) => System.Console.WriteLine(words.ToUpper());
}

class LowerCase : WritingState {
    public void write(string words) => System.Console.WriteLine(words.ToLower());
}

class DefaultText : WritingState {
    public void write(string words) => System.Console.WriteLine(words);
}
```

Then we have our editor

```c#
class TextEditor {
    protected WritingState state;

    public TextEditor(WritingState state) {
        this.state = state;
    }

    public void setState(WritingState state) {
        this.state = state;
    }

    public void type(string words) {
        this.state.write(words);
    }
}
```

And then it can be used as

```c#
TextEditor editor = new TextEditor(new DefaultText());

editor.type("First line");

editor.setState(new UpperCase());

editor.type("Second line");
editor.type("Third line");

editor.setState(new LowerCase());

editor.type("Fourth line");
editor.type("Fifth line");

// Output:
// First line
// SECOND LINE
// THIRD LINE
// fourth line
// fifth line
```

## 📒 Template Method

Real world example

> Suppose we are getting some house built. The steps for building might look like
>
> - Prepare the base of house
> - Build the walls
> - Add roof
> - Add other floors

> The order of these steps could never be changed i.e. you can't build the roof before building the walls etc but each of the steps could be modified for example walls can be made of wood or polyester or stone.

In plain words

> Template method defines the skeleton of how a certain algorithm could be performed, but defers the implementation of those steps to the children classes.

Wikipedia says

> In software engineering, the template method pattern is a behavioral design pattern that defines the program skeleton of an algorithm in an operation, deferring some steps to subclasses. It lets one redefine certain steps of an algorithm without changing the algorithm's structure.

**Programmatic Example**

Imagine we have a build tool that helps us test, lint, build, generate build reports(i.e. code coverage reports, linting report etc) and deploy our app on the test server.

First of all we have our base class that specifies the skeleton for the build algorithm

```c#
abstract class Builder {

    // Template method
    public void Build() {
        this.Test();
        this.Lint();
        this.Assemble();
        this.Deploy();
    }

    abstract public void Test();
    abstract public void Lint();
    abstract public void Assemble();
    abstract public void Deploy();
}
```

Then we can have our implementations

```c#
class AndroidBuilder : Builder {
    public override void Test() {
        System.Console.WriteLine("Running android tests");
    }

    public override void Lint() {
        System.Console.WriteLine("Linting the android code");
    }

    public override void Assemble() {
        System.Console.WriteLine("Assembling the android build");
    }

    public override void Deploy() {
        System.Console.WriteLine("Deploying android build to server");
    }
}

class IosBuilder : Builder {
    public override void Test() {
        System.Console.WriteLine("Running ios tests");
    }

    public override void Lint() {
        System.Console.WriteLine("Linting the ios code");
    }

    public override void Assemble() {
        System.Console.WriteLine("Assembling the ios build");
    }

    public override void Deploy() {
        System.Console.WriteLine("Deploying ios build to server");
    }
}
```

And then it can be used as

```c#
AndroidBuilder androidBuilder = new AndroidBuilder();
androidBuilder.Build();

// Output:
// Running android tests
// Linting the android code
// Assembling the android build
// Deploying android build to server

IosBuilder iosBuilder = new IosBuilder();
iosBuilder.Build();

// Output:
// Running ios tests
// Linting the ios code
// Assembling the ios build
// Deploying ios build to server
```

## 🚦 Wrap Up Folks

And that about wraps it up. I will continue to improve this, so you might want to watch/star this repository to revisit. Also, I have plans on writing the same about the architectural patterns, stay tuned for it.

## 👬 Contribution

- Report issues
- Open pull request with improvements
- Spread the word
- Reach out with any feedback [![Twitter URL](https://img.shields.io/twitter/url/https/twitter.com/kamranahmedse.svg?style=social&label=Follow%20%40kamranahmedse)](https://twitter.com/kamranahmedse)

## License

[![License: CC BY 4.0](https://img.shields.io/badge/License-CC%20BY%204.0-lightgrey.svg)](https://creativecommons.org/licenses/by/4.0/)

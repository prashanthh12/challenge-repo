# Object-Oriented Programming (OOP) in Java

> **Course notes | Java | Beginner-friendly revision**  
> Based on the uploaded *OOPS in Java* study material (15 pages). Examples below are clarified or corrected where necessary.

## Contents
1. [What is OOP?](#1-what-is-oop)
2. [Classes and Objects](#2-classes-and-objects)
3. [`this` Keyword](#3-this-keyword)
4. [Constructors](#4-constructors)
5. [Polymorphism](#5-polymorphism)
6. [Inheritance](#6-inheritance)
7. [Packages](#7-packages)
8. [Access Modifiers](#8-access-modifiers)
9. [Encapsulation](#9-encapsulation)
10. [Abstraction](#10-abstraction)
11. [Interfaces](#11-interfaces)
12. [`static` Keyword](#12-static-keyword)
13. [Interview Revision](#13-interview-revision)
14. [Practice Tasks](#14-practice-tasks)

## 1. What is OOP?

**Object-Oriented Programming (OOP)** is a programming approach that organizes code around **classes and objects**. It helps structure and maintain programs by grouping data and behavior.

The four major OOP principles are:

- **Encapsulation:** Keep data and methods together; control access to data.
- **Abstraction:** Show essential functionality while hiding unnecessary implementation details.
- **Inheritance:** Reuse or extend properties and behavior from another class.
- **Polymorphism:** Use a common method/interface in different forms.

## 2. Classes and Objects

- **Class:** A blueprint defining fields (state) and methods (behavior).
- **Object:** An instance of a class created at runtime.
- `new` creates an object; instance data typically lives on the heap, while a local reference variable may be held in a stack frame. The exact JVM memory implementation can vary.

```java
class Student {
    String name;
    int age;

    void getInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        student.name = "Aman";
        student.age = 24;
        student.getInfo();
    }
}
```

**Remember:** `Student` is the class; `student` is the reference variable; `new Student()` creates an object.

## 3. `this` Keyword

`this` refers to the **current object**. Common uses include accessing instance fields when parameters have the same name, invoking another constructor with `this(...)`, or passing the current object to a method.

```java
class Pen {
    String color;

    Pen(String color) {
        this.color = color;
    }

    void printColor() {
        System.out.println(this.color);
    }
}
```

Here, `this.color` is the object's field, while `color` is the constructor parameter.

## 4. Constructors

A **constructor** initializes a newly created object. Its name matches the class name and it has **no return type** (not even `void`). It runs as part of creating an object.

### 4.1 No-argument constructor

```java
class Student {
    Student() {
        System.out.println("Constructor called");
    }
}
```

If a class declares **no constructors at all**, Java supplies a default no-argument constructor. If you declare a constructor with parameters, Java does **not** automatically add a no-argument one.

### 4.2 Parameterized constructor

```java
class Student {
    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```

### 4.3 Copy constructor (user-defined pattern)

Java does not automatically provide a special copy constructor, but you can write one:

```java
class Student {
    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    Student(Student other) {
        this.name = other.name;
        this.age = other.age;
    }
}
```

**Memory management:** Java uses garbage collection; it does not have a C++-style deterministic destructor.

## 5. Polymorphism

**Polymorphism** means “many forms.” The notes distinguish two common categories:

| Type | Mechanism | Decided when? |
|---|---|---|
| Compile-time (static) | Method **overloading** | Compile time |
| Runtime (dynamic) | Method **overriding** | Runtime |

### 5.1 Method overloading

Same method name with **different parameter lists** (number, types, or order). A return-type change alone is not enough.

```java
class Student {
    void displayInfo(String name) { System.out.println(name); }
    void displayInfo(int age) { System.out.println(age); }
    void displayInfo(String name, int age) {
        System.out.println(name + " " + age);
    }
}
```

### 5.2 Method overriding

A subclass provides a new implementation of an inherited instance method with a compatible signature.

```java
class Shape {
    void area() {
        System.out.println("Area depends on the shape");
    }
}

class Circle extends Shape {
    @Override
    void area() {
        double radius = 3;
        System.out.println(Math.PI * radius * radius);
    }
}

public class Main {
    public static void main(String[] args) {
        Shape shape = new Circle();
        shape.area(); // Circle's method runs
    }
}
```

**Important correction to the source example:** Defining `area(int)` in a subclass when the parent has only `area()` is **overloading**, not overriding. To demonstrate overriding, both methods need matching parameter lists.

## 6. Inheritance

Inheritance lets a **child/subclass** reuse and extend members of a **parent/superclass**. Java uses `extends` for class inheritance.

### Main forms discussed in the source

- **Single:** `Triangle extends Shape`
- **Hierarchical:** `Triangle extends Shape` and `Circle extends Shape`
- **Multilevel:** `EquilateralTriangle extends Triangle`, where `Triangle extends Shape`
- **Hybrid:** A combination of inheritance patterns; in Java, combinations involving multiple types are achieved with **interfaces**, not multiple class inheritance.

```java
class Animal {
    void eat() { System.out.println("Eating"); }
}

class Dog extends Animal {
    void bark() { System.out.println("Barking"); }
}
```

**Important:** Java does **not** permit a class to extend multiple classes directly.

## 7. Packages

A **package** groups related classes and interfaces and helps organize code and control visibility.

```java
import java.util.Scanner;
import java.io.IOException;
```

Example package declaration (at the beginning of a Java source file):

```java
package myapp.models;
```

## 8. Access Modifiers

Access modifiers determine where fields, methods, or classes can be accessed.

| Modifier | Same class | Same package | Subclass in another package | Other packages |
|---|---|---|---|---|
| `private` | Yes | No | No | No |
| *(no modifier)* package-private | Yes | Yes | No | No |
| `protected` | Yes | Yes | Yes, through inheritance rules | No, generally |
| `public` | Yes | Yes | Yes | Yes |

```java
class Account {
    public String name;
    protected String email;
    private String password;

    public void setPassword(String password) {
        this.password = password;
    }
}
```

**Note:** `protected` access outside the package has additional subclass/reference restrictions.

## 9. Encapsulation

**Encapsulation** groups state and methods within a class and controls how outside code interacts with that state. A common pattern is private fields with public getters/setters.

```java
class Account {
    private String password;

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
```

For real applications, **do not expose or store plaintext passwords** like this demonstration. Store securely hashed passwords and never return them from a getter. The example illustrates access control only.

## 10. Abstraction

**Abstraction** exposes essential behavior and hides unnecessary details. The uploaded notes describe two Java tools for abstraction: **abstract classes** and **interfaces**.

### Abstract class

- Declared with `abstract`.
- Cannot be instantiated directly.
- Can have abstract methods (no body) and concrete methods (with bodies).
- Can contain fields, constructors, static methods, and final methods.

```java
abstract class Animal {
    abstract void walk();

    void breathe() {
        System.out.println("Breathing air");
    }
}

class Horse extends Animal {
    @Override
    void walk() {
        System.out.println("Horse walks on four legs");
    }
}
```

## 11. Interfaces

An **interface** defines a contract that implementing classes follow. Java supports implementing multiple interfaces.

```java
interface Animal {
    void walk();
}

class Horse implements Animal {
    @Override
    public void walk() {
        System.out.println("Horse walks on four legs");
    }
}
```

- Interface fields are implicitly `public static final`.
- Ordinary interface methods without a body are implicitly `public abstract`.
- A concrete implementing class must implement all inherited abstract methods.
- **Modern Java note:** Interfaces may also have `default`, `static`, and private methods, so *not every interface method is abstract*.

### Abstract class vs interface

| Abstract class | Interface |
|---|---|
| A class `extends` one class | A class can `implement` multiple interfaces |
| Can hold instance state and constructors | Fields are constants; no instance constructors |
| Can include abstract and concrete methods | Defines contracts; can also include default/static methods |

## 12. `static` Keyword

`static` marks a member as belonging to the **class**, rather than each individual object. The source lists static **variables, methods, blocks, and nested classes**.

```java
class Student {
    static String school = "JMV"; // shared by all students
    String name;                  // separate per student
}

public class Main {
    public static void main(String[] args) {
        Student first = new Student();
        Student second = new Student();
        first.name = "Meena";
        second.name = "Beena";
        System.out.println(Student.school);
    }
}
```

**Tip:** Access static members through the class name (`Student.school`) for clarity.

## 13. Interview Revision

| Question | Short answer |
|---|---|
| Class vs object? | Blueprint vs runtime instance. |
| What is `this`? | Reference to the current object. |
| Constructor vs method? | Constructor initializes a new object and has no return type. |
| Overloading vs overriding? | Different parameters vs subclass reimplementation of a compatible inherited method. |
| What does `extends` do? | Establishes inheritance between classes. |
| Why encapsulate fields? | To control access and protect object state. |
| Can abstract classes be instantiated? | No, not directly. |
| Can Java extend multiple classes? | No; it can implement multiple interfaces. |
| `static` vs instance field? | Shared class member vs per-object field. |
| What is a package? | A namespace grouping related types. |

## 14. Practice Tasks

- [ ] Create a `Pen` class with `color` and `printColor()`.
- [ ] Create `Student` objects using parameterized and copy constructors.
- [ ] Overload a `displayInfo()` method with different parameters.
- [ ] Override a `sound()` method in two animal subclasses.
- [ ] Build a class with private fields and safe validation in setters.
- [ ] Create an abstract `Shape` class and subclasses implementing `area()`.
- [ ] Implement two interfaces in one class.
- [ ] Experiment with a shared `static` field.

---

## Source and study notes

**Source:** Uploaded *OOPS in Java.pdf* (15 pages). Topics follow the PDF's order. Code examples were adapted for readability and Java correctness. The PDF also briefly mentions **data binding** (connecting UI and business logic); that term is distinct from the core Java OOP concepts covered here.

**Suggested location in this repository:** `course/week-01/day-012-oops-java/README.md` (or the day you studied OOP).

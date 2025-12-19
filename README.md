<h1 align="center">🚀 Data Structures Lab – Stack & Queue (Java)</h1>

![Course](https://img.shields.io/badge/DS%20Lab-Week%204-%2373c2fb)
![Language](https://img.shields.io/badge/Java-Source_Code-%23e57373)
![Topic](https://img.shields.io/badge/Topic-Stack%20%26%20Queue-%23ffb74d)
![Level](https://img.shields.io/badge/Level-Intermediate-%2381c784)
![Purpose](https://img.shields.io/badge/Purpose-Teaching-%234fc3f7)

---

## 📺 Lecture Video

Watch the full Stack & Queue lab lecture on YouTube:

👉 [Stack & Queue Lecture](https://youtu.be/7oQVEISshrk)

---

## 1. 🌟 Introduction

**Stack** and **Queue** are fundamental **linear data structures** used to organize data based on strict ordering rules.

They are essential for understanding:

- Function calls and recursion (call stack)
- Undo / Redo operations
- Expression evaluation
- Task scheduling and buffering
- Real-world data flow problems

### 2. 🧠 Core Concepts
#### 🔹 Stack (LIFO – Last In, First Out)

- Elements are added and removed from the same end called **top**
- Main operations:
  - `push` → insert element at top
  - `pop` → remove element from top
  - `peek` → view top element
  - `isEmpty`

**📌 Real-world analogy:**

A stack of plates — the last plate placed is the first removed.


**Complexity:**

- Time: `O(1)` for push/pop
- Space: depends on implementation

---

#### Queue (FIFO – First In, First Out)

- Elements are added from the rear and removed from the front, **queue** processes elements in the same order they arrive.
- Main operations:
  - `enqueue` → insert at rear
  - `dequeue` → remove from front
  - `peek`
  - `isEmpty`

**📌 Real-world analogy:**

People standing in a line.

**Complexity:**

- Time: `O(1)`
- Space: depends on implementation

---

## 3. 📂 Repository Structure

```bash
java-ds-lab-stack-queue/
│
├── README.md
│
├── src/
│   ├── examples/
│   │   ├── ArrayStack.java
│   │   ├── LinkedListStack.java
│   │   └── LinkedListQueue.java
│   │
│   ├── activities/
│   │   ├── ReverseSLLUsingStack.java
│   │   ├── SortStack.java
│   │   ├── PalindromeUsingStack.java
│   │   ├── ReverseQueueUsingRecursion.java
│   │   └── ReverseQueueUsingStack.java
│   │
│   └── chapters/
│       └── Lecture 05 - Stack & Queue.pdf
│
├── assignment/
│   └── README.md
│
└── .gitignore
```

---

## 4. 🖥 Lecture Examples (Explained in Class)

All files in [`src/examples/`](src/examples) were **fully explained during the lecture**, with diagrams, tracing, and dry runs.

---

### 4.1 🟦 Stack Using Array

📁 [`ArrayStack.java`](src/examples/ArrayStack.java)

**Idea:**
Implement stack behavior using an array and a `top` index.

**Key points explained:**

- `top = -1` → empty stack
- Increment `top` before insert
- Decrement `top` after removal
- Dynamic resizing when array is full

**Stack Growth Visualization**

```mermaid
flowchart TB
    %% Stack operations (LIFO)
    A["push(10)"] --> B["push(20)"] --> C["push(30)"]
    C --> D["top → 30 (Last In)"]
    D --> E["pop() → 30 (First Out)"]

    %% Styling
    classDef push fill:#e3f2fd,stroke:#1e88e5,stroke-width:2px,color:#0d47a1;
    classDef top  fill:#e8f5e9,stroke:#43a047,stroke-width:2px,color:#1b5e20;
    classDef pop  fill:#ffebee,stroke:#e53935,stroke-width:2px,color:#b71c1c;

    class A,B,C push;
    class D top;
    class E pop;
```

> **📌 Important:**
> This example teaches **memory layout, overflow handling**, and why arrays need resizing.

---

### 4.2 🟩 Stack Using Linked List

📁 [`LinkedListStack.java`](src/examples/LinkedListStack.java)

**Idea:**
Replace array with nodes to avoid resizing.

**Key concepts:**

- `top` always points to head node
- Push = insert at head
- Pop = remove head

**Push Operation**

```mermaid
flowchart LR
    %% Stack push linking (LIFO behavior)
    A["New Node (Top)"] --> B["Old Top"]
    B --> C["Next Node"]

    %% Styling
    classDef newNode fill:#e3f2fd,stroke:#1e88e5,stroke-width:2px,color:#0d47a1;
    classDef oldTop  fill:#fff3e0,stroke:#fb8c00,stroke-width:2px,color:#e65100;
    classDef next    fill:#f3e5f5,stroke:#8e24aa,stroke-width:2px,color:#4a148c;

    class A newNode;
    class B oldTop;
    class C next;
```

**📌 Why linked list stack?**

- No overflow
- Dynamic memory
- Clean pointer manipulation

---

### 4.3 🔁 Reverse String Using Stack

**Logic:**

1. Push each character
2. Pop characters to reverse order

```mermaid
flowchart LR

    subgraph Original_String
        direction LR
        A["M"] --> B["a"] --> C["r"] --> D["y"] --> E["a"] --> F["m"]
    end

    subgraph Reversed_String
        direction LR
        R1["m"] --> R2["a"] --> R3["y"] --> R4["r"] --> R5["a"] --> R6["M"]
    end

    %% Invisible edge to force left → right order
    F -.-> R1

    %% Styling
    classDef original fill:#e3f2fd,stroke:#1e88e5,stroke-width:2px,color:#0d47a1;
    classDef reversed fill:#ffebee,stroke:#e53935,stroke-width:2px,color:#b71c1c;

    class A,B,C,D,E,F original;
    class R1,R2,R3,R4,R5,R6 reversed;
```

> Demonstrates **pure LIFO behavior**.

---

### 4.4 ⚖️ Balanced Parentheses

**Goal:**
Validate expressions using stack.

**Rules:**

- Push opening brackets
- Pop and match on closing bracket
- Stack must be empty at the end

```mermaid
flowchart LR
    %% Input stream
    subgraph Input
        direction LR
        A["{"] --> B["("] --> C[")"] --> D["}"]
    end

    %% Stack operations
    subgraph Stack_Operations
        direction TB
        P1["push '{'"] --> P2["push '('"]
        P2 --> P3["pop '('  ✓ match )"]
        P3 --> P4["pop '{'  ✓ match }"]
    end

    %% Flow connection (invisible for ordering)
    D -.-> P1

    %% Styling
    classDef input fill:#e3f2fd,stroke:#1e88e5,stroke-width:2px,color:#0d47a1;
    classDef push  fill:#e8f5e9,stroke:#43a047,stroke-width:2px,color:#1b5e20;
    classDef pop   fill:#ffebee,stroke:#e53935,stroke-width:2px,color:#b71c1c;

    class A,B,C,D input;
    class P1,P2 push;
    class P3,P4 pop;
```

**📌 Used in:**

- Compilers
- Syntax validation
- Code editors

---

### 4.5 🟨 Queue Using Linked List

📁 [`LinkedListQueue.java`](scr/examples/LinkedListQueue.java)

**Structure:**

- `front` → first element
- `rear` → last element

**Enqueue / Dequeue Flow**

```mermaid
flowchart LR
    %% Queue structure (nodes as front and rear)
    F["Front: Node1"] --> N2["Node2"] --> R["Rear: Node3"]

    %% Queue operations
    subgraph Queue_Operations
        direction TB
        ENQ["Enqueue Node4 → add at Rear"] --> ENQ2["Queue: Front → Node1 → Node2 → Node3 → Node4 → Rear"]
        DEQ["Dequeue Front → remove Node1"] --> DEQ2["Queue: Front → Node2 → Node3 → Rear"]
    end

    %% Styling
    classDef nodes fill:#e3f2fd,stroke:#1e88e5,stroke-width:2px,color:#0d47a1;
    classDef enqueue fill:#e8f5e9,stroke:#43a047,stroke-width:2px,color:#1b5e20;
    classDef dequeue fill:#ffebee,stroke:#e53935,stroke-width:2px,color:#b71c1c;

    class F,N2,R nodes;
    class ENQ,ENQ2 enqueue;
    class DEQ,DEQ2 dequeue;
```

**Operations:**

- `Enqueue` → attach at `rear`
- `Dequeue` → remove from `front`

---

### 4.6 👀 Display Queue Without Losing Order

**Technique:**

- Dequeue
- Print
- Enqueue back

```mermaid
flowchart LR
    %% Queue display operation without losing order
    subgraph Queue
        direction LR
        F["Front: Node1"] --> N2["Node2"] --> N3["Node3"] --> R["Rear: Node4"]
    end

    %% Display operations
    subgraph Display_Queue
        direction TB
        S1["Dequeue Node1 → Print Node1"] --> S2["Enqueue Node1 back at Rear"]
        S2 --> S3["Dequeue Node2 → Print Node2"] --> S4["Enqueue Node2 back at Rear"]
        S4 --> S5["Dequeue Node3 → Print Node3"] --> S6["Enqueue Node3 back at Rear"]
        S6 --> S7["Dequeue Node4 → Print Node4"] --> S8["Enqueue Node4 back at Rear"]
    end

    %% Styling
    classDef queue fill:#e3f2fd,stroke:#1e88e5,stroke-width:2px,color:#0d47a1;
    classDef operation fill:#e8f5e9,stroke:#43a047,stroke-width:2px,color:#1b5e20;
    classDef print fill:#fff3e0,stroke:#fb8c00,stroke-width:2px,color:#e65100;

    class F,N2,N3,R queue;
    class S1,S2,S3,S4,S5,S6,S7,S8 operation;
```

> This reinforces **queue rotation** and FIFO understanding.

---

## 5. 🎯 Activities (Student Practice)

📁 [`src/activities/`](src/activities/)

These tasks are **intentionally incomplete** and must be solved by students.

| Activity                  | Concept                 |
| ------------------------- | ----------------------- |
| Reverse SLL using Stack   | Stack + Linked List     |
| Sort Stack                | Nested stack logic      |
| Palindrome using Stack    | String processing       |
| Reverse Queue (Recursion) | Queue + recursion       |
| Reverse Queue (Stack)     | Stack–Queue interaction |

> ❗ No solutions here.
> Students must reason, design, and implement.

---

## 📂 Assignments – Lecture 05

**📌 Assignment questions are NOT written here.**

To access the assignment:

1. Open the [`assignment/`](assignments) folder
2. Read `README.md`
3. Watch the assignment video
4. Follow submission instructions

👉 [`assignment/README.md`](assignments/README.md)

> This ensures fairness and prevents copying.

---

## 7. 🏃 Running the Code

```bash
git clone https://github.com/Maryam-Skaik/java-ds-lab-stack-queue.git
cd java-ds-lab-stack-queue/src/examples
javac *.java
java ArrayStack
```

---

## 8. 💡 Tips for Students

- Always track top, front, rear
- Draw before coding
- Trace push/pop manually
- Stack problems → think LIFO
- Queue problems → think FIFO

---

## 🎓 Learning Outcomes

After this lab, students will:

- Implement stack & queue from scratch
- Understand internal data flow
- Apply stack/queue to real problems
- Be ready for recursion internals and trees

---

## 📝 License

This project is provided for educational use in the Java Data Structures Lab.

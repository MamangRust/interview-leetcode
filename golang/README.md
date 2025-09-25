# LeetCode Problems in Go

This repository contains solutions to various LeetCode problems, implemented in Go. The problems are organized into directories based on the primary algorithm or data structure used for the solution.

## Algorithms and Data Structures

Here is an overview of the categories you'll find in this repository:

### `1d_dp`
**1D Dynamic Programming:** Problems that can be solved by breaking them down into smaller, overlapping subproblems and storing the results of these subproblems in a one-dimensional array or table to avoid redundant calculations.

```mermaid
graph LR
    subgraph 1D DP Table
        direction LR
        dp0["dp[0]"] --> dp1["dp[1]"] --> dp2["dp[2]"] --> dp3["..."] --> dpn["dp[n]"]
    end
    style dp0 fill:#f9f,stroke:#333,stroke-width:2px
    style dp1 fill:#f9f,stroke:#333,stroke-width:2px
    style dp2 fill:#f9f,stroke:#333,stroke-width:2px
    style dpn fill:#f9f,stroke:#333,stroke-width:2px
```

### `array_string`
**Array & String Manipulation:** Problems focused on operations involving arrays and strings, such as searching, sorting, reversing, and other transformations.

```mermaid
graph TD
    subgraph Array
        direction LR
        A[0] --- B[1] --- C[2] --- D[3] --- E[...]
    end
    subgraph String
        direction LR
        S1["'h'"] --- S2["'e'"] --- S3["'l'"] --- S4["'l'"] --- S5["'o'"]
    end
```

### `backtracking`
**Backtracking:** A general algorithmic technique for solving problems recursively by trying to build a solution incrementally. When a path is determined to be incorrect, the algorithm "backtracks" to a previous state to explore a different path. It's often used for constraint satisfaction problems like puzzles or generating combinations and permutations.

```mermaid
graph TD
    A[Start] --> B{Choice 1};
    A --> C{Choice 2};
    B --> D[Solution?];
    C --> E[Solution?];
    D -- No --> F{Backtrack};
    F --> A;
    style F fill:#f66,stroke:#333,stroke-width:2px
```

### `binary_search`
**Binary Search:** An efficient algorithm for finding an item from a sorted list of items. It works by repeatedly dividing the search interval in half.

```mermaid
graph TD
    subgraph "Sorted Array"
        direction LR
        N1[1] --> N2[2]
        N2 --> N3[3]
        N3 --> N4[4]
        N4 --> N5[5]
        N5 --> N6[6]
        N6 --> N7[7]
    end

    A[Search for 6] --> B{Midpoint is 4}
    B -- "6 > 4" --> C{Search right half}
    C --> D{Midpoint is 6}
    D -- "Found" --> E[Index 5]
```

### `binary_search_tree`
**Binary Search Tree (BST):** A node-based binary tree data structure which has the following properties: the left subtree of a node contains only nodes with keys lesser than the node's key; the right subtree of a node contains only nodes with keys greater than the node's key; the left and right subtree each must also be a binary search tree.

```mermaid
graph TD
    A(8) --> B(3);
    A --> C(10);
    B --> D(1);
    B --> E(6);
    C --> F(14);
```

### `binary-tree-bfs`
**Binary Tree - Breadth-First Search (BFS):** An algorithm for traversing or searching tree or graph data structures. It starts at the tree root and explores all of the neighbor nodes at the present depth prior to moving on to the nodes at the next depth level.

```mermaid
graph TD
    A(1) --> B(2);
    A --> C(3);
    B --> D(4);
    B --> E(5);
    C --> F(6);
    subgraph Traversal Order
        direction LR
        T1[1] --> T2[2] --> T3[3] --> T4[4] --> T5[5] --> T6[6]
    end
```

### `binary-tree-dfs`
**Binary Tree - Depth-First Search (DFS):** An algorithm for traversing or searching tree or graph data structures. The algorithm starts at the root node and explores as far as possible along each branch before backtracking.

```mermaid
graph TD
    A(1) --> B(2);
    A --> C(3);
    B --> D(4);
    B --> E(5);
    C --> F(6);
    subgraph "Traversal Order (Pre-order)"
        direction LR
        T1[1] --> T2[2] --> T3[4] --> T4[5] --> T5[3] --> T6[6]
    end
```

### `binary-tree-general`
**General Binary Tree:** Problems related to the structure, traversal, and manipulation of binary trees that don't fall into a more specific category like BFS, DFS, or BST.

```mermaid
graph TD
    A(Root) --> B(Left Child);
    A --> C(Right Child);
    B --> D(..);
    B --> E(..);
```

### `bit_manipulation`
**Bit Manipulation:** Problems that are solved by manipulating individual bits of a number using bitwise operators (AND, OR, XOR, NOT, shifts). This is often used for optimization or solving problems with specific constraints.

```mermaid
graph TD
    subgraph "5 (0101)"
        A[0] --> B[1]
        B --> C[0]
        C --> D[1]
    end

    subgraph "3 (0011)"
        E[0] --> F[0]
        F --> G[1]
        G --> H[1]
    end

    I{5 & 3} --> J["1 (0001)"]
```

### `divide_conquer`
**Divide and Conquer:** An algorithmic paradigm where a problem is recursively broken down into two or more sub-problems of the same or related type, until these become simple enough to be solved directly. The solutions to the sub-problems are then combined to give a solution to the original problem.

```mermaid
graph TD
    A[Problem] --> B(Divide);
    B --> C[Sub-problem 1];
    B --> D[Sub-problem 2];
    C --> E(Conquer);
    D --> F(Conquer);
    E --> G(Combine);
    F --> G;
    G --> H[Solution];
```

### `dp_multidimensional`
**Multidimensional Dynamic Programming:** An extension of 1D DP where the problem state is represented by two or more dimensions, requiring a 2D or higher-dimensional table to store the results of subproblems.

```mermaid
graph TD
    subgraph 2D DP Table
        A00["dp[0][0]"] --> A01["dp[0][1]"];
        A10["dp[1][0]"] --> A11["dp[1][1]"];
        A00 --> A10;
        A01 --> A11;
        A00 --> A11;
    end
```

### `graph_bfs`
**Graph - Breadth-First Search (BFS):** The application of BFS to graph data structures to find shortest paths in unweighted graphs or to simply traverse the graph level by level.

```mermaid
graph TD
    A -- 1 --> B;
    A -- 1 --> C;
    B -- 2 --> D;
    B -- 2 --> E;
    C -- 2 --> F;
    subgraph "Traversal Order"
        direction LR
        T1[A] --> T2[B] --> T3[C] --> T4[D] --> T5[E] --> T6[F]
    end
```

### `graph_dfs`
**Graph - Depth-First Search (DFS):** The application of DFS to graph data structures to explore all vertices and edges, detect cycles, or find connected components.

```mermaid
graph TD
    A --- B;
    A --- C;
    B --- D;
    B --- E;
    C --- F;
    subgraph "Traversal Order"
        direction LR
        T1[A] --> T2[B] --> T3[D] --> T4[E] --> T5[C] --> T6[F]
    end
```

### `graph_general`
**General Graph:** A collection of problems involving graph data structures that may require a combination of algorithms or have unique traversal or structural challenges.

```mermaid
graph
    A --- B;
    A --- C;
    B --- D;
    C --- D;
    D --- E;
```

### `hashmap`
**Hash Map (Hash Table):** Problems that can be efficiently solved using a hash map to store key-value pairs. This is useful for quick lookups, counting occurrences, or grouping items.

```mermaid
graph TD
    subgraph Hash Map
        K1["Key: 'apple'"] --> V1["Value: 5"];
        K2["Key: 'banana'"] --> V2["Value: 2"];
        K3["..."] --> V3["..."];
    end
    A[Input: 'apple'] --> B{Hash Function};
    B --> C[Index];
    C --> V1;
```

### `heap`
**Heap (Priority Queue):** Problems involving a specialized tree-based data structure that satisfies the heap property. Heaps are useful for implementing priority queues, which are essential for algorithms like Dijkstra's or for finding the k-th smallest/largest element.

```mermaid
graph TD
    subgraph Min-Heap
        A(1) --> B(3);
        A --> C(2);
        B --> D(5);
        B --> E(4);
    end
```

### `intervals`
**Intervals:** A category of problems that involve dealing with ranges or intervals. Common tasks include merging overlapping intervals, finding intersections, or scheduling.

```mermaid
gantt
    title Merging Overlapping Intervals
    dateFormat  X
    axisFormat %s
    section Intervals
    [1, 3] : 1, 3
    [2, 6] : 2, 6
    [8, 10] : 8, 10
    section Merged
    [1, 6] : 1, 6
    [8, 10] : 8, 10
```

### `kadane_algorithm`
**Kadane's Algorithm:** An efficient algorithm used to find the maximum subarray sum in a given one-dimensional array of numbers.

```mermaid
graph TD
    subgraph Array
        direction LR
        A[-2] --> B[1] --> C[-3] --> D[4] --> E[-1] --> F[2] --> G[1] --> H[-5]
    end
    subgraph "Max Subarray (Sum: 6)"
        direction LR
        style D fill:#9cf,stroke:#333,stroke-width:2px
        style E fill:#9cf,stroke:#333,stroke-width:2px
        style F fill:#9cf,stroke:#333,stroke-width:2px
        style G fill:#9cf,stroke:#333,stroke-width:2px
        D --- E --- F --- G
    end
```

### `linked_list`
**Linked List:** Problems focused on the linked list data structure, including operations like insertion, deletion, reversal, cycle detection, and merging.

```mermaid
graph LR
    A[Node 1] --> B[Node 2] --> C[Node 3] --> D[Null];
```

### `math_leetcode`
**Math:** Problems that require mathematical concepts and logic, such as number theory, geometry, or probability, rather than complex data structures.

```mermaid
graph TD
    A["a² + b² = c²"]
```

### `matrix`
**Matrix:** Problems that involve operations on 2D grids or matrices, such as rotation, searching, or dynamic programming on a grid.

```mermaid
graph TD
    subgraph "3x3 Matrix"
        A1["[0,0]"] --> A2["[0,1]"]
        A2 --> A3["[0,2]"]

        B1["[1,0]"] --> B2["[1,1]"]
        B2 --> B3["[1,2]"]

        C1["[2,0]"] --> C2["[2,1]"]
        C2 --> C3["[2,2]"]
    end
```

### `monotonic_stack`
**Monotonic Stack:** A stack data structure where the elements are always in a sorted order (either increasing or decreasing). It's useful for problems where you need to find the next greater/smaller element for each element in an array.

```mermaid
graph TD
    subgraph "Increasing Stack (Bottom to Top)"
        direction BT
        A[1] --> B[3] --> C[5] --> D[8]
    end
```

### `prefix_sum`
**Prefix Sum:** A technique where a new array is pre-calculated, and each element `i` in this new array stores the sum of all elements up to index `i` in the original array. This allows for constant-time calculation of the sum of any subarray.

```mermaid
graph TD
    subgraph "Original Array"
        direction LR
        A[2] --> B[8]
        B --> C[3]
        C --> D[5]
    end

    subgraph "Prefix Sum Array"
        direction LR
        PA[2] --> PB[10]
        PB --> PC[13]
        PC --> PD[18]
    end
```

### `queue`
**Queue:** Problems that utilize the First-In, First-Out (FIFO) nature of the queue data structure, often used in BFS or for simulating processes.

```mermaid
graph LR
    A(In) --> B[Front ... Rear] --> C(Out)
    style B fill:#ccf,stroke:#333,stroke-width:2px
```

### `sliding_window`
**Sliding Window:** An algorithmic technique used on arrays or strings where a "window" of a certain size slides over the data. It's used to efficiently solve problems that require finding a subarray or substring that satisfies certain conditions.

```mermaid
graph TD
    subgraph Array
        direction LR
        A[1] --> B[2]
        B --> C[3]
        C --> D[4]
        D --> E[5]
    end

    subgraph "Window (Size 3)"
        direction LR
        style B fill:#f99,stroke:#333,stroke-width:2px
        style C fill:#f99,stroke:#333,stroke-width:2px
        style D fill:#f99,stroke:#333,stroke-width:2px
        B --> C
        C --> D
    end
```

### `stack`
**Stack:** Problems that are naturally solved using the Last-In, First-Out (LIFO) property of the stack data structure, such as validating parentheses, expression evaluation, or simplifying paths.

```mermaid
graph TD
    A(Push) --> B[Top ... Bottom]
    B --> C(Pop)
    style B fill:#cfc,stroke:#333,stroke-width:2px
```

### `trie`
**Trie (Prefix Tree):** A tree-like data structure that is efficient for storing and retrieving strings. It's commonly used for implementing autocomplete features or as a spell checker.

```mermaid
graph TD
    A(root) --> B(t);
    B --> C(o);
    A --> D(a);
    D --> E(n);
    C -- "word: to" --> F(( ));
    E -- "word: an" --> G(( ));
```

### `two_pointer`
**Two Pointers:** A common technique for searching or manipulating sorted arrays. It involves using two pointers that typically move towards each other or in the same direction to solve a problem in linear time.

```mermaid
graph TD
    subgraph Array
        direction LR
        A[1] --> B[2] --> C[3] --> D[4] --> E[5] --> F[6]
    end
    subgraph Pointers
        Left --> A
        Right --> F
    end
    Left -- moves right --> Right
    Right -- moves left --> Left
```
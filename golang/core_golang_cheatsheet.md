# Core Go (Golang) Cheatsheet

This cheatsheet covers Go's built-in functions, core language features, and essential standard library packages.

---

## 1. Built-in Functions

These functions are built into the language and are always available.

- **`len(v)`**: Returns the length of a string, array, slice, or map.
- **`cap(v)`**: Returns the capacity of a slice or array.
- **`append(slice, elems...)`**: Appends elements to a slice, returning a new slice.
- **`copy(dst, src)`**: Copies elements from a source slice to a destination slice. Returns the number of elements copied.
- **`make(T, size...)`**: Creates slices, maps, and channels. `make([]int, 5)` creates a slice of 5 zeros. `make(map[string]int)` creates a hash map.
- **`new(T)`**: Allocates memory for a new item of type `T` and returns a pointer to it.
- **`delete(m, key)`**: Deletes a key-value pair from a map.
- **`panic(v)`**: Triggers a panic, which stops the ordinary flow of control.
- **`recover()`**: Regains control of a panicking goroutine. Only useful inside deferred functions.
- **`close(ch)`**: Closes a channel.
- **`print(args...)`, `println(args...)`**: Low-level printing functions, mainly for debugging. `fmt` is generally preferred.

```go
// Slices
slice := make([]int, 0, 5) // len=0, cap=5
slice = append(slice, 1, 2, 3)
fmt.Println(len(slice), cap(slice)) // 3 5

// Maps
m := make(map[string]int)
m["hello"] = 10
delete(m, "hello")
```

---

## 2. Control Flow

### If-Else

Can include a short initialization statement.

```go
if num := 9; num < 0 {
    fmt.Println(num, "is negative")
} else if num < 10 {
    fmt.Println(num, "has 1 digit")
} else {
    fmt.Println(num, "has multiple digits")
}
```

### For Loop

Go has only one looping construct: the `for` loop.

```go
// 1. Standard C-style loop
for i := 0; i < 5; i++ {
    // ...
}

// 2. While-style loop
sum := 1
for sum < 100 {
    sum += sum
}

// 3. Infinite loop
for {
    // ... break to exit
}

// 4. For-range loop (for slices, arrays, strings, maps, channels)
nums := []int{2, 3, 4}
for index, value := range nums {
    fmt.Println(index, value)
}

// For maps, it iterates over key-value pairs
m := map[string]int{"a": 1, "b": 2}
for k, v := range m {
    fmt.Println(k, v)
}
```

### Switch

Go's `switch` is more flexible than in C or Java. Cases don't fall through by default.

```go
// 1. Expression switch
i := 2
switch i {
case 1:
    fmt.Println("one")
case 2:
    fmt.Println("two")
default:
    fmt.Println("other")
}

// 2. Condition-only switch (cleaner if-else chain)
t := time.Now()
switch {
case t.Hour() < 12:
    fmt.Println("Good morning!")
default:
    fmt.Println("Good afternoon.")
}

// 3. Type switch
func do(i interface{}) {
    switch v := i.(type) {
    case int:
        fmt.Printf("Twice %v is %v\n", v, v*2)
    case string:
        fmt.Printf("%q is %v bytes long\n", v, len(v))
    default:
        fmt.Printf("I don't know about type %T!\n", v)
    }
}
do(21)      // Twice 21 is 42
do("hello")  // "hello" is 5 bytes long
```

### Defer

A `defer` statement defers the execution of a function until the surrounding function returns. Useful for cleanup activities like closing a file.

```go
func readFile(filename string) {
    f, err := os.Open(filename)
    if err != nil {
        panic(err)
    }
    defer f.Close() // f.Close() is executed when readFile returns

    // ... read the file
}
```

---

## 3. Composite Types

### Structs

A collection of named fields.

```go
type Person struct {
    Name string
    Age  int
}

p := Person{Name: "Alice", Age: 30}
fmt.Println(p.Name)
```

### Pointers

Go has pointers. `&` operator generates a pointer. `*` operator dereferences a pointer.

```go
p := Person{"Bob", 42}
p_ptr := &p
p_ptr.Age = 43 // Same as (*p_ptr).Age = 43
fmt.Println(p.Age) // 43
```

---

## 4. Functions and Methods

### Functions

Can return multiple values.

```go
func add(a, b int) int {
    return a + b
}

func swap(a, b string) (string, string) {
    return b, a
}
```

### Methods

A method is a function with a special receiver argument.

```go
// Method for the Person struct defined above
func (p Person) Greet() {
    fmt.Printf("Hi, I\'m %s\n", p.Name)
}

p.Greet()
```

---

## 5. Interfaces and Error Handling

### Interfaces

An interface type is a set of method signatures. A value of an interface type can hold any value that implements those methods.

```go
type Shape interface {
    Area() float64
}

type Rectangle struct { Width, Height float64 }

func (r Rectangle) Area() float64 {
    return r.Width * r.Height
}

func measure(s Shape) {
    fmt.Println(s.Area())
}

r := Rectangle{Width: 3, Height: 4}
measure(r) // 12
```

### Error Handling

Go uses an explicit, value-based error handling pattern using the built-in `error` interface.

```go
func Sqrt(x float64) (float64, error) {
    if x < 0 {
        return 0, fmt.Errorf("cannot Sqrt negative number: %v", x)
    }
    return math.Sqrt(x), nil
}

result, err := Sqrt(-1)
if err != nil {
    fmt.Println(err)
}
```

---

## 6. Concurrency

### Goroutines

A lightweight thread of execution. Start a new goroutine with the `go` keyword.

```go
func say(s string) {
    for i := 0; i < 5; i++ {
        time.Sleep(100 * time.Millisecond)
        fmt.Println(s)
    }
}

go say("world") // Start new goroutine
say("hello")    // Run in current goroutine
```

### Channels

Typed conduits for communication between goroutines.

```go
ch := make(chan int)

go func() {
    ch <- 42 // Send value to channel
}()

val := <-ch // Receive value from channel
fmt.Println(val)
```

### Select

The `select` statement lets a goroutine wait on multiple communication operations.

```go
select {
case msg1 := <-ch1:
    fmt.Println("received", msg1)
case msg2 := <-ch2:
    fmt.Println("received", msg2)
default:
    // non-blocking operation
}
```

---

## 7. Key Standard Library Packages

### `fmt`

Formatted I/O.

- `fmt.Println(...)`: Print with space between args and a newline.
- `fmt.Printf(format, ...)`: Formatted print. `%-v` (value), `%T` (type), `%d` (int), `%s` (string), `%f` (float).
- `fmt.Sprintf(...)`: Returns a formatted string.
- `fmt.Errorf(...)`: Returns an error with a formatted string.

### `strings`

Common string manipulations.

- `strings.Contains(s, substr)`
- `strings.HasPrefix(s, prefix)`
- `strings.HasSuffix(s, suffix)`
- `strings.Index(s, substr)`
- `strings.Join(a []string, sep string)`
- `strings.Split(s, sep string)`
- `strings.Replace(s, old, new, n)`
- `strings.ToLower(s)`, `strings.ToUpper(s)`
- `strings.TrimSpace(s)`

### `strconv`

String conversions.

- `strconv.Atoi(s)`: String to int.
- `strconv.Itoa(i)`: Int to string.
- `strconv.ParseFloat(s, bitSize)`
- `strconv.FormatBool(b)

### `sort`

Sorting slices.

- `sort.Ints(slice)`
- `sort.Float64s(slice)`
- `sort.Strings(slice)`
- `sort.Slice(slice, func(i, j int) bool { ... })`: Custom sort.
- `sort.SearchInts(slice, x)`: Binary search.

### `encoding/json`

JSON marshalling and unmarshalling.

```go
import "encoding/json"

type MyData struct {
    Name string `json:"name"`
    Age  int    `json:"age"`
}

// Marshal (struct to JSON)
data := MyData{"Eve", 28}
jsonData, err := json.Marshal(data)

// Unmarshal (JSON to struct)
var unmarshaledData MyData
err = json.Unmarshal(jsonData, &unmarshaledData)
```

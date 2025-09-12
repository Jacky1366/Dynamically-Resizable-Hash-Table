# Dynamically Resizable Hash Table

A high-performance hash table implementation in Java featuring automatic resizing and efficient collision handling. This project demonstrates advanced data structures and algorithm optimization techniques.

## 🚀 Project Overview

Implemented a resizable hash table using extraction-based hashing on ISBN keys with linear probing collision resolution. The hash table automatically resizes when the load factor reaches 0.70 to maintain optimal performance.

## 💻 Technologies Used

- **Language:** Java
- **Key Concepts:** Data Structures, Algorithms, Performance Optimization
- **Testing:** Custom test harness for validation

## ✨ Key Features

- **Dynamic Resizing:** Automatic expansion when load factor reaches 0.70
- **Efficient Collision Handling:** Linear probing with optimized probe sequences
- **Deletion Support:** Tombstone flags for efficient deletion without disrupting probe sequences
- **ISBN Key Optimization:** Extraction-based hashing specifically designed for ISBN identifiers
- **Comprehensive Testing:** Custom test harness validating all operations

## 🏗️ Technical Implementation

**Hash Function:**
- Extraction-based hashing using last 3 digits of ISBN (`lastThreeDigits % tableSize`)
- Optimized for ISBN key patterns with modulo operation for even distribution

**Collision Resolution:**
- Linear probing with careful handling of deleted entries
- Tombstone flags maintain probe sequence integrity

**Dynamic Resizing:**
- Monitors load factor continuously
- Triggers resize at 0.70 load factor threshold
- Rehashes all existing entries to new table size

**Operations Supported:**
- `insert(key, value)` - Add new key-value pair
- `lookup(key)` - Retrieve value for given key
- `remove(key)` - Delete key-value pair with tombstone marking
- `resize()` - Manual or automatic table expansion

## 🧪 Testing & Validation

Developed comprehensive test harness covering:
- **Insert Operations:** Verify correct placement and collision handling
- **Lookup Operations:** Confirm accurate retrieval and performance
- **Remove Operations:** Test tombstone flag implementation
- **Resize Operations:** Validate automatic resizing triggers and data integrity
- **Performance Analysis:** Load factor monitoring and operation timing

## 📊 Performance Characteristics

- **Average Case:** O(1) for insert, lookup, and delete operations
- **Load Factor Management:** Maintains performance through automatic resizing
- **Space Efficiency:** Optimized memory usage with tombstone recycling

## 🎯 What I Learned

**Technical Skills:**
- Advanced hash table implementation techniques
- Load factor optimization and performance tuning
- Collision resolution strategy design
- Memory management in data structure implementation

**Problem-Solving:**
- Algorithm optimization for specific use cases (ISBN keys)
- Testing methodology for complex data structures
- Performance analysis and benchmarking

## 🚧 Future Enhancements

- Implementation of alternative collision resolution methods (quadratic probing, double hashing)
- Support for generic key types beyond ISBN
- Performance comparison with Java's built-in HashMap
- Thread-safe concurrent implementation

## 📚 Academic Context

This project was developed as part of data structures coursework, focusing on:
- Understanding hash table internals
- Implementing efficient collision resolution
- Performance optimization techniques
- Comprehensive testing methodologies

---

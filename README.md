# Book Hash Table - Dynamically Resizable Hash Table Implementation

A specialized hash table implementation in Java designed for book inventory management, featuring extraction-based hashing on ISBN keys, linear probing collision resolution, and automatic resizing capabilities.

## Features

- **ISBN-optimized hashing** using last 3 digits for optimal distribution in book databases
- **Linear probing** collision resolution with tombstone flag support
- **Automatic resizing** triggered at 0.70 load factor for performance optimization
- **Safe deletion support** with tombstone flags to maintain hash table integrity
- **Comprehensive test suite** validating all operations across various collision scenarios

## Technical Implementation

### Core Components
- **Hash Function**: Extraction-based algorithm using last 3 digits of ISBN for book-specific optimization
- **Collision Resolution**: Linear probing with efficient probe sequence
- **Load Factor Management**: Automatic resize when load exceeds 70%
- **Memory Management**: Tombstone flags enable safe deletions without breaking probe sequences
- **Prime Number Sizing**: Uses prime-sized tables for better hash distribution

### Performance Characteristics
- **Insert**: O(1) average case, O(n) worst case
- **Find**: O(1) average case, O(n) worst case  
- **Remove**: O(1) average case, O(n) worst case
- **Resize**: O(n) when triggered at 0.70 load factor

## Usage

```java
// Create new book hash table
BookHashTable bookTable = new BookHashTable();

// Insert books with ISBN and title
bookTable.insert("Effective Java", "9780134685991");
bookTable.insert("Head First Design Patterns", "9780596009205");

// Find books by ISBN
String bookTitle = bookTable.find("9780134685991");

// Remove books by ISBN
boolean removed = bookTable.remove("9780596009205");

// Display table state
bookTable.printTable();
```

## Project Structure

```
src/
├── BookHashTable.java      # Main hash table implementation
└── BookHashTableTest.java  # Comprehensive test suite
```

## Running the Code

### Prerequisites
- Java 8 or higher
- No external dependencies required

### Compilation
```bash
javac BookHashTable.java BookHashTableTest.java
```

### Running Tests
```bash
java BookHashTableTest
```

## Algorithm Details

### Hash Function
The extraction-based hash function optimizes for ISBN keys by:
1. Extracting the last 3 digits from ISBN strings
2. Converting to integer for mathematical operations
3. Applying modulo operation for table size fitting

```java
private int hash(String isbn, int tableSize) {
    int lastThreeDigits = Integer.parseInt(isbn.substring(isbn.length() - 3));
    return lastThreeDigits % tableSize;
}
```

### Collision Resolution
Linear probing implementation:
- Sequential search from initial hash position
- Tombstone flags mark deleted entries
- Maintains probe sequence integrity during deletions

### Resizing Strategy
- Monitors load factor after each insertion
- Triggers resize at 0.70 threshold
- Uses prime number sizing for optimal distribution
- Rehashes all existing entries to new table

## Testing

The test suite validates:
- ✅ Basic insert/find/remove operations
- ✅ Collision handling with same-hash ISBN keys  
- ✅ Automatic resize behavior at load factor threshold
- ✅ Insertion order independence
- ✅ Tombstone flag functionality
- ✅ Prime number table sizing

### Test Scenarios Covered
1. **Different insertion orders** - Verifies consistent behavior regardless of input sequence
2. **Collision handling** - Tests linear probing with ISBNs that hash to same index
3. **Resizing behavior** - Validates automatic expansion when load factor exceeds 0.70
4. **Find operations** - Confirms accurate retrieval after collisions and resizing
5. **Remove operations** - Tests tombstone flag implementation
6. **Post-removal insertion** - Verifies tombstone reuse for new entries

## Technical Specifications

- **Language**: Java
- **Key Type**: ISBN strings (optimized for 10 and 13 digit formats)
- **Value Type**: Book titles (String)
- **Initial Capacity**: 11 (prime number)
- **Load Factor Threshold**: 0.70
- **Resize Strategy**: Double capacity, then find next prime
- **Collision Resolution**: Linear probing with wraparound

## Key Methods

### `void insert(String name, String isbn)`
Inserts a book into the hash table. Handles duplicates by displaying a warning message.

### `String find(String isbn)`
Retrieves the book title associated with the given ISBN. Returns null if not found.

### `boolean remove(String isbn)`
Removes a book by ISBN using tombstone marking. Returns true if book was found and removed.

### `void printTable()`
Displays the current state of the hash table for debugging and verification.

## Development Notes

This implementation prioritizes:
- **ISBN-specific optimization**: Hash function designed for book database patterns
- **Educational clarity**: Clear code structure demonstrating hash table concepts
- **Reliability**: Comprehensive testing ensures correctness across edge cases
- **Performance**: Maintains optimal load factor through automatic resizing

## Real-World Applications

This hash table design is ideal for:
- Library management systems
- Bookstore inventory tracking
- Academic book databases
- ISBN-based catalog systems

## Author

Jacky Huang - Information Technology Student, Kwantlen Polytechnic University

## Academic Context

Developed as part of Object-Oriented Programming & Data Structures coursework, demonstrating advanced understanding of hash table algorithms and performance optimization techniques.

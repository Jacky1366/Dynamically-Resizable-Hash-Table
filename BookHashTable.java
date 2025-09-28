public class BookHashTable {
    private class Book {
        String name;
        String isbn;
        boolean isDeleted;  // For marking deleted entries

        Book(String name, String isbn) {
            this.name = name;
            this.isbn = isbn;
            this.isDeleted = false;
        }
    }

    private Book[] table;
    private int size;
    private double loadFactor;
    private int initialSize;

    public BookHashTable() {
        this.initialSize = 11;
        this.loadFactor = 0.70;
        this.size = 0;
        this.table = new Book[initialSize];
    }

    // Hash function using last 3 digits of ISBN
    private int hash(String isbn, int tableSize) {
        int lastThreeDigits = Integer.parseInt(isbn.substring(isbn.length() - 3));
        return lastThreeDigits % tableSize;
    }

    // Insert a new book into the hash table
    public void insert(String name, String isbn) {
        if ((double) (size + 1) / table.length > loadFactor) {
            resize();
        }

        int index = hash(isbn, table.length);
        int originalIndex = index;

        // Linear probing
        while (table[index] != null && !table[index].isDeleted) {
            if (table[index].isbn.equals(isbn)) {
                System.out.println("Duplicate ISBN found: " + isbn);
                return;
            }
            index = (index + 1) % table.length;
            if (index == originalIndex) {
                System.out.println("Table is full!");
                return;
            }
        }

        table[index] = new Book(name, isbn);
        size++;
        System.out.println("Inserted " + name + " (ISBN: " + isbn + ") at index " + index);
    }

    // Resize the hash table
    private void resize() {
        int newSize = nextPrime(table.length * 2);
        Book[] oldTable = table;
        table = new Book[newSize];
        size = 0;

        System.out.println("\nResizing table to " + newSize);

        // Rehash all existing entries
        for (Book book : oldTable) {
            if (book != null && !book.isDeleted) {
                insert(book.name, book.isbn);
            }
        }
    }

    // Find a book by ISBN
    public String find(String isbn) {
        int index = hash(isbn, table.length);
        int originalIndex = index;

        while (table[index] != null) {
            if (!table[index].isDeleted && table[index].isbn.equals(isbn)) {
                return table[index].name;  // Return the book name instead of Book object
            }
            index = (index + 1) % table.length;
            if (index == originalIndex) {
                break;
            }
        }
        return null;
    }

    // Remove a book by ISBN
    public boolean remove(String isbn) {
        int index = hash(isbn, table.length);
        int originalIndex = index;

        while (table[index] != null) {
            if (!table[index].isDeleted && table[index].isbn.equals(isbn)) {
                table[index].isDeleted = true;
                size--;
                return true;
            }
            index = (index + 1) % table.length;
            if (index == originalIndex) {
                break;
            }
        }
        return false;
    }

    // Helper method to find next prime number
    private int nextPrime(int n) {
        while (!isPrime(n)) {
            n++;
        }
        return n;
    }

    private boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }

    // Print the current state of the hash table
    public void printTable() {
        System.out.println("\nCurrent Hash Table State:");
        System.out.println("Size: " + size + ", Capacity: " + table.length);
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null && !table[i].isDeleted) {
                System.out.println("Index " + i + ": " + table[i].name + " (ISBN: " + table[i].isbn + ")");
            }
        }
        System.out.println();
    }
}
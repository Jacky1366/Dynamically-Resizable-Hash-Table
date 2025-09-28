public class BookHashTableTest {
    public static void main(String[] args) {
        System.out.println("Test 1: Different insertion orders");
        System.out.println("First Order:");
        BookHashTable table1 = new BookHashTable();
        table1.insert("Book A", "1234567123");  // Will hash to index 123
        table1.insert("Book B", "9876567456");  // Will hash to index 456
        table1.insert("Book C", "5555567123");  // Will hash to index 123, probe to next available
        table1.printTable();

        System.out.println("Second Order:");
        BookHashTable table2 = new BookHashTable();
        table2.insert("Book C", "5555567123");  // Will hash to index 123
        table2.insert("Book A", "1234567123");  // Will hash to index 123, probe to next available
        table2.insert("Book B", "9876567456");  // Will hash to index 456
        table2.printTable();

        System.out.println("\nTest 2: Collision handling");
        BookHashTable table3 = new BookHashTable();
        table3.insert("Book 1", "1234567123");  // Same last 3 digits (123)
        table3.insert("Book 2", "9876567123");  // Will collide
        table3.insert("Book 3", "5555567123");  // Will collide
        table3.printTable();

        System.out.println("\nTest 3: Resizing");
        // Continue inserting until load factor exceeds 0.70
        table3.insert("Book 4", "1234567456");
        table3.insert("Book 5", "9876543789");
        table3.insert("Book 6", "5555567890");
        table3.insert("Book 7", "1111122222");
        table3.insert("Book 8", "2222233333");
        table3.insert("Book 9", "3333344444");  // This should trigger resize
        table3.printTable();

        System.out.println("\nTest 4: Finding books");
        String foundName = table3.find("1234567123");
        System.out.println("Finding Book 1: " + (foundName != null ? "Found " + foundName : "Not found"));
        foundName = table3.find("9999999999");
        System.out.println("Finding non-existent book: " + (foundName != null ? "Found" : "Not found"));

        System.out.println("\nTest 5: Removing books");
        boolean removed = table3.remove("1234567123");
        System.out.println("Removing Book 1: " + (removed ? "Removed" : "Not found"));
        table3.printTable();

        System.out.println("\nTest 6: Adding after removal");
        table3.insert("New Book", "9999999999");
        table3.printTable();
    }
}
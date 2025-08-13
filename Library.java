import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private String libraryName;
    private Map<String, Book> books; // HAS-A relationship with Book
    private Map<String, User> users; // HAS-A relationship with User
    private List<String> transactionHistory;
    
    // Constructor
    public Library(String libraryName) {
        this.libraryName = libraryName;
        this.books = new HashMap<>();
        this.users = new HashMap<>();
        this.transactionHistory = new ArrayList<>();
    }
    
    // Method to add book to library
    public void addBook(Book book) {
        books.put(book.getBookId(), book);
        addTransaction("Book added: " + book.getTitle() + " (ID: " + book.getBookId() + ")");
    }
    
    // Method to add user to library
    public void addUser(User user) {
        users.put(user.getUserId(), user);
        addTransaction("User registered: " + user.getName() + " (ID: " + user.getUserId() + ")");
    }
    
    // Method to issue book
    public boolean issueBook(String bookId, String userId) {
        Book book = books.get(bookId);
        User user = users.get(userId);
        
        if (book == null) {
            System.out.println("Book with ID " + bookId + " not found!");
            return false;
        }
        
        if (user == null) {
            System.out.println("User with ID " + userId + " not found!");
            return false;
        }
        
        if (book.isIssued()) {
            System.out.println("Book '" + book.getTitle() + "' is already issued!");
            return false;
        }
        
        if (!user.canIssueMoreBooks()) {
            System.out.println("User " + user.getName() + " has reached maximum book limit!");
            return false;
        }
        
        // Issue the book
        if (book.issueBook(userId) && user.addIssuedBook(bookId)) {
            addTransaction("Book issued: " + book.getTitle() + " to " + user.getName());
            System.out.println("Book '" + book.getTitle() + "' successfully issued to " + user.getName());
            return true;
        }
        
        return false;
    }
    
    // Method to return book
    public boolean returnBook(String bookId, String userId) {
        Book book = books.get(bookId);
        User user = users.get(userId);
        
        if (book == null) {
            System.out.println("Book with ID " + bookId + " not found!");
            return false;
        }
        
        if (user == null) {
            System.out.println("User with ID " + userId + " not found!");
            return false;
        }
        
        if (!book.isIssued() || !book.getIssuedToUserId().equals(userId)) {
            System.out.println("Book '" + book.getTitle() + "' is not issued to user " + user.getName());
            return false;
        }
        
        // Return the book
        if (book.returnBook() && user.removeIssuedBook(bookId)) {
            addTransaction("Book returned: " + book.getTitle() + " by " + user.getName());
            System.out.println("Book '" + book.getTitle() + "' successfully returned by " + user.getName());
            return true;
        }
        
        return false;
    }
    
    // Method to display all books
    public void displayAllBooks() {
        System.out.println("\n=== All Books in " + libraryName + " ===");
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        
        for (Book book : books.values()) {
            System.out.println(book);
        }
    }
    
    // Method to display available books
    public void displayAvailableBooks() {
        System.out.println("\n=== Available Books ===");
        boolean hasAvailable = false;
        
        for (Book book : books.values()) {
            if (!book.isIssued()) {
                System.out.println(book);
                hasAvailable = true;
            }
        }
        
        if (!hasAvailable) {
            System.out.println("No books available for issue.");
        }
    }
    
    // Method to display all users
    public void displayAllUsers() {
        System.out.println("\n=== All Users ===");
        if (users.isEmpty()) {
            System.out.println("No users registered.");
            return;
        }
        
        for (User user : users.values()) {
            System.out.println(user);
        }
    }
    
    // Method to search book by title
    public void searchBookByTitle(String title) {
        System.out.println("\n=== Search Results for: " + title + " ===");
        boolean found = false;
        
        for (Book book : books.values()) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println(book);
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("No books found with title containing: " + title);
        }
    }
    
    // Method to display transaction history
    public void displayTransactionHistory() {
        System.out.println("\n=== Transaction History ===");
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions recorded.");
            return;
        }
        
        for (int i = 0; i < transactionHistory.size(); i++) {
            System.out.println((i + 1) + ". " + transactionHistory.get(i));
        }
    }
    
    // Private method to add transaction
    private void addTransaction(String transaction) {
        transactionHistory.add(transaction);
    }
    
    // Getter methods
    public String getLibraryName() {
        return libraryName;
    }
    
    public int getTotalBooks() {
        return books.size();
    }
    
    public int getTotalUsers() {
        return users.size();
    }
}
import java.util.ArrayList;
import java.util.List;

public class User {
    private String userId;
    private String name;
    private String email;
    private List<String> issuedBooks; // HAS-A relationship with Book IDs
    private int maxBooksAllowed;
    
    // Constructor
    public User(String userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.issuedBooks = new ArrayList<>();
        this.maxBooksAllowed = 3; // Default limit
    }
    
    // Constructor with custom book limit (Constructor Overloading - Polymorphism)
    public User(String userId, String name, String email, int maxBooksAllowed) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.issuedBooks = new ArrayList<>();
        this.maxBooksAllowed = maxBooksAllowed;
    }
    
    // Getter methods (Encapsulation)
    public String getUserId() {
        return userId;
    }
    
    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public List<String> getIssuedBooks() {
        return new ArrayList<>(issuedBooks); // Return copy to maintain encapsulation
    }
    
    public int getMaxBooksAllowed() {
        return maxBooksAllowed;
    }
    
    public int getCurrentBookCount() {
        return issuedBooks.size();
    }
    
    // Method to check if user can issue more books
    public boolean canIssueMoreBooks() {
        return issuedBooks.size() < maxBooksAllowed;
    }
    
    // Method to add issued book
    public boolean addIssuedBook(String bookId) {
        if (canIssueMoreBooks() && !issuedBooks.contains(bookId)) {
            issuedBooks.add(bookId);
            return true;
        }
        return false;
    }
    
    // Method to remove returned book
    public boolean removeIssuedBook(String bookId) {
        return issuedBooks.remove(bookId);
    }
    
    // Override toString method (Polymorphism)
    @Override
    public String toString() {
        return "User{" +
                "ID='" + userId + '\'' +
                ", Name='" + name + '\'' +
                ", Email='" + email + '\'' +
                ", Books Issued=" + issuedBooks.size() + "/" + maxBooksAllowed +
                ", Issued Books=" + issuedBooks +
                '}';
    }
}

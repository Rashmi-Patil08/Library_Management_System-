public class Book {
    private String bookId;
    private String title;
    private String author;
    private boolean isIssued;
    private String issuedToUserId;
    
    // Constructor
    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isIssued = false;
        this.issuedToUserId = null;
    }
    
    // Getter methods (Encapsulation)
    public String getBookId() {
        return bookId;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public boolean isIssued() {
        return isIssued;
    }
    
    public String getIssuedToUserId() {
        return issuedToUserId;
    }
    
    // Setter methods (Encapsulation)
    public void setIssued(boolean issued) {
        this.isIssued = issued;
    }
    
    public void setIssuedToUserId(String userId) {
        this.issuedToUserId = userId;
    }
    
    // Method to issue book
    public boolean issueBook(String userId) {
        if (!isIssued) {
            this.isIssued = true;
            this.issuedToUserId = userId;
            return true;
        }
        return false;
    }
    
    // Method to return book
    public boolean returnBook() {
        if (isIssued) {
            this.isIssued = false;
            this.issuedToUserId = null;
            return true;
        }
        return false;
    }
    
    // Override toString method (Polymorphism)
    @Override
    public String toString() {
        return "Book{" +
                "ID='" + bookId + '\'' +
                ", Title='" + title + '\'' +
                ", Author='" + author + '\'' +
                ", Issued=" + isIssued +
                (isIssued ? ", Issued To='" + issuedToUserId + '\'' : "") +
                '}';
    }
}

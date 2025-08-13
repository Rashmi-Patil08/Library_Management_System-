import java.util.Scanner;

public class LibraryManagementSystem {
    private static Library library = new Library("Central Library");
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        // Initialize with some sample data
        initializeSampleData();
        
        System.out.println("=== Welcome to " + library.getLibraryName() + " Management System ===");
        
        while (true) {
            displayMenu();
            int choice = getChoice();
            
            switch (choice) {
                case 1:
                    addNewBook();
                    break;
                case 2:
                    addNewUser();
                    break;
                case 3:
                    issueBook();
                    break;
                case 4:
                    returnBook();
                    break;
                case 5:
                    library.displayAllBooks();
                    break;
                case 6:
                    library.displayAvailableBooks();
                    break;
                case 7:
                    library.displayAllUsers();
                    break;
                case 8:
                    searchBooks();
                    break;
                case 9:
                    library.displayTransactionHistory();
                    break;
                case 10:
                    displayLibraryStats();
                    break;
                case 0:
                    System.out.println("Thank you for using Library Management System!");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
            
            System.out.println("\nPress Enter to continue...");
            scanner.nextLine();
        }
    }
    
    private static void displayMenu() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("           LIBRARY MANAGEMENT SYSTEM");
        System.out.println("=".repeat(50));
        System.out.println("1. Add New Book");
        System.out.println("2. Add New User");
        System.out.println("3. Issue Book");
        System.out.println("4. Return Book");
        System.out.println("5. Display All Books");
        System.out.println("6. Display Available Books");
        System.out.println("7. Display All Users");
        System.out.println("8. Search Books");
        System.out.println("9. Display Transaction History");
        System.out.println("10. Library Statistics");
        System.out.println("0. Exit");
        System.out.println("=".repeat(50));
        System.out.print("Enter your choice: ");
    }
    
    private static int getChoice() {
        try {
            int choice = Integer.parseInt(scanner.nextLine());
            return choice;
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    private static void addNewBook() {
        System.out.println("\n=== Add New Book ===");
        System.out.print("Enter Book ID: ");
        String bookId = scanner.nextLine();
        
        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();
        
        System.out.print("Enter Author Name: ");
        String author = scanner.nextLine();
        
        Book book = new Book(bookId, title, author);
        library.addBook(book);
        
        System.out.println("Book added successfully!");
    }
    
    private static void addNewUser() {
        System.out.println("\n=== Add New User ===");
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        
        System.out.print("Enter User Name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        
        System.out.print("Enter Max Books Allowed (default 3): ");
        String maxBooksStr = scanner.nextLine();
        
        User user;
        if (maxBooksStr.isEmpty()) {
            user = new User(userId, name, email);
        } else {
            try {
                int maxBooks = Integer.parseInt(maxBooksStr);
                user = new User(userId, name, email, maxBooks);
            } catch (NumberFormatException e) {
                user = new User(userId, name, email);
            }
        }
        
        library.addUser(user);
        System.out.println("User added successfully!");
    }
    
    private static void issueBook() {
        System.out.println("\n=== Issue Book ===");
        System.out.print("Enter Book ID: ");
        String bookId = scanner.nextLine();
        
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        
        library.issueBook(bookId, userId);
    }
    
    private static void returnBook() {
        System.out.println("\n=== Return Book ===");
        System.out.print("Enter Book ID: ");
        String bookId = scanner.nextLine();
        
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        
        library.returnBook(bookId, userId);
    }
    
    private static void searchBooks() {
        System.out.println("\n=== Search Books ===");
        System.out.print("Enter book title to search: ");
        String title = scanner.nextLine();
        
        library.searchBookByTitle(title);
    }
    
    private static void displayLibraryStats() {
        System.out.println("\n=== Library Statistics ===");
        System.out.println("Library Name: " + library.getLibraryName());
        System.out.println("Total Books: " + library.getTotalBooks());
        System.out.println("Total Users: " + library.getTotalUsers());
    }
    
    private static void initializeSampleData() {
        // Add sample books
        library.addBook(new Book("B001", "The Java Programming Language", "James Gosling"));
        library.addBook(new Book("B002", "Clean Code", "Robert Martin"));
        library.addBook(new Book("B003", "Design Patterns", "Gang of Four"));
        library.addBook(new Book("B004", "Effective Java", "Joshua Bloch"));
        library.addBook(new Book("B005", "Spring in Action", "Craig Walls"));
        
        // Add sample users
        library.addUser(new User("U001", "John Doe", "john@email.com"));
        library.addUser(new User("U002", "Jane Smith", "jane@email.com", 5));
        library.addUser(new User("U003", "Mike Johnson", "mike@email.com"));
        
        System.out.println("Sample data initialized successfully!");
    }
}

Library Management System - Java OOP Implementation
📋 Task Overview
This is Task 3 of the Java Developer Internship program, focused on implementing a Library Management System using Object-Oriented Programming (OOP) principles.

🎯 Objective
Develop a mini system to manage books and users using core OOP concepts including Abstraction, Inheritance, Polymorphism, and Encapsulation.

🛠️ Tools Used
Language: Java
IDE: VS Code
Terminal: Command line interface for compilation and execution
📁 Project Structure
library-management-system/
├── Book.java
├── User.java
├── Library.java
├── LibraryManagementSystem.java
└── 

🔧 Classes Implementation
1. Book Class
Attributes: bookId, title, author, isIssued, issuedToUserId
Methods: issueBook(), returnBook(), getter/setter methods
OOP Concepts: Encapsulation, Method Overriding (toString)
2. User Class
Attributes: userId, name, email, issuedBooks, maxBooksAllowed
Methods: canIssueMoreBooks(), addIssuedBook(), removeIssuedBook()
OOP Concepts: Encapsulation, Constructor Overloading (Polymorphism), HAS-A relationship
3. Library Class
Attributes: libraryName, books (Map), users (Map), transactionHistory
Methods: addBook(), addUser(), issueBook(), returnBook(), search functionality
OOP Concepts: HAS-A relationships, Abstraction, Encapsulation
4. LibraryManagementSystem Class (Main)
Purpose: Main class with user interface and menu system
Features: Interactive menu, sample data initialization, user input handling

🚀 Features Implemented
Core Features
    Book Management: Add, display, search books
    User Management: Register users with customizable book limits
    Issue System: Issue books to users with validation
    Return System: Return books with proper verification
    Search Functionality: Search books by title
    Transaction History: Track all library operations
    
Additional Features
Library Statistics: Display total books and users
Available Books: Show only non-issued books
User Book Limits: Configurable maximum books per user
Input Validation: Error handling for invalid inputs
Sample Data: Pre-loaded test data for demonstration

🏗️ OOP Concepts Demonstrated
1. Encapsulation
Private attributes with public getter/setter methods
Data hiding and controlled access to class members
2. Abstraction
Clean interface design hiding implementation details
Modular design with clear responsibilities

4. Polymorphism
Method overriding (toString methods)
Constructor overloading in User class
Runtime polymorphism through method calls
5. Relationships
HAS-A Relationship: Library HAS-A Books and Users
HAS-A Relationship: User HAS-A List of issued books

💻 How to Run
Prerequisites
Java Development Kit (JDK) 8 or higher
VS Code or any Java IDE
Command line access
Compilation and Execution
bash
# Compile all Java files
javac *.java

# Run the main program
java LibraryManagementSystem
Sample Usage
Add Books: Use menu option 1 to add new books
Register Users: Use menu option 2 to register new users
Issue Books: Use menu option 3 to issue books to users
Return Books: Use menu option 4 to return books
View Data: Use options 5-7 to view books and users
Search: Use option 8 to search for books
History: Use option 9 to view transaction history

📊 Sample Data
The system comes pre-loaded with:

5 Books: Java Programming, Clean Code, Design Patterns, Effective Java, Spring in Action
3 Users: John Doe, Jane Smith, Mike Johnson

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // Lists to store book and user data
    protected static ArrayList<String> bookList = new ArrayList<>();
    protected static ArrayList<String> userList = new ArrayList<>();
    protected static Scanner input = new Scanner(System.in); // Scanner declared as a global variable

    public static void main(String[] args) {
        int choice;

        try {
            do {
                // Display the menu options
                System.out.println("\nMenu:");
                System.out.println("1. Add Book");
                System.out.println("2. Show Books");
                System.out.println("3. Update Book");
                System.out.println("4. Delete Book");
                System.out.println("5. Add User");
                System.out.println("6. Show Users");
                System.out.println("7. Update User");
                System.out.println("8. Delete User");
                System.out.println("9. Exit");
                System.out.print("Select an option: ");
                choice = input.nextInt();
                input.nextLine();  // Consume newline

                if (choice == 0) {
                    // Simulating a failure when choice is 0 (invalid option)
                    System.out.println("Error: Invalid option selected!");
                    return; // Simulate a failure
                }

                switch (choice) {
                    case 1:
                        // Adding a book
                        System.out.print("Enter book title: ");
                        String title = input.nextLine();
                        System.out.print("Enter book author: ");
                        String author = input.nextLine();
                        addBook(title, author);
                        break;
                    case 2:
                        // Displaying the list of books
                        showBooks();
                        break;
                    case 3:
                        // Updating a book
                        System.out.print("Enter the index of the book to update: ");
                        int updateIndex = input.nextInt();
                        input.nextLine(); // Consume newline
                        updateBook(updateIndex);
                        break;
                    case 4:
                        // Deleting a book
                        System.out.print("Enter the index of the book to delete: ");
                        int deleteIndex = input.nextInt();
                        deleteBook(deleteIndex);
                        break;
                    case 5:
                        // Adding a user
                        System.out.print("Enter user name: ");
                        String name = input.nextLine();
                        System.out.print("Enter user email: ");
                        String email = input.nextLine();
                        addUser(name, email);
                        break;
                    case 6:
                        // Displaying the list of users
                        showUsers();
                        break;
                    case 7:
                        // Updating a user
                        System.out.print("Enter the index of the user to update: ");
                        int updateUserIndex = input.nextInt();
                        input.nextLine(); // Consume newline
                        updateUser(updateUserIndex);
                        break;
                    case 8:
                        // Deleting a user
                        System.out.print("Enter the index of the user to delete: ");
                        int deleteUserIndex = input.nextInt();
                        deleteUser(deleteUserIndex);
                        break;
                    case 9:
                        // Exiting the application
                        System.out.println("Exiting the application.");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } while (choice != 9);
        } finally {
            input.close(); // Close the Scanner object after all inputs are done
        }
    }

    // Method to add a book
    public static void addBook(String title, String author) {
        if (title.isEmpty() || author.isEmpty()) {
            System.out.println("Error: Title or author cannot be empty.");
            return; // Simulate a failure in the test case
        }
        
        if (title.equalsIgnoreCase("fail")) {
            System.out.println("Simulated failure when adding book.");
            return; // Simulate a failure
        }

        bookList.add(title + " by " + author);
        System.out.println("Book successfully added.");
    }

    // Method to display all books
    public static void showBooks() {
        if (bookList.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        System.out.println("Book List:");
        for (int i = 0; i < bookList.size(); i++) {
            System.out.println((i + 1) + ". " + bookList.get(i));
        }
    }

    // Method to update book information
    public static void updateBook(int index) {
        if (index < 1 || index > bookList.size()) {
            System.out.println("Invalid index.");
            return; // Simulate a failure in the test case
        }
        System.out.print("Enter new title (leave empty to keep unchanged): ");
        String newTitle = input.nextLine();
        System.out.print("Enter new author (leave empty to keep unchanged): ");
        String newAuthor = input.nextLine();
        String oldBook = bookList.get(index - 1);
        String[] parts = oldBook.split(" by ");

        // Update title and author if new values are entered
        if (!newTitle.isEmpty()) {
            parts[0] = newTitle;
        }
        if (!newAuthor.isEmpty()) {
            parts[1] = newAuthor;
        }
        bookList.set(index - 1, parts[0] + " by " + parts[1]);
        System.out.println("Book successfully updated.");
    }

    // Method to delete a book
    public static void deleteBook(int index) {
        if (index < 1 || index > bookList.size()) {
            System.out.println("Invalid index.");
            return; // Simulate a failure in the test case
        }
        bookList.remove(index - 1);
        System.out.println("Book successfully deleted.");
    }

    // Method to add a user
    public static void addUser(String name, String email) {
        if (name.isEmpty() || email.isEmpty() || !email.contains("@")) {
            System.out.println("Error: Name or email cannot be empty, and email must be valid.");
            return; // Simulate a failure in the test case
        }

        if (name.equalsIgnoreCase("fail")) {
            System.out.println("Simulated failure when adding user.");
            return; // Simulate a failure
        }

        userList.add(name + " with email " + email);
        System.out.println("User successfully added.");
    }

    // Method to display all users
    public static void showUsers() {
        if (userList.isEmpty()) {
            System.out.println("No users available.");
            return;
        }
        System.out.println("User List:");
        for (int i = 0; i < userList.size(); i++) {
            System.out.println((i + 1) + ". " + userList.get(i));
        }
    }

    // Method to update user information
    public static void updateUser(int index) {
        if (index < 1 || index > userList.size()) {
            System.out.println("Invalid index.");
            return; // Simulate a failure in the test case
        }
        System.out.print("Enter new name (leave empty to keep unchanged): ");
        String newName = input.nextLine();
        System.out.print("Enter new email (leave empty to keep unchanged): ");
        String newEmail = input.nextLine();
        String oldUser = userList.get(index - 1);
        String[] parts = oldUser.split(" with email ");

        // Update name and email if new values are entered
        if (!newName.isEmpty()) {
            parts[0] = newName;
        }
        if (!newEmail.isEmpty()) {
            parts[1] = newEmail;
        }
        userList.set(index - 1, parts[0] + " with email " + parts[1]);
        System.out.println("User successfully updated.");
    }

    // Method to delete a user
    public static void deleteUser(int index) {
        if (index < 1 || index > userList.size()) {
            System.out.println("Invalid index.");
            return; // Simulate a failure in the test case
        }
        userList.remove(index - 1);
        System.out.println("User successfully deleted.");
    }
}

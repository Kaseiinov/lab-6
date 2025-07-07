package server.models;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String password;
    private List<Book> borrowedBooks = new ArrayList<>();
    private List<Book> borrowedBooksHistory = new ArrayList<>();

    public User(String firstName, String lastName, int age, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.password = password;
    }

    public User() {}

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    public void setBookToStore(Book book) {
        borrowedBooksHistory.add(book);
    }

    public List<Book> getBorrowedBooksHistory() {
        return borrowedBooksHistory;
    }

    public void setBorrowedBooksHistory(List<Book> borrowedBooksHistory) {
        this.borrowedBooksHistory = borrowedBooksHistory;
    }

    public int getBorrowedBooksCount() {
        return borrowedBooks.size();
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User {\n" +
                "  firstName='" + firstName + "',\n" +
                "  lastName='" + lastName + "',\n" +
                "  age=" + age + ",\n" +
                "  email='" + email + "',\n" +
                "  password='" + password + "'\n" +
                "}";
    }
}

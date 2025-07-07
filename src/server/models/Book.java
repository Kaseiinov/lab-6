package server.models;

import java.util.Objects;

public class Book {
    private String id;
    private String name;
    private String author;
    private int year;
    private String description;
    private boolean isBorrowed;
    private String borrowedBy;

    public Book(String id, String name, String author, int year, String description) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.year = year;
        this.description = description;
        this.isBorrowed = false;
        this.borrowedBy = null;
    }

    public Book(){};

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public String getBorrowedBy() {
        return borrowedBy;
    }

    public void setBorrowedBy(String borrowedBy) {
        this.borrowedBy = borrowedBy;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book books = (Book) o;
        return year == books.year && Objects.equals(name, books.name) && Objects.equals(author, books.author) && Objects.equals(description, books.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, author, year, description);
    }

    @Override
    public String toString() {
        return "Books{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", desciption='" + description + '\'' +
                '}';
    }
}

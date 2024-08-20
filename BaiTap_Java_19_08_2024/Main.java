package BaiTap_Java_19_08_2024;

import java.util.*;

class Book {
    private String title;
    private String author;
    private String ISBN;

    public Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + ISBN;
    }
}

class Library {
    private List<Book> books;
    private Set<String> borrowedBooks;
    private Map<String, String> borrowedBy;

    public Library() {
        books = new ArrayList<>();
        borrowedBooks = new HashSet<>();
        borrowedBy = new HashMap<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void borrowBook(String ISBN, String borrower) throws Exception {
        if (borrowedBooks.contains(ISBN)) {
            throw new Exception("This book is already borrowed.");
        }
        borrowedBooks.add(ISBN);
        borrowedBy.put(ISBN, borrower);
    }

    public void returnBook(String ISBN) throws Exception {
        if (!borrowedBooks.contains(ISBN)) {
            throw new Exception("This book is not borrowed.");
        }
        borrowedBooks.remove(ISBN);
        borrowedBy.remove(ISBN);
    }

    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Thêm 5 cuốn sách vào thư viện
        library.addBook(new Book("Clean Code", "Robert C. Martin", "9780132350884"));
        library.addBook(new Book("Effective Java", "Joshua Bloch", "9780134685991"));
        library.addBook(new Book("Design Patterns", "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides", "9780201633610"));
        library.addBook(new Book("Introduction to Algorithms", "Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest, Clifford Stein", "9780262033848"));
        library.addBook(new Book("The Pragmatic Programmer", "Andrew Hunt, David Thomas", "9780201616224"));

        // Hiển thị danh sách sách hiện có trong thư viện
        System.out.println("Danh sách sách trong thư viện:");
        library.displayBooks();

        try {
            // Mượn một vài cuốn sách
            library.borrowBook("9780132350884", "Alice");
            library.borrowBook("9780201633610", "Bob");

            // Hiển thị trạng thái của thư viện sau khi mượn
            System.out.println("\nTrạng thái sau khi mượn:");
            library.displayBooks();
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }

        try {
            // Trả lại sách
            library.returnBook("9780132350884");

            // Hiển thị trạng thái của thư viện sau khi trả sách
            System.out.println("\nTrạng thái sau khi trả sách:");
            library.displayBooks();
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}

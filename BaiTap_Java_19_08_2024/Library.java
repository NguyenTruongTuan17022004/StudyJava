package BaiTap_Java_19_08_2024;

import java.util.*;

    class Library {
        private List<Book> books = new ArrayList<>();
        private Set<String> borrowedBooks = new HashSet<>();
        private Map<String, String> borrowedBy = new HashMap<>();

        // Thêm sách vào thư viện
        public void addBook(Book book) {
            books.add(book);
        }

        // Mượn sách từ thư viện
        public void borrowBook(String ISBN, String borrower) throws Exception {
            if (borrowedBooks.contains(ISBN)) {
                throw new Exception("This book is already borrowed.");
            }
            borrowedBooks.add(ISBN);
            borrowedBy.put(ISBN, borrower);
        }

        // Trả lại sách cho thư viện
        public void returnBook(String ISBN) throws Exception {
            if (!borrowedBooks.contains(ISBN)) {
                throw new Exception("This book was not borrowed.");
            }
            borrowedBooks.remove(ISBN);
            borrowedBy.remove(ISBN);
        }


        public void displayBooks() {
            for (Book book : books) {
                if (!borrowedBooks.contains(book.getISBN())) {
                    System.out.println(book);
                }
            }
        }
    }


package BaiTap_Java_19_08_2024;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Thêm 5 cuốn sách vào thư viện

        // Hiển thị danh sách sách hiện có trong thư viện
        System.out.println("Danh sách sách trong thư viện:");
        library.displayBooks();

        try {
            // Mượn một vài cuốn sách

            // Hiển thị trạng thái của thư viện sau khi mượn
            System.out.println("\nTrạng thái sau khi mượn:");
            library.displayBooks();
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }

        try {
            // Trả lại sách

            // Hiển thị trạng thái của thư viện sau khi trả sách
            System.out.println("\nTrạng thái sau khi trả sách:");
            library.displayBooks();
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}

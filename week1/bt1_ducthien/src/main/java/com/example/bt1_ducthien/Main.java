package com.example.bt1_ducthien;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) {
        List<Book> listBook = new ArrayList<>();
        Scanner x = new Scanner(System.in);

        String msg = """
                Chương trình quản lý sách
                1. Thêm 1 cuốn sách
                2. Xóa 1 cuốn sách
                3. Thay đổi sách
                4. Xuất thông tin
                5. Tìm sách Lập trình
                6. Lấy sách tối đa theo giá
                7. Tìm kiếm theo tác giả
                0. Thoát
                Chọn chức năng: """;

        int chon;
        do {
            System.out.print(msg);
            chon = Integer.parseInt(x.nextLine());

            switch (chon) {
                case 1 -> {
                    Book newBook = new Book();
                    newBook.input(x);
                    listBook.add(newBook);
                    System.out.println("Đã thêm sách thành công.");
                }
                case 2 -> {
                    System.out.print("Nhập vào mã sách cần xóa: ");
                    int bookId = Integer.parseInt(x.nextLine());
                    Book find = listBook.stream()
                            .filter(p -> p.getId() == bookId)
                            .findFirst()
                            .orElse(null);
                    if (find != null) {
                        listBook.remove(find);
                        System.out.println("Đã xóa sách thành công.");
                    } else {
                        System.out.println("Không tìm thấy sách có mã " + bookId);
                    }
                }
                case 3 -> {
                    System.out.print("Nhập vào mã sách cần điều chỉnh: ");
                    int bookId = Integer.parseInt(x.nextLine());
                    Book find = listBook.stream()
                            .filter(p -> p.getId() == bookId)
                            .findFirst()
                            .orElse(null);
                    if (find != null) {
                        find.input(x);
                        System.out.println("Đã cập nhật sách thành công.");
                    } else {
                        System.out.println("Không tìm thấy sách có mã " + bookId);
                    }
                }
                case 4 -> {
                    System.out.println("\nXuất thông tin danh sách ");
                    listBook.forEach(Book::output);
                }
                case 5 -> {
                    // Tìm sách có tựa đề chứa "Lập trình" (không phân biệt hoa thường)
                    List<Book> list5 = listBook.stream()
                            .filter(u -> u.getTitle().toLowerCase().contains("lập trình"))
                            .toList();
                    list5.forEach(Book::output);
                }
                case 6 -> {
                    // Nhập K và P, lấy tối đa K sách có giá <= P
                    System.out.print("Nhập số lượng sách tối đa K: ");
                    int k = Integer.parseInt(x.nextLine());
                    System.out.print("Nhập giá sách P mong muốn: ");
                    double p = Double.parseDouble(x.nextLine());
                    listBook.stream()
                            .filter(b -> b.getPrice() <= p)
                            .limit(k)
                            .forEach(Book::output);
                }
                case 7 -> {
                    // Nhập danh sách tác giả, hiển thị sách của các tác giả đó
                    System.out.print("Nhập danh sách tác giả (cách nhau bởi dấu phẩy): ");
                    String line = x.nextLine();
                    Set<String> authorsSet = java.util.Arrays.stream(line.split(","))
                            .map(String::trim)
                            .filter(s -> !s.isEmpty())
                            .collect(Collectors.toSet());
                    listBook.stream()
                            .filter(b -> authorsSet.contains(b.getAuthor()))
                            .forEach(Book::output);
                }
                case 0 -> System.out.println("Thoát chương trình.");
                default -> System.out.println("Chọn không hợp lệ.");
            }
        } while (chon != 0);

        x.close();
    }
}

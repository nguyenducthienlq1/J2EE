package com.example.bt3_ducthien.service;

import com.example.bt3_ducthien.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class BookService {
    private final List<Book> books = new ArrayList<>();
    private final AtomicInteger idGenerator = new AtomicInteger(1);

    public BookService() {
        // Khởi tạo dữ liệu mẫu
        books.add(new Book(idGenerator.getAndIncrement(), "Phát triển ứng dụng với J2EE", "Nguyễn Huy Cương"));
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    public Book getBookById(int id) {
        return books.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void addBook(Book book) {
        book.setId(idGenerator.getAndIncrement());
        books.add(book);
    }

    public void updateBook(Book book) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == book.getId()) {
                books.set(i, book);
                break;
            }
        }
    }

    public void deleteBook(int id) {
        books.removeIf(book -> book.getId() == id);
    }
}


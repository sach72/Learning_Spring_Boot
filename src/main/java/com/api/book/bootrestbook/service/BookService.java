package com.api.book.bootrestbook.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.api.book.bootrestbook.entities.Book;

@Service
public class BookService {
    private static List<Book> book = new ArrayList<>();
    private static Book book1;

    static {
        book.add(new Book(1, "Amelia Stone", "The Quantum Paradox"));
        book.add(new Book(2, "Brandon Lee", "Echoes of the Forgotten"));
        book.add(new Book(3, "Clara Vance", "The Midnight Bloom"));
    }

    // get all books
    public List<Book> getAllBooks() {
        return book;
    }

    // get book by id
    public Book getBookById(int id) {
        try {
            book1 = book.stream().filter(e -> e.getId() == id).findFirst().get();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return book1;
    }

    // adding the book
    public Book addBook(Book b) {
        book.add(b);
        return b;
    }

    // Delete Book
    public void deleteBook(int bid) {
        book = book.stream().filter(e -> e.getId() != bid).collect(Collectors.toList());
    }

    // Update Book
    public void updateBook(Book newBook, int bookId) {
        book = book.stream().map(b -> {
            if (b.getId() == bookId) {
                b.setAuthor(newBook.getAuthor());
                b.setTitle(newBook.getTitle());
            }
            return b;
        }).collect(Collectors.toList());
    }
}

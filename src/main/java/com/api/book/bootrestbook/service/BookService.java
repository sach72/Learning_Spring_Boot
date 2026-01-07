package com.api.book.bootrestbook.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;

@Service
public class BookService {
    // private static List<Book> book = new ArrayList<>();
    // private static Book book1;

    // static {
    // book.add(new Book(1, "Amelia Stone", "The Quantum Paradox"));
    // book.add(new Book(2, "Brandon Lee", "Echoes of the Forgotten"));
    // book.add(new Book(3, "Clara Vance", "The Midnight Bloom"));
    // }
    @Autowired
    private BookRepository bookrepository;

    // get all books
    public List<Book> getAllBooks() {
        List<Book> list = (List<Book>) this.bookrepository.findAll();
        return list;
    }

    // get book by id
    public Book getBookById(int id) {
        // book1 = book.stream().filter(e -> e.getId() == id).findFirst().get();
        return bookrepository.findById(id).orElse(null);
    }

    // adding the book
    public Book addBook(Book b) {
        Book result = bookrepository.save(b);
        return result;
    }

    // Delete Book
    public void deleteBook(int bid) {
        // book = book.stream().filter(e -> e.getId() !=
        // bid).collect(Collectors.toList());
        bookrepository.deleteById(bid);
    }

    // Update Book
    public void updateBook(Book newBook, int bookId) {
        // book = book.stream().map(b -> {
        // if (b.getId() == bookId) {
        // b.setAuthor(newBook.getAuthor());
        // b.setTitle(newBook.getTitle());
        // }
        // return b;
        // }).collect(Collectors.toList());
        newBook.setId(bookId);
        bookrepository.save(newBook);
    }
}

package com.xfactor.openlibrary.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xfactor.openlibrary.domain.Book;
import com.xfactor.openlibrary.repositories.BookRepository;

@RestController
@RequestMapping("book")
public class BookController {

    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/allbooks")
    public List<Book> getAllBooks()
    {
        return bookRepository.findAll();
    }

    @PostMapping("/savebook")
    public Book saveBook(@RequestBody Book b)
    {
        return bookRepository.save(b);
    }

    @PutMapping("/updatebook")
    public Book updateBook(@RequestBody Book b)
    {
        if(bookRepository.existsById(b.getId()))
            return bookRepository.save(b);
        else
            return null;

    }

    @GetMapping("/bookbyid/{id}")
    public Book getBookById(@PathVariable Long id)
    {
        Optional<Book> optional = bookRepository.findById(id);
        if(optional.isPresent())
            return optional.get();
        else
            return null;
    }

    @GetMapping("/bookbyisbn/{isbn}")
    public List<Book> getBookByIsbn(@PathVariable String isbn)
    {
        return bookRepository.findByIsbn(isbn);
    }

    @GetMapping("/bookbyauthor/{author}")
    public List<Book> getBookByAuthor(@PathVariable String author)
    {
        return bookRepository.findByAuthor(author);
    }

    @GetMapping("/bookbypublisher/{publisher}")
    public List<Book> getBookByPublisher(@PathVariable String publisher)
    {
        return bookRepository.findByPublisher(publisher);
    }

    @GetMapping("/bookbypublicationdate/{publicationDate}")
    public List<Book> getBookByPublicationDate(@PathVariable String publicationDate)
    {
        return bookRepository.findByPublicationDate(publicationDate);
    }

    @GetMapping("/bookbytitleandisbn/{title}/{isbn}")
    public List<Book> getBookByTitleAndIsbn(@PathVariable String title,@PathVariable String isbn)
    {
        return bookRepository.findByTitleAndIsbn(title,isbn);
    }

    @GetMapping("/bookbypublisherandpublicationdate/{publisher}/{publicationDate}")
    public List<Book> getBookByPublisherAndPublicationDate(@PathVariable String publisher,@PathVariable String publicationDate)
    {
        return bookRepository.findByPublisherAndPublicationDate(publisher,publicationDate);
    }

    @GetMapping("/bookcount")
    public long getBookCount()
    {
        return bookRepository.count();
    }

    @DeleteMapping("/deletebook/{id}")
    public void deleteBookById(@PathVariable Long id)
    {
        if(bookRepository.existsById(id))
            bookRepository.deleteById(id);
    }
}
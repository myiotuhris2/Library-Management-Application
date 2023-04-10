package com.xfactor.openlibrary.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xfactor.openlibrary.domain.Book;

public interface BookRepository extends JpaRepository<Book,Long>{

    List<Book> findByPublisherAndPublicationDate(String publisher,String publicationDate);
    List<Book> findByIsbn(String isbn);
    List<Book> findByAuthor(String author);
    List<Book> findByPublisher(String publisher);
    List<Book> findByPublicationDate(String publicationDate);
    List<Book> findByTitleAndIsbn(String title,String isbn);

}
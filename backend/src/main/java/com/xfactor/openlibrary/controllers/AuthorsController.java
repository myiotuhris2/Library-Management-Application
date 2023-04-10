package com.xfactor.openlibrary.controllers;
import com.xfactor.openlibrary.domain.Author;
import org.springframework.web.bind.annotation.DeleteMapping;
import com.xfactor.openlibrary.domain.Book;
import com.xfactor.openlibrary.repositories.AuthorRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;
@RestController
@RequestMapping("authors")

public class AuthorsController {
    private AuthorRepository authorRepository;
    ArrayList<Author> lAuthors=new ArrayList<>();

    public AuthorsController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @PostMapping("/saveAuthor")
    public Author saveAuthor(@RequestBody Author author){
        if(author.getId()==null){
            Author author2 = authorRepository.save(author);
            return author2;
        }
        return null;
    }
    @GetMapping("/getAllAuth")
    public List<Author> getAllAuth(){
        return authorRepository.findAll();
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Long id) {
        authorRepository.deleteById(id);
    }
}

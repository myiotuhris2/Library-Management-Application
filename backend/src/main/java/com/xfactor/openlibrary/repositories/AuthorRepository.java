package com.xfactor.openlibrary.repositories;
import com.xfactor.openlibrary.domain.Author;

import org.springframework.data.jpa.repository.JpaRepository;
public interface AuthorRepository extends JpaRepository<Author, Long>{
}

package com.xfactor.openlibrary.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xfactor.openlibrary.domain.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher,Long> {

    List<Publisher> findByPhoneAndName(String phone,String name);
    List<Publisher> findByName(String name);
    List<Publisher> findByPhone(String phone);

}

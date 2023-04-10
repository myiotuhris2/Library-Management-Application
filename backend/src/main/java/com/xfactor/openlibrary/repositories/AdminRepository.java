package com.xfactor.openlibrary.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xfactor.openlibrary.domain.Admin;

public interface AdminRepository extends JpaRepository<Admin,Long> {

    List<Admin> findByName(String name);

}

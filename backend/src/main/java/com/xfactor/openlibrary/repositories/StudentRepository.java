package com.xfactor.openlibrary.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xfactor.openlibrary.domain.Student;

public interface StudentRepository extends JpaRepository<Student,Long>{

    List<Student> findByName(String name);
    List<Student> findByDepartment(String department);
    List<Student> findByNameAndBirthDate(String name,String birthDate);

}

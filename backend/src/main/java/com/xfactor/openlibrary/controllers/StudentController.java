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

import com.xfactor.openlibrary.domain.Student;
import com.xfactor.openlibrary.repositories.StudentRepository;

@RestController
@RequestMapping("student")
public class StudentController {

    private StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/allstudents")
    public List<Student> getAllStudents()
    {
        return studentRepository.findAll();
    }

    @PostMapping("/savestudent")
    public Student saveStudent(@RequestBody Student s)
    {
        return studentRepository.save(s);
    }

    @PutMapping("/updatestudent")
    public Student updateStudent(@RequestBody Student s)
    {
        if(studentRepository.existsById(s.getId()))
            return studentRepository.save(s);
        else
            return null;

    }

    @GetMapping("/studentbyid/{id}")
    public Student getStudentById(@PathVariable Long id)
    {
        Optional<Student> optional = studentRepository.findById(id);
        if(optional.isPresent())
            return optional.get();
        else
            return null;
    }

    @GetMapping("/studentbyname/{name}")
    public List<Student> getStudentByName(@PathVariable String name)
    {
        return studentRepository.findByName(name);
    }

    @GetMapping("/studentbydepartment/{department}")
    public List<Student> getStudentByDepatment(@PathVariable String department)
    {
        return studentRepository.findByDepartment(department);
    }

    @GetMapping("/studentbynameandbirthdate/{name}/{birthDate}")
    public List<Student> getStudentByNameAndBirthDate(@PathVariable String name,@PathVariable String birthDate)
    {
        return studentRepository.findByNameAndBirthDate(name,birthDate);
    }

    @GetMapping("/studentcount")
    public long getStudentCount()
    {
        return studentRepository.count();
    }

    @DeleteMapping("/deletestudent/{id}")
    public void deleteStudentById(@PathVariable Long id)
    {
        if(studentRepository.existsById(id))
            studentRepository.deleteById(id);
    }
}
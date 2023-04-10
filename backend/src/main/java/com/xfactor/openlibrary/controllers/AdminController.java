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

import com.xfactor.openlibrary.domain.Admin;
import com.xfactor.openlibrary.repositories.AdminRepository;

@RestController
@RequestMapping("admin")
public class AdminController {

    private AdminRepository adminRepository;
    public AdminController(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @PutMapping("/updateadmin")
    public Admin updateAdmin(@RequestBody Admin admin)
    {
        if (admin.getId() != null) {
            Admin admin2 = adminRepository.save(admin);
            return admin2;
        }
        return null;

    }

    @PostMapping("/saveadmin")
    public Admin saveAdmin(@RequestBody Admin admin)
    {
        return adminRepository.save(admin);
    }

    @GetMapping("/getalladmins")
    public List<Admin> getAllAdmins()
    {
        return adminRepository.findAll();
    }

    @GetMapping("/getadminbyid/{id}")
    public Admin getAdminById(@PathVariable Long id)
    {
        Optional<Admin> optional = adminRepository.findById(id);
        if(optional.isPresent())
            return optional.get();
        else
            return null;
    }

    @GetMapping("/getadminbyname/{name}")
    public List<Admin> getAdminByIsbn(@PathVariable String name)
    {
        return adminRepository.findByName(name);
    }

    @GetMapping("/getadmincount")
    public long getAdminCount()
    {
        return adminRepository.count();
    }

    @DeleteMapping("/deleteAdmin/{id}")
    public void deleteAdminById(@PathVariable Long id)
    {
        if(adminRepository.existsById(id))
            adminRepository.deleteById(id);
    }
}

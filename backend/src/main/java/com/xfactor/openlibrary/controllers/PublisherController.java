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

import com.xfactor.openlibrary.domain.Publisher;
import com.xfactor.openlibrary.repositories.PublisherRepository;

@RestController
@RequestMapping("publisher")
public class PublisherController {

    private PublisherRepository publisherRepository;

    public PublisherController(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @PutMapping("/updatepublisher")
    public Publisher updatePublisher(@RequestBody Publisher publisher)
    {
        if (publisher.getId() != null) {
            Publisher publisher2 = publisherRepository.save(publisher);
            return publisher2;
        }
        return null;

    }

    @PostMapping("/savepublisher")
    public Publisher savePublisher(@RequestBody Publisher publisher)
    {
        return publisherRepository.save(publisher);
    }

    @GetMapping("/getallpublishers")
    public List<Publisher> getAllPublishers()
    {
        return publisherRepository.findAll();
    }

    @GetMapping("/publisherbyid/{id}")
    public Publisher getPublisherById(@PathVariable Long id)
    {
        Optional<Publisher> optional = publisherRepository.findById(id);
        if(optional.isPresent())
            return optional.get();
        else
            return null;
    }

    @GetMapping("/publisherbyname/{name}")
    public List<Publisher> getPublisherByName(@PathVariable String name)
    {
        return publisherRepository.findByName(name);
    }

    @GetMapping("/publisherbyphone/{phone}")
    public List<Publisher> getPublisherByPhone(@PathVariable String phone)
    {
        return publisherRepository.findByPhone(phone);
    }

    @GetMapping("/publisherbyphoneandname/{phone}/{name}")
    public List<Publisher> getPublisherByPhoneandName(@PathVariable String phone,@PathVariable String name)
    {
        return publisherRepository.findByPhoneAndName(phone,name);
    }

    @GetMapping("/publishercount")
    public long getPublisherCount()
    {
        return publisherRepository.count();
    }

    @DeleteMapping("/deletepublisher/{id}")
    public void deletePublisherById(@PathVariable Long id)
    {
        if(publisherRepository.existsById(id))
            publisherRepository.deleteById(id);
    }


}

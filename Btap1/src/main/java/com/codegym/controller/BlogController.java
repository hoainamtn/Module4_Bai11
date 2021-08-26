package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.blog.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/blogs")
public class BlogController {

    @Autowired
    IBlogService blogService;

    @GetMapping
    public Page<Blog> students(@RequestParam(defaultValue = "0") int page) {
        return blogService.findAll(PageRequest.of(page, 2));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> findAllById(@PathVariable Long id) {
        Optional<Blog> customerOptional = blogService.findById(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customerOptional.get(), HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Blog> saveCustomer(@RequestBody Blog blog) {
        return new ResponseEntity<>(blogService.save(blog), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Blog> update(@PathVariable Long id, @RequestBody Blog blog) {
        Optional<Blog> customerOptional = blogService.findById(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        blog.setId(customerOptional.get().getId());
        return new ResponseEntity<>(customerOptional.get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Blog> deleteCustomer(@PathVariable Long id) {
        Optional<Blog> customerOptional = blogService.findById(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blogService.remove(id);
        return new ResponseEntity<>(customerOptional.get(), HttpStatus.NO_CONTENT);
    }
}

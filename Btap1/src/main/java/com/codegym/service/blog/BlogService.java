package com.codegym.service.blog;

import com.codegym.model.Blog;
import com.codegym.repository.IBlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepo iBlogRepo;

    @Override
    public Iterable<Blog> findAll() {
        return iBlogRepo.findAll();
    }

    @Override
    public Optional<Blog> findById(Long id) {
        return iBlogRepo.findById(id);
    }

    @Override
    public Blog save(Blog blog) {
        return iBlogRepo.save(blog);
    }

    @Override
    public void remove(Long id) {
        iBlogRepo.deleteById(id);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return iBlogRepo.findAll(pageable);
    }
}

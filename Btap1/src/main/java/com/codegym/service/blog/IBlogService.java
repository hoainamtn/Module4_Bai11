package com.codegym.service.blog;

import com.codegym.model.Blog;
import com.codegym.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService extends IGeneralService<Blog> {

    public Page<Blog> findAll(Pageable pageable);
}


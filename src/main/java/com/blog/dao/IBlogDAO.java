package com.blog.dao;

import com.blog.model.BlogModel;

import java.util.List;

public interface IBlogDAO extends GenericDAO<BlogModel> {
    List<BlogModel> findAll();
    BlogModel findOne(long id);
    List<BlogModel> findByCategoryId(long categoryId);
    long create(BlogModel blogModel);
    void modify(BlogModel blogModel);
    void delete(long id);
}

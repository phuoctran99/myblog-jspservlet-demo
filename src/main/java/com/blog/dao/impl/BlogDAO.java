package com.blog.dao.impl;

import com.blog.dao.IBlogDAO;
import com.blog.mapper.BlogMapper;
import com.blog.model.BlogModel;
import com.blog.model.CategoryModel;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BlogDAO extends AbstractDAO<BlogModel> implements IBlogDAO {

    @Override
    public List<BlogModel> findAll() {
        String sql = "SELECT * FROM blog";
        return query(sql, new BlogMapper());
    }

    @Override
    public BlogModel findOne(long id) {
        String sql = "SELECT * FROM blog WHERE id = ?";
        List<BlogModel> list = query(sql, new BlogMapper(), id);
        return list.isEmpty()?null:list.get(0);
    }

    @Override
    public List<BlogModel> findByCategoryId(long categoryId) {
        String sql = "SELECT * FROM blog WHERE categoryid = ?";
        return query(sql, new BlogMapper(), categoryId);
    }

    @Override
    public long create(BlogModel blogModel) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO blog(title, thumbnail, shortdescription, content, categoryid,");
        sql.append("createddate, createdby) VALUES(?, ?, ?, ?, ?, ?, ?)");
        return insert(sql.toString(),
                blogModel.getTitle(),
                blogModel.getThumbnail(),
                blogModel.getShortDescription(),
                blogModel.getContent(),
                blogModel.getCategoryId(),
                blogModel.getCreatedDate(),
                blogModel.getCreatedBy());
    }

    @Override
    public void modify(BlogModel blogModel) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE blog SET title = ?, thumbnail = ?, shortdescription = ?,");
        sql.append("content = ?, categoryid = ?, modifieddate = ?, modifiedby = ? WHERE id = ?");
        update(sql.toString(),
                blogModel.getTitle(),
                blogModel.getThumbnail(),
                blogModel.getShortDescription(),
                blogModel.getContent(),
                blogModel.getCategoryId(),
                blogModel.getModifiedDate(),
                blogModel.getModifiedBy(),
                blogModel.getId());
    }

    @Override
    public void delete(long id) {
        String sql = "DELETE FROM blog WHERE id = ?";
        update(sql, id);
    }
}

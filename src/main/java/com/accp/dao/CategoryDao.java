package com.accp.dao;

import com.accp.entity.Category;

import java.util.List;

public interface CategoryDao {
    public List<Category> selectAll();
    public Category fetchById(String username);
    public int add(Category category);
    public void update(Category category);
     public void del(int id);

}

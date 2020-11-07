package com.accp.dao.impl;

import com.accp.dao.CategoryDao;
import com.accp.dao.HidernataUtil;
import com.accp.entity.Category;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;

public class CategoryDaoImpl<main> implements CategoryDao {

    @Override
    public List<Category> selectAll() {
        Session session= HidernataUtil.openSession();
        Query q=session.createQuery("from com.accp.entity.Category");
        List<Category> list=q.list();
        session.close();
        return list;
    }

    @Override
    public Category fetchById(String username) {
        Session sesssion= HidernataUtil.openSession();
        Category c=sesssion.get(Category.class,username);
        sesssion.close();
        return c;
    }

    @Override
    public int add(Category category) {
        Session sess=HidernataUtil.openSession();
        Transaction tx = null;
        try {
            tx = sess.beginTransaction();
            int num= (int) sess.save(category);
            tx.commit();
            return num;
        } catch (RuntimeException e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;            //回滚后继续抛出异常
        } finally {
            sess.close();
        }
    }

    @Override
    public void update(Category category) {
        Session sess=HidernataUtil.openSession();
        Transaction tx = null;
        try {
            tx = sess.beginTransaction();
            sess.update(category);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;            //回滚后继续抛出异常
        } finally {
            sess.close();
        }
    }

    @Override
    public void del(int id) {
        Session sess=HidernataUtil.openSession();
        Transaction tx = null;
        try {
            tx = sess.beginTransaction();

            Category c=new Category();
            c.setId(id);
            sess.delete(c);

            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;            //回滚后继续抛出异常
        } finally {
            sess.close();
        }

    }
    public static void main(String [] args){
        CategoryDao dao=new CategoryDaoImpl();
//        List<Category> list=dao.selectAll();
//        for(Category c:list){
//            System.out.println(c.getName());
//        }
        Category category=new Category();
        category.setName("阿斯顿");
        dao.add(category);

//        dao.del(6);
//        Category category=new Category();
////        category.setId(7);
//        category.setName("牛逼");
//        dao.update(category);



//        List<Category> list=dao.selectAll();
//        for (Category c:list
//             ) {
//            System.out.println(c.getName());
//        }
//        Category c=dao.fetchById(3);
//        System.out.println(c.getName());
//        Category c=new Category();
//        c.setName("血腥3");
//        dao.add(c);
//        System.out.println(c.getId());

    }

}


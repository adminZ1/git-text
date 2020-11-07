package com;

import com.accp.entity.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Demo {
    public static void main(String[] args) {

        Configuration cfg = new Configuration();

        cfg.configure(); // 读取配置文件

        SessionFactory sessionFactory = cfg.buildSessionFactory();// 创建Session工厂

        Session sess = sessionFactory.openSession(); // 打开Session

        Query query = sess.createQuery("from com.accp.entity.Category");// 创建查询对象

        List<Category> list = query.list(); // 执行查询

        for (Category c : list) { // 输出结果

            System.out.println(c.getName());

        }

        sess.close(); // 关闭Session
    }
}

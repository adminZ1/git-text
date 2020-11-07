
package com.accp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HidernataUtil {

    private static SessionFactory sessionFactory;

    //静态块
    static {
        Configuration cfg = new Configuration();
        cfg.configure();
        sessionFactory = cfg.buildSessionFactory();
    }

    public static Session openSession() {
        return sessionFactory.openSession();
    }

}

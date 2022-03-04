package com.example.hibernate.contorller;

import com.example.hibernate.pojo.MyName;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.transaction.Transactional;

public class demo {
    private static SessionFactory sessionFactory;

    public static void main(String[] args) {
        try {
            sessionFactory = new Configuration().configure()
                    .addPackage("com.example.hibernate")
                    .addAnnotatedClass(MyName.class)
                    .buildSessionFactory();
            add("恩零零",39,"295783@126.com");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Integer add(String name,int age,String email){
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Integer count = null;
        try{
            tx = session.beginTransaction();
            MyName myName = new MyName();
            myName.setName(name);
            myName.setAge(age);
            myName.setEmail(email);
            count = (Integer) session.save(myName);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return  count;
    }
}

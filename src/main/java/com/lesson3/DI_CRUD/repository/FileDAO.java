package com.lesson3.DI_CRUD.repository;

import com.lesson3.DI_CRUD.model.File;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.io.IOException;
import java.util.List;


public class FileDAO implements DAO_interface {

    private static SessionFactory  sessionFactory;



    @Override
    public void save(Object object) {
        File file = (File) object;
        file.setFormat("txt");
        try (Session session = createSessionFactory().openSession()) {

            Transaction transaction = session.getTransaction();
            transaction.begin();
            //action
            session.save(file);
            transaction.commit();
            System.out.println("Save File  done ");
            // throw new IOException();
        }  catch (HibernateException e) {
            System.err.println();

            e.printStackTrace();
            System.err.println("!!!!!!!" +
                    "cath worked " + "Save File failed!!!" + e.getMessage());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(long id) {
        try (Session session = createSessionFactory().openSession()) {
            //
            Query query = session.createQuery("delete from  File where id = :Id");
            Transaction transaction = session.getTransaction();
            transaction.begin();
            //action
            query.setParameter("Id", id);
            query.executeUpdate();
            //close session/tr
            transaction.commit();
            throw new IOException();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (HibernateException e) {
            System.err.println("Delete from File failed" + e.getMessage());
        }

    }

    @Override
    public void update(Object object) {
        File fileObj = (File)object;
        //File file = new File();
        try (Session session = createSessionFactory().openSession()) {

            Transaction transaction = session.getTransaction();
            transaction.begin();

            File findItem = (File) findById(fileObj.getId());
            findItem.setName("new_comics");
            findItem.setSize(10);
            //action
            session.update(findItem);
            //close session/tr
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println("Nothing update!" + e.getMessage());
        }
    }


    @Override
    public Object findById(long id) {
       Object objectNew = new Object();
        Object object = new Object();
        try (Session session = createSessionFactory().openSession()) {
            Query query = session.createQuery("from File where id = :Id");
            Transaction transaction = session.getTransaction();
            transaction.begin();
            //action
            query.setParameter("Id", id);
            List list = query.list();

            //close session/tr
            transaction.commit();
            for (Object l : list) {
                objectNew =  l;
            }
            return objectNew;
            //тут  сессия закроется автоматичесски
            //session.close();
        }
    }

    public SessionFactory createSessionFactory() {
        if (sessionFactory == null) {
//Hear we create new sessionFactory
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        return sessionFactory;
    }
}

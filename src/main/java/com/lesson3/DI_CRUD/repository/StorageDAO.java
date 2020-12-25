package com.lesson3.DI_CRUD.repository;

import com.lesson3.DI_CRUD.model.Storage;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import java.io.IOException;
import java.util.List;

public class StorageDAO implements DAO_interface {

    private static SessionFactory sessionFactory;


    @Override
    public Storage read(Object object) {
       Storage storage;
        String data = object.toString();
        Long id = Long.parseLong(data);
        try (Session session = createSessionFactory().openSession()) {
            storage =  session.get(Storage.class, id);
            //action
            //тут  сессия закроется автоматичесски
            //session.close();
            return storage;
        }
    }

    @Override
    public void save(Object object) throws NumberFormatException {
        Storage storage = (Storage) object;
        storage.setStorageCountry("Ukraine");
        try (Session session = createSessionFactory().openSession()) {

            Transaction transaction = session.getTransaction();
            transaction.begin();
            //action
            session.save(storage);
            transaction.commit();
            System.out.println("Save Storage done ");
            // throw new IOException();
        }  catch (HibernateException e) {
            System.err.println();

            e.printStackTrace();
            System.err.println("!!!!!!!" +
                    "cath worked " + "Save Storage failed!!!" + e.getMessage());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(long id) throws HibernateException {
        try (Session session = createSessionFactory().openSession()) {
            //
            Query query = session.createQuery("delete from  Storage where id = :Id");
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
            System.err.println("Delete from Storage failed" + e.getMessage());
        }
    }

    @Override
    public void update(Object object) throws HibernateException {
        Storage storageObj = new Storage();
        try (Session session = createSessionFactory().openSession()) {

            Transaction transaction = session.getTransaction();
            transaction.begin();
// File findItem = (File) findById(fileObj.getId());
            Storage findStorage = (Storage) findById(storageObj.getId());

            findStorage.setFormatSupported("jpg","txt");

            //action
            session.update(findStorage);
            //close session/tr
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println("Nothing update!" + e.getMessage());
        }
    }




    @Override
    public Object findById(long id) {
        Object objectNew = new Object();

        try (Session session = createSessionFactory().openSession()) {
            Query query = session.createQuery("from Storage where id = :Id");
            Transaction transaction = session.getTransaction();
            transaction.begin();
            //action
            query.setParameter("Id", id);
            List list = query.list();

            //close session/tr
            transaction.commit();
            for (Object l : list) {
                objectNew=  l;
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

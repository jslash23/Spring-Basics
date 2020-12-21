package com.lesson3.DI_CRUD.repository;

public interface DAO_interface {
   void  save(Object object);
   void delete(long id);
   void update(Object object);
   public  Object  findById(long id);
}

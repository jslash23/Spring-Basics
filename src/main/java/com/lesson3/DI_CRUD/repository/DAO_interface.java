package com.lesson3.DI_CRUD.repository;

import com.lesson3.DI_CRUD.model.File;

public interface DAO_interface {
   Object read (Object object);
 //  Storage readStorage (Object object);
   void  save(Object object);
   void delete(long id);
   void update(Object object);
   public  Object  findById(long id);
}

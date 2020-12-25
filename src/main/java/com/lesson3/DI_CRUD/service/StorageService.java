package com.lesson3.DI_CRUD.service;

import com.lesson3.DI_CRUD.model.File;
import com.lesson3.DI_CRUD.repository.DAO_interface;
import com.lesson3.DI_CRUD.model.Storage;
import com.lesson3.DI_CRUD.repository.StorageDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class StorageService {

   private final DAO_interface dao_interface;

   @Autowired
    public StorageService(@Qualifier("storageDao") DAO_interface dao_interface) {
        this.dao_interface = dao_interface;
    }

    public Object servRead(String params){
        return dao_interface.read(params);

    }

    public void servSave(Storage storage) {
        Object obj = (Object) storage;
        dao_interface.save(obj);//
    }


    public void servUpdate(long id) {
        dao_interface.update(id);//
    }

    public void servDelete(long idn) {

        dao_interface.delete(idn);//
    }
}

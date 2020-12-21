package com.lesson3.DI_CRUD.service;

import com.lesson3.DI_CRUD.repository.DAO_interface;
import com.lesson3.DI_CRUD.model.Storage;
import com.lesson3.DI_CRUD.repository.StorageDAO;
import org.springframework.beans.factory.annotation.Autowired;

public class StorageService {

    @Autowired
    private DAO_interface dao_interface;
    @Autowired
    public StorageService(DAO_interface dao_interface) {
        this.dao_interface = dao_interface;
    }




    @Autowired
    private StorageDAO storageDAO;

    public StorageService(StorageDAO storageDAO) {
        this.storageDAO = storageDAO;
    }

    @Autowired



    public void servSave(Storage storage) {
        Object obj = (Object) storage;
        storageDAO.save(obj);//
    }


    public void servUpdate(long id) {
        storageDAO.update(id);//
    }

    public void servDelete(long idn) {

        storageDAO.delete(idn);//
    }
}

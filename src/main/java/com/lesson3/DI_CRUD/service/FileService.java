package com.lesson3.DI_CRUD.service;

import com.lesson3.DI_CRUD.repository.DAO_interface;
import com.lesson3.DI_CRUD.model.File;
import com.lesson3.DI_CRUD.repository.FileDAO;
import org.springframework.beans.factory.annotation.Autowired;

public class FileService {

    @Autowired
    private DAO_interface dao_interface;

    public FileService(DAO_interface dao_interface) {
        this.dao_interface = dao_interface;
    }


    @Autowired
    private FileDAO fileDAO;

    @Autowired
    public FileService(FileDAO fileDAO) {
        this.fileDAO = fileDAO;
    }


    public void servSave(File file)  {

        // TODO: 20.12.2020  
       fileDAO.save(file);//

    }

    public void servUpdate(long id) {

      fileDAO.update(id);//
    }

    public void servDelete(long idn)  {

        fileDAO.delete(idn);
    }

}

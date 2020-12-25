package com.lesson3.DI_CRUD.service;

import com.lesson3.DI_CRUD.repository.DAO_interface;
import com.lesson3.DI_CRUD.model.File;
import com.lesson3.DI_CRUD.repository.FileDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class FileService {

    private final DAO_interface dao_interface;

    @Autowired
    public FileService(@Qualifier("fileDao") DAO_interface dao_interface1) {
        this.dao_interface = dao_interface1;
    }


    public Object servRead(String params){
        return dao_interface.read(params);

    }


    public void servSave(File file)  {

        // TODO: 20.12.2020  
       dao_interface.save(file);//

    }

    public void servUpdate(long id) {

      dao_interface.update(id);//
    }

    public void servDelete(long idn)  {

        dao_interface.delete(idn);
    }

}

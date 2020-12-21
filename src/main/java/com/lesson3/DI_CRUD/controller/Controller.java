package com.lesson3.DI_CRUD.controller;

import com.lesson3.DI_CRUD.model.File;
import com.lesson3.DI_CRUD.model.Storage;
import com.lesson3.DI_CRUD.repository.DAO_interface;
import com.lesson3.DI_CRUD.service.FileService;
import com.lesson3.DI_CRUD.service.StorageService;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller {

    @Autowired
   private StorageService storageService;

    @Autowired
    public Controller(StorageService storageService) {
        this.storageService = storageService;
    }

    @Autowired
    private FileService fileService;
@Autowired
    public Controller(FileService fileService) {
        this.fileService = fileService;
    }

    @RequestMapping(method = RequestMethod.POST)
    protected void doPostFile(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        File file = new File();
        //считываем стрим приходящий из Постмана (метод POST)
        //мапим данные Гибернейтом
        //добавляем ай ди и даты
        //сохраняем в БД

        file.setName(req.getParameter("name"));
        file.setFormat(req.getParameter("format"));
        fileService.servSave(file);
        resp.getWriter().println(file);

    }


    //делаем запрос req.getParameter("fileName") вызываем параметр  "fileName"
    // и по имени которое получили делаем обновление  объекта из БД
    @RequestMapping(method = RequestMethod.PUT)
    protected void doPutFile(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        long idServ = Long.parseLong(req.getParameter("id"));
        fileService.servUpdate(idServ);
        resp.getWriter().println(idServ);
    }

    //return "POST OK";


    @RequestMapping(method = RequestMethod.DELETE)
    protected void doDeleteFile(HttpServletRequest req, HttpServletResponse resp) throws HibernateException {

        long idServ = Long.parseLong(req.getParameter("id"));
        fileService.servDelete(idServ);

        //делаем запрос req.getParameter("itemId") вызываем параметр  "itemId"
        // и по айдишнику который получили делаем удаление объекта из БД
    }



    @RequestMapping(method = RequestMethod.POST)
    protected void doPostStorage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Storage storage = new Storage();
        //считываем стрим приходящий из Постмана (метод POST)
        //мапим данные Гибернейтом
        //добавляем ай ди и даты
        //сохраняем в БД

        storage.setStorageCountry(req.getParameter("StorageCountry"));
        resp.getWriter().println(storage);
    }


    //делаем запрос req.getParameter("fileName") вызываем параметр  "fileName"
    // и по имени которое получили делаем обновление  объекта из БД
    @RequestMapping(method = RequestMethod.PUT)
    protected void doPutStorage(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        long idServ = Long.parseLong(req.getParameter("id"));
        storageService.servUpdate(idServ);
        resp.getWriter().println(idServ);
    }

    //return "POST OK";


    @RequestMapping(method = RequestMethod.DELETE)
    protected void doDeleteStorage(HttpServletRequest req, HttpServletResponse resp) throws HibernateException {

        long idServ = Long.parseLong(req.getParameter("id"));
        storageService.servDelete(idServ);

        //делаем запрос req.getParameter("itemId") вызываем параметр  "itemId"
        // и по айдишнику который получили делаем удаление объекта из БД
    }
}

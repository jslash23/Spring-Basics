package com.lesson3.DI_CRUD.controller;

import com.lesson3.DI_CRUD.model.File;
import com.lesson3.DI_CRUD.service.FileService;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@RequestMapping(value = "/test")

public class FileController {
    private final FileService fileService;

    //тут мы указали что бы Спринг нашел бин  класса FileService и этот бин был
    //внедрен в класс Controller

@Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }
//@GetMapping("/read")

    @RequestMapping(method = RequestMethod.GET, value = "/readFile")
    protected void doGetFile(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // метод должен возвращать в окно браузера введенное значение
        String params = req.getParameter("id");
        resp.getWriter().println(fileService.servRead(params));
    }


    @RequestMapping(method = RequestMethod.POST, value = "/saveFile")
    protected void doPostFile(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        File file = new File();
        //считываем стрим приходящий из Постмана (метод POST)
        //мапим данные Гибернейтом
        //добавляем имя и формат
        //сохраняем в БД
        file.setName(req.getParameter("name"));
        file.setFormat(req.getParameter("format"));
        fileService.servSave(file);
        resp.getWriter().println(file);
    }


    //делаем запрос req.getParameter("fileName") вызываем параметр  "fileName"
    // и по имени которое получили делаем обновление  объекта из БД
    @RequestMapping(method = RequestMethod.PUT,value = "/putFile")
    protected void doPutFile(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        long idServ = Long.parseLong(req.getParameter("id"));
        fileService.servUpdate(idServ);
        resp.getWriter().println(idServ);
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteFile")
    protected void doDeleteFile(HttpServletRequest req, HttpServletResponse resp) throws HibernateException {

        long idServ = Long.parseLong(req.getParameter("id"));
        fileService.servDelete(idServ);
        //делаем запрос req.getParameter("fileId") вызываем параметр  "fileId"
        // и по айдишнику который получили делаем удаление объекта из БД
    }
}

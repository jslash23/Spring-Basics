package spring;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
@RequestMapping("/test")

public class ItemController {
    //private static final ItemService itemService = new ItemService();

    @Autowired
    ItemService itemService;
    @Autowired
    Item item;
    @SuppressWarnings({ "null"})

    @RequestMapping(method = RequestMethod.GET)
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // метод должен возвращать в окно браузера введенное значение
        String params = req.getParameter("id");
        resp.getWriter().println(itemService.servRead(params));
    }


    @RequestMapping(method = RequestMethod.POST)
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Item item = new Item();
        //считываем стрим приходящий из Постмана (метод POST)
        //мапим данные Гибернейтом
        //добавляем ай ди и даты
        //сохраняем в БД

        item.setName(req.getParameter("name"));
        item.setDescription(req.getParameter("description"));
        itemService.servSave(item);
        resp.getWriter().println(item);

    }


    //делаем запрос req.getParameter("itemName") вызываем параметр  "itemName"
    // и по имени которое получили делаем обновление  объекта из БД
    @RequestMapping(method = RequestMethod.PUT)
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //Item item = new Item();
        long idServ = Long.parseLong(req.getParameter("id"));
        itemService.servUpdate(idServ);
        resp.getWriter().println(idServ);
    }

    //return "POST OK";


    @RequestMapping(method = RequestMethod.DELETE)
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws HibernateException {

        long idServ = Long.parseLong(req.getParameter("id"));
        itemService.servDelete(idServ);

        //делаем запрос req.getParameter("itemId") вызываем параметр  "itemId"
        // и по айдишнику который получили делаем удаление объекта из БД
    }

    //return "DELETE OK";
}


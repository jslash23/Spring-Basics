package spring;

import org.springframework.beans.factory.annotation.Autowired;

public class ItemService {

    @Autowired
    ItemDAO itemDAO;


    public Item servRead(String id) {

        return itemDAO.daoRead(id);//
    }

    public void servSave(Item item)  {
        itemDAO.daoSave(item);//

    }

    public void servUpdate(long id) {

        itemDAO.daoUpdate(id);//
    }

    public void servDelete(long idn)  {

        itemDAO.daoDelete(idn);//
    }
}

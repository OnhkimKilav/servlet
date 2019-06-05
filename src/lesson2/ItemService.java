package lesson2;



public class ItemService {
    ItemDAO itemDAO = new ItemDAO();

    public Item findById(long id){
        return itemDAO.findById(id);
    }

    public void save(Item item){
        itemDAO.save(item);
    }

    public void update(Item item){
        itemDAO.update(item);
    }

    public void deleate(long id){
        itemDAO.delete(id);
    }

}

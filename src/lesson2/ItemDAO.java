package lesson2;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ItemDAO {

    private static SessionFactory sessionFactory;

    public void save(Item item) {
        Transaction tr = null;

        try(Session session = createSessionFactory().openSession()) {
            //create session/tr
            tr = session.getTransaction();
            tr.begin();

            //action
            session.save(item);

            //close session/tr
            tr.commit();
        } catch (HibernateException e) {
            System.err.println("Save is failed");
            System.out.println(e.getMessage());

            if (tr != null)
                tr.rollback();
        }
        System.out.println("Save is done");
    }

    public void update(Item item) {
        Transaction tr = null;

        try(Session session = createSessionFactory().openSession();) {
            //create session/tr
            tr = session.getTransaction();
            tr.begin();

            //action
            session.update(item);

            //close session/tr
            tr.commit();
        } catch (HibernateException e) {
            System.err.println("Update is failed");
            System.out.println(e.getMessage());

            if (tr != null)
                tr.rollback();
        }
        System.out.println("Update is done");
    }

    public void delete(long itemId) {
        Transaction tr = null;

        try(Session session = createSessionFactory().openSession();) {
            //create session/tr
            tr = session.getTransaction();
            tr.begin();

            //action
            session.delete(itemId);

            //close session/tr
            tr.commit();
        } catch (HibernateException e) {
            System.err.println("Delete is failed");
            System.out.println(e.getMessage());

            if (tr != null)
                tr.rollback();
        }
        System.out.println("Delete is done");
    }

    public Item findById(long id) {
        Transaction tr = null;
        Item item = null;

        try(Session session = createSessionFactory().openSession()) {
            //create session/tr

            tr = session.getTransaction();
            tr.begin();

            //action
            item = session.get(Item.class, id);

            //close session/tr
            tr.commit();
        } catch (HibernateException e) {
            System.err.println("Read is failed");
            System.out.println(e.getMessage());

            if (tr != null)
                tr.rollback();
        }
        System.out.println("Read is done");

        return item;
    }

    public static SessionFactory createSessionFactory() {
        //singleton pattern
        if (sessionFactory == null)
            sessionFactory = new Configuration().configure().buildSessionFactory();
        return sessionFactory;
    }
}

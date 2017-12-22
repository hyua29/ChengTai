package redundant;

import database.data.tables.TotalInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TestIpm {

    @Autowired
    SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public TotalInfo getTotalInfoById(int id){
        TotalInfo totalInfo = null;
        Session session = sessionFactory.openSession();
        //Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            totalInfo = session.get(TotalInfo.class, id);
            session.getTransaction().commit();
        } catch (Exception e){
            System.out.println("something is wrong");
        } finally {
            session.close();
        }

        return totalInfo;

    }
}

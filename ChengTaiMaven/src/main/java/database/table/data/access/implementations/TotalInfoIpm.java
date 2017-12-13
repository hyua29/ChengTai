package database.table.data.access.implementations;

import database.table.classes.TotalInfo;
import database.table.classes.parents.DataClassImp;
import database.table.classes.parents.DataClassInterface;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;

//@Component
public class TotalInfoIpm<T extends DataClassInterface> extends DataClassImp{

    public TotalInfoIpm(String nameOFT) {
        super(nameOFT);
    }

    public TotalInfo getTotalInfoById(int id){
        TotalInfo totalInfo = null;
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            totalInfo = session.get(TotalInfo.class, id);
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            session.close();

        }
        return totalInfo;

    }

    public List<TotalInfo> searchTotalInfo(String cOrPSelect, String ctyOrPod, Date fromThisDate, String sourceHarbor) {
        // pre-condition
        String selection = "";
        if(cOrPSelect.equals("pod"))
            selection = "pod";
        else if(cOrPSelect.equals("country"))
            selection = "country";
        else
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        // get a session
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        List<TotalInfo> searchResultList = null;

        // search TotalInfo base of date range and other attributes specified
        Date now = new Date();
        try{
            Query q = session.createQuery("from TotalInfo where sourceHarbor=:sh" + " " +
                    "and "+ selection + "=:selectionValue" + " " +
                    "and createdAt between :fromDate and :toDate");
            q.setParameter("sh", sourceHarbor);
            q.setParameter("selectionValue", ctyOrPod);
            q.setParameter("fromDate", fromThisDate);
            q.setParameter("toDate", now);
            searchResultList = q.getResultList();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            session.close();
        }

        return searchResultList;

    }

    public Boolean saveTotalInfo(TotalInfo t){

        Session session = factory.getCurrentSession();
        session.beginTransaction();

        Boolean transactionSucceeded = true;
        try {
            session.saveOrUpdate(t);  // save new record or update original one based on ID
            session.getTransaction().commit();
        } catch (Exception e){
            transactionSucceeded = false;
            System.out.println("Must update primary key first ");
        } finally {
            session.close();
        }
        return transactionSucceeded;

    }

}

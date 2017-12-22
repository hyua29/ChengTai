package database.data.access.implementations;

import database.data.access.implementations.parents.DAO;
import database.data.tables.TotalInfo;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Repository
public class TotalInfoIpm extends DAO {


    @Transactional
    public TotalInfo getTotalInfoById(int id){
        TotalInfo totalInfo = null;
        Session session = sessionFactory.getCurrentSession();

        totalInfo = session.get(TotalInfo.class, id);

        return totalInfo;
    }

    @Transactional
    public List<TotalInfo> searchTotalInfo(String cOrPSelect, String ctyOrPod, Date dateFrom, Date dateTo, String sourceHarbor) {
        // pre-condition
        String selection = "";
        if(cOrPSelect.equals("pod"))
            selection = "pod";
        else if(cOrPSelect.equals("country"))
            selection = "country";
        else
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        // get a session
        Session session = sessionFactory.getCurrentSession();
        List<TotalInfo> searchResultList;

        // search TotalInfo base of date range and other attributes specified

            Query q = session.createQuery("from TotalInfo where sourceHarbor=:sh" + " " +
                    "and "+ selection + "=:selectionValue" + " " +
                    "and createdAt between :fromDate and :toDate order by lastModified");
            q.setParameter("sh", sourceHarbor);
            q.setParameter("selectionValue", ctyOrPod);
            q.setParameter("fromDate", dateFrom);
            q.setParameter("toDate", dateTo);
            searchResultList = q.getResultList();
            Collections.reverse(searchResultList);

        return searchResultList;
    }

    @Transactional
    public Boolean saveTotalInfo(TotalInfo t){

        Session session = sessionFactory.getCurrentSession();

        Boolean transactionSucceeded = true;
        try {
            session.saveOrUpdate(t);  // save new record or update original one based on ID
        } catch (Exception e){
            transactionSucceeded = false;
            System.out.println("Must update primary key first ");
        }

        return transactionSucceeded;

    }

    @Transactional
    public Boolean deleteById(int numId) {

        Boolean deleteSucceeded = true;
        // get a session
        Session session = sessionFactory.getCurrentSession();
        try {
            Query query = session.createQuery("delete from TotalInfo where id=:id");
            query.setParameter("id", numId);
            query.executeUpdate();

        } catch (Exception e) {
            deleteSucceeded = false;
        }

        return deleteSucceeded;
    }
}

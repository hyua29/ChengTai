package database.data.access.implementations;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.sun.xml.internal.fastinfoset.algorithm.BooleanEncodingAlgorithm;
import database.data.access.implementations.parents.DAO;
import database.data.tables.SourceHarbor;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class HarborIpm extends DAO {

    @Transactional
    public SourceHarbor getSpecificHarbors(String harborName) {
        Session session = sessionFactory.getCurrentSession();
        SourceHarbor harbor = session.get(SourceHarbor.class, harborName);

        return harbor;

    }

    @Transactional
    public List<SourceHarbor> getAllHarbors() {

        Session session = sessionFactory.getCurrentSession();
        Query q = session.createQuery("from SourceHarbor");
        List<SourceHarbor> sourceHarborList = q.getResultList();

        return sourceHarborList;
    }

    @Transactional
    public Boolean deleteHarborByName(String harborName) {
        Session session = sessionFactory.getCurrentSession();
        Boolean succeeded = true;

        try{
            Query query = session.createQuery("delete from SourceHarbor where sourceHarborName=:harbor");
            query.setParameter("harbor", harborName);
            query.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            succeeded = false;
        }

        return succeeded;
    }

    @Transactional
    public Boolean addHarbor(SourceHarbor sourceHarbor) {
        Boolean succeeded = true;
        Session session = sessionFactory.getCurrentSession();
        try {
            session.saveOrUpdate(sourceHarbor);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            succeeded = false;
        }
        return succeeded;
    }

}

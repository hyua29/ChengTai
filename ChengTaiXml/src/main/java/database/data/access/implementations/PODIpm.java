package database.data.access.implementations;

import database.data.access.implementations.parents.DAO;
import database.data.tables.POD;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class PODIpm extends DAO {

    @Transactional
    public POD getPodByName(String podName) { // get object according to primary key

        Session session = sessionFactory.getCurrentSession();
        POD pod = session.get(POD.class, podName);

        return pod;
    }

    @Transactional
    public List<POD> getAllPods() {
        List<POD> podList;
        Session session = sessionFactory.getCurrentSession();

        Query q = session.createQuery("from POD");
        podList = q.getResultList();

        return podList;
    }


    public Boolean deleteByPODName(String podName) {

        String statement = "delete from POD where pods="+podName;

        Boolean succeeded = runQuery(statement);

        return succeeded;
    }


    public Boolean deleteByCountryName(String countryName) {

        String statement = "delete from POD where pods="+countryName;

        Boolean succeeded = runQuery(statement);

        return succeeded;

    }


}
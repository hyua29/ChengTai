package database.data.access.implementations;

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
}

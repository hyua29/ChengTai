package database.data.access.implementations.parents;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * This is a implementation class that all DAOs should implement
 */
@Component
public abstract class DAO {

    @Autowired
    protected SessionFactory sessionFactory;

    @Transactional
    protected Boolean runQuery(String queryStatement) {
        Boolean runSucceeded = true;

        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery(queryStatement);
        query.executeUpdate();

        return runSucceeded;
    }

}

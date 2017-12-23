package database.data.access.implementations;

import database.data.access.implementations.parents.DAO;
import database.data.tables.Carrier;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CarrierIpm extends DAO {

    @Transactional
    public Carrier getSpecificCarrier(String carrierName) {
        Session session = sessionFactory.getCurrentSession();
        Carrier carrier = session.get(Carrier.class, carrierName);

        return carrier;

    }

    @Transactional
    public List<Carrier> getAllCarriers() {
        Session session = sessionFactory.getCurrentSession();
        Query q = session.createQuery("from Carrier");
        List<Carrier> carrierList  = q.getResultList();

        return carrierList;
    }
}
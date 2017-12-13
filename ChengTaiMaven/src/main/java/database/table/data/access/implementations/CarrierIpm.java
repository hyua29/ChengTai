package database.table.data.access.implementations;

import database.table.classes.Carrier;
import database.table.classes.parents.DataClassImp;
import org.hibernate.Session;

public class CarrierIpm <T extends Carrier> extends DataClassImp {

    public CarrierIpm(String nameOFT) {
        super(nameOFT);
    }

    public Carrier getCarrierFromDatabase(String carrierName) {
        Session session = factory.getCurrentSession();
        Carrier carrier = null;
        try {
            session.beginTransaction();
            carrier = session.get(Carrier.class, carrierName);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return carrier;

    }
}
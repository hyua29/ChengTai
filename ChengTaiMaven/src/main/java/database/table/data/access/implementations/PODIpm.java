package database.table.data.access.implementations;

import database.table.classes.POD;
import database.table.classes.parents.DataClassImp;
import org.hibernate.Session;

//@Component
public class PODIpm<T extends POD> extends DataClassImp{

    public PODIpm(String nameOFT) {
        super(nameOFT);
    }


    public POD getPodFromDatabase(String podName) {
        Session session = factory.getCurrentSession();
        POD pod = null;
        try {
            session.beginTransaction();
            pod = session.get(POD.class, podName);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return pod;

    }

}

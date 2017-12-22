package autowire;

import database.data.tables.Carrier;
import database.data.tables.POD;
import database.data.tables.SourceHarbor;
import database.data.tables.TotalInfo;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryStatic {

    private static SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
            .addAnnotatedClass(TotalInfo.class)
            .addAnnotatedClass(POD.class)
            .addAnnotatedClass(Carrier.class)
            .addAnnotatedClass(SourceHarbor.class)
            .buildSessionFactory();

    public static SessionFactory getFactory() {
        return factory;
    }



}

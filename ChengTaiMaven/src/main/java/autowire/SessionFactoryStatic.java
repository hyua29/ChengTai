package autowire;

import database.table.classes.Carrier;
import database.table.classes.POD;
import database.table.classes.TotalInfo;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryStatic {

    private static SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
            .addAnnotatedClass(TotalInfo.class)
            .addAnnotatedClass(POD.class)
            .addAnnotatedClass(Carrier.class).buildSessionFactory();

    public static SessionFactory getFactory() {
        return factory;
    }



}

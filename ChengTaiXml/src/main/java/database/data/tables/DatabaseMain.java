package database.data.tables;

import database.data.access.services.TotalInfoService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DatabaseMain {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(TotalInfo.class)
                .addAnnotatedClass(POD.class)
                .addAnnotatedClass(Carrier.class)
                .buildSessionFactory();

        // get a session
        Session session = factory.getCurrentSession();

        try {
            // start a transaction
            session.beginTransaction();

            TotalInfo t = new TotalInfoService().getTotalInfoById(28);
            System.out.println("AAAAAAAAA");
            System.out.println(t);
            //List<TotalInfo> totalInfoList = session.createQuery("from TotalInfo t where t.sourceHarbor = 'HuangPu' "
              //    ).getResultList();  // ignore the warning

            //for(TotalInfo t:totalInfoList)
              //  System.out.println(t);
            //TotalInfoIpm imp = new TotalInfoIpm("TotalInfo");

            //List<TotalInfo> t = imp.getTList();
            //System.out.println(t);
            /*
            POD tempPOD = session.get(POD.class, "LAEM CHABANG");
            Carrier tempCarrier = session.get(Carrier.class, "HEUNG-A");

            TotalInfo t = new TotalInfo("danger", 169,
                  123, 34, "THC+DOC FEE", "CTC", "SAT", "MON",
                  "5DAYS", "3");

            tempCarrier.add(t);
            tempPOD.add(t);

            session.save(t);
            */
            session.getTransaction().commit();
            session.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();

        } finally {
            session.close();
            factory.close();
        }
      //  TotalInfoService s = new TotalInfoService();
        //List<TotalInfo> l = s.searchTotalInfo("pod", "BANGKOK", "1", "HuangPu" );
        //System.out.println(l);

    }


}

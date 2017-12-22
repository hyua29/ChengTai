package app;

import com.solidfire.gson.Gson;
import database.data.access.implementations.TotalInfoIpm;
import database.data.tables.POD;
import database.data.tables.TotalInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class DateTest {
    public static void main(String[] args) {
        Gson g = new Gson();
        POD p = new POD();
        p.setCountry("aaa");
        p.setPODName("bbb");

        String podJson = g.toJson(p);

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext(
                        "applicationContext.xml","databaseConfig.xml");
        TotalInfoIpm totalInfoIpm = context.getBean("totalInfoIpm", TotalInfoIpm.class);

        TotalInfo totalInfoToAdd = new TotalInfo("BANGKO","HUANGPU", "COSCO", "CHINA");
        totalInfoIpm.saveTotalInfo(totalInfoToAdd);

    }
}

package app;

import autowire.SessionFactoryStatic;
import database.table.classes.TotalInfo;
import database.table.data.access.implementations.TotalInfoIpm;
import database.table.data.access.services.TotalInfoService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.service.spi.SessionFactoryServiceContributor;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateTest {
    public static void main(String[] args) {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");//dd/MM/yyyy
        Date now = new Date();
        String strDate = sdfDate.format(now);

        TotalInfoIpm totalInfoIpm = new TotalInfoIpm("TotalInfo");
        TotalInfo t = totalInfoIpm.getTotalInfoById(39);

        Calendar c = Calendar.getInstance();
        c.setTime(now);
        c.add(Calendar.DAY_OF_MONTH, -30);
        System.out.println(c.getTime());

        /*
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date fromDate = null;
        Date toDate=null;
        try {
            fromDate = format.parse(c.getTime().toString());
            toDate = format.parse(now.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println(toDate);
        */

        TotalInfoService totalInfoService = new TotalInfoService();

        List<TotalInfo> totalInfoList = totalInfoService.searchTotalInfo("pod", "BANGKOK", c.getTime(), "HUANGPU");
        System.out.println(totalInfoList);
    }
}

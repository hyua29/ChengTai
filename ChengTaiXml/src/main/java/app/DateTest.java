package app;

import com.solidfire.gson.Gson;
import database.data.access.implementations.TotalInfoIpm;
import database.data.tables.POD;
import database.data.tables.TotalInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;


public class DateTest {
    File template =  new File(getClass().getClassLoader().getResource("template.xlsx").getFile());

    public String getName() {
        return template.getName();
    }
}

package app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import test.aop.AccountAOP;
import web.config.aop.AOPConfig;

public class Main {
    public static void main(String[] args) {

        // read the web.config
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AOPConfig.class);
        // get Bean
        AccountAOP accountAOP = context.getBean("accountAOP", AccountAOP.class);
        // call method of the bean
        accountAOP.addAccount("This is a message");

        context.close();

    }
}

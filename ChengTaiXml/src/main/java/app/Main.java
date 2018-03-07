package app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import redundant.TestIpm;
import test.aop.AccountAOP;
import web.config.aop.AOPConfig;

import java.io.File;

public class Main {


    public static void main(String[] args) {
        DateTest dateTest = new DateTest();

        System.out.println(dateTest.getName());


    }
}

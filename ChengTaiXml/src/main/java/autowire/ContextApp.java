package autowire;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContextApp {
    public static void main(String[] args) {

        //ApplicationContext context = new AnnotationConfigApplicationContext(ComponentStudent.class);

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        ComponentStudent componentStudent = context.getBean("componentStudent", ComponentStudent.class);

        System.out.println(componentStudent.getCourse());
    }
}

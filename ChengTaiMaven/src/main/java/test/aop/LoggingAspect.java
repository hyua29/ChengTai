package test.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1) // the order of the aspect to be run; 1 is the highest
public class LoggingAspect {

    // reuse pointcut
    @Pointcut("execution(public void test.aop.AccountAOP.addAccount(..))")  // can use ||/&&/!
    //@Pointcut("execution(public void addAccount())*")  // parameter: " ", "*", ".." -> no arg, one or more, zero or more
    //@Pointcut("execution(* addAccount())*")  // any method called addAccount()
    //@Pointcut("execution(* test.dao.*.*(..))")  // left is return type
    private void addPointCut(){}

    // This method runs before the method specified
    // cut in the execution
    @Before("addPointCut()")
    public void beforeAddAccount(){
        System.out.println("something before add account");
        System.out.println("----------------------");
    }

    @Before("addPointCut()")
    public void accessArgs(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();  // access the args of method specified
        System.out.println("args:");
        for(Object arg:args)
            System.out.println(arg);
        System.out.println("----------------------");
    }

}

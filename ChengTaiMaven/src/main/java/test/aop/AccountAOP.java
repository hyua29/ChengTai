package test.aop;

import org.springframework.stereotype.Component;

@Component
public class AccountAOP {


    public void addAccount(String msg) {

        System.out.println("account is added" + "\n" + msg);
    }
}

package per.lyg.advice;

import org.springframework.stereotype.Component;

@Component
public class MyAdvice {
    public void before() {
        System.out.println("前置通知执行了....");
    }

}

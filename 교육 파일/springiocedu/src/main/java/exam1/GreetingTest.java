package exam1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDateTime;

public class GreetingTest {
    public static void main(String[] args) {
        ApplicationContext factory
                = new ClassPathXmlApplicationContext("exam1.xml");
        LocalDateTime date = (LocalDateTime)factory.getBean("date");

        int hour = date.getHour();
        System.out.println("현재 시간 : " + hour);
        Greeting greeting = (Greeting) factory.getBean("greeting"+hour/6);
        greeting.greet();

        ((ClassPathXmlApplicationContext)factory).close();
    }
}

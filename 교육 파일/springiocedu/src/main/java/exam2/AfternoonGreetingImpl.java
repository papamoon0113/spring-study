package exam2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("greeting2")
public class AfternoonGreetingImpl implements Greeting {
    @Autowired
    @Qualifier("message2")
    private String message;
    public void greet(){
        System.out.println(message);
    }
}

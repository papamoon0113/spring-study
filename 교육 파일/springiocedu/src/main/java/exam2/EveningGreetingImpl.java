package exam2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("greeting3")
public class EveningGreetingImpl implements Greeting {
    @Autowired
    @Qualifier("message3")
    private String message;
    public void greet(){
        System.out.println(message);
    }
}

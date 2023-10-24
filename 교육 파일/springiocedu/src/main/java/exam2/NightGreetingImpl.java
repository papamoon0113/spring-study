package exam2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("greeting0")
public class NightGreetingImpl implements Greeting {
    @Autowired
    @Qualifier("message0")
    private String message;
    public void greet(){
        System.out.println(message);
    }
}

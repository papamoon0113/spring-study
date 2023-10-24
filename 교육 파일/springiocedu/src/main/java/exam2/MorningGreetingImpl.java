package exam2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("greeting1")
public class MorningGreetingImpl implements Greeting {

	@Autowired
	@Qualifier("message1")
	private String message;

	public void greet() {
		System.out.println(message);
	}
}

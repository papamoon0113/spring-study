package exam2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDateTime;
import java.util.Scanner;

public class GreetingTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("exam2.xml");

		int hour = (int) factory.getBean("hourNow");
		System.out.println("현재 시간 : " + hour);
		Greeting greeting = (Greeting) factory.getBean("greeting" + hour / 6);
		greeting.greet();

		System.out.print("시간을 입력하세요 (0~23) : ");
		Scanner scanner = new Scanner(System.in);
		hour = Integer.parseInt(scanner.next());
		greeting = (Greeting) factory.getBean("greeting" + hour / 6);
		greeting.greet();

		scanner.close();
		((ClassPathXmlApplicationContext) factory).close();
	}
}

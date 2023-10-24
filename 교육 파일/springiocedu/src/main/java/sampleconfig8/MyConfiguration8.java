package sampleconfig8;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan("sampleconfig8")
public class MyConfiguration8 {

	@Bean
	@Primary // String 객체가 여러개 라도 이름 안 넣으면 얘가 디폴트로 설정됨. 없으면 에러남
	public String message1() {
		return "스프링 FW";


	}

	@Bean
	public String message2() {
		return "마이바티스 FW";
	}
}

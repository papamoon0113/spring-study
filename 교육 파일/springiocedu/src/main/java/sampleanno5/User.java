package sampleanno5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("myUser")
public class User {
	@Autowired // Autowired가 하나만 있는 경우 bean 중 타입이 맞는 걸 들고와서 넣어준다.
				// 두 개부터는 이름이 같아야 함. 보면 하나 밖에 없어서 이름이 달라도 걍 넣어줌
	private String userName2;

	public User() {
		super();
	}

	public User(String userName) {
		super();
		this.userName2 = userName;
	}

	public String getUserName() {
		return userName2;
	}
}

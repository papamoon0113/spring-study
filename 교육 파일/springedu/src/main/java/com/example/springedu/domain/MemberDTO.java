package com.example.springedu.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MemberDTO {
	private String name = "";
	private String phone = "";
	private String id = "";
	private String password = "";
}

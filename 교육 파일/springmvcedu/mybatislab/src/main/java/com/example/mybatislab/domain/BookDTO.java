package com.example.mybatislab.domain;

import lombok.Data;

@Data
public class BookDTO {
	private int id;
	private String title;
	private int price;
	private String kind;
}

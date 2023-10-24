package com.example.mybatislab.dao;

import com.example.mybatislab.domain.BookDTO;
import com.example.mybatislab.domain.BookResultVO;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BookMapper {
	//전체 도서 리스트 보기 메서드
	@Select("select id, title, price, kind from book;")
	public List<BookDTO> readBook();

	//가격이 높은 순으로 도서 리스트 보기 메서드
	@Select("select id, title, price, kind from book order by price desc;")
	public List<BookDTO> readBookOrderByPrice();

	//가격이 20000원 이상인 도서 리스트 보기 메서드
	@Select("select id, title, price, kind from book where price > #{n};")
	public List<BookDTO> readBookUpper(int n);

	//웹 프로그래밍 도서 리스트 보기 메서드
	@Select("select id, title, price, kind from book where kind = 'b02';")
	public List<BookDTO> readBookOfWebProgramming();

	//데이터베이스와 인프라 도서 리스트 보기 메서드
	@Select("select id, title, price, kind from book where kind = 'b04' or kind = 'b05';")
	public List<BookDTO> readBookOfDataBaseAndInfra();

	//도서명에 '자바'가 포함된 도서 리스트 보기 메서드
	@Select("select id, title, price, kind from book where title like '%자바%';")
	public List<BookDTO> readBookIncludedJava();

	//분류별 도서 가격의 평균 보기 메서드
	@Select("select round(avg(price),1) as 'avgPrice' , kind from book group by kind;")
	public List<BookResultVO> readAveragePriceOfKind();

	//도서 정보 입력 메서드
	@Insert("insert into book (title, price, kind) values (#{title}, #{price}, #{kind})")
	public boolean createBook(BookDTO dto);
}

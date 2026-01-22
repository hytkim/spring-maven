package com.yedam.app.board.service;

import java.util.Date; // yyyy/MM/dd 로 날짜를처리, 

import org.springframework.format.annotation.DateTimeFormat;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Data // 얘가 아래 4개 + 선언한 생성자 없을 경우 NoArgsConstructor까지 총 5개 생성 해줌
	@Getter
	@Setter
	@ToString
	@EqualsAndHashCode
@NoArgsConstructor
public class BoardVO {
	private Integer bno;
	private String  title;
	private String  contents;
	private String  writer;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date    regdate;    // DB에서전달하는 Data는 yyyy-MM-dd 라서 변환이 안 됨
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date    updatedate;
	private String  image;
}
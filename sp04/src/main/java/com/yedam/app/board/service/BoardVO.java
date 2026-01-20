package com.yedam.app.board.service;

import java.util.Date;

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
	private Date    regdate;
	private Date    updatedate;
	private String  image;
}
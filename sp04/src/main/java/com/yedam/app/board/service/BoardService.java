package com.yedam.app.board.service;

import java.util.List;

public interface BoardService {
	// 게시글 전체 조회
	public List<BoardVO> findAll();
	// 게시글 단건 조회
	public BoardVO findByBno(BoardVO boardVO);
	// 게시글 등록
	public int addInfo(BoardVO boardVO);
}

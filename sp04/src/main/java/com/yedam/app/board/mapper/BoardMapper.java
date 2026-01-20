package com.yedam.app.board.mapper;

import java.util.List;
import java.util.Map;

import com.yedam.app.board.service.BoardVO;

public interface BoardMapper {
	// 전체조회
	public abstract List<BoardVO> selectAll();
	// 단건조회
	public abstract BoardVO selectOne(BoardVO boardVO);
	// 등록
	public abstract int insertBoard(BoardVO boardVO);
	// 수정
	public abstract Map<String, Object> updateBoard(BoardVO boardVO);
	// 삭제
	public abstract Map<String, Object> deleteBoard(Integer bno);
}

package com.yedam.app.board.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yedam.app.board.mapper.BoardMapper;
import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor //public BoardServiceImpl(BoardMapper boardMapper) {this.boardMapper = boardMapper;}
public class BoardServiceImpl implements BoardService {
	private final BoardMapper boardMapper;

	// 게시글 전체 조회
	@Override
	public List<BoardVO> findAll() {
		return boardMapper.selectAll();
	}

	@Override
	public BoardVO findByBno(BoardVO boardVO) {
		return boardMapper.selectInfo(boardVO);
	}
	
	@Override
	public int addInfo(BoardVO boardVO) {
		// 단건에대한 처리이므로 반환값이 1일경우만 성공, 성공적으로 selectKey를사용했을경우 매개변수의 필드에 bno값 할당받은값을 결과로써 전달.
		return boardMapper.insertInfo(boardVO) == 1 ? boardVO.getBno() : -1; // 절대 나올 수 없는 값 -1 을 임의의 실패값으로 결과를 전달. 
	}

}

package com.yedam.app.board.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

import lombok.RequiredArgsConstructor;

@Controller // DispatcherServlet(front-controller)에게 정보를 전달
@RequiredArgsConstructor // public BoardController(BoardService boardService){this.boardService = boardService;}
public class BoardController {
	private final BoardService boardService;
	
	// 게시글 전체 조회 기능 제공 - 레스트방식(Model 객체 사용 안함)이 아닌경우에는 기능이 uri 에 있다.
	@GetMapping("boardList") // @GetMapping("boards")
	public String boardList(Model model) {
		// 1) 제공할 서비스
		List<BoardVO> list = boardService.findAll();
		// 2) 페이지에 전달할 데이터
		model.addAttribute("boards", list);
		// 3) 사용할 페이지 prefix suffix
		return "board/list";
	}
}

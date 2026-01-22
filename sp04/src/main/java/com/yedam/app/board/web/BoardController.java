package com.yedam.app.board.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
	
	// 게시글 단건 조회 : 
	@GetMapping("boardInfo") // QueryString(커맨드겍체, @RequestParam)
	public String boardInfo(BoardVO boardVO, Model model) {
//		BoardVO boardVO = BoardVO.builder;
		BoardVO findVO = boardService.findByBno(boardVO);
		model.addAttribute("board", findVO); // model의 addAttribute Name은 '자원'단위로 설정해주기
		return "board/info";
	}
	// 게시글 등록 : 페이지 요청
	@GetMapping("boardInsert")
	public String boardInsertForm() {
		return "board/insert";
	}
	// 게시글 등록 : 처리
	@PostMapping("boardInsert")	// 등록할 때 사용한 데이터의 재사용을 막기위해 [페이지 전환] => <form />을 전재로 하거나 등록된 데이터를 재 사용 못하게 처리를 해야한다.
	// => 지금받으려는것은 게시글에대한 복수의데이터를 객체를기반으로하는 데이터를 받아서 처리해야됨 => <form /> => QueryString => CommandObejct
	public String boardInsertProcess(BoardVO boardVO) {
		int bno = boardService.addInfo(boardVO);
		return "redirect:boardInfo?bno=" + bno;
	}
}

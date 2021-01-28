package board.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.board.dto.BoardDto;
import board.board.service.BoardService;

@Controller // 클래스에 @controller 어노테이션을 적용함으로써 해당 클래스를 컨트롤러로 동작하게 함.
public class BoardController {
	@Autowired
	private BoardService boardService; //비즈니스 로직을 처리하는 Bean을 연결
	
	@RequestMapping("/board/openBoardList.do")

	/*
	 * @RequestMapping어노테이션을 이용하여 요청에 대한 주소를 지정한다. @RequestMapping의 값으로
	 * /board/openBoardList.do가 지정되어 있는데 웹브라우져에서 /board/openBoardList.do라는 주소를 호출하면
	 * 스프링 디스패처는 호출된 주소와 @RequestMapping 어노테이션의 값이 동일한 메서드를 찾아 실행한다. 
	 * 즉, 클라이언트에서 호출한 주소와 그것을 수행하라 메서드를 연결한다.
	 */
	public ModelAndView openBoardList() throws Exception{
		ModelAndView mv = new ModelAndView("/board/boardList");
		
		/*
		 * 호출된 요청의 결과를 보여줄 뷰를 지정한다. 여기서는 /board/boardList로 지정했는데,
		 * 이는 templates 폴더 아래에 있는 board/boardList.html을 의미한다.
		 */
		
		List<BoardDto> list = boardService.selectBoardList();
		/*
		 * 게시글 목록을 조회한다. 이 비즈니스 로직을 수행하기 위해 
		 * BoardService 클래스의 selectBoardList 메서드를 호출한다.
		 * 게시글 목록을 저장하기 위해 List 인터페이스를 사용하였다.
		 */
		
		mv.addObject("list", list);	  
		/* 뷰로 데이터를 전달하기 위해 addObject를 사용했다. 이 때 데이터는 list이다.
		 * 뷰에서는 이 list를 ${list}로 이용할 수 있다. 	
		 *
		 * 실행된 비즈니스 로직의 결과값을 뷰에 list라는 이름으로 저장한다. 
		 * 뷰에서 사용할 경우 List라는 이름으로 조회 결과를 사용할 수 있다.
		 * "list"를 "List'라고 대문자로 썼더니 오류남. 객체와 동일한 이름이여야 하나봄
		 */
		
		return mv; //실행된 비즈니스 로직의 결과를 뷰로 리턴
	}
	

	@RequestMapping("/board/openBoardWrite.do")
	public String openBoardWrite() throws Exception{
		return "/board/boardWrite";
	}
	
	@RequestMapping("/board/insertBoard.do")
	public String insertBoard(BoardDto board) throws Exception{
		boardService.insertBoard(board);
		return "redirect:/board/openBoardList.do";
	}
	
	@RequestMapping("/board/openBoardDetail.do")
	public ModelAndView openBoardDetail(@RequestParam int boardIdx) throws Exception{
		ModelAndView mv = new ModelAndView("/board/boardDetail");
		
		BoardDto board = boardService.selectBoardDetail(boardIdx);
		mv.addObject("board", board);
		
		return mv;
	}
	
	@RequestMapping("/board/updateBoard.do")
	public String updateBoard(BoardDto board) throws Exception{
		boardService.updateBoard(board);
		return "redirect:/board/openBoardList.do";
	}
	
	@RequestMapping("/board/deleteBoard.do")
	public String deleteBoard(int boardIdx) throws Exception{
		boardService.deleteBoard(boardIdx);
		return "redirect:/board/openBoardList.do";
	}
	

}










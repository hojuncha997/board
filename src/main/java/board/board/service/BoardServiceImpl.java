package board.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.board.dto.BoardDto;
import board.board.mapper.BoardMapper;

@Service

/*
 * 비즈니스 로직을 처리하는 서비스 클래스를 나타내는 어노테이션이다. 컨트롤러 클래스에
 * @Controller를 붙이듯 서비스 클래스에서도 @Service를 이용해
 * 해당 클래스가 스프링 MVC의 서비스임을 나타낸다.
 */

public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	
	//DB에 접근하는 DAO Bean을 선언한다. BoardMapper가 먼저 생성되지 않았다면 오류난다. 만들어라.
	
	@Override
	public List<BoardDto> selectBoardList() throws Exception {
		return boardMapper.selectBoardList();
		
		/*
		 * 사용자 요청을 처리하기 위한 비즈니스 로직을 구현한다. 
		 * 여기서는 데이터를 조회하도록 BoardMapper 클래스의
		 * selectBoardList 메서드를 호출한다.
		 */
		
	}
	
	@Override
	public void insertBoard(BoardDto board) throws Exception{
		boardMapper.insertBoard(board);
	}

	@Override
	public BoardDto selectBoardDetail(int boardIdx) throws Exception{
		boardMapper.updateHitCount(boardIdx);
		
		BoardDto board = boardMapper.selectBoardDetail(boardIdx);
		return board;
	}
	
	
	
	
}

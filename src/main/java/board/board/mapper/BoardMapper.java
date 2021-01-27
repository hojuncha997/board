package board.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import board.board.dto.BoardDto;

@Mapper
//마이바티스의 매퍼 인터페이스임을 선언함

public interface BoardMapper {
	List<BoardDto> selectBoardList() throws Exception;
	
	void insertBoard(BoardDto board) throws Exception;
	
	void updateHitCount(int boardIdx) throws Exception;
	
	BoardDto selectBoardDetail(int boardIdx) throws Exception;
	
	/* 인터페이스이기 때문에 메서드의 이름과 반환 형식만 지정함.
	 *  여기서 지정한 메서드의 이름은 SQL의 이름과 동일해야 함.
	 *  마이바티스는 쿼리를 XML에 작성하고 아이디를 이용하여 매핑함.
	 */
	
}





/*
 * Generates getters for all fields, a useful toString method, and hashCode and
 * equals implementations that checkall non-transient fields. Will also generate
 * setters for all non-final fields, as well as a constructor.
 * 
 * Equivalent
 * to @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode
 * 모든 필드의 getter, setter를 생성하고 toString, hashCode, equals 메소드도 생성한다.
 * 단, setter의 경우 final이 선언되지 않은 필드에만 적용된다.
 */

package board.board.dto;

import lombok.Data;

@Data
public class BoardDto {
	
	private int boardIdx;
	
	private String title;
	
	private String contents;
	
	private int hitCnt;
	
	private String creatorId;
	
	private String createdDatetime;
	
	private String updaterId;
	
	private String updatedDatetime;
}
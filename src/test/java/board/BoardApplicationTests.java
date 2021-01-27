package board;

import org.junit.jupiter.api.Test; // = import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith; //import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class BoardApplicationTests {
	@Autowired
	private SqlSessionTemplate SqlSession;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testSqlSession() throws Exception{
		System.out.println(SqlSession.toString());
	}

}

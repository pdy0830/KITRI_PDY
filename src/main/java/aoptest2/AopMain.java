package aoptest2;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopMain {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("aoptest2/aop1.xml");
		
		Member member = factory.getBean("member",Member.class);
		Board board = factory.getBean("board",Board.class);

		member.login("id");
		board.insert(4);
		board.getList();
		member.logout();
	}

}

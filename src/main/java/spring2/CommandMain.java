package spring2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CommandMain {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("spring2/command.xml");
		Command[] array = new Command[3];
		
		array[0]=(Command) factory.getBean("comm1");
		array[1]= factory.getBean("comm2",Command.class);
		array[2]=(Command) factory.getBean("comm3");
		
		for(int i=0; i<array.length; i++) {
			array[i].run();
		}
		//scope="singleton" : 생성자가 호출X, 첫번째에서만 생성자 호출됨
		//scope="prototype" : 생성자가 또 호출O, 매번 생성됨
		Command singleton1 = factory.getBean("comm1",Command.class);
	}
}
//게시판:실행중입니다.
//회원:관리중입니다.
//상품:등록중입니다.

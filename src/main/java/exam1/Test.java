package exam1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("exam1/test.xml");
		
		//////////////////////////////////////////////////////
		String[] names = factory.getBeanDefinitionNames();
		for(String name:names) {
			System.out.println(name); //service dao vo
		}
		//////////////////////////////////////////////////////
		TestService service = factory.getBean("testservice",TestService.class);
		TestVO vo = service.test();
		System.out.println(vo.getMember1()+" : "+vo.getMember2());
	}
}

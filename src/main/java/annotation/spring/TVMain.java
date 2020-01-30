package annotation.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TVMain {

	public static void main(String[] args) {//args[0] 삼성 / 엘지
		//spring factory api 이용
		ApplicationContext factory = new ClassPathXmlApplicationContext("annotation/spring/tvspring.xml");

		String[] names = factory.getBeanDefinitionNames();
		for(String name:names) {
			System.out.println(name);
		}
		
		TV tv =factory.getBean("lgTV",TV.class);
		tv.powerOn(); //TV 기능
		tv.soundDown();
		tv.soundUp();
		tv.powerOff();
		
		tv =factory.getBean("samsungTV",TV.class);
		tv.powerOn(); //TV 기능
		tv.soundDown();
		tv.soundUp();
		tv.powerOff();

	}

}

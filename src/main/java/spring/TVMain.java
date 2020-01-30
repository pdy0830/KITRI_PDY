package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TVMain {

	public static void main(String[] args) {//args[0] 삼성 / 엘지
		//spring factory api 이용
		ApplicationContext factory = new ClassPathXmlApplicationContext("spring/tvspring.xml");

		//<bean id="tv" class="spring.LgTV"/>
		//TV tv = (TV)factory.getBean("tv2");
		TV tv =factory.getBean("tv2",TV.class);
		
		//TVFactory factory = new TVFactory();
		//TV tv = factory.getTV(args[0]);
		tv.powerOn(); //TV 기능
		tv.soundDown();
		tv.soundUp();
		tv.powerOff();

	}

}

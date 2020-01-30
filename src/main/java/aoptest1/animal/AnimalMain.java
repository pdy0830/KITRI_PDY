package aoptest1.animal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnimalMain {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("aoptest1/animal/animal.xml");

		// aoptest1/animal/animal.xml 스프링 빈 설정파일 등록
		/* AnimalCommon클래스 만들어서 aop활용 -> 하단의 출력문장 완성 */
		
		Animal[] animal = new Animal[3];
		animal[0] = factory.getBean("cat",Animal.class); //Cat타입 객체
		animal[1] = factory.getBean("dog",Animal.class); //Dog타입 객체
		animal[2] = factory.getBean("rabbit",Animal.class);//Rabbit타입 객체
		
		for(Animal a:animal) {
			a.lunch();
		}
	}

}
/*
점심 뭐 먹었어요?
생선 먹었습니다.
Cat 님은 생선 먹었군요.
점심 뭐 먹었어요?
사료 먹었습니다.
Dog 님은 생선 먹었군요.
점심 뭐 먹었어요?
당근 먹었습니다.
Rabbit 님은 생선 먹었군요.
*/
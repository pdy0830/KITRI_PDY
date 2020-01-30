package annotation.spring;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Scope("Prototype")
@Repository
public class LgTV implements TV{
	LgTV(){
		System.out.println("LgTV 생성자 호출");
	}
	//전원 켜다
	public void powerOn() {
		System.out.println("엘지TV : 전원켜다");
	}
	//전원끄다
	public void powerOff() {
		System.out.println("엘지TV : 전원끄다");
	}
	//볼륨 높이다
	public void soundUp() {
		System.out.println("엘지TV : 볼륨 높이다");
	}
	//볼륨 낮추다
	public void soundDown() {
		System.out.println("엘지TV : 볼륨 낮추다");
	}
}

package annotation.spring;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
//xml bean 태그 설정말고 @ 설정 이용할거라고 알려줘야함 -> xml파일에서 설정
//@Component
@Repository
public class SamsungTV implements TV{
	//전원 켜다
	public void powerOn() {
		System.out.println("삼성TV : 전원켜다");
	}
	//전원끄다
	public void powerOff() {
		System.out.println("삼성TV : 전원끄다");
	}
	//볼륨 높이다
	public void soundUp() {
		System.out.println("삼성TV : 볼륨 높이다");
	}
	//볼륨 낮추다
	public void soundDown() {
		System.out.println("삼성TV : 볼륨 낮추다");
	}
}

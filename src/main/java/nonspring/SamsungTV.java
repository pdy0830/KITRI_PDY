package nonspring;

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

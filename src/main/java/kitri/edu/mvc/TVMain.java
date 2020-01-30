package kitri.edu.mvc;

public class TVMain {

	public static void main(String[] args) {//삼성 티비
		//삼성TV 구입사용자 - LgTV 구입 => 소스수정많다
		//TV변경하면 같이 변경 코드 발생한다 = coupling(결합도) 높다
		
		//상위인터페이스 변수명 = new 하위클래스객체();
		//TV tv = new SamsungTV();//삼성TV 구입사용자
		//TV tv = new LgTV(); //엘지TV 구입사용자
		
		TVFactory factory = new TVFactory();
		TV tv = factory.getTV(args[0]);
		
		tv.powerOn(); //TV 기능
		tv.soundDown();
		tv.soundUp();
		tv.powerOff();


	}

}

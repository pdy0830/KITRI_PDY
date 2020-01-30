package nonspring;
//static : 멤버변수/메소드 앞 선언 가능, 공유=1개
//			클래스명.i / 클래스명.getInstance()
class Singleton{
	static int i=0; //객체마다 하나의 i를 공유
	static Singleton s; //1.자신의 객체 타입의 변수를 선언:static
	private Singleton(){ //2.생성자:private
		System.out.println(++i + " 번째 생성자 호출합니다.");
	}
	static public Singleton getInstance() { //3.자신객체생성 전용 메소드를 만듦:static
		if(s==null) { //5.처음 s가 null일때만 1번 생성자 호출 => 객체를 하나만 만들 수 있도록
			s=new Singleton(); //객체생성
		} //그 후에 null이 아니면 원래 쓰던걸 쓰자
		return s; //리턴타입을 싱글톤으로
	}
}

public class SingletonTest {

	public static void main(String[] args) {
		Singleton n1 = Singleton.getInstance(); //4.클래스명.getInstanc()
		Singleton n2 = Singleton.getInstance(); //동일한객체
		Singleton n3 = Singleton.getInstance(); //동일한객체
		System.out.println("생성된객체="+n1);
		System.out.println("생성된객체="+n2);
		System.out.println("생성된객체="+n3);
	}

}

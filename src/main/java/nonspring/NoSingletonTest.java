package nonspring;

class NoSingleton{
	//int i=0; //객체마다 각자의 i를 가짐
	static int i=0; //객체마다 하나의 i를 공유
	NoSingleton(){
		System.out.println(++i + " 번째 생성자 호출합니다.");
	}
}

public class NoSingletonTest {

	public static void main(String[] args) {
		NoSingleton n1 = new NoSingleton();
		NoSingleton n2 = new NoSingleton();
		NoSingleton n3 = new NoSingleton();
		System.out.println("생성된객체="+n1);
		System.out.println("생성된객체="+n2);
		System.out.println("생성된객체="+n3);
	}

}

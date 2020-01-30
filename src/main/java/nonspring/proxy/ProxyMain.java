package nonspring.proxy;

public class ProxyMain {

	public static void main(String[] args) {
		ProxyInterface pi = new C();
		B b1 = new B();
		b1.setProxyInterface(pi); //C객체를 전달받음
		b1.action(); //C(핵심관심)+B(공통관심)
	}

}

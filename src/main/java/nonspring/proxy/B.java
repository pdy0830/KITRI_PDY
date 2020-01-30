package nonspring.proxy;

public class B implements ProxyInterface {
	ProxyInterface pi;
	public void setProxyInterface(ProxyInterface pi) {
		this.pi=pi;
	}
	@Override
	public void action() {
		System.out.println("B 클래스의 action() 수행중1");
		pi.action(); //insert sql
		System.out.println("B 클래스의 action() 수행중2");

	}

}

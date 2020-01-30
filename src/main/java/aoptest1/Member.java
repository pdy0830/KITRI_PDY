package aoptest1;

public class Member {
	protected Boolean login(String id) {
		System.out.println(id + "회원님 로그인하셨습니다.");
		return true;
	}
	public Boolean logout() {
		System.out.println("로그아웃하셨습니다.");
		return false;
	}
}

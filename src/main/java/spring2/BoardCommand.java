package spring2;

public class BoardCommand implements Command{
	BoardCommand(){
		System.out.println("<<BoardCommand 생성자 실행>>");
	}
	public void run() {
		System.out.println("게시판:실행중입니다.");
	}
}

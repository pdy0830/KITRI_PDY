package member;

public class MemberVO {
	String id;
	String name;
	
	MemberVO(){}
	//<jsp:useBean id="a" class="MemberVO"
	//<beans:bean id="a" class="MemberVO"
	//@Component
	MemberVO(String id, String name){
		this.id=id;
		this.name=name;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "아이디: "+id+", 이름: "+name;
	}
}

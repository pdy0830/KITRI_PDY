package annotation.springdi;

import org.springframework.stereotype.Component;

//현재 패키지 EmpVO 타입 객체 2개 vo(xml태그),vo2(annotation)
@Component("vo")
public class EmpVO {
	int id;
	String name;
	double salary;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "사번:"+id+", 이름:"+name+", 급여:"+salary;
	}
}

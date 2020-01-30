package mvc;

public class EmpVO {
	int id;
	String name;
	double salary;
	String hiredate;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "사번="+id+", 이름="+name+", 급여"+salary+", 입사일"+hiredate;
	}
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
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	
	
}

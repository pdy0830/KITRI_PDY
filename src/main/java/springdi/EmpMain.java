package springdi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpMain {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("springdi/emp.xml");
		
		//emp.xml 설정 - 스프링팩토리 생성 객체 외부 전달
		//ioc 개념 단어 - 스프링 ioc 구현하기 setter DI 방식 전달
		
		EmpVO vo = factory.getBean("vo",EmpVO.class);
		/* <bean id="vo" class="springdi.EmpVO">		//EmpVO vo = new EmpVO();
		 * 	<property name="id" value="100"/>			//vo.setId(100);
		 * 	<property name="name" value="김사원"/>		//vo.setName("김사원");
		 * 	<property name="salary" value="123000.99"/>	//vo.setSalary(123000.99);
		 * </bean> */
		 
		EmpDAO dao = factory.getBean("dao",EmpDAO.class);
		/* <bean id="dao" class="springdi.EmpDAO">	//EmpDAO dao = new EmpDAO();
		 * 	<property name="vo" ref="vo"/> 			//dao.setVo(vo);//vo객체 생성 - EmpDAO전달
		 * </bean> */
		
		EmpVO resultvo = dao.getVo();
		System.out.println(resultvo); //사번:xxx, 이름:xxx, 급여:xxx
	}

}

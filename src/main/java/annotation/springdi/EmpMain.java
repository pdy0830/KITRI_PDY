package annotation.springdi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpMain {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("annotation/springdi/emp.xml");
		
		//emp.xml 설정 - 스프링팩토리 생성 객체 외부 전달
		//ioc 개념 단어 - 스프링 ioc 구현하기 setter DI 방식 전달
		
		EmpVO vo = factory.getBean("vo",EmpVO.class);
		EmpDAO dao = factory.getBean("dao",EmpDAO.class);
	
		EmpVO resultvo = dao.getVo();
		System.out.println(resultvo); //사번:xxx, 이름:xxx, 급여:xxx
	}

}

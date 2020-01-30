package kitri.edu.mvc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller //<annotaion-driven/> 있어야
public class EmpController  {
	@Autowired
	EmpDAO dao; //<beans:bean 태그 생성 또는 @Component
	// <context:component-scan base-package="kitri.edu.mvc"/> 있어야
	@RequestMapping("/emp.spring")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		//EmpDAO dao = new EmpDAO(); 지역변수->멤버변수:@Autowired
		ArrayList<EmpVO> list = dao.getEmpList();
		ModelAndView mav = new ModelAndView();
		mav.addObject("emp",list);
		//request.setAttribute("name", "글쓰기 화면입니다.");
		mav.setViewName("emplist"); //emplist.jsp
		return mav;
	}
}

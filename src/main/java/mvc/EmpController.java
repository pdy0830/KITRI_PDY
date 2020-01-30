package mvc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class EmpController implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		EmpDAO dao = new EmpDAO();
		ArrayList<EmpVO> list = dao.getEmpList();
		ModelAndView mav = new ModelAndView();
		mav.addObject("emp",list);
		//request.setAttribute("name", "글쓰기 화면입니다.");
		mav.setViewName("emplist"); //emplist.jsp
		return mav;
	}
}

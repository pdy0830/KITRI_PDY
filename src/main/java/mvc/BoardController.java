package mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class BoardController implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("name","글쓰기화면입니다.");
		//request.setAttribute("name", "글쓰기 화면입니다.");
		mav.setViewName("boardwrite");
		return mav;
	}
	
	/*
	 * @Override public String handleRequest(HttpServletRequest request,
	 * HttpServletResponse response) { //모델(뷰 출력 데이터) 알려줌 ("hello message" 문자열)
	 * request.setAttribute("name", "글쓰기 화면입니다.");
	 * 
	 * //view 알려줌 String jspname="boardwrite.jsp"; return jspname; }
	 */
}

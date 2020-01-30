package kitri.edu.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	//@RequestMapping("/loginform")
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView loginform(){
		ModelAndView mav = new ModelAndView();
		//mav.addobject("","");
		mav.setViewName("loginform"); //.jsp
		return mav;
	}
	
	//@RequestMapping("/loginresult")
	/*@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView loginresult(@RequestParam(value="id1",required=false,defaultValue="kitri") String id, String pw){ //test1: id,pw 입력값 읽어와서 구현
	 //id,pw 입력 값 읽어와서 구현 //(HttpServletRequest request 매개변수 타입)
		//String id =request.getParameter("id"); 
		//String pw = request.getParameter("pw");
	 //test2: String 타입 요청파라미터명 동일 이름 매개변수 System.out.println(id+":"+pw);
		ModelAndView mav = new ModelAndView();
		mav.addObject("loginid", id); // Paramvalue가 뭐가 됐든 loginid에 담김
		if (id.equals("hr")) {
			if (pw.equals("hr")) {
				// 정상로그인
				mav.addObject("result", "정상로그인 사용자 입니다.");
			} else { // 암호 맞지 않는 경우
				mav.addObject("result", "암호를 확인하세요.");
			}
		} else { // 아이디가 없는 경우
			mav.addObject("result", "새로 회원가입 하세요.");
		}
		mav.setViewName("loginresult");// forward
		return mav;
	}*/
	
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView loginresult(@ModelAttribute("model") LoginVO vo){
	//test4
		//요청파라미터변수들이름 = 멤버변수들 이름, 모델 저장
		ModelAndView mav = new ModelAndView();
		//3문장과 동일 효과
		 //vo.setId(request.getParameter("id"));
		 //vo.setPw(request.getParameter("pw"));
		 //mav.addObject("model",vo); //model이라는 이름으로 vo변수(id,pw들어있는)전달됨
		
		if(vo.getId().equals("hr")) {
			if(vo.getPw().equals("hr")) {
				//정상로그인
				mav.addObject("result","정상로그인 사용자 입니다.");
			}
			else {
				//암호 맞지 않는 경우
				mav.addObject("result","암호를 확인하세요.");
			}
		}
		else {
			//아이디가 없는 경우
			mav.addObject("result","새로 회원가입 하세요.");
		}
		mav.setViewName("loginresult"); //forward
		return mav;
	}
}

package kitri.edu.mvc;


import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BakeryController {
	
	@Autowired
	BakeryDAO dao;
	
   @RequestMapping(value="/store.bakery", method=RequestMethod.GET)
   public String storeForm() {
	  return "storeform";
		
   }
	@RequestMapping(value="/store.bakery", method=RequestMethod.POST)
	   public ModelAndView storeResult
	   (BakeryVO vo)  throws Exception {
		 //vo 변수명 = 요청파라미터명 동일
		// 자동 베이커리이름, 가격, 수량, 이미지파일 
		//1> BakeryDAO 객체 시킬 것BAKERY 테이블 INSERT
		
		// BakeryDAO dao = new BakeryDAO();
		dao.insertBakery(vo);
		
		String imageuploadpath = 
		"C:/web_workspace/spring1/src/main/webapp/resources/";
		
		String uploadfilename = 
				vo.getBakeryimage().getOriginalFilename();
		
		File real = new File(imageuploadpath + uploadfilename);
		//파일복사 : IOException
		vo.getBakeryimage().transferTo(real);
		
		//3초 일시정지:이미지 업로드 / 리후레쉬 시간 주자
		Thread.sleep(3000);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("model", "상품 등록 완료되었습니다.");
		mav.setViewName("storeresult");
		return mav;
	   }	
}






package kitri.edu.mvc;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AjaxController {
	@RequestMapping(value="/ajax/login",method=RequestMethod.GET)
	public String loginform(){
		return "ajax/loginform";
	}
	
	//ajax 사용
	@RequestMapping(value="/ajax/login",method=RequestMethod.POST,produces ="application/json; charset=utf-8")
	@ResponseBody //의미있는 json형태의 데이터가 된다.
	public String loginResult(String id, String pw){
		//현재요청 뷰 바디 포함 데이터를 json으로 만들어줘야해

		if(id.equalsIgnoreCase("hr") && pw.equalsIgnoreCase("hr")){
			String time = new Date().toLocaleString();
			return "{\"result\":\"ok\", \"logintime\" : \"" +time+ "\"}";
		}
		else {
			return "{\"result\":\"error\", \"logintime\" : \"====\"}";
		}
	}
	
	@RequestMapping(value="/ajax/boardlist")
	@ResponseBody
	public ArrayList<BoardVO> getBoardList() {
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		list.add(new BoardVO(1,"제목1","내용1","kitri","2020-01-17",1111,0));
		list.add(new BoardVO(2,"제목2","내용2","kitri","2020-01-17",1111,0));
		list.add(new BoardVO(3,"제목3","내용3","kitri","2020-01-17",1111,0));
		list.add(new BoardVO(4,"제목4","내용4","kitri","2020-01-17",1111,0));
		list.add(new BoardVO(5,"제목5","내용5","kitri","2020-01-17",1111,0));
		return list;
	}

	@RequestMapping("/ajax/oneboard")
	@ResponseBody
	public BoardVO getOneBoard(int seq){
		System.out.println(seq);
		//게시물리스트 5개에서 찾아서
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		list.add(new BoardVO(1,"제목1","내용1","작성자1","2020-01-17",1111,1));
		list.add(new BoardVO(2,"제목2","내용2","작성자2","2020-01-17",1111,1));
		list.add(new BoardVO(3,"제목3","내용3","작성자3","2020-01-17",1111,1));
		list.add(new BoardVO(4,"제목4","내용4","작성자4","2020-01-17",1111,1));
		list.add(new BoardVO(5,"제목5","내용5","작성자5","2020-01-17",1111,1));

		for(BoardVO vo : list) {
			if(vo.getSeq()==seq) {
				return vo;
			}
		}
		return new BoardVO(6,"제목6","내용6","작성자6","2020-01-17",1111,1);
	}
	
	/* ajax 아닐때 사용
	@RequestMapping(value="/ajax/login",method=RequestMethod.POST)
	public ModelAndView loginResult(String id, String pw){
		//id,pw : hr 입력
		ModelAndView mav = new ModelAndView();
		if(id.equalsIgnoreCase("hr") && pw.equalsIgnoreCase("hr")){
			//정상사용자 -> 아래view에게 줘야해
			mav.addObject("result","정상사용자 입니다.");
			mav.addObject("logintime",new Date().toLocaleString());
		}
		mav.setViewName("ajax/loginresult");
		return mav;
	}*/
}

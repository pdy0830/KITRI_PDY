package member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {
	//회원가입,회원리스트조회,회원정보,회원수정,회원탈퇴
	@RequestMapping("/member/add") //http://localhost:8081/mvc/member/add
	public void addMember() {
		System.out.println("===회원가입 처리중입니다.===");
		//return타입이 void : 모델없고, 뷰이름은 url 동일 이름 결정됨
		//webapp/web-inf/views/member/add.jsp
	}
	@RequestMapping("/member/list")
	public String getMemberList() {
		System.out.println("===회원리스트 처리중입니다.===");
		//return타입이 String : 모델없고, 뷰이름은 member/memberlist.jsp가 되도록 정하고 싶다.
		return "/member/memberlist"; //.jsp
	}
	@RequestMapping("/member/delete")
	public String deleteMember() {
		System.out.println("===회원탈퇴처리 후 회원리스트 출력합니다.===");
		
		// 컨트롤러 메소드 실행은 하지않고 jsp파일(=뷰)로만 이동
		return "/member/memberlist"; //.jsp
		
		// url "/member/list" 매핑 컨트롤러 메소드가 실행됨
		//return "redirect:/member/list";
	}
	@RequestMapping("/member/update") //url
	public ModelAndView updateMember() {
		System.out.println("===회원정보 수정합니다.===");
		ModelAndView mav = new ModelAndView();
		mav.addObject("updateid","수정id");
		mav.setViewName("member/update"); //setViewName있으면 이름대로 url과 다른 이름으로 이동, url과 같은이름으로 이동할거면 생략 가능
		return mav;
	}
	@RequestMapping("/member/get")
	public Model getMember(Model m) {
		m.addAttribute("id","spring");
		m.addAttribute("name","이자바");
		return m;
	}
	@RequestMapping("/member/get2")
	public Map<String,String> getMember2() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id","spring");
		map.put("name","이자바");
		return map;
	}
	///////////////////////이전에는 리턴타입 확인했었다.///////////////////////////
	@ModelAttribute("listmodel")//모델이름
	public ArrayList<MemberVO> getModel(){
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		list.add(new MemberVO("spring","이봄"));
		list.add(new MemberVO("mybatis","박자바"));
		list.add(new MemberVO("java","김자바"));
		list.add(new MemberVO("android","최용권"));
		list.add(new MemberVO("jsp","정용식"));
		return list;
	}
	@ModelAttribute("searchmodel")//모델이름
	public ArrayList<String> getModel2(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("id검색");
		list.add("이름검색");
		list.add("e-mail검색");
		list.add("연락처검색");
		return list;
	}
	
	//@ModelAttribute 메소드 선언 : 공유
	@RequestMapping("/member/list2")
	public void getList2() {
		//모든 Member ArrayList리턴 - 모델
	}
	@RequestMapping("/member/list3")
	public void getList3() {
		//검색 조건 추가 Member ArrayList리턴 - 모델
	}
	@RequestMapping("/member/searchlist")
	public ModelAndView searchlist(@RequestParam("searchitem") String item, String searchword) { //두 방법 가능
		//item id검색 이름검색 에서 검색 떼내기
		item=item.substring(0,item.length()-2);
		ModelAndView mav = new ModelAndView();
		mav.addObject("item", item);
		mav.addObject("word", searchword);
		return mav;
	}
}

package board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	@Autowired
	BoardDAO dao;
	
	@RequestMapping(value="/write.board", method=RequestMethod.GET)
	public ModelAndView writeBoard() {
		ModelAndView mav = new ModelAndView();
		//1.model없다
		//2.insert가 되면 WEB-INF/views/board/writeform.jsp로 가도록
		//(title,contents,writer,password 입력 폼:post -
		// action="/mvc/write.board")
		mav.setViewName("/board/writeform"); //.jsp
		return mav;
	}
		
	@RequestMapping(value="/write.board", method=RequestMethod.POST)
		public ModelAndView writeBoard(BoardVO vo, HttpServletResponse response) throws IOException {
			ModelAndView mav = new ModelAndView();
			//구현
			//1.board.BoardVO : seq,title,contents,writer,time,password,viewcount 변수
			//getter/setter 메소드
			//toString / 생성자 추가정의 선택적
			//2.BoardDAO: writeBoard(BaordVO vo) : board 테이블 insert
			//3.model없다
			//4.insert가 되면 WEB-INF/views/board/list.jsp로 가도록
			int result = dao.writeBoard(vo);
			ArrayList<BoardVO> list = dao.getBoardList();
			if(result==1) {
				mav.addObject("list",list);
				mav.setViewName("/board/list");
			}
			return mav;
	}
	@RequestMapping("/list.board")
	public ModelAndView getBoardList(@ModelAttribute("model") BoardVO vo) {
		ModelAndView mav = new ModelAndView();
		//구현
		//1.BoardDAO: ArrayList<BoardVO> getBoardList() : board테이블 모든 게시물 select
		//3.model : BoardDAO-getBoardList() 리턴결과
		//4.WEB-INF/views/board/list.jsp
		//	번호 <a href="/mvc/detail.board?seq=게시물번호">제목</a>작성자
		ArrayList<BoardVO> list = dao.getBoardList();
		mav.addObject("list",list);
				
		mav.setViewName("/board/list");
		return mav;
	}
	@RequestMapping("/detail.board")
	public ModelAndView getBoardDetail(int seq) {
		ModelAndView mav = new ModelAndView();
		//구현
		//1.BoardDAO: ArrayList<BoardVO> getBoardDetail(int seq) : seq번호 board테이블 1개 게시물 select
		//3.model : BoardDAO-getBoardDetail() 리턴결과
		//4.WEB-INF/views/board/detail.jsp
		// 번호,작성자,....
		BoardDAO dao = new BoardDAO();
		BoardVO vo = dao.getBoardDetail(seq);
		mav.addObject("detail",vo);
				
		mav.setViewName("/board/detail");
		return mav;
	
	}
}

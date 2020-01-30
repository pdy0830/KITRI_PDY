package kitri.edu.mvc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DownloadController {
	@RequestMapping("/downloadform")
	public ModelAndView downloadform() {
		// c:upload 폴더 목록 화면 보여주고 a태그 링크
		ModelAndView mav = new ModelAndView();
		String[] filelist = new File("c:/upload/").list();
		mav.addObject("filelist",filelist);
		mav.setViewName("downloadform");
		return mav;
	}
	@RequestMapping("/downloadresult")
	public void downloadresult(String filename, HttpServletResponse response) throws IOException{
		//1.filename 폴더에서 filename 해당 파일 찾기
		File f = new File("c:/upload",filename);
		//2.다운로드 설정
		response.setContentType("application/download");
		response.setContentLength((int) f.length());
		response.setHeader("Content-Disposition", "attchment;filename=\""+ filename +"\"");
		//3. 위 지정 파일을 클라이언트 응답 내부 스트림 포함
		OutputStream out = response.getOutputStream();
		//4. out형태를 파일의 형태 변경
		FileInputStream fis = new FileInputStream(f);
		//5. 파일 다운로드
		FileCopyUtils.copy(fis, out);
		//6.close
		fis.close();
		out.close();
	}
}

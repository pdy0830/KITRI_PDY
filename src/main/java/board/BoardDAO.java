package board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class BoardDAO {
	public int writeBoard(BoardVO vo) {
		int result = 0;
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection
		("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
		
		String sql = "insert into board values((select max(seq)+1 from board),?,?,?,sysdate,?,0)";
		PreparedStatement pt = con.prepareStatement(sql);
		
		pt.setString(1, vo.getTitle());
		pt.setString(2, vo.getContents());
		pt.setString(3, vo.getWriter());
		pt.setInt(4, vo.getPassword());
		result = pt.executeUpdate();
		
		pt.close();
		con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public ArrayList<BoardVO> getBoardList() {
	      ArrayList<BoardVO> list = new ArrayList<BoardVO>();
	      try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			String sql = "select * from board";
			PreparedStatement pt = con.prepareStatement(sql);
			ResultSet rs = pt.executeQuery();
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setSeq(rs.getInt("seq"));
				vo.setTitle(rs.getString("title"));
	 			vo.setWriter(rs.getString("writer"));
	 			vo.setViewcount(rs.getInt("viewcount"));
	 			list.add(vo);
	 		}
	 		rs.close();
	 		pt.close();
	 		con.close();
	 		} catch(Exception e) {
	 			e.printStackTrace();
	 		}
	 		return list;
	   }
	
	public BoardVO getBoardDetail(int seq){
		BoardVO vo = new BoardVO();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
		//조회수1증가시키기 : update
		String sql2="update board set viewcount=viewcount+1 where seq=?";
		PreparedStatement pt2 = con.prepareStatement(sql2);
		pt2.setInt(1, seq);
		pt2.executeUpdate();
		
		//게시물내용 보이기
		String sql="select * from board where seq=?";
		PreparedStatement pt = con.prepareStatement(sql);
		pt.setInt(1, seq);
		ResultSet rs = pt.executeQuery();
		
		rs.next();
		vo.setSeq(rs.getInt("seq"));
		vo.setTitle(rs.getString("title"));
		vo.setContents(rs.getString("contents"));
		vo.setWriter(rs.getString("writer"));
		vo.setTime(rs.getString("time"));
		vo.setViewcount(rs.getInt("viewcount"));
		vo.setPassword(rs.getInt("Password"));
		System.out.println(vo.getTitle());
		rs.close();
		pt.close();
		con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
}

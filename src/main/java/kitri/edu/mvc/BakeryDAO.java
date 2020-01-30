package kitri.edu.mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

@Repository
public class BakeryDAO {
 
	public void insertBakery(BakeryVO vo) {
		// vo  전달 모든 내용을 bakery insert
		// bakeryid : bakery_seq 시퀀스 이용
		// bakeryname : 이미지 사진 업로드 파일이름 저장
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection
			("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
			
			String sql = 
			"insert into bakery values"
			+"(bakery_seq.nextval, ?, ?, ?, ?)";

			PreparedStatement pt = conn.prepareStatement(sql);
			pt.setString(1, vo.getBakeryname());
			pt.setInt(2, vo.getPrice());
			pt.setInt(3, vo.getBalance());
			pt.setString(4, vo.getBakeryimage().getOriginalFilename());
			int insertRow = pt.executeUpdate();
	
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}
  
}

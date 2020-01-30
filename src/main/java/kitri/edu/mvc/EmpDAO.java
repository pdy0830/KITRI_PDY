package kitri.edu.mvc;

import static java.sql.DriverManager.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class EmpDAO {
	public ArrayList<EmpVO> getEmpList() {
		ArrayList<EmpVO> emp = new ArrayList();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			String sql = "select employee_id, first_name ||','|| last_name as name,"
					+ " salary, to_char(hire_date,'yyyy-mm-dd') as hire_date from employees";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				EmpVO vo = new EmpVO();
				vo.setId(rs.getInt("employee_id"));
				vo.setName(rs.getString("name"));
				vo.setSalary(rs.getInt("salary"));
				vo.setHiredate(rs.getString("hire_date"));
				emp.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}
}
package mybatis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

//직접 db 접근 (1.jdbc ->2.mybatis)
public class EmpDAO {
   SqlSession session;

   public void setSession(SqlSession session) {
      this.session = session;
   }

   public List<EmpVO> getAllEmp() {
	   List<EmpVO> list = session.selectList("emp.allemp");
	   return list;
   }
   
   public EmpVO getOneEmp(int id) {
	   return session.selectOne("emp.oneemp",id);
   
	   /*	emp-mapping.xml
  		<select id="oneemp" resultType="emp" parameterType="int">
  		select * from employees where id=#{b}	*/
   
   }
   
   public List<EmpVO> getManyEmp(int id){
	    return session.selectList("emp.manyemp",id);
	   
	}
   
   public void insertEmp(EmpVO vo) {
	    session.insert("emp.insertemp", vo);
	}
   
   public void updateEmp(EmpVO vo) {
	   session.update("emp.updateemp",vo);
   }
   
   public void deleteEmp(int id) {
	   session.delete("emp.deleteemp",id);
   }
   public void deleteHistory(int id) {
	   session.delete("emp.deletehistory",id);
   }
   public int selectEmpCount() {
	   int i = session.selectOne("emp.empcnt");
	   return i;
	}
   public List<EmpVO> empPaging(int[] param){
	   return session.selectList("emp.emppaging",param); //{41,50}
	
   }

	/*
	 * public List<EmpVO> getEmpDeptid(int[] dept_id){ return
	 * session.selectList("emp.empdeptid",dept_id);
	 * 
	 * }
	 */
   public List<EmpVO> getEmpDeptid(ArrayList<Integer> dept_id){
	   return session.selectList("emp.empdeptid",dept_id);
	
   }
   public List<EmpVO> getEmpDynamicwhere(HashMap<String, String> map){
	   return session.selectList("emp.empdynamic",map);
	
   }
}
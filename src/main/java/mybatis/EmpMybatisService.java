package mybatis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EmpMybatisService implements EmpService {

   EmpDAO dao;

   public void setDao(EmpDAO dao) {
      this.dao = dao;
   }

   @Override
   public List getAllEmp() {
      return dao.getAllEmp();
   }

   @Override
   public EmpVO getOneEmp(int id) {
      return dao.getOneEmp(id);
   }

   @Override
   public List getManyEmp(int id) {
      return dao.getManyEmp(id);
   }
   
   @Override
   public void insertEmp(EmpVO vo) {
      dao.insertEmp(vo);
      
   }

	@Override
	public void updateEmp(EmpVO vo) {
		dao. updateEmp(vo);
	}

	@Override
	public void deleteEmp(int id) {
		dao.deleteHistory(id);
		dao.deleteEmp(id);

	}
	@Override
	   public int selectEmpCount() {
	      return dao.selectEmpCount();
	   }

	@Override
	public List<EmpVO> empPaging(int[] param) {
		List<EmpVO> list = dao.empPaging(param);
		return list;
	}
/*
	@Override
	public List<EmpVO> getEmpDeptid(int[] dept_id) {
		List<EmpVO> list = dao.getEmpDeptid(dept_id);
		return list;
	}*/
	@Override
	public List<EmpVO> getEmpDeptid(ArrayList<Integer> dept_id) {
		List<EmpVO> list = dao.getEmpDeptid(dept_id);
		return list;
	}

	@Override
	public List<EmpVO> getEmpDynamicwhere(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		return dao.getEmpDynamicwhere(map);
	}
	
	
}
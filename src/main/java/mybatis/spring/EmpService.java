package mybatis.spring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

public interface EmpService {
	//모든사원조회서비스
	public List<EmpVO> getAllEmp();
	//특정 사번 사원 1명 조회 서비스
	public EmpVO getOneEmp(int id);
	//특정 사번 사원 여러명 조회 서비스
	public List<EmpVO> getManyEmp(int id);
	//신입사원 등록 서비스
	public void insertEmp(EmpVO vo);
	//사원 정보 변경 서비스
	public void updateEmp(EmpVO vo);
	//사원 퇴사처리 서비스
	public void deleteEmp(int id);
	//총 사원 수 조회 서비스
	public int selectEmpCount();
	//페이징처리 조회 서비스(서비스 상속 하위클래스 "의무" 구현)
	public List<EmpVO> empPaging(int[] param);
	//부서코드 조건조회 서비스
	/* public List<EmpVO> getEmpDeptid(int[] dept_id); */
	public List<EmpVO> getEmpDeptid(ArrayList<Integer> dept_id);
	//동적 컬럼명 변경 조회 서비스
	public List<EmpVO> getEmpDynamicwhere(HashMap<String,String> map);
	//직종코드 조회 서비스
	public List<String> getAllJobs();
}

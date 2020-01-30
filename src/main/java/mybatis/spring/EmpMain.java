package mybatis.spring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class EmpMain {

	public static void main(String[] args) throws Exception {
		// xml 설정사항들 con 생성 공장 부지
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

		// 설정파일 읽어서 con pool 생성
		SqlSessionFactory factory = builder.build(Resources.getResourceAsReader("mybatis/mybatis-config.xml"));

		// jdbc con 1개 생성 = sqlsession
		// connection.getAutoCommit() -->true(기본dml 자동 커밋)
		// connextion.setAutoCommit(false) --> 수동 커밋 변경

		// 기본 연결 : 수동 커밋
		// SqlSession session = factory.openSession();

		// 자동 커밋 변경
		SqlSession session = factory.openSession(true);
		System.out.println(session.getConnection().getAutoCommit());

		// Mybatis db 접근 객체
		EmpDAO dao = new EmpDAO();
		dao.setSession(session);

		// EmpMybatisService 객체한테 시키자
		EmpMybatisService service = new EmpMybatisService();
		service.setDao(dao);

		// List<EmpVO> list = service.getAllEmp(); //EmpDAO : MYBATIS

		//////////////////////////////////////////////
		// test1: 모든레코드 조회
		/*
		 * List<EmpVO> list = session.getAllEmp(); for(EmpVO vo : list) {
		 * 
		 * System.out.println(vo.getEmployee_id() +":" + vo.getLast_name() +":" +
		 * vo.getFirst_name()+":"+vo.getHire_date()+":"+vo.getEmail()+":"+vo.
		 * getDepartment_id());
		 * 
		 * }
		 */

		// test2: 특정레코드조회
		/*
		 * EmpVO vo = service.getOneEmp(100); System.out.println(vo.getEmployee_id()
		 * +":" + vo.getLast_name() +":" +
		 * vo.getFirst_name()+":"+vo.getHire_date()+":"+vo.getEmail()+":"+vo.
		 * getDepartment_id());
		 */

		// test3: 비교연산자<![CDATA[]]>
		/*
		 * List<EmpVO> list = service.getManyEmp(150); for(EmpVO vo : list) {
		 * 
		 * System.out.println(vo.getEmployee_id() +":" + vo.getLast_name() +":" +
		 * vo.getFirst_name()+":"+vo.getHire_date()+":"+vo.getEmail()+":"+vo.
		 * getDepartment_id());
		 * 
		 * }
		 */

		// test4 : insert(resultType 없고 parameterType 있다)
		/*
		EmpVO insertVO = new EmpVO();
		insertVO.setEmployee_id(1000); // pk(중복x, not null)
		insertVO.setLast_name("홍");
		insertVO.setFirst_name("길동"); // not null
		insertVO.setEmail("mybatis@kitri.com"); // unique(중복x)
		// insertVO.setHire_date("2020-01-12");
		insertVO.setJob_id("IT_PROG"); // jobs 테이블 존재하는 데이터 fk
		insertVO.setDepartment_id(50); // departments 테이블에 존재하는 데이터
		service.insertEmp(insertVO);
		System.out.println("=========사원등록완료========");
		*/
		
		//test5: update:
		/*
		EmpVO updateVO = new EmpVO();
		updateVO.setEmployee_id(1000); // pk(중복x, not null)
		//updateVO.setLast_name("김"); // 1000 사원의 '홍'->'김'
		updateVO.setDepartment_id(80); // 1000 사원의 부서 80번으로 변경
		service.updateEmp(updateVO);
		System.out.println("=========사원정보변경완료========");
		*/
		
		//test6: 1000:delete
		/*
		service.deleteEmp(1000);
		System.out.println("=========사원퇴사처리완료========");
		*/
		
		//test7 : 전체 사원수 조회
		int cnt = service.selectEmpCount();
		System.out.println("총 사원수 = " + cnt);
		
		//test8: 1페이지당 10개씩 출력 예정
		/*
		int pagenum = 5; //41-50
		int param[] = new int[2];
		param[0] =(pagenum-1)*10+1; //41
		param[1] = pagenum*10; //50
		List<EmpVO> list = service.empPaging(param);
		for(EmpVO vo:list) {
			System.out.println(vo.getEmployee_id()+":"+vo.getHire_date());
		}
		*/
		
		//test9-1: 부서코드 조건 조회
		/*
		int dept_id[]= {10,50,80};
		List<EmpVO> list = service.getEmpDeptid(dept_id);
		for(EmpVO vo:list) {
			System.out.println(vo.getEmployee_id()+":"+vo.getDepartment_id());
		}
		*/
		
		//test9-2: 부서코드 ArrayList 조건 조회
		/*
		ArrayList<Integer> dept_id= new ArrayList<Integer>();
		dept_id.add(10);
		dept_id.add(50);
		dept_id.add(80);
		List<EmpVO> list = service.getEmpDeptid(dept_id);
		for(EmpVO vo:list) {
			System.out.println(vo.getEmployee_id()+":"+vo.getDepartment_id());
		}
		*/
		
		//test10 : map 전송
		//column 키값 컬럼명 = word 키값
		//where first_name='Steven'
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("column", "first_name");
		map.put("word", "Steven");
		List<EmpVO> list = service.getEmpDynamicwhere(map);
		for(EmpVO vo:list) {
			System.out.println(vo.getFirst_name()+":"+vo.getLast_name());
		}
		
	}
}
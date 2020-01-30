package annotation.springdi;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

//<bean id="dao" class=... />
@Repository("dao")
public class EmpDAO {
	//1.EmpVO 타입 객체 생성되어있다면, 1개라면 이름 무고나하게 자동 연결
	//2.생성 객체가 여러개 있다면 이름동일하면 자동setter
	//3.@Qualifier("vo2") 같이 정의 -> EmpVO, vo2 자동 연결
	
	//@Autowired //spring에서 제공
	//@Qualifier("vo2") //spring에서 제공, @Autowired 없이 사용할 수 X
	@Resource(name="vo2") //자바에서 제공 위에 두개 대신에 하나로 쓸 수 있음
	EmpVO vo;

	public EmpVO getVo() {
		return vo;
	}	
}

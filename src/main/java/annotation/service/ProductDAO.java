package annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("dao")
public class ProductDAO {
	//<property name="vo" ref="vo"/>
	//ProductVO 타입 생성 bean 있으면 자동 전달
	@Autowired
	@Qualifier("vo1")//타입이 중복되는 게 2개 이상일때 사용(지금은 안써도됨)
	
	ProductVO vo;
	
	//setter 부분 없어도됨
	
	public ProductVO getVo() {
		return vo;
	}	
	//12월 서비스객체 : sell(0.5,1)
	//5월 서비스객체 : sell(0.3,3)
	//다른월 서비스객체 : sell(0.0,5)
	public ProductVO sell(double sale, int coupon){
		vo.setSale(sale);
		vo.setCoupon(coupon);
		return vo;
	}
}

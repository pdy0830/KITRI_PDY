package service;

public class ProductDAO {
	ProductVO vo;
	
	public void setVo(ProductVO vo) {
		this.vo = vo;
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

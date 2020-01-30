package service;

public class ProductServiceGeneral implements ProductService{
	ProductDAO dao;
	//12월 서비스객체 : sell(0.5,1)
	
	public void setDao(ProductDAO dao) {
		this.dao = dao;
	}
	@Override
	public ProductVO sell() {
		return dao.sell(0.0,5);
	}
}

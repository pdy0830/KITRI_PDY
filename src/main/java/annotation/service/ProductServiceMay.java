package annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("service3")
public class ProductServiceMay implements ProductService{
	@Autowired
	// @Repository("dao")
	ProductDAO dao;
	
	//setter 메소드 없어도됨
	@Override
	public ProductVO sell() {
		return dao.sell(0.3,3);
	}
}

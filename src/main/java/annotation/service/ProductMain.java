package annotation.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.ProductService;
import service.ProductVO;

public class ProductMain {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("service/product.xml");
		//ProductServiceGeneral, ProductServiceDec, ProductServiceMay
		//ProductDAO, ProductVO
		
		ProductService service1=factory.getBean("service1",ProductService.class);
		ProductService service2=factory.getBean("service2",ProductService.class);
		ProductService service3=factory.getBean("service3",ProductService.class);
		System.out.println("===노세일기간===");
		ProductVO result1 = service1.sell();
		System.out.println(result1);
		System.out.println("=============");
		
		System.out.println("===12월세일기간===");
		ProductVO result2 = service2.sell();
		System.out.println(result2);
		System.out.println("=============");
		
		System.out.println("===5월세일기간===");
		ProductVO result3 = service3.sell();
		System.out.println(result3);
		System.out.println("=============");
	}
}

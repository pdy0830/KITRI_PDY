package mybatis.bakery;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

public class BakeryMain {

	public static void main(String[] args) throws IOException {
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		
		SqlSessionFactory factory = builder.build(Resources.getResourceAsReader("mybatis/bakery/config.xml"));
		//mybatis-config.xml 수정
		
		SqlSession session = factory.openSession(true);
		
		BakeryDAO dao = new BakeryDAO();
		dao.setSession(session);
		
		BakeryService service = new BakeryServiceImpl();
		((BakeryServiceImpl)service).setDao(dao);
		
		//1. bakeryid : bakery_seq.nexval
		//2. bakeryname,price,balance,bakeryimage:
		//명령행 매개변수 입력
		// run-run configurations-arguments-program arguments
		// 소보로빵 1500 100 bbang1.jsp
		//bakery 테이블 insert(5번)
		
		BakeryVO vo = new BakeryVO(args[0],
								Integer.parseInt(args[1]),
								Integer.parseInt(args[2]),
								args[3]);
		
		service.registerBakery(vo);
		//bakery 테이블 select : 콘솔출력
		
		//db: 1> mybatis 이용(2개 xml: 
		//		mybatis/bakery/config.xml(mybatis설정정의) , mybatis/bakery/bakery-mapping.xml(sql정의))
		//	  2> mybatis구현 : BakeryDAO
		
		List<BakeryVO> list = service.getBakery();
		for(BakeryVO vo2 : list) {
			System.out.println(vo2.getBakeryid());
			System.out.println(vo2.getBakeryname());
			System.out.println(vo2.getPrice());
			System.out.println(vo2.getBalance());
			System.out.println(vo2.getBakeryimage());
		}
	}

}

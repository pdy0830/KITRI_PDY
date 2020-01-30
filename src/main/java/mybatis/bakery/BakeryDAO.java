package mybatis.bakery;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class BakeryDAO {
	SqlSession session;

	public void setSession(SqlSession session) {
		this.session = session;
	}
	public void insertBakery(BakeryVO vo) {
		session.insert("bakery.insertbakery",vo);
	}
	public List<BakeryVO> selectBakery(BakeryVO vo) {
		List<BakeryVO> list = session.selectList("bakery.bakerylist");
		return list;
	}
	
}

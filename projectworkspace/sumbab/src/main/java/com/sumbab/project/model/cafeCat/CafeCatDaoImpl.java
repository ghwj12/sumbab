package store.cafeCat;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CafeCatDaoImpl implements CafeCatDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Autowired
	public CafeCatDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public void insert(CafeCat cafeCat) {
		sqlSessionTemplate.insert("insertCafeCat", cafeCat);
	}

	@Override
	public void update(CafeCat cafeCat) {
		sqlSessionTemplate.update("updateCafeCat", cafeCat);
	}

	

}

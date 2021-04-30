package store;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StoreDaoImpl implements StoreDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Autowired
	public StoreDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	// =========기본 CRUD 기능================
	@Override
	public void insert(Store store) {
		sqlSessionTemplate.insert("insertStore", store);
	}

	@Override
	public void update(Store store) {
		sqlSessionTemplate.update("updateStore", store);
	}

	@Override
	public void delete(Store store) {
		sqlSessionTemplate.delete("deleteStore", store);
	}

	@Override // 숨밥 시작하기 : 카테고리 검색-식당
	public List<Store> selectByRestCat(String category) {
		List<Store> results = sqlSessionTemplate.selectList("selectByRestCat", category);
		return results;
	}

	@Override // 숨밥 시작하기 : 카테고리 검색-식당
	public List<Store> selectByCafeCat(String category) {
		List<Store> results = sqlSessionTemplate.selectList("selectByCafeCat", category);
		return results;
	}
}

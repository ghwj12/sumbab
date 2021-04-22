package store;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import store.restCat.RestCat;

@Repository
public class StoreDaoImpl implements StoreDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Autowired
	public StoreDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	//=========기본 crud 기능================
	@Override
	public void insert(Store store) {
		sqlSessionTemplate.insert("insert", store);
	}

	@Override
	public void update(Store store) {
		sqlSessionTemplate.update("update", store);
	}

	@Override
	public void delete(Store store) {
		sqlSessionTemplate.delete("delete",store);
	}
	
	//========검색 관련 기능 ====================
	@Override //일반검색
	public List<Store> selectByKeyword(String keyword) {
		List<Store> results = sqlSessionTemplate.selectList("selectByKeyword", keyword);
		return results;
	}

	@Override //특정 해시태그 가진 식당 검색
	public List<Store> selectByTag(String tag) {
		List<Store> results = sqlSessionTemplate.selectList("selectByTag", tag);
		return results;
	}

	@Override //숨밥 시작하기 : 카테고리 검색-식당
	public List<Store> selectByRestCat(String category) {
		List<Store> results = sqlSessionTemplate.selectList("selectByRestCat", category);
		return results;
	}

}

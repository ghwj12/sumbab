package store.search;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import store.Store;

@Repository
public class SearchDaoImpl implements SearchDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Autowired
	public SearchDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public List<Store> search(String input) {
		return sqlSessionTemplate.selectList("selectByKeyword", input);
	}

/*	// ========검색 관련 기능 ====================
	@Override // 일반검색
	public List<Store> selectByKeyword(String input) {
		List<Store> results = sqlSessionTemplate.selectList("selectByKeyword", input);
		return results;
	}

	@Override // 특정 해시태그 가진 식당 검색
	public List<Store> selectByTag(String tag) {
		List<Store> results = sqlSessionTemplate.selectList("selectByTag", tag);
		return results;
	}*/
}

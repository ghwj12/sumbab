package store;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import store.restCat.RestCat;

@Repository
public class StoreDaoImpl implements StoreDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate; //이거 선언이 없네요 DB연동 빈이 등록되어 있지않습니다.

	//Component-scan 
	//@Component, @Controller, @Service, @Repository
	//@Autowired, @Resource (X사용할일 거의 없습니다), @Inject 
	
	@Autowired
	public StoreDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	@Override
	public void insert(Store store) {
		sqlSessionTemplate.insert("insert", store);
	}

	@Override
	public void update(Store store) {
		sqlSessionTemplate.update("update", store);
	}

	@Override
	public List<Store> selectByKeyword(String keyword) {
		List<Store> results = sqlSessionTemplate.selectList("selectByKeyword", keyword);
		return results;
	}

	@Override
	public List<Store> selectByTag(String tag) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Store> selectNearby(Store store) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Store> selectByEditor(int editorNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Store store) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Store> selectByRestCat(RestCat restCat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Store selectByName(String storeName) {
		List<Store> result = sqlSessionTemplate.selectOne("selectByName", storeName);
		return result.isEmpty() ? null : result.get(0);
	}

}

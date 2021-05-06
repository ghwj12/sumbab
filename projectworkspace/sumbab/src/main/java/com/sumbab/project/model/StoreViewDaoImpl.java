package com.sumbab.project.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StoreViewDaoImpl implements StoreViewDao {

	private SqlSession sqlSession;

	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<StoreVo> selectAll() {
		return sqlSession.selectList("selectAll");
	}

	@Override
	public StoreVo selectOne(int storeNum) {
		return sqlSession.selectOne("selectOne", storeNum);
	}

	@Override
	public List<Map<String, Object>> nearbyCafe(int storeNum) {
		return sqlSession.selectList("nearbycafe", storeNum);
	}

	@Override
	public List<Map<String, Object>> nearbyRestaurant(int storeNum) {
		return sqlSession.selectList("nearbyrestaurant", storeNum);
	}

//==============================================================================

	@Override
	public List<Map<String, Object>> selectReviews(int storeNum, int page_num) {
		System.out.println(storeNum);

		Map<String, Integer> map = new HashMap<>();

		int startNum = (page_num - 1) * 3 + 1;
		int endNum = page_num * 3;
	
		map.put("storeNum", storeNum);
		map.put("startNum", startNum);
		map.put("endNum", endNum);

		return sqlSession.selectList("selectReviews", map);
	}

	@Override
	public List<Map<String, Object>> selectReviewsPaging(int storeNum, int page_num) {
		System.out.println(storeNum);
		Map<String, Integer> map = new HashMap<>();
		int startNum = (page_num - 1) * 3 + 1;
		int endNum = page_num * 3;
		System.out.printf("startNum=%d, endNum=%d\n", startNum, endNum);
		map.put("storeNum", storeNum);
		map.put("startNum", startNum);
		map.put("endNum", endNum);

		return sqlSession.selectList("selectReviewsPaging", map);
	}

	@Override
	public int getReviewCount(int storeNum) {
		return sqlSession.selectOne("reviewCount", storeNum);
	}
//=========================================================================
	@Override
	public List<StoreVo> selectAllAddress() {
		return sqlSession.selectList("selectAllAddress");
	}

	@Override
	public void upReadCount(int storeNum) {
		 sqlSession.update("upReadCount", storeNum);
		
	}

	@Override
	public float getAvgStar(int storeNum) {
		return 	sqlSession.selectOne("getAvgStar", storeNum);
	}

	@Override
	public float getAvgRevisit(int storeNum) {
		return sqlSession.selectOne("getAvgRevisit", storeNum);
	}


}

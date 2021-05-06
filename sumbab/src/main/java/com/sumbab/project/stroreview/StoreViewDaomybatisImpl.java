package com.sumbab.project.stroreview;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StoreViewDaomybatisImpl implements StoreViewDao {

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
	public StoreVo selectOne(int store_num) {
		return sqlSession.selectOne("selectOne", store_num);
	}

	@Override
	public List<Map<String, Object>> nearbyCafe(int store_num) {
		return sqlSession.selectList("nearbycafe", store_num);
	}

	@Override
	public List<Map<String, Object>> nearbyRestaurant(int store_num) {
		return sqlSession.selectList("nearbyrestaurant", store_num);
	}

//==============================================================================

	@Override
	public List<Map<String, Object>> selectReviews(int store_num, int page_num) {
		System.out.println("리뷰 셀렉 실행확인");
		System.out.println(store_num);

		Map<String, Integer> map = new HashMap<>();
		//기본페이징기법....게시물수 조정하고 싶으면 이부분을 건드리도록.....
		//결론적으로 1페이지당 5개의 개시물 만약 추가 게시물이 6개면 페이지넘은2가되는....
		//리뷰에 사진 첨부되는거 감안했을때 그냥 3개씩 보이는게깔끔할것같아서 수정함 
		int startNum = (page_num - 1) * 3 + 1;
		int endNum = page_num * 3;
			//추후에 결정될 page_num에따라 달라지는 startNum과 endNum	
		map.put("store_num", store_num);
		map.put("startNum", startNum);
		map.put("endNum", endNum);

		return sqlSession.selectList("selectReviews", map);
	}

	@Override
	public List<Map<String, Object>> selectReviewsPaging(int store_num, int page_num) {
		System.out.println("리뷰 셀렉 실행확인");
		System.out.println(store_num);
		Map<String, Integer> map = new HashMap<>();
		int startNum = (page_num - 1) * 3 + 1;
		int endNum = page_num * 3;
		System.out.printf("startNum=%d, endNum=%d\n", startNum, endNum);
		map.put("store_num", store_num);
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
//조회수증가
	@Override
	public void upReadCount(int store_num) {
		 sqlSession.update("upReadCount", store_num);
		
	}
//리뷰상세사항에 들어갈내용
	@Override
	public float getAvgStar(int store_num) {
		return 	sqlSession.selectOne("getAvgStar", store_num);
	}

	@Override
	public float getAvgRevisit(int store_num) {
		return sqlSession.selectOne("getAvgRevisit", store_num);
	}


}

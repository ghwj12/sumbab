package com.sumbab.sumbab.model.notice;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sumbab.sumbab.model.review.Review;

@Repository
public class NoticeDaoImpl implements NoticeDao{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public int selectClassify(String id) {
		return sqlSessionTemplate.selectOne("selectClassify", id);
	}

	@Override
	public List<Notice> selectNotice(String id) {
		return sqlSessionTemplate.selectList("selectNotice", id);
	}

	@Override
	public List<Notice> allNotice() {
		return sqlSessionTemplate.selectList("allNotice");
	}

	@Override
	public Notice noticeDetail(int noticeNum) {
		return (Notice)sqlSessionTemplate.selectOne("noticeDetail", noticeNum);
	}

	@Override
	public void insert(Notice notice) {
		sqlSessionTemplate.insert("insertNotice", notice);
	}
	
	@Override
	public void fromWarning(Notice notice) {
		sqlSessionTemplate.insert("insertWithRN", notice);	//RN:ReviewNum
	}

	@Override
	public void update(Notice notice) {
		sqlSessionTemplate.update("updateNotice", notice);	
	}

	@Override
	public void delete(int noticeNum) {
		sqlSessionTemplate.update("deleteNotice", noticeNum);
	}

	@Override
	public Review selectReview(int reviewNum) {
		return sqlSessionTemplate.selectOne("selectReview", reviewNum);
	}
	
	

}

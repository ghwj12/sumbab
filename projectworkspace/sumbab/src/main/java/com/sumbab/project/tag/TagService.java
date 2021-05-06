package com.sumbab.project.tag;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagService {

	public TagService() {}
	
	private TagDao tagDao;
	
	@Autowired
	public TagService(TagDao tagDao) {
		this.tagDao = tagDao;
	}
	
	public List<Tag> selectTagByStore(int storeNum){
		return tagDao.selectTagByStore(storeNum);
	}
		
	public List<String> selectTagByReview(int reviewNum){
		return tagDao.selectTagByReview(reviewNum);
	}
	
	public Map<Integer, List<String>> selectTagEachReview(int storeNum){
		List<Integer> reviewNumList = tagDao.selectReviewNumList(storeNum); //숫자 리스트
		Map<Integer, List<String>> eachTagList = new HashMap<Integer, List<String>>();//번호,배열 담을 해시맵
		
		for (int i = 0; i < reviewNumList.size(); i++) {
			List<String> eachTagOnReview = tagDao.selectTagByReview(reviewNumList.get(i));
			eachTagList.put(reviewNumList.get(i), eachTagOnReview);
		}
		return eachTagList;
	}

}

package com.sumbab.sumbab.model.tag;

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
	
	public void regist(String tagName) {
		
		int check = tagDao.check(tagName);
		Tag newTag = new Tag();
		
		if(check==0) {
		newTag.setTagName(tagName);
		tagDao.insert(newTag);
		}else {
			tagDao.update(tagName);
		}
	}
	
	public List<Tag> selectTagByStore(int storeNum){
		return tagDao.selectTagByStore(storeNum);
	}
	
	public List<String> selectTagByReview(int reviewNum){
		return tagDao.selectTagByReview(reviewNum);
	}
	
	public List<Integer> selectReviewNumList(int storeNum){
		return tagDao.selectReviewNumList(storeNum);
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
	
	//중간테이블 insert Dao
	public void insertReview_Tag(String tagName) {
		int check = tagDao.check(tagName);
		
		if(check==0) {
			tagDao.insertReview_Tag();
		}else {
			int tagId = tagDao.getTagIDbyName(tagName);
			tagDao.insertReview_Tags(tagId);
		}
	}
	
	public void insertStore_Tag(int storeNum, String tagName) {
		int check = tagDao.check(tagName);
		
		if(check==0) {
			tagDao.insertStore_Tag(storeNum);
		}else {
			Map<String, Integer> sequences = new HashMap<>();
			sequences.put("storeNum", storeNum);
			int tagId = tagDao.getTagIDbyName(tagName);
			sequences.put("tagId", tagId);
			
			tagDao.insertStore_Tags(sequences);
		}
	}
}

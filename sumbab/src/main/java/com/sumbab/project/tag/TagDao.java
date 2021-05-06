package com.sumbab.project.tag;

import java.util.List;

public interface TagDao {
	

	
	public List<Tag> selectTagByStore(int storeNum);
	public List<String> selectTagByReview(int reviewNum);
	public List<Integer> selectReviewNumList(int storeNum);
	

	
}

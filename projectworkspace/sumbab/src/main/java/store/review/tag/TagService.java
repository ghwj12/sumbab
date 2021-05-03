package store.review.tag;

import java.util.HashMap;
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

package store.review.tag;

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
	
	public void insertReview_Tag() {
		tagDao.insertReview_Tag();
	}
	
	public void insertStore_Tag(int storeNum) {
		tagDao.insertStore_Tag(storeNum);
	}
}

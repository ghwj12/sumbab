package store.review.tag;

import java.util.List;

public interface TagDao {
	
	public void insert(Tag tag);
	//같은 태그 입력했을 때 count 올리는 update
	public void update(String tagName);
	public void delete(int reviewNum);
	public int check(String tagName);
	//작성된 태그는 수정(update)이 없다.
	//리뷰에 작성된 태그 수정--> 태그를 삭제 하거나 새로운 태그를 추가하는 개념이기 때문.
	
	public List<Tag> selectTagByStore(int storeNum);
	public List<Tag> selectTagByReview(int reviewNum);
	
	//중간테이블 insert Dao
	public void insertReview_Tag();
	public void insertStore_Tag(int storeNum);
	
}

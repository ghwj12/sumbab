package store.review;

import java.util.List;

public interface ReviewDao {

	public void insert(Review review);
	public void update(int reviewNum);
	public void delete(int reviewNum);
	
	public int getReviewCount(int storeNum);
	public float getAvgStar(int storeNum);
	public List<Review> getReviewList(int storeNum);
	
}

package store.review.tag;

public class Tag {

	private int tagId;
	private String tagName;
	private int count;
	
	public Tag() {}

	public Tag(int tagId, String tagName, int count) {
		super();
		this.tagId = tagId;
		this.tagName = tagName;
		this.count = count;
	}

	public int getTagId() {
		return tagId;
	}

	public void setTagId(int tagId) {
		this.tagId = tagId;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
}

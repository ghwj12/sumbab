package store.review;

import java.sql.Date;

public class Review {

	private int reviewNum;
	private int storeNum;
	private String id;
	private String menu;
	private float star;
	private boolean revisit;
	private Date regDate;
	private String picture;
	
	public Review() {}

	public Review(String menu, float star, boolean revisit, Date regDate, String picture) {
		super();
		this.menu = menu;
		this.star = star;
		this.revisit = revisit;
		this.regDate = regDate;
		this.picture = picture;
	}

	public int getReviewNum() {
		return reviewNum;
	}

	public void setReviewNum(int reviewNum) {
		this.reviewNum = reviewNum;
	}

	public int getStoreNum() {
		return storeNum;
	}

	public void setStoreNum(int storeNum) {
		this.storeNum = storeNum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public float getStar() {
		return star;
	}

	public void setStar(float star) {
		this.star = star;
	}

	public boolean isRevisit() {
		return revisit;
	}

	public void setRevisit(boolean revisit) {
		this.revisit = revisit;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	
}

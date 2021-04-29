package my.reserve;

public class Reserve {

	private int reserveSeq;
	private int storeNum;
	private String id;
	private String reserveName;
	private String resDate;
	private String phone;
	
	public Reserve() {}
	
	public Reserve(String reserveName, String resDate, String phone) {
		super();
		this.reserveName = reserveName;
		this.resDate = resDate;
		this.phone = phone;
	}

	
	public int getReserveSeq() {
		return reserveSeq;
	}

	public void setReserveSeq(int reserveSeq) {
		this.reserveSeq = reserveSeq;
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

	public String getReserveName() {
		return reserveName;
	}

	public void setReserveName(String reserveName) {
		this.reserveName = reserveName;
	}

	public String getResDate() {
		return resDate;
	}

	public void setResDate(String resDate) {
		this.resDate = resDate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}

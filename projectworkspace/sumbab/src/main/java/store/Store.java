package store;

public class Store {

	private int storeNum;
	private String id;
	private String classify;
	private String name;
	private String address;
	private String phone;
	private String menu;
	private String time;
	private char reserving;
	private String etc;
	private String pwd;
	private int count;
	private String picture;

	public Store() {}

	public Store(int storeNum, String id, String classify, String name, String address, String phone,
			String menu, String time, char reserving, String etc, String pwd, int count, String picture) {
		super();
		this.storeNum = storeNum;
		this.id = id;
		this.classify = classify;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.menu = menu;
		this.time = time;
		this.reserving = reserving;
		this.etc = etc;
		this.pwd = pwd;
		this.count = count;
		this.picture = picture;
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

	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public char getReserving() {
		return reserving;
	}

	public void setReserving(char reserving) {
		this.reserving = reserving;
	}

	public String getEtc() {
		return etc;
	}

	public void setEtc(String etc) {
		this.etc = etc;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

}

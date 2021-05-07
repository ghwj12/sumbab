package com.sumbab.project.model.store;


//storeView와 공유
public class Store {

	private int storeNum;
	private String id;
	private String classify;
	private String name;
	private String phone;
	private String citycode;
	private String districtcode;
	private String address;
	private String menu;
	private String time;
	private boolean reserving;
	private String etc;
	private String pwd;
	private int count;
	private String picture;

	public Store() {}

	public Store(String classify, String name, String citycode, String districtcode, String address, String phone, String menu, String time,
			boolean reserving, String etc, String pwd, String picture) {
		super();
		this.classify = classify;
		this.name = name;
		this.citycode = citycode;
		this.districtcode = districtcode;
		this.address = address;
		this.phone = phone;
		this.menu = menu;
		this.time = time;
		this.reserving = reserving;
		this.etc = etc;
		this.pwd = pwd;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getcitycode() {
		return citycode;
	}

	public void setcitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getDistrictcode() {
		return districtcode;
	}

	public void setDistrictcode(String districtcode) {
		this.districtcode = districtcode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public boolean isReserving() {
		return reserving;
	}

	public void setReserving(boolean reserving) {
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

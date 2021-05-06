package com.sumbab.project.stroreview;

public class StoreVo {
	private int store_num;
	private String id;
	private String classify;
	private String name;
	private String address;
	private String citycode;
	private String districtcode;
	private String phone;
	private String menu;
	private String time;
	private int reserving;
	private String etc;
	private int count;
	private String picture;

	
	public StoreVo() {}
	
	public StoreVo(int store_num, String name) {
		super();
		this.store_num = store_num;
		this.name = name;
	}


	public StoreVo(int store_num, String id, String classify, String name, String address, String citycode,
			String districtcode, String phone, String menu, String time, int reserving, String etc, int count,
			String picture) {
		super();
		this.store_num = store_num;
		this.id = id;
		this.classify = classify;
		this.name = name;
		this.address = address;
		this.citycode = citycode;
		this.districtcode = districtcode;
		this.phone = phone;
		this.menu = menu;
		this.time = time;
		this.reserving = reserving;
		this.etc = etc;
		this.count = count;
		this.picture = picture;
	}

	public int getStore_num() {
		return store_num;
	}

	public void setStore_num(int store_num) {
		this.store_num = store_num;
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

	
	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getDistrictcode() {
		return districtcode;
	}

	public void setDistrictcode(String districtcode) {
		this.districtcode = districtcode;
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

	public int getReserving() {
		return reserving;
	}

	public void setReserving(int reserving) {
		this.reserving = reserving;
	}

	public String getEtc() {
		return etc;
	}

	public void setEtc(String etc) {
		this.etc = etc;
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

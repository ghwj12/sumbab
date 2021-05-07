package com.sumbab.project.model;

import org.apache.ibatis.type.Alias;

@Alias("storeVo")
public class StoreVo {

	private int storeNum;
	private String classify;
	private String name;
	private String citycode;
	private String districtcode;
	private String address;
	private String menu;
	private String time;
	private String phone;
	private int reserving;
	private String etc;
	private int count;
	private String picture;

	public StoreVo() {}

	public StoreVo(String classify, String name, String citycode, String districtcode, String address, String phone, String menu, String time,
			int reserving, String etc, String picture) {
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
		this.picture = picture;
	}

	public int getStoreNum() {
		return storeNum;
	}

	public void setStoreNum(int storeNum) {
		this.storeNum = storeNum;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

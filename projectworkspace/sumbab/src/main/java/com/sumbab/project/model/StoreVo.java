package com.sumbab.project.model;

import org.apache.ibatis.type.Alias;

@Alias("storeVo")
public class StoreVo {

	private int storeNum;
	private String name;
<<<<<<< HEAD:projectworkspace/sumbab/src/main/java/com/sumbab/project/model/StoreVo.java
	private String citycode;
	private String districtcode;
=======
	private String cityCode;
	private String districtCode;
>>>>>>> STORE:projectworkspace/sumbab/src/main/java/store/Store.java
	private String address;
	private String menu;
	private String time;
<<<<<<< HEAD:projectworkspace/sumbab/src/main/java/com/sumbab/project/model/StoreVo.java
	private String picture;
	private String phone;
=======
	private boolean reserving;
>>>>>>> STORE:projectworkspace/sumbab/src/main/java/store/Store.java
	private String etc;
	private int reserving;
	private int count;
<<<<<<< HEAD:projectworkspace/sumbab/src/main/java/com/sumbab/project/model/StoreVo.java
	
=======
	private String picture;

	public Store() {}


	public Store(String classify, String name, String cityCode, String districtCode, String address, String phone, String menu, String time,
			boolean reserving, String etc, String pwd, String picture) {
		super();
		this.classify = classify;
		this.name = name;
		this.cityCode = cityCode;
		this.districtCode = districtCode;
		this.address = address;
		this.phone = phone;
		this.menu = menu;
		this.time = time;
		this.reserving = reserving;
		this.etc = etc;
		this.pwd = pwd;
		this.picture = picture;
	}


>>>>>>> STORE:projectworkspace/sumbab/src/main/java/store/Store.java
	public int getStoreNum() {
		return storeNum;
	}
	public void setStoreNum(int storeNum) {
		this.storeNum = storeNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
<<<<<<< HEAD:projectworkspace/sumbab/src/main/java/com/sumbab/project/model/StoreVo.java
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
=======

	public String getCityCode() {
		return cityCode;
	}


	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}


	public String getDistrictCode() {
		return districtCode;
	}


	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}


>>>>>>> STORE:projectworkspace/sumbab/src/main/java/store/Store.java
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
<<<<<<< HEAD:projectworkspace/sumbab/src/main/java/com/sumbab/project/model/StoreVo.java
=======

	public boolean getReserving() {
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

>>>>>>> STORE:projectworkspace/sumbab/src/main/java/store/Store.java
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEtc() {
		return etc;
	}
	public void setEtc(String etc) {
		this.etc = etc;
	}
	public int getReserving() {
		return reserving;
	}
	public void setReserving(int reserving) {
		this.reserving = reserving;
	}
	
	
}

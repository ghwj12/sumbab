package com.sumbab.project.pick;

import org.apache.ibatis.type.Alias;

@Alias("pick")
public class PickVo {

	private String id;
	private int storeNum;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getStoreNum() {
		return storeNum;
	}
	public void setStoreNum(int storeNum) {
		this.storeNum = storeNum;
	}
	
}
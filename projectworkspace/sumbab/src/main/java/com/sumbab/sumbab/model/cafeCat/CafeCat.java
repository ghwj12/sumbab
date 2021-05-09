package com.sumbab.sumbab.model.cafeCat;

import org.apache.ibatis.type.Alias;

@Alias("cafeCat")
public class CafeCat {
	
	private int storeNum;
	private boolean situation1;
	private boolean situation2;
	private boolean situation3;
	private boolean timeslot;
	private boolean mood1;
	private boolean mood2;
	private boolean mood3;
	private boolean size1;
	private boolean size2;
	private boolean size3;
	
	private String name;//join용
	
	public CafeCat() {super();}

	public CafeCat(boolean situation1, boolean situation2, boolean situation3, boolean timeslot, boolean mood1,
			boolean mood2, boolean mood3, boolean size1, boolean size2, boolean size3) {
		super();
		this.situation1 = situation1;
		this.situation2 = situation2;
		this.situation3 = situation3;
		this.timeslot = timeslot;
		this.mood1 = mood1;
		this.mood2 = mood2;
		this.mood3 = mood3;
		this.size1 = size1;
		this.size2 = size2;
		this.size3 = size3;
	}

	public int getStoreNum() {
		return storeNum;
	}

	public void setStoreNum(int storeNum) {
		this.storeNum = storeNum;
	}

	public boolean isSituation1() {
		return situation1;
	}

	public void setSituation1(boolean situation1) {
		this.situation1 = situation1;
	}

	public boolean isSituation2() {
		return situation2;
	}

	public void setSituation2(boolean situation2) {
		this.situation2 = situation2;
	}

	public boolean isSituation3() {
		return situation3;
	}

	public void setSituation3(boolean situation3) {
		this.situation3 = situation3;
	}

	public boolean isTimeslot() {
		return timeslot;
	}

	public void setTimeslot(boolean timeslot) {
		this.timeslot = timeslot;
	}

	public boolean isMood1() {
		return mood1;
	}

	public void setMood1(boolean mood1) {
		this.mood1 = mood1;
	}

	public boolean isMood2() {
		return mood2;
	}

	public void setMood2(boolean mood2) {
		this.mood2 = mood2;
	}

	public boolean isMood3() {
		return mood3;
	}

	public void setMood3(boolean mood3) {
		this.mood3 = mood3;
	}

	public boolean isSize1() {
		return size1;
	}

	public void setSize1(boolean size1) {
		this.size1 = size1;
	}

	public boolean isSize2() {
		return size2;
	}

	public void setSize2(boolean size2) {
		this.size2 = size2;
	}

	public boolean isSize3() {
		return size3;
	}

	public void setSize3(boolean size3) {
		this.size3 = size3;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

package com.sumbab.sumbab.model.search;

import java.util.List;

import com.sumbab.sumbab.model.store.Store;

public interface SearchDao {

	public List<Store> selectByKeyword(String input); //일반 검색
	public List<Store> selectByTag(String inputT);  //해시태그 검색
	
}

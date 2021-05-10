package com.sumbab.sumbab.model.editor;

import java.util.List;

import com.sumbab.sumbab.model.store.Store;

public interface EditorDao {
	
	public void createList(Editor editor); //리스트 만들기
	public List<Store> getAllStore(); //모든 가게 내역 불러오기

}

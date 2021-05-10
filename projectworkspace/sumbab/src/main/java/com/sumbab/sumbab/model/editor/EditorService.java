package com.sumbab.sumbab.model.editor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sumbab.sumbab.model.store.Store;

@Service
public class EditorService {
	
	private EditorDaoImpl editorDao;
	
	public EditorService() {}
	
	@Autowired
	public EditorService(EditorDaoImpl editorDao) {
		this.editorDao = editorDao;
	}
	
	public List<Store> getAllStore(){
		return editorDao.getAllStore();
	}
	
	public void createList(Editor editor){
		editorDao.createList(editor);
	}
	
}
